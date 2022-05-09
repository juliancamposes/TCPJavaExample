package Client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        //Creating connection with the server
        Client client = null;
        try {
            client = new Client("localhost", 9876);
            System.out.println("Client connected!");
        } catch (IOException ex){
            System.err.println("Oops! We can't connect with the server");
            ex.printStackTrace();
        }

        //Creating the communication
            client.communication();
    }
}
