
<%
  String button = request.getParameter("button");
%>

<%-- redorect to SearchUser servlet --%>
<%
  session.setAttribute("button", button);
  response.sendRedirect("../SearchSalesRecord");
%>
