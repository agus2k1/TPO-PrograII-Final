package Ej1.implementacion;

import Ej1.interfaz.ConjuntoEspecialTDA;
import Ej1.interfaz.ConjuntoEspecialTDA.Respuesta;
// EJ 1
public class ConjuntoEspecial implements ConjuntoEspecialTDA{

	private class Nodo {
		int info;
		Nodo sig;
	}

	private Nodo c;

	public void inicializarConjunto () { // C
		c = null; // C
	}

	@Override
	public Respuesta agregar(int valor) { // L

		Respuesta RTA = new Respuesta(); // C
		if (!this.pertenece(valor)) { // L	// se verifica pertenencia, Si no pertenece entonces
			Nodo nuevo = new Nodo(); // C	// Creo el nuevo nodo, el nuevo nodo que se agregar
			nuevo.info = valor; // C 		// Le asigno su valor
			nuevo.sig = c; // C				// Lo pongo como primer nodo, raiz, ahora el viejo c va a ser segundo
			c = nuevo; // C
			RTA.error = false; // C
		} else { // C
			RTA.error = true; // C
		}

		RTA.rta = valor; // C
		return RTA; // C
	}

	@Override
	public Respuesta sacar(int valor) { // L

		Respuesta RTA = new Respuesta(); // C
		if (c != null) { // L											// Si existe un valor raiz
			if (c.info == valor) { // C									// es el primero
				c = c.sig; // C
				RTA.error = false; // C
				RTA.rta = valor; // C
			} else { // L 												// es algun otro; lo buscamos
				Nodo aux = c; // C 										// Tomo al raiz como auxiliar
																		// Mientras que el siguiente a auxiliar exista
				while (aux.sig != null && aux.sig.info != valor) // L
					aux = aux.sig; // C 								// Paso al siguiente nodo
				if (aux.sig != null) { // C 							// Verifico que el siguiente sea realmente un nodo
					aux.sig = aux.sig.sig; // C 						// Lo reemplazo por null
					RTA.error = false; // C
					RTA.rta = valor; // C
				} else { // C
					RTA.error = true; // C
					RTA.rta = valor; // C
				}
			}
		} else {
			RTA.error = true; // C
		}

		return RTA; // C
	}

	@Override
	public Respuesta elegir() { // C

		Respuesta RTA = new Respuesta(); // C
		if(!this.conjuntoVacio()) {
			RTA.error = false; // C
			RTA.rta = c.info; // C
		} else { // C
			RTA.error = true; // C
			RTA.rta = 0; // C
		}
		return RTA; // C
	}

	public boolean pertenece(int x) { // L
		Nodo aux = c; // C // Tomo el nodo raiz como
		while (aux != null && aux.info != x) // L
			aux = aux.sig; // C
		return (aux != null); // C
	}

	public boolean conjuntoVacio() { // C
		return (c == null); // C // Si mi nodo raiz es null entonces está vacío
	}

}