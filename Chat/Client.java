package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8189);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            Thread responseThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Введите ник и нажмите enter: ");

                    while (true){
                        String nickname = null;
                        String response = null;
                        try {
                       

                            nickname = in.readUTF();
                            response = in.readUTF();
                            System.out.println(response);
                            while (true) {
                            

                                System.out.println(nickname+": "+response);
                                break;

                            }
                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            });

            responseThread.start();
            while (true){
                String str = scanner.nextLine();
                out.writeUTF(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
