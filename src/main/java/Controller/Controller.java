
package Controller;

import Model.Animal;
import Model.AnimalDAO;
import Model.Cliente;
import Model.ClienteDAO;
import Model.ConsultaDAO;
import Model.Especie;
import Model.TratamentoDAO;
import View.AnimalTableModel;
import java.util.List;
import View.GenericTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Controller {
    private static Animal animalSelecionado = null;
    private static Cliente clienteSelecionado = null;
    private static Animal especieSelecionado = null;
    private static JTextField clienteSelecionadoTextField = null;
    private static JTextField animalSelecionadoTextField = null;
    private static JTextField especieSelecionadoTextField = null;
    
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
    
    public static void setSelected(Object selected){
        if(selected instanceof Cliente){
            clienteSelecionado = (Cliente)selected;
            clienteSelecionadoTextField.setText(clienteSelecionado.getNome());
            animalSelecionadoTextField.setText("");
        } else if(selected instanceof Animal){
            animalSelecionado = (Animal)selected;
            animalSelecionadoTextField.setText(animalSelecionado.getNome());
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


    
}
