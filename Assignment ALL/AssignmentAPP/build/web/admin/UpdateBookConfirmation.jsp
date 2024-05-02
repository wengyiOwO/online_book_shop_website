<%@page import="java.util.Base64"%>
<%@page  import="model.Books" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>BBC - Update Book Confirmation</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>

    <body>
        <%@ include file="../user/Header.jsp" %>  


        <!-- Open Content -->
        <section class="bg-light">
            <div class="container pb-5">
                <%
                    Books book = (Books) session.getAttribute("book");
                    if (book != null) {
                %>
                <div class="row">
                    <div class="col-lg-5 mt-5">
                        <form action="../UpdateBook" method="post" enctype="multipart/form-data" onsubmit="return window.confirm('Confirm update <%=book.getBookId()%>?')">
                            <div class="card mb-3">
                                <input type="file" name="bookImage" value="<%=book.getBookImage()%>">
                                <%String base64img = Base64.getEncoder().encodeToString(book.getBookImage());%>
                                <img class="card-img img-fluid" src="data:image/png;base64,<%=base64img%>" alt="Book Image" id="bookImg">
                            </div>
                    </div>
                    <div class="col-lg-7 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h6>Book ID: </h6>
                                <p><input style="width:100%;" type="text" name="bookId" value="<%=book.getBookId()%>"  readonly></p>
                                <h6>Book Name: </h6>
                                <p><input style="width:100%;" type="text" name="bookName" value="<%=book.getBookName()%>" required></p>
                                <h6>Description:</h6>
                                <p><input style="width:100%;" type="text" name="bookDescription" value="<%=book.getDescription()%>" required></p>
                                <h6>Author: </h6>
                                <p><input style="width:100%;" type="text" name="bookAuthor" value="<%=book.getAuthor()%>" required></p>
                                <h6>Price: </h6>
                                <p><input style="width:100%;" type="text" name="bookPrice" value="<%=String.format("%.2f", book.getPrice())%>" 
                                          pattern="[0-9]+(\.[0-9]{1,2})?" title="Please enter format as 0.00"  required></p>
                                <h6>Stock: </h6>
                                <p><input style="width:100%;" type="text" name="bookStock" value="<%=book.getStocks()%>" 
                                          pattern="[0-9]+" title="Please enter number" required></p>
                                <h6>Category: </h6>
                                <p><input style="width:100%;" type="text" name="bookCategory" value="<%=book.getCategory()%>" 
                                          pattern="[a-zA-Z]+" title="Please enter only letters" required></p>
                                <h6>Language: </h6>
                                <p><input style="width:100%;" type="text" name="bookLanguage" value="<%=book.getLanguages()%>" 
                                          pattern="[a-zA-Z]+" title="Please enter only letters" required><p>
                                <div class="row pb-3">
                                    <div class="col d-grid">
                                        <input type="submit" class="btn btn-success btn-lg" name="button" value="Update"></a>
                                    </div>
                                </div>
                            </div>
                            </form>                            
                            <%} else {%>
                            <p>Book <%=book.getBookId()%> not found</p>
                            <%}%>
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