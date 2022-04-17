<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Relatório diário">
    <jsp:body>
        <main class="container d-flex flex-column justify-content-center align-items-center">
            <h5 class="text-center">Relatório do dia</h5>
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
                        <tr>
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
                Ainda não temos registro de nenhum carro!
            </c:if>
        </main>

    </jsp:body>
</t:template>