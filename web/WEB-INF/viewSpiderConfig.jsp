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
        <jsp:include page="static/leftNav_one.jsp"/>
        <!--END SIDEBAR MENU-->

        <!--BEGIN PAGE WRAPPER-->
        <div id="page-wrapper">
            <!--BEGIN TITLE & BREADCRUMB PAGE-->
            <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
                <div class="page-header pull-left">
                    <div class="page-title">
                        可视化爬虫配置</div>
                </div>
                <ol class="breadcrumb page-breadcrumb pull-right">
                    <li><xi class="fa fa-home"></x i>&nbsp;<a>爬虫管理</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="hidden"><a href="#">可视化爬虫配置</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="active">可视化爬虫配置</li>
                </ol>
                <div class="clearfix">
                </div>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->

            <!--BEGIN CONTENT-->
            <div class="page-content" style="position:absolute; height:100%; overflow-y:auto">
                <div class="panel panel-grey" style="width:auto;margin-top: 3%;">
                    <div class="panel-heading">可视化爬虫配置</div>
                    <div class="panel-body">
                        <table class="table table-hover table-bordered">
                            <thead align="right">
                            <tr>
                                <th width="20%">配置项</th>
                                <th width="25%">名称</th>
                                <th>值</th>
                                <th width="35%">备注</th>
                                <th width="10%">操作</th>

                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                            <%--<input value="${fn:length(spiderInfoList)}" id="info-length" hidden="hidden" />--%>
                            <%--<c:forEach var="spiderInfo" items="${spiderInfoList}" varStatus="status">--%>
                            <tr>
                                <td>配置项配置项配置项配置项</td>
                                <td>名称名称名称名称名称名称名称</td>
                                <td>值值值值值值</td>
                                <td>备注备注备注备注</td>
                                <td><a href="#" class="todo-complete"><i class="fa fa-check"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="javascript:updateSpiderConfig('${spiderInfo[0].id}');" class="todo-edit">
                                    <i class="fa fa-edit"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="deleteSpiderConfig(id)" class="todo-remove"><i class="fa fa-trash-o">
                                </i></a></td>

                            </tr>
                            <tr>
                                <td>配置项配置项配置项配置项名称名称名称</td>
                                <td>名称名称名称名称名称名称名称名称名称名称</td>
                                <td>值值值值值值</td>
                                <td>备注备注备注备注</td>
                                <td><a href="#" class="todo-complete"><i class="fa fa-check"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="javascript:updateSpiderConfig('${spiderInfo[0].id}');" class="todo-edit">
                                    <i class="fa fa-edit"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="deleteSpiderConfig(id)" class="todo-remove"><i class="fa fa-trash-o">
                                </i></a></td>

                            </tr>
                            <tr>
                                <td>配置项配置项配置项配置项名称名称名称</td>
                                <td>名称名称名称名称名称名称名称名称名称名称</td>
                                <td>值值值值值值</td>
                                <td>备注备注备注备注</td>
                                <td><a href="#" class="todo-complete"><i class="fa fa-check"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="javascript:updateSpiderConfig('${spiderInfo[0].id}');" class="todo-edit">
                                    <i class="fa fa-edit"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="deleteSpiderConfig(id)" class="todo-remove"><i class="fa fa-trash-o">
                                </i></a></td>

                            </tr>
                            <%--</c:forEach>--%>
                            </tr>


                            </tbody>
                        </table>
                    </div>
                </div>
                <!--END CONTENT-->


                <!--BEGIN FOOTER-->
                <jsp:include page="static/footer.jsp"/>
                <!--END FOOTER-->
            </div>
            <!--END PAGE WRAPPER-->
        </div>
    </div>
    <script>

        function updateSpiderConfig(id) {
            window.location.href = "updateSpiderConfig?spiderID=" + id;
        }
        function addConfig(id) {
            window.location.href = "spiderConfig?spiderID=" + id;
        }
        function deleteSpiderConfig(id) {
            window.location.href = "deleteSpiderConfig?spiderID=" + id;
        }
    </script>
    <script>
        var info_length = $("#info-length").attr("value");

        $(function () {
            for(var i = 0; i < info_length; i++) {
                (function (i) {
                    var spider_id =$("#title_" + i).attr("data-spider");
                    $.ajax({
                        type : "post",
                        url : "getConfigItem",
                        data : {'spider_id' : spider_id},
                        success : function (msg) {
                            console.log(i);
                            var msgJson = JSON.parse(msg);

                            var result = msgJson.result;

                            if(result == "success") {
                                var dataMap = msgJson.data;
                                var configMap = msgJson.config;
                                var html_code = jointConfig(spider_id, dataMap, configMap);
                                $("#collapse_" + i).append(html_code);
                            } else {

                            }
                        },
                        error : function (msg) {
                            alert(msg)
                        }
                    })

                }(i))

            }
        }());

        var jointConfig = function(spider_id, dataMap, configMap) {
            if(dataMap == undefined || dataMap == '') {
//            return '<div class="widget-content">' +
//                        '<h5>没有配置项</h5>' +
//                        '<button class="btn btn-info">添加配置项</button>' +
//                        '<button class="btn btn-success">以默认配置运行</button>' +
//                    '</div>';
                return '<div class="widget-content">' +
                    '<h5>查询数据出错，请重新刷新！！</h5>' +
                    '</div>';
            }

            var html = '';
            for(var key in dataMap) {
                html = html + '<div class="widget-content">' +
                    '<div class="widget-box">' +
                    '<div class="widget-content nopadding">' +
                    '<table class="table table-striped table-bordered">' +
                    '<thead>' +
                    '<tr>' +
                    '<th>配置项</th>' +
                    '<th>名称</th>' +
                    '<th>值</th>' +
                    '<th>备注</th>' +
                    '<th>Opts</th>' +
                    '</tr>' +
                    '</thead>' +
                    '<tbody>';
                var configList = dataMap[key];
                for(var i = 0; i < configList.length; i++) {
                    html = html + '<tr>' +
                        '<td class=""><i class="icon-ok-sign"></i> 配置项 '+ ( i + 1 ) +'</td>' +
                        '<td class="taskStatus"><span class="in-progress">' + configList[i][1].displayName + '</span></td>' +
                        '<td class="taskStatus"><span class="in-progress">' + configList[i][0].configItemValue + '</span></td>' +
                        '<td class="taskDesc">' + configList[i][1].remark + '</td>' +
                        '<td class="taskOptions">' +
                        '<a href="#" class="tip-top" data-original-title="Update">' +
                        '<i class="icon-ok"></i></a> ' +
                        '<a href="#" class="tip-top" data-original-title="Delete">' +
                        '<i class="icon-remove"></i></a>' +
                        '</td>' +
                        '</tr>';
                }

                html = html + '</tbody>' +
                    '</table>' +
                    '</div>' +
                    '</div>'
                //爬虫是否正在运行
                if(configMap[key].status == "running") {
                    html = html + '<button id="btn_' + key +'" class="btn btn-danger" onclick="runSpider(\'' + spider_id + '\', \'' + key + '\')" disabled="disabled">正在运行</button>'
                } else {
                    html = html + '<button id="btn_' + key +'" class="btn btn-success" onclick="runSpider(\'' + spider_id + '\', \'' + key + '\')">运行</button>'
                }
                html += '<button class="btn btn-info"  onclick="addConfig(\'' + spider_id + '\')">添加配置项</button>';
                html += '</div>';
            }

            if(html == '') {
                return '<div class="widget-content">' +
                    '<h5>没有配置项</h5>' +
                    '<button class="btn btn-info"  onclick="addConfig(\'' + spider_id + '\')">添加配置项</button>' +
                    //                        '<button class="btn btn-success">以默认配置运行</button>' +
                    '</div>';
            }

            return html
        };

        function runSpider(spiderID, configID) {
            $.ajax({
                type : "post",
                url : "runSpider",
                data : {
                    'spiderID' : spiderID,
                    'configID' : configID
                },
                success : function (msg) {
                    if(msg == 'ERROR') {
                        alert('运行失败！！');
                    } else {
                        alert('运行成功！！');
                        $("#btn_" + configID).text('正在运行');
//                    $("#btn_" + configID).removeClass().addClass("btn btn-danger");
                        $("#btn_" + configID).attr("class","btn btn-danger");
                        $("#btn_" + configID).attr('disabled',"true");
                    }
                },
                error : function (msg) {
                    alert(msg)
                }
            })
        }

        function addConfig(id) {
            window.location.href = "spiderConfig?spiderID=" + id;
        }

    </script>
    <jsp:include page="static/footer_script.jsp"/>

</body>
</html>
