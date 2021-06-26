public class Ore {
    String ziua;
    String oraInceput;
    boolean disponibil;

    Ore(String ziua, String oraInceput) {
        this.ziua=ziua;
        this.oraInceput = oraInceput;
        this.disponibil = false;
    }
    Ore(){
        this.ziua="Luni";
        this.oraInceput="8:00";
        this.disponibil=true;
    }
}
