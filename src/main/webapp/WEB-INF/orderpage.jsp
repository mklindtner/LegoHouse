<%@ page import="FunctionLayer.User" %>
<%@ page import="FunctionLayer.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mkl
  Date: 3/20/18
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OrderPage</title>
</head>
<body>
    <%
        User u = (User) session.getAttribute("user");
        List orders = (List) session.getAttribute("orders");
        out.print("<b> your orders </b>");
        for(int i = 0; i < orders.size(); i++) {
            Order order = (Order) orders.get(i);
            out.println("order id is: " + order.getId() );
            out.println("<br />");
            if(u.getRole().equalsIgnoreCase("employee")) {
                //out.println(order.getLength() + ", Width: " + order.getWidth() + ", Height: " + order.getHeight() + ", Id: " + order.getUserId() + "<br />");
            } else {
                if(u.getId() == order.getUserId() ) {
                	//out.println("<a href=\"FrontController?command=delegate&page=specificOrderPage\">" + "length: " + order.getLength() + ", Width: " + order.getWidth() +", Height: " + order.getHeight() + "<br />" + "</a>");
                   // out.println("length: " + order.getLength() + ", Width: " + order.getWidth() +", Height: " + order.getHeight() + "<br />");
                }
            }
        }
    %>
   <a href="FrontController?command=specificOrderPage&orderId=10">showOrder</a>

    <form name="createOrder" action="FrontController" method="POST">
        <input type="hidden" name="command" value="createOrder">
        <input type="number" name="length" value="">length
        <input type="number" name="width" value="">width
        <input type="number" name="height" value="">height
        <input type="submit" value="submit">
    </form>
    <a href="FrontController?command=delegate&page=customerpage">testLink</a> <!-- fix this to general-->


</body>
</html>
