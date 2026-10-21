package appejercicio8.pkg3;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class PanelFigura extends JPanel {
    public static final int CILINDRO = 0;
    public static final int ESFERA = 1;
    public static final int PIRÁMIDE = 2;
    public static final int CUBO = 3;
    public static final int PRISMA = 4;

    private static final Color CONTORNO = new Color(30, 50, 100);
    private static final Color FRENTE = new Color(135, 175, 240);
    private static final Color LATERAL = new Color(90, 130, 210);
    private static final Color SUPERIOR = new Color(185, 210, 250);

    private final int figura;

    public PanelFigura(int figura) {
        this.figura = figura;
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2f));
        int w = getWidth();
        int h = getHeight();

        switch (figura) {
            case CILINDRO:
                dibujarCilindro(g2, w, h);
                break;
            case ESFERA:
                dibujarEsfera(g2, w, h);
                break;
            case PIRÁMIDE:
                dibujarPirámide(g2, w, h);
                break;
            case CUBO:
                dibujarCaja(g2, (w - 125) / 2, (h - 125) / 2, 90, 90, 35);
                break;
            case PRISMA:
                dibujarCaja(g2, (w - 140) / 2, (h - 90) / 2, 110, 60, 30);
                break;
        }
        g2.dispose();
    }

    private void rellenar(Graphics2D g2, Shape forma, Paint relleno) {
        g2.setPaint(relleno);
        g2.fill(forma);
        g2.setColor(CONTORNO);
        g2.draw(forma);
    }

    private void dibujarCaja(Graphics2D g2, int x, int y, int ancho, int alto, int prof) {
        Polygon frente = new Polygon(
                new int[]{x, x + ancho, x + ancho, x},
                new int[]{y + prof, y + prof, y + prof + alto, y + prof + alto}, 4);
        Polygon superior = new Polygon(
                new int[]{x, x + prof, x + prof + ancho, x + ancho},
                new int[]{y + prof, y, y, y + prof}, 4);
        Polygon derecha = new Polygon(
                new int[]{x + ancho, x + prof + ancho, x + prof + ancho, x + ancho},
                new int[]{y + prof, y, y + alto, y + prof + alto}, 4);
        rellenar(g2, frente, FRENTE);
        rellenar(g2, superior, SUPERIOR);
        rellenar(g2, derecha, LATERAL);
    }

    private void dibujarCilindro(Graphics2D g2, int w, int h) {
        int rx = 45;
        int ry = 14;
        int altura = 90;
        int cx = w / 2;
        int yArriba = (h - altura) / 2;
        int yAbajo = yArriba + altura;

        rellenar(g2, new Ellipse2D.Double(cx - rx, yAbajo - ry, 2 * rx, 2 * ry), LATERAL);
        g2.setColor(FRENTE);
        g2.fill(new Rectangle2D.Double(cx - rx, yArriba, 2 * rx, altura));
        g2.setColor(CONTORNO);
        g2.drawLine(cx - rx, yArriba, cx - rx, yAbajo);
        g2.drawLine(cx + rx, yArriba, cx + rx, yAbajo);
        rellenar(g2, new Ellipse2D.Double(cx - rx, yArriba - ry, 2 * rx, 2 * ry), SUPERIOR);
    }

    private void dibujarEsfera(Graphics2D g2, int w, int h) {
        int d = 110;
        int x = (w - d) / 2;
        int y = (h - d) / 2;
        Paint degradado = new RadialGradientPaint(
                new Point2D.Float(x + d * 0.35f, y + d * 0.35f), d * 0.75f,
                new float[]{0f, 1f},
                new Color[]{new Color(205, 225, 255), new Color(60, 100, 200)});
        rellenar(g2, new Ellipse2D.Double(x, y, d, d), degradado);
        g2.setStroke(new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                10f, new float[]{4f, 4f}, 0f));
        g2.draw(new Ellipse2D.Double(x, y + d / 2.0 - 14, d, 28));
    }

    private void dibujarPirámide(Graphics2D g2, int w, int h) {
        int cx = w / 2;
        int yBase = h / 2 + 35;
        Point p1 = new Point(cx - 50, yBase + 10);
        Point p2 = new Point(cx + 30, yBase + 10);
        Point p3 = new Point(cx + 55, yBase - 15);
        Point p4 = new Point(cx - 25, yBase - 15);
        Point cima = new Point(cx + 2, h / 2 - 60);

        Stroke normal = g2.getStroke();
        g2.setStroke(new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                10f, new float[]{4f, 4f}, 0f));
        g2.setColor(CONTORNO);
        g2.drawLine(p1.x, p1.y, p4.x, p4.y);
        g2.drawLine(p4.x, p4.y, p3.x, p3.y);
        g2.drawLine(p4.x, p4.y, cima.x, cima.y);
        g2.setStroke(normal);

        rellenar(g2, new Polygon(new int[]{p1.x, p2.x, cima.x},
                new int[]{p1.y, p2.y, cima.y}, 3), FRENTE);
        rellenar(g2, new Polygon(new int[]{p2.x, p3.x, cima.x},
                new int[]{p2.y, p3.y, cima.y}, 3), LATERAL);
    }
}
