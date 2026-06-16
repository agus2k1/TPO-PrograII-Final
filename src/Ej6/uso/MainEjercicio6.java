package Ej6.uso;

import Ej6.implementacion.MetodosEj6;
import imple.Pila;
import tda.PilaTDA;

public class MainEjercicio6 {

    public static void main(String[] args) {
        MetodosEj6 m = new MetodosEj6();

        PilaTDA pila = new Pila();
        pila.inicializarPila();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(4);

        System.out.println("Porcentaje de pares: " + m.pares(pila) + "%");
    }
}
