<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de Livros</title>

        <style>
            tr:first-child{
                font-weight: bold;
                background-color: #C6C9C4;
            }
        </style>

    </head>


    <body>
        <h2>Livros</h2>  
        <table>
            <tr>
                <td>Nome</td><td>Escritor</td><td>Ano Edição</td><td>Classificação</td><td></td>
            </tr>
            <c:forEach items="${livros}" var="livro">
                <tr>
                    <td>${livro.nome}</td>
                    <td>${livro.escritor}</td>
                    <td>${livro.anoedicao}</td>
                    <td>${livro.classificacao}</td>
                    <c:url var='edit_url' value='/edit-${livro.id}-livro' />
                    <td><a onclick="abreModal('${edit_url}');">${livro.id}</a></td>
                    <td><a class="link" href="<c:url value='/delete-${livro.id}-livro' />" data-target="#dialogEdicao" data-toggle="modal">delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <c:url var='new_url' value='/new' />
        <a onclick="abreModal('${new_url}');">Novo Livro</a>

        <script type="text/javascript">
            function abreModal(url) {
                $.ajax({
                    type: "GET",
                    url: url,
                    data: '',
                    success: function (text) {
                        $('#conteudo').html(text);
                        $('#dialogEdicao').modal('show');
                    }
                });
            }
        </script>

    </body>
</html>