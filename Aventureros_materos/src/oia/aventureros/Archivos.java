package oia.aventureros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivos {

	public static DatosEntrada leerArchivo(String direccionArchivo) {
		try (BufferedReader br = new BufferedReader(new FileReader(direccionArchivo))) {

			// Primera línea -> cantidad de OIA
			int n = Integer.parseInt(br.readLine().trim());

			// Segunda línea -> pasajes
			String[] partes = br.readLine().trim().split("\\s+");
			long[] pasajes = new long[n - 1];

			for (int i = 0; i < n - 1; i++) {
				pasajes[i] = Integer.parseInt(partes[i]);
			}

			return new DatosEntrada(n, pasajes);
		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
		}
		return null;
	}

	public static void escribirArchivo(String direccionArchivo, Resultado resultado) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(direccionArchivo))) {

			// Primera línea: eliminados
			for (int i = 0; i < resultado.getEliminados().length; i++) {
				bw.write(String.valueOf(resultado.getEliminado(i)));
				if (i < resultado.getEliminados().length - 1) {
					bw.write(" ");
				}
			}
			bw.newLine();

			// Segunda línea: cebador final
			bw.write(String.valueOf(resultado.getCebador()));
			bw.newLine();
		} catch (IOException e) {
			System.err.println("Error al escribir el archivo: " + e.getMessage());
		}
	}
}
