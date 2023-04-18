<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int totalAmt=(int)request.getAttribute("totalAmt");
int waiting_charges=(int)request.getAttribute("waiting_charge");
int final_bill=(int)request.getAttribute("final_bill");%>

<h3 style="color:green ;font-family:Georgia,Times New Roman"><marquee>CAB BOOKED SUCCESSFULLY!!===========WELCOME TO CAB BOOKING SYSTEM!==========THANK YOU FOR VISITING!.............</marquee></h3>
<h1 style="color:darkblue ;font-family:Georgia,Times New Roman,Times,serif">TOTAL AMOUNT : <%= totalAmt %></h1>
<h1  style="color:darkblue ;font-family:Georgia,Times New Roman,Times,serif">WAITING CHARGES : <%= waiting_charges %></h1>
<h1  style="color:red ;font-family:Times New Roman">FINAL BILL : <%= final_bill %></h1>
</body>
</html>