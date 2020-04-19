function menu(){
	document.getElementById("menu_sm").style.display = "block";
	document.body.style.overflow='hidden';
}

function fechar(){
	document.getElementById("menu_sm").style.display = "none";
	document.body.style.overflow='';
}

function nome_arquivo(){
	var nome = document.getElementById("arquivo").value.split(/[\\"]/g).pop();
	document.getElementById("label").innerHTML = nome;
}