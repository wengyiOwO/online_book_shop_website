<%@page import="java.util.Base64"%>
<%@page import="model.Books"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        img {
        display: block;
        margin: 0 auto;
        }
    </style>
           <%@include file="HeaderNoLogin.jsp" %>
    <!-- Modal -->
    <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="w-100 pt-1 mb-5 text-right">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="" method="get" class="modal-content modal-body border-0 p-0">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Why u press me, i have no function">
                    <button type="submit" class="input-group-text bg-success text-light">
                        <i class="fa fa-fw fa-search text-white"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>


    <%Books firstBook = (Books) session.getAttribute("firstBook");%>
    <%String base64img = Base64.getEncoder().encodeToString(firstBook.getBookImage());%>
    <div id="template-mo-zay-hero-carousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="data:image/png;base64, <%= base64img%>" alt="">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left align-self-center">
                                <h1 class="h1 text-success"><b>Most Popular</b></h1> </br>
                                <h2 class="h2 text-success"><%= firstBook.getBookName()%> </h2>
                                <h3 class="h3"><%= firstBook.getCategory()%></h3>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Banner Hero -->


    <!-- Start Categories of The Month -->
    <section class="container py-5">
        <div class="row text-center pt-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1">Categories of The Month</h1>
                <p>Top 3 most pick book Categories of the Month!!!</p>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-md-4 p-5 mt-3">
                <a><img src="./assets/img/business.png" class="rounded-circle img-fluid border"></a>
                <h5 class="text-center mt-3 mb-3">Business & Management</h5>
                <p class="text-center"><a class="btn btn-success" href="Login.jsp">View</a></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3">
                <a><img src="./assets/img/fitness.png" class="rounded-circle img-fluid border"></a>
                <h2 class="h5 text-center mt-3 mb-3">Health & Fitness</h2>
                <p class="text-center"><a class="btn btn-success" href="Login.jsp">View</a></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3">
                <a><img src="./assets/img/travel.png" class="rounded-circle img-fluid border"></a>
                <h2 class="h5 text-center mt-3 mb-3">Travel</h2>
                <p class="text-center"><a class="btn btn-success" href="Login.jsp">View</a></p>
            </div>
        </div>
    </section>
    <!-- End Categories of The Month -->


    <!-- Start Featured Product -->
    <section class="bg-light">
        <div class="container py-5">
            <div class="row text-center py-3">
                <div class="col-lg-6 m-auto">
                    <h1 class="h1">Featured Books</h1>
                    <p>
                        Ini Putang Ina 
                    </p>
                </div>
            </div>
            <div class="row">
                <%

                    List<Books> threeBooks = (List) session.getAttribute("threeBooks");
                    for (Books trBooks : threeBooks) {

                        String base64imgs = Base64.getEncoder().encodeToString(trBooks.getBookImage());

                %>
                <div class="col-12 col-md-4 mb-4">
                    <div class="card h-100">
                        <a>
                            <img src="data:image/png;base64, <%= base64imgs%>" class="card-img-top" alt="...">
                        </a>
                        <div class="card-body">
                            <ul class="list-unstyled d-flex justify-content-between">
                                <li class="text-muted text-right">RM<%= String.format("%.2f", trBooks.getPrice())%></li>
                            </ul>
                            <a class="h2 text-decoration-none text-dark" ><%= trBooks.getBookName()%></a>
                            <p class="card-text">
                                <%= trBooks.getCategory()%></br></br>
                                <%= trBooks.getLanguages()%>
                            </p>

                            <p class="text-muted">Stocks Available:<%= trBooks.getStocks()%></p>
                            <a href="Login.jsp" >Details</a>
                        </div>
                    </div>

                </div>
                <%}%>
            </div>
        </div>
    </section>
    <!-- End Featured Product -->
           <%@include file="FooterNoLogin.jsp" %>
</html>