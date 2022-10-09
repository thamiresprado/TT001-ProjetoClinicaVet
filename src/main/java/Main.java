
import java.util.List;

public class Main {
        public static void  main (String[] args){
            
//----------------------------------- CLIENTE
            System.out.println("Clientes adicionados");
            ClienteDAO.getInstance().create("Cliente 1", "Rua 1", "0000-0000", "cliente1@gmail.com");
            ClienteDAO.getInstance().create("Cliente 2", "Rua 2", "0000-0000", "cliente2@gmail.com");
            ClienteDAO.getInstance().create("Cliente 3", "Rua 3", "0000-0000", "cliente3@gmail.com");
//            
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
//            Cliente c3 = ClienteDAO.getInstance().retrieveById(2);
//            ClienteDAO.getInstance().delete(c3);
//            
//            System.out.println(ClienteDAO.getInstance().retrieveAll());

//----------------------------------- ANIMAL
            
            System.out.println("Adicionando animais");
            AnimalDAO.getInstance().create("Lulu", 12, true, 1, 1);
            AnimalDAO.getInstance().create("Pepe", 12, false, 3, 2);
            AnimalDAO.getInstance().create("Pipo", 12, false, 3, 2);
//            
//            System.out.println(AnimalDAO.getInstance().retrieveAll());
//            
//            System.out.println("\nRetornando os animais do cliente com id 3");
//            System.out.println(AnimalDAO.getInstance().retrieveByIdCliente(3));
            
//----------------------------------- ESPECIE
            
//            System.out.println("Adicionando novas espécies");
//            EspecieDAO.getInstance().create("Gato");
//            EspecieDAO.getInstance().create("Pássaro");
//            EspecieDAO.getInstance().create("Cobra");
//            
//            List<Especie> especies = EspecieDAO.getInstance().retrieveAll();
//            
//            for (Especie especie : especies) {
//            System.out.println("id=" + especie.getId() + ", name=" + especie.getNome());
//            }
            
//            Especie esp = EspecieDAO.getInstance().retrieveById(3);
//            EspecieDAO.getInstance().delete(esp); //nao ta funcionando
            
            
//----------------------------------- VETERINARIO
//              System.out.println("Adicionando novos veterinarios");
              VeterinarioDAO.getInstance().create("Vet1", "vet1@gmail.com", "0000-0000");
              VeterinarioDAO.getInstance().create("Vet2", "vet2@gmail.com", "0000-0000");
//              
//              List<Veterinario> veterinarios = VeterinarioDAO.getInstance().retrieveAll();
//            
//              for (Veterinario veterinario : veterinarios) {
//              System.out.println("id=" + veterinario.getId() + ", name=" + veterinario.getNome());
//              }
//              

//----------------------------------- TRATAMENTO
                System.out.println("Adicionando tratamento");
                TratamentoDAO.getInstance().create("Tratamento1", "descricao do tratamento", "09/10/2022", "tratamento aberto", 1, false);


//----------------------------------- CONSULTA
                System.out.println("Adicionando consulta");
                ConsultaDAO.getInstance().create("09/10/2022", "consulta de rotina", 1, 1, 1);
                

//----------------------------------- EXAME











        }
}
