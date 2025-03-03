
public class Stella {
    
    private String nome;
    private double massa;
    
    // metodi di accesso
    public String getNome() {
        return nome;
    }

    public double getMassa() {
        return massa;
    }
    
    // costruttore
    public Stella(String nome, double massa) {
        this.nome = nome;
        this.massa = massa;
    }
}
