<%-- 
    Document   : Login
    Created on : 14 Apr 2023, 4:01:32 pm
    Author     : louis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">




    <%@include file="HeaderNoLogin.jsp" %>


    <!-- Start Contact -->
    <div class="container py-5">
        <div class="row py-5">
            <form class="col-md-9 m-auto" method="post" action="LoginCon">

                <h3>Login</h3>
                <p></p>
                <p></p>
                <p></p>

                <div class="mb-3">
                    <label for="inputemail">Email</label>
                    <input type="email" class="form-control mt-1" id="email" name="email" placeholder="Email">
                </div>
                <span class="text-danger">
                <%
                        if (session.getAttribute("emailError") != null && session.getAttribute("emailError") != "") {%>
                <% out.print(session.getAttribute("emailError")); %>
                <%}%>
                </span>

                <div class="mb-3">
                    <label for="inputpassword">Password</label>
                    <input type="password" class="form-control mt-1" id="password" name="password" placeholder="Password">
                </div>
                <span class="text-danger">
                <%
                        if (session.getAttribute("passwordError") != null && session.getAttribute("passwordError") != "") {%>
                <% out.print(session.getAttribute("passwordError")); %>
                
                <%session.removeAttribute("passwordError");%>
                <%session.removeAttribute("emailError");%>

                <%}%>

                </span>
                <div class="row">
                    <div class="col text-end mt-2">
                        Don't have a account?<a href="Register.jsp">Register now!</a>
                        <button type="submit" class="btn btn-success btn-lg px-3">Login</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- End Contact -->


    <%@include file="FooterNoLogin.jsp" %>

</body>

</html>