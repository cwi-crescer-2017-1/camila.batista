import java.util.ArrayList;
public class ListaSaint{
    private ArrayList<Saint> saints = new ArrayList<>();
    
    public ListaSaint(){}
    
    public void adicionaSaint(Saint saint){
        this.saints.add(saint);
    }
    
    public ArrayList<Saint> getListaSaint(){
        return this.saints;
    }
}