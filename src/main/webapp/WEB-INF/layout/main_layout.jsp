<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, 11, 10">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>search manager</title>


<!-- 트리속성 사용하기위한 CSS  -->
<link rel="stylesheet" href="css/zTree/zTreeStyle/zTreeStyle.css" type="text/css">

<script src="js/jquery-1.9.1.js"></script>
<script src="js/common.js"></script>

</head>
<body>
<div id="Main_Wrap">
        <tiles:insertAttribute name="header"/>
        
        <div style="clear: both;"></div>
        
        <div class="cont">
           <%-- <tiles:insertAttribute name="left"/> --%>
           <tiles:insertAttribute name="body"/>
           <%-- <tiles:insertAttribute name="right"/> --%>

        </div> <!--cotn-->         
    </div>
       
</body>
</html>
