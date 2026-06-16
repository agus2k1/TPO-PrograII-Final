package Ej4.implementacion;

import Ej4.interfaz.DiccionarioSimpleModTDA;
import imple.Conjunto;
import tda.ConjuntoTDA;

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {
    NodoClave primero;

    class NodoClave {
        int clave;
        int valor;
        int factorMod;
        NodoClave sigClave;
    }

    @Override
    public void inicializarDiccionario() { // C
        primero = null; // C
    }

    @Override
    public void agregar(int clave, int valor) { // L
        if (!this.claves().pertenece(clave)) { // L (claves() itera la lista)
            NodoClave nodoClave = new NodoClave(); // C
            nodoClave.clave = clave; // C
            nodoClave.valor = valor; // C
            nodoClave.factorMod = 0; // C
            nodoClave.sigClave = primero; // C
            primero = nodoClave; // C
        } else {
            NodoClave nodoClave = primero; // C
            while (nodoClave != null && clave != nodoClave.clave) { // L
                nodoClave = nodoClave.sigClave; // C
            }
            nodoClave.factorMod++; // C
        }
    }

    @Override
    public void eliminar(int clave) { // L
        NodoClave nodoClave = primero; // C
        NodoClave nodoAnterior = null; // C
        while (nodoClave != null && clave != nodoClave.clave) { // L
            nodoAnterior = nodoClave; // C
            nodoClave = nodoClave.sigClave; // C
        }
        if (nodoAnterior == null) { // C
            primero = nodoClave.sigClave; // C
        } else {
            nodoAnterior.sigClave = nodoClave.sigClave; // C
        }
    }

    @Override
    public int recuperar(int clave) { // L
        NodoClave nodoClave = primero; // C
        while (nodoClave != null && clave != nodoClave.clave) { // L
            nodoClave = nodoClave.sigClave; // C
        }
        return nodoClave.valor; // C
    }

    @Override
    public int recuperarMod(int clave) { // L
        NodoClave nodoClave = primero; // C
        while (nodoClave != null && clave != nodoClave.clave) { // L
            nodoClave = nodoClave.sigClave; // C
        }
        return nodoClave.factorMod; // C
    }

    @Override
    public ConjuntoTDA claves() { // L
        ConjuntoTDA claves = new Conjunto(); // C
        claves.inicializarConjunto(); // C
        NodoClave nodoClave = primero; // C
        while (nodoClave != null) { // L
            claves.agregar(nodoClave.clave); // C
            nodoClave = nodoClave.sigClave; // C
        }
        return claves; // C
    }
}
