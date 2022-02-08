<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> Add Product</h1>

<form method="post" action="add-product">
	<fieldset>
		<legend>Add Product form</legend>
		Product Name: <input type="text" name="name" id="name" /><br/><br/>
		Product Price: <input type="text" name="price" id = "price" /> <br/><br/>
		<input type="submit" value="Add Product">
	</fieldset>
</form>

</body>
</html>