<%@page import="java.util.List"%>
<%@page import="model.Users"%>

<%
    List<Users> userList = (List) session.getAttribute("userList");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>BBC - User List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
    <%@ include file="../user/Header.jsp" %>  

    <!-- Start Content -->
    <div class="container py-5">
        <div class="row">
            <%@ include file="../staff/staffControlMenu.jsp" %>

            <div class="col-lg-9">
                <h1>User List</h1>
                <div class="row">
                    <table style='font-size: 15px;margin:20px;padding:20px; border: 1px dashed green;'>
                        <tr align="center" style='margin:20px;border: 1px dashed green;'>
                            <th style="width:5%">ID</th>
                            <th style="width:15%">Name</th>
                            <th style="width:20%">Email</th>
                            <th style="width:10%">Phone Number</th>
                            <th style="width:10%">Action</th>
                        </tr>
                        <% for (Users user: userList) {%>
                        <tr align="center" style='border: 1px dashed green;'>
                            <td><%=user.getUserId()%></td>
                            <td><%=user.getUserName()%> </td>
                            <td><%=user.getUserEmail()%></td>
                            <td><%=user.getPhoneNum()%></td>
                            <td>
                                <form action="../ViewUserDetails" method="post">
                                    <input type="hidden" name="userId" value="<%=user.getUserId()%>">
                                    <input class="btn btn-success btn-lg" type="submit" value="View">
                                </form>
                            </td>
                        </tr>
                        <% }%>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- End Content -->


    <%@ include file="../user/Footer.jsp" %>
</body>

</html>
