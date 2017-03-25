<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Reclamações</title>
    </head>
    <body>
        <h1>Listagem de Reclamações!</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Descrição</th>
                <th>Status</th>
            </tr>
            <c:forEach var="reclamacao" items="${reclamantes}">
                <tr>
                    <td>${reclamacao.id}</td>
                    <td>${reclamacao.nome}</td>
                    <td>${reclamacao.email}</td>
                    <td>${reclamacao.descricao}</td>
                    <td>${reclamacao.status}</td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
