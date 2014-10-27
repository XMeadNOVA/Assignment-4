/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var counter = 0;
var limit = 50;
function addInput(divName){
	if (counter === limit) {
		alert("You have reached the limit of adding " + counter + " inputs");
	}
	else {
		var newdiv = document.createElement('div');
		newdiv.innerHTML = "Ingredient " + (counter + 1) + " <br><input type='text' name='myInputs[]'>";
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