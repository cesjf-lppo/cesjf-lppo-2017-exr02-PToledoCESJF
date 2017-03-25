package br.cesjf.lppoexercicio02Web.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
@WebServlet(name = "ExcluiRegistroServlet", urlPatterns = {"/exclui.html"})
public class ExcluiRegistroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Connection conexao = null;
        Statement operacao = null;
        String url = "jdbc:derby://localhost:1527/lppoEx02Reclamacoes";
        Long id = Long.parseLong(request.getParameter("id"));
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conexao = DriverManager.getConnection(url, "usuario", "senha");
            operacao = conexao.createStatement();
            operacao.executeUpdate("DELETE FROM reclamacao WHERE id=" +id);
            
        } catch (Exception ex) {
            Logger.getLogger(ExcluiRegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("lista.html");

    }

}
