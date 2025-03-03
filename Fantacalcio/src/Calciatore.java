public class Calciatore {
    private String nome, cognome;
    private Ruolo ruolo;
    private double mediaVoto;
    private boolean infortunato;

    public Calciatore(String nome, String cognome, Ruolo ruolo, double mediaVoto, boolean infortunato) {
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
        this.mediaVoto = mediaVoto;
        this.infortunato = infortunato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public double getMediaVoto() {
        return mediaVoto;
    }

    public void setMediaVoto(double mediaVoto) {
        this.mediaVoto = mediaVoto;
    }

    public boolean isInfortunato() {
        return infortunato;
    }

    public void setInfortunato(boolean infortunato) {
        this.infortunato = infortunato;
    }
    
    public void stampaDati(){
        System.out.println("Nome: " + nome + " " + cognome);
        System.out.println("Ruolo: " + ruolo);
        System.out.println("Media voto: " + mediaVoto);
        System.out.println("Infortunato: " + infortunato);
    }
    
}
