package cn.providerImple.NetRelate;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
* Waiter for socket require and call the thread*/
public class NetService {
    //use the singleTon instace of TreadPool which thread number is 100 to provide unblocked service.
    static final ExecutorService THREADPOOL = Executors.newFixedThreadPool(100);

    public static void mainServiceSetUp(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while(true){//make the main service run and new a thread to Handle callings.
            Socket socket = serverSocket.accept();
            final Future<?> submit = THREADPOOL.submit(new ThreadProcdure(socket));
        }
    }

    public static void main(String[] agrs) throws IOException {
        mainServiceSetUp(9999);
    }
}
