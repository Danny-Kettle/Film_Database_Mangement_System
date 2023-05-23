
function filmTable(searchField, searchID, resultRegion) {
	var search = getValue(searchField);
	var searchID = getValue(searchID);
	var data;	
	if((search == "" || search == "*") && (searchID == "" || searchID == "*")){
		var address = "get-all-films";
	}else if(searchID != ""){
		var address = "searchID"
		data = data + "&searchID=" + searchID;
	}
	else{
		var address = "search"
		data = data + "&search=" + search;
	}

	ajaxResultPost(address, data, resultRegion);
}

//Edit Event
function makeRowsEditable(element){
	if(element.innerHTML == "Edit"){
		element.innerHTML = "Update";		
		//Get All TD'S 
		var currentTD = element.parentNode.parentNode.querySelectorAll('td');
		console.log(currentTD);
		for(let i = 0 ; i < currentTD.length-1; i++){
			currentTD[i].style.border = "2px solid orange";
			currentTD[i].setAttribute("contenteditable","true");
		}
	}else{
		//Set Parameters
		var id = element.name;
		var search = getValue("search");
		
		//Getting Edited Values
		var currentTD = element.parentNode.parentNode.querySelectorAll('td');

		var title = currentTD[0].innerHTML;
		var year = currentTD[1].innerHTML;
		var director = currentTD[2].innerHTML;
		var stars = currentTD[3].innerHTML;
		var review = currentTD[4].innerHTML;
		
		var resultRegion = "result";
		
		for(let i = 0 ; i < currentTD.length; i++){
			currentTD[i].style.border = "1px solid black";
			currentTD[i].setAttribute("contenteditable","false");
		}

		//Getting parameters 
		var data = "id=" + id + "&search=" + search + "&title=" + title + "&year=" + year + "&director=" + director + "&stars=" + stars + "&review=" + review;
		var address = "update";
		
		ajaxResultPost(address, data, resultRegion);
		
		element.innerHTML = "Edit";		
	}
}

//Delete Event
function deleteRow(element){
	var resultRegion = "result";
	var id = element.name;
	//Get Format
	var search = getValue("search");
	
	if(search == ""){
			
	}

	var data = "id=" + id  + "&search=" + search;
	var address = "delete";
	ajaxResultPost(address, data, resultRegion);
}


//Create Event
function CreateNewFilm(){
	//Get input Fields
	var resultRegion = "result";
	var title = getValue("title");
	var year = getValue("year");
	var director = getValue("director");
	var stars = getValue("stars");
	var review = getValue("review");
	var search = title;
	
	
	//Stringify input fields
	var data = "title=" + title + "&year=" + year + "&director=" + director+ "&stars=" + stars + "&review=" + review ;

	var address = "insert";
	
	window.location.href = "filmlist.jsp";

	//ajaxAlert(address,data);
	ajaxResultPost(address, data, resultRegion);
}



//Tables
function getTable(rows) {
	var headings = 
    [ "Title", "Year", "Director", "Stars", "Review"];
	var table = "<table border='1' class='ajaxTable'>" +
		headings +
		getTableBody(rows) +
		"</table>";
	return (table);
}


function getTableBody(rows) {
	var body = "";
	for (var i = 0; i < rows.length; i++) {
		body += " <tr>";
		var row = rows[i];
		for (var j = 0; j < row.length-1; j++) {
			body += "<td>" + row[j] + "</td>";
		}
		body += "<td><button class='edit-btn' onclick='makeRowsEditable(this)' name='"+ row[row.length-1] +"'>Edit</button><button onclick='deleteRow(this)' class='delete-btn' name='"+ row[row.length-1] +"'>Delete</button></td>"
		body += "</tr>\n";
	}
	return (body);
}

