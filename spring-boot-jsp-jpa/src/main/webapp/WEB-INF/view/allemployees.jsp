<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>University Enrollments</title>

        <style>
            tr:first-child{
                font-weight: bold;
                background-color: #C6C9C4;
            }
        </style>

    </head>


    <body>
        <h2>List of Employees</h2>  
        <table>
            <tr>
                <td>NAME</td><td>Joining Date</td><td>Salary</td><td>SSN</td><td></td>
            </tr>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td>${employee.name}</td>
                    <td>${employee.joiningDate}</td>
                    <!-- precisa que o campo seja java.util.Date fmt:formatDate value="{employee.joiningDate}" pattern="dd/MM/yyyy" /-->
                    <td>${employee.salary}</td>
                    <c:url var='edit_url' value='/edit-${employee.ssn}-employee' />
                    <td><a onclick="abreModal('${edit_url}');">${employee.ssn}</a></td>
                    <td><a class="link" href="<c:url value='/delete-${employee.ssn}-employee' />" data-target="#dialogEdicao" data-toggle="modal">delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <c:url var='new_url' value='/new' />
        <a onclick="abreModal('${new_url}');">Add New Employee</a>

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