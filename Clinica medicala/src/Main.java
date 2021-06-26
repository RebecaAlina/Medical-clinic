import java.sql.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Medic> medici = new ArrayList<>();
        Medic m1 = new Medic("Ioan Pop", "Dermatopatologie", 3.5);
        Medic m2 = new Medic("Maria Alina","Dermatologie procedurala", 4);
        Medic m3 = new Medic("Vasile Onescu", "Dermatologie estetica / cosmetica", 4.9);
        Medic m4 = new Medic("Popa Ioana", "Dermatopatologie", 3.4);
        Medic m5 = new Medic("Ana Mioara", "Dermatologie procedurala",2.2);
        Medic m6 = new Medic("Dumitru Popescu", "Dermatologie estetica / cosmetica", 4.3);
        medici.add(m1);
        medici.add(m2);
        medici.add(m3);
        medici.add(m4);
        medici.add(m5);
        medici.add(m6);
        ArrayList<Pacient> pacienti = new ArrayList<>();
        Programare p1 = new Programare("9.03.2021","marti","Dermatopatologie","Popa Ioana", "12:00");
        Programare p2 = new Programare("10.03.2021","miercuri","Dermatologie procedurala","Ana Mioara", "14:00");
        Programare p3 = new Programare("31.05.2021","luni","Dermatologie estetica","Dumitru Popescu", "16:00");
        Programare p4 = new Programare("20.05.2021","joi","Dermatopatologie","Popa Ioana", "10:00");
        ArrayList <Programare> programare1 = new ArrayList<>();
        ArrayList <Programare> programare2 = new ArrayList<>();
        programare1.add(p1);
        programare1.add(p2);
        programare2.add(p3);
        programare2.add(p4);
        Pacient pacient1 = new Pacient("Maria Adriana", 18, programare1);
        Pacient pacient2 = new Pacient("Amalia Luiza", 25, programare2);
        pacienti.add(pacient1);
        pacienti.add(pacient2);

        Ore o1 = new Ore("Luni","12:00");
        Ore o2 = new Ore("Marti","13:00");
        Ore o3 = new Ore("Joi", "16:00");
        Ore o4 = new Ore("Vineri", "16:00");

        ArrayList<Ore> or1 = new ArrayList<>();
        ArrayList<Ore> or2 = new ArrayList<>();
        ArrayList<Ore> or3 = new ArrayList<>();
        or1.add(o1);
        or1.add(o2);
        or2.add(o3);
        or3.add(o4);
        m1.program=or1;
        m2.program=or2;
        m3.program=or3;



        new Frame(medici,pacienti);
    }
}
