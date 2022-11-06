package View;

import java.util.List;
import Model.Animal;
import Model.AnimalDAO;
import Model.Especie;
import Model.EspecieDAO;


public class AnimalTableModel extends GenericTableModel {
    
    public AnimalTableModel (List vDados){
        super(vDados, new String[]{"Nome", "Sexo", "Especie"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch(columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return animal.getNome();
            case 1:
                return animal.getSexo();
            case 2:
                Especie especies = EspecieDAO.getInstance().retrieveById(animal.getidEspecie());
                if (especies != null){
                    return especies.getNome();
                }
                return "";
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue,int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                animal.setNome((String) aValue);
                break;
            case 1:
                animal.setSexo((Boolean) aValue);
                break;
            case 2:
                Especie especies = EspecieDAO.getInstance().retrieveById(animal.getidEspecie());
                if (especies != null){
                    especies = EspecieDAO.getInstance().create((String) aValue);
                }
                animal.setidEspecie(especies.getId());
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        AnimalDAO.getInstance().update(animal);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }

}
