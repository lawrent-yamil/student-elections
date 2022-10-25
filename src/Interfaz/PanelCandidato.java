package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Datos.Candidato;

// Panel que contiene la informaci�n de un candidato.
@SuppressWarnings("serial")
public class PanelCandidato extends JPanel implements ActionListener {
    // Constantes
    // Comando para mostrar estad�sticas del candidato.
    private static final String VOTOS_POR_RANGO_EDAD = "Votos por rango de edad";
    // Comando para votar por el candidato.
    private static final String VOTAR = "Votar";

    // Atributos
    // Ventana principal de la aplicació.
    private final InterfazElecciones principal;
    // Número del candidato.
    private final int numCandidato;

    // Atributos de la interfaz
    // Etiqueta nombre del candidato.
    private final JLabel lblNombreCandidato;

    // Etiqueta edad del candidato.
    private final JLabel lblEdadCandidato;
    // Etiqueta partido pol�tico del candidato.
    private final JLabel lblPartidoPoliticoCandidato;
    // Etiqueta Costo de campa�a del candidato.
    private final JLabel lblCostoCampanhaCandidato;
    // Etiqueta número de votos del candidato.
    private final JLabel lblNumeroVotos;
    // Etiqueta porcentaje de votos del candidato.
    private final JLabel lblPorcVotos;
    // Caja de texto nombre del candidato.
    private final JTextField txtNombreCandidato;
    // Caja de texto edad del candidato.
    private final JTextField txtEdadCandidato;
    // Caja de texto partido pol�tico del candidato.
    private final JTextField txtPartidoPoliticoCandidato;
    // Caja de texto Costo de campa�a del candidato.
    private final JTextField txtCostoCampanhaCandidato;
    // Caja de texto n�mero de votos del candidato.
    private final JTextField txtNumeroVotos;
    // Caja de texto porcentaje de votos del candidato.
    private final JTextField txtPorcVotos;
    // Botón mostrar votos por rango de edad.
    private final JButton btnVotosPorRangoEdad;
    // Botón votar.
    private final JButton btnVotar;

    // Constructores
    // Constructor del panel.
    // @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
    // @param pNumeroCandidato Número del candidato. pNumeroCandidato > 0 &&
    // pNumeroCandidato < 4.
    public PanelCandidato(InterfazElecciones pPrincipal, int pNumeroCandidato, String nombreCandidato) {
        principal = pPrincipal;
        numCandidato = pNumeroCandidato;

        btnVotosPorRangoEdad = new JButton(VOTOS_POR_RANGO_EDAD);
        btnVotosPorRangoEdad.setPreferredSize(new Dimension(160, 20));
        btnVotosPorRangoEdad.setActionCommand(VOTOS_POR_RANGO_EDAD);
        btnVotosPorRangoEdad.addActionListener(this);

        btnVotar = new JButton(VOTAR);
        btnVotar.setPreferredSize(new Dimension(160, 20));
        btnVotar.setActionCommand(VOTAR);
        btnVotar.addActionListener(this);

        lblNombreCandidato = new JLabel("Nombre:");
        lblNombreCandidato.setHorizontalAlignment(JLabel.LEFT);

        lblEdadCandidato = new JLabel("Edad:");
        lblEdadCandidato.setHorizontalAlignment(JLabel.LEFT);

        lblPartidoPoliticoCandidato = new JLabel("Partido político:");
        lblPartidoPoliticoCandidato.setHorizontalAlignment(JLabel.LEFT);

        lblCostoCampanhaCandidato = new JLabel("Costo campaña:");
        lblCostoCampanhaCandidato.setHorizontalAlignment(JLabel.LEFT);

        lblNumeroVotos = new JLabel("Número de votos:");
        lblNumeroVotos.setHorizontalAlignment(JLabel.LEFT);
        lblNumeroVotos.setForeground(Color.RED.darker());

        lblPorcVotos = new JLabel("Porcentaje votos:");
        lblPorcVotos.setHorizontalAlignment(JLabel.LEFT);
        lblPorcVotos.setForeground(Color.RED.darker());

        txtNombreCandidato = new JTextField();
        txtNombreCandidato.setEditable(false);
        txtNombreCandidato.setFont(new Font("Dialog", Font.BOLD, 12));

        txtEdadCandidato = new JTextField();
        txtEdadCandidato.setEditable(false);
        txtEdadCandidato.setFont(new Font("Dialog", Font.BOLD, 12));

        txtPartidoPoliticoCandidato = new JTextField();
        txtPartidoPoliticoCandidato.setEditable(false);
        txtPartidoPoliticoCandidato.setFont(new Font("Dialog", Font.BOLD, 12));

        txtCostoCampanhaCandidato = new JTextField();
        txtCostoCampanhaCandidato.setEditable(false);
        txtCostoCampanhaCandidato.setFont(new Font("Dialog", Font.BOLD, 12));

        txtNumeroVotos = new JTextField();
        txtNumeroVotos.setEditable(false);
        txtNumeroVotos.setFont(new Font("Dialog", Font.BOLD, 12));
        txtNumeroVotos.setForeground(Color.RED.darker());

        txtPorcVotos = new JTextField();
        txtPorcVotos.setEditable(false);
        txtPorcVotos.setFont(new Font("Dialog", Font.BOLD, 12));
        txtPorcVotos.setForeground(Color.RED.darker());

        JPanel panelImagen = new JPanel();
        JPanel panelInformacionGlobal = new JPanel();
        JPanel panelInformacionDatos = new JPanel();
        JPanel panelInformacionBotones = new JPanel();

        setLayout(new java.awt.BorderLayout());
        setBorder(javax.swing.BorderFactory.createTitledBorder("Candidato" + numCandidato));

        panelImagen.setLayout(new BorderLayout());

        JLabel temp = new JLabel();
        temp.setHorizontalAlignment(JLabel.CENTER);
        temp.setIcon(new ImageIcon("src/Recursos/" + nombreCandidato + ".png"));

        panelImagen.add(temp, BorderLayout.CENTER);

        add(panelImagen, BorderLayout.CENTER);

        panelInformacionGlobal.setLayout(new BorderLayout());
        panelInformacionDatos.setLayout(new GridLayout(6, 2));
        panelInformacionBotones.setLayout(new GridLayout(2, 1));

        panelInformacionDatos.add(lblNombreCandidato);
        panelInformacionDatos.add(txtNombreCandidato);
        panelInformacionDatos.add(lblEdadCandidato);
        panelInformacionDatos.add(txtEdadCandidato);
        panelInformacionDatos.add(lblPartidoPoliticoCandidato);
        panelInformacionDatos.add(txtPartidoPoliticoCandidato);
        panelInformacionDatos.add(lblCostoCampanhaCandidato);
        panelInformacionDatos.add(txtCostoCampanhaCandidato);

        panelInformacionDatos.add(lblNumeroVotos);
        panelInformacionDatos.add(txtNumeroVotos);
        panelInformacionDatos.add(lblPorcVotos);
        panelInformacionDatos.add(txtPorcVotos);

        panelInformacionBotones.add(btnVotosPorRangoEdad);
        panelInformacionBotones.add(btnVotar);

        panelInformacionGlobal.add(panelInformacionDatos, BorderLayout.CENTER);
        panelInformacionGlobal.add(panelInformacionBotones, BorderLayout.SOUTH);

        add(panelInformacionGlobal, BorderLayout.SOUTH);
    }

    // Métodos
    // Actualiza el panel con la información del candidato dado por parámetro.
    // @param pCandidato Candidato para mostrar la informaci�n. pCandidato != null.
    public void actualizar(Candidato pCandidato) {
        txtNombreCandidato.setText(pCandidato.darNombre() + " " + pCandidato.darApellido());
        txtEdadCandidato.setText("" + pCandidato.darEdad());
        txtPartidoPoliticoCandidato.setText(String.valueOf(pCandidato.darPartidoPolitico()));
        txtCostoCampanhaCandidato.setText(formatearValorReal(pCandidato.darCostoCampanha()));
        txtNumeroVotos.setText("" + pCandidato.darCantidadTotalVotos());

        if (principal.darTotalVotosUrna() == 0) {
            btnVotosPorRangoEdad.setEnabled(false);
            txtPorcVotos.setText(principal.formatearValorReal(0) + " %");
        } else {
            btnVotosPorRangoEdad.setEnabled(true);
            txtPorcVotos.setText(principal.formatearValorReal(
                    (float) pCandidato.darCantidadTotalVotos() /
                            (float) principal.darTotalVotosUrna() * 100.f)
                    + " %");
        }
    }

    // Formatea un valor numérico real.
    // @param pValor Valor numérico a ser formateado.
    // @return Cadena con el valor formateado con puntos y signos.
    private String formatearValorReal(double pValor) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern(" ###,###.##");
        df.setMinimumFractionDigits(2);
        return df.format(pValor);
    }

    // Manejo de eventos del usuario.
    // @param pEvento Evento de usuario. pEvento != null.
    @Override
    public void actionPerformed(ActionEvent pEvento) {
        if (VOTAR.equals(pEvento.getActionCommand())) {
            principal.mostrarDialogoVotar(numCandidato);
        } else if (VOTOS_POR_RANGO_EDAD.equals(pEvento.getActionCommand())) {
            principal.mostrarDialogoEstadisticasCandidato(numCandidato);
        }
    }
}