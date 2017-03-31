<!DOCTYPE html>
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
    <link rel="stylesheet" type="text/css" media="all" th:href="@{resources/css/styles.css}" />
</head>
<body onload='document.loginForm.j_username.focus();'>

<div class="container main-container">
    <div class='header'>
        <img src='../../resources/images/tinylogo21.png' class='app-logo'/>
        <h2 class='title'>Liverton Help Form</h2>
    </div>
    <div class='p-y-2'>
<div th:if="${param.error}">
    Invalid username and password.
</div>
<form name="loginForm" th:action="@{/login}" method="post">

    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
</form>
    </div>
</div>
</body>
</html>