public class Main {
        public static void  main (String[] args){
            
            System.out.println("Clientes adicionados");
            ClienteDAO.getInstance().create("Cliente 1", "Rua 1", "0000-0000", "cliente1@gmail.com");
            ClienteDAO.getInstance().create("Cliente 2", "Rua 2", "0000-0000", "cliente2@gmail.com");
            
            System.out.println(ClienteDAO.getInstance().retrieveAll());
            
            System.out.println("\nRetornando o cliente com id 1");
            System.out.println(ClienteDAO.getInstance().retrieveById(1));
            
            System.out.println("Atualizando o cliente com id 4");
            ClienteDAO.getInstance().update("Juninho", "Rua de Setembro", "1111-111", "juninho@gmail.com");
            
            System.out.println(ClienteDAO.getInstance().retrieveAll());
            
            /*System.out.println("Adicionando animais");
            AnimalDAO.getInstance().create(3, 1, "Lulu", 12, true);
            AnimalDAO.getInstance().create(2, 1, "Zeca", 3, false);
            
            System.out.println(AnimalDAO.getInstance().retrieveAll());
            
            System.out.println("Retornando animais do cliente com id 1");
            System.out.println(AnimalDAO.getInstance().retrieveByIDCliente(1));*/
        }
}
