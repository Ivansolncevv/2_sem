package HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class toserver {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(88);//Где 80- номер порта, их может быть 65535
        while (true) {
            Socket s = ss.accept();
            Runnable action = () -> handle(s);
            new Thread (action).start();
        }

    }

    private static void handle(Socket s) {
        Pattern p = Pattern.compile("GET\\s+(\\S+)");
        try {
            try {
                BufferedReader rdr = new BufferedReader(
                        new InputStreamReader(
                                s.getInputStream(), "US-ASCII"));
                while (true) {
                    String line = rdr.readLine();
                    if (line == null || line.isEmpty()) break;
                    Matcher m = p.matcher(line);
                    if (m.find()) {
                        String resource = m.group(1);
                        System.out.println(resource);
                    }
                }
                OutputStream os = s.getOutputStream();
                os.write("Hello world".getBytes("US-ASCII"));
            } finally {
                s.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}


