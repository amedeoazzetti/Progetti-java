
import java.util.ArrayList;

public class Sistema {
    
    private String nome;
    private Stella stella;
    private ArrayList<Pianeta> pianeti;     // generics
    
    // costante gravitazione universale
    public static double G = 6.67408e-11; 
    
    public Sistema(String nome, Stella stella) {
        this.nome = nome;
        this.stella = stella;
        
        pianeti = new ArrayList<>();
    }
    
    /**
     * Aggiunge un nuovo pianeta in coda alla lista
     * @param nuovo nuovo pianeta da aggiungere
     */
    public void appendi(Pianeta nuovo) {
        
        pianeti.add(nuovo);
    }
    
    /**
     * Aggiunge un nuovo pianeta in una posizione specifica
     * @param nuovo nuovo pianeta da aggiungere
     * @param posizione posizione in cui inserire il pianeta (parte da 0)
     * @return esito dell'inserimento, falso se la posizione indicata è non valida
     */
    public boolean inserisci(Pianeta nuovo, int posizione) {
        
        if (posizione < 0 || posizione > pianeti.size()) {
            return false;
        }
        
        // aggiunge il pianeta nella pos scelta shiftando tutti gli altri
        pianeti.add(posizione, nuovo);
        return true;
    }
    
    /**
     * Cerca nella lista se il pianeta è presente
     * @param cercato pianeta da cercare
     * @return esito della ricerca
     */
    public boolean contiene(Pianeta cercato) {
        
        return pianeti.contains(cercato);
    }
    
    public boolean cercaPianeta(String nomePianeta) {
        
        for (Pianeta p : pianeti) {
            if (p.getNome().equals(nomePianeta))
                return true;
        }
        return false;
    }
    
    /**
     * Cerca un pianeta nella lista e restituisce la sua posizione
     * @param cercato pianeta da cercare
     * @return posizione della lista, -1 se non è presente
     */
    public int trovaPosizione(Pianeta cercato) {
        
        return pianeti.indexOf(cercato);
    }
    
    /**
     * Recupera un pianeta nella lista data la sua posizione
     * @param posizione posizione del pianeta da leggere
     * @return pianeta cercato, null se la posizione non è valida
     */
    public Pianeta leggi(int posizione) {
        
        if (posizione < 0 || posizione > pianeti.size()) {
            return null;
        }
        
        return pianeti.get(posizione);
    }
    
    /**
     * Sostituisce un pianeta data la sua posizione
     * @param posizione posizione del pianeta da modificare
     * @param nuovo nuovo pianeta da inserire
     * @return il vecchio pianeta che è stato sostituito
     */
    public Pianeta sostituisci(int posizione, Pianeta nuovo) {
        
        if (posizione < 0 || posizione > pianeti.size()) {
            return null;
        }
        
        return pianeti.set(posizione, nuovo);
    }
    
    
    public Pianeta rimuovi(int indice) {
        
        if (indice < 0 || indice >= pianeti.size()) {
            return null;
        }
        
        return pianeti.remove(indice);
    }
    
    /**
     * 
     * @param p
     * @return 
     */
    public int rimuoviTutti(Pianeta p) {
        
        int quanti = 0;
        for (int i=pianeti.size()-1; i >= 0; i--) {
            
            if (pianeti.get(i) == p) {
                pianeti.remove(i);
                quanti++;
            }
        }
        
        return quanti;
    }
    
    
    public boolean isVuoto() {
        
        return pianeti.isEmpty();
    }
    
    
    public void stampaPianeti() {
        
        System.out.println("[");
        
//        for (int i=0; i<pianeti.length; i++) {
//            
//            Pianeta p = pianeti[i];
//        }
        
        for (Pianeta p : pianeti) {   
            p.stampaDati();
        }
        
        System.out.println("]");
    }
}
