package Ej11.uso;

import Ej11.implementacion.MetodosEj11;
import imple.DiccionarioMultiple;
import tda.ColaTDA;
import tda.DiccionarioMultipleTDA;

public class MainEjercicio11 {

    public static void main(String[] args) {
        MetodosEj11 m = new MetodosEj11();

        DiccionarioMultipleTDA dic = new DiccionarioMultiple();
        dic.inicializarDiccionario();
        dic.agregar(1, 10);
        dic.agregar(1, 20);
        dic.agregar(2, 30);

        ColaTDA valores = m.valoresDiccionario(dic);

        System.out.println("Valores del diccionario:");
        while (!valores.colaVacia()) {
            System.out.println("- " + valores.primero());
            valores.desacolar();
        }
    }
}
