package com.dormitory.controller.student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
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

import com.dormitory.dto.student.StudentDTO;
import com.dormitory.entity.Article;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Student;
import com.dormitory.service.ArticleService;
import com.dormitory.service.DormitoryService;
import com.dormitory.service.EmailService;
import com.dormitory.service.FileService;
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
	@Resource
	private FileService fileService;
	private static final String MODEL_DIR = "/models/";
	private static final String IMG_DIR = "/images/";
	private static final String ERROR_PAGE = "error";
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	public StudentController() {

	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute(value = "register") @Valid StudentDTO register, BindingResult result,
			@RequestParam(value = "img") MultipartFile img, HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView("../../jsp/register");// 默认为跳转回注册页面
		if (result.hasErrors()) {
			System.out.println(result.getFieldError().toString());
			return modelAndView;
		}
		if (!register.getPassword2().equals(register.getPassword())) {
			return modelAndView;
		}
		// 检查图片文件
		System.out.println("img:" + img);
		if (img == null || img.isEmpty()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("文件为空：");
			}
			return modelAndView;
		}
		System.out.println("img name:" + img.getOriginalFilename() + " ends with jpg:"
				+ img.getOriginalFilename().endsWith(".jpg"));
		if (!(img.getOriginalFilename().toLowerCase().endsWith(".jpg"))) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("img参数异常：");
			}
			return modelAndView;
		}

		// 检查是否已注册
		Student temp = studentService.get(register.getStudentId());
		if (temp != null) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("已注册");
			}
			modelAndView.addObject("status", "已注册");
			return modelAndView;
		}

		System.out.println("acccept registerDTO:" + register);

		// 保存宿舍信息(如果宿舍不存在，就添加进去，否则不添加)
		Dormitory dormitory = dormitoryService.save(register.getBuildingName(), register.getRoom());

		fileService.saveFile(request, IMG_DIR,img);
		// 保存学生信息
		Student student = register.getStudent();
		student.setDormitoryId(dormitory.getDormitoryId());
		String imgName=fileService.getFilePath(request, IMG_DIR, img);
		System.out.println("--imgName:" + imgName);
		student.setImgPath(imgName);
		
		studentService.saveOrUpdate(student);

		// TODO
		modelAndView.setViewName("redirect:listArticle.do");

		setSessionValue(model, dormitory.getDormitoryId(), student.getStudentId());
		return modelAndView;
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "id") Long studentId,
			@RequestParam(value = "password") String password, Model model) {
		ModelAndView modelAndView = new ModelAndView("../../jsp/login");// login不在WEB-INF/pages下，要访问父级目录
		Student temp = studentService.get(studentId);
		if (temp != null) {
			if (password.trim().equals(temp.getPassword())) {
				modelAndView.setViewName("redirect:listArticle.do");
				Dormitory dormitory = dormitoryService.get(studentId);
				setSessionValue(model, dormitory.getDormitoryId(), studentId);
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "/isStudentIdExisted.do", method = RequestMethod.GET)
	@ResponseBody
	public String isStudentIdExisted(@RequestParam(value = "studentId") Long studentId) {
		Student student = studentService.get(studentId);
		return student != null ? "existed" : "unexisted";
	}

	@RequestMapping(value = "/isPasswordCorrect.do", method = RequestMethod.GET)
	@ResponseBody
	public String isPasswordCorrect(@RequestParam(value = "studentId") String studentId,
			@RequestParam(value = "password") String password) {
		Student student = studentService.get(Long.valueOf(studentId));
		if (student == null) {
			return "incorrect";
		}
		return student.getPassword().equals(password.trim()) ? "correct" : "incorrect";
	}

	@RequestMapping("/updatePassword.do")
	public ModelAndView updatePassword(@RequestParam(value = "studentId") Long studentId, Model model) {
		Student student = studentService.get(studentId);
		ModelAndView modelAndView = new ModelAndView();
		
		if (student == null) {
			modelAndView.setViewName("redirect:/error");
		} else {
			studentService.saveOrUpdate(student);
			modelAndView.setViewName("redirect:listArticle.do");
			model.addAttribute("studentId", studentId);
			Integer dormitoryId = dormitoryService.get(studentId).getDormitoryId();
			model.addAttribute("dormitoryId", dormitoryId);
		}
		return modelAndView;
	}

	@RequestMapping("/forgetPassword.do")
	public Map<String, String> forgetPassword(@RequestParam(value = "request") HttpServletRequest request,
			@RequestParam(value = "studentId") Long studentId) {

		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		Student student = studentService.get(studentId);
		return emailService.sendEmail(student, basePath);
	}

	/**
	 * 找回链接已经发到邮箱了。进入邮箱点开链接 以下为链接检验代码，验证通过 跳转到修改密码界面,否则跳转到失败界面
	 * 
	 * @param sid
	 * @param studentId
	 * @return
	 */
	@RequestMapping(value = "/checkResetLink.do", method = RequestMethod.GET)
	public ModelAndView checkResetLink(String sid, String studentId) {
		ModelAndView model = new ModelAndView("redirect:/error");
		Map<String, String> map = emailService.checkResetLink(sid, Long.valueOf(studentId.trim()));
		if (map.get("status").equals("success")) {
			model.setViewName("updatePassword"); // 返回到修改密码的界面
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
	@RequestMapping(value = { "listArticle.do" }, method = RequestMethod.GET)
	public ModelAndView listArticle(@RequestParam(value = "studentId") Long studentId, Model model) {
		ModelAndView modelAndView = new ModelAndView("dormitory");
		Dormitory dormitory = dormitoryService.get(studentId);
		List<Article> list = articleService.listByDormitoryId(dormitory.getDormitoryId());
		modelAndView.addObject("list", list);

		return modelAndView;
	}

	@RequestMapping(value = "/saveArticle.do", method = RequestMethod.POST)
	public ModelAndView saveArticle(@ModelAttribute(value = "article") @Valid Article article, BindingResult result,
			@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
		if (result.hasErrors()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("参数异常：result.hasErrors." + result);
			}
			return modelAndView;
		}
		System.out.println("file:" + file);
		if (file == null || file.isEmpty()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("文件为空：");
			}
			return modelAndView;
		}
		System.out.println("file name:" + file.getOriginalFilename() + " ends with obj:"
				+ file.getOriginalFilename().endsWith(".obj"));
		if (!(file.getOriginalFilename().toLowerCase().endsWith(".obj")
				|| file.getOriginalFilename().toLowerCase().endsWith(".dae"))) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("file参数异常：");
			}
			return modelAndView;
		}
		//model.addAttribute("imgUrl", dirUrl+modelNameWithTimestamp);
		// 保存上传的模型
		fileService.saveFile(request,MODEL_DIR,file);
		// 保存物品对象
		String filePath=fileService.getFilePath(request, MODEL_DIR, file);
		System.out.println("model path:"+filePath);
		article.setPath(filePath);
		articleService.saveOrUpdate(article);
		modelAndView.setViewName("/student");
		return modelAndView;
	}

	@RequestMapping("/logout.do")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/index.jsp";
	}

	@RequestMapping(value = "/getPersonalInfo.do", method = RequestMethod.GET)
	public ModelAndView getPersonalInfo(@RequestParam(value = "studentId") Long studentId) {
		StudentDTO studentDTO = new StudentDTO();
		Student student = studentService.get(studentId);
		if(student==null){
			return new ModelAndView("../../jsp/login");
		}
		studentDTO.setStudent(student);
		ModelAndView modelAndView = new ModelAndView("student");
		System.out.println("response studentDTO:"+studentDTO);
		modelAndView.addObject("student", studentDTO);
		return modelAndView;
	}

	private void setSessionValue(Model model, Integer dormitoryId, Long studentId) {
		model.addAttribute("studentId", studentId);
		model.addAttribute("dormitoryId", dormitoryId);
	}

	
}
