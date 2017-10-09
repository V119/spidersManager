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
    <style>

        .link {
            fill: none;
            stroke: #666;
            stroke-width: 1.5px;
        }

        #licensing {
            fill: green;
        }

        .link.licensing {
            stroke: green;
        }

        .link.resolved {
            stroke-dasharray: 0,2 1;
        }

        circle {
            fill: #ffffff;
            stroke: none;
            stroke-width: 1.5px;
        }

        text {
            font: 10px sans-serif;
            pointer-events: none;
            text-shadow: 0 1px 0 #fff, 1px 0 0 #fff, 0 -1px 0 #fff, -1px 0 0 #fff;
        }


        .axis path,
        .axis line{
            fill: none;
            stroke: black;
            shape-rendering: crispEdges;
        }

        .axis text {
            font-family: sans-serif;
            font-size: 11px;
        }




    </style>


    <jsp:include page="static/head_jsp.jsp"/>
</head>
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
            <div >

                <div id="w" style="float:left; margin:150px 0px 0px 40px "></div>

                <div ><svg id="svg" width="1300" height="700"></svg></div>
                <!--BEGIN FOOTER-->
                <jsp:include page="static/footer.jsp"/>
                <!--END FOOTER-->
            </div>
            <!--END PAGE WRAPPER-->
        </div>
    </div>

</div>

<jsp:include page="static/footer_script.jsp"/>

<script src="//d3js.org/d3.v3.min.js"></script>
<script>

    var category = JSON.parse('${category}');
    var categories = [];

    for (var c_num = 0; c_num < category.length;  c_num++) {
        categories[c_num] = {
            name: category[c_num]
        }
    }

    var nodesAndEdges = JSON.parse('${nodesAndEdges}');
    var edges=nodesAndEdges['edges'];

    var nodes = nodesAndEdges['nodes'];//顶点表

    var links = edges[2];//边表

    //不同阈值下的SNA列表
    var SNAList = JSON.parse('${SNAList}');//会导致$ref错误
    var graphSNA =SNAList[2]['graphSNA'];
    var nodeSNAList =SNAList[2]['nodeSNAList'];


    var map = new Map();
    for (var i = 0; i < nodes.length; i++) {
        map.set(nodes[i]['id'], nodes[i]);
    }


    // Compute the distinct nodes from the links.
    links.forEach(function(link,index) {
        nodes.splice(index, 1);//删除重复的

        link.source = nodes[link.source] || (nodes[link.source] = {id: link.source});
        link.target = nodes[link.target] || (nodes[link.target] = {id: link.target});

    });


    var width = 1200,
        height = 700;

    var svg = d3.select("#svg"),
        width = +svg.attr("width"),
        height = +svg.attr("height");

    var force = d3.layout.force()
        .nodes(d3.values(nodes))
        .links(links)
        .size([width, height])
        .linkDistance(180)
        .charge(-180)
        .on("tick", tick)
        .start();

    //图的参数
    var graphIndex = d3.select("#w")
        .append("div")
        . style("position","absolute")
        . style("z-index","10")
        . style("background","rgba(0, 0, 0, 0.8)")
        . style("color","#fff")
        . style("visibility","visible")
        . style(" padding","30px");

    graphIndex.html(" 度数中心势  "+graphSNA['degreeCentralization']+"<br />"
        +" 接近中心势  "+graphSNA['closeCentralization']+"<br />"
        +" 图规模  "+graphSNA['scale']+"<br />"
        +" 图密度  "+graphSNA['density']+"<br />"
        +" 直径  "+graphSNA['diameter']+"<br />"
        +" 平均长度  "+graphSNA['averageength']+"<br />"
        +" 关联度  "+graphSNA['correlationDegree']+"<br />"
        +" 等级度  "+graphSNA['rankDegree']+"<br />"
    )


    //点的参数
    var tooltip = d3.select("body")
        . append("div")
        . style("position","absolute")
        . style("z-index","10")
        . style("background","rgba(0, 0, 0, 0.8)")
        . style("color","#fff")
        . style("visibility","hidden")
        . style(" padding","12px");

    var color = d3.scale.category10();

    var circle = svg.append("g")
        .selectAll("circle")
        .data(force.nodes())
        .enter().append("circle")
        .attr("r", 10)
        .style("fill", function(d) { return color(map.get(d.id).website); })
        .on("mouseover", function(d){

            path.style("stroke-width",function(p){
                    if(p.source.id==d.id || p.target.id==d.id){
                        return 4;
                    }else{
                        return 1.5;
                    }
                }
            );

            tooltip.html("标题 "+map.get(d.id).title+"<br />"
                +"网站  "+map.get(d.id).website+"<br />"
                +"出度  "+nodeSNAList[d.id]['outdegree']+"<br />"
                +"入度  "+nodeSNAList[d.id]['indegree']+"<br />"
                +"相对中心度  "+nodeSNAList[d.id]['relativeCentrality']+"<br />"
                +"绝对接近中心度  "+nodeSNAList[d.id]['aCloseCentrality']+"<br />"
                +"相对接近中心度  "+nodeSNAList[d.id]['rCloseCentrality']+"<br />"
            );
            tooltip.style("visibility","visible");


        })
        .on("mousemove", function(){return tooltip.style("top",
            (d3.event.pageY-10)+"px").style("left",(d3.event.pageX+10)+"px");})
        .on("mouseout", function(){
            tooltip.style("visibility","hidden");

        })
        .call(force.drag);

    //箭头
    svg.append("defs").selectAll("marker")
        .data(["resolved"])
        .enter().append("marker")
        .attr("id", function(d) { return d; })
        .attr("viewBox", "0 -5 10 10")
        .attr("refX", 15)
        .attr("refY", -1.5)
        .attr("markerWidth", 4)
        .attr("markerHeight", 4)
        .attr("orient", "auto")
        .append("path")
        .attr("d", "M0,-5L10,0L0,5");

    //文字
    var text = svg.append("g").selectAll("text")
        .data(force.nodes())
        .enter().append("text")
        .attr("x", 8)
        .attr("y", ".31em")
        .text(function(d) { return map.get(d.id).title; });

    //连线
    var path = svg.append("g").selectAll("path")
        .data(force.links())
        .enter().append("path")
        .attr("class", function(d) { return "link " + d; })
        .attr("marker-end", "url(#resolved)");


    function tick() {
        path.attr("d", linkArc);
        circle.attr("transform", transform);
        text.attr("transform", transform);
    }
    function linkArc(d) {
        var dx = d.target.x - d.source.x,
            dy = d.target.y - d.source.y,
            dr = Math.sqrt(dx * dx + dy * dy);
        return "M" + d.source.x + "," + d.source.y + "A" + dr + "," + dr + " 0 0,1 " + d.target.x + "," + d.target.y;
    }
    function transform(d) {
        return "translate(" + d.x + "," + d.y + ")";
    }


    //添加图例
    var legend=svg.append("g");
    addLegend();
    function addLegend()
    {
        legend.selectAll("rect")
            .data(categories)
            .enter()
            .append("rect")
            .attr("x", function(d,i) {return (i+3)*100-20;})
            .attr("y",10)
            .attr("rx",5)
            .attr("ry",5)
            .attr("width",20)
            .attr("height",12)
            .attr("fill",function(d){ return color(d.name);});
        legend.attr("transform","translate("+((categories.length*100)/2)+","+")");

        var textGroup=legend.selectAll("text")
            .data(categories);
        textGroup.exit().remove();
        legend.selectAll("text")
            .data(categories)
            .enter()
            .append("text")
            .text(function(d){return "   "+d.name;})
            .attr("class","legend")
            .attr("x", function(d,i) {return (i+3)*100;})
            .attr("y",20)
            .attr("fill",function(d){ return d.name});
    }



    //添加阈值选择条
    var xScale = d3.scale.linear()
        .domain([0,1])
        .range([0,500]);


    var axis = d3.svg.axis()
        .scale(xScale)
        .orient("bottom");

    svg.append("g")
        .attr("class","axis")
        .attr("transform","translate(500,680)")
        .call(axis);


    var option=[0.0,0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1.0];


    var optionCircle = svg.append("g")    //这一句必须得有
        .selectAll("circle")
        .data(option)
        .enter()
        .append("circle")
        .attr("r",8)
        .style("stroke","#666")
        .attr("cx",function(d){
            return 500+xScale(d);

        })
        .attr("cy",680)
        .on("click", function(d,i){
            optionCircle.style("fill","white");
            d3.select(this).style("fill","red");

            //###################################

            update(i)



        });



    function update(i) {

        path.remove();
        circle.remove();
        text.remove();

        links = edges[i];//更新边表
        nodes = nodesAndEdges['nodes'];//顶点表

        graphSNA =SNAList[i]['graphSNA'];
        nodeSNAList =SNAList[i]['nodeSNAList'];



        links.forEach(function(link,index) {

            link.source = nodes[link.source] || (nodes[link.source] = {id: link.source});
            link.target = nodes[link.target] || (nodes[link.target] = {id: link.target});

            nodes.splice(index, 1);//删除重复的

        });


        svg = d3.select("#svg"),
            width = +svg.attr("width"),
            height = +svg.attr("height");

        force = d3.layout.force()
            .nodes(d3.values(nodes))
            .links(links)
            .size([width, height])
            .linkDistance(180)
            .charge(-180)
            .on("tick", tick)
            .start();


        circle = svg.append("g")
            .selectAll("circle")
            .data(force.nodes())
            .enter().append("circle")
            .attr("r", 10)
            .style("fill", function(d) { return color(map.get(d.id).website); })
            .on("mouseover", function(d){

                path.style("stroke-width",function(p){
                        if(p.source.id==d.id || p.target.id==d.id){
                            return 4;
                        }else{
                            return 1.5;
                        }
                    }
                );
                path.style("stroke",function(y) {

                        if(y.source.id==node.id || y.target.id==node.id){
                            return "red";
                        }else{
                            return "#666";
                        }
                    }
                );
                tooltip.html("标题 "+map.get(d.id).title+"<br />"
                    +"网站  "+map.get(d.id).website+"<br />"
                    +"出度  "+nodeSNAList[d.id]['outdegree']+"<br />"
                    +"入度  "+nodeSNAList[d.id]['indegree']+"<br />"
                    +"相对中心度  "+nodeSNAList[d.id]['relativeCentrality']+"<br />"
                    +"绝对接近中心度  "+nodeSNAList[d.id]['aCloseCentrality']+"<br />"
                    +"相对接近中心度  "+nodeSNAList[d.id]['rCloseCentrality']+"<br />"
                );
                tooltip.style("visibility","visible");


            })
            .on("mousemove", function(){return tooltip.style("top",
                (d3.event.pageY-10)+"px").style("left",(d3.event.pageX+10)+"px");})
            .on("mouseout", function(){
                tooltip.style("visibility","hidden");

            })
            .call(force.drag);

        path = svg.append("g").selectAll("path")
            .data(force.links())
            .enter().append("path")
            .attr("class", function(d) { return "link " + d; })
            .attr("marker-end", "url(#resolved)");

        text = svg.append("g").selectAll("text")
            .data(force.nodes())
            .enter().append("text")
            .attr("x", 8)
            .attr("y", ".31em")
            .text(function(d) { return map.get(d.id).title; });


        graphIndex.html(" 度数中心势  "+graphSNA['degreeCentralization']+"<br />"
            +" 接近中心势  "+graphSNA['closeCentralization']+"<br />"
            +" 图规模  "+graphSNA['scale']+"<br />"
            +" 图密度  "+graphSNA['density']+"<br />"
            +" 直径  "+graphSNA['diameter']+"<br />"
            +" 平均长度  "+graphSNA['averageength']+"<br />"
            +" 关联度  "+graphSNA['correlationDegree']+"<br />"
            +" 等级度  "+graphSNA['rankDegree']+"<br />"
        )

    }




</script>
</body>
</html>