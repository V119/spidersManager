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
            舆情影响力</div>
        </div>
        <ol class="breadcrumb page-breadcrumb pull-right">
          <li><i class="fa fa-home"></i>&nbsp;<a href="dashboard.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
          <li class="hidden"><a href="#">舆情影响力</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
          <li class="active">舆情影响力</li>
        </ol>
        <div class="clearfix">
        </div>
      </div>
      <!--END TITLE & BREADCRUMB PAGE-->

      <!--BEGIN CONTENT-->
      <div class="page-content" style="position:absolute; height:100%; overflow-y:auto" align="center">
        <!--END CONTENT-->

        <div id="main" style="width: 800px;height: 400px;margin-top:10%">
        <!--BEGIN FOOTER-->
        <jsp:include page="static/footer.jsp"/>
        <!--END FOOTER-->
      </div>
      <!--END PAGE WRAPPER-->
    </div>
  </div>

  <jsp:include page="static/footer_script.jsp"/>
  <script src="js/js1/echarts.min.js"></script>
  <script src="js/js3/echarts.min.js"></script><!--引入echarts.js-->
  <script type="text/javascript">
      <!--从后台传值到前台-->
      //豆瓣数据
      var arr_douban_num = [];
      var arr_douban_name = [];
      //人民网数据
      var arr_bbspeople_num = [];
      var arr_bbspeople_name = [];
      //凯迪社区
      var arr_kdnet_num = [];
      var arr_kdnet_name = [];
      //搜狐bbs
      var arr_bbssohu_num = [];
      var arr_bbssohu_name = [];
      //天涯bbs
      var arr_bbstianya_num = [];
      var arr_bbstianya_name = [];
      //西祠社区
      var arr_bbsxici_num = [];
      var arr_bbsxici_name = [];
      //猫扑社区
      var arr_bbsmop_num = [];
      var arr_bbsmop_name = [];
      //中华网社区
      var arr_bbschina_num = [];
      var arr_bbschina_name = [];
      //网易博客
      var arr_blog163_num = [];
      var arr_blog163_name = [];
      //博客
      var arr_blogsina_num = [];
      var arr_blogsina_name = [];
      //博客中国
      var arr_blogchina_num = [];
      var arr_blogchina_name = [];
      //中国社会新闻网
      var arr_xinwen_num = [];
      var arr_xinwen_name = [];
      //公共参数
      var arr_time = [];
      var data = [];
      data = ${commlist};
      var douban_i = 0;
      var people_i = 0;
      var kdnet_i = 0;
      var sohu_i = 0;
      var tianya_i = 0;
      var xici_i = 0;
      var mop_i = 0;
      var china_i = 0;
      var blog163_i = 0;
      var blogsina_i = 0;
      var blogchina_i = 0;
      var xinwen_i = 0;
      var alldata = 0;
      for (var o in ${commlist}){
          if(data[o].tableName == 'douban_group_post'){
              arr_douban_num[douban_i] = data[o].num;
              arr_douban_name[douban_i] = data[o].tableName;
              arr_time[douban_i] = data[o].startTime;
              douban_i ++;
          }else if(data[o].tableName == 'bbs_people_post'){
              arr_bbspeople_num[people_i] = data[o].num;
              arr_bbspeople_name[people_i] = data[o].tableName;
              people_i ++;
          }else if(data[o].tableName =='kdnet_post'){
              arr_kdnet_num[kdnet_i] = data[o].num;
              arr_kdnet_name[kdnet_i] = data[o].tableName;
              kdnet_i ++;
          }else if(data[o].tableName == 'bbs_sohu_post'){
              arr_bbssohu_num[sohu_i] = data[o].num;
              arr_bbssohu_name[sohu_i] = data[o].tableName;
              sohu_i ++;
          }else if(data[o].tableName == 'bbs_tianya_post'){
              arr_bbstianya_num[tianya_i] = data[o].num;
              arr_bbstianya_name[tianya_i] = data[o].tableName;
              tianya_i ++;
          }else if(data[o].tableName =='bbs_xici_post'){
              arr_bbsxici_num[xici_i] = data[o].num;
              arr_bbsxici_name[xici_i] = data[o].tableName;
              xici_i ++;
          }else if(data[o].tableName =='bbs_mop_post'){
              arr_bbsmop_num[mop_i] = data[o].num;
              arr_bbsmop_name[mop_i] = data[o].tableName;
              mop_i ++;
          }else if(data[o].tableName == 'bbs_china_post'){
              arr_bbschina_num[china_i] = data[o].num;
              arr_bbschina_name[china_i] = data[o].tableName;
              china_i ++;
          }else if(data[o].tableName =='blog_163_post'){
              arr_blog163_num[blog163_i] = data[o].num;
              arr_blog163_name[blog163_i] = data[o].tableName;
              blog163_i ++;
          }else if(data[o].tableName =='blog_sina_post'){
              arr_blogsina_num[blogsina_i] = data[o].num;
              arr_blogsina_name[blogsina_i] = data[o].tableName;
              blogsina_i ++;
          }else if(data[o].tableName == 'blogchina_blog'){
              arr_blogchina_num[blogchina_i] = data[o].num;
              arr_blogchina_name[blogchina_i] = data[o].tableName;
              blogchina_i ++;
          }else if(data[o].tableName =='xinwen110_news'){
              arr_xinwen_num[xinwen_i] = data[o].num;
              arr_xinwen_name[xinwen_i] = data[o].tableName;
              xinwen_i ++;
          }
      }
      for (var i = 0;i < douban_i; i++){
          data[i] = arr_douban_num[i] + arr_bbspeople_num[i]  + arr_bbssohu_num[i] + arr_bbstianya_num[i] + arr_bbsxici_num[i] + arr_kdnet_num[i] + arr_bbsmop_num[i] + arr_bbschina_num[i] + arr_blog163_num[i] + arr_blogsina_num[i] + arr_blogchina_num[i] + arr_xinwen_num[i];
      }
      //基于准备好的dom,初始化echarts实例
      var myChart = echarts.init(document.getElementById('main'));
      //指定图表的配置项和数据
      option = {
          tooltip : {
              trigger: 'axis',
              axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                  type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
              }
          },
          legend: {
              orient: 'horizontal',
              x:'center',
              data:['总评论量','豆瓣小组','人民网社区','凯迪社区','搜狐社区','天涯社区','西祠社区','猫扑社区','中华网论坛','网易博客','新浪博客','博客中国','中国社会新闻网']
          },
          grid: {
              left: '3%',
              right: '4%',
              bottom: '3%',
              containLabel: true
          },
          xAxis : [
              {
                  type : 'category',
                  data : arr_time,
                  axisLabel:{
                      //X轴刻度配置
                      interval:0 //0：表示全部显示不间隔；auto:表示自动根据刻度个数和宽度自动设置间隔个数
                  }
              }
          ],
          yAxis : [
              {
                  type : 'value'
              }
          ],
          series : [
              {
                  name:'总评论量',
                  type:'bar',
                  data: data,
                  markLine : {
                      lineStyle: {
                          normal: {
                              type:'dashed'
                          }
                      },
                      data : [
                      ]
                  }
              },
              {
                  name:'豆瓣小组',
                  type:'bar',
                  stack: '评论量',
                  data: arr_douban_num
              },
              {
                  name:'人民网社区',
                  type:'bar',
                  stack: '评论量',
                  data: arr_bbspeople_num
              },
              {
                  name:'凯迪社区',
                  type:'bar',
                  stack: '评论量',
                  data:[]
              },
              {
                  name:'搜狐社区',
                  type:'bar',
                  stack: '评论量',
                  data:arr_bbssohu_num
              },
              {
                  name: '天涯社区',
                  type:'bar',
                  stack: '评论量',
                  data: arr_bbstianya_num
              },
              {
                  name:'西祠社区',
                  type:'bar',
                  stack: '评论量',
                  data:arr_bbsxici_num
              },
              {
                  name:'猫扑社区',
                  type:'bar',
                  stack: '评论量',
                  data:arr_bbsmop_num
              },
              {
                  name:'中华网社区',
                  type:'bar',
                  stack: '评论量',
                  data:arr_bbschina_num
              },
              {
                  name:'网易博客',
                  type:'bar',
                  stack: '评论量',
                  data:arr_blog163_num
              },
              {
                  name:'新浪博客',
                  type:'bar',
                  stack: '评论量',
                  data:arr_blogsina_num
              },
              {
                  name:'博客中国',
                  type:'bar',
                  stack: '评论量',
                  data:arr_blogchina_num
              },
              {
                  name:'中国社会新闻网',
                  type:'bar',
                  stack: '评论量',
                  data:arr_xinwen_num
              }
          ]
      };
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
  </script>
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.ui.custom.js"></script>
  <script src="js/matrix.js"></script>
</body>
</html>
