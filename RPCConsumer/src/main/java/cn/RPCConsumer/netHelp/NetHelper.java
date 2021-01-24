package cn.RPCConsumer.netHelp;

import java.io.*;
import java.net.Socket;


public class NetHelper {
    /*This method struct the common network process.*/
    public static Object remoateCall(String host, int port, Object sendObj){
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        Object obj = null;
        try {
            Socket socket = new Socket(host,port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(sendObj);
            objectOutputStream.flush();
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            obj = objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                objectOutputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  obj;
    }
}
