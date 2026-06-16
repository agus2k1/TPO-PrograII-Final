package Ej2.uso;

import Ej2.implementacion.ConjuntoMamushka;
import Ej2.interfaz.ConjuntoMamushkaTDA;

public class uso {

	static void check(String desc, boolean cond) {
		System.out.println((cond ? "[PASS]" : "[FAIL]") + " " + desc);
	}

	public static void main(String[] args) {
		ConjuntoMamushkaTDA c = new ConjuntoMamushka();
		c.inicializar();

		check("recién inicializado está vacío", c.estaVacio());
		check("perteneceCant(5) en vacío = 0", c.perteneceCant(5) == 0);

		c.guardar(5);
		check("guardar(5): no está vacío", !c.estaVacio());
		check("guardar(5): perteneceCant(5)=1", c.perteneceCant(5) == 1);

		c.guardar(5);
		c.guardar(5);
		check("guardar(5) x3: perteneceCant(5)=3", c.perteneceCant(5) == 3);

		check("perteneceCant(99)=0", c.perteneceCant(99) == 0);

		c.sacar(5);
		check("sacar(5) una vez: perteneceCant(5)=2", c.perteneceCant(5) == 2);
		check("sigue sin estar vacío", !c.estaVacio());

		c.sacar(5);
		c.sacar(5);
		check("sacar(5) última vez: perteneceCant(5)=0", c.perteneceCant(5) == 0);
		check("estaVacio=true luego de sacar todo", c.estaVacio());

		c.guardar(1);
		c.guardar(2);
		c.guardar(3);
		c.sacar(2);
		check("sacar del medio: perteneceCant(1)=1", c.perteneceCant(1) == 1);
		check("sacar del medio: perteneceCant(2)=0", c.perteneceCant(2) == 0);
		check("sacar del medio: perteneceCant(3)=1", c.perteneceCant(3) == 1);

		int elegido = c.elegir();
		check("elegir devuelve elemento del conjunto", c.perteneceCant(elegido) > 0);
	}

}