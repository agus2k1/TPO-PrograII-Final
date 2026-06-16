package ejercicios_sueltos.ejercicio15.Implementacion;

import tda.GrafoTDA;
import tda.ConjuntoTDA;

public class MetodosEj15 {

    public int calcularGrado(GrafoTDA g, int v) { // P
        int salientes = 0; // C
        int entrantes = 0; // C
        
        // Pido todos los vértices del grafo para analizarlos
        ConjuntoTDA vertices = g.vertices(); // C
        
        // Recorro todos los vértices uno por uno
        while (!vertices.conjuntoVacio()) { // P
            int u = vertices.elegir(); // C
            vertices.sacar(u); // C
            
            // Si hay una arista que sale de mi vértice 'v' hacia el vértice 'u'
            if (g.existeArista(v, u)) { // L
                salientes++; // C
            } // C
            
            // Si hay una arista que llega desde el vértice 'u' hacia mi vértice 'v'
            if (g.existeArista(u, v)) { // L
                entrantes++; // C
            } // C
        } // P (Itera todos los vértices y adentro usa existeArista que es lineal)
        
        // El grado es la diferencia entre las que salen y las que llegan
        return salientes - entrantes; // C
    } // P
}