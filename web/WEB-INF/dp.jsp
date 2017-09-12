<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>舆情分析大平台</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/js1/echarts.min.js"></script>
</head>
<body>
<jsp:include page="static/fore_header.jsp"/>
<!--sidebar-menu-->
<jsp:include page="static/fore_lefter.jsp">
    <jsp:param name="eventID" value='<%=request.getSession().getAttribute("eventID")%>'/>
</jsp:include>
<div id="content">
    <div id="content-header">
        <div id="breadcrumb"><a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>主页</a> <a
                href="#" class="current">dp 聚类</a></div>
        <h1>dp聚类</h1>
        <hr>
    </div>
    <!--为Echarts准备一个具备大小（宽高）的Dom-->
    <div id="main" style="width: 900px;height: 700px;"></div>
</div>
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
</body>
</html>