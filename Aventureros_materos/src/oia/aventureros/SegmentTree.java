package oia.aventureros;

public class SegmentTree {
	private int tamaño;
    private int[] arbol;

    /*
     * Las hojas son los aventureros y se encuentra 1 (sigue en la ronda) o 0 (fuera de la ronda)
     * Los nodos tiene la suma de sus hijos, entonces representan la cantidad de aventureros que tiene
     */
    public SegmentTree(int n) {
        this.tamaño = 1;
        /*
         * las cantidad de hojas en el arbol debe ser potencia de 2, 
         * entonces buscamos la potencia de 2 que sea suficiente para la cantidad de aventureros
        */
        while (this.tamaño < n) {
        	this.tamaño *= 2;
        }
        this.arbol = new int[2 * this.tamaño];
        
        
        //construimos el arbol, todos los aventureros (hojas) vivos
        for (int i = 0; i < n; i++) {
        	this.arbol[this.tamaño + i] = 1;
        }
        //completamos los demas nodos con la suma de sus hijos
        for (int i = this.tamaño - 1; i > 0; i--) {
        	this.arbol[i] = this.arbol[2 * i] + this.arbol[2 * i + 1];
        }
    }

    public void eliminar(int nroAventurero) {
        int pos = this.tamaño + nroAventurero;
        this.arbol[pos] = 0;
        //actualizamos el valor de los nodos
        while (pos > 1) {
            pos /= 2;
            this.arbol[pos] = this.arbol[2 * pos] + this.arbol[2 * pos + 1];
        }
    }

    /* obtener el aventurero a retirar de la ronda
     * 
     */
    public int realizarPasaje(long nroAventurero) {
        int nodo = 1;
        while (nodo < this.tamaño) {
            if (this.arbol[2 * nodo] > nroAventurero) {
                nodo = 2 * nodo;
            } else {
                nroAventurero -= this.arbol[2 * nodo];
                nodo = 2 * nodo + 1;
            }
        }
        return nodo - tamaño;
    }
}
