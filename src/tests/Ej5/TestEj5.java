package tests.Ej5;

import Ej5.implementacion.DiccionarioSimpleCPImpl;
import tda.DiccionarioSimpleTDA;
import tda.ConjuntoTDA;

public class TestEj5 {

    static void check(String desc, boolean cond) {
        System.out.println((cond ? "[PASS]" : "[FAIL]") + " " + desc);
    }

    static DiccionarioSimpleTDA nuevoDiccionario() {
        DiccionarioSimpleCPImpl d = new DiccionarioSimpleCPImpl();
        d.inicializarDiccionario();
        return d;
    }

    public static void main(String[] args) {
        System.out.println("=== DiccionarioSimpleCPImpl ===\n");

        DiccionarioSimpleTDA d;
        ConjuntoTDA claves;

        // agregar y recuperar
        d = nuevoDiccionario();
        d.agregar(1, 100);
        check("agregar: clave 1 aparece en claves()", d.claves().pertenece(1));
        check("agregar: recuperar(1)=100", d.recuperar(1) == 100);

        // agregar actualiza si la clave ya existe
        d = nuevoDiccionario();
        d.agregar(1, 100);
        d.agregar(1, 999);
        check("agregar clave existente: valor actualizado a 999", d.recuperar(1) == 999);
        claves = d.claves();
        int count = 0;
        while (!claves.conjuntoVacio()) { count++; int k = claves.elegir(); claves.sacar(k); }
        check("agregar clave existente: sigue habiendo 1 clave (sin duplicados)", count == 1);

        // eliminar
        d = nuevoDiccionario();
        d.agregar(1, 10); d.agregar(2, 20); d.agregar(3, 30);
        d.eliminar(2);
        check("eliminar: clave 2 ya no está", !d.claves().pertenece(2));
        check("eliminar: clave 1 sigue", d.claves().pertenece(1));
        check("eliminar: clave 3 sigue", d.claves().pertenece(3));

        // claves devuelve todas
        d = nuevoDiccionario();
        d.agregar(10, 1); d.agregar(20, 2); d.agregar(30, 3);
        claves = d.claves();
        check("claves(): contiene 10", claves.pertenece(10));
        check("claves(): contiene 20", claves.pertenece(20));
        check("claves(): contiene 30", claves.pertenece(30));

        // recuperar después de eliminar y re-agregar
        d = nuevoDiccionario();
        d.agregar(5, 50);
        d.eliminar(5);
        d.agregar(5, 99);
        check("re-agregar clave eliminada: recuperar(5)=99", d.recuperar(5) == 99);

        System.out.println("\n=== Fin de tests ===");
    }
}
