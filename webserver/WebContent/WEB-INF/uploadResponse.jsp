<!doctype html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
		<title>ADD - RELATÓRIO</title>
		<link rel="icon" type="imagem/png" href="imagens/logo_ADD.png" />
		<link rel="stylesheet" type="text/css" href="css/estilo.css">
		<script type="text/javascript" src="js/funcionalidades.js"></script>
	</head>
	<body>
		<div class="container">
			<header>
				<nav class="menu_lg">
					<img class="menu_icone" src="imagens/menu_icone.svg" title="MENU" alt="MENU" onclick="menu()"/>
					<a href="index.html" title="PÁGINA INICIAL"><h2>Página Inicial</h2></a>
					<a href="projeto.html" title="PROJETO"><h2>Projeto</h2></a>
				</nav>
			</header>
			<div id="menu_sm">
				<nav>
					<img src="imagens/fechar_icone.svg" title="FECHAR" alt="FECHAR" onclick="fechar()"/>
					<div>
					<a href="index.html" title="PÁGINA INICIAL"><h2>Página Inicial</h2></a>
					<a href="projeto.html" title="PROJETO"><h2>Projeto </h2></a>
					</div>
				</nav>
			</div>
			<aside>
				<img src="imagens/logo_ADD.png" alt="LOGO ADD - AVALIADOR DE DOCUMENTOS DIGITAIS"/>
			</aside>
		    <main>
				<div class="texto">
					${result}
				</div>
			</main>
			<footer>
				<h3>Projeto Ferramentas Acessíveis | UFABC 2020</h3>
			</footer>
		</div>
	</body>
</html>