package ejercicios_sueltos.ejercicio3;

import imple.Cola;
import tda.ABBTDA;
import tda.ColaTDA;

public class ejercicios {

    //Ejercicio 8
    public ColaTDA sinRepetidos(ColaTDA c) {

        ColaTDA cola = new Cola();
        cola.inicializarCola();

        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();

        while (!c.colaVacia()) {

            int valor = c.primero();
            c.desacolar();
            colaAux.acolar(valor);

            boolean encontrado = false;

            ColaTDA colaAux2 = new Cola();
            colaAux2.inicializarCola();

            while (!cola.colaVacia()) {
                int valor2 = cola.primero();
                cola.desacolar();

                if (valor == valor2) {
                    encontrado = true;
                }

                colaAux2.acolar(valor2);
            }

            while (!colaAux2.colaVacia()) {
                cola.acolar(colaAux2.primero());
                colaAux2.desacolar();
            }

            if (!encontrado) {
                cola.acolar(valor);
            }
        }

        while (!colaAux.colaVacia()) {
            c.acolar(colaAux.primero());
            colaAux.desacolar();
        }

        return cola;
    }

    // Ejercicio 13
    public static int contarHojasPares(ABBTDA arbol) {
        if (arbol.arbolVacio()){
            return 0;
        }

        if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()){
            if (arbol.raiz() % 2 == 0){
                return 1;
            } else {
                return 0;
            }
        }

        return contarHojasPares(arbol.hijoIzq()) + contarHojasPares(arbol.hijoDer());
    }
}
