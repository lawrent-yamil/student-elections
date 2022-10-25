package Datos;

// Votos de un rango de edad.
public class VotosRangoEdad {
    // Enumeradores para los rangos de edad.
    public enum Edad {
        // Representa el rango entre 18 y 34 años.
        EDAD_JOVEN,
        // Representa el rango entre 35 y 54 años.
        EDAD_MEDIA,
        // Representa el rango de 55 años en adelante.
        EDAD_MAYOR
    }

    // Enumeradores para género.
    public enum Genero {
        // Representa el género masculino.
        MASCULINO,
        // Representa el género femenino.
        FEMENINO
    }

    // Atributos
    // Cantidad de votos de personas con género masculino.
    private int cantidadMasculino;
    // Cantidad de votos de personas con género femenino.
    private int cantidadFemenino;
    // Edad del rango.
    private final Edad edad;

    // Constructores
    // -----------------------------------------------------------------
    // Crea los votos en un rango de edad.
    // La cantidad de votos del género masculino fueron inicializados en 0.
    // La cantidad de votos del género femenino fueron inicializados en 0.
    // @param pEdad Rango de edad. pEdad pertenece a Edad.
    public VotosRangoEdad(Edad pEdad) {
        cantidadMasculino = 0;
        cantidadFemenino = 0;
        edad = pEdad;
    }

    // Métodos
    // Retorna la cantidad de votos de personas con género masculino.
    public int darCantidadMasculino() {
        return cantidadMasculino;
    }

    // Retorna la cantidad de votos de personas con género femenino.
    public int darCantidadFemenino() {
        return cantidadFemenino;
    }

    // Retorna la edad del rango.
    public Edad darEdad() {
        return edad;
    }

    // Retorna la cantidad total de votos.
    public int darCantidadTotalVotos() {
        int total = cantidadMasculino + cantidadFemenino;
        return total;
    }

    // Registra un voto al género dado por parámetro.
    // Aumentó en uno la cantidad de votos de un género.
    // @param pGenero Género al cual aumentar la cantidad de votos. pGenero ==
    // MASCULINO || pGenero == FEMENINO.
    public void registrarVoto(Genero pGenero) {
        switch (pGenero) {
            case MASCULINO: {
                cantidadMasculino++;
                break;
            }
            case FEMENINO: {
                cantidadFemenino++;
                break;
            }
        }
    }

    // Reinicia el conteo de votos.
    // La cantidad de votos masculinos y femeninos ahora son 0.
    public void reiniciar() {
        cantidadMasculino = 0;
        cantidadFemenino = 0;
    }
}
