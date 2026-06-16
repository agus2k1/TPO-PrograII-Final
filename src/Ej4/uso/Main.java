package Ej4.uso;

import Ej4.implementacion.DiccionarioSimpleMod;
import Ej4.interfaz.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;

public class Main {
    static void check(String descripcion, Object esperado, Object obtenido) {
        boolean ok = esperado.equals(obtenido);
        System.out.println((ok ? "[PASS]" : "[FAIL]") + " " + descripcion
                + (ok ? "" : " | esperado=" + esperado + " obtenido=" + obtenido));
    }

    static boolean clavesPertencen(ConjuntoTDA c, int... claves) {
        for (int k : claves) {
            if (!c.pertenece(k)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        DiccionarioSimpleModTDA dic = new DiccionarioSimpleMod();
        dic.inicializarDiccionario();
        System.out.println("=== DiccionarioSimpleMod inicializado ===\n");

        // agregar clave nueva → factorMod = 0
        dic.agregar(1, 100);
        check("recuperar(1) luego de agregar", 100, dic.recuperar(1));
        check("recuperarMod(1) primera vez → 0", 0, dic.recuperarMod(1));

        dic.agregar(2, 200);
        check("recuperar(2)", 200, dic.recuperar(2));
        check("recuperarMod(2) primera vez → 0", 0, dic.recuperarMod(2));

        // agregar clave existente → incrementa factorMod
        dic.agregar(1, 150);
        check("recuperarMod(1) luego de modificar → 1", 1, dic.recuperarMod(1));

        dic.agregar(1, 175);
        check("recuperarMod(1) luego de segunda modificación → 2", 2, dic.recuperarMod(1));

        // claves contiene las esperadas
        ConjuntoTDA claves = dic.claves();
        check("claves contiene 1 y 2", true, clavesPertencen(claves, 1, 2));

        // agregar tercera clave
        dic.agregar(3, 300);
        check("recuperar(3)", 300, dic.recuperar(3));
        check("recuperarMod(3) primera vez → 0", 0, dic.recuperarMod(3));
        check("claves contiene 1, 2 y 3", true, clavesPertencen(dic.claves(), 1, 2, 3));

        // eliminar clave del medio
        dic.eliminar(2);
        check("claves no contiene 2 post-eliminar", false, dic.claves().pertenece(2));
        check("claves contiene 1 y 3 post-eliminar", true, clavesPertencen(dic.claves(), 1, 3));

        // eliminar primer nodo
        dic.eliminar(3);
        check("claves no contiene 3 post-eliminar", false, dic.claves().pertenece(3));
        check("clave 1 sigue luego de eliminar el primer nodo", true, dic.claves().pertenece(1));

        // eliminar último nodo
        dic.eliminar(1);
        check("claves vacías luego de eliminar todo", false, dic.claves().pertenece(1));

        System.out.println("\n=== Fin de tests ===");
    }
}