<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<jsp:include page="/WEB-INF/i18n/langGet.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css" title="currentStyle">
	@import "css/jquery.dataTables.css";

</style>
<c:set var="localeCode" value="${pageContext.response.locale}" />

<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
<script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>

<c:choose>
  <c:when test="$localecode == 'en' }"> 
    <script src="../themes/administration/js/languages/i18nEN.js" type="text/javascript"> </script>
  </c:when>
   <c:otherwise>
    <script src="../themes/administration/js/languages/i18nHR.js" type="text/javascript"> </script>
  </c:otherwise> 
</c:choose>
<script type="text/javascript">
	$(document).ready(function() {
    	oTable = $('#newTaskTable').dataTable({"language": {
            "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Croatian.json"
        }
    });
    	oTable = $('#obranaTable').dataTable();
    
} );
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>" />
<title><fmt:message key='displayTask.title' /></title>
</head>
<body>
								<jsp:useBean id="now" class="java.util.Date"/>    

								<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="nowDate"/> 
								
								


	<center>

		<div>
			<h1 id="displayTitle"><fmt:message key='displayTask.titleMain' /></h1>
		
			<h2><fmt:message key='displayTask.titleSub' /></h2>

			
			<table id="newTaskTable" border="1">
			
			
			
			<thead>

				<tr>
				
					<th><fmt:message key='displayTask.name' /></th>
					<th><fmt:message key='displayTask.lastName' /></th>
					<th><fmt:message key='displayTask.userName' /></th>
					<th><fmt:message key='displayTask.projectName' /></th>
					<th><fmt:message key='displayTask.projectCompany' /></th>
					<th><fmt:message key='displayTask.description' /></th>
					<th><fmt:message key='displayTask.estimatedTime' /></th>
					<th><fmt:message key='displayTask.expiryDate' /></th>
					
				</tr>
				
			</thead>
			
			<tbody>
			<c:set var="count" value="0" scope="page" />
			<c:forEach items="${tasksList}" var="taskVar">
				<fmt:formatDate value="${taskVar.expiryDate}" pattern="yyyy-MM-dd" var="expiryDate"/>
				<tr>
				
					<td><c:out value="${count + 1}." /></td>
					
					<c:set var="count" value="${count + 1}" scope="page"/>
					
					<td><c:out value='${taskVar.user.userFirstName}'/></td>
					
					<td><c:out value="${taskVar.user.userLastName}" /></td>
					
					<td><c:out value="${taskVar.user.userName}" /></td>
					
					<td><c:out value="${taskVar.project.projectName}" /></td>
					
					<td><c:out value="${taskVar.project.projectCompany}" /></td>
					
					<td><c:out value="${taskVar.taskDescription}" /></td>
					
					<td><c:out value="${taskVar.estimatedTime}" /></td>

					<!--   <td class="urgent" style="color: red"><c:out value="${expiryDate}" /></td> 	-->				
		
		<c:if test = "${nowDate eq expiryDate}">			
		<td style="background-color: red"><c:out value="${expiryDate}" /></td> 
		</c:if> 
<%-- 		<td><c:out value="${nowDate}" /></td>  --%>
					
					
<%-- 					<c:if test = "${nowDate eq expiryDate}">  --%>
    				
<%--     					<td style="color: red"><fmt:formatDate value="${taskVar.expiryDate}" pattern="yyyy-MM-dd" var="expiryDate"/></td> --%>
   						
<%-- 					</c:if> 		 --%>
					
					
				<!--  	<td><c:out value="${taskVar.expiryDate}" /></td>  -->
					
					<sec:authorize access="hasAnyRole('Administrator')">
					
					<td>
					<sf:form action="editTask.html" method="GET" commandName="task">
<!-- 					http://stackoverflow.com/questions/17524584/how-to-send-back-the-model-data-from-jsp-to-controller -->
							<input type="hidden" name="taskId" value="${taskVar.taskId}"> 
							<input type="submit" name="editButton" 
							value="<fmt:message key="displayTask.btnEdit"/>">
							
					</sf:form>
					</td>
					</sec:authorize>
					
					
					
				</tr>
				
				
				
			</c:forEach>
			
			</tbody>
			
			</table>
			
			</div>
			
			<form action="<c:url value="/createTask.html"/>" method="GET">
			
				<input type="submit" name="saveButton" value="<fmt:message key='displayTask.btnNewTask' />">
			
			</form>
			
			<form method="POST" action="j_spring_security_logout">
			
				<input type="submit" value="<fmt:message key="displayTask.btnSignOut"/>">
				
			</form>
			
		

	</center>
<jsp:include page="/WEB-INF/i18n/langSelect.jsp"/>
</body>
</html>