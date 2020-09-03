package server;

import javax.swing.text.StringContent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    static ArrayList<Socket> clients = new ArrayList<>();

    // создаю коллекцию для хранения ников клиентов
    static ArrayList<String> nickname = new ArrayList<>();

    public static void main(String[] args) {
        Socket socket = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен");
            while (true){
                socket = serverSocket.accept();
                clients.add(socket);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             //   System.out.println(nickname+" зашел в чат!");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // добавляю имя в коллекцию
                            String nickname = in.readUTF();
                            out.writeUTF(nickname);
                            System.out.println(nickname+" зашел в чат любителей кодить на Java");
                            while (true){
                                String str = in.readUTF();
                                broadcastMsg(str);
                                System.out.println("Сообщение от "+nickname+": "+str);
                            }
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void broadcastMsg(String str) throws IOException{
        DataOutputStream out;
        for (Socket socket : clients){
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(str);
        }
    }
}
