package br.cesjf.lppoexercicio02Web.servlets;

import br.cesjf.lppoexercicio02Web.bDados.ConexaoBD;
import br.cesjf.lppoexercicio02Web.bDados.Reclamante;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ListaReclamacoesServlet", urlPatterns = {"/lista.html"})
public class ListaReclamacoesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Reclamante> lstReclamantes = new ArrayList<>();
        Connection conexao = null;
        Statement operacao = null;
        ResultSet resultado = null;
        String url = "jdbc:derby://localhost:1527/lppoEx02Reclamacoes";

        // Pegar os dados no banco
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conexao = DriverManager.getConnection(url, "usuario", "senha");
            operacao = conexao.createStatement();
            resultado = operacao.executeQuery("SELECT * FROM reclamacao");

            while (resultado.next()) {
                Reclamante reclamanteAtual = new Reclamante();
                reclamanteAtual.setId(resultado.getLong("id"));
                reclamanteAtual.setNome(resultado.getString("nome"));
                reclamanteAtual.setEmail(resultado.getString("email"));
                reclamanteAtual.setDescricao(resultado.getString("descricao"));
                reclamanteAtual.setStatus(resultado.getInt("status"));
                lstReclamantes.add(reclamanteAtual);

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, "Erro ao conectar o banco de dados", ex);
        }

        request.setAttribute("reclamantes", lstReclamantes);
        request.getRequestDispatcher("WEB-INF/listaReclamacoes.jsp").forward(request, response);
    }
}
