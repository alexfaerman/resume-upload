<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>Resume Upload</title>
</head>
<body>
<div class="container" align="center">
    <br><br>
    <h1>Resume Upload</h1>
        <br><br>
        <form:form method="post" enctype="multipart/form-data" action="upload">
            <label for="resumeFile">Choose a file:</label>
            <input type="file" id="resumeFile" name="file">
            <br><br><br><br>
            <input type="submit" class="btn btn-success"/>
        </form:form>
</div>
<script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
</body>
</html>
