package br.cesjf.lppoexercicio02Web.servlets;

import br.cesjf.lppoexercicio02Web.bDados.Reclamante;
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
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
@WebServlet(name = "NovaReclamacaoServlet", urlPatterns = {"/nova.html"})
public class NovaReclamacaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("WEB-INF/novaReclamacao.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "jdbc:derby://localhost:1527/lppoEx02Reclamacoes";
        Connection conexao = null;
        Statement operacao = null;
        
        
        Reclamante reclamante = new Reclamante();
        reclamante.setNome(request.getParameter("txtNome"));
        reclamante.setEmail(request.getParameter("txtEmail"));
        reclamante.setDescricao(request.getParameter("txtDescricao"));
        reclamante.setStatus(Integer.parseInt(request.getParameter("rbgStatus")));
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");        
            conexao = DriverManager.getConnection(url, "usuario", "senha");
            operacao = conexao.createStatement();
            operacao.executeUpdate("INSERT INTO reclamacao(nome, email, descricao, status) VALUES('"
                    +reclamante.getNome()+"', '"
                    +reclamante.getEmail()+"', '"
                    +reclamante.getDescricao()+"', "
                    +reclamante.getStatus()+")");

        } catch (Exception ex) {
            Logger.getLogger(NovaReclamacaoServlet.class.getName()).log(Level.SEVERE, "Não foi possível inserir o registro" +ex);
        }
        
        response.sendRedirect("lista.html");
 
    }


}
