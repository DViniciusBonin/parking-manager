<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Registrar carro">
    <jsp:body>

        <main class="container d-flex flex-column justify-content-center align-items-center">

            <h5>Registro de veiculo</h5>

            <form action="registrar-carros" method="post" class="w-75">

                <div class="">
                    <label for="exampleFormControlInput1" class="form-label">Marca</label>
                    <select id="select-brands" class="form-select" aria-label="Default select example" name="brand">
                    </select>
                </div>

                <div class="mt-2">
                    <label for="exampleFormControlInput1" class="form-label">Modelo</label>
                    <input type="text" class="form-control" name="model">
                </div>

                <div class="mt-2">
                    <label for="exampleFormControlInput1" class="form-label">Placa</label>
                    <input type="text" class="form-control" name="placa">
                </div>

                <div class="mt-2">
                    <label for="exampleFormControlInput1" class="form-label">Cor</label>
                    <input type="text" class="form-control" name="color">
                </div>

                <div class="mt-4 d-flex justify-content-between">
                    <button type="reset" class="btn btn-danger  mw-25">Cancelar</button>
                    <button type="submit" class="btn btn-success  mw-25">Salvar</button>
                </div>
            </form>

        </main>
        <script>
            window.onload = function (){
                $.get('marcas', function(data) {
                    let $select = $('#select-brands');
                    $.each(data, function(index, item) {
                        $('<option>').val(item.id).text(item.name).appendTo($select);
                    });
                });
            }
        </script>

    </jsp:body>
</t:template>