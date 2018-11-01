<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Login</title>
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
                        <li>
                            <a href="javascript:void(0)" aria-expanded="true"><i
                                    class="fa fa-user"></i><span>Usuário</span></a>
                            <ul class="collapse">
                                <li><a href="/online/index">Entrar</a></li>
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
                <div class="col-md-6 col-sm-8 clearfix">
                    <div class="nav-btn pull-left">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </div>
                <!-- profile info & task notification -->
                <div class="col-md-6 col-sm-4 clearfix">
                    <ul class="notification-area pull-right">
                        <li id="full-view"><i class="ti-fullscreen"></i></li>
                        <li id="full-view-exit"><i class="ti-zoom-out"></i></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- page title area end -->
        <div class="main-content-inner">
            <div class="col-12 mt-5">
                <div class="card">
                    <div class="card-body">
                        <h4 class="header-title">Dados do usuário</h4>
                        <form action="/cadastrar/salvar" method="POST">
                            <div class="form-group">
                                <label for="name" class="col-form-label">Nome</label>
                                <input class="form-control" type="text" id="name" name="name" required>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-form-label">Senha</label>
                                <input class="form-control" type="password" name="password" required id="password">
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-form-label">Confirmar Senha</label>
                                <input class="form-control" type="password" name="confirm_password" required
                                       id="confirm_password">
                            </div>
                            <button type="submit" class="btn btn-flat btn-primary btn-lg btn-block">
                                Cadastrar
                            </button>
                        </form>
                    </div>
                </div>
            </div>
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