<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de Livros</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>Cadastro de Livros</h2>

    <form:form method="POST" modelAttribute="livro">
        <form:input type="hidden" path="idlivro" id="idlivro"/>
        <table>
            <tr>
                <td><label for="nome">Nome: </label> </td>
                <td><form:input path="nome" id="nome"/></td>
            <td><form:errors path="nome" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="escritor">Escritor: </label> </td>
                <td><form:input path="escritor" id="escritor"/></td>
            <td><form:errors path="escritor" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="anoedicao">Ano Edição: </label> </td>
                <td><form:input path="anoedicao" id="anoedicao"/></td>
            <td><form:errors path="anoedicao" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="classificacao">Classificação: </label> </td>
                <td><form:input path="classificacao" id="classificacao"/></td>
            <td><form:errors path="classificacao" cssClass="error"/></td>
            </tr>

            <tr>
                <td colspan="3">
            <c:choose>
                <c:when test="${edit}">
                    <input type="submit" value="Update"/>
                </c:when>
                <c:otherwise>
                    <input type="submit" value="Register"/>
                </c:otherwise>
            </c:choose>
            </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Retornar a <a href="<c:url value='/livros' />">Lista de Livros</a>
</body>
</html>