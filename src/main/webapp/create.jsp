<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 11/7/2023
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
</head>
<body>
<form action="http://localhost:8080/student?action=create" method="post">
    <div class="form-group">
        <label class="form-label" >Name</label>
        <input name='name' type="text" class="form-control" placeholder="Enter Name" >
    </div>
    <div class="mb-3">
        <label  class="form-label" >Email</label>
        <input name="email" type="text" class="form-control"  aria-describedby="emailHelp" placeholder="Enter Email">
    </div>
    <div class="mb-3">
        <label  class="form-label">Date Of Birth</label>
        <input name="dateOfBirth" type="text" class="form-control"  placeholder="Enter date of birth as YYYY-MM-DD">
    </div>
    <div class="mb-3">
        <label  class="form-label">Address</label>
        <input name="address" type="text" class="form-control" placeholder="Enter address">
    </div>
    <div class="mb-3">
        <label  class="form-label">Phone Number</label>
        <input name="phoneNumber" type="text" class="form-control" placeholder="Enter phone number" >
    </div>
    <div class="mb-3">
        <label  class="form-label">Class</label >
        <Select name="classRoomId">
            <c:forEach var="item" items="${clasezList}">
                <option value="${item.id}">${item.name}</option>
            </c:forEach>
        </Select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
