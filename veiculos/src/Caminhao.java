public class Caminhao extends Veiculo{
    public double capacidadeToneladas;

    public Caminhao(String marca, String modelo, int ano, double capacidadeToneladas) {
        super(marca, modelo, ano);
        this.capacidadeToneladas = capacidadeToneladas;
    }

    public double getCapacidadeToneladas() {
        return capacidadeToneladas;
    }

    public void setCapacidadeToneladas(double capacidadeToneladas) {
        this.capacidadeToneladas = capacidadeToneladas;
    }

    @Override
    public double calcularValorAluguel(int dias) {
        return 200 * dias + 50 * this.capacidadeToneladas;
    }

    @Override
    public String toString() {
        return "Caminhao  - capacidadeToneladas=" + capacidadeToneladas + ", Marca()=" + getMarca() + ", Modelo()="
                + getModelo() + ", Ano()=" + getAno() + ", isAlugado()=" + isAlugado();
    }

    

    


    
}
