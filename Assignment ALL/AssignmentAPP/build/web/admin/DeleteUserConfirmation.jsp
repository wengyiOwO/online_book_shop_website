<%@page import="model.Users"%>

<%
    Users user = (Users) session.getAttribute("user");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>BBC - Delete User Confirm</title>
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
                <h1>User Details</h1>
                <div class="row">
                    <%
                        if (user != null) {
                    %>
                    <form action="../DeleteUser" method="post" onsubmit="return window.confirm('Confirm delete <%=user.getUserId()%>?')">
                        <div class="card-body">
                            <h6>ID: </h6>
                            <p><input style="width:100%;" type="text" name="userId" value="<%=user.getUserId()%>" readonly></p>
                            <h6>Name: </h6>
                            <p><input style="width:100%;" type="text" name="userName" value="<%=user.getUserName()%>" readonly></p>
                            <h6>Email: </h6>
                            <p><input style="width:100%;" type="text" name="userEmail" value="<%=user.getUserEmail()%>" readonly></p>
                            <h6>Phone Number: </h6>
                            <p><input style="width:100%;" type="text" name="userPhonenumber"value="<%=user.getPhoneNum()%>" readonly></p>
                            <span class="text-danger">
                                <% String unableDelete = (String) session.getAttribute("errorMessage");%>
                                <%if (unableDelete != null) {%>
                                <%= unableDelete%>
                                <%session.removeAttribute("errorMessage");}%>

                            </span>
                            <div class="row pb-3">
                                <div class="col d-grid">
                                    <input type="submit" class="btn btn-success btn-lg" name="button" value="Delete"></a>
                                </div>
                            </div>
                        </div>
                    </form>
                    <%} else {%>
                    <p>User <%=user.getUserId()%> not found</p>
                    <%}%>
                </div>
            </div>
        </div>
    </div>
    <!-- End Content -->


    <%@ include file="../user/Footer.jsp" %>
</body>

</html>
