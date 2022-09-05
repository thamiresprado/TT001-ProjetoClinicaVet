import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalDAO {
    private static AnimalDAO instance;
    private List <Animal> animais = new ArrayList<Animal>();
    private int idAnimal;
    
    public static AnimalDAO getInstance(){
        return (instance==null ? (instance = new AnimalDAO()): instance);
    }
    
    public List<Animal> create (int id, int idCliente, String nome, int idade, boolean sexo){
        Animal padrao = new Animal (id, idCliente, nome, idade, sexo);
        animais.add(padrao);
        idAnimal++;
        return animais;
    }
    
    public List<Animal> retrieveAll(){
        return animais;
    }
    
    public List<Animal> retrieveByID (int id){
        return (List<Animal>) this.animais.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }
    
    public List<Animal> retrieveByIDCliente (int id){
        return (List<Animal>) this.animais.stream().filter(item -> item.getClienteId() == id).collect(Collectors.toList());
    }
    
    public void update (int id, int idCliente, String nome, int idade, boolean sexo){
        Animal padrao = animais.get(id);
        padrao.setIdCliente(idCliente);
        padrao.setNome(nome);
        padrao.setIdade(idade);
        padrao.setSexo(sexo);
    }
    
    public void delete (int id){
        animais.remove(id);
    }
}
