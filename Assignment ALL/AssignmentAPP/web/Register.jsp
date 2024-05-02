<%-- 
    Document   : Register
    Created on : 17 Apr 2023, 10:29:27 am
    Author     : louis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="HeaderNoLogin.jsp" %> 
    <!-- Start Contact -->
    <div class="container py-5">
        <div class="row py-5">
            <form class="col-md-9 m-auto"  method="post" action="Register">
                <span class="text-danger">
                    <%
                        if (session.getAttribute("error") != null && session.getAttribute("error") != "") {%>
                    <% out.print(session.getAttribute("error")); %>
                    <%}%>
                    <%
                        if (session.getAttribute("locate") != null && session.getAttribute("locate") != "") {%>
                    <% out.print(session.getAttribute("locate")); %>
                    <%}%>
                </span>
                <h3>Register</h3>

                <div class="mb-3">
                    <label for="inputemail">Name</label>
                    <input type="text" class="form-control mt-1" id="name" name="name" placeholder="Name">
                </div>
                <span class="text-danger">
                    <%
                        if (session.getAttribute("nameError") != null && session.getAttribute("nameError") != "") {%>
                    <% out.print(session.getAttribute("nameError")); %>
                    <%}%>
                </span>

                <div class="mb-3">
                    <label for="inputpassword">Email</label>
                    <input type="email" class="form-control mt-1" id="email" name="email" placeholder="example@gmail.com">
                </div>
                <span class="text-danger">
                    <%
                        if (session.getAttribute("emailError") != null && session.getAttribute("emailError") != "") {%>
                    <% out.print(session.getAttribute("emailError")); %>
                    <%}%>

                </span>


                <div class="mb-3">
                    <label for="inputpassword">Phone Number</label>
                    <input type="text" class="form-control mt-1" id="pNumber" name="pNumber" placeholder="011-1111111">
                </div>
                <span class="text-danger">
                    <%
                        if (session.getAttribute("numError") != null && session.getAttribute("numError") != "") {%>
                    <% out.print(session.getAttribute("numError")); %>
                    <%}%>
                </span>

                <div class="mb-3">
                    <label for="inputpassword">Password</label>
                    <input type="password" class="form-control mt-1" id="password" name="password" placeholder="Password">
                </div>
                <span class="text-danger">
                    <%
                        if (session.getAttribute("passwdError") != null && session.getAttribute("passwdError") != "") {%>
                    <% out.print(session.getAttribute("passwdError")); %>
                    <%}%>
                </span>

                <div class="mb-3">
                    <label for="inputpassword">Confirm Password</label>
                    <input type="password" class="form-control mt-1" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password">
                </div>
                <span class="text-danger">
                    <%
                        if (session.getAttribute("conPasswdError") != null && session.getAttribute("conPasswdError") != "") {%>
                    <% out.print(session.getAttribute("conPasswdError")); %>
                    <%}%>
                </span>
                <%session.removeAttribute("nameError");%>
                <%session.removeAttribute("emailError");%>
                <%session.removeAttribute("numError");%>
                <%session.removeAttribute("passwdError");%>
                <%session.removeAttribute("conPasswordError");%>
                <%session.removeAttribute("error");%>



                <div class="row">   
                    <div class="col text-end mt-2">
                        Already have a account?<a href="Login.jsp">Login Now!</a>

                        <button type="submit" class="btn btn-success btn-lg px-3">Register</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- End Contact -->
    <%@include file="FooterNoLogin.jsp" %>
</html>
