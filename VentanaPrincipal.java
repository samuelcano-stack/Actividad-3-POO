package appejercicio8.pkg2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel nota1, nota2, nota3, nota4, nota5, promedio,
    desviación, mayor, menor;
    private JTextField campoNota1, campoNota2, campoNota3,
    campoNota4, campoNota5;
    private JButton calcular, limpiar;
    
    public VentanaPrincipal(){
        inicio();
        setTitle("Notas");
        setSize(280,380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        nota1 = new JLabel();
        nota1.setText("Nota 1:");
        nota1.setBounds(20, 20, 135, 23);
        campoNota1 = new JTextField();
        campoNota1.setBounds(105, 20, 135, 23);
        nota2 = new JLabel();
        nota2.setText("Nota 2:");
        nota2.setBounds(20, 50, 135, 23);
        campoNota2 = new JTextField();
        campoNota2.setBounds(105, 50, 135, 23);
        nota3 = new JLabel();
        nota3.setText("Nota 3:");
        nota3.setBounds(20, 80, 135, 23);
        campoNota3 = new JTextField();
        campoNota3.setBounds(105, 80, 135, 23);
        nota4 = new JLabel();
        nota4.setText("Nota 4:");
        nota4.setBounds(20, 110, 135, 23);
        campoNota4 = new JTextField();
        campoNota4.setBounds(105, 110, 135, 23);
        nota5 = new JLabel();
        nota5.setText("Nota 5:");
        nota5.setBounds(20, 140, 135, 23);
        campoNota5 = new JTextField();
        campoNota5.setBounds(105, 140, 135, 23);
        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(20, 170, 100, 23);
        calcular.addActionListener(this);
        limpiar = new JButton();
        limpiar.setText("Limpiar");
        limpiar.setBounds(125, 170, 80, 23);
        limpiar.addActionListener(this);
        promedio = new JLabel();
        promedio.setText("Promedio = ");
        promedio.setBounds(20, 210, 135, 23);
        desviación = new JLabel();
        desviación.setText("Desviación = ");
        desviación.setBounds(20, 240, 200, 23);
        mayor = new JLabel();
        mayor.setText("Nota mayor = ");
        mayor.setBounds(20, 270, 120, 23);
        menor = new JLabel();
        menor.setText("Nota menor = ");
        menor.setBounds(20, 300, 120, 23);
        contenedor.add(nota1);
        contenedor.add(campoNota1);
        contenedor.add(nota2);
        contenedor.add(campoNota2);
        contenedor.add(nota3);
        contenedor.add(campoNota3);
        contenedor.add(nota4);
        contenedor.add(campoNota4);
        contenedor.add(nota5);
        contenedor.add(campoNota5);
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviación);
        contenedor.add(mayor);
        contenedor.add(menor);
        }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            JTextField[] campos = {campoNota1, campoNota2, campoNota3,
                           campoNota4, campoNota5};
        Notas notas = new Notas();

        for (int i = 0; i < campos.length; i++) {
            Double valor = leerNota(campos[i], i + 1);
            if (valor == null) {
                return;
            }
            notas.listaNotas[i] = valor;
        }

        promedio.setText("Promedio = " + String.format("%.2f", notas.calcularPromedio()));
        desviación.setText("Desviación estándar = " + String.format("%.2f", notas.calcularDesviación()));
        mayor.setText("Valor mayor = " + notas.calcularMayor());
        menor.setText("Valor menor = " + notas.calcularMenor());
    }

        if (evento.getSource() == limpiar) {
        campoNota1.setText("");
        campoNota2.setText("");
        campoNota3.setText("");
        campoNota4.setText("");
        campoNota5.setText("");
        promedio.setText("Promedio = ");
        desviación.setText("Desviación = ");
        mayor.setText("Nota mayor = ");
        menor.setText("Nota menor = ");
        campoNota1.requestFocus();
        }
    }
    
    private Double leerNota(JTextField campo, int numero) {
        String texto = campo.getText().trim();

        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe ingresar la nota " + numero + ".",
                    "Nota no ingresada",
                    JOptionPane.WARNING_MESSAGE);
            campo.requestFocus();
            return null;
        }

        try {
            return Double.parseDouble(texto);
            }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La nota " + numero + " no es numérica.\n"
                    + "Ingrese únicamente números (use punto para los decimales).",
                    "Dato no válido",
                    JOptionPane.ERROR_MESSAGE);
            campo.selectAll();
            campo.requestFocus();
            return null;
            }
    }
}