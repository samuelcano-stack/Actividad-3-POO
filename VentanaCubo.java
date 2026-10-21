package appejercicio8.pkg3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCubo extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel arista, volumen, superficie;
    private JTextField campoArista;
    private JButton calcular;
    private PanelFigura imagen;
    public VentanaCubo() {
        inicio();
        setTitle("Cubo");
        setSize (450, 250);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        arista = new JLabel();
        arista.setText("Arista (cms):");
        arista.setBounds(20, 20, 135, 23);
        campoArista = new JTextField();
        campoArista.setBounds(100, 20, 135, 23);
        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(100, 50, 135, 23);
        calcular.addActionListener(this);
        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setBounds(20, 90, 245, 23);
        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setBounds(20, 120, 245, 23);
        imagen = new PanelFigura(PanelFigura.CUBO);
        imagen.setBounds(270, 20, 160, 160);
        contenedor.add(arista);
        contenedor.add(campoArista);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        contenedor.add(imagen);
    }
    
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            boolean error = false;
            try {
                double arista = Double.parseDouble(campoArista.getText());
                Cubo cubo = new Cubo(arista);
                volumen.setText("Volumen (cm3): " + String.format("%.2f", cubo.calcularVolumen()));
                superficie.setText("Superficie (cm2): " + String.format("%.2f", cubo.calcularSuperficie()));
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