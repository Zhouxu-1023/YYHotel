package com.yuanyangguo.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import com.alibaba.fastjson.JSON;
import com.yuanyangguo.dto.AdminDto;
import com.yuanyangguo.service.IAmdinBiz;
import com.yuanyangguo.service.impl.AmdinBizImpl;
import com.yuanyangguo.util.AdminDtoUtil;
import com.yuanyangguo.vo.Admin;

public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IAmdinBiz adminBiz = new AmdinBizImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		String username = request.getParameter("username");
//		username = new String(username.getBytes("iso-8859-1"), "utf-8");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String duty = request.getParameter("duty");
		String phone = request.getParameter("phone");
		String wechat = request.getParameter("wechat");
		String hiredate = request.getParameter("hiredate");
		String mail = request.getParameter("mail");
		String signature = request.getParameter("signature");
		String url = request.getParameter("url");

		if ("login".equals(action)) {// 登录
			dologin(response, username, password);
		} else if ("amdinAmend".equals(action)) {// 修改
			Admin admin = packAdmin(request);
			if (admin != null) {
				adminBiz.update(admin.getUsername(), admin.getPassword(), admin.getName(), admin.getDepartment(),
						admin.getDuty(), admin.getPhone(), admin.getWechat(), admin.getHiredate(), admin.getMail(),
						admin.getSignature(), admin.getUrl());
				response.getWriter().println(JSON.toJSON(admin));
			} else {
				response.getWriter().println(JSON.toJSON(null));
			}

		}
	}

	private void dologin(HttpServletResponse response, String username, String password) throws IOException {
		boolean isLogin = adminBiz.isLogin(username, password);
		if (isLogin) {
			AdminDto adminDto = AdminDtoUtil.getAdminDto(adminBiz.getAdmin(username, password), true);
			response.getWriter().println(JSON.toJSON(adminDto));
		} else {
			AdminDto adminDto = AdminDtoUtil.getAdminDto(null, false);
			response.getWriter().println(JSON.toJSON(adminDto));
		}
	}

	public Admin packAdmin(HttpServletRequest request) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		HashMap<String, String> map = new HashMap<>();
		try {
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					map.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
				} else {
					InputStream in = fileItem.getInputStream();
					String realPath = this.getServletContext().getRealPath("upload");
					System.out.println(realPath);
					File file = new File(realPath);
					if (!file.exists()) {
						file.mkdirs();
					}
					FileOutputStream out = new FileOutputStream(realPath + "/" + fileItem.getName());
					IOUtils.copy(in, out);
					out.close();
					map.put("url", "http://120.55.43.219:8080/YYHotel/upload/" + fileItem.getName());
					System.out.println(map.get("url"));
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Admin admin = new Admin();
		try {
			BeanUtils.populate(admin, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;

	}
}
