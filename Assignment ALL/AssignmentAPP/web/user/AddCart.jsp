<%-- 
    Document   : AddCart
    Created on : 18 Apr 2023, 12:41:27 pm
    Author     : louis
--%>

<%@page import="java.util.Base64"%>
<%@page import="model.Cart"%>
<%@page import="java.util.List"%>
<%double total = 0.0;%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>

        table{
            table-layout: fixed;
            margin:auto;
            margin-bottom:20px;
            width:auto;


        }
        .productimage{
            padding-left:10px;
            padding-right:auto;
            min-width:200px;

        }
        .quantity{
            padding-left: auto;
            padding-right:auto;
            min-width:150px;
        }
        .productname{
            min-width:400px;

        }
        .price{
            padding-left: auto;
            padding-right:auto;
            min-width:100px;

        }
        .products{
            height:100px;
        }

        h1{
            margin-left:12%
        }
    </style>
    <%@include file="Header.jsp" %>
    <body>

        <div class="container py-5">
            <h1>Cart</h1>
            <table style="border: 1px solid  green;">

                <tr>
                    <th class="productimage">Product Image</th>
                    <th class="quantity">Quantity</th>
                    <th class="productname">Product Name</th>
                    <th class="price">Price</th>
                </tr>


                <%
                    
                    List<Cart> carts = (List) session.getAttribute("cartList");
                    for (Cart cart : carts) {

                String base64img = Base64.getEncoder().encodeToString(cart.getBookId().getBookImage());

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
                            <span><%= cart.getQuantity()%></span>
                            <input type="hidden" class="form-control mt-1" id="quantity" name="quantity" value="<%= cart.getQuantity()%>">
                        </div>
                    </td>

                    <td class="bookName">
                        <div class="description">
                            <span><%= cart.getBookId().getBookName()%></span>
                        </div>
                    </td>

                    <td class="price">
                        <div class="total-price"><%out.print(String.format("%.2f",cart.getQuantity() * cart.getBookId().getPrice()));%></div>
                    </td>

                    <td class="remove">
                <li class="list-inline-item"><a class="btn btn-success" id="remove" name="remove" href="DeleteCartItem?cartId=<%= cart.getCartId()%>">remove</a></li>
                </td>
                </tr>
                <!-- end of product 1 -->

                <% total += cart.getQuantity() * cart.getBookId().getPrice();%>

                
                <%}%>
            </table>
            <div class="row">
                <div class="col text-end mt-2">
                    <td class="Total">
                            <span>Total : RM<% out.print(String.format("%.2f",total));%></span>
                    </td>
                    <a type="" class="btn btn-success btn-lg px-3" href="DisplayCheckOutDetails"style=" margin-right:12%">Proceed</a>
                </div>
            </div>
        </div>
    </body>

    <%@include file="Footer.jsp" %>
</html>
