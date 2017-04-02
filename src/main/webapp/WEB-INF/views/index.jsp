<!DOCTYPE html>
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
    <link rel="stylesheet" type="text/css" media="all" th:href="@{resources/css/styles.css}" />
</head>
<body>

<div class="container main-container">
    <div class='header'>
        <img src='../../resources/images/tinylogo21.png' class='app-logo'/>
        <h2 class='title'>Liverton Help Form</h2>
    </div>
    <div class='p-y-2'>
        <form class="form-horizontal" action="#" th:action="@{/submit}" th:object="${feedback}" method="post">
            <div class="form-group">
                <label  for="name" class="col-xs-8 col-sm-7 col-md-6 col-lg-3 col-xl-4 col-form-label">Name:</label>
                <input required="true" class="form-control col-xs-4 col-sm-3 col-md-2" type="text" th:field="*{name}" />
            <div class="form-group">
            </div>
                <label for="phoneNumber" class="col-xs-8 col-sm-7 col-md-6 col-lg-3 col-xl-4 col-form-label">Phone number:</label>
                <input required="true" class="form-control col-xs-4 col-sm-3 col-md-2" type="text" th:field="*{phoneNumber}" />
            </div>
            <div class="form-group">
                <label for="email" class="col-xs-8 col-sm-7 col-md-6 col-lg-3 col-xl-4 col-form-label">Email address:</label>
                <input required="true" class="form-control col-xs-4 col-sm-3 col-md-2" type="email" th:field="*{email}" />
            </div>
            <div class="form-group blu-margin">
                <label for="product" class="col-xs-8 col-sm-7 col-md-6 col-lg-3 col-xl-4 col-form-label">Product:</label>
                <select name="product" class="form-control" required="true">
                    <option value="" th:text="${'Please select a product'}" ></option>
                    <th:block th:each="item, iterationStatus : ${productList}" th:inline="text">
                        <option th:value="${item}">[[${item}]]</option>
                    </th:block>
                </select>

            </div>
            <div class="form-group">
                <label for="feedback" class="col-xs-8 col-sm-7 col-md-6 col-lg-3 col-xl-4 col-form-label">Feedback:</label>
                <textarea required="true" class="form-control col-xs-4 col-sm-3 col-md-2" type="textarea" th:field="*{feedback}" />
            </div>

            <div class="form-group">
                <div class="">
                    <button type="submit" class="btn submit btn-outline-primary">Submit</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>