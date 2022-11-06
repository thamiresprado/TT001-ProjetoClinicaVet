package View;

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
        super(vDados, new String[]{"Consulta", "Exame solicitado", "Veterinário responsável"});
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
                return consulta.getDescricao();
            case 1:
                Exame exames = ExameDAO.getInstance().retrieveById(consulta.getId());
                if(exames != null){
                    return exames.getNome();
                }
                return "";
            case 2:
                Veterinario veterinario = VeterinarioDAO.getInstance().retrieveById(consulta.getIdVet());
                if (veterinario != null){
                    return veterinario.getNome();
                }
                return "";
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

                
//    @Override
//    public void setValueAt(Object aValue,int rowIndex, int columnIndex) {
//        Consulta consulta = (Consulta) vDados.get(rowIndex); 
//        
//        switch(columnIndex) {
//            case 0:
//                tratamento.setNome((String) aValue);
//                break;
//            case 1:
//                tratamento.setDtIni((String) aValue);
//                break;
//            case 2:
//                consulta.setIdVet((Integer) aValue);
//                break;
//            default:
//                throw new IndexOutOfBoundsException("columnIndex out of bounds");
//        }
//        
//       TratamentoDAO.getInstance().update(tratamento);
//    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
}
