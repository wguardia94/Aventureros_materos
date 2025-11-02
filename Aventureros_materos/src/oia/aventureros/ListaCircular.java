package oia.aventureros;

public class ListaCircular {
	private int[] izq;
	private int[] der;
	
	public ListaCircular(int n) {
		this.izq = new int[n + 1];
		this.der = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			this.izq[i] = (i == 1) ? n : i - 1;
			this.der[i] = (i == n) ? 1 : i + 1;
		}
	}

	public int getSiguienteDe(int actual) {
		return this.der[actual];
	}
	
	public void eliminar(int actual) {
		this.der[this.izq[actual]] = this.der[actual];
		this.izq[this.der[actual]] = this.izq[actual];
	}
	
}
