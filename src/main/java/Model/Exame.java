package Model;

public class Exame {
    private int id;
    private String nome;
    private String descricao;
    private int idConsulta;

    public Exame(int id, String nome, String descricao, int idConsulta) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.idConsulta = idConsulta;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdConsulta() {
        return idConsulta;
    }
    
    @Override
    public String toString() {
        String desc = nome;
        return desc;
    }
}
