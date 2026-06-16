package Ej2.implementacion;

import Ej2.interfaz.ConjuntoMamushkaTDA;

public class ConjuntoMamushka implements ConjuntoMamushkaTDA {

	private Nodo nodoInicial;

	private static class Nodo {
		int info;
		Nodo sig;
		int cant;
	}

	@Override
	public void inicializar() {	//C
		nodoInicial = null;		//C

	}

	@Override
	public void guardar(int dato) {	//L

		if(this.perteneceCant(dato) > 0) {	//L
			Nodo aux = nodoInicial;	//C
			while(aux.info != dato) {	//L
				aux = aux.sig;	//C
			}
			aux.cant ++;	//C
		} else {
			Nodo nuevo = new Nodo();	//C
			nuevo.info = dato;	//C
			nuevo.cant = 1;		//C
			nuevo.sig = nodoInicial; 	//C
			nodoInicial = nuevo;		//C
		}
	}

	@Override
	public void sacar(int dato) {		//L

	    int cant = perteneceCant(dato);	//L

	    if (cant > 1) {		//C
	        Nodo aux = nodoInicial;	//C
	        while (aux.info != dato) {	//L
	            aux = aux.sig;	//C
	        }

	        aux.cant--;		//C

	    } else if (cant == 1) {	//C
	        if (nodoInicial.info == dato) {	//C
	            nodoInicial = nodoInicial.sig;	//C
	        } else {	//C
	            Nodo aux = nodoInicial;	//C
	            while (aux.sig != null && aux.sig.info != dato) {	//L
	                aux = aux.sig;		//C
	            }
	            if (aux.sig != null) {		//C
	                aux.sig = aux.sig.sig;		//C
	            }
	        }
	    }
	}


	@Override
	public int elegir() {	//C
		return nodoInicial.info;	//C
	}

	@Override
	public int perteneceCant(int dato) {	//L
		Nodo aux = nodoInicial;		//C

		while(aux != null && aux.info != dato) {	//L
			aux = aux.sig;		//C
		}

		if(aux != null) {		//C
			return aux.cant;		//C
		}

		return 0;		//C
	}

	@Override
	public boolean estaVacio() {	//C
		return (nodoInicial == null);		//C
	}

}