public class Moto extends Veiculo {
    
    private int cilindradas;
    
    public Moto(String marca, String modelo, int ano, int cilindradas) {
        super(marca, modelo, ano);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public double calcularValorAluguel(int dias) {
        return 50 * dias + 0.1 * cilindradas;
    }

    @Override
    public String toString() {
        return "Moto [cilindradas=" + cilindradas + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo()
                + ", getAno()=" + getAno() + ", isAlugado()=" + isAlugado() + "]";
    }


    
    
    
}