package br.cesjf.lppoexercicio02Web.bDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo
 */
public class ConexaoBD {
    Connection conexao;
    
    public boolean abrirConexao(){
        String url = "jdbc:derby://localhost:1527/lppoEx02Reclamacoes";
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conexao = DriverManager.getConnection(url, "usuario", "senha");
            return true;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, "Erro ao conectar o banco de dados", ex);
            return false;
        }
    }
    
    public boolean fecharConexao(){
        
        try {
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, "Nao foi possível fechar a conexão", ex);
            return false;
        }
        
    }
    
    public Connection obterConexao(){
            return conexao;
        }
}
