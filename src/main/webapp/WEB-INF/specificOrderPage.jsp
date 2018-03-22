<%@ page import="java.util.List" %>
<%@ page import="FunctionLayer.Order" %>
<%@ page import="FunctionLayer.LegoCalculator.LegoPieces" %>
<%@ page import="FunctionLayer.LegoCalculator.BrickList" %>
<%--
  Created by IntelliJ IDEA.
  User: mkl
  Date: 3/21/18
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Specific pageOrder</title>
</head>
<body>
        This displays a specific order
        <%
           Order choosenOrder = (Order) session.getAttribute("order");
            BrickList lp = choosenOrder.getBrickList();
            out.println("long bricks: " + lp.getNumberOfLongBrik() + ", mediumBricks: " + lp.getNumberOfMediumBrick() + ", smallBricks: " + lp.getNumberOfSmallBrick() + "<br />");
            //out.println("length: " + choosenOrder.getHeight() + ", width: " + choosenOrder.getWidth() + ", height: " + choosenOrder.getHeight());
        %>
</body>
</html>
