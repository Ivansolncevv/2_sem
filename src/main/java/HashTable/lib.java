package HashTable;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class lib {
    public static void main(String[] args) throws IOException {
        URL url=new URL ("http://lib.ru");
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        try(InputStream is=conn.getInputStream()){
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            while(true){
                int c=is.read();
                if (c<0)break;
                bos.write(c);
            }
            System.out.println(bos.toString( "CP1251"));
        }
        conn.disconnect();
    }
}
