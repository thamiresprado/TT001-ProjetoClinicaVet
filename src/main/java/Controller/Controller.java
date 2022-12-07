package Controller;

import Model.Animal;
import Model.AnimalDAO;
import Model.Cliente;
import Model.ClienteDAO;
import Model.Consulta;
import Model.ConsultaDAO;
import Model.Tratamento;
import Model.TratamentoDAO;
import Model.Veterinario;
import Model.VeterinarioDAO;
import View.AnimalTableModel;
import View.ClienteTableModel;
import View.DetalhesTratTableModel;
import View.GenericTableModel;
import View.TratamentoTableModel;
import View.VeterinarioTableModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Controller {

    private static Animal animalSelecionado = null;
    private static Cliente clienteSelecionado = null;
    private static Tratamento tratamentoSelecionado = null;
    private static Veterinario veterinarioSelecionado = null;
    private static Consulta consultaSelecionada = null;
    private static JTextField clienteSelecionadoTextField = null;
    private static JTextField animalSelecionadoTextField = null;
    private static JTextField veterinarioSelecionadoJTextField = null;

    public static void setTextFields(JTextField cliente, JTextField animal) {
        clienteSelecionadoTextField = cliente;
        animalSelecionadoTextField = animal;
        
    }

    public static void setTableModel(JTable table, GenericTableModel tableModel) {
        table.setModel(tableModel);
    }

    public static Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public static Animal getAnimalSelecionado() {
        return animalSelecionado;
    }

    public static Tratamento getTratamentoSelecionado() {
        return tratamentoSelecionado;
    }
    
     public static Consulta getConsultaSelecionada() {
        return consultaSelecionada;
    }
    
    public static Veterinario getVeterinarioSelecionado() {
        return veterinarioSelecionado;
    }

    public static void setSelected(Object selected) {
        if (selected instanceof Cliente) {
            clienteSelecionado = (Cliente) selected;
            clienteSelecionadoTextField.setText(clienteSelecionado.getNome());
            animalSelecionadoTextField.setText("");
        } else if (selected instanceof Animal) {
            animalSelecionado = (Animal) selected;
            animalSelecionadoTextField.setText(animalSelecionado.getNome());
        } else if (selected instanceof Tratamento) {
            tratamentoSelecionado = (Tratamento) selected;
        } else if (selected instanceof Veterinario){
            veterinarioSelecionado = (Veterinario) selected;
        } else if (selected instanceof Consulta){
            consultaSelecionada = (Consulta) selected;
        }
    }

    public static List getAllClientes() {
        return ClienteDAO.getInstance().retrieveAll();
    }

    public static List getAllAnimais() {
        return AnimalDAO.getInstance().retrieveAll();
    }

    public static List getAllTratamentos() {
        return TratamentoDAO.getInstance().retrieveAll();
    }

    public static List getAllConsultas() {
        return ConsultaDAO.getInstance().retrieveAll();
    }

    public static List getAllVeterinarios() {
        return VeterinarioDAO.getInstance().retrieveAll();
    }

    //CONEXÃO DAS TABELAS
    //Tabela cliente exibe animais do cliente selecionado
    public static void tabelaClienteSelected(JTable table) {
        if (getClienteSelecionado() != null) {
            setTableModel(table, new AnimalTableModel(AnimalDAO.getInstance().retrieveByIdCliente(Controller.getClienteSelecionado().getId())));
        } else {
            setTableModel(table, new AnimalTableModel(new ArrayList()));
        }
    }

    //Tabela animal exibe tratamentos do animal selecionado
    public static void tabelaAnimalSelected1(JTable table) {
        if (getAnimalSelecionado() != null) {
            setTableModel(table, new TratamentoTableModel(TratamentoDAO.getInstance().retrieveByIdAnimal(Controller.getAnimalSelecionado().getId())));
        } else {
            Controller.setTableModel(table, new TratamentoTableModel(new ArrayList()));
        }
    }
    
     //Tabela animal exibe consultas do animal selecionado
    public static void tabelaAnimalSelected2(JTable table) {
        if (getAnimalSelecionado() != null) {
            setTableModel(table, new DetalhesTratTableModel((ConsultaDAO.getInstance().retrieveByIdAnimal(Controller.getAnimalSelecionado().getId()))));
        } else {
            Controller.setTableModel(table, new TratamentoTableModel(new ArrayList()));
        }
    }

    //Tabela de tratamentos exibe consultas do tratamento selecionado
    public static void tabelaTratamentoSelected(JTable table) {
        if (getTratamentoSelecionado() != null) {
            setTableModel(table, new DetalhesTratTableModel((ConsultaDAO.getInstance().retrieveByIdTratamento(Controller.getTratamentoSelecionado().getId()))));
        }
    }

    //Quando um novo cliente for selecionado, limpar os tratamentos exibidos no cliente anterior
    public static void limpaExibicao(JTable table) {
        if (table.getModel() instanceof TratamentoTableModel) {
            ((TratamentoTableModel) table.getModel()).clear();
        } 
    }

    //BUSCA NOS CAMPOS
    public static void busca(JTable table, JTextField campo) {
        if (table.getModel() instanceof ClienteTableModel) {
            ((ClienteTableModel) table.getModel()).addListOfItems(ClienteDAO.getInstance().retrieveBySimilarName(campo.getText()));
        } else if (table.getModel() instanceof AnimalTableModel) {
            ((AnimalTableModel) table.getModel()).addListOfItems(AnimalDAO.getInstance().retrieveBySimilarName(campo.getText()));
        } else if (table.getModel() instanceof VeterinarioTableModel) {
            ((VeterinarioTableModel) table.getModel()).addListOfItems(VeterinarioDAO.getInstance().retrieveBySimilarName(campo.getText()));
        }
    }

    //ADICIONANDO NOVOS ITENS
    public static Cliente adicionaCliente(String nome, String end, String telefone, String email) {
        return ClienteDAO.getInstance().create(nome, end, telefone, email);
    }

    public static Animal adicionaAnimal(String nome, int idade, String sexo, int idCliente, int idEspecie) {
        return AnimalDAO.getInstance().create(nome, idade, sexo, idCliente, idEspecie);
    }
    
    public static Veterinario adicionaVeterinario(int id, String nome, String email, String telefone){
        return VeterinarioDAO.getInstance().create(nome, email, telefone);
    }
    
    public static Consulta adicionaConsulta(String data, String descricao, int idAnimal, int idVet, int idTratamento){
        return ConsultaDAO.getInstance().create(data, descricao, idAnimal, idVet, idTratamento);
    }
    
    public static Tratamento adicionaTratamento(String nome, String descricao, String dtIni, String dtFim, int idAnimal, boolean encerrado){
        return TratamentoDAO.getInstance().create(nome, descricao, dtIni, dtFim, idAnimal, encerrado);
    }
    
   //REMOVENDO
   
   public static void removerCliente(Cliente cliente) {
       List <Animal> animais = AnimalDAO.getInstance().retrieveByIdCliente(cliente.getId());
       for (Animal animal : animais){
           AnimalDAO.getInstance().delete(animal);
       }
        ClienteDAO.getInstance().delete(cliente);
    }
   
   public static void removerAnimal(Animal animal) {
        AnimalDAO.getInstance().delete(animal);
    }
   
   public static void removerVeterinario(Veterinario veterinario) {
        VeterinarioDAO.getInstance().delete(veterinario);
    }
   
   public static void removerConsulta(Consulta consulta) {
        ConsultaDAO.getInstance().delete(consulta);
    }
   
   public static void removerTratamento(Tratamento tratamento){
//       TratamentoDAO.getInstance().delete(tratamento);
     List <Consulta> consultas = ConsultaDAO.getInstance().retrieveByIdTratamento(tratamento.getId());
       for (Consulta consulta : consultas){
           ConsultaDAO.getInstance().delete(consulta);
       }
        TratamentoDAO.getInstance().delete(tratamento);
        
   }
}
