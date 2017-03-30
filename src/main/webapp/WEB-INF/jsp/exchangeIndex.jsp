<%--
  Created by IntelliJ IDEA.
  Date: 2017/3/15
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${ctx}/js/jquery-3.1.1.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>

    <script type="text/javascript">

        $(function () {
            $('.popover-show').popover('show');
        });
        $(function () {
            $('.popover-show').on('shown.bs.popover', function () {
            alert("当显示时警告消息");
        })});

        //查询
        $(function () {
            $("#select").click(function () {
                var url="${ctx}/select";
                var form=$("#myform");
                form.attr("action",url);
                form.submit();
            });

            //兑换
            $("#exchange").click(function () {
                var url="${ctx}/exchange";
                var form=$("#myform");
                form.attr("action",url);
                form.submit();
            });
        })
    </script>
</head>
<body>
<form method="post" id="myform" name="sss">
    电话：<input type="text" id="phone" name="phone"/>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input type="button" name="select" id="select" value="查询"  />

</form>

<c:if test="${not empty dxExchange}">
    <table class="table">
        <tr class="warning" style="text-align: center"><td colspan="4"><h3>客户资料</h3></td></tr>
        <tr class="warning"><td>客户编号</td><td>电话号码</td><td>积分余额</td><td>是否黑名单</td></tr>
        <tr class="success">
            <td>${dxExchange.customNo}</td>
            <td>${dxExchange.serialNo}</td>
            <td>${dxExchange.restPoints}</td>
            <c:choose>
                <c:when test="${dxExchange.limitNo == '1'}">
                    <td>否</td>
                </c:when>
                <c:otherwise>
                    <td>是</td>
                </c:otherwise>
            </c:choose>
        </tr>

   <tr class="warning" ><td colspan="4" style="text-align: center"><h3>可兑换的礼品</h3></td></tr>
    <%--<table style="text-align: center">--%>
        <tr class="warning"><td>礼品编号</td><td>礼品名称</td><td>兑换数量</td><td>所需积分</td><td>操作</td></tr>
        <c:forEach var="gift" items="${dxExchange.giftList}">
            <tr class="active">
                <td>${gift.giftId}</td>
                <td>${gift.giftName}</td>
                <td>${gift.changeNumber}</td>
                <td>${gift.scoreValue}</td>
                <td><a  name="exchange" href="${ctx}/exchange?giftId=${gift.giftId}&customNo=${dxExchange.customNo}&serialNo=${dxExchange.serialNo}">兑换</a></td>
            </tr>
        </c:forEach>
    </table>

</c:if>

<div style="text-align: center;width: 200px;height: 200px;">
    <c:if test="${not empty resultMsg}">
        <label>${resultMsg}</label>
    </c:if>

</body>
</html>
