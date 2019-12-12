<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  enctype="multipart/form-data"-->
        <form action="AdminServlet?action=amdinAmend" method="post" enctype="multipart/form-data"/>
		账号：<input type="text" name="username" placeholder="请输入账号....." /><br />
		密码：<input type="password" name="password" placeholder="请输入密码....." /><br />
		姓名：<input type="text" name="name" placeholder="请输入账号....." /><br />
		部门：<input type="text" name="department" placeholder="请输入账号....." /><br />
		职位：<input type="text" name="duty" placeholder="请输入账号....." /><br />
		电话：<input type="text" name="phone" placeholder="请输入账号....." /><br />
		微信：<input type="text" name="wechat" placeholder="请输入账号....." /><br />
		入职时间：<input type="text" name="hiredate" placeholder="请输入账号....." /><br />
		邮箱：<input type="text" name="mail" placeholder="请输入账号....." /><br />
		签名：<input type="text" name="signature" placeholder="请输入账号....." /><br />
		<input  type="file" name="url"/>
		<input	type="submit" value="修改" />
	</form>

</body>
</html>