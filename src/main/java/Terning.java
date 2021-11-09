// Denne klasse bruges til at lave en terning
// Her instantieres terningen

public class Terning {
    private int sider;
    public Terning(int sider){

        if(sider<0){
            this.sider=0;
        } else this.sider = sider;
    }

    public int kastTerning (){
        return (int)Math.floor((Math.random()*sider)+1);
    }
}
