package org.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class Exercise31_09Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Set up streams
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            // Thread to read messages from client
            Thread readThread = new Thread(() -> {
                Scanner scanner = new Scanner(new InputStreamReader(in));
                while (scanner.hasNextLine()) {
                    String message = scanner.nextLine();
                    System.out.println("Received from client: " + message);
                }
                scanner.close();
            });
            readThread.start();

            // Write messages to client from standard input
            PrintWriter writer = new PrintWriter(out, true);
            Scanner inputScanner = new Scanner(System.in);
            while (inputScanner.hasNextLine()) {
                String line = inputScanner.nextLine();
                writer.println(line);
                System.out.println("Sent to client: " + line);
            }
            inputScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}