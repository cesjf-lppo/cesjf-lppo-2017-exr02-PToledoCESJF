
package br.cesjf.lppoexercicio02Web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
@WebServlet(name = "cadReclamacoesServlet", urlPatterns = {"/reclamacao.html"})
public class cadReclamacoesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Connection conexao = null;
        Statement operacao = null;
        
        String nome = request.getParameter("txtNome");
        String email = request.getParameter("txtEmail");
        String descricao = request.getParameter("txtDescricao");
        int status = Integer.parseInt(request.getParameter("txtStatus"));
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/lppoEx02Reclamacoes";
            conexao = DriverManager.getConnection(url, "usuario", "senha");
            operacao = conexao.createStatement();
            
        } catch (ClassNotFoundException e) {
            Logger.getLogger(cadReclamacoesServlet.class.getName()).log(Level.SEVERE, "Erro no carregamento do Driver" +e);
        } catch (SQLException e1) {
            Logger.getLogger(cadReclamacoesServlet.class.getName()).log(Level.SEVERE, "Erro na conexão" +e1);
        }
        
        try {
            operacao.executeUpdate("INSERT INTO reclamacao VALUES('" + nome + "', '" + email + "','" + descricao + "', " + status + ")");
        } catch (SQLException ex) {
            Logger.getLogger(cadReclamacoesServlet.class.getName()).log(Level.SEVERE, "Não foi possível inserir na tabela"+ ex);
        }

    }

}
