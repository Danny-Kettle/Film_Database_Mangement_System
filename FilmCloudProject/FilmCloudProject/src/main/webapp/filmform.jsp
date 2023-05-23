<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Films</title>
</head>
<body>
    <h1>Add Film</h1>
    <fieldset>
  	<legend>Films Search</legend>
		<input type="button" value="Back to search" id="filmsSearch" onclick="(function(){
			window.history.back();
		})();"/>
  	</fieldset>
    <div align="center">
	        <table border="1">
	            <caption>
	                <h2>Add New Film</h2>
	            </caption>       
	            <tr>
	                <th>Title: </th>
	                <td>
	                    <input required type="text" id="title" name="title" size="45"/>
	                </td>
	            </tr>
	            <tr>
	                <th>Year: </th>
	                <td>
	                    <input required type="text" id="year" name="year" size="45"/>
	                </td>
	            </tr>
	            <tr>
	                <th>Director: </th>
	                <td>
	                    <input required type="text" id="director" name="price" size="45"/>
	                </td>
	            </tr>
				<tr>
	                <th>Stars: </th>
	                <td>
	                    <input required type="text" id="stars" name="stars" size="45"/>
	                </td>
	            </tr>
				<tr>
	                <th>Review: </th>
	                <td>
	                    <textarea required id="review" rows="12" cols="45" name="review"></textarea>
	                </td>
	            </tr>
	            <tr>
	                <td colspan="2" align="center">
	                    <input type="submit" value="Save" onclick="CreateNewFilm()"/>
	                </td>
	            </tr>
	        </table>
		<div id="result"></div>
    </div>   
	<script src="./scripts/ajax-utils.js" type="text/javascript"></script>
  	<script src="./scripts/ajax-data.js" type="text/javascript"></script>
</body>
</html>