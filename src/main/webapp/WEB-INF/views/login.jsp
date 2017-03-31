<!DOCTYPE html>
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
    <link rel="stylesheet" type="text/css" media="all" th:href="@{resources/css/styles.css}" />
</head>
<body>
    <div class="dim">
        <div class='p-y-2 login container rounded'>
            <h3 class='title flex-center'>Admin Login Portal</h3>

            <div class="loginContainer">

                <form name="loginForm" th:action="@{/login}" class="login" method="post">

                    <div class="form-group flex-center"> <label> User Name : <input type="text" name="username"/> </label></div>
                    <div class="form-group flex-center"><label> Password: <input type="password" name="password"/> </label></div>



                    <div class="alert alert-danger flex-center" th:if="${param.error}" role="alert">
                        Invalid username and password.
                    </div>

                    <div class="flex-center"><input type="submit" value="Sign In" class="btn submit btn-outline-primary"/></div>

                </form>
            </div>
        </div>
    </div>
</body>
</html>