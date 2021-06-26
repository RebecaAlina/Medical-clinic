import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pacient {
    String name;
    int age;
    ArrayList<Programare> programari;

    Pacient(String name, int age, ArrayList<Programare> programari){
        this.name=name;
        this.age=age;
        this.programari=programari;
    }
    Pacient(String name,int age){
        this.name=name;
        this.age=age;
    }
    Pacient(){
        this("Unknown",-1,null);
    }

    @Override
    public String toString() {
        return "Nume: " + name  +
                ", varsta: " + age + " " +
                "\n" + programari.toString();
    }
}
