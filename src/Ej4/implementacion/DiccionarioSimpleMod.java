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
    public void inicializarDiccionario() {
        primero = null;
    }

    @Override
    public void agregar(int clave, int valor) {
        if (!this.claves().pertenece(clave)) {
            NodoClave nodoClave = new NodoClave();
            nodoClave.clave = clave;
            nodoClave.valor = valor;
            nodoClave.factorMod = 0;
            nodoClave.sigClave = primero;
            primero = nodoClave;
        } else {
            NodoClave nodoClave = primero;

            while (nodoClave != null && clave != nodoClave.clave) {
                nodoClave = nodoClave.sigClave;
            }

            nodoClave.factorMod++;
        }
    }

    @Override
    public void eliminar(int clave) {
        NodoClave nodoClave = primero;
        NodoClave nodoAnterior = null;

        while (nodoClave != null && clave != nodoClave.clave) {
            nodoAnterior = nodoClave;
            nodoClave = nodoClave.sigClave;
        }

        if (nodoAnterior == null) {
            primero = nodoClave.sigClave;
        } else {
            nodoAnterior.sigClave = nodoClave.sigClave;
        }
    }

    @Override
    public int recuperar(int clave) {
        NodoClave nodoClave = primero;

        while (nodoClave != null && clave != nodoClave.clave) {
            nodoClave = nodoClave.sigClave;
        }

        return nodoClave.valor;
    }

    @Override
    public int recuperarMod(int clave) {
        NodoClave nodoClave = primero;

        while (nodoClave != null && clave != nodoClave.clave) {
            nodoClave = nodoClave.sigClave;
        }

        return nodoClave.factorMod;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA claves = new Conjunto();
        claves.inicializarConjunto();
        NodoClave nodoClave = primero;

        while (nodoClave != null) {
            claves.agregar(nodoClave.clave);
            nodoClave = nodoClave.sigClave;
        }

        return claves;
    }
}
