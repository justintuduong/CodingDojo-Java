<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey</title>

<!-- BootStrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
        <form action='/process' method="POST">
            <div class="form-group">
 
                <label for="name">Your Name</label>
                <input type="text" name="name" class="form-control" placeholder="Your Name">
            </div>
            <div class="form-group">
                <label for="location">Dojo Location</label>
                <select class="form-control" name="location">
                    <option>San Jose</option>
                    <option>Berkeley</option>
                    <option>Seattle</option>
                </select>
            </div>
            <div>
                <label for="language">Favorite Language</label>
                <select class="form-control" name="language">
                    <option placeholder="language"></option>
                    <option value="python">Python</option>
                    <option value="Java">Java</option>
                    <option value="MEAN">MEAN</option>
                </select>
            </div>
            <div class="form-group">
                <label for="comment">Comment (optional):</label>
                <textarea class="form-control" name="comment" rows="3"></textarea>
            </div>
            <a>
                <button class="btn btn-primary" type="submit" value="result">Button</button>
            </a>
        </form>
    </div>

</body>
</html>