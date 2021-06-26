public class Programare {
    String data;
    String ziua;
    String ora;
    String cabinet;
    String doctor;
    boolean liber;

    Programare(String data,String ziua, String cabinet, String doctor, String ora){
        this.data=data;
        this.cabinet=cabinet;
        this.ora=ora;
        this.doctor=doctor;
        this.ziua=ziua;
        this.liber=false;
    }
    Programare(String ziua, String cabinet, String doctor, String ora){
        this.ziua=ziua;
        this.cabinet=cabinet;
        this.doctor=doctor;
        this.ora=ora;
        this.liber=false;
    }
    Programare(){
        this("Unknown" ,"Unknown","Unknown","Unknown","Unknown");
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public void setOra(String ora) {
        this.ora = ora;
    }

    @Override
    public String toString() {
        return "\nProgramare: " +
                "in data " + data +
                ", la ora " + ora +
                ", la cabinetul " + cabinet +
                ", la doctorul " + doctor;
    }
}
