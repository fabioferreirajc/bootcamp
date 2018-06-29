package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.utils.Dispatcher;
import org.academiadecodigo.bootcamp.utils.Helper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {


    public static final String PREFIX = "www";
    private final int port;
    private static final String ROOT = "/index.html";

    public WebServer(int port) {
        this.port = port;
    }

    ExecutorService cachedPool;

    public void start() {

        try {

            ServerSocket serverSocket = new ServerSocket(port);
            cachedPool = Executors.newCachedThreadPool();

            while (true) {

                System.out.println("Waiting for connection");
                Socket socket = serverSocket.accept();
                cachedPool.submit(new ServerWorker(socket));




                //Thread thread= new Thread(new ServerWorker());

                //System.out.println(thread.getName() +"  New client connected");

                //thread.start();


                //System.out.println(thread.getName());
                //System.out.println(thread.getId());

            }

        } catch (IOException e) {
            System.err.println("server failed to start at port: " + port);
        } finally {cachedPool.shutdown();

        }
    }

    private void serveClient(Socket socket) {

        try {
            String request = getClientRequest(socket.getInputStream());

            System.out.println("Client request is: " + request);

            if (request == null) {
                return;
            }

            String verb = Helper.parseVerb(request);

            if (!verb.equals("GET")) {
                System.out.println("VERB: " + verb);
                Dispatcher.sendNotSupported(socket.getOutputStream());
                return;
            }

            String resource = Helper.parseResource(request);

            File file = new File(PREFIX + resource);

            if (file.isDirectory()) {
                file = new File(file.getAbsolutePath() + ROOT);
            }

            System.out.println(file.getAbsolutePath() + " " + file.exists());

            if (!file.exists() || !file.isFile()) {
                System.out.println(file.getName() + " not found");
                Dispatcher.sendNotFound(socket.getOutputStream());
                return;
            }

            Dispatcher.sendOkFile(file, socket.getOutputStream());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                System.out.println("Client served");
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private String getClientRequest(InputStream inputStream) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        return reader.readLine();
    }


    private class ServerWorker implements Runnable {

        private Socket socket;

        public ServerWorker(Socket socket) {
            this.socket=socket;

        }


        @Override
        public void run() {
            serveClient(socket);

        }
    }
}
