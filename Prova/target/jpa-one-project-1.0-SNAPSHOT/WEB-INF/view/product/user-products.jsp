<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Compra e venda Pedrão">
    <jsp:body>
        <div class="page-title-area">
            <div class="row align-items-center">
                <div class="col-sm-6 m-2">
                    <div class="breadcrumbs-area clearfix">
                        <h4 class="page-title pull-left">${breadcrumb}</h4>
                        <ul class="breadcrumbs pull-left">
                            <li><a href="/online/index">Home</a></li>
                            <li><span>${breadcrumb}</span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${success != null}">
            <div class="alert-dismiss">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>${success}</strong>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span class="fa fa-times"></span>
                    </button>
                </div>
            </div>
            <c:remove var="success" scope="application"/>
        </c:if>
        <!-- page title area end -->
        <div class="main-content-inner">
            <!-- row area end -->
            <div class="row mt-5">
                <!-- latest news area start -->
                <c:forEach var="product" items="${products}">

                    <div class="col-xl-4 mb-5">
                        <div class="card">
                            <div class="card-body">
                                <div class="letest-news">
                                    <div class="lts-content">
                                        <h4>Título: ${product.title}</h4>
                                        <br>
                                        <span>Descrição: ${product.description}</span>
                                        <br>
                                        <span>Preço: ${product.getFormattedPrice()}</span>
                                        <br>
                                        <span>Unidade: ${product.unit}</span>
                                        <br>
                                        <span>Validade: ${product.getFormattedValidity()}</span>
                                        <br>
                                        <span>Quantidade: ${product.quantity}</span>
                                    </div>
                                </div>
                            </div>
                            <div class="card-footer">
                                <a href="/online/produto/editar?id=${product.id}"
                                   class="btn btn-warning btn-flat pull-left">
                                    <i class="fa fa-pencil"></i>
                                    Editar
                                </a>
                                <form action="/online/produto/apagar" method="POST">
                                    <input type="hidden" name="id" value="${product.id}">
                                    <button type="submit" class="btn btn-flat btn-danger pull-right">
                                        <i class="fa fa-trash"></i>
                                        Apagar
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <!-- latest news area end -->
            </div>
            <!-- row area start-->
        </div>
        </div>
        <!-- main content area end -->
        <!-- footer area start-->
        <footer>
            <div class="footer-area">
                <p>© Copyright 2018 . Todos os direitos reservados</p>
            </div>
        </footer>
        <!-- footer area end-->
    </jsp:body>
</t:template>