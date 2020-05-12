<%--
  Created by IntelliJ IDEA.
  User: estefaniebecerra
  Date: 5/12/20
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="head.jsp"/>
<body>
<c:import url="nav.jsp"/>
<section>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <h2>Update Goal</h2>
<form action="" method="POST">
    <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" placeholder="Enter title" id="title" name="title" required>
    </div>
    <div class="form-check-inline">
        <label class="form-check-label">
            <input type="radio" class="form-check-input" name="frequency" value="DAILY" required>Daily
        </label>
    </div>
    <div class="form-check-inline">
        <label class="form-check-label">
            <input type="radio" class="form-check-input" name="frequency" value="WEEKLY">Weekly
        </label>
    </div>
    <div class="form-check-inline">
        <label class="form-check-label">
            <input type="radio" class="form-check-input" name="frequency" value="MONTHLY">Monthly
        </label>
    </div>
    <br>
    <input class="btn btn-danger" type="SUBMIT" value="Update Goal">
</form>
                </div>
        </div>
    </div>
    </section>
</body>
</html>
