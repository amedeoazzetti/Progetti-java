

import java.util.ArrayList;

public class Rubrica {
    
    private ArrayList<Contatto> contatti;
    
    public Rubrica() {
        contatti = new ArrayList<>(); 
    }
    
    public void stampaContatti() {
        
        for (Contatto c : contatti) {
            c.stampaDati();
        }
    }
    
    /**
     * Conta quanti contatti in rubrica hanno un numero fisso (che inizia per 0)
     * @return quanti contatti ha contato
     */
    public int contaNumeriFissi() {
        
        // devo contare quanti contatti hanno un numero fisso
        int quanti = 0;
        
        for (Contatto c : contatti) {
            
            // ogni numero fisso inizia per 0, ho due modi per controllarlo
            //if (c.getTelefono().startsWith("0")) 
            if (c.getTelefono().charAt(0) == '0')
                quanti++;
        }
        
        return quanti;
    }
    
    /**
     * Controlla se nella rubrica è già presente questo numero di telefono
     * @param numero il numero di telefono da cercare
     * @return esito della ricerca
     */
    public boolean isDoppione(String numero) {
        
        // scorro ogni contatto e confronto i numeri di telefono
        for (Contatto c : contatti) {
            if (c.getTelefono().equals(numero))
                return true;
        }
        
        return false;
    }
    
    /**
     * Cerca se sono presenti almeno 2 contatti che presentano lo stesso numero di telefono
     * @return vero se trova numeri ripetuti
     */
    public boolean cercaDoppioni() {
        
        // devo saltare i contatti uguali, quindi il secondo ciclo parte dopo il primo
//        for (int i=0; i < contatti.size(); i++) {
//            for (int j=i+1; j < contatti.size()-1; j++) {
//                
//                if (contatti.get(i).getTelefono().equals(contatti.get(j).getTelefono()))
//                    return true;
//            }
//        }
//        
//        return false;

        for (Contatto c1 : contatti) {
            for (Contatto c2 : contatti) {
                
                // salto i contatti uguali, "continue" passa alla prossima iterazione
                if (c1 == c2) continue;
                
                // controllo la corrispondenza del numero
                if (c1.getTelefono().equals(c2.getTelefono()))
                    return true;
            }
        }
        
        return false;
    } 
    
    /** 
     * Filtra la lista dei contatti cercando solo quelli che contengono la 
     * stringa in input
     * @param cercata la stringa da cercare in nome e cognome
     * @return la lista filtrata dei contatti
     */
    public ArrayList<Contatto> ricercaAvanzata(String cercata) {
        
        // devo produrre una nuova lista, l'algoritmo non è in-place
        ArrayList<Contatto> filtrati = new ArrayList<>();
        
        // trasformo la stringa inserita in minuscola
        cercata = cercata.toLowerCase();
        
        // cerco la corrispondenza su nome O su cognome
        // il confronto non è esatto, mi basta che la stringa sia contenuta
        for (Contatto c : contatti) {
            if (c.getNome().toLowerCase().contains(cercata) || 
                c.getCognome().toLowerCase().contains(cercata)) {
                
                // se trovo corrispondenza, aggiungo alla nuova lista
                filtrati.add(c);
            }
        }
        
        return filtrati;
    }
    
    /**
     * Aggiunge un nuovo contatto alla lista, 
     * ma solo se un omonimo non è già presente in rubrica; 
     * in quel caso, modifica il numero di telefono del contatto esistente 
     * con quello del contatto nuovo. 
     * @param nuovo nuovo contatto da inserire in rubrica
     */
    public void aggiungiContatto(Contatto nuovo) {
        
        // sentinella per l'inserimento
        boolean presente = false;
        
        for (Contatto c : contatti) {
            if (c.isOmonimo(nuovo)) {
                presente = true;
                
                // contatto esistente, aggiorno il numero di telefono
                c.setTelefono(nuovo.getTelefono()); 
                break;
                // non dovrei altri omonimi, termino il ciclo
            }
        }
        
        // aggiungo il nuovo contatto perché non è presente
        if (!presente) {
            contatti.add(nuovo);
        }
    }
    
    
    public void ordinaCognome() {
        
        // versione estesa con corpo di funzione (necessita il return!)
        contatti.sort((c1, c2) -> {
            /*
            if (c1 < c2)
                return -1;
            if (c1 > c2)
                return +1;
            else 
                return 0;
            */
            
            return c1.getCognome().compareTo(c2.getCognome());
        });
    }
    
    public void ordinaNome() {
        
        // versione compatta, con una sola istruzione non necessito le graffe
        contatti.sort((c1, c2) -> 
           c1.getNome().compareTo(c2.getNome())
        );
    }
    
    public void ordinaEta(boolean crescente) {
        
        contatti.sort((c1, c2) -> {
            // classe wrapper
            return (crescente ? +1 : -1) * Integer.compare(c1.getEta(), c2.getEta());

            
//            if (c1.getEta() < c2.getEta())
//                return -1;
//            if (c1.getEta() > c2.getEta())
//                return +1;
//            //if (c1.getEta() == c2.getEta())
//            return 0;
        });

        
    }
    
}
