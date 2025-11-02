package oia.aventureros;

public class SeleccionarCebador {
	public static Resultado seleccionarCebador(int N, long[] pasajes) {
		ListaCircular aventureros = new ListaCircular(N);
		int[] eliminados = new int[N - 1];
		int actual = 1;
		int siguenEnRonda = N;

		for (int i = 0; i < N - 1; i++) {
			long pasos = pasajes[i] % siguenEnRonda;
			for (int j = 0; j < pasos; j++) {
				actual = aventureros.getSiguienteDe(actual);
			}

			eliminados[i] = actual;
			aventureros.eliminar(actual);
		
			actual = aventureros.getSiguienteDe(actual);
			siguenEnRonda--;
		}

		return new Resultado(actual, eliminados);
	}
	
	public static Resultado seleccionarCebadorSegmentTree(int N, long[] pasajes) {
		SegmentTree aventureros = new SegmentTree(N);
		int[] eliminados = new int[N - 1];
		long actual = 0;
		int siguenEnRonda = N;
		
		for (int i = 0; i < N-1; i++) {
			long pasaje = pasajes[i] % siguenEnRonda;
			int aventureroRetirar = (int)((actual + pasaje) % siguenEnRonda);
			int nroAventurero = aventureros.realizarPasaje(aventureroRetirar);
			
			eliminados[i] = nroAventurero + 1;
			aventureros.eliminar(nroAventurero);
			siguenEnRonda--;
			
			if (siguenEnRonda > 0) {
				actual = aventureroRetirar % siguenEnRonda;
			}
		}
		int cebador = aventureros.realizarPasaje(0) + 1;
		
		return new Resultado(cebador, eliminados);
	}
}
