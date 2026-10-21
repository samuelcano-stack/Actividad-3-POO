package appejercicio8.pkg3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrisma extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel largo, ancho, altura, volumen, superficie;
    private JTextField campoLargo, campoAncho, campoAltura;
    private JButton calcular;
    private PanelFigura imagen;
    public VentanaPrisma() {
        inicio();
        setTitle("Prisma");
        setSize(450, 250);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        largo = new JLabel();
        largo.setText("Largo (cms):");
        largo.setBounds(20, 20, 135, 23);
        campoLargo = new JTextField();
        campoLargo.setBounds(100, 20, 135, 23);
        ancho = new JLabel();
        ancho.setText("Ancho (cms):");
        ancho.setBounds(20, 50, 135, 23);
        campoAncho = new JTextField();
        campoAncho.setBounds(100, 50, 135, 23);
        altura = new JLabel();
        altura.setText("Altura (cms):");
        altura.setBounds(20, 80, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(100, 80, 135, 23);
        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(100, 110, 135, 23);
        calcular.addActionListener(this);
        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setBounds(20, 140, 245, 23);
        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setBounds(20, 170, 245, 23);
        imagen = new PanelFigura(PanelFigura.PRISMA);
        imagen.setBounds(270, 20, 160, 160);
        contenedor.add(largo);
        contenedor.add(campoLargo);
        contenedor.add(ancho);
        contenedor.add(campoAncho);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        contenedor.add(imagen);
    }
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            boolean error = false;
            try {
                double largo = Double.parseDouble(campoLargo.getText());
                double ancho = Double.parseDouble(campoAncho.getText());
                double altura = Double.parseDouble(campoAltura.getText());
                Prisma prisma = new Prisma(largo, ancho, altura);
                volumen.setText("Volumen (cm3): " + String.format("%.2f", prisma.calcularVolumen()));
                superficie.setText("Superficie (cm2): " + String.format("%.2f", prisma.calcularSuperficie()));
            } catch (Exception e) {
                error = true;
            } finally {
                if (error) {
                    JOptionPane.showMessageDialog(null,
                            "Campo nulo o error en formato de número",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
}
