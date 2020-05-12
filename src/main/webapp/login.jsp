<%--
  Created by IntelliJ IDEA.
  User: estefaniebecerra
  Date: 3/24/20
  Time: 12:29 AM
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
                <h2>Log in</h2>
                <FORM ACTION="j_security_check" METHOD="POST">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" placeholder="Enter username" id="username"
                               NAME="j_username" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" placeholder="Enter password" id="password"
                               NAME="j_password" required>
                    </div>
                    <INPUT class="btn btn-danger" TYPE="SUBMIT" VALUE="Log In">
                </FORM>
            </div>
        </div>
    </div>
</section>
<c:import url="footer.jsp"/>
</body>
</html>
