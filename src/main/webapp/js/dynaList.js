/* 
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

var counter = 0;
var limit = 50;
function addInput(divName){
	if (counter === limit) {
		alert("You have reached the limit of adding " + counter + " inputs");
	}
	else {
		var newdiv = document.createElement('div');
		newdiv.innerHTML = "Ingredient " + (counter + 1) + "<br><input type='text' name='ingredients'>";
		document.getElementById(divName).appendChild(newdiv);
		counter++;
	}
}

function removeInput(divName) {
	if (counter > 0) {
		var parent = document.getElementById(divName);
		parent.removeChild(parent.lastChild);
		counter--;
	}
}