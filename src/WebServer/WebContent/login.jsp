<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<title>Bienvenido</title>
</head>
<body>
	<div>
		<form action="Login" method="post">
			<table border="0" cellpadding="1" align="center">
				<tr>
					<td><label class="Tipografia">Usuario:</label></td>
					<td><input type="text" name="Username" id="Username" /></td>
					<td><label class="Tipografia">Contraseña:</label></td>
					<td><input type="password" name="Password" id="Password" /></td>
					<td><input name="login" type="submit" value="Entrar" /></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>