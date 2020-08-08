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
<br />
<div class="container">
	<div class="card">
		<div class="card-header">Quote</div>
		<div class="card-body">
			<blockquote class="blockquote mb-0">
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Integer posuere erat a ante.</p>
				<footer class="blockquote-footer">
					Someone famous in <cite title="Source Title">Source Title</cite>
				</footer>
			</blockquote>
		</div>
	</div>
</div>
<br />

<jsp:include page="footer.jsp"></jsp:include>