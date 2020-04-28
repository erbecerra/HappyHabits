<%--
  Created by IntelliJ IDEA.
  User: estefaniebecerra
  Date: 4/27/20
  Time: 10:09 PM
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
                <h2>Log goal</h2>
                <form action="">
                    <div class="form-check-inline">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="log" value="yes">Yes
                        </label>
                    </div>
                    <div class="form-check-inline">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="log" value="no">No
                        </label>
                    </div>
                    <br>
                    <input class="btn btn-danger" type="SUBMIT" value="Log">
                </form>
            </div>
        </div>
    </div>
</section>
<c:import url="footer.jsp"/>
</body>
</html>

