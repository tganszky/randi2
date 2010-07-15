<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">

<f:view xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ice="http://www.icesoft.com/icefaces/component">
<!--	locale="#{loginHandler.chosenLocale}">-->
	
	<ice:outputDeclaration doctypeRoot="HTML"
		doctypePublic="-//W3C//DTD HTML 4.01 Transitional//EN"
		doctypeSystem="http://www.w3.org/TR/html4/loose.dtd" />
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
	<title><ice:outputText nospan="true" value="RANDI2 #{randi2.version} Installation" /></title>
	<ice:outputStyle href="./xmlhttp/css/rime/rime.css" />
	<ice:outputStyle href="RANDI2.css" />
	</head>
	<body>
	<ice:panelGroup id="userEditPanel">
						<f:subview id="uep">
							<jsp:directive.include file="./inc/panels/userEditPanel.jspx" />
						</f:subview>
					</ice:panelGroup>
	</body>
</f:view>

</html>