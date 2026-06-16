package Ej11.implementacion;

import imple.Cola;
import imple.Conjunto;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;

public class MetodosEj11 {

    public ColaTDA valoresDiccionario(DiccionarioMultipleTDA dic) { // P

        ColaTDA cola = new Cola(); // C
        cola.inicializarCola(); // C
        ConjuntoTDA vistos = new Conjunto(); // C
        vistos.inicializarConjunto(); // C
        ConjuntoTDA claves = dic.claves(); // L

        while (!claves.conjuntoVacio()) { // P (loop interno con L adentro)
            int clave = claves.elegir(); // C
            claves.sacar(clave); // L
            ConjuntoTDA valores = dic.recuperar(clave); // L
            while (!valores.conjuntoVacio()) { // P (pertenece adentro es L)
                int valor = valores.elegir(); // C
                valores.sacar(valor); // L
                if (!vistos.pertenece(valor)) { // L
                    vistos.agregar(valor); // C
                    cola.acolar(valor); // C
                }
            }
        }

        return cola; // C
    }
}
