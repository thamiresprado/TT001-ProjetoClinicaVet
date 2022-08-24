public class Animal {
    private int id;
    private String nome;
    private int idade;
    private boolean sexo; // false - Macho, true - Fêmea

    public Animal(int id, String nome, int idade, boolean sexo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
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
}
