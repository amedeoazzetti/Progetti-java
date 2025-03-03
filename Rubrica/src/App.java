
import java.util.ArrayList;

public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Contatto c1 = new Contatto("Filippo", "Pilati", "1234567", Genere.Maschio, 17);
        Contatto c2 = new Contatto("Gabriele", "Pittui", "012345678", Genere.Maschio, 17);
        Contatto c3 = new Contatto("Manuela", "Toniolli", "663478", Genere.Femmina, 30);
        Contatto c4 = new Contatto("Federico", "Esposito", "2356235", Genere.Maschio, 16);
        Contatto c5 = new Contatto("Davide", "Cesari", "12452352", Genere.Maschio, 16);
        Contatto c6 = new Contatto("Amedeo", "Romani", "12452352", Genere.Maschio, 16);
        Contatto c7 = new Contatto("Nicolas", "Rosa", "056845", Genere.Maschio, 16);
        Contatto c8 = new Contatto("Joshua", "Susman", "3456346", Genere.Maschio, 21);
        Contatto c9 = new Contatto("Joshua", "Susman", "121212", Genere.Maschio, 16);
        
        Rubrica rubrica = new Rubrica();
        rubrica.aggiungiContatto(c1);
        rubrica.aggiungiContatto(c2);
        rubrica.aggiungiContatto(c3);
        rubrica.aggiungiContatto(c4);
        rubrica.aggiungiContatto(c5);
        rubrica.aggiungiContatto(c6);
        rubrica.aggiungiContatto(c7);
        rubrica.aggiungiContatto(c8);
        
        rubrica.stampaContatti();
        
        System.out.println("Numeri fissi: " + rubrica.contaNumeriFissi());
        
        System.out.println(rubrica.isDoppione("3456346"));

        rubrica.aggiungiContatto(c9);
        
        rubrica.stampaContatti();
        
        System.out.println(rubrica.cercaDoppioni());
        
        ArrayList<Contatto> filtro = rubrica.ricercaAvanzata("man");
        
        for (Contatto c : filtro) {
            c.stampaDati();
        }
        
        // ordinamento per cognome
        rubrica.ordinaCognome();
        rubrica.stampaContatti();
        
        rubrica.ordinaNome();
        rubrica.stampaContatti();
        
        rubrica.ordinaEta(false);
        rubrica.stampaContatti();
    }
    
}
