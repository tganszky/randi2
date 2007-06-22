<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="de.randi2.model.fachklassen.beans.*"
	import="de.randi2.model.fachklassen.beans.AktivierungBean"
	import="java.util.GregorianCalendar"
	import="java.text.SimpleDateFormat" import="java.util.Locale"%>
<jsp:setProperty name="user" property="*" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Randi2 :: Studie fortsetzen</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<%@include file="include/inc_header.jsp"%>

<div id="content">
<h1>Studie fortsetzen</h1>
<form action="DispatcherServlet" method="post" name="user" id="user"><input
	type="hidden" name="anfrage_id"
	value="<%=DispatcherServlet.anfrage_id.JSP_STUDIE_FORTSETZEN_EINS.name() %>">
<fieldset style="width:60%"><legend><b>Studie</b></legend>
<table>
	<tr>
		<td>Sind Sie sicher, dass Sie die Studie fortsetzen wollen?</td>
	</tr>
	<tr>
		<td><input type="submit" name="entsp_ja" value="Ja" tabindex="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<input type="button" name="entsp_nein" value="Nein" tabindex="2" onclick="location.href='studie_ansehen.jsp'"></td>
	</tr>
</table>

</fieldset>
<br>
</form>
</div>
<div id="show_none"></div>

<%@include file="include/inc_footer.jsp"%>
<div id="show_none"><%@include file="include/inc_menue.jsp"%>
</div>
</body>
</html>
