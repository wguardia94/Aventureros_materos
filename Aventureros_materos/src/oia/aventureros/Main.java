package oia.aventureros;

public class Main {

	public static void main(String[] args) {
		/*
		// sin archivos
		int N = 5;
		long[] a = { 1, 2, 3, 4 };
		Resultado resultado = SeleccionarCebador.seleccionarCebador(N, a);
		System.out.println(resultado);

		//con archivos
		DatosEntrada datos = Archivos.leerArchivo("./casosDePrueba/casoNormal.txt");
		resultado = SeleccionarCebador.seleccionarCebador(datos.getN(), datos.getPasajes());
		Archivos.escribirArchivo("./casosDePrueba/resultados/resultadoCasoNormal.txt", resultado);
		*/
		
		// sin archivos
		int N = 5;
		long[] a = { 1, 2, 3, 4 };
		Resultado resultado = SeleccionarCebador.seleccionarCebadorSegmentTree(N, a);
		System.out.println(resultado);

		//con archivos
		DatosEntrada datos = Archivos.leerArchivo("./casosDePrueba/casoNormal.txt");
		resultado = SeleccionarCebador.seleccionarCebadorSegmentTree(datos.getN(), datos.getPasajes());
		Archivos.escribirArchivo("./casosDePrueba/resultados/resultadoCasoNormal.txt", resultado);
	}

}
