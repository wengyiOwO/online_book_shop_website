<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.Transactions"%>

<%
    List<Transactions> transactionList = (List) session.getAttribute("transactionList");
    Double totalPayment = (Double) session.getAttribute("totalPayment");
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
                <h1>Sales Report</h1>
                <form action="../SearchSalesReport" method="post">
                    <div class="row pb-3">
                        <div class="col d-grid">
                            <input type="submit" class="btn btn-success btn-lg" name="button" value="Top 5 Sales"></a>
                        </div>
                        <div class="col d-grid">
                            <input type="submit" class="btn btn-success btn-lg" name="button" value="Least 5 Sales"></a>
                        </div>
                    </div>
                </form>
                <div class="row">
                    <h3>Total Sales Report</h3>
                    <table style='font-size: 15px;margin:20px;padding:20px; border: 1px dashed green;'>
                        <tr align="center" style='margin:20px;border: 1px dashed green;'>
                            <th style="width:10%">Transaction ID</th>
                            <th style="width:10%">Order Date</th>
                            <th style="width:10%">Order ID</th>
                            <th style="width:10%">User ID</th>
                            <th style="width:10%">Payment Amount</th>
                        </tr>
                        <% for (Transactions transaction : transactionList) {%>
                        <tr align="center" style='border: 1px dashed green;'>
                            <td><%=transaction.getTransactionId()%> </td>
                            <%
                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                String formattedOrderDate = dateFormat.format(transaction.getPaymentId().getOrderId().getOrderDate());
                            %>
                            <td><%=formattedOrderDate%></td>
                            <td><%=transaction.getPaymentId().getOrderId().getOrderId()%> </td>
                            <td><%=transaction.getPaymentId().getOrderId().getUserId().getUserId()%></td>
                            <td><%=String.format("%-6.2f", transaction.getPaymentId().getTotal())%></td>
                        </tr>
                        <% }%>
                        <tr>
                            <td align="right" colspan="4"><b>Total</b></td>
                            <td align="center"><%=String.format("%-6.2f", totalPayment)%></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- End Content -->


    <%@ include file="../user/Footer.jsp" %>
</body>

</html>
