<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Reclamação</title>
    </head>
    <body>
        <form action="nova.html" method="POST">
            <center>
                <h1>Nova Reclamação!</h1>
                <table>
                    <tr>
                        <td>
                            <p>Nome<br>
                            <p>Email</p>
                            <p>Descrição</p>
                        </td>
                        <td>
                            <p><input type="text" name="txtNome"  size="40"/></p>
                            <p><input type="text" name="txtEmail"  size="40"/></p>
                            <p><input type="text" name="txtDescricao"  size="40"/></p>
                        </td>
                    </tr>   
                </table>
                <table>
                    <tr>
                    <th>Status</th>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="rbgStatus" value="0" checked="checked" /><label> 0 - Aberto</label><br>
                            <input type="radio" name="rbgStatus" value="1" /><label> 1 - Confirmado</label><br>
                            <input type="radio" name="rbgStatus" value="2" /><label> 2 - Recusado</label><br>
                            <input type="radio" name="rbgStatus" value="3" /><label> 3 - Em execução</label><br>
                            <input type="radio" name="rbgStatus" value="4" /><label> 4 - Resolvido</label><br>
                            <p><input type="submit" value="Salvar" name="btSalvar" /></p>
                        </td>
                    </tr>
                </table>
            </center>
        </form>
    </body>
</html>
