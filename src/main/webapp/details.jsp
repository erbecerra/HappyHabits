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
                <h2>Goal Detail</h2>
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#logGoal">
                   Log to goal
                </button>
                <br>
                <h3>After x weeks you will get a surprise pokemon</h3>
                ${goal}
                ${pokemon}
                <table class="table table-striped">

                </table>
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
                </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>

<c:import url="footer.jsp"/>
</body>
</html>