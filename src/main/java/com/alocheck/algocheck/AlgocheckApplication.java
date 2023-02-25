package com.alocheck.algocheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

@SpringBootApplication
public class AlgocheckApplication {

    public static void main(String[] args) {

        String hostname = "kantipur.com.np";
        int port = 443;

        try {
            // Create an SSLSocketFactory with default settings
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            // Create an SSLSocket and connect to the server
            SSLSocket socket = (SSLSocket) factory.createSocket(hostname, port);

            // Perform the TLS/SSL handshake
            socket.startHandshake();

            // Check if the handshake was successful
            SSLSession session = socket.getSession();
            if (session.isValid()) {
                System.out.println("TLS/SSL handshake successful.");
            } else {
                System.out.println("TLS/SSL handshake failed.");
            }

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SpringApplication.run(AlgocheckApplication.class, args);
    }

}
