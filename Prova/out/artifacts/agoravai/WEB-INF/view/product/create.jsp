<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Compra e venda Pedrão">
    <jsp:body>
        <div class="col s12">
            <div class="card">
                <div class="card-content">
                    <div class="row">
                        <form class="col s12">
                            <div class="row">
                                <div class="input-field col s12">
                                    <input id="title" name="title" type="text" class="validate">
                                    <label for="title">Título</label>
                                </div>
                                <div class="input-field col s12">
                                    <input id="description" name="description" type="text" class="validate">
                                    <label for="description">Descrição</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s6">
                                    <input id="quantity" name="quantity" type="text" class="validate">
                                    <label for="quantity">Quantidade</label>
                                </div>
                                <div class="input-field col s6">
                                    <input id="price" name="price" type="text" class="validate">
                                    <label for="price">Preço</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s3">
                                    <input id="validity" name="validity" type="text" class="datepicker validate">
                                    <label for="validity">Validade</label>
                                </div>
                                <div class="input-field col s3">
                                    <input id="unit" name="unit" type="text" class="validate">
                                    <label for="unit">Unidade</label>
                                </div>
                            </div>
                            <button class="btn left">Voltar</button>
                            <button type="submit" class="btn right">Salvar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            document.addEventListener('DOMContentLoaded', function() {
                var elems = document.querySelectorAll('.datepicker');
                var instances = M.Datepicker.init(elems, options);
            });
        </script>
    </jsp:body>
</t:template>
