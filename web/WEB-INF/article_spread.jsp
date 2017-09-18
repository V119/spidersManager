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
                        文章传播
                    </div>
                </div>
                <ol class="breadcrumb page-breadcrumb pull-right">
                    <li><i class="fa fa-home"></i>&nbsp;<a>Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="hidden"><a href="#">文章传播</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="active">文章传播分析</li>
                </ol>
                <div class="clearfix">
                </div>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->

            <!--BEGIN CONTENT-->
            <div class="page-content" align="center">
                <div id="main" style="width: 800px;height: 400px;margin-top: 10%" align="center"></div>

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
        //基于准备好的dom,初始化echarts实例
        var myChart = echarts.init(document.getElementById("main"));
        //指定图表的配置项和数据

        var category = JSON.parse('${category}');
        var nodesAndEdges = JSON.parse('${nodesAndEdges}');

        var nodes = nodesAndEdges['nodes'];
        var edges = nodesAndEdges['edges'];

        var titleMap = new Map();
        var numMap = new Map();
        var tableMap = new Map();
        var data = [];
        for (var i =0; i < nodes.length; i++) {
            titleMap.set(nodes[i]['id'], nodes[i]['title']);
            numMap.set(nodes[i]['id'], nodes[i]['num']);
            tableMap.set(nodes[i]['id'], nodes[i]['table']);

            data.push({
                "name": nodes[i]['id'],
                "symbolSize": (nodes[i]['num'] + 1) * 3,
                "draggable": true,
                "value": nodes[i]['title'],
                "category": nodes[i]['website'],
                "label": {
                    "normal": {
                        "show": true
                    }
                }
            });
        }

        option = {
            visualMap: {
                left: 'right',
                top: '10%',
                dimension: 1,
                min: 0,
                max: 50,
                itemWidth: 30,
                itemHeight: 120,
                calculable: true,
                precision: 0.1,
                text: ['圆形大小：PM2.5'],
                textGap: 30,
                textStyle: {
                    color: '#fff'
                },
                inRange: {
                    symbolSize: [10, 70]
                },
                outOfRange: {
                    symbolSize: [10, 70],
                    color: ['rgba(255,255,255,.2)']
                },
                controller: {
                    inRange: {
                        color: ['#c23531']
                    },
                    outOfRange: {
                        color: ['#444']
                    }
                }
            },
            tooltip: {
                show: true,
                position: function (pos, params, dom, rect, size) {
                    // 鼠标在左侧时 tooltip 显示到右侧，鼠标在右侧时 tooltip 显示到左侧。
                    var obj = {top: 60};
                    obj[['left', 'right'][+(pos[0] < size.viewSize[0] / 2)]] = 5;
                    return obj;
                },
                hideDelay: 250,
                formatter: function (params, ticket, callback) {
                    var result = '';
                    if (params.dataType == 'node') {
                        var id = params.name;
                        result = "<span style='color: sienna'>标题：</span> " + titleMap.get(id).replace(/(.{25})/g,'$1<br />') + "<br />";
                        result += "<span style='color: #1e23d5'>相关文章数：</span> ";
                        result += numMap.get(id);
                        result += "<br />";

//                    $.get('tooltipContent?table=' + tableMap.get(id) + '&articleID=' + id, function (content) {
//                        result += content;
//                        callback(ticket, result);
//                    });
                        $.ajax({
                            type : "post",
                            url : "tooltipContent",
                            data : {'table' : tableMap.get(id), 'articleID' : id},
                            contentType: "application/x-www-form-urlencoded; charset=utf-8",
                            success : function (msg) {
                                var content = msg.replace(/(.{30})/g,'$1<br />'); //换行显示
                                result += content;
                                callback(ticket, result);
                            },
                            error : function (msg) {
                                alert(msg)
                            }
                        });
                        return 'Loading';
                    } else {
                        var src_id = params.data.source;
                        var tar_id = params.data.target;
                        result = "<span style='color: #b90c25'>source:</span> " + titleMap.get(src_id) + "  <span style='color: #5eb95e'>" + numMap.get(src_id) + "</span>";
                        result += "<br />"
                        result += "<span style='color: #d54ac9'>target: </span>" + titleMap.get(tar_id) + "  <span style='color: #5eb95e'>" + numMap.get(tar_id) + "</span>";

                        return result;
                    }
                }
            },
            toolbox: {
                show: true,
                feature: {
                    dataView: {
                        show: true,
                        readOnly: true
                    },
                    restore: {
                        show: true
                    },
                    saveAsImage: {
                        show: true
                    }
                }
            },
            animationDuration: 1500,
            animationEasingUpdate: 'quinticInOut',
            series: [{
//            name: '媒体',
                type: 'graph',
                layout: 'force',

                force: {
                    initLayout:'circular',
                    edgeLength: 50,
                    repulsion: 50,
                    gravity: 0.2,
                    layoutAnimation : true
                },
                data: data,
                edges: edges,
                categories: category,
                focusNodeAdjacency: true,
                roam: true,
                label: {
                    normal: {
                        textStyle: {
                            color: ["#327df8"]
                        },
                        show: true,
                        position: 'right',
                        formatter: '{c}'
                    }
                },
                edgeSymbol:['none', 'arrow'],
                lineStyle: {
                    normal: {
                        color: {
                            type: 'linear',
                            x: 0,
                            y: 0,
                            x2: 0,
                            y2: 1,
                            colorStops: [{
                                offset: 0, color: 'black' // 0% 处的颜色
                            }, {
                                offset: 1, color: 'blue' // 100% 处的颜色
                            }],
                            globalCoord: false // 缺省为 false
                        },
                        width: 2
                    }
                }
            }]
        };
        myChart.setOption(option)
    </script>
</body>
</html>
