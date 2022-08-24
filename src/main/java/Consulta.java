public class Consulta {
    private int id;
    private String data;
    private int hora;
    private String sintomas;
    private String diagnostico;
    private String descricao;
    private int idAnimal;
    private int idVet;
    private int idTratamento;

    public Consulta(int id, String data, int hora, String sintomas, String diagnostico, String descricao, int idAnimal, int idVet, int idTratamento) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
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

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
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
