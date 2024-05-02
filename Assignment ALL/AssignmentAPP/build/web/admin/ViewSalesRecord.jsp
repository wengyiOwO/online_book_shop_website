<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.OrderHistory"%>

<%
    List<OrderHistory> salesList = (List) session.getAttribute("salesList");
    Double totalSales = (Double) session.getAttribute("totalSales");
    String title = (String) session.getAttribute("title");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>BBC - Sales Record</title>
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
                <h1>Sales Record</h1>
                <form action="../SearchSalesRecord" method="post">
                    <div class="row pb-3">
                        <div class="col d-grid">
                            <input type="submit" class="btn btn-success btn-lg" name="button" value="Daily"></a>
                        </div>
                        <div class="col d-grid">
                            <input type="submit" class="btn btn-success btn-lg" name="button" value="Monthly"></a>
                        </div>
                        <div class="col d-grid">
                            <input type="submit" class="btn btn-success btn-lg" name="button" value="Yearly">
                        </div>
                    </div>
                </form>
                <h3><%=title%></h3>
                <div class="row">
                    <table style='font-size: 15px;margin:20px;padding:20px; border: 1px dashed green;'>
                        <tr align="center" style='margin:20px;border: 1px dashed green;'>
                            <th style="width:10%">Order Date</th>
                            <th style="width:10%">Book ID</th>
                            <th style="width:20%">Book Name</th>
                            <th style="width:10%">User ID</th>
                            <th style="width:10%">Order Quantity</th>
                            <th style="width:10%">Price</th>
                            <th style="width:10%">Total</th>
                        </tr>
                        <%if (salesList.isEmpty()) {%>
                        <tr align="center" style='border: 1px dashed green;'>
                            <td colspan="7">No record found</td>
                        </tr>
                        <% } else { %>
                        <% for (OrderHistory salesRecord : salesList) {%>
                        <tr align="center" style='border: 1px dashed green;'>
                            <%
                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                String formattedOrderDate = dateFormat.format(salesRecord.getOrderId().getOrderDate());
                            %>
                            <td><%=formattedOrderDate%></td>
                            <td><%=salesRecord.getBookId().getBookId()%> </td>
                            <td><%=salesRecord.getBookId().getBookName()%></td>
                            <td><%=salesRecord.getOrderId().getUserId().getUserId()%></td>
                            <td><%=salesRecord.getQuantity()%></td>
                            <td><%=String.format("%-7.2f", salesRecord.getBookId().getPrice())%></td>
                            <td><%=String.format("%-7.2f", salesRecord.getQuantity() * salesRecord.getBookId().getPrice())%></td>
                        </tr>
                        <% }%>
                        <tr>
                            <td align="right" colspan="6">Total</td>
                            <td align="center"><%=String.format("%-7.2f", totalSales)%></td>
                        </tr>
                        <%}%>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- End Content -->


    <%@ include file="../user/Footer.jsp" %>
</body>

</html>
