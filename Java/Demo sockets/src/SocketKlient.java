import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketKlient {
    public static void main(String[] args) {
        //definerer portnr
        final int PORTNR = 1250;

        //Bruker scanner for å lese for console
        Scanner leserFraKonsoll = new Scanner(System.in);
        System.out.println("Skriv serverens adresse: ");
        String IP = leserFraKonsoll.nextLine();

        //forbindelse til server
        try {
            Socket forbindelse = new Socket(IP,PORTNR);
            System.out.println("Nå er forbindelse opprettet");
            //lager leser
            InputStreamReader leseforbindelse = new InputStreamReader(forbindelse.getInputStream());
            BufferedReader leseren = new BufferedReader(leseforbindelse);
            //lager skriver
            PrintWriter skriveren = new PrintWriter(forbindelse.getOutputStream(),true);
            //Leser innledning fra tjener og skriver det til konsollet.
            String input = leseren.readLine();
            while (input != null) {
                System.out.println(input+"\n");
                input = leseren.readLine();
            }
            //Leser input fra konsollet:
            String enlinje = leserFraKonsoll.nextLine();
            while (!enlinje.equals("")) {
                //sender enlinje til serveren
                skriveren.println(enlinje);
                //Leser respons fra tjeneren
                String respons = leseren.readLine();
                System.out.println("Fra server:\t"+respons); //skriver ut

                //leser inn på nytt
                enlinje = leserFraKonsoll.nextLine();
            }

            //lukker
            leseren.close();
            skriveren.close();
            forbindelse.close();


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
