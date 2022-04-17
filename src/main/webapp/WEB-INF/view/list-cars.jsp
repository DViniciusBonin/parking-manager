<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Carros estacionados">
    <jsp:body>
        <main class="container d-flex flex-column justify-content-center align-items-center">
            <h5 class="text-center">Carros estacionados</h5>
            <c:if test="${not empty cars}">
                <table class="table table-hover mt-3">

                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Marca</th>
                        <th scope="col">Modelo</th>
                        <th scope="col">Placa</th>
                        <th scope="col">Cor</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="car" items="${cars}">
                        <tr onclick="handleDetails(${car.id})">
                            <th scope="row">${car.id}</th>
                            <td>${car.brand.name}</td>
                            <td>${car.model}</td>
                            <td>${car.code}</td>
                            <td>${car.color}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty cars}">
                Não há carros estacionados no momento!
            </c:if>
        </main>
        <script>
            function handleDetails(id) {
                const url = `http://localhost:8080/parking-manager/carro?id=`+ id
                window.location.href = url
            }
        </script>
    </jsp:body>
</t:template>