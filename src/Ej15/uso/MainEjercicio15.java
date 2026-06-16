package Ej15.uso;

import tda.GrafoTDA;
import imple.Grafo;
import Ej15.implementacion.MetodosEj15;

public class MainEjercicio15 {

    public static void main(String[] args) {
        GrafoTDA miGrafo = new Grafo();
        miGrafo.inicializarGrafo();

        miGrafo.agregarVertice(1);
        miGrafo.agregarVertice(2);
        miGrafo.agregarVertice(3);

        // Aristas que salen del 1
        miGrafo.agregarArista(1, 2, 10);
        miGrafo.agregarArista(1, 3, 20);

        // Arista que llega al 1
        miGrafo.agregarArista(2, 1, 30);

        MetodosEj15 metodos = new MetodosEj15();
        int grado = metodos.calcularGrado(miGrafo, 1);

        // Salen 2, entra 1 -> grado = 1
        System.out.println("El grado del vertice 1 es: " + grado);
    }
}