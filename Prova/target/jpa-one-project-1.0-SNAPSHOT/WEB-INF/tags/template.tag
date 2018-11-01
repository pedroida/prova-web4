<%@tag language="java" description="Template principal" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="title" %>


<html>
<head>
    <title>${title}</title>
    <base href="${pageContext.request.contextPath}/">
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/png" href="resources/assets/images/icon/favicon.ico">
    <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/assets/css/themify-icons.css">
    <link rel="stylesheet" href="resources/assets/css/metisMenu.css">
    <link rel="stylesheet" href="resources/assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="resources/assets/css/slicknav.min.css">
    <!-- amchart css -->
    <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all"/>
    <!-- others css -->
    <link rel="stylesheet" href="resources/assets/css/typography.css">
    <link rel="stylesheet" href="resources/assets/css/default-css.css">
    <link rel="stylesheet" href="resources/assets/css/styles.css">
    <link rel="stylesheet" href="resources/assets/css/responsive.css">
    <!-- modernizr css -->
    <script src="resources/assets/js/vendor/modernizr-2.8.3.min.js"></script>

</head>
<body>
<div class="page-container">
    <div class="sidebar-menu">
        <div class="sidebar-header">
            <div class="logo">
                <a href="/online/index"><img src="resources/assets/images/icon/logo.png" alt="logo"></a>
            </div>
        </div>
        <div class="main-menu">
            <div class="menu-inner">
                <nav>
                    <ul class="metismenu" id="menu">
                        <li class="active">
                            <a href="javascript:void(0)" aria-expanded="true"><i
                                    class="ti-dashboard"></i><span>Produtos</span></a>
                            <ul class="collapse">
                                <li><a href="/online/index">Todos os produtos</a></li>
                                <%--<c:if test="${isLoggedin}">--%>
                                <li><a href="/online/produto">Meus Produtos</a></li>
                                <li><a href="/online/produto/criar">
                                    <i class="fa fa-plus"></i>
                                    Novo
                                </a></li>
                                <%--</c:if>--%>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0)" aria-expanded="true"><i
                                    class="fa fa-user"></i><span>Usuário</span></a>
                            <ul class="collapse">
                                <li><a href="/online/logout">Sair</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <div class="main-content">
        <!-- header area start -->
        <div class="header-area">
            <div class="row align-items-center">
                <!-- nav and search button -->
                <div class="col-md-1 col-sm-1 clearfix">
                    <div class="nav-btn pull-left">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>

                </div>
                <div class="col-md-10 col-sm-10">
                    <h5 class="page-title pull-left">
                        Interesses: ${interest}
                    </h5>

                    <h5 class="page-title pull-right">${cookie.currentTime.value}</h5>
                </div>
                <!-- profile info & task notification -->
                <div class="col-md-1 col-sm-1 clearfix">
                    <ul class="notification-area pull-right">
                        <li id="full-view"><i class="ti-fullscreen"></i></li>
                        <li id="full-view-exit"><i class="ti-zoom-out"></i></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- header area end -->
        <!-- page title area start -->
        <jsp:doBody/>
        <!-- page container area end -->
        <!-- offset area start -->
    </div>
    <!-- offset area end -->
    <!-- jquery latest version -->
    <script src="resources/assets/js/vendor/jquery-2.2.4.min.js"></script>
    <!-- bootstrap 4 js -->
    <script src="resources/assets/js/popper.min.js"></script>
    <script src="resources/assets/js/bootstrap.min.js"></script>
    <script src="resources/assets/js/owl.carousel.min.js"></script>
    <script src="resources/assets/js/metisMenu.min.js"></script>
    <script src="resources/assets/js/jquery.slimscroll.min.js"></script>
    <script src="resources/assets/js/jquery.slicknav.min.js"></script>

    <!-- start chart js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
    <!-- start highcharts js -->
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <!-- start zingchart js -->
    <script src="https://cdn.zingchart.com/zingchart.min.js"></script>
    <script>
        zingchart.MODULESDIR = "https://cdn.zingchart.com/modules/";
        ZC.LICENSE = ["569d52cefae586f634c54f86dc99e6a9", "ee6b7db5b51705a13dc2339db3edaf6d"];
    </script>
    <!-- all line chart activation -->
    <script src="resources/assets/js/line-chart.js"></script>
    <!-- all pie chart -->
    <script src="resources/assets/js/pie-chart.js"></script>
    <!-- others plugins -->
    <script src="resources/assets/js/plugins.js"></script>
    <script src="resources/assets/js/scripts.js"></script>
    <script src="resources/js/jquery.maskMoney.min.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.13.4/jquery.mask.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

    <script>
        $(function () {
            $('#price').maskMoney();

            $('#quantity').mask("0#");

            $('#validity').datepicker({
                format: 'dd/mm/yyyy',
                language: 'pt-BR'
            });
        });
    </script>
</div>
</body>
</html>
