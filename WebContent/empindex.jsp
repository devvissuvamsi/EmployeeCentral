<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/error"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.simplilearn.model.hibernate.Employee"%>
<%@page import="java.util.Iterator"%>

<jsp:include page="header.jsp"></jsp:include>
<%
    session=request.getSession(false);
    if(session.getAttribute("username")==null)
    {
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
%>
<%

	String createButtonLabel = request.getAttribute("createButtonLabel").toString();
	String gridTitle = request.getAttribute("gridTitle").toString();
	String uri = "/" + request.getAttribute("title").toString() + ".create";
	String uriDelete = request.getAttribute("title").toString().toLowerCase() + ".delete";
	String uriEdit = request.getAttribute("title").toString().toLowerCase() + ".edit";
	ArrayList<Employee> employeeList = (ArrayList) request.getAttribute("listEmployee"); // Assigning ArrayList object containing Employee data to the local object
%>

<!--  content begin -->
<div class="container">
	<br /> <br />

	<table class="table">
		<tr>
			<th><a href="<%=request.getContextPath()%><%=uri %>"
				class="btn btn-success">${createButtonLabel}</a></th>
		</tr>
	</table>
	<table class="table table-striped table-hover">
		<caption>${gridTitle}</caption>
		<c:choose>
		  <c:when test="${empty listEmployee}">
		    <div class="alert alert-warning" role="alert">No Employees Found!</div>
		  </c:when>
		  <c:otherwise>
			<table class="table table-striped table-hover">
				<caption>${gridTitle}</caption>
				<tbody>
					<%
					// Iterating through subjectList
					if (request.getAttribute("listEmployee") != null)  // Null check for the object
					{
					%>
					<thead class="thead-dark">
						<tr>
							<th>Id</th>
							<th>Full Name</th>
							<th>Phone</th>
							<th>Join Date</th>
							<th>Department</th>
							<th>Actions</th>
						</tr>
					</thead>			
					<%
						Iterator<Employee> iterator = employeeList.iterator();  // Iterator interface
						
						while(iterator.hasNext())  // iterate through all the data until the last record
						{
							Employee empDetails = iterator.next(); //assign individual employee record to the employee class object
						%>
					<tr>
						<td><%=empDetails.getEmployeeId()%></td>
						<td><%=empDetails.getFirstName()%>, <%=empDetails.getLastName()%></td>
						<td><%=empDetails.getPhone()%></td>
						<td><%=empDetails.getJoinDate()%></td>
						<td><%=empDetails.getDepartment().getDepartmentName()%></td>
						<td><a
							href="<%=uriEdit %>?id=<c:out value='<%=empDetails.getEmployeeId()%>'/>"
							class="btn btn-secondary">Edit</a> <a
							href="<%=uriDelete %>?id=<c:out value='<%=empDetails.getEmployeeId()%>'/>"
							class="btn btn-danger">Delete</a></td>
					</tr>
					<%
						}
					}
					%>
				</tbody>
			</table>	    
		  </c:otherwise>
		</c:choose>		

	</table>

</div>
<!--  content end -->
<jsp:include page="footer.jsp"></jsp:include>