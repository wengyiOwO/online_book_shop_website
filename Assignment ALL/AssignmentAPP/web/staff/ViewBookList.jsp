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
                <h1>Book List</h1>
                <div class="row">
                    <table style='font-size: 15px;margin:20px;padding:20px; border: 1px dashed green;'>
                        <tr align="center" style='margin:20px;border: 1px dashed green;'>
                            <th style="width:5%">ID</th>
                            <th colspan='2' style="width:30%">Name</th>
                            <th style="width:10%">Author</th>
                            <th style="width:10%">Stocks</th>
                            <th style="width:10%">Price</th>
                            <th style="width:10%">Category</th>
                            <th style="width:10%">Action</th>
                        </tr>
                        <% for (Books book : bookList) {%>
                        <tr align="center" style='border: 1px dashed green;'>
                            <td><%=book.getBookId()%></td>
                            <%String base64img = Base64.getEncoder().encodeToString(book.getBookImage());%>
                            <td><img src="data:image/png;base64,<%=base64img%>" style="weight:50px; height:60px;"></td>
                            <td><%=book.getBookName()%></td>
                            <td><%=book.getAuthor()%></td>
                            <td><%=book.getStocks()%></td>
                            <td><%=String.format("%.2f", book.getPrice())%></td>
                            <td><%=book.getCategory()%></td>
                            <td>
                                <form action="../ViewBookDetails" method="post">
                                    <input type="hidden" name="bookId" value="<%=book.getBookId()%>">
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
