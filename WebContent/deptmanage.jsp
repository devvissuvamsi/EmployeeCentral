<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/error"%>
<jsp:include page="header.jsp"></jsp:include>
<%
    session=request.getSession(false);
    if(session.getAttribute("username")==null)
    {
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
%>
<%
	String title = request.getAttribute("title").toString();
	String uri = request.getAttribute("uri").toString();
%>
	<!--  content begin -->
	<div class="container">
		<br />
		<h2><%=title%></h2>
		<br />
		<form action="<%=request.getContextPath()%><%=uri%>" method="post">
			<input type="hidden" class="form-control" name="departmentId" value="<c:out value="${departmentObj.getDepartmentId()}"/>" />
			<div class="form-group">
				<label for="departmentName">Department Name</label> <input type="text"
					class="form-control" name="departmentName" value="<c:out value="${departmentObj.getDepartmentName()}"/>" />
			</div>
			<button type="submit" class="btn btn-primary" name="submit">Submit</button>
		</form>
	</div>
	<!--  content end -->

<jsp:include page="footer.jsp"></jsp:include>