package Ej1.uso;

import Ej1.implementacion.ConjuntoEspecial;
import Ej1.interfaz.ConjuntoEspecialTDA;
import Ej1.interfaz.ConjuntoEspecialTDA.Respuesta;

public class uso {

	static void check(String desc, boolean cond) {
		System.out.println((cond ? "[PASS]" : "[FAIL]") + " " + desc);
	}

	public static void main(String[] args) {
		ConjuntoEspecialTDA c = new ConjuntoEspecial();
		c.inicializarConjunto();

		// Conjunto vacío al inicio
		check("conjunto recién inicializado está vacío", c.conjuntoVacio());

		// elegir en conjunto vacío → error=true
		Respuesta r = c.elegir();
		check("elegir en vacío: error=true", r.error);

		// sacar en conjunto vacío → error=true
		r = c.sacar(5);
		check("sacar en vacío: error=true", r.error);

		// agregar elemento nuevo → error=false, rta=valor
		r = c.agregar(10);
		check("agregar(10): error=false", !r.error);
		check("agregar(10): rta=10", r.rta == 10);
		check("después de agregar, no está vacío", !c.conjuntoVacio());

		// agregar elemento duplicado → error=true
		r = c.agregar(10);
		check("agregar(10) duplicado: error=true", r.error);

		// pertenece
		check("pertenece(10)=true", c.pertenece(10));
		check("pertenece(99)=false", !c.pertenece(99));

		// elegir en conjunto no vacío → error=false
		r = c.elegir();
		check("elegir no vacío: error=false", !r.error);
		check("elegir no vacío: rta=10", r.rta == 10);

		// agregar más elementos y sacar del medio
		c.agregar(1);
		c.agregar(2);
		c.agregar(3);

		r = c.sacar(2);
		check("sacar(2) existente: error=false", !r.error);
		check("después de sacar(2), pertenece(2)=false", !c.pertenece(2));
		check("después de sacar(2), pertenece(1)=true", c.pertenece(1));
		check("después de sacar(2), pertenece(3)=true", c.pertenece(3));

		// sacar elemento inexistente → error=true
		r = c.sacar(99);
		check("sacar(99) inexistente: error=true", r.error);
	}
}
