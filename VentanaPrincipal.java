package appejercicio8.pkg3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JButton cilindro, esfera, pirámide, cubo, prisma;
        
    public VentanaPrincipal(){
        inicio();
        setTitle("Figuras");
        setSize(350,190);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        cilindro = new JButton();
        cilindro.setText("Cilindro");
        cilindro.setBounds(20, 30, 80, 23);
        cilindro.addActionListener(this);
        esfera = new JButton();
        esfera.setText("Esfera");
        esfera.setBounds(125, 30, 80, 23);
        esfera.addActionListener(this);
        pirámide = new JButton();
        pirámide.setText("Pirámide");
        pirámide.setBounds(225, 30, 100, 23);
        pirámide.addActionListener(this);
        contenedor.add(cilindro);
        contenedor.add(esfera);
        contenedor.add(pirámide);
        cubo = new JButton();
        cubo.setText("Cubo");
        cubo.setBounds(20, 70, 80, 23);
        cubo.addActionListener(this);
        prisma = new JButton();
        prisma.setText("Prisma");
        prisma.setBounds(125, 70, 80, 23);
        prisma.addActionListener(this);
        contenedor.add(cubo);
        contenedor.add(prisma);
    }
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == esfera) {
        VentanaEsfera esfera = new VentanaEsfera();
        esfera.setVisible(true);
        }
        if (evento.getSource() == cilindro) {
        VentanaCilindro cilindro = new VentanaCilindro();
        cilindro.setVisible(true);
        }
        if (evento.getSource() == pirámide) {
        VentanaPirámide pirámide = new VentanaPirámide();
        pirámide.setVisible(true);
        }
        if (evento.getSource() == cubo) {
            VentanaCubo cubo = new VentanaCubo();
            cubo.setVisible(true);
        }
        if (evento.getSource() == prisma) {
            VentanaPrisma prisma = new VentanaPrisma();
            prisma.setVisible(true);
        }   
    }
}
