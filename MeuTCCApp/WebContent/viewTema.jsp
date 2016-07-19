<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="br.ifrn.meutcc.modelo.Tema"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meu TCC</title>
</head>
<body>
<h1>Detalhes do Tema</h1>
<%
	Tema tema = (Tema) request.getAttribute("tema");
	boolean verificação=false;
	if (tema != null) {
		out.println("<h3>"+tema.getTitulo()+"</h3>");
		out.println("<ul>");
		out.println("<li> ID = "+tema.getId()+"</li>");
		out.println("<li> Descrição = "+tema.getDescricao()+"</li>");
		out.println("<li> Quantidade de Candidatos = "+tema.getQtdCandidato()+"</li>");
		out.println("<li> Orientador = "+tema.getIdOrientador()+"</li>");
		out.println("</ul>");
		if(verificação==false){
			out.println("<form action=\"/ViewTema/AddCandidato\" method=\"POST\">"
			+"<input type=\"hidden\" name=\"idTema\" value=\""+tema.getId()+"\" />"
			+"<input type=\"hidden\" name=\"idCandidato\" value=\""+1+"\" />"
			+"<input type=\"submit\" value=\"Cadastre-se!\" />"
			+"</form>");
			//verificação=Boolean.//parseBoolean(request.getAttribute("addCandidato"));
		}else{
			out.println("<p>Já Cadastrado nesse Tema!</p>");
		}
	} else {
		out.println("<h3>Não há nenhum tema para mostrar!</h3>");
	}
%>
</body>
</html>