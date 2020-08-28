import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Arrays;

public class ProxyCheckerN2 {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("/Users/marianna/Documents/Marianna/Documents/STUDY/test.txt");
        int c;
        String ipList = "";
        while ((c = reader.read()) != -1) {
            ipList += (char) c;
        }
        String[] ipListArray = ipList.split("\\n");
        for (int i = 0; i < ipListArray.length; i++) {
            String[] splitString = ipListArray[i].split(":");
            String ip = splitString[0].trim();
            int port = Integer.parseInt(splitString[1]);

            Thread t1 = new Thread(new MyRunnableClass(ip,port));
            Thread t2 = new Thread(new MyRunnableClass(ip,port));
            t1.start();
            t2.start();

        }
    }

    class Thread {
        String ip;
        int port;

        public Thread(String ip, int port) {
            this.ip = ip;
            this.port = port;
        }
    }

    class MyRunnableClass implements Runnable {
        String ip;
        int port;

        @Override
        public void run() {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));

            try {
                URLConnection connection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);

                InputStream is = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(is);
                char[] buffer = new char[256];
                int rc;

                StringBuilder sb = new StringBuilder();

                while ((rc = reader.read(buffer)) != -1)
                    sb.append(buffer, 0, rc);

                reader.close();

                for (int i = 0; i < 100; i++)
                    System.out.println("ip: " + ip + ":" + port + " - ДОСТУПЕН");
            } catch (Exception e) {
                System.out.println("ip: " + ip + ":" + port + " - недоступен");
            }
        }
    }
}
