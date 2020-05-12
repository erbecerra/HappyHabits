<%--
  Created by IntelliJ IDEA.
  User: estefaniebecerra
  Date: 5/10/20
  Time: 12:19 AM
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
                <div>
                <h2>Goal Detail</h2>
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#logGoal">
                   Log to goal
                </button>
                <br>
                <h3>After x weeks you will get a surprise pokemon</h3>
                ${goal.goalName}
                    <img src="${pokemon.imageUrl}" alt="${pokemon.pokemonName}">${pokemon.pokemonName}
                </div>
                <div>
                    <table class="table table-striped">
                    <c:forEach items="${logs}" var="log">
                        <tr>
                            <td>${log.date}</td>
                            <td>${log.success}</td>
                            <td><a href="/HappyHabits/delete?entity=log&id=${log.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
                </div>
            </div>
        </div>
    </div>
</section>



<!-- The Modal -->
<div class="modal" id="logGoal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Add Goal</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form action="" method="POST">
                    <div class="form-check-inline">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="completed" value="true">Yes
                        </label>
                    </div>
                    <div class="form-check-inline">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="completed" value="false">No
                        </label>
                    </div>
                    <br>
                    <input class="btn btn-danger" type="SUBMIT" value="Add log to goal">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </form>
            </div>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>
</body>
</html>