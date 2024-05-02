<%@page import="java.util.Base64"%>
<%@page import="java.util.List"%>
<%@page  import="model.*" %>
<%
    //List<Object[]> results = (List) session.getAttribute("results");
    Shipping shipping = (Shipping) session.getAttribute("shipping");
    //String shippingId = (String) session.getAttribute("shippingId");
    //String orderID = (String) session.getAttribute("orderId");
    List<OrderHistory> orderDetailList = (List) session.getAttribute("orderDetailList");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>BBC - Order Details</title>
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
                <h1>Order Details(<%=shipping.getOrderId().getOrderId()%>)</h1> 
                <div class="row">
                    <form action="../UpdateStatus" method="post">
                        <input type="hidden" name="shippingId" value="<%=shipping.getShippingId()%>">
                        <table style='font-size: 15px;margin:20px;padding:20px; border: 1px dashed green;'>
                            <tr align="center" style='margin:20px;border: 1px dashed green;'>
                                <th style="width:5%">Book ID</th>
                                <th style="width:40%" colspan="2">Book Name</th>
                                <th style="width:20%">Quantity</th>
                                <th style="width:20%">Price</th>
                            </tr>
                            <% for (OrderHistory orderHistory : orderDetailList) {%>
                            <tr align="center" style='border: 1px dashed green;'>
                                <td><%=orderHistory.getBookId().getBookId()%></td>
                                <%String base64img = Base64.getEncoder().encodeToString(orderHistory.getBookId().getBookImage());%>
                                <td><img src="data:image/png;base64,<%=base64img%>" style="weight:50px; height:60px;"></td>
                                <td><%=orderHistory.getBookId().getBookName()%></td>
                                <td><%=orderHistory.getQuantity()%></td>
                                <td><%=orderHistory.getBookId().getPrice()%></td>
                            </tr>
                            <%}%>
                            <tr style='border: 1px dashed green;'>
                                <td>Receiver: </td>
                                <td colspan="2"><%=shipping.getOrderId().getUserId().getUserName()%></td>
                            </tr>
                            <tr style='border: 1px dashed green;'>
                                <td>Address: </td>
                                <td colspan="2"><%=shipping.getAddress()%></td>
                            </tr>
                            <tr style='border: 1px dashed green;'>
                                <td>Status: </td>
                                <td colspan="2"><%=shipping.getStatus()%></td>
                            </tr>
                        </table>
                        <div>
                            <p></p>
                            <div>
                                <div class="row pb-3">
                                    <div class="col d-grid">
                                        <input type="submit" class="btn btn-success btn-lg" name="button" value="Packaging"></a>
                                    </div>
                                    <div class="col d-grid">
                                        <input type="submit" class="btn btn-success btn-lg" name="button" value="Shipping"></a>
                                    </div>
                                    <div class="col d-grid">
                                        <input type="submit" class="btn btn-success btn-lg" name="button" value="Delivered">
                                    </div>
                                </div>

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
