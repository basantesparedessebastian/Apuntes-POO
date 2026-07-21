package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    public static void main(String[] args) {
    JFrame ventana = new JFrame();
    ventana.setTitle("Mi primera ventana");
    ventana.setSize(500,400);
    ventana.setVisible(true);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel texto = new JLabel("Hola mundo");
    ventana.add(texto);
    } 
}