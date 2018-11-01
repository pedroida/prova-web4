<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Novo Produto">
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
        <!-- page title area end -->
        <t:product-formt/>
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
