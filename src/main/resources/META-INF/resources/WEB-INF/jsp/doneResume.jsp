<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>Parsed Resume</title>
</head>
<body>
<div class="container">
    <pre>${message}</pre>
<h1>Education</h1>

<table class="table">
    <thead>
    <tr>
        <th>Degree</th>
        <th>Institution</th>
        <th>Start Date</th>
        <th>End Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${educationList}" var="education">
        <tr>
            <td>${education.degree}</td>
            <td>${education.institution}</td>
            <td>${education.startDate}</td>
            <td>${education.endDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h1>Past Experiences</h1>

<table class="table">
    <thead>
    <tr>
        <th>Job Title</th>
        <th>Company Name</th>
        <th>Start Date</th>
        <th>End Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pastExperienceList}" var="experience">
        <tr>
            <td>${experience.jobTitle}</td>
            <td>${experience.companyName}</td>
            <td>${experience.startDate}</td>
            <td>${experience.endDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>>
<script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
</body>
</html>
