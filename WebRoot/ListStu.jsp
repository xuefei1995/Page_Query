<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>查询学生信息</title>  
  </head>
  
  <body>
  <form id="queryForm" action="${pageContext.request.contextPath }/ListStuServlet" method="post">
  	<input type="hidden" id="hidcur" name="currentPage" value="${pageBean.currentPage }">
  	<input type="hidden" id="hidsiz" name="pageSize" value="${pageBean.pageSize }">
  <table align="center" width="700px">
  <tr>
  <td colspan="5" align="center">
     姓名<input type="text" name="name" size="2" value="${param['name'] }">&nbsp;
     年龄<input type="text" name="age" size="2"value="${param['age'] }">&nbsp;  
  <c:choose>
     <c:when test="${param['gender']=='男' }">
          性别:&nbsp;<input type="radio" name="gender" value="男" checked="checked">男
   			  <input type="radio" name="gender" value="女">女
     </c:when>
     <c:when test="${param['gender']=='女' }">
          性别:&nbsp;<input type="radio" name="gender" value="男">男
   			  <input type="radio" name="gender" value="女" checked="checked">女
     </c:when>
     <c:otherwise>
               性别:&nbsp;<input type="radio" name="gender" value="男">男
   			  <input type="radio" name="gender" value="女">女
     </c:otherwise>
   </c:choose>  
   &nbsp;Servlet:&nbsp;从<input type="text" name="beginservlet" size="2" value="${param['beginservlet'] }">
   				到<input type="text" name="endservlet" size="2" value="${param['endservlet'] }">
   	<input type="submit" value="搜索">
  </td>  
  </tr>
  </table>
  </form>
    <table align="center" border="1" width="700px">
     <tr><td colspan="5" align="center">学生信息表</td></tr>
     <tr>
     <td>姓名</td>
     <td>年龄</td>
     <td>性别</td>
     <td>Servlet成绩</td>
     <td>Java成绩</td>
     </tr>
     <c:forEach items="${pageBean.list }" var="stu">
	    <tr>
	    <td>${stu.name }</td>
	    <td>${stu.age }</td>
	    <td>${stu.gender }</td>
	    <td>${stu.servlet }</td>
	    <td>${stu.java }</td>
	    </tr>
    </c:forEach>
    <tr>
    <td colspan="5" align="center">
    <c:choose>
    <c:when test="${pageBean.currentPage==pageBean.firstPage }">
    	首页&nbsp;上一页&nbsp;
    </c:when>
    <c:otherwise>
   	<a href="javascript:void(0)" onclick="subForm(${pageBean.firstPage})">首页</a>&nbsp;
    <a href="javascript:void(0)" onclick="subForm(${pageBean.prePage})">上一页</a>&nbsp;
    </c:otherwise>
    </c:choose>
	
	<c:choose>
    <c:when test="${pageBean.currentPage==pageBean.totalPage }">
    	下一页&nbsp;末页&nbsp;
    </c:when>
    <c:otherwise>
    <a href="javascript:void(0)" onclick="subForm(${pageBean.nextPage})">下一页</a>&nbsp;
    <a href="javascript:void(0)" onclick="subForm(${pageBean.totalPage})">末页</a>&nbsp;
    </c:otherwise>
    </c:choose>
    	当前为第${pageBean.currentPage }页/共${pageBean.totalPage }页&nbsp;
    	共${pageBean.totalCount }条数据,每页<input type="text" id="pageSize" size="1" value="${pageBean.pageSize }" onblur="changePageSize()">条&nbsp;
    	跳转到<input type="text" id="curentPage" size="1" value="${pageBean.currentPage }" onblur="changecurentPage()">页
    </td>
    </tr>
    </table>
  </body>
  <script type="text/javascript">
	function changePageSize(){
		var pageSize=document.getElementById("pageSize").value;
	  	var reg=/^[1-9][0-9]?$/;
	  	if(!reg.test(pageSize)){
	  		alert("请输入1-2位数字");
	  		return; 
	  	}
	  	document.getElementById("hidsiz").value=pageSize;
	  	var form=document.getElementById("queryForm");
	  	form.submit();//提交表单	
		}  
	function changecurentPage(){
		var curentPage=document.getElementById("curentPage").value;
		var reg=/^[1-9][0-9]?$/;
		if(!reg.test(curentPage)){
	  		alert("请输入1-2位数字");
	  		return; 
	  	}
	  	var totalpage=${pageBean.totalPage};
	  	if(curentPage>totalpage){
	  		alert("输入的页面不存在!");
	  		return;
	  	}
		document.getElementById("hidcur").value=curentPage;
	  	var form=document.getElementById("queryForm");
	  	form.submit();//提交表单	
	}
	
	function subForm(currentPage){
		var form=document.getElementById("queryForm");
		document.getElementById("hidcur").value=currentPage;
		form.submit();//提交表单	
	}
</script>
</html>
