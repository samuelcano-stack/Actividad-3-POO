package appejercicio8.pkg3;

public class Prisma extends FiguraGeométrica {
    private double largo;
    private double ancho;
    private double altura;
    public Prisma(double largo, double ancho, double altura) {
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }
    public double calcularVolumen() {
        return largo * ancho * altura;
    }
    public double calcularSuperficie() {
        return 2.0 * (largo * ancho + largo * altura + ancho * altura);
    }
}
