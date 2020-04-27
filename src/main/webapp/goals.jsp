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
                    <tr>
                        <td>POkemon picture/poke ball</td>
                        <td>${goals[0].goalName}</td>
                        <td>Daily @ 7:00 pm 20 days left to reveal pokemon</td>
                    </tr>
                    <tr>
                        <td>POkemon picture/poke ball</td>
                        <td>${goals[0].endDate}</td>
                        <td>Daily @ 7:00 pm 20 days left to reveal pokemon</td>
                    </tr>
                    <tr>
                        <td>POkemon picture/poke ball</td>
                        <td>${goals[0].goalName}</td>
                        <td>Daily @ 7:00 pm 30 days left to evolve your pokemon</td>
                    </tr>
                    <tr>
                        <td>POkemon picture/poke ball</td>
                        <td>${goals[0].endDate}</td>
                        <td>Daily @ 7:00 pm 20 days left to reveal pokemon</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</section>
<c:import url="footer.jsp"/>
</body>
</html>

