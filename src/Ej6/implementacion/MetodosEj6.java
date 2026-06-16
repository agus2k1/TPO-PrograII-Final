package Ej6.implementacion;

import imple.Pila;
import tda.PilaTDA;

public class MetodosEj6 {

    public float pares(PilaTDA pila) { // L

        PilaTDA aux = new Pila(); // C
        aux.inicializarPila(); // C

        float contadorPares = 0; // C
        float contadorTotal = 0; // C

        while(!pila.pilaVacia()) { // L
            int num = pila.tope(); // C
            if (num % 2 == 0) { // C
                contadorPares++; // C
            }
            contadorTotal++; // C
            aux.apilar(num); // C
            pila.desapilar(); // C
        }

        while(!aux.pilaVacia()) { // L
            pila.apilar(aux.tope()); // C
            aux.desapilar(); // C
        }

        return (contadorPares / contadorTotal) * 100; // C
    }
}
