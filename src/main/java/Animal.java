public class Animal {
    private int id;
    private int idCliente;
    private int idEspecie;
    private String nome;
    private int idade;
    private boolean sexo; // false - Macho, true - Fêmea

    public Animal(int id, String nome, int idade, boolean sexo, int idCliente, int idEspecie) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.idCliente = idCliente;
        this.idEspecie = idEspecie;
    }

    public int getId() {
        return id;
    }
    
    public int getClienteId (){
        return idCliente;
    }
    
    
    public int getidEspecie() {
        return idEspecie;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
    
    public void setIdCliente (int idCliente){
        this.idCliente = idCliente;
    }
    
    public void setidEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }
    
    @Override
    public String toString() {
        String desc = "Animal {" + "id= " + id + ",idCliente= " + idCliente + ", nome= " + nome + ", idade= " + idade + ", sexo" + sexo + '}' + '\n';
        return desc;
    }
}
