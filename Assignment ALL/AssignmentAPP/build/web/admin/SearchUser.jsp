<%-- retrieve selected user code --%>
<%
   String userId = request.getParameter("userId");
%>

<%-- retrieve button that was clicked --%>
<%
  String button = request.getParameter("button");
%>

<%-- redorect to SearchUser servlet --%>
<%
  session.setAttribute("userId", userId);
  session.setAttribute("button", button);
  response.sendRedirect("../SearchUser");
%>
