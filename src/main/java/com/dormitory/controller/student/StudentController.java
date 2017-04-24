package com.dormitory.controller.student;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.dto.student.StudentRegisterDTO;
import com.dormitory.entity.Article;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Student;
import com.dormitory.service.ArticleService;
import com.dormitory.service.DormitoryService;
import com.dormitory.service.EmailService;
import com.dormitory.service.StudentService;
import com.dormitory.validator.RegisterDTOValidator;

@SessionAttributes({ "studentId", "dormitoryId" })
@Controller
@RequestMapping("/student")
public class StudentController {
	@Resource
	private StudentService studentService;
	@Resource
	private DormitoryService dormitoryService;
	@Resource
	private EmailService emailService;
	@Resource
	private ArticleService articleService;
	private static final String DIR = "/models/";
	private static final String ERROR_PAGE = "error";
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	public StudentController() {

	}

	@InitBinder(value = "/registerController")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new RegisterDTOValidator());// 绑定自定义的校验器
	}

	

	@RequestMapping(value = "/registerController", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute(value = "register") @Valid StudentRegisterDTO register,
			BindingResult result,Model model) {
		ModelAndView modelAndView = new ModelAndView("redirect:/register");
		if (result.hasErrors()) {
			System.out.println(result.getFieldError().toString());
			return modelAndView;
		}
		if (!register.getPassword2().equals(register.getPassword())) {
			return modelAndView;
		}
		modelAndView.setViewName("redirect:/student");

		model.addAttribute("studentId", register.getStudentId());
		model.addAttribute("dormitoryId", register.getDormitoryId());

		System.out.println("acccept registerDTO:" + register);
		// String page = studentService.saveOrUpdate(register);
		return modelAndView;
	}

	@RequestMapping(value = "/loginController", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "id") Long studentId,
			@RequestParam(value = "password") String password,Model model) {
		ModelAndView modelAndView = new ModelAndView("redirect:/login");
		Student temp = studentService.get(studentId);
		if (temp != null) {
			if (password.trim().equals(temp.getPassword())) {
				modelAndView.setViewName("redirect:/student");
				model.addAttribute("studentId", studentId);
				Dormitory dormitory=dormitoryService.get(studentId);
				model.addAttribute("dormitoryId", dormitory.getDormitoryId());
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "/isStudentIdExisted", method = RequestMethod.GET)
	@ResponseBody
	public String isStudentIdExisted(@RequestParam(value = "studentId") String studentId) {
		Student student = studentService.get(Long.valueOf(studentId.trim()));
		return student != null ? "existed" : "unexisted";
	}

	@RequestMapping(value = "/isPasswordCorrect", method = RequestMethod.GET)
	@ResponseBody
	public String isPasswordCorrect(@RequestParam(value = "studentId") String studentId,
			@RequestParam(value = "password") String password) {
		Student student = studentService.get(Long.valueOf(studentId));
		if (student == null) {
			return "incorrect";
		}
		return student.getPassword().equals(password.trim()) ? "correct" : "incorrect";
	}

	@RequestMapping("/updatePassword")
	public ModelAndView updatePassword(@RequestParam(value = "studentId") String studentId,Model model) {
		Long id = Long.valueOf(studentId);
		Student student = studentService.get(id);
		ModelAndView modelAndView = new ModelAndView();
		if (student == null) {
			modelAndView.setViewName("redirect:/error");
		} else {
			studentService.saveOrUpdate(student);
			modelAndView.setViewName("redirect:/student");
			model.addAttribute("studentId", id);
			Integer dormitoryId = dormitoryService.get(id).getDormitoryId();
			model.addAttribute("dormitoryId", dormitoryId);
		}
		return modelAndView;
	}

	@RequestMapping("/forgetPassword")
	public Map<String, String> forgetPassword(@RequestParam(value = "request") HttpServletRequest request,
			@RequestParam(value = "studentId") String studentId) {
		Long id = Long.valueOf(studentId.trim());
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		Student student = studentService.get(id);
		return emailService.sendEmail(student, basePath);
	}

	/**
	 * 找回链接已经发到邮箱了。进入邮箱点开链接 以下为链接检验代码，验证通过 跳转到修改密码界面,否则跳转到失败界面
	 * 
	 * @param sid
	 * @param studentId
	 * @return
	 */
	@RequestMapping(value = "/checkResetLink", method = RequestMethod.GET)
	public ModelAndView checkResetLink(String sid, String studentId) {
		ModelAndView model = new ModelAndView("redirect:/error");
		Map<String, String> map = emailService.checkResetLink(sid, Long.valueOf(studentId.trim()));
		if (map.get("status").equals("success")) {
			model.setViewName("/updatePassword"); // 返回到修改密码的界面
			model.addObject("studentId", studentId);
			return model;
		} else {
			model.addObject("msg", map.get("msg"));
			return model;
		}
	}

	/**
	 * 查找所在宿舍的物品
	 * 
	 * @param dormitoryId
	 * @return
	 * @author guo.junbao
	 */
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public ModelAndView listArticle(@RequestParam(value = "studentId") Long studentId,Model model) {
		ModelAndView modelAndView = new ModelAndView("dormitory");
		Dormitory dormitory=dormitoryService.get(studentId);
		List<Article> list = articleService.listByDormitoryId(dormitory.getDormitoryId());
		modelAndView.addObject("list", list);
		
		return modelAndView;
	}

	@RequestMapping(value = "/saveArticleController", method = RequestMethod.POST)
	public ModelAndView saveArticle(@ModelAttribute(value = "article") @Valid Article article, BindingResult result,
			@RequestParam(value = "file") MultipartFile file, HttpServletRequest request,
			Model model) {
		ModelAndView modelAndView=new ModelAndView(ERROR_PAGE);
		if (result.hasErrors()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("参数异常：result.hasErrors." + result);
			}
			return modelAndView;
		}
		System.out.println("file:"+file);
		if(file==null||file.isEmpty()){
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("文件为空：");
			}
			return modelAndView;
		}
		System.out.println("file name:"+file.getOriginalFilename()+" ends with obj:"+file.getOriginalFilename().endsWith(".obj"));
		if (!(file.getOriginalFilename().endsWith(".obj") || file.getOriginalFilename().endsWith(".dae"))) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("file参数异常：");
			}
			return modelAndView;
		}
		String path = request.getSession().getServletContext().getRealPath("/");
		String filePath = request.getContextPath() + DIR + file.getOriginalFilename();
		model.addAttribute("path", filePath);
		articleService.saveArticle(article, file, filePath);
		modelAndView.setViewName("redirect:/student");
		return modelAndView;
	}
	
	@RequestMapping("/logout")
	public String logout(SessionStatus status){
	  status.setComplete();
	  return "redirect:/index.jsp";
	}
}
