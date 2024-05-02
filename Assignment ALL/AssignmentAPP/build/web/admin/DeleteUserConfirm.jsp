<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>BBC - Delete User</title>
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
                <div class="row">
                    <div class="card" style="background-color: greenyellow;">
                        <%
                            boolean success = (Boolean) session.getAttribute("success");
                            if (success)
                                out.println("User deleted successfully.");
                            else
                                out.println("Error: Unable to delete user.");
                        %>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Content -->


    <%@ include file="../user/Footer.jsp" %>
</body>

</html>
