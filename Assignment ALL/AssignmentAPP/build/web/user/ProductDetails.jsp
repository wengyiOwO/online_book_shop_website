<%-- 
    Document   : ProductDetails
    Created on : 17 Apr 2023, 10:27:27 am
    Author     : louis
--%>

<%@page import="java.util.Base64"%>
<%@page import="model.Books"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="Header.jsp" %>
    <!-- Modal -->
    <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="w-100 pt-1 mb-5 text-right">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="" method="get" class="modal-content modal-body border-0 p-0">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                    <button type="submit" class="input-group-text bg-success text-light">
                        <i class="fa fa-fw fa-search text-white"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>

<%Books book = (Books) session.getAttribute("books");%>
<%String base64img = Base64.getEncoder().encodeToString(book.getBookImage());%>

    <!-- Open Content -->
    <section class="bg-light">
        <div class="container pb-5">
            <div class="row">
                <div class="col-lg-5 mt-5">
                    <div class="card mb-3">
                        <img class="card-img img-fluid" src="data:image/png;base64, <%= base64img%>" alt="Card image cap" id="product-detail">
                    </div>
                </div>
                <!-- col end -->
                

                <div class="col-lg-7 mt-5">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="h2"><%= book.getBookName()%></h1>
                            <p class="h3 py-2">RM<%= String.format("%.2f", book.getPrice())%></p>

                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>Author:</h6>
                                </li>
                                <li class="list-inline-item">
                                    <p class="text-muted"><strong><%= book.getAuthor()%></strong></p>
                                </li>
                            </ul>

                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>Language:</h6>
                                </li>
                                <li class="list-inline-item">
                                    <p class="text-muted"><strong><%= book.getLanguages()%></strong></p>
                                </li>
                            </ul>
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>Category:</h6>
                                </li>
                                <li class="list-inline-item">
                                    <p class="text-muted"><strong><%= book.getCategory()%></strong></p>
                                </li>
                            </ul>

                            <h6>Description:</h6>
                            <p><%= book.getDescription()%></p>

                            <form action="AddCart" method="post">
                                <input type="hidden" name="bookId" value="<%= book.getBookId()%>" >
                                <div class="row">

                                    <div class="col-auto">
                                        <ul class="list-inline pb-3">
                                            <li class="list-inline-item text-right">
                                                Stock Available : <%= book.getStocks()%>
                                                <input type="hidden" name="stock" id="product-quanity" value="<%= book.getStocks()%>">
                                                </br>
                                                <label for="pin">Quantity:</label>
                                                <input type="number" id="quantity" maxlength="2" size="1" name="quantity" required>
                                            </li>

                                        </ul>
                                    </div>
                                </div>
                                <span class="text-danger">
                                    <% String dupeItem = (String) session.getAttribute("errorMessage");%>
                                    <%if (dupeItem != null) {%>
                                    <%= dupeItem%>
                                    <%session.removeAttribute("errorMessage");
                                        }%>

                                </span>
                                <div class="row pb-3">
                                    <div class="col d-grid">
                                        <button type="submit" class="btn btn-success btn-lg" name="submit">Add To Cart</button>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Close Content -->
    <%@include file="Footer.jsp" %>

</html>
