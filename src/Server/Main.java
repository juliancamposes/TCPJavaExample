package Server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        //Starting Server
        Server server = null;
        try{
            System.out.println("Server starting...");
            server = new Server();
        } catch (IOException e){
            System.err.println("Oops! The server is not started");
            e.printStackTrace();
        }

        try{
            server.waitConnection();
        }catch (IOException e){
            System.err.println("Oops! We can't get the connection with the client");
            e.printStackTrace();
        }

        try{
            server.communication();
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
