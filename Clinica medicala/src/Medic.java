import java.util.ArrayList;

public class Medic {
    String name;
    String specializare;
    double rating;
    ArrayList<Ore> program = new ArrayList<>();

    Medic(){
        this("Unkown","None",0);
    }
    Medic(String name, String specializare, double rating){
        this.name=name;
        this.specializare=specializare;
        this.rating=rating;
    }

    @Override
    public String toString() {
        return "Medic{" +
                "name='" + name + '\'' +
                ", specializare='" + specializare + '\'' +
                ", rating=" + rating +
                '}';
    }

}
