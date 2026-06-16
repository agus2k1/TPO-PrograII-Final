package Ej14.implementacion;

import imple.Conjunto;
import tda.ConjuntoTDA;
import tda.GrafoTDA;

public class GrafoImpl {

    public ConjuntoTDA verticesPuente(GrafoTDA grafo, int v1, int v2) {
        ConjuntoTDA conjuntoResultado = new Conjunto();
        conjuntoResultado.inicializarConjunto();

        ConjuntoTDA verticesTotal = grafo.vertices();
        verticesTotal.sacar(v1);
        verticesTotal.sacar(v2);

        ConjuntoTDA verticesPuente = new Conjunto();
        verticesPuente.inicializarConjunto();

        while (!verticesTotal.conjuntoVacio()) {
            int verticeElegido = verticesTotal.elegir();

            if (grafo.existeArista(v1, verticeElegido)) {
                verticesPuente.agregar(verticeElegido);
            }

            verticesTotal.sacar(verticeElegido);
        }

        while (!verticesPuente.conjuntoVacio()) {
            int verticeElegido = verticesPuente.elegir();

            if (grafo.existeArista(verticeElegido, v2)) {
                conjuntoResultado.agregar(verticeElegido);
            }

            verticesPuente.sacar(verticeElegido);
        }

        return conjuntoResultado;
    }
}
