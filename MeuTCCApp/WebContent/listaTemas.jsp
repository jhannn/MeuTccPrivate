<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, br.ifrn.meutcc.modelo.Tema" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meu TCC</title>
</head>
<body>
<h1>Listagem dos Temas Disponíveis para TCC</h1>
<ol>
<%
	List<Tema> temas = (List<Tema>) request.getAttribute("temas");
	if (temas != null && !temas.isEmpty()) {
		for(Tema t: temas) {
			out.println("<li><a href=\"/MeuTCC/ViewTema?id="+t.getId()+
							"\">["+t.getId()+"] "+t.getTitulo()+"</a>.</li>");
		}
	} else {
		out.println("<li>Nenhum tema cadastrado para o referido curso!</li>");
	}
%>
</ol>
</body>
</html>