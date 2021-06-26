import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Frame {

    JFrame frame;
    MenuBar menu;
    ArrayList<Medic> medici;
    ArrayList<Pacient> pacienti;

    Frame(ArrayList<Medic> medici, ArrayList<Pacient> pacienti){
        this.medici=medici;
        this.pacienti=pacienti;

        JPanel description = new JPanel(new GridLayout(3,1));
        description.setBorder(BorderFactory.createTitledBorder("Clinica dermatologie"));
        description.add(new JLabel("Locatie: str. Mihai Viteazul, nr. 23., Cluj-Napoca"));
        description.add(new JLabel("Numar de telefon: 0765243887."));
        description.add(new JLabel("Descriere: Clinica de dermatologie privata, estetica, " +
                "noua si moderna, deschisa pentru a corespunde asteptarilor clientilor"));

        JPanel preturi = new JPanel();
        preturi.setBorder(BorderFactory.createTitledBorder("Servicii si tarife"));
        String[] column={"Servicii","Preturi (Ron)"};
        String[][] data={{"Consultatie dermatologica","230"}, {"Consultatie de urgenta","300"}, {"Control","150"},{"Biopsie cutanata","300"},
                {"Ecografie","200"},{"Microdermabraziune","300"},{"Radiofrecventa faciala","320"}, {"Control la interval de o luna","Gratuit"},
                {"Chiuretare leziuni moluscum sub 10 leziuni","120"},{"Crioterapie leziune","50"},{"Peeling chimic(Acid salicilic)","300"},
                {"Peeling chimic(solutie jessner)","350"}, {"Tratament pb serum","1600 /sedinta"},{"Dermapen","400"},{"Mezoterapie","500 /sedinta"},
                {"Tratemnt acid hialuronic","1300 /ml"},{"tratament volite","800 /fiola"},
                {"Tratament botox","700 /1 zona"},{"Tratament laser","1300 /sedinta"}};
        JTable jt = new JTable(data, column);
        JScrollPane sp = new JScrollPane(jt);
        preturi.add(sp);

        menu = new MenuBar();
        Menu doctori = new Menu("Medici");
        Menu dermatopatologie = new Menu("Dermatopatologie");
        Menu procedurala = new Menu("Dermatologie procedurala");
        Menu estetica = new Menu("Dermatologie estetica / cosmetica");
        doctori.add(dermatopatologie);
        for (Medic value : medici) {
            if (value.specializare.equals("Dermatopatologie"))
                dermatopatologie.add(new MenuItem(value.name));
        }
        doctori.add(procedurala);
        for (Medic medic : medici) {
            if (medic.specializare.equals("Dermatologie procedurala"))
                procedurala.add(new MenuItem(medic.name));
        }
        doctori.add(estetica);
        for (Medic medic : medici) {
            if (medic.specializare.equals("Dermatologie estetica / cosmetica"))
                estetica.add(new MenuItem(medic.name));
        }
        Menu orar = new Menu("Orar");
        orar.add(new MenuItem("Luni-vineri: 8:00 - 18:00"));
        orar.add(new MenuItem("Sambata: Inchis"));
        orar.add(new MenuItem("Duminica: Inchis"));
        Menu locatii = new Menu("Alte locatii");
        locatii.add(new MenuItem("Floresti, str. Ghiocelului, nr. 4"));
        locatii.add(new MenuItem("Dej, str. 1 Mai, nr. 34A"));
        locatii.add(new MenuItem("Gherla, str. Libertatii, nr 45"));
        menu.add(doctori);
        menu.add(orar);
        menu.add(locatii);

        JButton programare = new JButton("Creeaza programare");
        programare.addActionListener(e -> deschideProgramari());

        JButton pacientiButon = new JButton("Vizualizeaza pacienti");
        pacientiButon.addActionListener(e -> deschideIstoricMedical());
        JPanel sud = new JPanel();
        sud.add(programare);
        sud.add(pacientiButon);

        frame = new JFrame("Clinica medicala de dermatologie Cluj");
        frame.setMenuBar(menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.add(description,BorderLayout.NORTH);
        frame.add(preturi,BorderLayout.CENTER);
        frame.add(sud,BorderLayout.SOUTH);

    }

    protected void deschideIstoricMedical(){
        JFrame istoricMedical = new JFrame("Istoric medical pacienti");
        istoricMedical.setSize(750,250);
        istoricMedical.setVisible(true);
        istoricMedical.setLayout(new BorderLayout());
        JPanel tfP= new JPanel(new GridLayout(2,2));
        JTextField tF= new JTextField(10);
        JTextArea taF = new JTextArea();
        tfP.add( new JLabel("Fisa medicala pentru pacientul:"));
        tfP.add(tF);
        tF.addActionListener(e -> {
            for (Pacient pacient : pacienti) {
                if (pacient.name.equals(tF.getText()))
                    taF.append(pacient + "\n");
            }
        });
        taF.setFont( new Font("Arial", Font.ITALIC, 14));
        tfP.add(new JLabel("Pacienti"));
        JButton pacientiList = new JButton("Lista nume");
        tfP.add(pacientiList);
        pacientiList.addActionListener(e -> {
            for(int i=0;i< pacienti.size();i++){
                taF.append((i+1)+". "+pacienti.get(i).name);
                taF.append("\n");
            }
        });
        istoricMedical.add(tfP, BorderLayout.NORTH);
        istoricMedical.add(taF, BorderLayout.CENTER);
    }

    protected void deschideProgramari() {
        JFrame programari = new JFrame("Creeaza programare");
        programari.setSize(350, 350);
        programari.setVisible(true);
        programari.setLayout(new BorderLayout());
        JPanel tfP = new JPanel(new GridLayout(6, 2));
        tfP.add(new JLabel("Nume pacient"));
        JTextField nume = new JTextField(10);
        tfP.add(nume);
        tfP.add(new JLabel("Cabinet"));
        Choice cabinet = new Choice();
        cabinet.add("Dermatopatologie");
        cabinet.add("Dermatologie procedurala");
        cabinet.add("Dermatologie estetica / cosmetica");
        cabinet.addItemListener(e -> {});
        tfP.add(cabinet);
        Choice medic = new Choice();
        tfP.add(new JLabel("Medicul specialist"));
        cabinet.addItemListener(e -> {
            medic.removeAll();
            for (Medic m : medici) {
                if (m.specializare.equals(cabinet.getSelectedItem())) {
                    medic.add(m.name);
                }
            }
        });
        tfP.add(medic);

        tfP.add(new JLabel("Zi"));
        Choice ziua = new Choice();
        String[] zile = {"Luni", "Marti", "Miercuri", "Joi", "Vineri"};
        for (String s : zile) {
            ziua.add(s);
        }
        ziua.addItemListener(e -> {});
        tfP.add(ziua);

        tfP.add(new JLabel("Ora"));
        Choice ora = new Choice();
        int cnt = 7;
        while (cnt <= 17) {
            ora.add(cnt + ":00");
            cnt++;
        }
        ora.addItemListener(e -> {

        });
        tfP.add(ora);
        JButton finalizare = new JButton("Finalizare programare");
        finalizare.addActionListener(e -> {
            Medic m = cautaMedic(medic.getSelectedItem(), cabinet.getSelectedItem());
            if (cautaZi(ziua.getSelectedItem(), m, ora.getSelectedItem()))
            {
                JOptionPane.showMessageDialog(programari, "Programare finalizata cu succes!");
                //System.out.println(cautaZi(ziua.getSelectedItem(), m, ora.getSelectedItem()));
            }
            else
                JOptionPane.showMessageDialog(programari, "Data indisponibila!");
        });
        tfP.add(finalizare);
        programari.add(tfP);
    }

    protected Medic cautaMedic(String nume, String specializare){
        for (Medic medic : medici) {
            if (medic.name.equals(nume) && medic.specializare.equals(specializare))
                return medic;
        }
        return null;
    }
    protected boolean cautaZi(String zi, Medic medic, String ora){
        ArrayList<Ore> sortat = new ArrayList<>();
        for (Ore ore : medic.program) {
            if (ore.ziua.equals(zi))
                sortat.add(ore);
        }
        for (Ore ore : sortat) {
            if (ore.oraInceput.equals(ora) && ore.disponibil)
                return true;
        }
        return false;
    }
}
