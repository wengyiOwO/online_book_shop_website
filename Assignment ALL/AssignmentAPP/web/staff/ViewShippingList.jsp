<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.Shipping"%>
<%@page import="model.Orders"%>


<%
    List<Shipping> shippingList = (List) session.getAttribute("shippingList");
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
                <h1>New Order</h1>
                <div class="row">
                    <table style='font-size: 15px;margin:20px;padding:20px; border: 1px dashed green;'>
                        <tr align="center" style='margin:20px;border: 1px dashed green;'>
                            <th style="width:5%">ID</th>
                            <th style="width:10%">Order ID</th>
                            <th style="width:20%">Address</th>
                            <th style="width:10%">Status</th>
                            <th style="width:10%">Action</th>
                        </tr>
                        <% for (Shipping shipping : shippingList) {%>
                        <% if (shipping.getStatus().equals("Processing")) {%>
                        <tr align="center" style='border: 1px dashed green;'>
                            <td><%=shipping.getShippingId()%></td>
                            <td><%=shipping.getOrderId().getOrderId()%></td>
                            <td><%=shipping.getAddress()%></td>
                            <td><%=shipping.getStatus()%></td>
                            <td>
                                <form action="../ViewShippingOrderDetails" method="post">
                                    <input type="hidden" name="shippingId" value="<%=shipping.getShippingId()%>">
                                    <input type="hidden" name="orderId" value="<%=shipping.getOrderId().getOrderId()%>">
                                    <input class="btn btn-success btn-lg" type="submit" value="View">
                                </form>
                            </td>
                        </tr>
                        <% }%>
                        <%}%>
                    </table>
                </div>
                    <h1>Shipping List</h1>
                <div class="row">
                    <table style='font-size: 15px;margin:20px;padding:20px; border: 1px dashed green;'>
                        <tr align="center" style='margin:20px;border: 1px dashed green;'>
                            <th style="width:5%">ID</th>
                            <th style="width:10%">Order ID</th>
                            <th style="width:20%">Address</th>
                            <th style="width:10%">Status</th>
                            <th style="width:10%">Action</th>
                        </tr>
                        <% for (Shipping shipping : shippingList) {%>
                        <% if (!shipping.getStatus().equals("Delivered") && !shipping.getStatus().equals("Processing")) {%>
                        <tr align="center" style='border: 1px dashed green;'>
                            <td><%=shipping.getShippingId()%></td>
                            <td><%=shipping.getOrderId().getOrderId()%></td>
                            <td><%=shipping.getAddress()%></td>
                            <td><%=shipping.getStatus()%></td>
                            <td>
                                <form action="../ViewShippingOrderDetails" method="post">
                                    <input type="hidden" name="shippingId" value="<%=shipping.getShippingId()%>">
                                    <input type="hidden" name="orderId" value="<%=shipping.getOrderId().getOrderId()%>">
                                    <input class="btn btn-success btn-lg" type="submit" value="View">
                                </form>
                            </td>
                        </tr>
                        <% }%>
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
