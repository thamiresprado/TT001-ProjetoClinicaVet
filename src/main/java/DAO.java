
// DAO Implementation for SQLite.
/**
 * @author Prof. Dr. Plínio Vilela - prvilela@unicamp.br
 * @date 16 de Agosto de 2021
 */
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DAO {
    public static final String DBURL = "jdbc:sqlite:vet2021.db";
    private static Connection con;
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Connect to SQLite
    public static Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(DBURL);
                if (con != null) {
                    DatabaseMetaData meta = con.getMetaData();
                }
            } catch (SQLException e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
        return con;
    }

    protected ResultSet getResultSet(String query) {
        Statement s;
        ResultSet rs = null;
        try {
            s = (Statement) con.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return rs;
    }

    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }

    protected int lastId(String tableName, String primaryKey) {
        Statement s;
        int lastId = -1;
        try {
            s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(" + primaryKey + ") AS id FROM " + tableName);
            if (rs.next()) {
                lastId = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return lastId;
    }

    public static void terminar() {
        try {
            (DAO.getConnection()).close();
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    // Create table SQLite
    protected final boolean createTable() {
        try {
            PreparedStatement stmt;
            // Table client:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS cliente( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR, 
                                                        end VARCHAR, 
                                                        telefone VARCHAR, 
                                                        email VARCHAR); 
                                                        """
            );
            executeUpdate(stmt);
            
            // Table animal:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS animal( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR, 
                                                        idade INTEGER, 
                                                        sexo BOOLEAN, 
                                                        idCliente INTEGER, 
                                                        idEspecie INTEGER, 
                                                        FOREIGN KEY (idCliente) REFERENCES cliente(id) INTEGER, 
                                                        FOREIGN KEY (idEspecie) REFERENCES especie(id) INTEGER); 
                                                        """);
            executeUpdate(stmt);
            
            // Table species:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS especie( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR UNIQUE); 
                                                        """);
            executeUpdate(stmt);
            //UNIQUE: garante que aquele valor vai ser unico na tabela
            
            // Table vet:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS veterinario( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR, 
                                                        email VARCHAR, 
                                                        telefone VARCHAR); 
                                                        """);
            executeUpdate(stmt);    
            
            // Table treatment:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS tratamento( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR, 
                                                        descricao VARCHAR, 
                                                        dataIni VARCHAR, 
                                                        dataFim VARCHAR, 
                                                        idAnimal INTEGER, 
                                                        FOREIGN KEY (idAnimal) REFERENCES animal(id), 
                                                        encerrado BOOLEAN); 
                                                        """);
            executeUpdate(stmt);
            
            // Table appointment:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS consulta( 
                                                        id INTEGER PRIMARY KEY, 
                                                        data VARCHAR, 
                                                        descricao VARCHAR, 
                                                        idAnimal INTEGER, 
                                                        idVet INTEGER, 
                                                        idTratamento INTEGER, 
                                                        FOREIGN KEY (idAnimal) REFERENCES animal(id), 
                                                        FOREIGN KEY (idVet) REFERENCES veterinario(id), 
                                                        FOREIGN KEY (idTratamento) REFERENCES tratamento(id));  
                                                        """);
            executeUpdate(stmt);    
            
             // Table exam:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS exame( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR, 
                                                        descricao VARCHAR, 
                                                        idConsulta INTEGER); 
                                                        FOREIGN KEY (idConsulta) REFERENCES consulta(id));  
                                                        """);
            executeUpdate(stmt);      
            
            // Default element for species:
            stmt = DAO.getConnection().prepareStatement("INSERT OR IGNORE INTO especie (id, nome) VALUES (1, 'Cachorro')");
            executeUpdate(stmt);
            
            stmt = DAO.getConnection().prepareStatement("INSERT OR IGNORE INTO especie (id, nome) VALUES (1, 'Gato')");
            executeUpdate(stmt);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
