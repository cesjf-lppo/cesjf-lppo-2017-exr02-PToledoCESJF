package br.cesjf.lppoexercicio02Web.servlets;

import br.cesjf.lppoexercicio02Web.bDados.Reclamante;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
@WebServlet(name = "EditaReclamacaoServlet", urlPatterns = {"/edita.html"})
public class EditaReclamacaoServlet extends HttpServlet {

    Connection conexao = null;
    Statement operacao = null;
    ResultSet resultado = null;
    String url = "jdbc:derby://localhost:1527/lppoEx02Reclamacoes";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Reclamante reclamante = new Reclamante();
        Long id = Long.parseLong(request.getParameter("id"));
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conexao = DriverManager.getConnection(url, "usuario", "senha");
            operacao = conexao.createStatement();
            resultado = operacao.executeQuery("SELECT * FROM reclamacao WHERE id=" + id);
                        
            if(resultado.next()){
                reclamante.setId(resultado.getLong("id"));
                reclamante.setNome(resultado.getString("nome"));
                reclamante.setEmail(resultado.getString("email"));
                reclamante.setDescricao(resultado.getString("descricao"));
                reclamante.setStatus(resultado.getInt("Status"));
            }

        } catch (Exception ex) {
            Logger.getLogger(EditaReclamacaoServlet.class.getName()).log(Level.SEVERE, "Não foi possível conectar o banco" +ex);
        }
        
       request.setAttribute("reclamante", reclamante);
       request.getRequestDispatcher("WEB-INF/editaReclamacao.jsp").forward(request, response);
               
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Reclamante reclamante = new Reclamante();
                        
        reclamante.setId(Long.parseLong(request.getParameter("id")));
        reclamante.setNome(request.getParameter("txtNome"));
        reclamante.setEmail(request.getParameter("txtEmail"));
        reclamante.setDescricao(request.getParameter("txtDescricao"));
        reclamante.setStatus(Integer.parseInt(request.getParameter("txtStatus")));

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conexao = DriverManager.getConnection(url, "usuario", "senha");
            operacao = conexao.createStatement();
            operacao.executeUpdate("UPDATE reclamacao SET nome= '" 
                    + reclamante.getNome() + "', email= '" 
                    + reclamante.getEmail() + "', descricao= '" 
                    + reclamante.getDescricao() + "', status= " 
                    + reclamante.getStatus() + " WHERE id=" + reclamante.getId());  
            
        } catch (Exception ex) {
            Logger.getLogger(EditaReclamacaoServlet.class.getName()).log(Level.SEVERE, "Não foi possivel gravar no banco" +ex);
        }
        
        response.sendRedirect("lista.html");
        
    }
}