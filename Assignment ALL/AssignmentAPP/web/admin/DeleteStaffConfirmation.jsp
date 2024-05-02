<%@page import="model.Staffs"%>

<%
    Staffs staff = (Staffs) session.getAttribute("staff");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>BBC - Delete Staff Confirm</title>
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
                <h1>Staff Details</h1>
                <div class="row">
                    <%
                        if (staff != null) {
                    %>
                    <form action="../DeleteStaff" method="post" onsubmit="return window.confirm('Confirm delete <%=staff.getStaffId()%>?')">
                        <div class="card-body">
                            <h6>ID: </h6>
                            <p><input style="width:100%;" type="text" name="staffId" value="<%=staff.getStaffId()%>" readonly></p>
                            <h6>Name: </h6>
                            <p><input style="width:100%;" type="text" name="staffName" value="<%=staff.getStaffName()%>" readonly></p>
                            <h6>Email: </h6>
                            <p><input style="width:100%;" type="text" name="staffEmail" value="<%=staff.getCompanyEmail()%>" readonly></p>
                            <h6>Phone Number: </h6>
                            <p><input style="width:100%;" type="text" name="staffPhonenumber"value="<%=staff.getPhoneNum()%>" readonly></p>
                            <div class="row pb-3">
                                <div class="col d-grid">
                                    <input type="submit" class="btn btn-success btn-lg" name="button" value="Delete"></a>
                                </div>
                            </div>
                        </div>
                    </form>
                    <%} else {%>
                    <p>Staff <%=staff.getStaffId()%> not found</p>
                    <%}%>
                </div>
            </div>
        </div>
    </div>
    <!-- End Content -->


    <%@ include file="../user/Footer.jsp" %>
</body>

</html>
