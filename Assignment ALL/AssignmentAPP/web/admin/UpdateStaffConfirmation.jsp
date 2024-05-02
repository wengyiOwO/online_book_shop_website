<%@page import="model.Staffs"%>

<%
    Staffs staff = (Staffs) session.getAttribute("staff");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>BBC - Update Staff Confirm</title>
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
                    <form action="../UpdateStaff" method="post" onsubmit="return window.confirm('Confirm update <%=staff.getStaffId()%>?')">
                        <div class="card-body">
                            <h6>ID: </h6>
                            <p><input style="width:100%;" type="text" name="staffId" value="<%=staff.getStaffId()%>" readonly></p>
                            <h6>Name: </h6>
                            <p><input style="width:100%;" type="text" name="staffName" value="<%=staff.getStaffName()%>" 
                                      pattern="[a-zA-Z]+" placeholder="Staff Name" required></p>
                            <h6>Email: </h6>
                            <p><input style="width:100%;" type="text" name="staffEmail" value="<%=staff.getCompanyEmail()%>" 
                                      pattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Please enter a valid email format"
                                      placeholder="xxxxx@email.com" required></p>
                            <h6>Phone Number: </h6>
                            <p><input style="width:100%;" type="text" name="staffPhonenumber"value="<%=staff.getPhoneNum()%>" 
                                      pattern="01[0-9]-[0-9]{7,8}" title="please enter 01X-XXXXXXX" placeholder="01X-XXXXXXX" required></p>
                            <div class="row pb-3">
                                <div class="col d-grid">
                                    <input type="submit" class="btn btn-success btn-lg" name="button" value="Update"></a>
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
