package Datos;

import Datos.Candidato.Medio;
import Datos.VotosRangoEdad.Edad;
import Datos.VotosRangoEdad.Genero;

// Urna de votación con tres candidatos.
public class Urna {
    // Atributos
    // Candidato número 1 de la elecciones.
    private final Candidato candidato1;
    // Candidato núumero 2 de la elecciones.
    private final Candidato candidato2;
    // Candidato núumero 3 de la elecciones.
    private final Candidato candidato3;
    // Candidato núumero 4 de la elecciones.
    private final Candidato candidato4;
    // Candidato núumero 5 de la elecciones.
    private final Candidato candidato5;

    // Métodos
    // Inicializa los 5 candidatos.
    public Urna() {
        candidato1 = new Candidato("Irelia", "Doofentzmirchs", "Republicano Neozelandes", 27, 1);
        candidato2 = new Candidato("Yasunovich", "Stalin", "Volchevique", 56, 2);
        candidato3 = new Candidato("Akali", "Hotler", "Tradicional Comunista", 26, 3);
        candidato4 = new Candidato("Pepe", "Pepiño", "America Unida", 46, 4);
        candidato5 = new Candidato("Kendall", "Castro", "Congo City", 23, 5);
    }

    // Retorna el candidato 1.
    public Candidato darCandidato1() {
        return candidato1;
    }

    // Retorna el candidato 2.
    public Candidato darCandidato2() {
        return candidato2;
    }

    // Retorna el candidato 3.
    public Candidato darCandidato3() {
        return candidato3;
    }

    // Retorna el candidato 4.
    public Candidato darCandidato4() {
        return candidato4;
    }

    // Retorna el candidato 5.
    public Candidato darCandidato5() {
        return candidato5;
    }

    // Busca el candidato con el nombre dado.
    // @param pNumero Número del candidato a buscar. pNumero > 0 && pNumero < 4.
    // @return El candidato con el nombre dado, null si no lo encuentra.
    public Candidato buscarCandidato(int pNumero) {
        Candidato buscado = null;

        if (candidato1.darNumero() == pNumero) {
            buscado = candidato1;

        } else if (candidato2.darNumero() == pNumero) {
            buscado = candidato2;

        } else if (candidato3.darNumero() == pNumero) {
            buscado = candidato3;

        } else if (candidato4.darNumero() == pNumero) {
            buscado = candidato4;
            
        } else if (candidato5.darNumero() == pNumero) {
            buscado = candidato5;
        }
        return buscado;
    }

    // Retorna el total de votos de todos los candidatos.
    public int calcularTotalVotos() {
        return candidato1.darCantidadTotalVotos() 
                + candidato2.darCantidadTotalVotos()
                + candidato3.darCantidadTotalVotos()
                + candidato4.darCantidadTotalVotos()
                + candidato5.darCantidadTotalVotos();
    }

    // Retorna el total de votos de todos los candidatos por votantes de género
    // femenino.
    public int calcularTotalVotosGeneroFemenino() {
        return candidato1.darTotalVotosGeneroFemenino() + candidato2.darTotalVotosGeneroFemenino()
                + candidato3.darTotalVotosGeneroFemenino() + candidato4.darTotalVotosGeneroFemenino()
                + candidato5.darTotalVotosGeneroFemenino();
    }

    // Retorna el total de votos de todos los candidatos por votantes de género
    // masculino.
    public int calcularTotalVotosGeneroMasculino() {
        return candidato1.darTotalVotosGeneroMasculino() 
                + candidato2.darTotalVotosGeneroMasculino()
                + candidato3.darTotalVotosGeneroMasculino()
                + candidato4.darTotalVotosGeneroMasculino()
                + candidato5.darTotalVotosGeneroMasculino();
    }

    // Retorna el total de votos en un rango de edad específico.
    // @param pEdad Edad del rango. pEdad == EDAD_JOVEN || pEdad == EDAD_MEDIA ||
    // pEdad == EDAD_MAYOR.
    public int darTotalVotosRangoEdad(Edad pEdad) {
        int total = 0;
        switch (pEdad) {
            case EDAD_JOVEN: {
                total = candidato1.darVotosRango1().darCantidadTotalVotos()
                        + candidato2.darVotosRango1().darCantidadTotalVotos()
                        + candidato3.darVotosRango1().darCantidadTotalVotos()
                        + candidato4.darVotosRango1().darCantidadTotalVotos()
                        + candidato5.darVotosRango1().darCantidadTotalVotos();
                break;
            }
            case EDAD_MEDIA: {
                total = candidato1.darVotosRango2().darCantidadTotalVotos()
                        + candidato2.darVotosRango2().darCantidadTotalVotos()
                        + candidato3.darVotosRango2().darCantidadTotalVotos()
                        + candidato4.darVotosRango2().darCantidadTotalVotos()
                        + candidato5.darVotosRango2().darCantidadTotalVotos();
                break;
            }
            case EDAD_MAYOR: {
                total = candidato1.darVotosRango3().darCantidadTotalVotos()
                        + candidato2.darVotosRango3().darCantidadTotalVotos()
                        + candidato3.darVotosRango3().darCantidadTotalVotos()
                        + candidato4.darVotosRango3().darCantidadTotalVotos()
                        + candidato5.darVotosRango3().darCantidadTotalVotos();
                break;
            }
        }
        return total;
    }

    // Calcula el costo promedio de campaña de los candidatos.
    public double calcularCostoPromedioCampanha() {
        double total = candidato1.darCostoCampanha() + candidato2.darCostoCampanha() + candidato3.darCostoCampanha()
                + candidato4.darCostoCampanha() + candidato5.darCostoCampanha();
        double promedio = total / 5;

        return promedio;
    }

    // Retorna el porcentaje de votos obtenidos por el candidato con el nombre dado
    // por parámetro.
    // @param pNumero N�mero del candidato a buscar. pNumero > 0 && pNumero < 4.
    public double calcularPorcentajeVotosCandidato(int pNumero) {
        double numVotosCandidato = buscarCandidato(pNumero).darCantidadTotalVotos();
        double votosTotales = calcularTotalVotos();
        double porcentaje = numVotosCandidato / votosTotales * 100;
        return porcentaje;
    }

    // Registra un voto al candidato con el nombre dado por parámetro.
    // Los votos del candidato aumentaron en uno en el rango y g�nero dado. <br>
    // Aumentó el costo de campaña del candidato.
    // @param pNumero Número del candidato a buscar. pNumero > 0 && pNumero < 4.
    // @param pEdad Rango de edad de la persona que registró el voto. pEdad ==
    // EDAD_JOVEN || pEdad == EDAD_MEDIA || pEdad == EDAD_MAYOR.
    // @param pGenero Género de la persona que registró el voto. pGenero ==
    // MASCULINO || pGenero == FEMENINO.
    // @param pMedio Medio de influencia que influenció el voto. pMedio == INTERNET
    // || pMedio == RADIO || pMedio == TELEVISION.
    public void registrarVoto(int pNumero, Edad pEdad, Genero pGenero, Medio pMedio) {
        Candidato buscado = buscarCandidato(pNumero);
        if (buscado != null) {
            buscado.registrarVoto(pEdad, pGenero, pMedio);
        }
    }

    // Reinicia los 5 candidatos.
    public void reiniciar() {
        candidato1.reiniciar();
        candidato2.reiniciar();
        candidato3.reiniciar();
        candidato4.reiniciar();
        candidato5.reiniciar();
    }

    // Puntos de Extensión
    // Método para la extensión 1.
    public String metodo1() {
        return "Respuesta 1";
    }

    // Método para la extensión 2.
    public String metodo2() {
        return "Respuesta 2";
    }
}