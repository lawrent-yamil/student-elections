package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

// Panel de manejo de opciones.
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener {
    // Constantes
    // Comando para las estadísticas.
    private static final String ESTADISTICAS = "ESTADISTICAS";
    // Comando para vaciar la urna.
    private static final String VACIAR_URNA = "VACIAR_URNA";
    // Comando para la opción 1.
    private static final String OPCION_1 = "OPCION_1";
    // Comando para la opción 2.
    private static final String OPCION_2 = "OPCION_2";

    // Atributos
    // Ventana principal de la aplicación.
    private InterfazElecciones principal;

    // Atributos de interfaz
    // Botón Estadisticas.
    private JButton btnEstadisticas;
    // Botón VaciarUrna.
    private JButton btnVaciarUrna;
    // Botón Opción 1.
    private JButton btnOpcion1;
    // Botón Opción 2.
    private JButton btnOpcion2;

    // Constructores
    // Constructor del panel.
    // @param pPrincipal Ventana principal de la aplicación.
    public PanelOpciones( InterfazElecciones pPrincipal ){
        principal = pPrincipal;

        setBorder( new TitledBorder( "Ver Estadísticas" ) );
        setLayout( new GridLayout( 1, 5 ) );

        // Botón estadísticas
        btnEstadisticas = new JButton( "Estadísticas" );
        btnEstadisticas.setActionCommand( ESTADISTICAS );
        btnEstadisticas.addActionListener( this );
        add( btnEstadisticas );

        // Botón vaciar urna
        btnVaciarUrna = new JButton( "Vaciar urna" );
        btnVaciarUrna.setActionCommand( VACIAR_URNA );
        btnVaciarUrna.addActionListener( this );
        add( btnVaciarUrna );

        // Botón opción 1
        btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );

        // Botón opción 2
        btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );
    }

    // Métodos
    // Manejo de los eventos de los botones.
    // @param pEvento Acci�n que gener� el evento. pEvento != null.
    @Override
    public void actionPerformed( ActionEvent pEvento ){
        if( OPCION_1.equals( pEvento.getActionCommand( ) ) ){
            principal.reqFuncOpcion1( );
        } else if( OPCION_2.equals( pEvento.getActionCommand( ) ) ) {
            principal.reqFuncOpcion2( );
        } else if( ESTADISTICAS.equals( pEvento.getActionCommand( ) ) ) {
            principal.mostrarDialogoEstadisticasTotales( );
        } else if( VACIAR_URNA.equals( pEvento.getActionCommand( ) ) ) {
            principal.reiniciarUrna( );
        }
    }
}
