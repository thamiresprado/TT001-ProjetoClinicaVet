public class Tratamento {
    private int id;
    private String nome;
    private String descricao;
    private String dtIni;
    private String dtFim;
    private int idAnimal;
    private boolean encerrado;

    public Tratamento(int id, String nome, String descricao, String dtIni, String dtFim, int idAnimal, boolean encerrado) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dtIni = dtIni;
        this.dtFim = dtFim;
        this.idAnimal = idAnimal;
        this.encerrado = encerrado;
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

    public String getDtIni() {
        return dtIni;
    }

    public void setDtIni(String dtIni) {
        this.dtIni = dtIni;
    }

    public String getDtFim() {
        return dtFim;
    }

    public void setDtFim(String dtFim) {
        this.dtFim = dtFim;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public boolean isEncerrado() {
        return encerrado;
    }

    public void setEncerrado(boolean encerrado) {
        this.encerrado = encerrado;
    }  
}
