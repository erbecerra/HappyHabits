<%--
  Created by IntelliJ IDEA.
  User: estefaniebecerra
  Date: 4/5/20
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="head.jsp" />
<body>
<c:import url="nav.jsp" />

<div>
    <div class="content">
        <h1>Goals</h1>
        <table class="table table-striped">
            <tr><td>${goals[0].goalName}</td></tr>
            <tr><td>${goals[0].endDate}</td></tr>
            <tr><td>${goals[0].goalName}</td></tr>
            <tr><td>${goals[0].endDate}</td></tr>
        </table>
    </div>
</div>


</body>
</html>

