<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Parking manager">
    <jsp:body>
        <main class="container d-flex flex-column justify-content-center align-items-center">

            <span class="title">Selecione uma opção</span>

            <a href="registrar-carros" class="button-custom secondary-color color-light-bg">Registrar veículo</a>
            <a href="carros" class="button-custom color-white primary-color-bg">Ver carros estacionados</a>
            <a href="relatorio-diario" class="button-custom color-white secondary-color-bg">Relatório do dia</a>
        </main>

    </jsp:body>
</t:template>