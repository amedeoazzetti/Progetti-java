
public class Contatto {
    
    private String nome, cognome;
    private String telefono;
    private Genere gender;
    private int eta;

    public Contatto(String nome, String cognome, String telefono, Genere gender) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.gender = gender;
    }

    public Contatto(String nome, String cognome, String telefono, Genere gender, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.gender = gender;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public Genere getGender() {
        return gender;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEta() {
        return eta;
    }
    
    public boolean isOmonimo(Contatto altro) {
        
        return this.nome.equals(altro.getNome()) &&
            this.cognome.equals(altro.getCognome());
    }
    
    public void stampaDati() {
        System.out.println(nome.charAt(0) + ". " + cognome + " #" + telefono + " - " + eta);
    }
}
