import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTjener {
    public static void main(String[] args) {
        //definerer portnr
        final int PORTNR = 1250;
        try {
            //Oppretter et objekt for tjeneren
            ServerSocket tjener = new ServerSocket(PORTNR);
            System.out.println("Tjener startet, venter på forbindelse...");
            //Oppretter forbindelse
            Socket forbindelse = tjener.accept();
            //Kommunikasjonsstrømm
            //lager en leser
            InputStreamReader leseforbindelse = new InputStreamReader(forbindelse.getInputStream());
            BufferedReader leseren = new BufferedReader(leseforbindelse);
            //lager en skriver
            PrintWriter skriveren = new PrintWriter(forbindelse.getOutputStream(), true);
            skriveren.println("Du har nå forbindelse med tjeneren");
            skriveren.println("Skriv hva du vil så skal jeg gjenta det");

            //leser input
            String input = leseren.readLine();

            //Holder programmet kjørende
            while (input != null) {
                skriveren.println("Du skrev:\t"+input+"\n");
                input = leseren.readLine();
            }

            //Lukker
            leseren.close();
            skriveren.close();
            forbindelse.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
