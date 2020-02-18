package lesson3;

public class SerialMain {

    private final MyServer server = new MyServer();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MyClient.main(null);
            }
        }, "ClientThread").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                MyServer.main(null);
            }
        }, "ServerThread").start();
    }
}
