<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<div class="">
    <div class="main-content">
        <!-- header area end -->
        <!-- page title area start -->
        <div id="preloader">
            <div class="loader"></div>
        </div>
        <!-- preloader area end -->
        <!-- login area start -->
        <div class="login-area">
            <div class="container">
                <div class="login-box ptb--100">
                    <form action="j_security_check" method="POST">
                        <div class="login-form-head">
                            <h4>Entrar</h4>
                            <p>Entre e desfrute da melhor plataforma de anúncios da minha rua</p>
                        </div>
                        <div class="login-form-body">
                            <div class="form-gp">
                                <label for="username">Usuário</label>
                                <input type="text" id="username" name="j_username">
                                <i class="ti-user"></i>
                            </div>
                            <div class="form-gp">
                                <label for="j_password">Senha</label>
                                <input type="password" id="j_password" name="j_password">
                                <i class="ti-lock"></i>
                            </div>
                            <div class="submit-btn-area">
                                <button id="form_submit" type="submit">Entrar <i class="ti-arrow-right"></i></button>
                            </div>
                            <div class="form-footer text-center mt-5">
                                <p class="text-muted">Não faz parte do time ainda?
                                    <a href="/cadastrar">REGISTRE-SE</a></p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
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
</div>
</body>
</html>
