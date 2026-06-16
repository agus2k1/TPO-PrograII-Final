package tests.Ej15;

import Ej15.implementacion.MetodosEj15;
import imple.Grafo;
import tda.GrafoTDA;

public class TestEj15 {

    static void check(String desc, boolean cond) {
        System.out.println((cond ? "[PASS]" : "[FAIL]") + " " + desc);
    }

    static GrafoTDA grafoVacio() {
        GrafoTDA g = new Grafo();
        g.inicializarGrafo();
        return g;
    }

    public static void main(String[] args) {
        System.out.println("=== calcularGrado ===\n");

        MetodosEj15 m = new MetodosEj15();
        GrafoTDA g;

        // vértice con más salientes que entrantes
        g = grafoVacio();
        g.agregarVertice(1); g.agregarVertice(2); g.agregarVertice(3);
        g.agregarArista(1, 2, 1);
        g.agregarArista(1, 3, 1);
        g.agregarArista(2, 1, 1);
        // vértice 1: 2 salen, 1 entra → grado = 1
        check("2 salientes, 1 entrante: grado=1", m.calcularGrado(g, 1) == 1);

        // vértice con más entrantes que salientes
        g = grafoVacio();
        g.agregarVertice(1); g.agregarVertice(2); g.agregarVertice(3);
        g.agregarArista(2, 1, 1);
        g.agregarArista(3, 1, 1);
        g.agregarArista(1, 2, 1);
        // vértice 1: 1 sale, 2 entran → grado = -1
        check("1 saliente, 2 entrantes: grado=-1", m.calcularGrado(g, 1) == -1);

        // vértice aislado (sin aristas)
        g = grafoVacio();
        g.agregarVertice(1); g.agregarVertice(2);
        check("vértice aislado: grado=0", m.calcularGrado(g, 1) == 0);

        // igual cantidad de entrantes y salientes
        g = grafoVacio();
        g.agregarVertice(1); g.agregarVertice(2); g.agregarVertice(3);
        g.agregarArista(1, 2, 1);
        g.agregarArista(3, 1, 1);
        // vértice 1: 1 sale, 1 entra → grado = 0
        check("1 saliente, 1 entrante: grado=0", m.calcularGrado(g, 1) == 0);

        // arista de un vértice hacia sí mismo no cuenta como saliente ni entrante del mismo
        g = grafoVacio();
        g.agregarVertice(1);
        g.agregarArista(1, 1, 1);
        // existeArista(1,1) cuenta como saliente Y como entrante → se cancelan
        check("arista self-loop: grado=0", m.calcularGrado(g, 1) == 0);

        System.out.println("\n=== Fin de tests ===");
    }
}
