package ejercicios_sueltos.ejercicio3.Uso;

import ejercicio3.Implementacion.Multipila;
import imple.Pila;
import tda.PilaTDA;

public class Main {
    public static void main(String[] args) {

        // 🔹 Crear multipila
        Multipila multi = new Multipila();
        multi.inicializarPila();

        // 🔹 Crear pila 1 → (tope) 7 - 2 - 8 - 9
        PilaTDA p1 = new Pila();
        p1.inicializarPila();

        p1.apilar(9);
        p1.apilar(8);
        p1.apilar(2);
        p1.apilar(7);

        multi.apilar(p1);

        System.out.println("Multipila inicial:");
        imprimirMultipila(multi);

        // 🔹 Crear pila a desapilar → (tope) 7 - 2
        PilaTDA p2 = new Pila();
        p2.inicializarPila();

        p2.apilar(2);
        p2.apilar(7);

        multi.desapilar(p2);

        System.out.println("\nDespués de desapilar (7 - 2):");
        imprimirMultipila(multi);

        // 🔹 Probar tope(2)
        PilaTDA resultado = multi.tope(2);

        System.out.println("\nResultado de tope(2):");
        imprimirPila(resultado);
    }

    // 🔹 Método para imprimir multipila (SIN romperla)
    public static void imprimirMultipila(Multipila multi) {

        PilaTDA aux = multi.tope(100); // trae todos

        while (!aux.pilaVacia()) {
            System.out.print(aux.tope() + " ");
            aux.desapilar();
        }
        System.out.println();
    }

    // 🔹 Método para imprimir pila
    public static void imprimirPila(PilaTDA p) {

        PilaTDA aux = new Pila();
        aux.inicializarPila();

        while (!p.pilaVacia()) {
            System.out.print(p.tope() + " ");
            aux.apilar(p.tope());
            p.desapilar();
        }

        // reconstruir
        while (!aux.pilaVacia()) {
            p.apilar(aux.tope());
            aux.desapilar();
        }

        System.out.println();
    }
}