package Ej13.implementacion;

import tda.ABBTDA;

public class MetodosEj13 {

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