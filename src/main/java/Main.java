public class Main {
        public static void  main (String[] args){
            
            System.out.println("Clientes adicionados");
            ClienteDAO.getInstance().create("Pedro", "Rua 2", "0000-000", "pedro@gmail.com");
            ClienteDAO.getInstance().create("Luisa", "Rua Azul", "0000-000", "luisa@gmail.com");
            
            System.out.println(ClienteDAO.getInstance().retrieveAll());
            
            System.out.println("Retornando o cliente com id 1");
            System.out.println(ClienteDAO.getInstance().retrieveByID(1));
            
            System.out.println("Atualizando o cliente com id 0");
            ClienteDAO.getInstance().update(0,"Juninho", "Rua de Setembro", "1111-111", "juninho@gmail.com");
            
            System.out.println(ClienteDAO.getInstance().retrieveAll());
            
            System.out.println("Adicionando animais");
            AnimalDAO.getInstance().create(3, 1, "Lulu", 12, true);
            AnimalDAO.getInstance().create(2, 1, "Zeca", 3, false);
            
            System.out.println(AnimalDAO.getInstance().retrieveAll());
            
            System.out.println("Retornando animais do cliente com id 1");
            System.out.println(AnimalDAO.getInstance().retrieveByIDCliente(1));
        }
}
