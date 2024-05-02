<%-- 
    Document   : Header
    Created on : 14 Apr 2023, 3:57:58 pm
    Author     : louis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Book Book Chui</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">


        <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="../assets/css/templatemo.css">
        <link rel="stylesheet" href="../assets/css/custom.css">

        <!-- Load fonts style after rendering the layout styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="../assets/css/fontawesome.min.css">

        <!-- Load map styles -->
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A==" crossorigin="" />
    </head>

    <body>
        <!-- Start Top Nav -->
        <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
            <div class="container text-light">
                <div class="w-100 d-flex justify-content-between">
                    <div>
                        <i class="fa fa-envelope mx-2"></i>
                        <a class="navbar-sm-brand text-light text-decoration-none" href="mailto:bookbookchui@bookstore.com">bookbookchui@bookstore.com</a>
                        <i class="fa fa-phone mx-2"></i>
                        <a class="navbar-sm-brand text-light text-decoration-none" href="tel:013-3201802">013-3201802</a>
                    </div>
                    <div>

                        <a class="text-light" href="https://fb.com" target="_blank" rel="sponsored"><i class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
                        <a class="text-light" href="https://www.instagram.com/" target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
                        <a class="text-light" href="https://twitter.com/" target="_blank"><i class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
                    </div>
                </div>
            </div>
        </nav>
        <!-- Close Top Nav -->
    <head>
        <!-- Header -->
    <nav class="navbar navbar-expand-lg navbar-light shadow">
        <div class="container d-flex justify-content-between align-items-center">
            <img class="img-fluid" src=".././assets/img/Logo2.png" width="100" height="100" alt="">
            <a class="navbar-brand text-success logo h1 align-self-center" href="../MainMenu">
                BOOK BOOK CHUI
            </a>

            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                <div class="flex-fill">
                    <ul class="nav navbar-nav d-flex mx-lg-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="../MainMenu">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../DisplayBooks">Catalogue</a>
                        </li>
                        <%
                            String role = (String) session.getAttribute("role");
                            if (role.equals("user")) {
                        %>
                        <li class="nav-item">
                            <a class="nav-link" href="DisplayOrderHistory">Order History</a>
                        </li>
                        <%} else {%>
                        <li class="nav-item">
                            <a class="nav-link" href="../staff/StaffMainPage.jsp">Staff Management</a>
                        </li>
                        <%}%>
                    </ul>
                </div>
                <div class="navbar align-self-center d-flex">
                    <%
                        if (role.equals("user")) {
                    %>
                    <a class="nav-icon position-relative text-decoration-none" href="DisplayCart">
                        <i class="fa fa-fw fa-cart-arrow-down text-dark mr-1"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>
                    </a>
                    <%}%>
                    <a class="nav-icon position-relative text-decoration-none" href="../MainMenuNoLogin.jsp">
                        <i class="fa fa-fw fa-user text-dark mr-3"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">LogOut</span>
                    </a>
                </div>
            </div>

        </div>
    </nav>
    <!-- Close Header -->
</head>
</html>
