package oia.aventureros;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {

		String ruta = "./casosDePrueba/casoNormal.txt";
		// String ruta = "./casosDePrueba/casoSecuencial.txt";
		// String ruta = "./casosDePrueba/casoLimite.txt";
		// String ruta = "./casosDePrueba/casoError.txt";
		try {
			DatosEntrada datos = Archivos.leerArchivo(ruta);
			Resultado resultado = SeleccionarCebador.seleccionarCebadorSegmentTree(datos);
			Path path = Paths.get(ruta);
			String nombreArchivo = path.getFileName().toString();
			Archivos.escribirArchivo("./casosDePrueba/resultados/resultado_" + nombreArchivo, resultado);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}

	}

}
