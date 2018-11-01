<%@tag description="formulário produto" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main-content-inner">
    <div class="col-12 mt-5">
        <div class="card">
            <div class="card-body">
                <h4 class="header-title">Dados do produto</h4>
                <form action="${action}" method="POST">
                    <c:choose>
                        <c:when test="${product == null}">
                            <div class="form-group">
                                <label for="title" class="col-form-label">Título</label>
                                <input class="form-control" type="text" id="title" name="title">
                            </div>
                            <div class="form-group">
                                <label for="description" class="col-form-label">Descrição</label>
                                <input class="form-control" type="text" name="description" id="description">
                            </div>
                            <div class="form-group">
                                <label for="quantity" class="col-form-label">Quantidade</label>
                                <input class="form-control" type="text" name="quantity" id="quantity"
                                       data-thousands="." data-decimal=",">
                            </div>
                            <div class="form-group">
                                <label for="unit" class="col-form-label">Unidade</label>
                                <input class="form-control" type="text" name="unit" id="unit">
                            </div>
                            <div class="form-group">
                                <label for="price" class="col-form-label">Preço</label>
                                <input class="form-control" type="text" name="price" id="price"
                                       data-prefix="R$ " data-thousands="." data-decimal=",">
                            </div>
                            <div class="form-group">
                                <label for="validity" class="col-form-label">Validade do anúncio</label>
                                <input class="form-control" type="text" name="validity" id="validity">
                            </div>
                        </c:when>
                        <c:when test="${product != null}">
                            <input type="hidden" name="id" value="${product.id}">
                            <div class="form-group">
                                <label for="title" class="col-form-label">Título</label>
                                <input class="form-control" value="${product.title}" type="text" id="title"
                                       name="title">
                            </div>
                            <div class="form-group">
                                <label for="description" class="col-form-label">Descrição</label>
                                <input class="form-control" value="${product.description}" type="text"
                                       name="description" id="description">
                            </div>
                            <div class="form-group">
                                <label for="quantity" class="col-form-label">Quantidade</label>
                                <input class="form-control" value="${product.quantity}" type="text" name="quantity"
                                       id="quantity"
                                       data-thousands="." data-decimal=",">
                            </div>
                            <div class="form-group">
                                <label for="unit" class="col-form-label">Unidade</label>
                                <input class="form-control" value="${product.unit}" type="text" name="unit" id="unit">
                            </div>
                            <div class="form-group">
                                <label for="price" class="col-form-label">Preço</label>
                                <input class="form-control" value="${product.getFormattedPrice()}" type="text"
                                       name="price" id="price"
                                       data-prefix="R$ " data-thousands="." data-decimal=",">
                            </div>
                            <div class="form-group">
                                <label for="validity" class="col-form-label">Validade do anúncio</label>
                                <input class="form-control" value="${product.getFormattedValidity()}" type="text"
                                       name="validity" id="validity">
                            </div>
                        </c:when>
                    </c:choose>
                    <button type="submit" class="btn btn-flat btn-primary btn-lg btn-block">
                        Salvar
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>