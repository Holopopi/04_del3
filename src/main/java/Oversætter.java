import java.io.*;

public class Oversætter {
    public static void main(String[] args) throws IOException {
        skrivFil();
        læsFil();

    }
    static void skrivFil() throws IOException {
        String str = "knap_1_tekst\n" +
                "Tryk på mig\n" +
                "knap_2_tekst\n" +
                "hej\n" +
                "brugervelkomst\n" +
                "velkommen til mit spil\n" +
                "ugyldigtTræk\n" +
                "Dette træk er ugyldigt. Vælg noget andet\n" +
                "skiftsprogknap\n" +
                "skift sprog\n";

        String mitFilnavn = "Dansk.txt";
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(mitFilnavn));
        writer.write(str); //skriver streng til filen
        writer.close();
    }
    static void læsFil() throws IOException {
        String file ="Dansk.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        while (currentLine != null){
            System.out.println(currentLine);
            currentLine = reader.readLine();
        }
        reader.close();
    }
}
