<%@page import="java.util.Base64"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.Books"%>

<%
    List<Books> bookList = (List) session.getAttribute("bookList");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>BBC - Book List</title>
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
                <h1>Add Book</h1>
                <div class="row">
                    <form action="../AddBook" method="post" enctype="multipart/form-data">
                        <h6>Book Image: </h6>
                        <p><input style="width:100%;" type="file" name="bookImage" value="" required></p>
                        <h6>Book Name: </h6>
                        <p><input style="width:100%;" type="text" name="bookName" value="" required></p>
                        <h6>Description:</h6>
                        <p><input style="width:100%;" type="text" name="bookDescription" value="" required></p>
                        <h6>Author: </h6>
                        <p><input style="width:100%;" type="text" name="bookAuthor" value="" required></p>
                        <h6>Price: </h6>
                        <p><input style="width:100%;" type="text" name="bookPrice" value="" pattern="[0-9]+(\.[0-9]{1,2})?" title="Please enter format as 0.00" required></p>
                        <h6>Stock: </h6>
                        <p><input style="width:100%;" type="text" name="bookStock" value="" pattern="[0-9]+" title="Please enter number" required></p>
                        <h6>Category: </h6>
                        <p><input style="width:100%;" type="text" name="bookCategory" value="" pattern="[a-zA-Z]+" title="Please enter only letters" required></p>
                        <h6>Language: </h6>
                        <p><input style="width:100%;" type="text" name="bookLanguage" value="" pattern="[a-zA-Z]+" title="Please enter only letters"required></p>

                        <div class="row pb-3">
                            <div class="col d-grid">
                                <input type="submit" class="btn btn-success btn-lg" name="AddBook" value="Add">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- End Content -->


    <%@ include file="../user/Footer.jsp" %>
</body>

</html>
