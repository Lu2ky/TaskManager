package co.Luky;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.crypto.SecretKey;

public class Archivos {
	
	public static boolean guardarTareas(Tarea tarea) {
		String sRuta = "C:e\\" + "DatosGestorTareas.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(sRuta, true))) {
			writer.write(tarea.toString());
			writer.newLine();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean saltodelinea() throws IOException {
		String sRuta = "D:\\DataBase\\" + "DatosGestorTareas.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(sRuta, true))) {
			writer.newLine();
			return true;
		}
	}

	public static boolean guardarUsuarios(Usuario usuario) throws Exception {
		String sRuta = "D:\\TaskManagerData\\" + File.separator + "Usuarios.txt";
		File directorio = new File("D:\\\\TaskManagerData\\\\");
		if (!directorio.exists()) {
			if (!directorio.mkdir()) {
				System.err.println("No se pudo crear el directorio: " + directorio.getAbsolutePath());
				return false;
			}
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(sRuta, true))) {
			writer.write(usuario.toString());
			writer.newLine();
			
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static ArrayList<Usuario> cargarUsuarios() throws Exception {
		ArrayList<Usuario> users = new ArrayList<>();
		File file = new File("D:\\TaskManagerData\\Usuarios.txt");
		File directorio = new File("D:\\\\TaskManagerData\\\\");
		if(directorio.exists() == false) {
			directorio.mkdir();
		}
		if(file.exists() == false) {
			file.createNewFile();
		}
		String sRuta = "D:\\TaskManagerData\\Usuarios.txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(sRuta))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				linea = linea.trim();
				if (linea.isEmpty()) {
					continue;
				}

				try {
				
					Usuario user = Usuario.fromString(linea);
					users.add(user);
				} catch (IllegalArgumentException e) {
					System.err.println("Error al procesar la línea: " + linea + " - " + e.getMessage());
				}
			}
		}

		return users;
	}
}
