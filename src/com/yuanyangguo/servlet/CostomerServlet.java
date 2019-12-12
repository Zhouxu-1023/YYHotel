package com.yuanyangguo.servlet;
  
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yuanyangguo.service.CostomerBiz;
import com.yuanyangguo.service.impl.CostomerBizImpl;
import com.yuanyangguo.util.CodeUtil;
import com.yuanyangguo.util.CostomerDtoUtil;
import com.yuanyangguo.util.MailUtil;
import com.yuanyangguo.util.isCodeReturnUtil;
import com.yuanyangguo.util.isReigsterReturnUtil;
import com.yuanyangguo.vo.Costomer;
import com.yuanyangguo.vo.CostomerDto;


@WebServlet("/CostomerServlet")
public class CostomerServlet extends HttpServlet {
	private CostomerBiz costomerBiz = new CostomerBizImpl();
	private Costomer costomer = null;
	private HashMap<String, String> map = new HashMap<>();
 
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 设置请求响应编码为utf-8
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
  		
		// 获取请求方法名
		String action = req.getParameter("action");
		// 获取用户邮箱
		String inputEmail = req.getParameter("email");
		String email = new String(inputEmail.getBytes("iso-8859-1"), "utf-8");
		

		if ("sendcode".equals(action)) {
 			sendCode(res, email);
   		} else if ("register".equals(action)) {// 注册
			// 注册功能1，发送验证码：
			// 获取用户性别
			String inputSex = req.getParameter("sex");
			String sex = new String(inputSex.getBytes("iso-8859-1"), "utf-8");

			// 获取用户姓氏
			String inputSurname = req.getParameter("surname");
			String surname = new String(inputSurname.getBytes("iso-8859-1"), "utf-8");

			// 获取用户名字
			String inputName = req.getParameter("name");
			String name = new String(inputName.getBytes("iso-8859-1"), "utf-8");
			// 获取用户生日
			String inputBirthday = req.getParameter("birthday");
			String birthday = new String(inputBirthday.getBytes("iso-8859-1"), "utf-8");

			// 获取用户密码
			String inputPassword = req.getParameter("password");
			String password = new String(inputPassword.getBytes("iso-8859-1"), "utf-8");
			// 获取用户地址
			String inputAddress = req.getParameter("address");
			String address = new String(inputAddress.getBytes("iso-8859-1"), "utf-8");

			// 获取用户手机号码
			String inputPhone_number = req.getParameter("phone_number");
			String phone_number = new String(inputPhone_number.getBytes("iso-8859-1"), "utf-8");

			// 获取邮箱验证码
			String inputEmail_code = req.getParameter("email_code");
			String email_code = new String(inputEmail_code.getBytes("iso-8859-1"), "utf-8");
 			register(res, sex, surname, name, birthday, email, password, address, phone_number, email_code);
		} else if ("login".equals(action)) {// 邮件账户和密码登陆
			// 获取用户密码
			String inputPassword = req.getParameter("password");
			String password = new String(inputPassword.getBytes("iso-8859-1"), "utf-8");
			login(res, email, password);
		} else if ("loginBycode".equals(action)) {
			// 获取邮箱验证码
			String inputEmail_code = req.getParameter("email_code");
			String email_code = new String(inputEmail_code.getBytes("iso-8859-1"), "utf-8");
			loginBycode(res, email, email_code);
		}

	}

	private void loginBycode(HttpServletResponse res, String email, String email_code) throws IOException {
		// 用户输入验证码与邮件验证码一致,登陆成功
  		Set<Entry<String, String>> entrySet = map.entrySet();
   		String jsonString = null;
 		for (Entry<String, String> entry : entrySet) {
 			if (entry.getValue().equals(email_code)) {
 				costomer = costomerBiz.getCostomerByEmail(email);
 				if (costomer != null) {
 					CostomerDto costomerDto = CostomerDtoUtil.getLogin(costomer, true);
 					jsonString = JSON.toJSONString(costomerDto);
 					res.getWriter().print(jsonString);
 					break;
 				} else {// 登录失败
 					CostomerDto costomerDto = CostomerDtoUtil.getLogin(null, false);
 					jsonString = JSON.toJSONString(costomerDto);
 					res.getWriter().print(jsonString);
 					break;
 				}

 			} else {
 				CostomerDto costomerDto = CostomerDtoUtil.getLogin(null, false);
 				jsonString = JSON.toJSONString(costomerDto);
 				
 			}
		}
 		res.getWriter().print(jsonString);
		
	}

	private void login(HttpServletResponse res, String email, String password) throws IOException {
		costomer = costomerBiz.getCostomerByEmail_password(email, password);
		if (costomer != null) {// 登录成功
			CostomerDto costomerDto = CostomerDtoUtil.getLogin(costomer, true);
			String jsonString = JSON.toJSONString(costomerDto);
			res.getWriter().print(jsonString);
		} else {// 登录失败
			CostomerDto costomerDto = CostomerDtoUtil.getLogin(null, false);
			String jsonString = JSON.toJSONString(costomerDto);
			res.getWriter().print(jsonString);
		}
	}

	private void register(HttpServletResponse res, String sex, String surname, String name, String birthday,
			String email, String password, String address, String phone_number, String email_code) throws IOException {
		// 用户输入验证码与邮件验证码一致
  		Set<Entry<String, String>> entrySet = map.entrySet();
 		boolean bool = true;
		for (Entry<String, String> entry : entrySet) {
 			if (email.equals(entry.getKey())&&entry.getValue().equals(email_code)) {
				// 根据邮箱查询是否被注册过
				costomer = costomerBiz.getCostomerByEmail(email);
				if (costomer == null) {// 该邮箱未被注册，可以注册
 					// 添加注册数据到数据库
					int result = costomerBiz.add(sex, surname, name, birthday, email, password, address, phone_number);
 					if(result!=1){
						bool = false;
						break;
 					}else{
						bool = true;
						break;
 					}				
 				} else {// 该邮箱已经被注册，不能注册
					bool = false;
					break;
 				}

			} else {
				// 用户输入验证码与邮件验证码不一致，注册失败
				bool = false;
 			}
		}
 		String jsonString = null;
		if(bool){
			jsonString = JSON.toJSONString(new isReigsterReturnUtil(true));
		}else{
			jsonString = JSON.toJSONString(new isReigsterReturnUtil(false));
		}
		res.getWriter().print(jsonString);
 		
  		
	}

	private void sendCode(HttpServletResponse res, String email) throws IOException {
		// 根据工具类获取验证码
		String code = CodeUtil.getCode();
 		// 给用户邮箱发送验证码
		try {
			MailUtil.send_mail(email, code);
			// 邮件发送成功
			map.put(email, code);
			String jsonString = JSON.toJSONString(new isCodeReturnUtil(true));
			res.getWriter().print(jsonString);
 		} catch (MessagingException e) {
			// 邮件发送失败
			String jsonString = JSON.toJSONString(new isCodeReturnUtil(false));
			res.getWriter().print(jsonString);
			e.printStackTrace();
  		}
 	}

}
