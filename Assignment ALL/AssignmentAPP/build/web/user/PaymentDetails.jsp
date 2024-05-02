<%-- 
    Document   : PaymentDetails
    Created on : 18 Apr 2023, 12:41:49 pm
    Author     : louis
--%>

<%@page import="java.util.Base64"%>
<%@page import="model.Users"%>
<%@page import="model.Cart"%>
<%@page import="java.util.List"%>
<%double total = 0.0;%>
<%double delivery = 0.0;%>
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
            margin-left:12%;
        }
        .creditcardtable{
            margin-left:0px;
        }
    </style>
    <%@include file="Header.jsp" %>
    <body>

        <div class="container py-5">
            <h1 >Confirmation</h1>
            <form class="col-md-9 m-auto" method="post" role="form" action="AfterPayment" >
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
                            </div>
                        </td>

                        <td class="productname">
                            <div class="description">
                                <span><%= cart.getBookId().getBookName()%></span>
                            </div>
                        </td>


                        <td class="price">
                            <div class="total-price"><%out.print(String.format("%.2f", cart.getQuantity() * cart.getBookId().getPrice()));%></div>
                        </td>
                    </tr>
                    <!-- end of product 1 -->

                    <% total += cart.getQuantity() * cart.getBookId().getPrice();%>
                    <%}%>
                </table>



                <%Users user = (Users) session.getAttribute("userInfo");%>
                <%String address = (String) session.getAttribute("fullAddress");%>
                <div class="mb-3">
                    <label for="inputemail">Receiver Name</label>
                    <input type="text" class="form-control mt-1" id="Rname" name="Rname" value="<%= user.getUserName()%>" readonly="readonly">
                </div>

                <div class="mb-3">
                    <label for="inputpassword">Email</label>
                    <input type="text" class="form-control mt-1" id="email" name="email" value="<%= user.getUserEmail()%>" readonly="readonly">
                </div>

                <div class="mb-3">
                    <label for="inputpassword">Phone Number</label>
                    <input type="text" class="form-control mt-1" id="Pname" name="Pnumber" value="<%= user.getPhoneNum()%>" readonly>
                </div>

                <div class="mb-3">
                    <label for="inputpassword">Address</label>
                    <br/><input type="text" class="form-control mt-1" id="Pname" name="address" value="<%= address%>" readonly>
                </div>

                <% if (total >= 200) {
                        delivery = 0.0;
                    } else {
                        delivery = 25.00;
                    }%>
                <div class="mb-3">
                    <br/><input type="hidden" class="form-control mt-1" id="total" name="total" value="<%=total + delivery%>" readonly>
                </div>
                <div class="mb-3">
                    <label for="paymentType">Payment Type:</label>
                    <select id="paymentType" name="paymentType">
                        <option value="Card">Card</option>
                        <option value="Cash">Cash</option>
                        <option value="TNG">TNG</option>
                        <option value="GrabPay">GrabPay</option>
                    </select>
                    <div id="card-payment" style="display: none;">
                        <table class="creditcardtable">
                            <tr>
                                <td><label for="card-number">Card Number:</label></td>
                                <td><input type="text" id="card-number" name="card-number" required maxlength="16" pattern="[0-9]{16}"></td>
                            </tr>
                            </br>
                            <tr>
                                <td><label for="card-ccv">Card CCV:</label></td>
                                <td><input type="text" id="card-ccv" name="card-ccv" required maxlength="3" pattern="[0-9]{3}"></td>
                            </tr>
                            </br>
                            <tr>
                                <td><label for="card-expiry">Card Expiry:</label></td>
                                <td><input type="text" id="card-expiry" name="card-expiry" required maxlength="4" pattern="[0-9]{4}"></td>
                            </tr>
                        </table>
                    </div>
                </div> 

                <div class="mb-3">
                    <span>Before Total : RM<% out.print(String.format("%.2f", total));%></span></br>
                    <span>Delivery : <%=delivery%></span></br>
                    <span>After Total : RM<% out.print(String.format("%.2f", total + delivery));%></span>

                </div>

                <div class="row">
                    <div class="col text-end mt-2">

                        <button type="submit" class="btn btn-success btn-lg px-3" style="margin-right:12%;">Confirm</button>
                    </div>

                </div>
            </form>
        </div>
    </body>

    <script>
        const paymentType = document.querySelector('#paymentType');
        const cardPayment = document.querySelector('#card-payment');

        paymentType.addEventListener('change', () => {
            if (paymentType.value === 'Card') {
                cardPayment.style.display = 'block';
                cardPayment.querySelectorAll("input").forEach(function (input) {
                    input.disabled = false;
                });
            } else {
                cardPayment.style.display = 'none';
                cardPayment.querySelectorAll("input").forEach(function (input) {
                    input.disabled = true;
                });
            }
        });
    </script> 

    <%@include file="Footer.jsp" %>
</html>
