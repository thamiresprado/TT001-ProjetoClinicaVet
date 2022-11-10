package View;

import java.util.List;
import Model.Animal;
import Model.AnimalDAO;
import Model.Cliente;
import Model.ClienteDAO;
import Model.Especie;
import Model.EspecieDAO;

public class AnimalTableModel extends GenericTableModel {

    public AnimalTableModel(List vDados) {
        super(vDados, new String[]{"Nome", "Idade", "Sexo", "Cliente", "Especie"});
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return Integer.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return animal.getNome();
            case 1:
                return animal.getIdade();
            case 2:
                return animal.getSexo();
            case 3:
                Cliente clientes = ClienteDAO.getInstance().retrieveById(animal.getClienteId());
                if (clientes != null){
                    return clientes.getNome();
                }
                return "";
            case 4:
                Especie especies = EspecieDAO.getInstance().retrieveById(animal.getidEspecie());
                if (especies != null) {
                    return especies.getNome();
                }
                return "";
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    //    String nome, int idade, boolean sexo, int idCliente, int idEspecie
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                animal.setNome((String) aValue);
                break;
            case 1:
                animal.setIdade((Integer)aValue);
                break;
            case 2:
                animal.setSexo((String) aValue);
                break;
            case 3:
                Cliente clientes = ClienteDAO.getInstance().retrieveById(animal.getClienteId());
                if (clientes != null){
                    clientes = ClienteDAO.getInstance().create((String) aValue, (String) aValue, (String) aValue, (String) aValue);
                }
                animal.setIdCliente(clientes.getId());
                break;
            case 4:
                Especie especies = EspecieDAO.getInstance().retrieveById(animal.getidEspecie());
                if (especies == null) {
                    especies = EspecieDAO.getInstance().create((String) aValue);
                    animal.setidEspecie(especies.getId());
                }
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        AnimalDAO.getInstance().update(animal);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

}
