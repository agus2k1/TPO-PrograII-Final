package Ej8.implementacion;

import imple.Cola;
import tda.ColaTDA;

public class MetodosEj8 {

    public ColaTDA sinRepetidos(ColaTDA c) {

        ColaTDA cola = new Cola();
        cola.inicializarCola();

        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();

        while (!c.colaVacia()) {

            int valor = c.primero();
            c.desacolar();
            colaAux.acolar(valor);

            boolean encontrado = false;

            ColaTDA colaAux2 = new Cola();
            colaAux2.inicializarCola();

            while (!cola.colaVacia()) {
                int valor2 = cola.primero();
                cola.desacolar();

                if (valor == valor2) {
                    encontrado = true;
                }

                colaAux2.acolar(valor2);
            }

            while (!colaAux2.colaVacia()) {
                cola.acolar(colaAux2.primero());
                colaAux2.desacolar();
            }

            if (!encontrado) {
                cola.acolar(valor);
            }
        }

        while (!colaAux.colaVacia()) {
            c.acolar(colaAux.primero());
            colaAux.desacolar();
        }

        return cola;
    }
}