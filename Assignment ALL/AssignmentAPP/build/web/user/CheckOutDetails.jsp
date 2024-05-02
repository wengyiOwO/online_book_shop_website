<%-- 
    Document   : CheckOutDetails
    Created on : 17 Apr 2023, 10:16:27 am
    Author     : louis
--%>

<%@page import="model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="Header.jsp" %>
    <!-- Start Contact -->
    <div class="container py-5">
        <div class="row py-5">
            <form class="col-md-9 m-auto" method="post" role="form" action="ProceedToPayment">
                
                <%Users user = (Users) session.getAttribute("userInfo");%>
                <h2>Check Out</h2>
                <p></p>
                <p></p>
                <h3>Please Fill In Your Details</h3>
                <p></p>

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
                    <input type="text" class="form-control mt-1" id="Pname" name="Pnumber" value="<%= user.getPhoneNum()%>" readonly="readonly">
                </div>

                <div class="mb-3">
                    <label for="inputpassword">Address</label>
                    <input type="text" class="form-control mt-1" id="address1" name="address1" placeholder="Address" required>
                </div>
                <div class="row">
                    <div class="mb-3">
                        <label for="state">Choose a State:</label>
                        <select id="state" name="state">
                            <option value="Perlis">Perlis</option>
                            <option value="Kedah">Kedah</option>
                            <option value="Penang">Penang</option>
                            <option value="Perak">Perak</option>
                            <option value="Selangor">Selangor</option>
                            <option value="Negeri Sembilan">Negeri Sembilan</option>
                            <option value="Malacca">Malacca</option>
                            <option value="Terenganu">Terenganu</option>
                            <option value="Pahang">Pahang</option>
                            <option value="Kuala Lumpur">Kuala Lumpur</option>
                            <option value="Putrajaya">Putrajaya</option>
                        </select>
                        <p></p>
                    </div>
                    <div class="mb-3">
                        <label for="inputpassword">Post Code</label>
                        <input type="text" class="form-control mt-1" id="postcode" name="postCode" placeholder="00000" required>
                    </div>
                </div>  





                <div class="row">   
                    <div class="col text-end mt-2">
                        <button type="submit" class="btn btn-success btn-lg px-3">Proceed</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- End Contact -->

    <%@include file="Footer.jsp" %>
</html>
