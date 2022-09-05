import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ClienteDAO {
    private static ClienteDAO instance;
    private List <Cliente> cliente = new ArrayList<Cliente>();
    private int idCliente;
    
    public static ClienteDAO getInstance(){
        return (instance==null ? (instance = new ClienteDAO()): instance);
    }
    
    public List<Cliente> create (String nome, String endereco, String telefone, String email){
        Cliente padrao = new Cliente (idCliente, nome, endereco, telefone, email);
        cliente.add(padrao);
        idCliente++;
        return cliente;
    }
    
    public List<Cliente> retrieveAll(){
        return cliente;
    }
    
    public List<Cliente> retrieveByID (int id){
        return (List<Cliente>) this.cliente.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }
    
    public void update (int id, String nome, String endereco, String telefone, String email){
        Cliente padrao = cliente.get(id);
        padrao.setNome(nome);
        padrao.setEndereco(endereco);
        padrao.setTelefone(telefone);
        padrao.setEmail(email);
    }
    
    public void delete (int id){
        cliente.remove(id);
    }
    
    
}
