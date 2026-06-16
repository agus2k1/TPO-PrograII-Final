package Ej6.implementacion;

import imple.Pila;
import tda.PilaTDA;

public class MetodosEj6 {

    public float pares(PilaTDA pila) {

        PilaTDA aux = new Pila();
        aux.inicializarPila();

        int contadorPares = 0;
        int contadorTotal = 0;

        while(!pila.pilaVacia()) {
            int num = pila.tope();
            if (num % 2 == 0) {
                contadorPares++;
            }
            contadorTotal++;
            aux.apilar(num);
            pila.desapilar();
        }

        while(!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        return (contadorPares / contadorTotal) * 100;
    }
}
