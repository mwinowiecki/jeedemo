<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
 <%--   <jsp:include page="parts/head.jsp" /> --%>
</head>

<body>

<%--<jsp:include page="parts/navbar.jsp" /> --%>

<div class="container">
    <div class="row">
        <h3>List of sandwiches</h3>
        <br/>

        <c:choose>
            <c:when test="${sandwiches.size() > 0}">
                <table class="table table-striped">
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Date of make</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach var="sandwich" items="${sandwiches}" varStatus="loopCounter">
                        <tr>
                            <td>${sandwich.id}</td>
                            <td>${sandwich.name}</td>
                            <td>${sandwich.price}</td>
                            <td>
                                <a href="view/${sandwich.id}">
                                    View
                                </a>
                                |
                                <a href="edit/${sandwich.id}">
                                    Edit
                                </a>
                                |
                                <a href="remove/${sandwich.id}">
                                    Remove
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </c:when>
            <c:otherwise>
                <div class="well">No list yet!</div>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="row">
        <div class="col-md-12">
            <h3>Add new sandwich!</h3>
            <br/>

            <form action="add" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Name:</label>

                    <div class="col-sm-10">
                        <input type="text" name="name" id="name" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label for="price" class="col-sm-2 control-label">Price:</label>

                    <div class="col-sm-10">
                        <input type="number" name="price" id="price" class="form-control">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="dateOfMake" class="col-sm-2 control-label">Date of make:</label>

                    <div class="col-sm-10">
                        <input type="date" name="dateOfMake" id="dateOfMake" class="form-control">
                    </div>
                </div>

                <!-- <div class="form-group">
                    <label for="author" class="col-sm-2 control-label">Author:</label>
                    <div class="col-sm-10">
                        <input type="text" name="author" id="author" class="form-control">
                    </div>
                </div>
 -->
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Add</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <hr>

<%--    <jsp:include page="parts/footer.jsp" /> --%>
</div>
<%--
<jsp:include page="parts/scripts.jsp" /> --%>
</body>
</html>