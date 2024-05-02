
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Sidebar</title>
        <link rel="apple-touch-icon" href="../assets/img/apple-icon.png">
        <link rel="shortcut icon" type="../image/x-icon" href="assets/img/favicon.ico">

        <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="../assets/css/templatemo.css">
        <link rel="stylesheet" href="../assets/css/custom.css">

        <!-- Load fonts style after rendering the layout styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="../assets/css/fontawesome.min.css">
    </head>
    <body>
        <div class="col-lg-3">
            <h1 class="h2 pb-4">Staff Management</h1>
            <ul>
                <li>Sales
                    <ul>
                        <li><a class="text-decoration-none" href="../staff/AddBook.jsp">Add New Book</a></li>
                        <li><a class="text-decoration-none" href="../ViewBookList">Book List</a></li>
                        <li><a class="text-decoration-none" href="../ViewShippingList">Order Manage</a></li>
                            <%
                                String roleAdmin = (String) session.getAttribute("role");
                                if (roleAdmin.equals("admin")) {
                            %>
                        <li><a class="text-decoration-none" href="../ViewSalesRecordByDay">Sales Record</a></li>
                        <li><a class="text-decoration-none" href="../ViewSalesReport">Sales Report</a></li>
                            <%}%>
                    </ul>
                </li>
                <%
                    if (roleAdmin.equals("admin")) {
                %>
                <li>Staff
                    <ul>
                        <li><a class="text-decoration-none" href="../ViewStaffList">Staff List</a></li>
                        <li><a class="text-decoration-none" href="../admin/AddStaff.jsp">Staff Register</a></li>
                    </ul>
                </li>
                <li>User
                    <ul>
                        <li><a class="text-decoration-none" href="../ViewUserList">User List</a></li>
                    </ul>
                </li>
                <%}%>
            </ul>
        </div>
    </body>
</html>
