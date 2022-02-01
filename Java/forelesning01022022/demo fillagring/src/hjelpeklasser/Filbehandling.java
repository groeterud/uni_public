package hjelpeklasser;

import java.io.*;

public class Filbehandling {

    //Metode for å lage en skriveforbindelse
    public static PrintWriter lagSkriveForbindelse (String filnavn) {
        try {
            FileWriter filForbindelse = new FileWriter(filnavn);
            BufferedWriter skriveBuffer = new BufferedWriter(filForbindelse);
            PrintWriter skriveForbindelse = new PrintWriter(skriveBuffer); // lager fil om ikke finnes
            return skriveForbindelse;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Metode for å lage leseforbindelse
    public static BufferedReader lagLeseForbindelse (String filnavn) {
        try {
            FileReader filForbindelse = new FileReader(filnavn);
            BufferedReader leser = new BufferedReader(filForbindelse); // error om filen ikke finnes
            return leser;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
