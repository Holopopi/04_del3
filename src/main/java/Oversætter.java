import java.io.*;
import java.util.ArrayList;

/* Denne klasse er lavet til at skrive og læse filer, hvilket laver tekst filer med alle linjer hvorfra de manuelt kan
oversættes til andre sprog. Vi har indsæt spillets strenge på engelsk og har oversat dem manuelt til dansk.
 */
public class Oversætter {
    public static void main(String[] args) throws IOException {
        skrivFil();
        læsFil();

    }
    static void skrivFil() throws IOException {

        //Game.java strings
        String str = "getUserSelection\n" +
                "How many players?\n" +
                "CurrentPlayersTurn\n" +
                "'s turn to throw\n" +
                "ThrowDieButton\n" +
                "Throw Die\n" +
                "LostGamePrompt\n" +
                " has lost the game! Do you want to start a new game?\n" +
                "NewGameButtonTrue\n" +
                "Yes\n" +
                "NewGameButtonFalse\n" +
                "No\n" +
        //ChanceField.java strings
                "ChanceTitle\n" +
                "Chance\n" +
                "ChanceDescription\n" +
                "Take a chance card\n" +
                "Chancecase1\n" +
                "Move to start and receive 2M\n" +
                "Chancecase2\n" +
                "Move between one to five fields\n" +
                "Chancecase2.1\n" +
                "You move one field\n" +
                "Chancecase2.2\n" +
                "You move two fields\n" +
                "Chancecase2.3\n" +
                "You move three fields\n" +
                "Chancecase2.4\n" +
                "You move four fields\n" +
                "Chancecase2.5\n" +
                "You move five fields\n" +
                "Chancecase3\n" +
                "Move to either Skate Park or Swimming Pool and if the field isn't owned you get it for free\n" +
                "Chancecase3.SkateparkButton\n" +
                "Skate Park\n" +
                "Chancecase3.SwimmingPoolButton\n" +
                "Swimming Pool\n" +
                "Chancecase4\n" +
                "Move one or take a new chance card \n" +
                "Chancecase4TrueButton\n" +
                "Move one\n" +
                "Chancecase4FalseButton\n" +
                "Take another chance card\n" +
                "Chancecase5\n" +
                "You have eaten too much candy, pay 2m to the bank\n" +
                "Chancecase6\n" +
                "Move to either the Skate Park, the Swimming Pool, the Bowling Alley or the Zoo and if the field isn't owned you get it for free\n" +
                "Chancecase6.SkateParkButton\n" +
                "Skate Park\n" +
                "Chancecase6.SwimmingPoolButton\n" +
                "Swimming Pool\n" +
                "Chancecase6.BowlingAlleyButton\n" +
                "Bowling Alley\n" +
                "Chancecase6.ZooButton\n" +
                "Zoo\n" +
                "Chancecase6.SkatePark\n" +
                "Skate Park\n" +
                "Chancecase6.SwimmingPool\n" +
                "Swimming Pool\n" +
                "Chancecase6.BowlingAlley\n" +
                "Bowling Alley\n" +
                "Chancecase6.Zoo\n" +
                "Zoo\n" +
                "Chancecase7\n" +
                "Move to either the Candy Store or the Ice Cream Parlor and if the field isn't owned you get it for free\n" +
                "Chancecase7.CandyStoreButton\n" +
                "Candy Store\n" +
                "Chancecase7.IceCreamParlorButton\n" +
                "Ice Cream Parlor\n" +
                "Chancecase7.CandyStore\n" +
                "Candy Store\n" +
                "Chancecase7.IceCreamParlor\n" +
                "Ice Cream Parlor\n" +
                "Chancecase8\n" +
                "Get a get out of jail card\n" +
                "Chancecase9\n" +
                "Move to the Boardwalk\n" +
                "Chancecase10\n" +
                "Move to either the Museum, the Library, the Water Park or the Boardwalk and if the field isn't owned you get it for free\n" +
                "Chancecase10.MuseumButton\n" +
                "Museum\n" +
                "Chancecase10.LibraryButton\n" +
                "Library\n" +
                "Chancecase10.WaterParkButton\n" +
                "Water Park\n" +
                "Chancecase10.BoardwalkButton\n" +
                "Boardwalk\n" +
                "Chancecase10.Museum\n" +
                "Museum\n" +
                "Chancecase10.Library\n" +
                "Library\n" +
                "Chancecase10.WaterPark\n" +
                "Water Park\n" +
                "Chancecase10.Boardwalk\n" +
                "Boardwalk\n" +
                "Chancecase11\n" +
                "You have done your homework, gain 2m from the bank\n" +
                "Chancecase12\n" +
                "Move to either the Arcade or the Cinema and if the field isn't owned you get it for free\n" +
                "Chancecase12.ArcadeButton\n" +
                "Arcade\n" +
                "Chancecase12.CinemaButton\n" +
                "Cinema\n" +
                "Chancecase12.Arcade\n" +
                "Arcade\n" +
                "Chancecase12.Cinema\n" +
                "Cinema\n" +
                "Chancecase13\n" +
                "Move to Skate Park\n" +
                "Chancecase14\n" +
                "Move to either the Candy Store, Ice Cream Parlor, Arcade or the Cinema and if the field isn't owned you get it for free\n" +
                "Chancecase14.CandyStoreButton\n" +
                "Candy Store\n" +
                "Chancecase14.IceCreamParlorButton\n" +
                "Ice Cream Parlor\n" +
                "Chancecase14.ArcadeButton\n" +
                "Arcade\n" +
                "Chancecase14.CinemaButton\n" +
                "Cinema\n" +
                "Chancecase14.CandyStore\n" +
                "Candy Store\n" +
                "Chancecase14.IceCreamParlor\n" +
                "Ice Cream Parlor\n" +
                "Chancecase14.Arcade\n" +
                "Arcade\n" +
                "Chancecase14.Cinema\n" +
                "Cinema\n" +
                "Chancecase15\n" +
                "Move to either the Burger Joint, Pizzeria, Toy Store or the Pet Shop and if the field isn't owned you get it for free\n" +
                "Chancecase15.BurgerJointButton\n" +
                "Burger Joint\n" +
                "Chancecase15.PizzeriaButton\n" +
                "Pizzeria\n" +
                "Chancecase15.ToyStoreButton\n" +
                "Toy Store\n" +
                "Chancecase15.PetShopButton\n" +
                "Pet Shop\n" +
                "Chancecase15.BurgerJoint\n" +
                "Burger Joint\n" +
                "Chancecase15.Pizzeria\n" +
                "Pizzeria\n" +
                "Chancecase15.ToyStore\n" +
                "Toy Store\n" +
                "Chancecase15.PetShop\n" +
                "Pet Shop\n" +
        //GameBoard.java strings
                "HouseField1\n" +
                "Burger Joint\n" +
                "HouseField2\n" +
                "Pizzeria\n" +
                "HouseField3\n" +
                "Candy Store\n" +
                "HouseField4\n" +
                "Ice Cream Parlor\n" +
                "HouseField5\n" +
                "Museum\n" +
                "HouseField6\n" +
                "Library\n" +
                "HouseField7\n" +
                "Skate Park\n" +
                "HouseField8\n" +
                "Swimming Pool\n" +
                "HouseField9\n" +
                "Arcade\n" +
                "HouseField10\n" +
                "Cinema\n" +
                "HouseField11\n" +
                "Toy store\n" +
                "HouseField12\n" +
                "Pet Shop\n" +
                "HouseField13\n" +
                "Bowling Alley\n" +
                "HouseField14\n" +
                "Zoo\n" +
                "HouseField15\n" +
                "Water Park\n" +
                "HouseField16\n" +
                "The Boardwalk\n" +
                "BuyPrompt\n" +
                "This building isn't bought. You have enough money to buy it!\n" +
                "BuyButton\n" +
                "Buy\n" +
                "CantBuyPrompt\n" +
                "This building isn't bought. You don't have enough money to buy it\n" +
                "ContinueButton\n" +
                "Continue\n" +
                "PayRentPrompt1\n" +
                "This building is owned. You have to pay \n" +
                "PayRentPrompt2\n" +
                "M to \n" +
                "PayRentButton\n" +
                "Okay\n" +
                "ChancePayRentPrompt\n" +
                "The free building is already claimed, you have to pay rent\n" +
                "ChancePayRentButton\n" +
                "Pay rent\n" +
                "ChanceFreeBuildingPrompt\n" +
                "This free building isn't claimed. It's yours for free!\n" +
                "ChanceFreeBuildingButton\n" +
                "Claim\n" +
        //JailField.java Strings
                "JailFieldTitle\n" +
                "Go to jail\n" +
                "JailFieldDescription\n" +
                "Go to jail\n" +
                "JailFieldSubText\n" +
                "Go to jail\n" +
                "JailFieldVisitTitle\n" +
                "Jail\n" +
                "JailFieldVisitDescription\n" +
                "Jail\n" +
                "JailFieldVisitSubText\n" +
                "Visiting\n" +
                "UsedGOFJCardPrompt\n" +
                "You have used a get out of jail free card\n" +
                "UsedGOFJCardButton\n" +
                "OK\n" +
                "PaidToGOFJPrompt\n" +
                "You paid 1m to get out of jail\n" +
                "PaidToGOFJButton\n" +
                "OK\n" +
                "GOFJPrompt\n" +
                "Go to jail\n" +
                "GOFJButton\n" +
                "OK\n" +
        //ParkingField.java String
                "ParkingTitle\n" +
                "Free Parking\n" +
                "ParkingDescription\n" +
                "Free Parking\n" +
        //StartField.java String
                "StartFieldTitle\n" +
                "Start\n" +
                "StartFieldDescription\n" +
                "Start: Collect 2 when you pass.\n" +
                "StartFieldSubText\n" +
                "Collect 2\n";

        String mitFilnavn = "Engelsk.txt";
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(mitFilnavn));
        writer.write(str); //skriver streng til filen
        writer.close();
    }
    static void læsFil() throws IOException {
        String file ="Dansk.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        ArrayList<String> liste = new ArrayList<String>();
        while (currentLine != null){
            System.out.println(currentLine);
            liste.add(currentLine);
            currentLine = reader.readLine();
        }
        System.out.println(liste.get(7));
        reader.close();
    }
}
