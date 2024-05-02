<%-- retrieve selected staff code --%>
<%
   String staffId = request.getParameter("staffId");
%>

<%-- retrieve button that was clicked --%>
<%
  String button = request.getParameter("button");
%>

<%-- redorect to SearchStaff servlet --%>
<%
  session.setAttribute("staffId", staffId);
  session.setAttribute("button", button);
  response.sendRedirect("../SearchStaff");
%>
