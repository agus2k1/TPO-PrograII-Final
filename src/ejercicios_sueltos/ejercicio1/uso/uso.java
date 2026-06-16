package ejercicios_sueltos.ejercicio1.uso;

import imple.Cola;
import imple.Pila;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;
import tda.PilaTDA;

public class uso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public float pares(PilaTDA pila) {
		
		// Creo una nueva pila auxiliar y la inicializo
		PilaTDA aux = new Pila();
		aux.inicializarPila();
		
		// Inicializo mis contadores
		int contadorPares = 0;
		int contadorTotal = 0;
		
		// Recorro mi pila original buscando la cantidad de pares y totales
		while(!pila.pilaVacia()) {
			int num = pila.tope();
			if (num % 2 == 0) {
				contadorPares++;
			}
			contadorTotal++;
			aux.apilar(num);
			pila.desapilar();
		}
		
		// Reestablezco mi pila original
		while(!aux.pilaVacia()) {
			pila.apilar(aux.tope());
			aux.desapilar();
		}
		
		// Retorno el float
		return (contadorPares / contadorTotal) * 100;
	}
	
	public ColaTDA valoresDiccionario(DiccionarioMultipleTDA dic) {
		
		// Inicializo un par de TDAs
		ColaTDA cola = new Cola();
		cola.inicializarCola();
		ConjuntoTDA claves = dic.claves();
		
		// Recorro mi conjunto
		// Tomo una clave del conjunto de claves
		// Busco todos los valores asociados a esa clave en el diccionario
		// Tomo cada valor asociado y lo agrego a la cola
		
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
	
		// Retorno la cola
		return cola;
	}
}
