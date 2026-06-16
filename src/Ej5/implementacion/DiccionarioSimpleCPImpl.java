package Ej5.implementacion;

import tda.DiccionarioSimpleTDA;
import tda.ColaPrioridadTDA;
import tda.ConjuntoTDA;
import imple.ColaPrioridad;
import imple.Conjunto;

public class DiccionarioSimpleCPImpl implements DiccionarioSimpleTDA {
    private ColaPrioridadTDA cp; // C

    public void inicializarDiccionario() { // C
        cp = new ColaPrioridad(); // C
        cp.inicializarCola(); // C
    } // C

    public void agregar(int clave, int valor) { // P
        // Elimino primero la clave por si ya existía para no tener repetidos
        this.eliminar(clave); // L
        // Uso la clave como elemento y el valor como prioridad de la cola
        cp.acolarPrioridad(clave, valor); // C
    } // P

    public void eliminar(int clave) { // L
        ColaPrioridadTDA aux = new ColaPrioridad(); // C
        aux.inicializarCola(); // C

        // Desacolo todo para buscar la clave a borrar
        while (!cp.colaVacia()) { // L
            int c = cp.primero(); // C
            int p = cp.prioridad(); // C
            cp.desacolar(); // C

            // Guardo en la auxiliar todo menos la clave que quiero eliminar
            if (c != clave) { // C
                aux.acolarPrioridad(c, p); // C
            } // C
        } // L

        // Paso todo de vuelta a la cola original
        while (!aux.colaVacia()) { // L
            cp.acolarPrioridad(aux.primero(), aux.prioridad()); // C
            aux.desacolar(); // C
        } // L
    } // L

    public int recuperar(int clave) { // L
        ColaPrioridadTDA aux = new ColaPrioridad(); // C
        aux.inicializarCola(); // C
        int res = 0; // C

        while (!cp.colaVacia()) { // L
            int c = cp.primero(); // C
            int p = cp.prioridad(); // C

            // Si la encuentro, guardo su valor (que es la prioridad)
            if (c == clave) { // C
                res = p; // C
            } // C

            cp.desacolar(); // C
            aux.acolarPrioridad(c, p); // C
        } // L

        while (!aux.colaVacia()) { // L
            cp.acolarPrioridad(aux.primero(), aux.prioridad()); // C
            aux.desacolar(); // C
        } // L

        return res; // C
    } // L

    public ConjuntoTDA claves() { // L
        ConjuntoTDA conj = new Conjunto(); // C
        conj.inicializarConjunto(); // C
        ColaPrioridadTDA aux = new ColaPrioridad(); // C
        aux.inicializarCola(); // C

        while (!cp.colaVacia()) { // L
            int c = cp.primero(); // C
            int p = cp.prioridad(); // C

            conj.agregar(c); // C
            aux.acolarPrioridad(c, p); // C
            cp.desacolar(); // C
        } // L

        while (!aux.colaVacia()) { // L
            cp.acolarPrioridad(aux.primero(), aux.prioridad()); // C
            aux.desacolar(); // C
        } // L

        return conj; // C
    } // L
}