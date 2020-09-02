package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8189);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

          //  System.out.println("Введите ник: " +nickname);
//            out.write(Integer.parseInt(scanner.nextLine()));
//            Resender resend = new Resender();
//            resend.start();

            Thread responseThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String response = null;
                        try {
                            response = in.readUTF();
                            System.out.println(response);
                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            });
            responseThread.start();
            while (true) {
                String str = scanner.nextLine();
                out.writeUTF(str);

            //    String response = in.readUTF(); //ждет ответ от сервера
            //    System.out.println(in.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void getNick(Socket clientSocket) throws IOException {
        String nickname = null;
        Writer output = new OutputStreamWriter(new BufferedOutputStream(clientSocket.getOutputStream()));
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        output.write("Введите ник:\n +\r");
        nickname = input.readLine();
    }
//    private class Resender extends Thread {
//        private boolean stoped;
//
//        public void setStop() {
//            stoped = true;
//        }
//        @Override
//        public void run() {
//            try {
//                while (!stoped) {
//                    String str = in.readLine();
//                    System.out.println(str);
//                }
//            } catch (IOException e) {
//                System.err.println("Ошибка при получении сообщения.");
//                e.printStackTrace();
//            }
//        }
//    }
}
