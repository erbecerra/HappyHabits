<%--
  Created by IntelliJ IDEA.
  User: estefaniebecerra
  Date: 4/26/20
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <c:forEach items="${pokemon}" var="poke">
                    <div class="card" s>
                        <img class="card-img-top" src="${poke.imageUrl}" alt="Card image" style="width:150px;height:150px">
                        <div class="card-body">
                            <p class="card-title">Name: ${poke.pokemonName}</p>
                            <p class="card-text">Description: ${poke.description}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
<c:import url="footer.jsp"/>
</body>
</html>
