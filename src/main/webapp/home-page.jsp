<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/6/2024
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%-- Add this to the top of your home-page.jsp to debug --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TH Cinema</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/js/all.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <i class="fas fa-home"></i> Home
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="home-page.jsp">List Films <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="book-tickets.jsp">Tickets</a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <c:choose>
                <c:when test="${sessionScope.username != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="logout">
                            <i class="fas fa-sign-out-alt"></i> Logout
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">
                            <i class="fas fa-sign-in-alt"></i> Login
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>

<div class="container mt-5">
    <h1>Welcome to TH Cinema</h1>
    <div class="row">
        <c:forEach var="movie" items="${movies}">
            <div class="col-md-3 mb-4">
                <div class="card">
                    <img src="${movie.imageUrl}" class="card-img-top" alt="${movie.title}">
                    <div class="card-body">
                        <h5 class="card-title">${movie.title}</h5>
                        <p class="card-text">${movie.genre} - ${movie.duration} minutes</p>
                        <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#movieModal"
                           data-title="${movie.title}"
                           data-genre="${movie.genre}"
                           data-duration="${movie.duration}"
                           data-image-url="${movie.imageUrl}"
                           data-trailer-url="${movie.trailerUrl}"
                           data-description="${movie.description}">View Details</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<div class="modal fade" id="movieModal" tabindex="-1" role="dialog" aria-labelledby="movieModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="movieModalLabel">Movie Details</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <img src="" id="modalImage" class="img-fluid mb-3" alt="">
                <h5 id="modalTitle"></h5>
                <p><strong>Genre:</strong> <span id="modalGenre"></span></p>
                <p><strong>Duration:</strong> <span id="modalDuration"></span> minutes</p>
                <p><strong>Description:</strong> <span id="modalDescription"></span></p>
                <a id="modalTrailer" href="#" class="btn btn-info" target="_blank">Watch Trailer</a>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script>
    $('#movieModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var title = button.data('title');
        var genre = button.data('genre');
        var duration = button.data('duration');
        var imageUrl = button.data('image-url');
        var trailerUrl = button.data('trailer-url');
        var description = button.data('description');

        var modal = $(this);
        modal.find('.modal-title').text('Details: ' + title);
        modal.find('#modalImage').attr('src', imageUrl);
        modal.find('#modalTitle').text(title);
        modal.find('#modalGenre').text(genre);
        modal.find('#modalDuration').text(duration);
        modal.find('#modalDescription').text(description);
        modal.find('#modalTrailer').attr('href', trailerUrl);
    });
</script>
</body>
</html>