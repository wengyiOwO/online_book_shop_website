<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="model.Books"%>

<%
    List<Books> bookList = (List) session.getAttribute("bookList");
    List<Map.Entry<String, Integer>> least5 = (List) session.getAttribute("least5");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>BBC - Staff List</title>
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
                <h1>Least 5 Sales Report</h1>
                <div class="row">
                    <table style='font-size: 15px;margin:20px;padding:20px; border: 1px dashed green;'>
                        <tr align="center" style='margin:20px;border: 1px dashed green;'>
                            <th style="width:5%">ID</th>
                            <th style="width:20%">Name</th>
                            <th style="width:10%">Price</th>
                            <th style="width:20%">Stock</th>
                            <th style="width:10%">Total Sales</th>
                        </tr>
                        <% for (Map.Entry<String, Integer> sales : least5) {%>
                        <% for (Books book : bookList) {%>
                        <%if (book.getBookId().equals(sales.getKey())) {%>
                        <tr align="center" style='border: 1px dashed green;'>
                            <td><%=book.getBookId()%></td>
                            <td><%=book.getBookName()%> </td>
                            <td><%=String.format("%-6.2f", book.getPrice())%></td>
                            <td><%=book.getStocks()%></td>
                            <td><%=sales.getValue()%></td>
                        </tr>
                        <% }%>
                        <% }%>
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
