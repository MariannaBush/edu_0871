package server;

import client.Client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    static ArrayList<Socket> clients = new ArrayList<>();
  //  private ArrayList<ClientNames> clients = new ArrayList<ClientNames>();
    public static void main(String[] args) {
        Socket socket = null;

        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен");

            while (true) {
                socket = serverSocket.accept();
                clients.add(socket);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

           //     ClientNames client = new ClientNames(clients);
            //    clients.add(client);
           //     System.out.println("Клиент "+name+" подключился");

                Thread thread =new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (true){
                                String str = in.readUTF();
                            //    System.out.println("Клиент прислал сообщение");
                            //    out.writeUTF("Сообщение: "+str+" принято");
                                broadcastMsg(str);
                                System.out.println("Клиент прислал сообщение: "+str);
                            }

                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }

        } catch (IOException ex) {
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

//    public static void nickName(String str) {
//        Scanner scan = new Scanner(System.in);
//        if(scan.hasNext(name)){
//            for(int i = 0; i < 10; i++){
//                System.out.println("Привет! "+name);
//            }
//        }
//    }
}
