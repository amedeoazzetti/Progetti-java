
public class Pianeta {
    
    // attributi o campi
    private String nome;
    private double massa, raggio, distanzaStella;
    // information hiding
    
    // -----------------------------
    
    // incapsulamento (encapsulation)
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMassa() {
        return massa;
    }

    public double getRaggio() {
        return raggio;
    }

    public double getDistanzaStella() {
        return distanzaStella;
    }
    
    // costruttore
    public Pianeta() {}
    
    public Pianeta(String nome, double massa, double raggio, double distanza) {
        // crea l'istanza
        // inizializza gli attributi
        this.nome = nome;
        this.massa = massa;
        this.raggio = raggio;
        this.distanzaStella = distanza;
    }
    
    /**
     * Calcola l'accelerazione di gravità del pianeta con formula Newton
     * @return accelerazione di gravità
     */
    public double getGravita() {
        
        return Sistema.G * this.massa / Math.pow(raggio, 2);
    }

    public void stampaDati() {
        
        System.out.println(this.nome + ": " + this.distanzaStella);
    }

    // dichiarazione della costante di gravitazione universale
    public static final double G = 6.67408e-11;

    /**
     * Calcola l'accelerazione di gravità del pianeta con formula Newton
     * @return accelerazione di gravità
     */
    public double calcolaGravita() {
        return G * this.massa / (this.raggio * this.raggio);
    }
    
}
