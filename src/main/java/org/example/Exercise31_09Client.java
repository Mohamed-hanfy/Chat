package org.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class Exercise31_09Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            System.out.println("Connected to server.");

            // Set up streams
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            // Thread to read messages from server
            Thread readThread = new Thread(() -> {
                Scanner scanner = new Scanner(new InputStreamReader(in));
                while (scanner.hasNextLine()) {
                    String message = scanner.nextLine();
                    System.out.println("Received from server: " + message);
                }
                scanner.close();
            });
            readThread.start();

            // Write messages to server from standard input
            PrintWriter writer = new PrintWriter(out, true);
            Scanner inputScanner = new Scanner(System.in);
            while (inputScanner.hasNextLine()) {
                String line = inputScanner.nextLine();
                writer.println(line);
                System.out.println("Sent to server: " + line);
            }
            inputScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}