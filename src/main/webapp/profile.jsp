<%--
  Created by IntelliJ IDEA.
  User: estefaniebecerra
  Date: 3/24/20
  Time: 12:55 AM
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
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#edit">
                    Edit
                </button>
            </div>
        </div>
    </div>
</section>

<!-- The Modal -->
<div class="modal" id="edit">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Edit Profile</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form action="" method="POST">
                    <div class="form-group">
                        <label for="first_name">First Name:</label>
                        <input type="text" class="form-control" placeholder="First name" id="first_name"
                               name="first_name">
                    </div>
                    <div class="form-group">
                        <label for="last_name">Last Name:</label>
                        <input type="text" class="form-control" placeholder="Last Name" id="last_name" name="last_name">
                    </div>
                    <div class="form-group">
                        <label for="date_of_birth">Date of Birth:</label>
                        <input type="date" class="form-control" id="date_of_birth" name="date_of_birth">
                    </div>
                    <input class="btn btn-danger" type="SUBMIT" value="Update">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </form>
            </div>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>
</body>
</html>
