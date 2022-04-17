<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Carro estacionado">
    <jsp:body>
        <main class="container d-flex flex-column justify-content-center align-items-center">
            <div>
                <section>
                    ${car.brand.name} ${car.model}
                </section>
                <section>
                    Placa: ${car.code}
                </section>
                <Section>
                    Cor: ${car.color}
                </Section>
                <section>
                    Hora de entrada: ${car.created_at.getHour()}:${car.created_at.getMinute()}
                </section>
                <section>
                    Hora de saida: ${car.updated_at.getHour()}:${car.updated_at.getMinute()}

                </section>
            </div>
            <form action="registrar-saida" method="post">
                <input type="text" name="id" value="${car.id}" style="display: none">
                <button type="submit" class="btn btn-success  mw-25 d-flex justify-content-center align-items-center">Registrar saída</button>
            </form>
        </main>

    </jsp:body>
</t:template>