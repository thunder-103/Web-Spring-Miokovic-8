<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="/WEB-INF/i18n/langGet.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>" />
<title><fmt:message key='createTask.title' /></title>
</head>


<body>
<c:set var="localeCode" value="${pageContext.response.locale}" />

  	<c:choose>
		<c:when test='${not empty param["saveButton"]}'>
			<c:set var="choosePage" value="createTask.html" scope="page" />
			<c:out value='kreiraj'/>
		</c:when>
		<c:otherwise>
			<c:set var="choosePage" value="editTask.html" scope="page" />
			<c:out value='uredi'/>
		</c:otherwise>
	</c:choose>

  		<div id="misoDiv" style="border-width: 0px 0px 0px 0px; border-style: solid; border-color: #600;">
  			
  			<!--  http://www.codingforums.com/dom-and-json-scripting/322227-dynamically-change-background-image-html-tag.html -->
  			<script type="text/javascript"> 
				(function() { 
				    var images = ['./images/jasmin2.jpg', './images/milo.jpg', './images/miso.jpg']; 
				    var body = window.document.body; 
				    var counter = 0; 
				    window.setInterval(function() { 
				        if( counter >= images.length ) { 
				            counter = 0; 
				        }; 
				        var image = "url(" + images[counter] + ")"; 
				        counter++; 
				        misoDiv.style.backgroundImage = image; 
				    }, 2000); 
				})(); 
			</script> 
  		
  		</div>
  		
  	<div id="mainDiv" style="width: 90%; border-width: 0px 0px 0px 0px; border-style: solid; border-color: #600;" align="center">
  	


	<sf:form action="${choosePage}" method="POST" commandName="task">

	<input type="hidden" name="taskId" value="${task.taskId}"/>
	
		<h1><fmt:message key='createTask.headline' /></h1>
			
		<table border="0" style="font-family: Arial; font-size: 20px;">
		<tr>
			<td><fmt:message key='createTask.user' /></td>
			<td>
			<sf:select style="width: 143px" path="user">
				<sf:option value=""/>
				<sf:options items="${userList}" itemValue="userId" itemLabel="displayName"/>
			</sf:select><br/>
			</td>
			<td><sf:errors path="user" style="color: red"/></td>
		</tr>
		<tr>

			<td><fmt:message key='createTask.project' /></td>
			<td>
			<sf:select style="width: 143px" path="project">
				<sf:option value=""/>
				<sf:options items="${projectList}" itemValue="projectId" itemLabel="projectName"/>
			</sf:select>
			</td>
			<td><sf:errors path="project" style="color: red"/></td>
		</tr>

		<tr>
			<td><fmt:message key='createTask.description' /></td>

			<td><sf:textarea path="taskDescription"></sf:textarea></td>
			<td><sf:errors path="taskDescription" style="color: red"/></td>
				
		</tr>
		
		<tr>
			<td><fmt:message key='displayTask.expiryDate' /></td>

			<td><sf:textarea path="expiryDate"></sf:textarea></td>
			<td><sf:errors path="expiryDate" style="color: red"/></td>
				
		</tr>

		
		<tr>
			<td><fmt:message key='createTask.estimatedTime' /></td>
			<td>
			<sf:select style="width: 143px" path="estimatedTime">
				<sf:option value=""/>
				<sf:options items="${hoursList}" />
			</sf:select>
			</td>
			<td><sf:errors path="estimatedTime" style="color: red"/></td>
		</tr>
		<tr>	
					
			<td>
				<input type="submit" value="<fmt:message key='createTask.btnSaveTask' />"/>
			</td>
		
		</table>
		
		<center>

		<div>
			<h1 id="displayTitle"><fmt:message key='displayTask.titleMain' /></h1>
		
			<h2><fmt:message key='displayTask.titleSub' /></h2>

			
			<table id="newTaskTable" border="1">
			
			
			
			<thead>

				<tr>
				
					<th><fmt:message key='displayTask.projectName' /></th>
					<th><fmt:message key='displayTask.maxHours' /></th>
					
				</tr>
				
			</thead>
			
			<tbody>
			
			<c:forEach items="${projectList}" var="taskVar" varStatus="i">
				
				<tr>
				
	
					<td><c:out value='${taskVar.projectName}'/></td>
					
					<td><c:out value="${maxHours[i.index]}" /></td>
		
				</tr>
				
				
				
			</c:forEach>
			
			</tbody>
			
			</table>
			
			</div>
			
			</center>

	</sf:form>
<%-- 	<sf:form action="editTask.html" method="GET" commandName="updateTask"> --%>
<!-- 	<input type="submit" name="editButton"  -->
<%-- 							value="<fmt:message key="displayTask.btnEdit"/>"> --%>
							
<%-- 	</sf:form> --%>
	
</div>
<jsp:include page="/WEB-INF/i18n/langSelect.jsp"/>
</body>
</html>