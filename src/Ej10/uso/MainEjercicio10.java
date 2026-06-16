package Ej10.uso;

import tda.PilaTDA;
import tda.DiccionarioSimpleTDA;
import tda.ConjuntoTDA;
import imple.Pila;
import Ej10.implementacion.MetodosEj10;

public class MainEjercicio10 {

    public static void main(String[] args) {
        PilaTDA miPila = new Pila();
        miPila.inicializarPila();

        // Pila con repetidos
        miPila.apilar(5);
        miPila.apilar(2);
        miPila.apilar(5);
        miPila.apilar(8);
        miPila.apilar(2);
        miPila.apilar(5);

        MetodosEj10 metodos = new MetodosEj10();
        DiccionarioSimpleTDA frecuencias = metodos.frecuenciasPila(miPila);

        System.out.println("Frecuencias calculadas:");
        ConjuntoTDA claves = frecuencias.claves();
        while (!claves.conjuntoVacio()) {
            int elemento = claves.elegir();
            int cantidad = frecuencias.recuperar(elemento);
            System.out.println("Elemento " + elemento + " -> " + cantidad + " veces");
            claves.sacar(elemento);
        }

        // Verifico que la pila original no se haya roto
        int contador = 0;
        while (!miPila.pilaVacia()) {
            contador++;
            miPila.desapilar();
        }
        System.out.println("La pila original conservo sus " + contador + " elementos.");
    }
}