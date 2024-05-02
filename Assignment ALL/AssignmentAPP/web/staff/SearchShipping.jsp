<%-- retrieve selected user code --%>
<%
   String shippingId = request.getParameter("shippingId");
%>

<%-- retrieve button that was clicked --%>
<%
  String button = request.getParameter("button");
%>

<%-- redorect to SearchUser servlet --%>
<%
  session.setAttribute("shippingId", shippingId);
  session.setAttribute("button", button);
  response.sendRedirect("../SearchShipping");
%>
