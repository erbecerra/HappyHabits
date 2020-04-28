<%--
  Created by IntelliJ IDEA.
  User: estefaniebecerra
  Date: 4/5/20
  Time: 10:56 PM
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
                <h2>Goals</h2>
                <div> + Add a goal </div>
                <table class="table table-striped">
                    <c:forEach items="${goals}" var="goal">
                        <tr>
                            <td>${goal.pokemon.pokemonName}</td>
                            <td>${goal.goalName}</td>
                            <td>${goal.endDate}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>
<c:import url="footer.jsp"/>
</body>
</html>

