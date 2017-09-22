<%@ page language="java" import="java.util.*,com.dbEntity.DrawData" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="js/ichart.1.2.min.js"></script>
    <script type="text/javascript">
    
			$(function(){
				var name=document.getElementById("name").value;
			    var namecount=document.getElementById("namecount").value;
			    var n=name.split("$");
			    var nc=namecount.split("$");
			    
			    var data=[];
			    for(var i=0;i<n.length-1;i++)
			    {
			    	var a={};
			    	a.name=n[i];
			    	a.value=nc[i];
			    	a.color="#6A5ACD";
			    	data.push(a);
			    }
				new iChart.Pie2D({
					render : 'canvasDiv',
					data: data,
					title : '统计图(有空项可能该字段在需求表中为非必填项)',
					legend : {
						enable : true
					},
					sub_option : {
						label : {
							background_color:null,
							sign:false,//设置禁用label的小图标
							padding:'0 4',
							border:{
								enable:false,
								color:'#666666'
							},
							fontsize:11,
							fontweight:600,
							color : '#4572a7'
						},
						border : {
							width : 2,
							color : '#ffffff'
						}
					},
					animation:true,
					showpercent:true,
					decimalsnum:2,
					width : 800,
					height : 400,
					radius:140
				}).draw();
			});
		</script>
		
</head>
<body>
<form name="form1"  method="post" action="searchData.action"  id="form1">
<table>
		<tr>
		<td>请选择统计类型：</td>
		<td>
		<select style="width:25;" name="StatisticsType" id="StatisticsType">
      			<option value="OTmd">归口管理部门</option>
      			<option value="OArea">所在地域</option>
      			<option value="OAttribute">机构属性</option>
      			<option value="techType">科技活动类型</option>
      			<option value="DServics">需求技术所属领</option>
      	</select>
      	</td>
      	<td><input type="Submit" name="submit"  value="确认"></td>
      	</tr>
      	</table>
</form>
<%
	String name="";
	String namecount="";
	if(request.getAttribute("data")!=null)
	{
		List<DrawData> list = (List<DrawData>)request.getAttribute("data");
		System.out.println(list);
		for(int i=0;i<list.size();i++)
		{
			DrawData dd = list.get(i);
			name+=dd.getName()+"$";
			namecount+=dd.getCount()+"$";
		}
	}
	
 %>

<input type="hidden" value="<%=name%>" id="name"/>
<input type="hidden" value="<%=namecount%>" id="namecount"/>
<div id='canvasDiv'></div>
</body>
</html>