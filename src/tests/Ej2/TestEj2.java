package tests.Ej2;

import Ej2.implementacion.ConjuntoMamushka;
import Ej2.interfaz.ConjuntoMamushkaTDA;

public class TestEj2 {

    static void check(String desc, boolean cond) {
        System.out.println((cond ? "[PASS]" : "[FAIL]") + " " + desc);
    }

    static ConjuntoMamushkaTDA nuevoConjunto() {
        ConjuntoMamushka c = new ConjuntoMamushka();
        c.inicializar();
        return c;
    }

    public static void main(String[] args) {
        System.out.println("=== ConjuntoMamushka ===\n");

        ConjuntoMamushkaTDA c;

        // estaVacio
        c = nuevoConjunto();
        check("recién inicializado está vacío", c.estaVacio());

        // guardar elemento nuevo
        c = nuevoConjunto();
        c.guardar(10);
        check("guardar nuevo: no está vacío", !c.estaVacio());
        check("guardar nuevo: perteneceCant=1", c.perteneceCant(10) == 1);

        // guardar mismo elemento dos veces
        c = nuevoConjunto();
        c.guardar(5);
        c.guardar(5);
        check("guardar mismo elemento 2 veces: perteneceCant=2", c.perteneceCant(5) == 2);

        // guardar mismo elemento tres veces
        c = nuevoConjunto();
        c.guardar(3);
        c.guardar(3);
        c.guardar(3);
        check("guardar mismo elemento 3 veces: perteneceCant=3", c.perteneceCant(3) == 3);

        // perteneceCant elemento inexistente
        c = nuevoConjunto();
        c.guardar(1);
        check("perteneceCant de elemento no guardado: 0", c.perteneceCant(99) == 0);

        // sacar cuando cant > 1: decrementa cantidad
        c = nuevoConjunto();
        c.guardar(7); c.guardar(7);
        c.sacar(7);
        check("sacar con cant>1: perteneceCant decrements a 1", c.perteneceCant(7) == 1);
        check("sacar con cant>1: sigue sin estar vacío", !c.estaVacio());

        // sacar cuando cant == 1: se elimina el nodo
        c = nuevoConjunto();
        c.guardar(8);
        c.sacar(8);
        check("sacar con cant=1: perteneceCant=0", c.perteneceCant(8) == 0);
        check("sacar único elemento: estaVacio=true", c.estaVacio());

        // sacar no afecta otros elementos
        c = nuevoConjunto();
        c.guardar(1); c.guardar(2); c.guardar(3);
        c.sacar(2);
        check("sacar del medio: 1 sigue con cant=1", c.perteneceCant(1) == 1);
        check("sacar del medio: 3 sigue con cant=1", c.perteneceCant(3) == 1);
        check("sacar del medio: 2 tiene cant=0", c.perteneceCant(2) == 0);

        // elegir
        c = nuevoConjunto();
        c.guardar(42);
        check("elegir devuelve un elemento del conjunto", c.perteneceCant(c.elegir()) > 0);

        System.out.println("\n=== Fin de tests ===");
    }
}
