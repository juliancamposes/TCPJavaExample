package Server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private final ServerSocket serverSocket;
    private final int PORT = 9876;
    private Socket socket;
    private String name;

    private int numberOfTask;

    public Server() throws IOException{
        this.serverSocket = new ServerSocket(PORT);
    }

    public void waitConnection()throws IOException{
        System.out.println("Waiting connection...");
        socket = serverSocket.accept();

    }

    public void communication() throws IOException{
        //Streams for the communcation
        DataInputStream getData = null;
        DataOutputStream sendData = null;
        getData = new DataInputStream(socket.getInputStream());
        sendData = new DataOutputStream(socket.getOutputStream());

        //Asking name
        try{
            sendData.writeUTF("What is your name?");
            name = getData.readUTF();
            System.out.println("Welcome " + name);
            sendData.writeUTF("How many task do you want realise?");
            numberOfTask = getData.readInt();
            System.out.println("You want realise " + numberOfTask + " tasks");

            List<Task> tasks = new ArrayList<Task>();
            String taskDescription;
            String taskStatus;

            for(int i  = 0; i < numberOfTask; i++){
                int task = i + 1;
                sendData.writeUTF("Write the description of the task number " + task);
                taskDescription = getData.readUTF();

                sendData.writeUTF("Write the status of the task number " + task);
                taskStatus = getData.readUTF();

                Task tareaUser = new Task(taskDescription, taskStatus);
                tasks.add(tareaUser);
            }

            sendData.writeUTF("Sending tasks...");

            for(int i = 0; i < tasks.size(); i++){
                int task = i + 1;
                Task tareaRecovery = tasks.get(i);
                String taskDescriptionRecovery = tareaRecovery.getTaskDescription();
                String taskStatusRecovery = tareaRecovery.getTaskStatus();

                sendData.writeUTF("The task number " + task + " has the description " + taskDescriptionRecovery + " and the status " + taskStatusRecovery);

            }
            System.out.println("End of the communication");
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
