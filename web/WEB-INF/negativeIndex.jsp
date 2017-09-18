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
                        舆情负面指数</div>
                </div>
                <ol class="breadcrumb page-breadcrumb pull-right">
                    <li><i class="fa fa-home"></i>&nbsp;<a href="dashboard.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="hidden"><a href="#">舆情负面指数</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                    <li class="active">舆情负面指数</li>
                </ol>
                <div class="clearfix">
                </div>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->

            <!--BEGIN CONTENT-->
            <div class="page-content" align="center">
                <!--END CONTENT-->

                <div id= "main" style="width:1100px;height:550px;margin-top:10%">
                    <!--BEGIN FOOTER-->
                    <jsp:include page="static/footer.jsp"/>
                    <!--END FOOTER-->
                </div>
                <!--END PAGE WRAPPER-->
            </div>
        </div>

        <jsp:include page="static/footer_script.jsp"/>
        <script src="js/js3/echarts.min.js"></script><!--引入echarts.js-->
        <script type="text/javascript">
            <!--从后台传值到前台-->
            //豆瓣数据
            var arr_douban_index = [];
            var arr_douban_name = [];
            //人民网数据
            var arr_bbspeople_index = [];
            var arr_bbspeople_name = [];
            //搜狐bbs
            var arr_bbssohu_index = [];
            var arr_bbssohu_name = [];
            //公共参数
            var arr_time = [];
            var data = [];
            data = ${indexList};
            var douban_i = 0;
            var people_i = 0;
            var sohu_i = 0;
            var alldata = 0;
            for(var o in ${indexList}){
                if(data[o].tableName == 'douban_group_post'){
                    arr_douban_index[douban_i] = data[o].index;
                    arr_douban_name[douban_i] = data[o].tableName;
                    arr_time[douban_i] = data[o].startTime;
                    douban_i ++;
                }else if(data[o].tableName == 'bbs_people_post'){
                    arr_bbspeople_index[people_i] = data[o].index;
                    arr_bbspeople_name[people_i] = data[o].tableName;
                    people_i ++;
                }else if(data[o].tableName == 'bbs_sohu_post'){
                    arr_bbssohu_index[sohu_i] = data[o].index;
                    arr_bbssohu_name[sohu_i] = data[o].tableName;
                    sohu_i ++;
                }
            }
            for(var i=0;i < douban_i; i++){
                data[i] = arr_douban_index[i] + arr_bbspeople_index[i] + arr_bbssohu_index[i] ;
            }
            //基于准备好的dom，初始化echarts实例
            var myChart =echarts.init(document.getElementById('main'));
            var option = {
                title: {
                    text: '舆情负面指数',
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data:['总舆情负面指数','豆瓣小组指数','人民网社区指数','搜狐社区指数','天涯社区指数','西祠社区指数','猫扑社区指数','中华网社区指数','网易博客指数','博客指数','博客中国指数','三秦网指数']
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: arr_time,
                    axisLabel:{
                        //X轴刻度配置
                        interval:0 //0：表示全部显示不间隔；auto:表示自动根据刻度个数和宽度自动设置间隔个数
                    }
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        name:'总舆情负面指数',
                        type:'line',
                        data: data,
                        markLine : {
                            lineStyle: {
                                normal: {
                                    type:'dashed'
                                }
                            }
                        },
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        },
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
                            ]
                        }
                    },
                    {
                        name:'豆瓣小组指数',
                        type:'line',
                        stack: '舆情负面指数',
                        data:arr_douban_index
                    },
                    {
                        name:'人民网社区指数',
                        type:'line',
                        stack: '舆情负面指数',
                        data:arr_bbspeople_index
                    },
                    {
                        name:'搜狐社区指数',
                        type:'line',
                        stack: '舆情负面指数',
                        data:arr_bbssohu_index
                    }
                    /*,
                    {
                        name:'天涯社区指数',
                        type:'line',
                        stack: '舆情负面指数',
                        data:[0.2, 0.3, 0.2, 0.4, 0.0, 0.1, 0.3]
                    },
                    {
                        name:'西祠社区指数',
                        type:'line',
                        stack: '总量',
                        data:[0.3, 0.2, 0.11, 0.4, 0.4, 0.5, 0.2]
                    }
                    ,
                    {
                        name:'猫扑社区指数',
                        type:'line',
                        stack: '舆情负面指数',
                        data:[820, 932, 901, 934, 1290, 1330, 1320]
                    }
                    ,
                    {
                        name:'中华网社区指数',
                        type:'line',
                        stack: '舆情负面指数',
                        data:[820, 932, 901, 934, 1290, 1330, 1320]
                    },
                    {
                        name:'网易博客指数',
                        type:'line',
                        stack: '舆情负面指数',
                        data:[820, 932, 901, 934, 1290, 1330, 1320]
                    },
                    {
                        name:'博客指数',
                        type:'line',
                        stack: '舆情负面指数',
                        data:[0.1, 0.22, 0.3, 0.3, 0.2, 0.3, 0.9]
                    },
                    {
                        name:'博客中国指数',
                        type:'line',
                        stack: '舆情负面指数',
                        data:[0.3, 0.2, 0.1, 0.4, 0.3, 0.4, 0.5]
                    }
                    ,
                    {
                        name:'三秦网指数',
                        type:'line',
                        stack: '舆情负面指数',
                        data:[0.12, 0.2, 0.1, 0.24, 0.4, 0.3, 0.2]
                    }
         */
                ]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        </script>
        <!--Echarts end-->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.ui.custom.js"></script>
        <script src="js/matrix.js"></script>
</body>
</html>
