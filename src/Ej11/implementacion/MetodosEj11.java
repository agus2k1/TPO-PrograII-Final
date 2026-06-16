package Ej11.implementacion;

import imple.Cola;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;

public class MetodosEj11 {

    public ColaTDA valoresDiccionario(DiccionarioMultipleTDA dic) {

        ColaTDA cola = new Cola();
        cola.inicializarCola();
        ConjuntoTDA claves = dic.claves();

        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            claves.sacar(clave);
            ConjuntoTDA valores = dic.recuperar(clave);
            while (!valores.conjuntoVacio()) {
                int valor = valores.elegir();
                valores.sacar(valor);
                cola.acolar(valor);
            }
        }

        return cola;
    }
}
