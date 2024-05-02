<%@page import="java.util.Base64"%>
<%@page import="java.util.List"%>
<%@page  import="model.Books" %>
<%
    Books book = (Books) session.getAttribute("book");
    String staffRole = (String) session.getAttribute("role");
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>BBC - Book Detail</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>

    <body>
        <%@ include file="../user/Header.jsp" %>  

        <!-- Open Content -->
        <section class="bg-light">
            <div class="container pb-5">
                <div class="row">
                    <div class="col-lg-5 mt-5">
                        <div class="card mb-3">
                            <%String base64img = Base64.getEncoder().encodeToString(book.getBookImage());%>
                            <img class="card-img img-fluid" src="data:image/png;base64,<%=base64img%>" alt="Card image cap" id="product-detail">
                        </div>
                    </div>
                    <!-- col end -->
                    <div class="col-lg-7 mt-5">
                        <div class="card">
                            <form action="../admin/SearchBook.jsp" method="POST">
                                <div class="card-body">
                                    <h1 class="h2"><b><%=book.getBookName()%></b>(<%=book.getBookId()%>)</h1>
                                    <input type="hidden" name="bookId" value="<%=book.getBookId()%>">
                                    <p class="h3 py-2">RM<%=String.format("%.2f", book.getPrice())%></p>
                                    <h6>Description:</h6>
                                    <p><%=book.getDescription()%></p>
                                    <h6>Author: </h6>
                                    <p><%=book.getAuthor()%></p>
                                    <h6>Category: </h6>
                                    <p><%=book.getCategory()%></p>
                                    <h6>Category: </h6>
                                    <p><%=book.getLanguages()%></p>
                                    <h6>Stock: </h6>
                                    <p><%=book.getStocks()%></p>
                                    <div class="row pb-3">
                                        <div class="col d-grid">
                                            <input type="submit" class="btn btn-success btn-lg" name="button" value="Edit" <%if(staffRole.equals("staff")){%>disabled<%}%>></a>
                                        </div>
                                        <div class="col d-grid">
                                            <input type="submit" class="btn btn-success btn-lg" name="button" value="Delete"<%if(staffRole.equals("staff")){%>disabled<%}%>>
                                        </div>
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
    <%@ include file="../user/Footer.jsp" %>  

</body>

</html>