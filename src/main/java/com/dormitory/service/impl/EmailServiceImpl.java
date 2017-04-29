package com.dormitory.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dormitory.dao.StudentDAO;
import com.dormitory.entity.Student;
import com.dormitory.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	private static final String ALGORITHM = "MD5";
	private static final String EMAIL_ACCOUNT = "m13925094598@163.com";
	private static final String EMAIL_PASSWORD = "wy73112320634";
	private static final String EMAIL_STMP_HOST = "smtp.163.com";
	private static final String SEND_NAME = "虚拟宿舍";
	private static final String SUBJECT = "重置密码";
	//private static final String TITLE = "重置密码";
	private static final String CHARSET="UTF-8";
	private static final String CONTENT_TYPE="text/html;charset=UTF-8";
	private Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Resource
	private StudentDAO studentDAO;
	@Override
	public Map<String, String> sendEmail(Student student, String basePath) {
		Map<String, String> map = new HashMap<String, String>();
		String msg = "";
		if (student.getStudentId() == null) { // 用户名不存在
			msg = "学号不存在,你不会忘记学号了吧?";
			map.put("msg", msg);
			return map;
		}
		try {
			String secretKey = UUID.randomUUID().toString(); // 密钥
			student.setValidateCode(secretKey);
			Timestamp outDate = new Timestamp(System.currentTimeMillis() + 30 * 60 * 1000);// 30分钟后过期
			student.setOutDate(outDate);
			studentDAO.save(student);
			long date = outDate.getTime() / 1000 * 1000; // 忽略毫秒数
			String key = student.getName() + "$" + date + "$" + secretKey;
			String digitalSignature = DigestUtils.md5Hex(key); // 数字签名
			String resetPassHref = basePath + "student/checkResetLink?sid=" + digitalSignature + "&id="
					+ student.getStudentId();
			String emailContent = "请勿回复本邮件.点击下面的链接,重设密码<br/><a href=" + resetPassHref + " target='_BLANK'>点击我重新设置密码</a>"
					+ "<br/>tips:本邮件超过30分钟,链接将会失效，需要重新申请'找回密码'" + key + "\t" + digitalSignature;
			System.out.println("resetPassHref:"+resetPassHref);
			sendMail(student, emailContent);
			msg = "操作成功,已经发送找回密码链接到您邮箱。请在30分钟内重置密码";
			// logInfo(request, studentId, "申请找回密码");
		} catch (Exception e) {
			e.printStackTrace();
			msg = "邮箱不存在？未知错误,联系管理员吧。";
			if (logger.isDebugEnabled()) {
				logger.debug(msg, e);
			}
		}
		map.put("msg", msg);
		return map;

	}
	
	public Map<String,String> checkResetLink(String sid, Long id){
		String msg = "";
		Map<String,String> map=new HashMap<String,String>();
		if (sid.equals("") || id==null) {
			msg = "链接不完整,请重新生成";
			//logInfo(studentId, "找回密码链接失效");
			map.put("msg", msg);
			map.put("status", "error");
			return map;
		}
		Student student=studentDAO.get(id);
		if (student == null) {
			msg = "链接错误,无法找到匹配用户,请重新申请找回密码.";
			//logInfo(userName, "找回密码链接失效");
			map.put("msg", msg);
			map.put("status", "error");
			return map;
		}
		Timestamp outDate = student.getOutDate();
		if (outDate.getTime() <= System.currentTimeMillis()) { // 表示已经过期
			msg = "链接已经过期,请重新申请找回密码.";
			//logInfo(userName, "找回密码链接失效");
			map.put("msg", msg);
			map.put("status", "error");
			return map;
		}
		String key = student.getStudentId() + "$" + outDate.getTime() / 1000 * 1000 + "$" + student.getValidateCode(); // 数字签名
		String digitalSignature = DigestUtils.md5Hex(key);
		System.out.println(key + "\t" + digitalSignature);
		if (!digitalSignature.equals(sid)) {
			msg = "链接不正确,是否已经过期了?重新申请吧";
			//logInfo(userName, "找回密码链接失效");
			map.put("msg", msg);
			map.put("status", "error");
			return map;
		}
		map.put("status", "success");
		return map;
	}
	

	private void sendMail(Student student,  String content) {
		Properties props = new Properties(); // 参数配置
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", EMAIL_STMP_HOST); // 发件人的邮箱的 SMTP
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		MimeMessage message=null;
		try {
			message = createMimeMessage(session, student, content,  student.getEmail());
			Transport transport = session.getTransport();
			transport.connect(EMAIL_ACCOUNT, EMAIL_PASSWORD);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.debug("exception when sendMessage", e);
			}
			e.printStackTrace();
		}
	}

	private MimeMessage createMimeMessage(Session session, Student student,String content,
			String receiveMail) throws Exception {
		// 1. 创建一封邮件
		MimeMessage message = new MimeMessage(session);
		// 2. From: 发件人
		message.setFrom(new InternetAddress(EMAIL_ACCOUNT, SEND_NAME, CHARSET));
		// 3. To: 收件人（可以增加多个收件人、抄送、密送）
		message.setRecipient(MimeMessage.RecipientType.TO,
				new InternetAddress(receiveMail, student.getName(), CHARSET));
		// 4. Subject: 邮件主题
		message.setSubject(SUBJECT, CHARSET);
		// 5. Content: 邮件正文（可以使用html标签）
		message.setContent(content, CONTENT_TYPE);
		// 6. 设置发件时间
		message.setSentDate(new Date());
		// 7. 保存设置
		message.saveChanges();
		return message;
	}
}
