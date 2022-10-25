package Datos;

import Datos.VotosRangoEdad.Edad;
import Datos.VotosRangoEdad.Genero;

public class Candidato {
    // Enumeraciones
    // Enumeraciones para el medio de influencia.
    public enum Medio {
        // Representa el medio de influencia Internet.
        INTERNET,
        // Representa el medio de influencia radio.
        RADIO,
        // Representa el medio de influencia televisi�n.
        TELEVISION
    }

    // Constantes
    // Representa el costo de un voto influenciado por Internet.
    public final static double COSTO_INTERNET = 100;

    // Representa el costo de un voto influenciado por radio.
    public final static double COSTO_RADIO = 500;

    // Representa el costo de un voto influenciado por televisión.
    public final static double COSTO_TELEVISION = 1000;

    // Atributos
    // Nombre del candidato.
    private String nombre;
    // Apellido del candidato.
    private String apellido;
    // Partido político del candidato.
    private String partidoPolitico;
    // Edad del candidato.
    private int edad;
    // Costo de campa�a del candidato.
    private double costoCampanha;
    // N�mero que identifica al candidato.
    private int numero;
    // Votos en el rango de edad joven: entre 18 y 34 a�os.
    private VotosRangoEdad votosRango1;
    // Votos en el rango de edad media: entre 35 y 54 a�os.
    private VotosRangoEdad votosRango2;
    // Votos en el rango de edad mayor: desde 55 a�os en adelante.
    private VotosRangoEdad votosRango3;
    private VotosRangoEdad votosRango4;
    private VotosRangoEdad votosRango5;

    // Métodos
    // Crea el candidato con los valores dados por parámetro.
    // El nombre, apellido, partido político y edad fueron inicializados con los
    // valores dados por parámetro.
    // El costo de campaña se inicializó en cero.
    // Los votos en un rango de edad fueron inicializados con los siguientes
    // valores:
    // Rango1 - Edad: Joven. <br>
    // Rango2 - Edad: Media. <br>
    // Rango3 - Edad: Mayor.
    // @param pNombre Nombre del candidato. pNombre != null && pNombre != "".
    // @param pApellido Apellido del Candidato. pApellido != null && pApellido !=
    // "".
    // @param pPartidoPolitico Partido pol�tico del candidato. pPartidoPolitico !=
    // null && pPartidoPolitico != "".
    // @param pEdad Edad del candidato. pEdad > 0.
    // @param pNumero Número del candidato. pNumero > 0 && pNumero < 4.
    public Candidato(
            String pNombre, String pApellido,
            String pPartidoPolitico,
            int pEdad,
            int pNumero) {
        nombre = pNombre;
        apellido = pApellido;
        partidoPolitico = pPartidoPolitico;
        edad = pEdad;
        costoCampanha = 0;
        numero = pNumero;

        votosRango1 = new VotosRangoEdad(Edad.EDAD_JOVEN);
        votosRango2 = new VotosRangoEdad(Edad.EDAD_MEDIA);
        votosRango3 = new VotosRangoEdad(Edad.EDAD_MAYOR);
        votosRango4 = new VotosRangoEdad(Edad.EDAD_JOVEN);
        votosRango5 = new VotosRangoEdad(Edad.EDAD_MEDIA);
    }

    // Retorna el nombre del candidato.
    public String darNombre() {
        return nombre;
    }

    // Retorna el apellido del candidato.
    public String darApellido() {
        return apellido;
    }

    // Retorna el partido pol�tico del candidato.
    public String darPartidoPolitico() {
        return partidoPolitico;
    }

    // Retorna la edad del candidato.
    public int darEdad() {
        return edad;
    }

    // Retorna el costo de campaña del candidato.
    public double darCostoCampanha() {
        return costoCampanha;
    }

    // Retorna el número del candidato.
    public int darNumero() {
        return numero;
    }

    // Retorna la cantidad total de votos del candidato.
    public int darCantidadTotalVotos() {
        return votosRango1.darCantidadTotalVotos() + votosRango2.darCantidadTotalVotos()
                + votosRango3.darCantidadTotalVotos() + votosRango4.darCantidadTotalVotos()
                + votosRango5.darCantidadTotalVotos();
    }

    // Retorna la cantidad total de votos de género femenino.
    public int darTotalVotosGeneroFemenino() {
        return votosRango1.darCantidadFemenino() + votosRango2.darCantidadFemenino()
                + votosRango3.darCantidadFemenino() + votosRango4.darCantidadFemenino()
                + votosRango5.darCantidadFemenino();
    }

    // Retorna la cantidad total de votos de género masculino.
    public int darTotalVotosGeneroMasculino() {
        return votosRango1.darCantidadMasculino() + votosRango2.darCantidadMasculino()
                + votosRango3.darCantidadMasculino() + votosRango4.darCantidadMasculino()
                + votosRango5.darCantidadMasculino();
    }

    // Retorna los votos del rango de edad 1.
    public VotosRangoEdad darVotosRango1() {
        return votosRango1;
    }

    // Retorna los votos del rango de edad 2.
    public VotosRangoEdad darVotosRango2() {
        return votosRango2;
    }

    // Retorna los votos del rango de edad 3.
    public VotosRangoEdad darVotosRango3() {
        return votosRango3;
    }

    // Retorna los votos del rango de edad 4.
    public VotosRangoEdad darVotosRango4() {
        return votosRango4;
    }

    // Retorna los votos del rango de edad 5.
    public VotosRangoEdad darVotosRango5() {
        return votosRango5;
    }

    // Registra un voto en rango de edad para el género y medio de influencia dados
    // por parámetro.
    // La cantidad de votos en el rango de edad y género dados aumentó en uno.
    // El costo de campaña aumentó según el medio de influencia dado por parámetro.
    // @param pEdad Rango de edad de la persona que registró el voto. pEdad ==
    // EDAD_JOVEN || pEdad == EDAD_MEDIA || pEdad == EDAD_MAYOR.
    // @param pGenero Género de la persona que registró el voto. pGenero ==
    // MASCULINO || pGenero == FEMENINO.
    // @param pMedio Medio de influencia que influenció el voto. pMedio == INTERNET
    // || pMedio == RADIO || pMedio == TELEVISION.
    public void registrarVoto(Edad pEdad, Genero pGenero,
            Medio pMedio) {
        switch (pEdad) {
            case EDAD_JOVEN:
                votosRango1.registrarVoto(pGenero);
                break;
            case EDAD_MEDIA:
                votosRango2.registrarVoto(pGenero);
                break;
            case EDAD_MAYOR:
                votosRango3.registrarVoto(pGenero);
                break;
        }

        switch (pMedio) {
            case INTERNET: {
                costoCampanha += COSTO_INTERNET;
                break;
            }
            case RADIO: {
                costoCampanha += COSTO_RADIO;
                break;
            }
            case TELEVISION: {
                costoCampanha += COSTO_TELEVISION;
                break;
            }
        }
    }

    // Reinicia la información del candidato.
    // Los votos de los rangos 1, 2 y 3 fueron reiniciados.
    // El costo de campa�a fue cambiado a 0.
    public void reiniciar() {
        votosRango1.reiniciar();
        votosRango2.reiniciar();
        votosRango3.reiniciar();
        votosRango4.reiniciar();
        votosRango5.reiniciar();
        costoCampanha = 0;
    }
}
