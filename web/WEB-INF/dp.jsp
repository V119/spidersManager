<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<jsp:include page="static/head_jsp.jsp"/>
<body style="overflow: hidden">
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
                        dp聚类</div>
                </div>
                <ol class="breadcrumb page-breadcrumb pull-right">
                    <li><i class="fa fa-home"></i>&nbsp;<a href="dashboard.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="hidden"><a href="#">dp聚类</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="active">dp聚类</li>
                </ol>
                <div class="clearfix">
                </div>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->

            <!--BEGIN CONTENT-->
            <div class="page-content" align="center">
                <!--END CONTENT-->

                <div id= "main" style="width:900px;height:700px;margin-top:10%">
                    <!--BEGIN FOOTER-->
                    <jsp:include page="static/footer.jsp"/>
                    <!--END FOOTER-->
                </div>
                <!--END PAGE WRAPPER-->
            </div>
        </div>

        <jsp:include page="static/footer_script.jsp"/>
        <script src="js/js3/echarts.min.js"></script><!--引入echarts.js-->
        <script  type="text/javascript">
            //基于准备好的dom,初始化echarts实例
            var myChart = echarts.init(document.getElementById("main"));
            myChart.showLoading();
            $.get('js/d3/dpData.js', function (dpData) {
                myChart.hideLoading();
                var jsonData = JSON.parse(dpData);
                var categories = new Map();
                var cateSet = new Set();
                for(var i = 0; i < jsonData.length; i++) {
                    var cate = jsonData[i]['cluster'];
                    cateSet.add(cate);
                    if(categories.has(cate)) {
                        var xyList = categories.get(cate)
                        xyList.push([jsonData[i]['p'], jsonData[i]['cta'],  jsonData[i]['name']]);
                        categories[cate] = xyList;
                    } else {
                        categories.set(cate, [[jsonData[i]['p'], jsonData[i]['cta'],  jsonData[i]['name']]]);
                    }
                }

                var itemStyle = {
                    normal: {
                        opacity: 0.8,
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowOffsetY: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                };

                var seriesList = [];
                for(var m in categories) {
                    seriesList.push({
                        name: m,
                        value: 'qwer',
                        type: 'scatter',
                        itemStyle: itemStyle,
                        data: categories[m]
                    })
                }

                option = {
                    title: {
                        text: 'dp',
                        x: 'center',
                        y: 0
                    },

                    tooltip: {
                        show: true,
                        /* position: function (pos, params, dom, rect, size) {
                         // 鼠标在左侧时 tooltip 显示到右侧，鼠标在右侧时 tooltip 显示到左侧。
                         var obj = {top: 60};
                         obj[['left', 'right'][+(pos[0] < size.viewSize[0] / 2)]] = 5;
                         return obj;
                         },  */
                        hideDelay: 500,
                        formatter: function (params, ticket, callback) {
                            var result = "";
                            var stock_name = params.value[2];
                            result = "<span style='color:#C1FFC1'>名称：</span> " + stock_name + "<br />";
                            $.ajax({
                                type: "post",
                                url: "ajax_dp",
                                data: {
                                    'name': stock_name
                                },
                                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                                success: function (msg) {
                                    result += msg;
                                    callback(ticket, result);
                                },
                                error: function (msg) {
                                    alert(msg)
                                }
                            });

                            return "loading";
                        }
                    },
                    xAxis: [
                        {gridIndex: 0, min: 0, max: 50}
                    ],
                    yAxis: [
                        {gridIndex: 0, min: 0, max: 1.2}
                    ],

                    series: seriesList
                };

                myChart.setOption(option);
            });
        </script>

        <!--Echarts end-->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.ui.custom.js"></script>
        <script src="js/matrix.js"></script>
</body>
</html>