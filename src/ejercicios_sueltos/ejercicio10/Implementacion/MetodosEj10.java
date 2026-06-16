package ejercicios_sueltos.ejercicio10.Implementacion;

import tda.PilaTDA;
import tda.DiccionarioSimpleTDA;
import tda.ConjuntoTDA;
import imple.Pila;
import imple.DiccionarioSimple;

public class MetodosEj10 {

    public DiccionarioSimpleTDA frecuenciasPila(PilaTDA p) { // P
        DiccionarioSimpleTDA dicc = new DiccionarioSimple(); // C
        dicc.inicializarDiccionario(); // C
        
        PilaTDA aux = new Pila(); // C
        aux.inicializarPila(); // C

        // Desapilo la original para ir contando, y guardo en la auxiliar
        while (!p.pilaVacia()) { // P
            int tope = p.tope(); // C
            aux.apilar(tope); // C
            p.desapilar(); // C

            // Me fijo si el elemento ya está en el diccionario
            ConjuntoTDA claves = dicc.claves(); // L
            if (claves.pertenece(tope)) { // L
                // Si ya existe, le sumo 1 a la cantidad que tenía
                int cantActual = dicc.recuperar(tope); // L
                dicc.agregar(tope, cantActual + 1); // L
            } else { // C
                // Si no existe, lo agrego por primera vez con cantidad 1
                dicc.agregar(tope, 1); // L
            } // L
        } // P (El ciclo es Lineal, pero adentro tiene operaciones Lineales, entonces queda Polinómico)
        
        // Vuelvo a pasar todo de la auxiliar a la original para no romperla
        while (!aux.pilaVacia()) { // L
            p.apilar(aux.tope()); // C
            aux.desapilar(); // C
        } // L
        
        return dicc; // C
    } // P
}