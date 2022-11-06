package View;

import Model.Tratamento;
import Model.TratamentoDAO;
import java.util.List;



public class TratamentoTableModel extends GenericTableModel {
    
    public TratamentoTableModel (List vDados){
        super(vDados, new String[]{"Nome", "Data de Inicio", "Data de Fim", "Concluido"});
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
                return Boolean.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tratamento tratamento = (Tratamento) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return tratamento.getNome();
            case 1:
                return tratamento.getDtIni();
            case 2:
                return tratamento.getDtFim();
            case 3:
                return tratamento.isEncerrado();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue,int rowIndex, int columnIndex) {
        Tratamento tratamento = (Tratamento) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                tratamento.setNome((String) aValue);
                break;
            case 1:
                tratamento.setDtIni((String) aValue);
                break;
            case 2:
                tratamento.setDtFim((String) aValue);
                break;
            case 3:
                tratamento.setEncerrado((Boolean) aValue);
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
       TratamentoDAO.getInstance().update(tratamento);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
}
