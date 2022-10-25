package Interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Datos.Candidato.Medio;
import Datos.VotosRangoEdad.Edad;
import Datos.VotosRangoEdad.Genero;

// Diálogo para registrar un voto.
@SuppressWarnings("serial")
public class DialogoVotar extends JDialog implements ActionListener {
    // Constantes
    // Comando para el botón votar.
    private static final String VOTAR = "Votar";
    // Comando para el bot�n cancelar.
    private static final String CANCELAR = "Cancelar";

    // Atributos
    // Ventana principal de la aplicación.
    private final InterfazElecciones principal;
    // Número del candidato.
    private final int numeroCandidato;

    // Atributos de la Interfaz
    // Lista de opciones de género.
    private final JComboBox listaGenero;
    // Lista de opciones de rango de edad.
    private final JComboBox listaRangoEdad;
    // Lista de opciones de influencia.
    private final JComboBox listaInfluencia;

    // Constructores
    // Construye el diálogo e inicializa sus componentes.
    // @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
    // @param pNumeroCandidato Número del candidato. pNumeroCandidato > 0 &&
    // pNumeroCandidato < 4.
    public DialogoVotar(InterfazElecciones pPrincipal, int pNumeroCandidato) {
        principal = pPrincipal;

        setTitle("Votar");
        setSize(380, 245);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        numeroCandidato = pNumeroCandidato;

        setLayout(new BorderLayout());
        JPanel panelVotar = new JPanel();
        add(panelVotar, BorderLayout.CENTER);
        panelVotar.setLayout(new BorderLayout());
        panelVotar.setBorder(new CompoundBorder(new EmptyBorder(3, 5, 3, 5), new TitledBorder("Votar")));

        JPanel panelDatos = new JPanel();
        JPanel panelBotones = new JPanel();

        panelDatos.setLayout(new GridLayout(6, 1));

        JLabel lblInfluencia = new JLabel("¿Qué medio de comunicación lo influenció más en su voto?");
        JLabel lblGenero = new JLabel("Seleccione su género:");
        JLabel lblRangoEdad = new JLabel("Seleccione su rango de edad:");

        String[] opcionesGenero = { "Femenino", "Masculino" };
        String[] opcionesRangoEdad = { "Joven: 18 - 34 años", "Media: 35 - 54 años", "Mayor: 55 o más años" };
        String[] opcionesInfuencia = { "Televisión", "Radio", "Internet" };

        listaGenero = new JComboBox(opcionesGenero);
        listaGenero.setSelectedIndex(0);
        listaGenero.addActionListener(this);

        listaRangoEdad = new JComboBox(opcionesRangoEdad);
        listaRangoEdad.setSelectedIndex(0);
        listaRangoEdad.addActionListener(this);

        listaInfluencia = new JComboBox(opcionesInfuencia);
        listaInfluencia.setSelectedIndex(0);
        listaInfluencia.addActionListener(this);

        JButton btnVotar = new JButton(VOTAR);
        btnVotar.setActionCommand(VOTAR);
        btnVotar.addActionListener(this);

        JButton btnCancelar = new JButton(CANCELAR);
        btnCancelar.setActionCommand(CANCELAR);
        btnCancelar.addActionListener(this);

        panelDatos.add(lblGenero);
        panelDatos.add(listaGenero);
        panelDatos.add(lblRangoEdad);
        panelDatos.add(listaRangoEdad);
        panelDatos.add(lblInfluencia);
        panelDatos.add(listaInfluencia);

        panelBotones.add(btnVotar);
        panelBotones.add(btnCancelar);

        panelVotar.add(panelDatos, BorderLayout.CENTER);
        panelVotar.add(panelBotones, BorderLayout.SOUTH);

        setModal(true);
        setLocationRelativeTo(principal);
        setResizable(false);
    }

    // Métodos
    // Registra un voto a un candidato.
    // @param pMedio Medio de influencia del voto.
    // @param pGenero Género del votante.
    // @param pRangoEdad Rango de edad del votante.
    public void votar(String pMedio, String pGenero, String pRangoEdad) {
        Genero genero = Genero.MASCULINO;
        if (pGenero.equals("Femenino")) {
            genero = Genero.FEMENINO;
        }

        Medio medio = Medio.INTERNET;
        if (pMedio.equals("Televisión")) {
            medio = Medio.TELEVISION;
        } else if (pMedio.equals("Radio")) {
            medio = Medio.RADIO;
        }

        Edad edad = Edad.EDAD_JOVEN;
        if (pRangoEdad.equals("Media: 35 - 54 años")) {
            edad = Edad.EDAD_MEDIA;
        } else if (pRangoEdad.equals("Mayor: 55 o más años")) {
            edad = Edad.EDAD_MAYOR;
        }
        principal.registrarVotoCandidato(numeroCandidato, medio, genero, edad);
    }

    // Es el método que se llama cuando de hace click sobre un botón.
    // @param pEvento Es el evento de click sobre un botón. pEvento != null.
    @Override
    public void actionPerformed(ActionEvent pEvento) {
        String comando = pEvento.getActionCommand();

        if (VOTAR.equals(comando)) {
            String genero = (String) listaGenero.getSelectedItem();
            String rangoEdad = (String) listaRangoEdad.getSelectedItem();
            String influencia = (String) listaInfluencia.getSelectedItem();

            votar(influencia, genero, rangoEdad);
            dispose();
        } else if (CANCELAR.equals(comando)) {
            dispose();
        }
    }
}
