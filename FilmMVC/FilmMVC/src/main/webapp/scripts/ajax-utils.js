function getValue(id) {
  return(escape(document.getElementById(id).value));
}

function getRequestObject() {
  if (window.XMLHttpRequest) {
    return(new XMLHttpRequest());
  } else if (window.ActiveXObject) { 
    return(new ActiveXObject("Microsoft.XMLHTTP"));
  } else {
    return(null); 
  }
}

function ajaxResult(address, resultRegion) {
	var request = getRequestObject();
	request.onreadystatechange =
	function() {
		showResponseText(request, resultRegion);
	};
	request.open("GET", address, true);
	request.send(null);
}


function ajaxPost(address, data) {
  var request = getRequestObject();
  request.open("POST", address, true);
  request.setRequestHeader("Content-Type", 
                           "application/x-www-form-urlencoded");
  request.send(data);
}

function ajaxResultPost(address, data, resultRegion) {
	var request = getRequestObject();
	request.onreadystatechange =
	function() {
		showResponseText(request, resultRegion);
	};
	request.open("POST", address, true);
	request.setRequestHeader("Content-Type",
	"application/x-www-form-urlencoded");
	request.send(data);
}

function showResponseText(request, resultRegion) {
	if ((request.readyState == 4) && (request.status == 200)) {
		htmlInsert(resultRegion, request.responseText);
	}
}

function getBodyContent(element) {
  element.normalize();
  return(element.childNodes[0].nodeValue);
}


function getElementValues(element, subElementNames) {
  var values = new Array(subElementNames.length);
  for(var i=0; i<subElementNames.length; i++) {
    var name = subElementNames[i];
    var subElement = element.getElementsByTagName(name)[0];
    values[i] = getBodyContent(subElement);
  }
  return(values);
}

function htmlInsert(id, htmlData) {
	document.getElementById(id).innerHTML = htmlData;
}