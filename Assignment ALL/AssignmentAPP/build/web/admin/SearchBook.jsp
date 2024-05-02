<%-- retrieve selected user code --%>
<%
   String bookId = request.getParameter("bookId");
%>

<%-- retrieve button that was clicked --%>
<%
  String button = request.getParameter("button");
%>

<%-- redorect to SearchUser servlet --%>
<%
  session.setAttribute("bookId", bookId);
  session.setAttribute("button", button);
  response.sendRedirect("../SearchBook");
%>
