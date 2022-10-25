package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Panel con la imagen.
@SuppressWarnings("serial")
public class PanelImagen extends JPanel {
    // Atributos de Interfaz
    // Etiqueta con la imagen.
    private JLabel etiquetaImagen;

    // Constructores
    // Construye el panel con la imagen.
    public PanelImagen() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Etiqueta Logo de las elecciones. Logos basados en la historieta Mafalda
        ImageIcon icono = new ImageIcon("src/recursos/Encabezado.png");
        etiquetaImagen = new JLabel("");
        etiquetaImagen.setIcon(icono);
        etiquetaImagen.setHorizontalAlignment(JLabel.CENTER);
        etiquetaImagen.setVerticalAlignment(JLabel.CENTER);
        etiquetaImagen.setIcon(new ImageIcon("src/recursos/Encabezado.png"));

        add(etiquetaImagen, BorderLayout.CENTER);
    }
}
