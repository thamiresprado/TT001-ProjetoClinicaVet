package View;

import Model.Veterinario;
import Model.VeterinarioDAO;
import java.util.List;


public class VeterinarioTableModel extends GenericTableModel {
    
    public VeterinarioTableModel (List vDados){
        super(vDados, new String[]{"ID", "Nome", "Email", "Telefone"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch(columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veterinario veterinario = (Veterinario) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return veterinario.getId();
            case 1:
                return veterinario.getNome();
            case 2:
                return veterinario.getEmail();
            case 3:
                return veterinario.getTelefone();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue,int rowIndex, int columnIndex) {
        Veterinario veterinario = (Veterinario) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                veterinario.getId();
                break;
            case 1:
                veterinario.setNome((String) aValue);
                break;
            case 2:
                veterinario.setEmail((String) aValue);
                break;
            case 3:
                veterinario.setTelefone((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        VeterinarioDAO.getInstance().update(veterinario);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }

}
