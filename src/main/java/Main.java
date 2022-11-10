
import Model.VeterinarioDAO;
import Model.TratamentoDAO;
import Model.ConsultaDAO;
import Model.ClienteDAO;
import Model.AnimalDAO;
import Model.Cliente;
import Model.Especie;
import Model.EspecieDAO;
import Model.ExameDAO;
import Model.Veterinario;
import java.util.List;

public class Main {
        public static void  main (String[] args){
            
//----------------------------------- CLIENTE
//            System.out.println("Clientes adicionados");
//            ClienteDAO.getInstance().create("Cliente 1", "Rua 1", "0000-0000", "cliente1@gmail.com");
////            ClienteDAO.getInstance().create("Cliente 2", "Rua 2", "0000-0000", "cliente2@gmail.com");
//            ClienteDAO.getInstance().create("Rodolfo", "Rua 3", "0000-0000", "cliente3@gmail.com");
////            
//            System.out.println(ClienteDAO.getInstance().retrieveAll());
//            
//            System.out.println("\nRetornando o cliente com id 1");
//            System.out.println(ClienteDAO.getInstance().retrieveById(1));
            
            //Update em todos os campos
//            Cliente c1 = new Cliente(4, "Juninho", "Rua de Setembro", "1111-111", "juninho@gmail.com");
//            ClienteDAO.getInstance().update(c1);
            
            //Update em campo unico: definir o set desejado
//            Cliente c2 = ClienteDAO.getInstance().retrieveById(1);
//            c2.setNome("Joao");
//            ClienteDAO.getInstance().update(c2);
            
            
            //Deletando cliente do banco
//            Cliente c3 = ClienteDAO.getInstance().retrieveById(14);
//            ClienteDAO.getInstance().delete(c3);
//            
//            System.out.println(ClienteDAO.getInstance().retrieveAll());

//----------------------------------- ANIMAL
            
//            System.out.println("Adicionando animais");
//            AnimalDAO.getInstance().create("Lulu", 12, true, 1, 1);
//            AnimalDAO.getInstance().create("Pepe", 12, false, 3, 2);
//            AnimalDAO.getInstance().create("Pipo", 12, false, 3, 2);
            
            System.out.println(AnimalDAO.getInstance().retrieveAll());
//            
//            System.out.println("\nRetornando os animais do cliente com id 3");
//            System.out.println(AnimalDAO.getInstance().retrieveByIdCliente(3));
            
//----------------------------------- ESPECIE
            
//            System.out.println("Adicionando novas espécies");
//            EspecieDAO.getInstance().create("Gato");
//            EspecieDAO.getInstance().create("Pássaro");
//            EspecieDAO.getInstance().create("Cobra");
            
//            System.out.println(EspecieDAO.getInstance().retrieveAll());
            
//            System.out.println(EspecieDAO.getInstance().retrieveById(3));
            
//            Especie esp = EspecieDAO.getInstance().retrieveById(3);
//            EspecieDAO.getInstance().delete(esp); 

//              System.out.println(EspecieDAO.getInstance().retrieveAll());
            
            
//----------------------------------- VETERINARIO
//            System.out.println("Adicionando novos veterinarios");
//              VeterinarioDAO.getInstance().create("Vet1", "vet1@gmail.com", "0000-0000");
//              VeterinarioDAO.getInstance().create("Vet2", "vet2@gmail.com", "0000-0000");
//              
//              System.out.println(VeterinarioDAO.getInstance().retrieveAll());

//            System.out.println(VeterinarioDAO.getInstance().retrieveById(4));
//              
//               //Update em todos os campos
//            Veterinario c1 = new Veterinario(4, "Juninho", "email@email", "1111-111");
//            VeterinarioDAO.getInstance().update(c1);
//              
//            System.out.println(VeterinarioDAO.getInstance().retrieveById(4));

//----------------------------------- TRATAMENTO
//                System.out.println("Adicionando tratamento");
//                TratamentoDAO.getInstance().create("Tratamento1", "descricao do tratamento", "09/10/2022", "tratamento aberto", 1, false);
//                TratamentoDAO.getInstance().create("Tratamento1", "descricao do tratamento", "09/10/2022", "tratamento aberto", 2, false);
//                  TratamentoDAO.getInstance().create("Tratamentooooo", "descricao do tratamento", "06/11/2022", "tratamento aberto", 1, false);
                
//                System.out.println(TratamentoDAO.getInstance().retrieveByIdAnimal(1));


//----------------------------------- CONSULTA
//                System.out.println("Adicionando consulta");
//                ConsultaDAO.getInstance().create("09/10/2022", "consulta de rotina", 1, 1, 1);
//                  ConsultaDAO.getInstance().create("09/10/2022", "mais uma", 1, 1, 1);
//                  System.out.println(ConsultaDAO.getInstance().retrieveByIdTratamento(1));

//----------------------------------- EXAME
//                ExameDAO.getInstance().create("Coleta de sangue", "Ver se tem doença do carrapto", 1);

        }
}
