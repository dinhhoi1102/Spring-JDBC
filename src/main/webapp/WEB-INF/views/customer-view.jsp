<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Helo Spring MVC + JDBC</title>
</head>
<body>
  <a href="<c:url value="/customer-list" />" >List Customer</a><br />
  <h1>View Customer:</h1>  
  Employee ID: ${customer.id} <br/>
  Employee Name: ${customer.name} <br/>
  Employee Email: ${customer.email} <br/>
</body>
</html>