package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import Datos.Candidato;

// Diálogo para mostrar las estadísticas de un candidato.
@SuppressWarnings("serial")
public class DialogoEstadisticasCandidato extends JDialog implements ActionListener {
    // Atributos
    // Venta principal de la aplicación.
    private InterfazElecciones principal;

    // Constructores
    // Construye el diálogo e inicializa sus componentes
    // @param pPrincipal Es una referencia a la ventana principal de la interfaz.
    // pPrincipal != null
    // @param pCandidato Candidato cuyas estadísticas se mostrarán.
    public DialogoEstadisticasCandidato(InterfazElecciones pPrincipal, Candidato pCandidato) {
        principal = pPrincipal;

        setTitle("Votos por rango de edad candidato " + pCandidato.darNombre() + " " + pCandidato.darApellido());
        setSize(680, 455);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        DefaultCategoryDataset datosVotos = new DefaultCategoryDataset();
        JFreeChart graficoVotos = crearGrafico("Votos por rango de edad", datosVotos);

        ChartPanel panelVotos = new ChartPanel(graficoVotos);
        add(panelVotos, BorderLayout.CENTER);

        panelVotos.setBorder(new EmptyBorder(5, 5, 5, 5));
        datosVotos.setValue(pCandidato.darVotosRango1().darCantidadTotalVotos(), "18 - 34 años", "");
        datosVotos.setValue(pCandidato.darVotosRango2().darCantidadTotalVotos(), "35 - 54 años", "");
        datosVotos.setValue(pCandidato.darVotosRango3().darCantidadTotalVotos(), "55 ó más años", "");

        JPanel panelCentral = new JPanel();
        add(panelCentral, BorderLayout.SOUTH);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        panelCentral.add(btnAceptar);

        setModal(true);
        setLocationRelativeTo(principal);
        setResizable(false);
    }

    // Crea y configura los atributos de la gráfica en barras.
    // @param pTitulo Título de la gráfica.
    private static JFreeChart crearGrafico(String pTitulo, DefaultCategoryDataset pDatos) {
        JFreeChart chart = ChartFactory.createBarChart(pTitulo, "Rango de edad", "Votos", pDatos,
                PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.white);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
        return chart;
    }

    // Método que se llama cuando de hace click sobre un bot�n.
    // @param pEvento Evento de click sobre un botón. pEvento != null.
    @Override
    public void actionPerformed(ActionEvent pEvento) {
        dispose();
    }
}
