
package Controller;

import Model.Animal;
import Model.AnimalDAO;
import Model.Cliente;
import Model.ClienteDAO;
import Model.ConsultaDAO;
import Model.Tratamento;
import Model.TratamentoDAO;
import Model.VeterinarioDAO;
import View.AnimalTableModel;
import View.ClienteTableModel;
import View.DetalhesTratTableModel;
import View.GenericTableModel;
import View.TratamentoTableModel;
import View.VeterinarioTableModel;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Controller {
    private static Animal animalSelecionado = null;
    private static Cliente clienteSelecionado = null;
    private static Tratamento tratamentoSelecionado = null;
    private static JTextField clienteSelecionadoTextField = null;
    private static JTextField animalSelecionadoTextField = null;
    
    public static void setTextFields(JTextField cliente, JTextField animal){
        clienteSelecionadoTextField = cliente;
        animalSelecionadoTextField = animal;
    }
    
    public static void setTableModel(JTable table, GenericTableModel tableModel){
        table.setModel(tableModel);
    }
    
    public static Cliente getClienteSelecionado(){
        return clienteSelecionado;
    }
    
    public static Animal getAnimalSelecionado(){
        return animalSelecionado;
    }
    
    public static Tratamento getTratamentoSelecionado(){
        return tratamentoSelecionado;
    }
    
    public static void setSelected(Object selected){
        if(selected instanceof Cliente){
            clienteSelecionado = (Cliente)selected;
            clienteSelecionadoTextField.setText(clienteSelecionado.getNome());
            animalSelecionadoTextField.setText("");
        } else if(selected instanceof Animal){
            animalSelecionado = (Animal)selected;
            animalSelecionadoTextField.setText(animalSelecionado.getNome());
        } else if (selected instanceof Tratamento){
            tratamentoSelecionado = (Tratamento)selected;
        }
    }
    
    public static List getAllClientes(){
        return ClienteDAO.getInstance().retrieveAll();
    }
  
    public static List getAllAnimais(){
        return AnimalDAO.getInstance().retrieveAll();
    }
    
    
    public static List getAllTratamentos(){
        return TratamentoDAO.getInstance().retrieveAll();
    }
    
    public static List getAllConsultas(){
        return ConsultaDAO.getInstance().retrieveAll();
    }
    
    public static List getAllVeterinarios(){
        return VeterinarioDAO.getInstance().retrieveAll();
    }

    //CONEXÃO DAS TABELAS
    //Tabela cliente exibe animais do cliente selecionado
    public static void tabelaClienteSelected(JTable table){
        if(getClienteSelecionado() != null){
            setTableModel(table, new AnimalTableModel(AnimalDAO.getInstance().retrieveByIdCliente(Controller.getClienteSelecionado().getId()))); 
        } else{
            setTableModel(table, new AnimalTableModel(new ArrayList()));
        }
    }
    
    //Tabela animal exibe tratamentos do animal selecionado
    public static void tabelaAnimalSelected(JTable table){
        if(getAnimalSelecionado() != null){
            setTableModel(table, new TratamentoTableModel(TratamentoDAO.getInstance().retrieveByIdAnimal(Controller.getAnimalSelecionado().getId())));
        } else{
            Controller.setTableModel(table, new TratamentoTableModel(new ArrayList()));
        }
    }
    
    //Tabela de tratamentos exibe consultas do tratamento selecionado
    public static void tabelaTratamentoSelected(JTable table){
        if(getTratamentoSelecionado() != null){
            setTableModel(table, new DetalhesTratTableModel((ConsultaDAO.getInstance().retrieveByIdTratamento(Controller.getTratamentoSelecionado().getId()))));
        }
    }
    
    //BUSCA NOS CAMPOS
    public static void busca(JTable table, JTextField campo){
        if(table.getModel() instanceof ClienteTableModel){
            ((ClienteTableModel)table.getModel()).addListOfItems(ClienteDAO.getInstance().retrieveBySimilarName(campo.getText()));
        } else if(table.getModel() instanceof AnimalTableModel){
            ((AnimalTableModel)table.getModel()).addListOfItems(AnimalDAO.getInstance().retrieveBySimilarName(campo.getText()));
        } else if(table.getModel() instanceof VeterinarioTableModel){
            ((VeterinarioTableModel)table.getModel()).addListOfItems(VeterinarioDAO.getInstance().retrieveBySimilarName(campo.getText()));
        }
    }
    
    //ADICIONANDO NOVOS ITENS
    public static Cliente adicionaCliente(String nome, String end, String telefone, String email){
        return ClienteDAO.getInstance().create(nome, end, telefone, email);
    }
    
}
