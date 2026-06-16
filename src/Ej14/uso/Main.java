package Ej14.uso;

import Ej14.implementacion.GrafoImpl;
import imple.Grafo;
import tda.ConjuntoTDA;
import tda.GrafoTDA;

public class Main {
    static void check(String descripcion, boolean condicion) {
        System.out.println((condicion ? "[PASS]" : "[FAIL]") + " " + descripcion);
    }

    static GrafoTDA grafoVacio() {
        GrafoTDA g = new Grafo();
        g.inicializarGrafo();
        return g;
    }

    public static void main(String[] args) {
        System.out.println("=== verticesPuente ===\n");

        GrafoImpl impl = new GrafoImpl();
        GrafoTDA g;
        ConjuntoTDA resultado;

        // un único puente: o→p→d
        g = grafoVacio();
        g.agregarVertice(1); g.agregarVertice(2); g.agregarVertice(3);
        g.agregarArista(1, 2, 1);
        g.agregarArista(2, 3, 1);
        resultado = impl.verticesPuente(g, 1, 3);
        check("un puente → pertenece(2)", resultado.pertenece(2));
        check("un puente → no pertenece(1)", !resultado.pertenece(1));
        check("un puente → no pertenece(3)", !resultado.pertenece(3));

        // ningún puente: arista o→p existe pero no p→d
        g = grafoVacio();
        g.agregarVertice(1); g.agregarVertice(2); g.agregarVertice(3);
        g.agregarArista(1, 2, 1);
        resultado = impl.verticesPuente(g, 1, 3);
        check("sin arista p→d → conjunto vacío", resultado.conjuntoVacio());

        // ningún puente: arista p→d existe pero no o→p
        g = grafoVacio();
        g.agregarVertice(1); g.agregarVertice(2); g.agregarVertice(3);
        g.agregarArista(2, 3, 1);
        resultado = impl.verticesPuente(g, 1, 3);
        check("sin arista o→p → conjunto vacío", resultado.conjuntoVacio());

        // múltiples puentes: dos vértices cumplen la condición
        g = grafoVacio();
        g.agregarVertice(1); g.agregarVertice(2); g.agregarVertice(3); g.agregarVertice(4);
        g.agregarArista(1, 2, 1);
        g.agregarArista(1, 3, 1);
        g.agregarArista(2, 4, 1);
        g.agregarArista(3, 4, 1);
        resultado = impl.verticesPuente(g, 1, 4);
        check("dos puentes → pertenece(2)", resultado.pertenece(2));
        check("dos puentes → pertenece(3)", resultado.pertenece(3));

        // v1 y v2 no son puentes entre sí aunque tengan arista directa
        g = grafoVacio();
        g.agregarVertice(1); g.agregarVertice(2); g.agregarVertice(3);
        g.agregarArista(1, 2, 1);
        g.agregarArista(2, 1, 1);
        g.agregarArista(1, 3, 1);
        g.agregarArista(3, 2, 1);
        resultado = impl.verticesPuente(g, 1, 2);
        check("v1 y v2 no son puentes → no pertenece(1)", !resultado.pertenece(1));
        check("v1 y v2 no son puentes → no pertenece(2)", !resultado.pertenece(2));
        check("v1 y v2 no son puentes → pertenece(3)", resultado.pertenece(3));

        System.out.println("\n=== Fin de tests ===");
    }
}