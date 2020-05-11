<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: estefaniebecerra
  Date: 3/24/20
  Time: 12:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:import url="head.jsp"/>
<body>
<c:import url="nav.jsp"/>
Welcome to Poke Habits ${user[0].firstName},

</body>
</html>

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
                <h2>Profile</h2>

                <table class="table table-striped">
                    <tr>
                        <td>First Name</td>
                        <td>${user[0].firstName}</td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td>${user[0].lastName}</td>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td>${user[0].userName}</td>
                    </tr>
                    <tr>
                        <td>Date of Birth</td>
                        <td>${user[0].dateOfBirth}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</section>
<c:import url="footer.jsp"/>
</body>
</html>
