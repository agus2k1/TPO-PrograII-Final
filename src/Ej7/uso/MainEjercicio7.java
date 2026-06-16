package Ej7.uso;

import imple.Pila;
import tda.ConjuntoTDA;
import tda.PilaTDA;
import Ej7.implementacion.MetodosEj7;

public class MainEjercicio7 {

    public static void main(String[] args) {
        PilaTDA pila = new Pila();
        pila.inicializarPila();

        pila.apilar(3);
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(1);
        pila.apilar(3);
        pila.apilar(5);

        MetodosEj7 metodos = new MetodosEj7();
        ConjuntoTDA repetidos = metodos.elementosRepetidos(pila);

        System.out.println("Elementos repetidos:");
        while (!repetidos.conjuntoVacio()) {
            int e = repetidos.elegir();
            System.out.println("- " + e);
            repetidos.sacar(e);
        }
    }
}