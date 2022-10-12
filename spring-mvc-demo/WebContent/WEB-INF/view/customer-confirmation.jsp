<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<title>Customer confirmation</title>


<body>
	The customer is confirmed: ${customer.firstName} ${customer.lastName}
	<br><br>
	The customer`s free passes are: ${customer.freePasses}
	<br><br>
	The customer`s postal code is: ${customer.postalCode}
	<br><br>
	The customer`s course code is: ${customer.courseCode}
	<br><br>



</body>


</html>