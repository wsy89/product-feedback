<!DOCTYPE html>
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
    <link rel="stylesheet" type="text/css" media="all" th:href="@{resources/css/styles.css}" />
</head>
<body>
<div class="dim">
    <div class='p-y-2 outer container rounded'>
        <div class='header'>
            <img src='../../resources/images/tinylogo21.png' class='logo'/>
            <h2 class='title'>Your feedback is submitted</h2>
        </div>

        <div class="inner container">
            <div class="alert alert-success" role="alert">Thank you for your opinion</div>
        </div>
    </div>
</div>
</body>
</html>