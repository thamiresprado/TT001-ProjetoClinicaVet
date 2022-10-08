public class Consulta {
    private int id;
    private String data;
    private String descricao;
    private int idAnimal;
    private int idVet;
    private int idTratamento;

    public Consulta(int id, String data, String descricao, int idAnimal, int idVet, int idTratamento) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.idAnimal = idAnimal;
        this.idVet = idVet;
        this.idTratamento = idTratamento;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public int getIdVet() {
        return idVet;
    }

    public int getIdTratamento() {
        return idTratamento;
    }
}
