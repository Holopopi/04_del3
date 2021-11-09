public class Tekstfelt {
    private Tekstfelt() {

    }
// Her er teksten som hentes i ind i andre klasser og bliver udskrevet når spilleren lander på det pågældende felt
    public static String felt2Besked() {
        return "You pass by the tower overlooking the valley. The guard is generous and gives you 250 ducats.";
    }

    public static String felt3Besked() {
        return "You fall in a crater and break your legs. You lose 100 ducats from the medical bills.";
    }

    public static String felt4Besked() {
        return "You rob a beggar in front of the palace gates and manage to steal 100 ducats.";
    }

    public static String felt5Besked() {
        return "You pass through the cold desert and have to pay 20 ducats for a fur coat.";
    }

    public static String felt6Besked() {
        return "You enter the walled city. You go into the pub and get a beer. A young pretty lady sits down next to you. You knock her out and take 180 ducats from her purse.";
    }

    public static String felt7Besked() {
        return "Once you enter the monastery, you are one with mother earth. The monks teach you their ways, and you get the ability to enter a complete state of zen. You sleep well that night.";
    }

    public static String felt8Besked() {
        return "You can’t see anything inside the black cave. You get scared and run out of the cave. In your rush you drop 70 ducats.";
    }

    public static String felt9Besked() {
        return "You come across some remote huts in a mountain, the humans there have never seen other people, so they start worshipping you like a god. You receive 60 ducats from their offerings.";
    }

    public static String felt10Besked() {
        return "At the werewall you realize that there’s a full moon today. You go on a rampaging frenzy and kill all the nearby villagers. As a fine you have to pay 80 ducats, however you get to avoid any jail time. Go again.";
    }

    public static String felt11Besked() {
        return "You came across a pit, and something was off. It was an ambush! The robbers stole 50 ducats from your wallet.";
    }

    public static String felt12Besked() {
        return "You came across an abandoned gold mine, and started digging. You suddenly struck a large vein and received 650 ducats.";
    }
    // Her er øvrige tekster til knappen, hvis en spiller vinder og felterne
    public static String OK(){
        return "OK";
    }
    public static String spillerVinder(){
        return (" has won the game!");
    }
    public static String kast(){
        return ("Throw");
    }
    public static String feltNavn2(){
        return "2. Tower";
    }
    public static String feltNavn3() {
        return "3. Crater";
    }
    public static String feltNavn4() {
        return "4. Palace Gates";
    }
    public static String feltNavn5() {
        return "5. Cold Desert";
    }
    public static String feltNavn6() {
        return "6. Walled City";
    }
    public static String feltNavn7() {
        return "7. Monastery";
    }
    public static String feltNavn8() {
        return "8. Black Cave";
    }
    public static String feltNavn9() {
        return "9. Huts In The Mountain";
    }
    public static String feltNavn10() {
        return "10. The Werewall";
    }
    public static String feltNavn11() {
        return "11. The Pit";
    }
    public static String feltNavn12() {
        return "12. Goldmine";
    }
    public static String feltVærdi2() {
        return "+250";
    }
    public static String feltVærdi3() {
        return "-100";
    }
    public static String feltVærdi4() {
        return "+100";
    }
    public static String feltVærdi5() {
        return "-20";
    }
    public static String feltVærdi6() {
        return "+180";
    }
    public static String feltVærdi7() {
        return "0";
    }
    public static String feltVærdi8() {
        return "-70";
    }
    public static String feltVærdi9() {
        return "+60";
    }
    public static String feltVærdi10() {
        return "-80, Extra turn";
    }
    public static String feltVærdi11() {
        return "-50";
    }
    public static String feltVærdi12() {
        return "+650";
    }

}