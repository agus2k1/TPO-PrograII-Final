package ejercicios_sueltos.ejercicio5.Uso;

import tda.DiccionarioSimpleTDA;
import tda.ConjuntoTDA;
import ejercicio5.Implementacion.DiccionarioSimpleCPImpl;

public class MainEjercicio5 {

    public static void main(String[] args) {
        DiccionarioSimpleTDA dicc = new DiccionarioSimpleCPImpl();
        dicc.inicializarDiccionario();
        
        dicc.agregar(1, 100);
        dicc.agregar(2, 200);
        dicc.agregar(3, 300);
        
        // Piso el valor de la clave 1 para ver si actualiza
        dicc.agregar(1, 999);
        
        System.out.println("Valor de clave 1 (deberia ser 999): " + dicc.recuperar(1));
        System.out.println("Valor de clave 2 (deberia ser 200): " + dicc.recuperar(2));
        
        dicc.eliminar(2);
        System.out.println("Se elimino la clave 2.");
        
        System.out.println("Claves que quedaron:");
        ConjuntoTDA claves = dicc.claves();
        while (!claves.conjuntoVacio()) {
            int c = claves.elegir();
            System.out.println("- " + c);
            claves.sacar(c);
        }
    }
}