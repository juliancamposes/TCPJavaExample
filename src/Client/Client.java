package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Socket socket;

    public Client(String HOST, int PORT) throws IOException{
        socket = new Socket(HOST,PORT);
    }

    public void communication(){

        //Creating the streams for the communication
        DataInputStream getData;
        DataOutputStream sendData;

        //Creating of the scanner
        Scanner read = new Scanner(System.in);

        //Communication
        try{
            getData = new DataInputStream(socket.getInputStream());
            sendData = new DataOutputStream(socket.getOutputStream());

            //Name of user
            System.out.println(getData.readUTF());
            String name;
            name = read.nextLine();
            sendData.writeUTF(name);

            //Number of tasks
            System.out.println(getData.readUTF());
            int numberOfTasks;
            numberOfTasks = read.nextInt();
            sendData.writeInt(numberOfTasks);

            for(int i = 0; i < numberOfTasks; i++){
                Scanner readBucle = new Scanner(System.in);

                //Description of the task
                System.out.println(getData.readUTF());
                String description = readBucle.nextLine();
                sendData.writeUTF(description);

                //Status of the task
                System.out.println(getData.readUTF());
                String status = readBucle.nextLine();
                sendData.writeUTF(status);
            }


            //Getting the info of the tasks
            for(int i = 0; i <= numberOfTasks; i++){
                System.out.println(getData.readUTF());
            }
        } catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}
