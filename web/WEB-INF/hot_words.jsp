<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/9/6
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Dashboard | Dashboard</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="merge/images/icons/favicon.ico">
    <link rel="apple-touch-icon" href="merge/images/icons/favicon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="merge/images/icons/favicon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="merge/images/icons/favicon-114x114.png">
    <!--Loading bootstrap css-->
    <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,700">
    <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,700,300">
    <link type="text/css" rel="stylesheet" href="merge/styles/jquery-ui-1.10.4.custom.min.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/animate.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/all.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/main.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/style-responsive.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/zabuto_calendar.min.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/pace.css">
    <link type="text/css" rel="stylesheet" href="merge/styles/jquery.news-ticker.css">
</head>
<body>
<div>
    <!--BEGIN BACK TO TOP-->
    <a id="totop" href="#"><i class="fa fa-angle-up"></i></a>
    <!--END BACK TO TOP-->
    <jsp:include page="static/headerInfo.jsp"/>
    <div id="wrapper">
        <!--BEGIN SIDEBAR MENU-->
        <jsp:include page="static/leftNav.jsp"/>
        <!--END SIDEBAR MENU-->

        <!--BEGIN PAGE WRAPPER-->
        <div id="page-wrapper">
            <!--BEGIN TITLE & BREADCRUMB PAGE-->
            <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
              <div class="page-header pull-left">
                <div class="page-title">
                    热点词分析
                </div>
              </div>
              <ol class="breadcrumb page-breadcrumb pull-right">
                <li><i class="fa fa-home"></i>&nbsp;<a>Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                <li class="hidden"><a href="#">热点词分析</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                <li class="active">热点词分析</li>
              </ol>
              <div class="clearfix">
              </div>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->

            <!--BEGIN CONTENT-->
            <div class="page-content" align="center">
                <div id="main" style="width: 800px;height: 400px;margin-top: 10%" align="center"></div>
                <%--<div id="tab-general">
                    <div class="row mbl">
                        <div class="col-lg-12">

                            <div class="col-md-12">
                                <div id="area-chart-spline" style="width: 100%; height: 300px; display: none;">
                                </div>
                            </div>

                        </div>
                        <div class="panel" align="center">
                            <div class="panel-body"><h2 style="font-family:黑体;size: 24px;color: black" align="left"><strong>热点词分析</strong></h2>
                            </div>
                            <div id="main" style="width: 1200px;height: 600px;" align="center"></div>
                        </div>
                    </div>
                </div>--%>
                <!--END CONTENT-->
                <!--END CONTENT-->

                <!--BEGIN FOOTER-->
                <jsp:include page="static/footer.jsp"/>
                <!--END FOOTER-->
            </div>
            <!--END PAGE WRAPPER-->
        </div>
    </div>

    <jsp:include page="static/footer_script.jsp"/>
    <script src="js/js1/echarts.min.js"></script>
    <script src="js/js1/echarts-wordcloud.min.js"></script>
    <script  type="text/javascript">
        var keyWords = JSON.parse('${keyWords}');

        //基于准备好的dom,初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        //指定图表的配置项和数据
        var  option = {
            title: {
                text: '热点词分析',
                link: 'https://www.baidu.com/s?wd=' + encodeURIComponent('ECharts'),
                x: 'center',
                textStyle: {
                    fontSize: 23
                }

            },
            backgroundColor: '#F7F7F7',
            tooltip: {
                show: true
            },
            toolbox: {
                feature: {
                    saveAsImage: {
                        iconStyle: {
                            normal: {
                                color: '#FFFFFF'
                            }
                        }
                    }
                }
            },
            series: [{
                name: '热点分析',
                type: 'wordCloud',
                //size: ['9%', '99%'],
                sizeRange: [6, 66],
                //textRotation: [0, 45, 90, -45],
                rotationRange: [-45, 90],
                //shape: 'circle',
                textPadding: 0,
                autoSize: {
                    enable: true,
                    minSize: 6
                },
                textStyle: {
                    normal: {
                        color: function() {
                            return 'rgb(' + [
                                Math.round(Math.random() * 160),
                                Math.round(Math.random() * 160),
                                Math.round(Math.random() * 160)
                            ].join(',') + ')';
                        }
                    },
                    emphasis: {
                        shadowBlur: 10,
                        shadowColor: '#333'
                    }
                },
                data: []
            }]
        };


        option.series[0].data = keyWords;

        myChart.setOption(option);
        myChart.on('click', function (params) {
            alert((params.name));
            window.open('https://www.baidu.com/s?wd=' + encodeURIComponent(params.name));

        });
    </script>
</body>
</html>
