<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Reclamação</title>
    </head>
    <body>
        <form method="POST">
            <center>
                <h1>Editar Reclamação!</h1>             
                <div><input type="hidden" name="id" value="${reclamante.id}"/>id:${reclamante.id}</div>
                    <div><label>Nome: <input type="text" name="txtNome" value="${reclamante.nome}"/></label></div>
                    <div><label>Email: <input type="text" name="txtEmail" value="${reclamante.email}"/></div>
                    <div><label>Descricão: <input type="text" name="txtDescricao" value="${reclamante.descricao}"/></div>
                    <div><label>Status: <input type="text" name="txtStatus" value="${reclamante.status}"/></div>
                    <div><input type="submit" value="Salvar" name="btSalvar" /></div>  
            </center>
        </form>
    </body>
</html>
