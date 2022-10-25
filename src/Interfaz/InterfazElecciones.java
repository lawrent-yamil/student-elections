package Interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Datos.Candidato;
import Datos.Candidato.Medio;
import Datos.Urna;
import Datos.VotosRangoEdad.Edad;
import Datos.VotosRangoEdad.Genero;

// Ventana principal de la aplicación.
@SuppressWarnings("serial")
public class InterfazElecciones extends JFrame {
    // Atributos

    // Clase principal del mundo.
    private final Urna urna;
    // Atributos de la interfaz
    // Panel con la imagen.
    private final PanelImagen panelImagen;
    // Panel del candidato 1.
    private final PanelCandidato panelCandidato1;
    // Panel del candidato 2.
    private final PanelCandidato panelCandidato2;
    // Panel del candidato 3.
    private final PanelCandidato panelCandidato3;
    // Panel del candidato 4.
    private final PanelCandidato panelCandidato4;
    // Panel del candidato 5.
    private final PanelCandidato panelCandidato5;
    // Panel con las opciones.
    private final PanelOpciones panelOpciones;

    // Constructores
    // Construye la ventana principal de la aplicación y sus paneles.
    public InterfazElecciones() {
        setTitle("Elecciones Estudiantiles CTP Aserrí");
        setSize(700, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        urna = new Urna();

        setLayout(new BorderLayout());

        panelImagen = new PanelImagen();
        getContentPane().add(panelImagen, BorderLayout.NORTH);

        JPanel panelCandidatos = new JPanel();
        panelCandidatos.setLayout(new GridLayout(1, 3));
        getContentPane().add(panelCandidatos, BorderLayout.CENTER);
        panelCandidato1 = new PanelCandidato(this, 1, "irelia");
        panelCandidatos.add(panelCandidato1);
        panelCandidato2 = new PanelCandidato(this, 2, "yasuo");
        panelCandidatos.add(panelCandidato2);
        panelCandidato3 = new PanelCandidato(this, 3, "Akali");
        panelCandidatos.add(panelCandidato3);
        panelCandidato4 = new PanelCandidato(this, 4, "person1");
        panelCandidatos.add(panelCandidato4);
        panelCandidato5 = new PanelCandidato(this, 5, "person2");
        panelCandidatos.add(panelCandidato5);

        // panelUrna = new PanelUrna( );
        panelOpciones = new PanelOpciones(this);
        getContentPane().add(panelOpciones, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setResizable(false);

        actualizar();
    }

    // Métodos
    // Registra un voto a un candidato dado el medio de influencia, género y rango
    // de edad.
    // Se registró un voto al candidato con el número dado.
    // @param pNumeroCandidato Número del candidato a registrar el voto.
    // pNumeroCandidato > 0 && pNumeroCandidato < 4.
    // @param pMedio Medio de influencia que influenció el voto. pMedio == INTERNET
    // || pMedio == RADIO || pMedio == TELEVISION.
    // @param pGenero G�nero de la persona que registró el voto. pGenero ==
    // MASCULINO || pGenero == FEMENINO.
    // @param pEdad Rango de edad de la persona que registró el voto. pEdad ==
    // EDAD_JOVEN || pEdad == EDAD_MEDIA || pEdad == EDAD_MAYOR.
    public void registrarVotoCandidato(int pNumeroCandidato, Medio pMedio, Genero pGenero, Edad pEdad) {
        urna.registrarVoto(pNumeroCandidato, pEdad, pGenero, pMedio);
        actualizar();
    }

    // Reinicia la urna.
    public void reiniciarUrna() {
        urna.reiniciar();
        actualizar();
    }

    // Muestra el porcentaje de votos de un candidato dado.
    // @param pNumeroCandidato Número del candidato del cual se va a mostrar el
    // porcentaje de votos. pNumeroCandidato > 0 && pNumeroCandidato < 4.
    public void mostrarDialogoPorcentajeVotos(int pNumeroCandidato) {
        JOptionPane.showMessageDialog(this,
                "Porcentaje de votos: " + formatearValorReal(urna.calcularPorcentajeVotosCandidato(pNumeroCandidato))
                        + " %",
                "Candidato " + pNumeroCandidato, JOptionPane.INFORMATION_MESSAGE);
    }

    // Retorna el total de votos de la urna.
    public int darTotalVotosUrna() {
        return urna.calcularTotalVotos();
    }

    // Muestra el dialogo para votar.
    // @param pNumeroCandidato Número del candidato a adicionar el voto.
    // pNumeroCandidato > 0 && pNumeroCandidato < 4.
    public void mostrarDialogoVotar(int pNumeroCandidato) {
        DialogoVotar dialogo = new DialogoVotar(this, pNumeroCandidato);
        dialogo.setVisible(true);
    }

    // Muestra el dialogo de estad�sticas de un candidato.
    // @param pNumeroCandidato N�mero del candidato. pNumeroCandidato > 0 &&
    // pNumeroCandidato < 4.
    public void mostrarDialogoEstadisticasCandidato(int pNumeroCandidato) {
        Candidato candidato = urna.buscarCandidato(pNumeroCandidato);

        DialogoEstadisticasCandidato dialogo = new DialogoEstadisticasCandidato(this, candidato);
        dialogo.setVisible(true);
    }

    // Muestra el dialogo de estad�sticas totales de las elecciones.
    public void mostrarDialogoEstadisticasTotales() {
        int cantMasculino = urna.calcularTotalVotosGeneroMasculino();
        int cantFemenino = urna.calcularTotalVotosGeneroFemenino();
        int cantJovenes = urna.darTotalVotosRangoEdad(Edad.EDAD_JOVEN);
        int cantMedia = urna.darTotalVotosRangoEdad(Edad.EDAD_MEDIA);
        int cantMayor = urna.darTotalVotosRangoEdad(Edad.EDAD_MAYOR);
        int totalVotos = urna.calcularTotalVotos();
        double costoPromedioCampanha = urna.calcularCostoPromedioCampanha();
        DialogoEstadisticasGenerales dialogo = new DialogoEstadisticasGenerales(this, cantMasculino,
                cantFemenino, cantJovenes, cantMedia, cantMayor, totalVotos, costoPromedioCampanha);
        dialogo.setVisible(true);
    }

    // Formatea un valor numérico real.
    // @param pValor Valor numérico a ser formateado.
    public String formatearValorReal(double pValor) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern(" ###,###.##");
        df.setMinimumFractionDigits(2);
        return df.format(pValor);
    }

    // Actualiza la interfaz. <br>
    // Actualiza todos los paneles.
    private void actualizar() {
        panelCandidato1.actualizar(urna.darCandidato1());
        panelCandidato2.actualizar(urna.darCandidato2());
        panelCandidato3.actualizar(urna.darCandidato3());
        panelCandidato4.actualizar(urna.darCandidato4());
        panelCandidato5.actualizar(urna.darCandidato5());
        // panelUrna.actualizar( urna );
    }

    // Puntos de Extensión
    // Método para la extensi�n 1.
    public void reqFuncOpcion1() {
        String resultado = urna.metodo1();
        actualizar();
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para la extensi�n 2.
    public void reqFuncOpcion2() {
        String resultado = urna.metodo2();
        actualizar();
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    // Main
    // Ejecuta la aplicación.
    // @param pArgs Parámetros de la ejecución. No son necesarios.
    public static void main(String[] pArgs) {
        try {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            InterfazElecciones interfaz = new InterfazElecciones();
            interfaz.setVisible(true);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException
                | UnsupportedLookAndFeelException e) {
        }
    }
}