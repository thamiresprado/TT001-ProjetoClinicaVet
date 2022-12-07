
import Model.VeterinarioDAO;
import Model.TratamentoDAO;
import Model.ConsultaDAO;
import Model.ClienteDAO;
import Model.AnimalDAO;
import Model.Cliente;
import Model.Consulta;
import Model.Especie;
import Model.EspecieDAO;
import Model.Exame;
import Model.ExameDAO;
import Model.Tratamento;
import Model.Veterinario;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//----------------------------------- CLIENTE
//            System.out.println("Clientes adicionados");
//            ClienteDAO.getInstance().create("Roberto", "Rua 1", "0000-0000", "roberto@gmail.com");
//            ClienteDAO.getInstance().create("Juliana", "Rua 2", "1111-1111", "juliana@gmail.com");
//            ClienteDAO.getInstance().create("Rodolfo", "Rua 3", "2222-2222", "rodolfo@gmail.com");
//            ClienteDAO.getInstance().create("Paulo", "Rua do Paulo", "1234-5679", "paulo@gmail.com");
//            ClienteDAO.getInstance().create("Lucas", "Rua do Lucas", "8765-4321", "lucas@gmail.com");
///          
//            System.out.println(ClienteDAO.getInstance().retrieveAll());
//----------------------------------- ANIMAL
//            System.out.println("Adicionando animais");
//            AnimalDAO.getInstance().create("Lulu", 12, "Fêmea", 1, 1);
//            AnimalDAO.getInstance().create("Pepe", 12, "Macho", 1, 3);
//            AnimalDAO.getInstance().create("Pipo", 12, "Macho", 1, 1);
//            AnimalDAO.getInstance().create("Zezinho", 12, "Fêmea", 2, 2);
//            AnimalDAO.getInstance().create("Alface", 12, "Macho", 2, 4);
//            
//            System.out.println(AnimalDAO.getInstance().retrieveAll());
//----------------------------------- ESPECIE
//            System.out.println("Adicionando novas espécies");
//            EspecieDAO.getInstance().create("Gato");
//            EspecieDAO.getInstance().create("Pássaro");
//            EspecieDAO.getInstance().create("Cachorro");
//            EspecieDAO.getInstance().create("Cobra");
//            System.out.println(EspecieDAO.getInstance().retrieveAll());
//            System.out.println(EspecieDAO.getInstance().retrieveById(3));
//            Especie esp = EspecieDAO.getInstance().retrieveById(3);
//            EspecieDAO.getInstance().delete(esp); 
//            System.out.println(EspecieDAO.getInstance().retrieveAll());
//----------------------------------- VETERINARIO
//            System.out.println("Adicionando novos veterinarios");
//            VeterinarioDAO.getInstance().create("Luciana", "luciana@gmail.com", "0000-0000");
//            VeterinarioDAO.getInstance().create("Marcos", "marcos@gmail.com", "1111-1111");
//            VeterinarioDAO.getInstance().create("Luis", "luis@gmail.com", "1234-5678");
//            VeterinarioDAO.getInstance().create("Amanda", "amanda@gmail.com", "9849-2837");
//              
//            System.out.println(VeterinarioDAO.getInstance().retrieveAll());
//----------------------------------- TRATAMENTO
//            System.out.println("Adicionando tratamento");
//            TratamentoDAO.getInstance().create("Tratamento de pulgas", "Animal está com muita pulga", "09/10/2022", "tratamento aberto", 1, false);
//            TratamentoDAO.getInstance().create("Tratamento para o pelo", "Pelo do animal está caindo muito", "09/10/2022", "tratamento aberto", 1, false);
//            TratamentoDAO.getInstance().create("Tratamento Gravidez", "Gravidez em condição normal", "06/11/2022", "tratamento aberto", 1, false);
//            TratamentoDAO.getInstance().create("Tratamento de pulgas", "Animal está com muita pulga", "09/10/2022", "09/11/2022", 2, true);
//            Tratamento esp = TratamentoDAO.getInstance().retrieveById(17);
//            TratamentoDAO.getInstance().delete(esp); 
//            System.out.println(TratamentoDAO.getInstance().retrieveAll());
//----------------------------------- CONSULTA
//            System.out.println("Adicionando consulta");
//            ConsultaDAO.getInstance().create("09/10/2022", "Consulta inicial", 1, 1, 1);
//            ConsultaDAO.getInstance().create("09/11/2022", "Retorno após 1 mês de medicação", 1, 1, 1);
//            ConsultaDAO.getInstance().create("15/11/2022", "Acompanhamento de gravidez", 1, 2, 3);

//            Consulta esp = ConsultaDAO.getInstance().retrieveById(25);
//            ConsultaDAO.getInstance().delete(esp); 
            System.out.println(ConsultaDAO.getInstance().retrieveAll());
//----------------------------------- EXAME
//            ExameDAO.getInstance().create("Coleta de sangue", "Ver se tem doença do carrapato", 1);
//            ExameDAO.getInstance().create("Coleta de sangue", "Estado da doença", 1);
//            ExameDAO.getInstance().create("Ultrassom", "Ver se tem doença do carrapato", 3);
//            Exame exame = ExameDAO.getInstance().retrieveById(25);
//            ExameDAO.getInstance().delete(exame); 
//            System.out.println(ExameDAO.getInstance().retrieveByIdConsulta(25));
    }
}
