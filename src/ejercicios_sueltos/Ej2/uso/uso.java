package ejercicios_sueltos.Ej2.uso;

import imple.*;
import tda.*;

public class uso {

	public static void main(String[] args) {
		

	}
	
	//7)
	public ConjuntoTDA elementosRepetidos (PilaTDA pila) {
		
		// Guarda los elementos que ya aparecieron
		ConjuntoTDA conjuntoVistos = new Conjunto();
		conjuntoVistos.inicializarConjunto();
		
		// Guarda los elementos repetidos
		ConjuntoTDA conjuntoResultado = new Conjunto();
		conjuntoResultado.inicializarConjunto();
		
		// Permite restaurar la pila original
		PilaTDA aux = new Pila();
		aux.inicializarPila();
		
		// Recorro la pila
		while(!pila.pilaVacia()) {
			int elemento = pila.tope();
			
			// Guardo el elemento para reconstruir la pila luego
			aux.apilar(elemento);
			pila.desapilar();
			
			// Si ya aparecio, lo agrego al resultado
			if(conjuntoVistos.pertenece(elemento)) {
			    conjuntoResultado.agregar(elemento);  
			} else {
			    conjuntoVistos.agregar(elemento);    
			}
		}
		
		// Restauro la pila original
		while(!aux.pilaVacia()) {
			int elemento = aux.tope();
			pila.apilar(elemento);
			aux.desapilar();
		}
		
		return conjuntoResultado;
	}
	
	
	//12)
	public int sumaImpar (ABBTDA a) {
		
		//En caso de que arbol este vacio
		if(a.arbolVacio()) {
			return 0;
		}
		
		int suma = 0;
		
		// Si la raíz es impar la sumo
		if (a.raiz() % 2 != 0) {  
	        suma = a.raiz();
	    }
		
		// Sumo los impares de ambos subárboles
	    suma += sumaImpar(a.hijoIzq()); 
	    suma += sumaImpar(a.hijoDer());  

	    return suma;
		
	}
	
	

}
