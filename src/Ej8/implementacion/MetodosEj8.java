package Ej8.implementacion;

import imple.Cola;
import tda.ColaTDA;

public class MetodosEj8 {

    public ColaTDA sinRepetidos(ColaTDA c) { // P

        ColaTDA cola = new Cola(); // C
        cola.inicializarCola(); // C

        ColaTDA colaAux = new Cola(); // C
        colaAux.inicializarCola(); // C

        while (!c.colaVacia()) { // P (loop interno adentro)

            int valor = c.primero(); // C
            c.desacolar(); // C
            colaAux.acolar(valor); // C

            boolean encontrado = false; // C

            ColaTDA colaAux2 = new Cola(); // C
            colaAux2.inicializarCola(); // C

            while (!cola.colaVacia()) { // L
                int valor2 = cola.primero(); // C
                cola.desacolar(); // C

                if (valor == valor2) { // C
                    encontrado = true; // C
                }

                colaAux2.acolar(valor2); // C
            }

            while (!colaAux2.colaVacia()) { // L
                cola.acolar(colaAux2.primero()); // C
                colaAux2.desacolar(); // C
            }

            if (!encontrado) { // C
                cola.acolar(valor); // C
            }
        }

        while (!colaAux.colaVacia()) { // L
            c.acolar(colaAux.primero()); // C
            colaAux.desacolar(); // C
        }

        return cola; // C
    }
}