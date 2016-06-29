<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblioteca</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <style>
            footer {
                position: fixed;
                height: 22px;
                bottom: 0;
                width: 100%;
            }
        </style>
    </head>

    <body>
        <div class="container-fluid">
            <header class="row">
                <nav class="navbar navbar-default">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#collapse1" aria-expanded="false">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="collapse navbar-collapse" id="collapse1">
                        <ul class="nav nav-pills" id="menu">
                            <li><a href="">Projetos</a></li>
                            <li role="presentation"><a href="<c:url value='/livros' />" data-target="#desktop" data-toggle="pill">Livros</a></li>
                            <li role="presentation"><a href="" data-target="#desktop" data-toggle="pill">Pessoas</a></li>
                            <li role="presentation"><a href="" data-target="#desktop" data-toggle="pill">Empréstimos</a></li>
                        </ul>
                    </div>
                </nav>
            </header>
            <div class="row">
                <div class="modal fade" id="dialogEdicao" tabindex="-2" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-content" id="conteudo">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
            <div class="pill-content">
                <div class="pill-pane" id="desktop"></div>
            </div>
            <footer class="row btn-primary">
                <p class="text-center">Designed by Tarcísio Müller</p>
            </footer>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script type="text/javascript">
            jQuery(function () {
                jQuery('#menu a').on('click', function () {
                    $.ajax({
                        type: "GET",
                        url: this.href,
                        data: '',
                        success: function (text) {
                            $('#desktop').html(text);
                        }
                    });
                });
            });
        </script>
    </body>
</html>
