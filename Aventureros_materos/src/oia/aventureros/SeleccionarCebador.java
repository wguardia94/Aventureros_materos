package oia.aventureros;

public class SeleccionarCebador {
	public static Resultado seleccionarCebadorSegmentTree(DatosEntrada datos) {
		SegmentTree aventureros = new SegmentTree(datos.getN());
		int[] eliminados = new int[datos.getN() - 1];
		long actual = 0;
		int siguenEnRonda = datos.getN();
		
		for (int i = 0; i < datos.getN() - 1; i++) {
			long pasaje = datos.getPasaje(i) % siguenEnRonda;
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
