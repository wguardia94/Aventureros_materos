package oia.aventureros;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		int N = 400000;
		long[] a = new long[N-1];
		Random random = new Random();
		int max = 100000000;
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextLong(max + 1);
		}
		try {
			DatosEntrada datos = new DatosEntrada(N, a);
			Resultado resultado = SeleccionarCebador.seleccionarCebadorSegmentTree(datos);
			System.out.println(resultado);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		 
		
		//con archivos
		/*
		try {
			DatosEntrada datos = Archivos.leerArchivo("./casosDePrueba/casoNormal.txt");
			Resultado resultado = SeleccionarCebador.seleccionarCebadorSegmentTree(datos);
			Archivos.escribirArchivo("./casosDePrueba/resultados/resultadoCasoNormal.txt", resultado);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		*/
	}

}
