<%@page  import="model.Books"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>BBC - Delete Book Confirm</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>

    <body>
        <%@ include file="../user/Header.jsp" %>  
        <div class="container py-5">
            <div class="row">
                <%@ include file="../staff/staffControlMenu.jsp" %>

                <div class="col-lg-7 mt-5">
                    <div class="card">
                        <%
                            boolean success = (Boolean) session.getAttribute("success");
                            if (success)
                                out.println("Book deleted successfully.");
                            else
                                out.println("Error: Unable to delete book.");
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