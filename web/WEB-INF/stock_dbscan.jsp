<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>舆情分析大平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" href="css/matrix-style.css"/>
    <link rel="stylesheet" href="css/matrix-media.css"/>
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + path;
    %>
</head>

<body>
<jsp:include page="static/fore_header.jsp"/>
<!--sidebar-menu-->
<jsp:include page="static/fore_lefter.jsp">
    <jsp:param name="eventID" value='<%=request.getSession().getAttribute("eventID")%>'/>
</jsp:include>
<!--sidebar-menu-->
<div id="content">
    <div id="content-header">
        <div id="breadcrumb"><a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>主页</a> <a
                href="#" class="current">db scan</a></div>
        <h1>db scan</h1>
        <hr>
    </div>

    <div id="choose">
        起始时间：<input type="text" id="starttime" size=15 value="${starttime}" placeholder="请输入起始时间">
        结束时间：<input type="text" id="endtime" size=15 value="${endtime}" placeholder="请输入结束时间">
        邻域半径（相关系数cd）：<input type="text" id="radius" size=15 value="${radius}" placeholder="请输入相关系数"><br>
        邻域内最小节点个数：<input type="text" id="minPts" size=15 value="${minPts}" placeholder="请输入邻域最小个数">
        生成边的最低下限：<input type="text" id="therehold" size=15 value="${therehold}" placeholder="请输入生成边的最低下限">
        <input type="button" id="submit" value="提交" onclick="submiit()"/>
    </div>
    <!--为Echarts准备一个具备大小（宽高）的Dom-->
    <div id="main" style="width: 900px;height: 700px;"></div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/js1/echarts.min.js"></script>

<script type="text/javascript">
    var str_d3 = JSON.parse('${str_d3}');
    var node = str_d3['nodes'];
    var link = str_d3['edges'];
    var data = [];
    var edge = []
    //var cate = new Set();
    for (var i = 0; i < node.length; i++) {
        data.push({
            id: node[i].id,
            name: node[i].label,
            symbolSize: node[i].size + 10,
            itemStyle: {
                normal: {
                    color: node[i].color
                }
            },
            draggable: true,
            //	category:'' + node[i].cluster
        })

        //cate.add('' + node[i].cluster);
    }
    for (var i = 0; i < link.length; i++) {
        edge.push({
            source: link[i].sourceID,
            target: link[i].targetID
        })
    }
</script>
<script>
    var starttime = document.getElementById('starttime').value;
    var endtime = document.getElementById('endtime').value;
    var radius = document.getElementById('radius').value;
    var minPts = document.getElementById('minPts').value;
    var therehold = document.getElementById('therehold').value;
    function submiit() {
        var starttime = document.getElementById('starttime').value;
        var endtime = document.getElementById('endtime').value;
        var radius = document.getElementById('radius').value;
        var minPts = document.getElementById('minPts').value;
        var therehold = document.getElementById('therehold').value;
        window.location.href = "db_scan?starttime=" + starttime + "&endtime=" + endtime + "&radius=" + radius + "&minPts=" + minPts + "&therehold=" + therehold
    }
</script>
<script>

    var myChart = echarts.init(document.getElementById('main'));
    myChart.showLoading();
    myChart.hideLoading();
    myChart.setOption(option = {
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
                if (params.dataType == "node") {

                    var id = params.data.id,
                        result = "<span style='color:#C1FFC1'>名称：</span> " + id + "<br />";
                    $.ajax({
                        type: "post",
                        url: "ajax_stock",
                        data: {'name': id, "end": endtime, "str_d3": '<%=request.getAttribute("str_d3")%>'},
                        contentType: "application/x-www-form-urlencoded; charset=utf-8",
                        success: function (msg) {
                            result += msg;
                            callback(ticket, result);
                        },
                        error: function (msg) {
                            alert(msg)
                        }
                    });
                }
                return "loading";
            }
        },
        title: {
            text: '股东共现'
        },
        animationDurationUpdate: 1500,
        animationEasingUpdate: 'quinticInOut',
        series: [
            {
                force: { //力引导图基本配置
                    //initLayout: ,//力引导的初始化布局，默认使用xy轴的标点
                    repulsion: 2000,//节点之间的斥力因子。支持数组表达斥力范围，值越大斥力越大。
                    gravity: 0.3,//节点受到的向中心的引力因子。该值越大节点越往中心点靠拢。
                    edgeLength: 0,//边的两个节点之间的距离，这个距离也会受 repulsion。[10, 50] 。值越小则长度越长
                    layoutAnimation: true
                    //因为力引导布局会在多次迭代后才会稳定，这个参数决定是否显示布局的迭代动画，在浏览器端节点数据较多（>100）的时候不建议关闭，布局过程会造成浏览器假死。                        
                },
                type: 'graph',
                layout: 'force',
                // progressiveThreshold: 700,
                data: data,
                edges: edge,
                // categories:cate,
                label: {
                    emphasis: {
                        position: 'right',
                        show: true
                    }
                },
                roam: true,
                focusNodeAdjacency: true,
                lineStyle: {
                    normal: {
                        width: 0.8,
                        curveness: 0.3,
                        opacity: 0.7
                    }
                }
            }
        ]
    }, true);

</script>
</body>


</html>