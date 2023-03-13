package programa;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import simulacion.Accion;
import simulacion.LectorAcciones;
import simulacion.SimuladorRueda;

public class Programa {

	public static void main(String[] args) {

		SimuladorRueda simulador = new SimuladorRueda();
		List<Accion> acciones = new LinkedList<>();
		LectorAcciones lector = new LectorAcciones();

		try {
			acciones = lector.leerAcciones();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		simulador.simularRuedaDeBolsa(acciones);
		
		System.out.println("\nPrograma finalizado");
		
	}

}
