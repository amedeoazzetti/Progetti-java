import java.util.ArrayList;

public class Squadra {
    private String nome;
    private ArrayList<Calciatore> calciatori = new ArrayList<>();
    private static final int MAX_PORTIERI = 3;
    private static final int MAX_DIFENSORI = 8;
    private static final int MAX_CENTROCAMPISTI = 8;
    private static final int MAX_ATTACCANTI = 6;

    public Squadra(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void stampaDatiCalciatore() {
        for (Calciatore c : calciatori) {
            c.stampaDati();
        }
    }

    public int contaPerRuolo(Ruolo r) {
        int count = 0;
        for (Calciatore c : calciatori) {
            if (c.getRuolo() == r) {
                count++;
            }
        }
        return count;

    }

    public void stampaFiltrata(Ruolo filtro) {
        for (Calciatore c : calciatori) {
            if (filtro == null || c.getRuolo() == filtro) {
                c.stampaDati();
            }
        }
    }

    
    public void aggiungiCalciatore(Calciatore nuovo) {
        Ruolo ruolo = nuovo.getRuolo();
        int count = contaPerRuolo(ruolo);


        switch (ruolo) {
            case PORTIERE:
                if (count < MAX_PORTIERI) {
                    aggiungiCalciatore(nuovo);
                } else {
                    System.out.println("Numero massimo di portieri raggiunto.");
                }
                break;
            case DIFENSORE:
                if (count < MAX_DIFENSORI) {
                    aggiungiCalciatore(nuovo);
                } else {
                    System.out.println("Numero massimo di difensori raggiunto.");
                }
                break;
            case CENTROCAMPISTA:
                if (count < MAX_CENTROCAMPISTI) {
                    aggiungiCalciatore(nuovo);
                } else {
                    System.out.println("Numero massimo di centrocampisti raggiunto.");
                }
                break;
            case ATTACCANTE:
                if (count < MAX_ATTACCANTI) {
                    aggiungiCalciatore(nuovo);
                } else {
                    System.out.println("Numero massimo di attaccanti raggiunto.");
                }
                break;
            default:
                System.out.println("Ruolo non valido.");
        }
    }


    public Calciatore cercaMigliore() {
        if (calciatori.isEmpty()) {
            return null;
        }


        Calciatore migliore = calciatori.get(0);
        for (Calciatore calciatore : calciatori) {
            if (calciatore.getMediaVoto() > migliore.getMediaVoto()) {
                migliore = calciatore;
            }
        }
        return migliore;
    }
    public ArrayList<Calciatore> trovaPeggiori() {
        ArrayList<Calciatore> peggiori = new ArrayList<>();
        for (Calciatore calciatore : calciatori) {
            if (calciatore.getRuolo() != Ruolo.PORTIERE && calciatore.getMediaVoto() < 6) {
                peggiori.add(calciatore);
            }
        }
        return peggiori;
    }


    public int rimuoviInfortunati() {
        int rimossi = 0;
        ArrayList<Calciatore> daRimuovere = new ArrayList<>();
        for (Calciatore calciatore : calciatori) {
            if (calciatore.isInfortunato()) {
                daRimuovere.add(calciatore);
                rimossi++;
            }
        }
        calciatori.removeAll(daRimuovere);
        return rimossi;
    } 
}



