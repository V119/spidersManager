<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>舆情分析大平台</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/matrix-style.css" />
    <link rel="stylesheet" href="css/matrix-media.css" />
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
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
                href="#" class="current">文章传播图</a></div>
        <h1>文章传播分析</h1>
        <hr>
    </div>
    <!--为Echarts准备一个具备大小（宽高）的Dom-->
    <div id="main" style="width: 1200px;height: 800px;"></div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/js1/echarts.min.js"></script><!--引入echarts.js-->
<script src="js/js1/echarts-wordcloud.min.js"></script>
<script  type="text/javascript">
    //基于准备好的dom,初始化echarts实例
    var myChart = echarts.init(document.getElementById("main"));
    //指定图表的配置项和数据

    var category = JSON.parse('${category}');
    var categories = [];

    for (var c_num = 0; c_num < category.length;  c_num++) {
        categories[c_num] = {
            name: category[c_num]
        }
    }

    var nodesAndEdges = JSON.parse('${nodesAndEdges}');

    var nodes = nodesAndEdges['nodes'];
    var edges = nodesAndEdges['edges'];

    var titleMap = new Map();
    var numMap = new Map();
    var tableMap = new Map();

    //获取每个阈值下节点的最大值
    var max_num = [];
    var slice_num = nodes[0]['num'].length;
    for(var x = 0; x < slice_num; x++) {
        max_num[x] = 0;
        for (var xi = 0; xi < nodes.length; xi++) {
            if(nodes[xi]['num'][x] > max_num[x]) {
                max_num[x] = nodes[xi]['num'][x];
            }
        }
    }

    var dataSliceList = [];
    var layout = [];
    for(var y = 0; y < slice_num; y++) {

        //第一张采用环形布局，其余的采用力导向图
        if (y === 0) {
            layout.push('circular');
        } else {
            layout.push('force');
        }

        var data = [];
        for (var i = 0; i < nodes.length; i++) {
            if (y === 0) {
                titleMap.set(nodes[i]['id'], nodes[i]['title']);
                numMap.set(nodes[i]['id'], nodes[i]['num']);
                tableMap.set(nodes[i]['id'], nodes[i]['table']);
            }

            data.push({
                "name": nodes[i]['id'],
                "symbolSize": (nodes[i]['num'][y] + 1) / (max_num[y] + 1),
                "draggable": true,
                "value": [nodes[i]['title'], nodes[i]['num'][y]],
                "category": nodes[i]['website'],
                "label": {
                    "normal": {
                        "show": true
                    }
                }
            });
        }
        dataSliceList.push(data)
    }

    var edgeOptions = [];
    for(var ii = 0; ii < slice_num; ii++) {
        edgeOptions.push({
            visualMap: {
                max: max_num[ii]
            },
            series: {
                layout: layout[ii],
                edges: edges[ii],
                data: dataSliceList[ii]
            }
        })
    }

    var timeLineData = [];
    for(var s = 0; s <= 1; s += 0.1) {
        timeLineData.push(s.toFixed(1))
    }
    option = {
        baseOption: {
            timeline: {
                data: timeLineData,
                axisType: 'category',
                currentIndex: 4
            },
            visualMap: {
                left: 'right',
                top: '10%',
                dimension: 1,
                hoverLink: true,
                min: 0,
//                max: max_num,
                itemWidth: 30,
                itemHeight: 120,
                calculable: true,
                precision: 1,
                text: ['大小'],
                textGap: 30,
                textStyle: {
                    color: '#b90c25'
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
                        color: ['#a2c6f8']
                    },
                    outOfRange: {
                        color: ['#444']
                    }
                }
            },
            tooltip: {
                show: true,
//                position: function (pos, params, dom, rect, size) {
//                    // 鼠标在左侧时 tooltip 显示到右侧，鼠标在右侧时 tooltip 显示到左侧。
//                    var obj = {top: 60};
//                    obj[['left', 'right'][+(pos[0] < size.viewSize[0] / 2)]] = 5;
//                    return obj;
//                },
                hideDelay: 600,
                formatter: function (params, ticket, callback) {
                    var result = '';
                    if (params.dataType == 'node') {
                        var id = params.name;
                        result = "<span style='color: sienna'>标题：</span> " + titleMap.get(id).replace(/(.{25})/g, '$1<br />') + "<br />";
//                        result += "<span style='color: #1e23d5'>相关文章数：</span> ";
//                        result += numMap.get(id);
//                        result += "<br />";

                        //                    $.get('tooltipContent?table=' + tableMap.get(id) + '&articleID=' + id, function (content) {
                        //                        result += content;
                        //                        callback(ticket, result);
                        //                    });
                        $.ajax({
                            type: "post",
                            url: "tooltipContent",
                            data: {'table': tableMap.get(id), 'articleID': id},
                            contentType: "application/x-www-form-urlencoded; charset=utf-8",
                            success: function (msg) {
//                                var content = msg.replace(/(.{30})/g, '$1<br />'); //换行显示

                                var newStr = '';
                                if(msg.length <= 30) {
                                    newStr = msg;
                                }
                                var t = 30;
                                for (; t < msg.length; t+=30) {
                                    var tmp = msg.substring(t - 30, t);
                                    newStr = newStr + '<br />' + tmp;
                                }
                                result = result + newStr + "<br />" + msg.substring(t - 30, msg.length);
                                callback(ticket, result);
                            },
                            error: function (msg) {
                                alert(msg)
                            }
                        });
                        return 'Loading';
                    } else if (params.dataType == 'edge') {
                        var src_id = params.data.source;
                        var tar_id = params.data.target;
                        result = "<span style='color: #b90c25'>source:</span> " + titleMap.get(src_id);
                        result += "<br />"
                        result += "<span style='color: #d54ac9'>target: </span>" + titleMap.get(tar_id);

                        return result;
                    }
                }
            },
            legend: [{
                // selectedMode: 'single',
                data: categories.map(function (a) {
                    return a.name;
                })
            }],
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
//                layout: 'force',

                force: {
                    initLayout: 'circular',
                    edgeLength: 100,
                    repulsion: 300,
                    gravity: 0.2,
                    layoutAnimation: true
                },
//                data: data,
//                edges: edges,
                categories: categories,
                focusNodeAdjacency: true,
                roam: true,
                label: {
                    normal: {
                        textStyle: {
                            color: ["#bda29a"],
                            fontStyle: 'oblique',
                            fontWeight: 'lighter'
                        },
                        show: false,
                        position: 'right',
                        formatter: function (params) {
                            return params.value[0];
                        }
                    }
                },
                edgeSymbol: ['none', 'arrow'],
                lineStyle: {
                    normal: {
                        color: "source",
                        width: 3,
                        curveness: 0.3
                    }
                }
            }]
        },

        options:edgeOptions
    };
    myChart.setOption(option)
</script>
</body>
</html>
