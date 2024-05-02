<%-- 
    Document   : ProductPage
    Created on : 17 Apr 2023, 10:29:21 am
    Author     : louis
--%>

<%@page import="java.util.Base64"%>
<%@page import="model.Books"%>
<%@page import="java.util.List"%>
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
                    <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Why u press me, i have no function">
                    <button type="submit" class="input-group-text bg-success text-light">
                        <i class="fa fa-fw fa-search text-white"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>




    <!-- Start Featured Product -->
    <section class="bg-light">
        <div class="container py-5">
            <div class="row text-center py-3">
                <div class="col-lg-6 m-auto">
                    <h1 class="h1">Books</h1>
                    <strong>
                        All Books</br>
                    </strong>
                    <form action="SearchBookName" method="get">
                        <input type="text" name="searchTerm" placeholder="Search Books...">
                        <button type="submit">Search</button>
                    </form>
                    <select id="mySelect">
                        <option value="">Category</option>
                        <option value="ProductPage.jsp">All</option>
                        <option value="SortByCategory?category=Business%20%26%20Management">Business & Management</option>
                        <option value="SortByCategory?category=Computer%20%26%20Engineering">Computer & Engineering</option>
                        <option value="SortByCategory?category=Health%20%26%20Fitness">Health & Fitness</option>
                        <option value="SortByCategory?category=Travel">Travel</option>
                    </select>
                </div>
            </div>

            <div class="row">
                <%
                    List<Books> books = (List) session.getAttribute("bookList");
                    for (Books book : books) {

                        String base64img = Base64.getEncoder().encodeToString(book.getBookImage());
                %>

                <div class="col-12 col-md-4 mb-4">
                    <div class="card h-100">
                        <a>
                            <img src="data:image/png;base64, <%= base64img%>" class="card-img-top" alt="...">
                        </a>
                        <div class="card-body">
                            <ul class="list-unstyled d-flex justify-content-between">
                                <li class="text-muted text-right">RM<%= String.format("%.2f", book.getPrice())%></li>
                            </ul>
                            <a class="h2 text-decoration-none text-dark" ><%= book.getBookName()%></a>
                            <p class="card-text">
                                <%= book.getCategory()%></br></br>
                                <%= book.getLanguages()%>
                            </p>

                            <p class="text-muted">Stocks Available:<%= book.getStocks()%></p>
                            <a href="DisplayBookDetails?bookId=<%= book.getBookId()%>" >Details</a>
                        </div>
                    </div>

                </div>
                <%}%>
            </div>

        </div>
    </section>
    <!-- End Featured Product -->
    <%@include file="Footer.jsp" %>
    <script>
        // Get the dropdown list element
        var select = document.getElementById("mySelect");

        // Add event listener to handle selection changes
        select.addEventListener("change", function () {
            // Get the selected value
            var selectedValue = select.value;

            // Redirect to the selected URL
            if (selectedValue) {
                window.location.href = selectedValue;
            }
        });
    </script>
</html>
