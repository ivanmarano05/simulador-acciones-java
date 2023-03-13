package simulacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorAcciones {
	
	public LectorAcciones() {
		
	}
	
	public List<Accion> leerAcciones() throws IOException {
		List<Accion> acciones = new ArrayList<>();
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("acciones.csv"));
			
			String linea;
			Accion accion;
			while ((linea = in.readLine()) != null) {
				accion = crearAccion(linea);
				acciones.add(accion);
			}
			
			return acciones;
			
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
	
	private Accion crearAccion(String linea) {
		
		String nombre;
		int cotizacionInicial;
		
		String[] datos = linea.split(",");
		
		nombre = datos[0];
		cotizacionInicial = Integer.parseInt(datos[1]);
		
		return new Accion(nombre, cotizacionInicial, 0);
	}

}
