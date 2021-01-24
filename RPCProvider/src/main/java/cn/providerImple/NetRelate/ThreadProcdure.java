package cn.providerImple.NetRelate;
import cn.providerImple.ServiceDispatcher;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
* Every Thread is relate to a socket. It read the Object Instance and dispatch to suitable implement instance,
* and write back the result instance to network. */
public class ThreadProcdure implements Runnable {
    private Socket socket;

    public ThreadProcdure(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            //read the object which givend by caller
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object recObj = objectInputStream.readObject();
            //find the suitable implement class and handle it
            Object resultObj = ServiceDispatcher.dispatch(recObj);
            //write the object that produced
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(resultObj);
            objectOutputStream.flush();//this operation can make all transport correct
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
