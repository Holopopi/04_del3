import java.util.HashMap;
//Psuedokode
public class Ownership {
    HashMap<Integer, Integer> playerOwnership = new HashMap<Integer, Integer>();

    public Ownership(){
    }

    public void PayRent(int field){
        int owner = playerOwnership.get(field);
        //saldoopdatering for begge spillere
    }
    public void BuyBuilding(int field, int player){
        playerOwnership.put(field, player);
        //saldoopdatering når man køber bygning
    }
    public boolean CheckIfBought(int field){
        boolean bought = playerOwnership.containsKey(field);
        if (bought){
            return true;
        } else {
            return false;
        }
    }


}
