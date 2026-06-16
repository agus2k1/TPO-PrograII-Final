package Ej14.implementacion;

import imple.Conjunto;
import tda.ConjuntoTDA;
import tda.GrafoTDA;

public class GrafoImpl {

    public ConjuntoTDA verticesPuente(GrafoTDA grafo, int v1, int v2) { // P
        ConjuntoTDA conjuntoResultado = new Conjunto(); // C
        conjuntoResultado.inicializarConjunto(); // C

        ConjuntoTDA verticesTotal = grafo.vertices(); // L
        verticesTotal.sacar(v1); // L
        verticesTotal.sacar(v2); // L

        ConjuntoTDA verticesPuente = new Conjunto(); // C
        verticesPuente.inicializarConjunto(); // C

        while (!verticesTotal.conjuntoVacio()) { // P (existeArista y sacar adentro son L)
            int verticeElegido = verticesTotal.elegir(); // C

            if (grafo.existeArista(v1, verticeElegido)) { // L
                verticesPuente.agregar(verticeElegido); // C
            }

            verticesTotal.sacar(verticeElegido); // L
        }

        while (!verticesPuente.conjuntoVacio()) { // P (existeArista y sacar adentro son L)
            int verticeElegido = verticesPuente.elegir(); // C

            if (grafo.existeArista(verticeElegido, v2)) { // L
                conjuntoResultado.agregar(verticeElegido); // C
            }

            verticesPuente.sacar(verticeElegido); // L
        }

        return conjuntoResultado; // C
    }
}
