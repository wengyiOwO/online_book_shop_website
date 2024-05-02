<%-- 
    Document   : ViewOrderHistory
    Created on : 7 May 2023, 5:12:03 pm
    Author     : louis
--%>

<%@page import="model.Shipping"%>
<%@page import="java.util.Base64"%>
<%@page import="model.OrdersService"%>
<%@page import="model.Orders"%>
<%@page import="model.OrderHistory"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="Header.jsp" %>
    <style>

        table{
            table-layout: auto;
            margin:auto;
            margin-bottom:20px;
            width:1125px;


        }
        .productimage{
            padding-left:10px;
            padding-right:auto;
            min-width:50px;
            max-width:50px;

        }
        .quantity{
            padding-left: auto;
            padding-right:auto;
            width:50x;
        }
        .bookName{
            width:600px;

        }
        .price{
            padding-left: auto;
            padding-right:auto;
            min-width:50px;
            max-width:50px

        }
        .total-price{
            min-width:50px;
            max-width:50px;
        }
        .products{
            height:100px;
        }

        h1{
            margin-left:12%
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container py-5" style="min-height:600px;">
            <h1>Order History</h1>
            <%
                List<Orders> orders = (List<Orders>) session.getAttribute("orders");
                List<List<OrderHistory>> orderHistories = (List<List<OrderHistory>>) session.getAttribute("orderHistories");
                List<Shipping> shipping = (List<Shipping>) session.getAttribute("shippingList");
                for (int i = 0; i < orders.size(); i++) {
            %>
            <h3>Order ID: <%= orders.get(i).getOrderId()%></h3>
            <h4>Shipping Status: <%= shipping.get(i).getStatus()%></h4>
            <%double total = 0.0;%>
            <%double delivery = 0.0;%>
            <table style="border: 1px solid  green;">


                <tr>
                    <th class="productimage">Product Image</th>
                    <th class="quantity">Quantity</th>
                    <th class="productname">Product Name</th>
                    <th class="price">Price</th>
                </tr>

                <%
                    List<OrderHistory> orderHistory = orderHistories.get(i);
                    for (OrderHistory oh : orderHistory) {
                        String base64img = Base64.getEncoder().encodeToString(oh.getBookId().getBookImage());
                %>
                <!-- Product 1 -->
                <tr class="products">
                    <td class="productimage">
                        <div class="image" >
                            <img width="80px" height="50px" src="data:image/png;base64, <%= base64img%>" alt="" />
                        </div>
                    </td>

                    <td class="quantity">

                        <div class="description">
                            <span><%= oh.getQuantity()%></span>
                        </div>
                    </td>

                    <td class="bookName">
                        <div class="bookDescription">
                            <span><%= oh.getBookId().getBookName()%></span>
                        </div>
                    </td>

                    <td class="price">
                        <div class="total-price"><%out.print(String.format("%.2f", oh.getQuantity() * oh.getBookId().getPrice()));%></div>
                    </td>
                    <% total += oh.getQuantity() * oh.getBookId().getPrice();%>
                </tr>
                <!-- end of product 1 -->

                <% if (total >= 200) {
                        delivery = 0.0;
                    } else {
                        delivery = 25.00;
                    }%>


                <%}%>
            </table>
            <div class="col text-end mt-2">
                <span>Before Total : RM<% out.print(String.format("%.2f", total));%></span></br>
                    <span>Delivery : <%=delivery%></span></br>
                    <span>After Total : RM<% out.print(String.format("%.2f", total + delivery));%></span>

            </div>
            <%}%>
        </div>
    </body>
    <%@include file="Footer.jsp" %>
</html>
