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
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#addGoal">
                    Add a goal
                </button>
                <br>
                <table class="table table-striped">
                    <c:forEach items="${goals}" var="goal">
                        <tr>
                            <td>${goal.displayPokemon}</td>
                            <c:if test="${goal.displayPokemon}">
                                <td><img src="${goal.pokemon.imageUrl}" alt="${goal.pokemon.pokemonName}">${goal.pokemon.pokemonName}</td>
                            </c:if>
                            <c:if test="${!goal.displayPokemon}">
                                <td><img src="images/brokenPokeBall.png" alt="">Mystery Pokemon</td>
                            </c:if>
                            <td>${goal.goalName}</td>
                            <td>${goal.goalType}</td>
                            <td><a href="/HappyHabits/details?goalid=${goal.id}">Details</a></td>
                            <td><a href="/HappyHabits/delete?entity=goal&id=${goal.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>



<!-- The Modal -->
<div class="modal" id="addGoal">
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
                    <div class="form-group">
                        <label for="title">Title</label>
                        <input type="text" class="form-control" placeholder="Enter title" id="title" name="title">
                    </div>
                    <div class="form-check-inline">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="frequency" value="DAILY">Daily
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
                    <input class="btn btn-danger" type="SUBMIT" value="Add Goal">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </form>
            </div>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>
</body>
</html>

