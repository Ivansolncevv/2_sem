package HashTable;


import sun.misc.ASCIICaseInsensitiveComparator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Executors;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

public class server {
    public static void main(String[] args) throws IOException, InterruptedException {
        AsynchronousChannelGroup group = AsynchronousChannelGroup.withThreadPool(Executors.newFixedThreadPool(10));
        AsynchronousServerSocketChannel ass = AsynchronousServerSocketChannel.open(group);
        ass.bind(new InetSocketAddress(88));
        ass.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            public void completed(AsynchronousSocketChannel s, Void param) {
                ass.accept(null, this);
                readRequest(s);

            }

            public void failed(Throwable error, Void param) {
                error.printStackTrace();
            }
        });
        Object x= new Object();
        synchronized (x){
            x.wait();
        }

    }

    static void readRequest(AsynchronousSocketChannel s) {
        ByteBuffer buf = ByteBuffer.allocate(10240);
        StringBuilder request = new StringBuilder();
        s.read(buf, null, new CompletionHandler<Integer, Void>() {
            public void completed(Integer result, Void param) {
                buf.flip();
                byte[] data = new byte[buf.remaining()];
                buf.get(data);
                request.append(new String(data));
                int len = request.length();
                if (len >= 4 & request.substring(len - 4).equals("\r\n\r\n")) {
                    System.out.println(request);
                    sendResponse(s);
                } else {
                    buf.clear();
                    s.read(buf, null, this);

                }

            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });
    }
    private static void sendResponse(AsynchronousSocketChannel s) {
        ByteBuffer buf = ByteBuffer.wrap("Hello".getBytes());

        s.write(buf,null,new CompletionHandler<Integer, Void>(){
            public void completed (Integer result,Void param){
                try{
                    s.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });
    }
}
