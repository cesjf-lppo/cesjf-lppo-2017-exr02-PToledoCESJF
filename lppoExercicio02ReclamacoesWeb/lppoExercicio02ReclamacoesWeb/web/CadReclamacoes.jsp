<%-- 
    Document   : CadReclamacoes
    Created on : 20/03/2017, 21:14:09
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Reclamações</title>
    </head>
    <body>
        <form action="cadReclamacoesServlet" method="POST">
            <center>
                <table>
                    <tr>
                        <th><h1>Cadastro de Reclamações!</h1></th>
                    </tr>
                    <tr>
                        <td><p><label>Nome <input type="text" name="txtNome"  size="40"/></label></p>
                        <p><label>Email<input type="text" name="txtEmail"  size="40"/></label></p>
                        <p><label>Descrição<input type="text" name="txtDescricao"  size="40"/></label></p>
                        <label>Status</label>
                        <p><input type="radio" name="rbgStatus" value="0" checked="checked" /><label> 0 - Aberto</label></p>
                        <p><input type="radio" name="rbgStatus" value="1" /><label> 1 - Confirmado</label></p>
                        <p><input type="radio" name="rbgStatus" value="2" /><label> 2 - Recusado</label></p>
                        <p><input type="radio" name="rbgStatus" value="3" /><label> 3 - Em execução</label></p>
                        <p><input type="radio" name="rbgStatus" value="4" /><label> 4 - Resolvido</label></p>
                        <p><input type="submit" value="Salvar" name="btSalvar" /></p></td>
                    </tr>
                </table>
            </center>
        </form>
    </body>
</html>
