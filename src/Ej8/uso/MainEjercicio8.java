package Ej8.uso;

import imple.Cola;
import tda.ColaTDA;
import Ej8.implementacion.MetodosEj8;

public class MainEjercicio8 {

    public static void main(String[] args) {
        ColaTDA cola = new Cola();
        cola.inicializarCola();

        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(1);
        cola.acolar(3);
        cola.acolar(2);
        cola.acolar(4);

        MetodosEj8 metodos = new MetodosEj8();
        ColaTDA resultado = metodos.sinRepetidos(cola);

        System.out.println("Cola sin repetidos:");
        while (!resultado.colaVacia()) {
            System.out.print(resultado.primero() + " ");
            resultado.desacolar();
        }
        System.out.println();
    }
}