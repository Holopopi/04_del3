package Game;// Denne klasse bruges til at lave en terning
// Her instantieres terningen

public class Dice {
    private int sider;
    public Dice(int sider){

        if(sider<0){
            this.sider=0;
        } else this.sider = sider;
    }

    public int kastTerning (){
        return (int)Math.floor((Math.random()*sider)+1);
    }
}
