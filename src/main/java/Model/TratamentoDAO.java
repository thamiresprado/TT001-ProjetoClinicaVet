package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TratamentoDAO extends DAO {
    private static TratamentoDAO instance;

    private TratamentoDAO() {
        getConnection();
        createTable();
    }

    // Singleton
    public static TratamentoDAO getInstance() {
        return (instance==null?(instance = new TratamentoDAO()):instance);
    }

// CRUD    
    public Tratamento create(String nome, String descricao, String dtIni, String dtFim, int idAnimal, boolean encerrado) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO tratamento (nome, descricao, dtIni, dtFim, idAnimal, encerrado) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setString(3, dtIni);
            stmt.setString(4, dtFim);
            stmt.setInt(5, idAnimal);
            stmt.setBoolean(6, encerrado);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.retrieveById(lastId("tratamento","id"));
    }
    
    public boolean isLastEmpty(){
        Tratamento lastTratamento = this.retrieveById(lastId("tratamento","id"));
        if (lastTratamento != null) {
            return lastTratamento.getNome().isBlank();
        }
        return false;
    }

    private Tratamento buildObject(ResultSet rs) {
        Tratamento tratamento = null;
        try {
            tratamento = new Tratamento(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getString("dtIni"), rs.getString("dtFim"), rs.getInt("idAnimal"), rs.getBoolean("encerrado"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return tratamento;
    }

    // Generic Retriever
    public List retrieve(String query) {
        List<Tratamento> tratamentos = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                tratamentos.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return tratamentos;
    }
    
    // RetrieveAll
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM tratamento");
    }
    
    // RetrieveLast
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM tratamento WHERE id = " + lastId("tratamento","id"));
    }

    // RetrieveById
    public Tratamento retrieveById(int id) {
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM tratamento WHERE id = " + id);
        return (tratamentos.isEmpty()?null:tratamentos.get(0));
    }
    
    public List retrieveByIdAnimal(int idAnimal) {
        return this.retrieve("SELECT * FROM tratamento WHERE idAnimal = " + idAnimal);
    }
 
        
    // Updade
    public void update(Tratamento tratamento) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE tratamento SET nome=?, dtIni=?, dtFim=?, idAnimal=?, encerrado=? WHERE id=?"); 
            stmt.setString(1, tratamento.getNome());
            stmt.setString(2, tratamento.getDescricao());
            stmt.setString(3, tratamento.getDtIni());
            stmt.setString(4, tratamento.getDtFim());
            stmt.setInt(5, tratamento.getIdAnimal());
            stmt.setBoolean(6, tratamento.isEncerrado());
            
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
        // Delete   
    public void delete(Tratamento tratamento) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM tratamento WHERE id = ?");
            stmt.setInt(1, tratamento.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}
