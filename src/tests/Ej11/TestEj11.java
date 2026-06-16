package tests.Ej11;

import Ej11.implementacion.MetodosEj11;
import imple.DiccionarioMultiple;
import tda.ColaTDA;
import tda.DiccionarioMultipleTDA;

public class TestEj11 {

    static void check(String desc, boolean cond) {
        System.out.println((cond ? "[PASS]" : "[FAIL]") + " " + desc);
    }

    static int tamanio(ColaTDA c) {
        int count = 0;
        while (!c.colaVacia()) { count++; c.desacolar(); }
        return count;
    }

    static boolean contiene(ColaTDA c, int valor) {
        boolean encontrado = false;
        int count = 0;
        int[] aux = new int[100];
        while (!c.colaVacia()) {
            int v = c.primero();
            c.desacolar();
            if (v == valor) encontrado = true;
            aux[count++] = v;
        }
        for (int i = 0; i < count; i++) c.acolar(aux[i]);
        return encontrado;
    }

    public static void main(String[] args) {
        System.out.println("=== valoresDiccionario ===\n");

        MetodosEj11 m = new MetodosEj11();
        DiccionarioMultipleTDA dic;
        ColaTDA resultado;

        // diccionario con una clave y dos valores
        dic = new DiccionarioMultiple();
        dic.inicializarDiccionario();
        dic.agregar(1, 10);
        dic.agregar(1, 20);
        resultado = m.valoresDiccionario(dic);
        check("clave 1 con valores {10,20}: cola contiene 10", contiene(resultado, 10));
        check("clave 1 con valores {10,20}: cola contiene 20", contiene(resultado, 20));
        check("clave 1 con valores {10,20}: tamaño=2", tamanio(resultado) == 2);

        // diccionario con dos claves
        dic = new DiccionarioMultiple();
        dic.inicializarDiccionario();
        dic.agregar(1, 10);
        dic.agregar(2, 30);
        resultado = m.valoresDiccionario(dic);
        check("dos claves distintas: cola contiene 10", contiene(resultado, 10));
        check("dos claves distintas: cola contiene 30", contiene(resultado, 30));
        check("dos claves distintas: tamaño=2", tamanio(resultado) == 2);

        // mismo valor bajo dos claves distintas → no debe repetirse (sin ninguna repetición)
        dic = new DiccionarioMultiple();
        dic.inicializarDiccionario();
        dic.agregar(1, 10);
        dic.agregar(2, 10);
        resultado = m.valoresDiccionario(dic);
        check("valor 10 bajo dos claves: aparece solo 1 vez en la cola", tamanio(resultado) == 1);

        System.out.println("\n=== Fin de tests ===");
    }
}
