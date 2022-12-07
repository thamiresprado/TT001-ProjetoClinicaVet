package View;

import Model.Animal;
import Model.AnimalDAO;
import Model.ClienteDAO;
import Model.Consulta;
import Model.ConsultaDAO;
import Model.Exame;
import Model.ExameDAO;
import Model.Tratamento;
import Model.TratamentoDAO;
import Model.Veterinario;
import Model.VeterinarioDAO;
import java.util.List;



public class DetalhesTratTableModel extends GenericTableModel {
    
    public DetalhesTratTableModel (List vDados){
        super(vDados, new String[]{"Data", "Descrição", "Animal", "Veterinário responsável", "Exame"});
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
            case 3:
                return String.class;
            case 4:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
//    Especie especies = EspecieDAO.getInstance().retrieveById(animal.getidEspecie());
//                if (especies != null){
//                    return especies.getNome();
//                }
//                return "";

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return consulta.getData();
            case 1:
                return consulta.getDescricao();
            case 2:
                return AnimalDAO.getInstance().retrieveById(consulta.getIdAnimal()).getNome();
//                return ClienteDAO.getInstance().retrieveById(animal.getClienteId()).getNome();
            case 3:
                return VeterinarioDAO.getInstance().retrieveById(consulta.getIdVet());
            case 4:
                return ExameDAO.getInstance().retrieveByIdConsulta(consulta.getId());
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

                
    @Override
    public void setValueAt(Object aValue,int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex); 
        
        switch(columnIndex) {
            case 0:
                consulta.setData((String) aValue);
                break;
            case 1:
                consulta.setDescricao((String) aValue);
                break;
            case 2:
                break;
             case 3:
                break;
            case 4:
                ExameDAO.getInstance().create((String) aValue, (String) aValue, consulta.getId());
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
       ConsultaDAO.getInstance().update(consulta);
    }
//    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        if(columnIndex<=1||columnIndex>=4){
            return true;
        } else{
            return false;
        }
    }
}
