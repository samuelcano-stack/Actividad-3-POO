package appejercicio8.pkg3;

public class Cubo extends FiguraGeométrica {
    private double arista;
    public Cubo(double arista) {
        this.arista = arista;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }
    public double calcularVolumen() {
        return Math.pow(arista, 3.0);
    }
    public double calcularSuperficie() {
        return 6.0 * Math.pow(arista, 2.0);
    }
}
