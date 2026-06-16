package tests.Ej1;

import Ej1.implementacion.ConjuntoEspecial;
import Ej1.interfaz.ConjuntoEspecialTDA;
import Ej1.interfaz.ConjuntoEspecialTDA.Respuesta;

public class TestEj1 {

    static void check(String desc, boolean cond) {
        System.out.println((cond ? "[PASS]" : "[FAIL]") + " " + desc);
    }

    static ConjuntoEspecialTDA nuevoConjunto() {
        ConjuntoEspecial c = new ConjuntoEspecial();
        c.inicializarConjunto();
        return c;
    }

    public static void main(String[] args) {
        System.out.println("=== ConjuntoEspecial ===\n");

        ConjuntoEspecialTDA c;
        Respuesta r;

        // conjuntoVacio
        c = nuevoConjunto();
        check("conjunto recién inicializado está vacío", c.conjuntoVacio());

        // agregar
        c = nuevoConjunto();
        r = c.agregar(10);
        check("agregar nuevo: error=false", !r.error);
        check("agregar nuevo: rta=10", r.rta == 10);
        check("después de agregar, no está vacío", !c.conjuntoVacio());

        // agregar duplicado
        c = nuevoConjunto();
        c.agregar(10);
        r = c.agregar(10);
        check("agregar duplicado: error=true", r.error);

        // pertenece
        c = nuevoConjunto();
        c.agregar(5);
        check("pertenece a valor agregado", c.pertenece(5));
        check("no pertenece a valor no agregado", !c.pertenece(99));

        // elegir
        c = nuevoConjunto();
        c.agregar(7);
        r = c.elegir();
        check("elegir conjunto no vacío: error=false", !r.error);
        check("elegir conjunto no vacío: rta=7", r.rta == 7);

        // elegir vacío
        c = nuevoConjunto();
        r = c.elegir();
        check("elegir conjunto vacío: error=true", r.error);

        // sacar existente
        c = nuevoConjunto();
        c.agregar(3);
        r = c.sacar(3);
        check("sacar existente: error=false", !r.error);
        check("sacar existente: elemento ya no pertenece", !c.pertenece(3));

        // sacar inexistente
        c = nuevoConjunto();
        c.agregar(3);
        r = c.sacar(99);
        check("sacar inexistente: error=true", r.error);

        // sacar no afecta otros elementos
        c = nuevoConjunto();
        c.agregar(1); c.agregar(2); c.agregar(3);
        c.sacar(2);
        check("sacar del medio: 1 sigue perteneciendo", c.pertenece(1));
        check("sacar del medio: 3 sigue perteneciendo", c.pertenece(3));
        check("sacar del medio: 2 ya no pertenece", !c.pertenece(2));

        // sacar en conjunto vacío: debería devolver error=true
        c = nuevoConjunto();
        r = c.sacar(5);
        check("sacar en conjunto vacío: error=true", r.error);

        System.out.println("\n=== Fin de tests ===");
    }
}
