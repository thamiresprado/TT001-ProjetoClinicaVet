public class Animal {
    private int id;
    private int idCliente;
    private String nome;
    private int idade;
    private boolean sexo; // false - Macho, true - Fêmea

    public Animal(int id, int idCliente, String nome, int idade, boolean sexo) {
        this.id = id;
        this.idCliente = idCliente;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }
    
    public int getClienteId (){
        return idCliente;
    }
    
    public void setIdCliente (){
        this.idCliente = idCliente;
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
    
    @Override
    public String toString() {
        String desc = "Animal {" + "id= " + id + ",idCliente= " + idCliente + ", nome= " + nome + ", idade= " + idade + ", sexo" + sexo + '}' + '\n';
        return desc;
    }
}
