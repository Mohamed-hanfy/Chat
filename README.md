# Simple Client-Server Communication Project

This project demonstrates a basic client-server communication model using Java sockets. The client and server can send and receive messages from each other in real-time.

## Project Structure

The project consists of two main classes:

1. **`Exercise31_09Client`**: The client application that connects to the server and sends/receives messages.
2. **`Exercise31_09Server`**: The server application that listens for client connections and sends/receives messages.

## How It Works

### Client (`Exercise31_09Client`)
- The client connects to the server running on `localhost` at port `8080`.
- It sets up input and output streams to communicate with the server.
- A separate thread is created to continuously read messages from the server.
- The client reads messages from the standard input (keyboard) and sends them to the server.

### Server (`Exercise31_09Server`)
- The server listens for incoming client connections on port `8080`.
- Once a client connects, it sets up input and output streams to communicate with the client.
- A separate thread is created to continuously read messages from the client.
- The server reads messages from the standard input (keyboard) and sends them to the client.

## Prerequisites

- Java Development Kit (JDK) installed on your machine.
- Basic understanding of Java programming and socket communication.

## How to Run

1. **Compile the Code**:
   - Open a terminal or command prompt.
   - Navigate to the directory containing the Java files.
   - Compile the client and server classes:
     ```bash
     javac org/example/Exercise31_09Client.java
     javac org/example/Exercise31_09Server.java
     ```

2. **Run the Server**:
   - In the terminal, run the server:
     ```bash
     java org.example.Exercise31_09Server
     ```
   - The server will start listening on port `8080`.

3. **Run the Client**:
   - Open another terminal or command prompt.
   - Run the client:
     ```bash
     java org.example.Exercise31_09Client
     ```
   - The client will connect to the server.

4. **Start Communicating**:
   - You can now send messages from the client to the server and vice versa.
   - Messages typed in the client terminal will be sent to the server, and messages typed in the server terminal will be sent to the client.

## Future Enhancements

- Implement support for multiple clients using multi-threading.
- Add a graphical user interface (GUI) for a more user-friendly experience.
- Implement secure communication using SSL/TLS.

## License

This project is open-source and available under the MIT License. Feel free to modify and distribute it as needed.
