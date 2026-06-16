package ejercicios_sueltos.ejercicio3.Implementacion;

import ejercicio3.Interfaz.MultipilaTDA;
import imple.Pila;
import tda.PilaTDA;

public class Multipila implements MultipilaTDA {
    private class Nodo{
        int info;
        Nodo sig;
    }

    private Nodo tope;

    @Override
    public void inicializarPila() { // C
        tope = null; // C
    }

    @Override
    public void apilar(PilaTDA valores) { // L
        PilaTDA aux = new Pila(); // C
        aux.inicializarPila(); // C

        while (!valores.pilaVacia()){ // L
            aux.apilar(valores.tope()); // C
            valores.desapilar(); // C
        }

        while (!aux.pilaVacia()){ // L
            Nodo nuevo = new Nodo(); // C
            nuevo.info = aux.tope(); // C
            nuevo.sig = tope; // C
            tope = nuevo; // C
            aux.desapilar(); // C
        }

    }

    @Override
    public void desapilar(PilaTDA valores) { // L
        PilaTDA auxValores = new Pila(); // C
        auxValores.inicializarPila(); // C

        Nodo auxMulti = tope; // C

        boolean coincide = true; //C

        while(!valores.pilaVacia() && coincide){ // L
            if (auxMulti == null){ // C
                coincide = false; // C
            } else if (auxMulti.info == valores.tope()){ // C
                auxValores.apilar(valores.tope()); // C
                valores.desapilar(); // C
                auxMulti = auxMulti.sig; // C
            } else { // C
                coincide = false; // C
            }
        }

        if (!valores.pilaVacia()) { // C
            coincide = false; // C
        }

        if (coincide){ // C
            while (!auxValores.pilaVacia()){ // L
                tope = tope.sig; // C
                auxValores.desapilar(); // C
            }
        } else { // C
            while (!auxValores.pilaVacia()){ // L
                valores.apilar(auxValores.tope()); // C
                auxValores.desapilar(); // C
            }
        }

    }

    @Override
    public PilaTDA tope(int cantidad) { // L
        PilaTDA resultado = new Pila(); // C
        resultado.inicializarPila(); // C

        PilaTDA aux = new Pila(); //C
        aux.inicializarPila(); // C

        Nodo n = tope; //C

        int contador = 0; //C

        while (n != null && contador < cantidad){ // L
            aux.apilar(n.info); // C
            n = n.sig; // C
            contador++; // C
        }

        while (!aux.pilaVacia()){ // L
            resultado.apilar(aux.tope()); //C
            aux.desapilar(); // C
        }
        return resultado; // C
    }

    @Override
    public boolean pilaVacia() { // C
        return tope == null; // C
    }
}

