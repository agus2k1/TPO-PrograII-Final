package tests.Ej4;

import Ej4.implementacion.DiccionarioSimpleMod;
import Ej4.interfaz.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;

public class TestEj4 {

    static void check(String desc, boolean cond) {
        System.out.println((cond ? "[PASS]" : "[FAIL]") + " " + desc);
    }

    static DiccionarioSimpleModTDA nuevoDiccionario() {
        DiccionarioSimpleMod d = new DiccionarioSimpleMod();
        d.inicializarDiccionario();
        return d;
    }

    public static void main(String[] args) {
        System.out.println("=== DiccionarioSimpleMod ===\n");

        DiccionarioSimpleModTDA d;
        ConjuntoTDA claves;

        // agregar y recuperar
        d = nuevoDiccionario();
        d.agregar(1, 100);
        check("agregar: clave aparece en claves()", d.claves().pertenece(1));
        check("agregar: recuperar devuelve el valor correcto", d.recuperar(1) == 100);
        check("agregar: factorMod inicial es 0", d.recuperarMod(1) == 0);

        // agregar misma clave dos veces: incrementa factorMod, NO cambia valor
        d = nuevoDiccionario();
        d.agregar(1, 100);
        d.agregar(1, 200);
        check("agregar clave existente: factorMod se incrementa a 1", d.recuperarMod(1) == 1);
        check("agregar clave existente: valor original se preserva (100)", d.recuperar(1) == 100);

        // agregar misma clave tres veces
        d = nuevoDiccionario();
        d.agregar(1, 100);
        d.agregar(1, 200);
        d.agregar(1, 300);
        check("agregar misma clave 3 veces: factorMod=2", d.recuperarMod(1) == 2);

        // varias claves independientes
        d = nuevoDiccionario();
        d.agregar(1, 10);
        d.agregar(2, 20);
        d.agregar(3, 30);
        check("múltiples claves: recuperar(1)=10", d.recuperar(1) == 10);
        check("múltiples claves: recuperar(2)=20", d.recuperar(2) == 20);
        check("múltiples claves: recuperar(3)=30", d.recuperar(3) == 30);

        // eliminar clave intermedia (no la primera)
        d = nuevoDiccionario();
        d.agregar(1, 10);
        d.agregar(2, 20);
        d.agregar(3, 30);
        d.eliminar(2);
        check("eliminar clave intermedia: clave 2 ya no está", !d.claves().pertenece(2));
        check("eliminar clave intermedia: clave 1 sigue", d.claves().pertenece(1));
        check("eliminar clave intermedia: clave 3 sigue", d.claves().pertenece(3));

        // eliminar la primera clave insertada (la que está al inicio de la lista interna)
        d = nuevoDiccionario();
        d.agregar(1, 10);
        d.agregar(2, 20);
        d.eliminar(2); // 2 fue agregado último, está al inicio de la lista interna
        check("eliminar primer nodo: clave 1 sigue disponible", d.claves().pertenece(1));
        check("eliminar primer nodo: clave 2 eliminada", !d.claves().pertenece(2));

        System.out.println("\n=== Fin de tests ===");
    }
}
