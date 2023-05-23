<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Film List</title>
</head>
<body>
  <fieldset>
  	<legend>Films Search</legend>
	<input type="text" placeholder="Search..." id="search"/>
	<input type="text" placeholder="Search By ID..." id="searchID"/>
  	<input type="button" value="Show Films" onclick="filmTable('search', 'searchID', 'result')"/>
  	<button type="button"><a href="new">Add Film</a></button>
  </fieldset>
  <div id="result">
  	
  </div>
  
  <script src="./scripts/ajax-utils.js" type="text/javascript"></script>
  <script src="./scripts/ajax-data.js" type="text/javascript"></script>
</body>
</html>