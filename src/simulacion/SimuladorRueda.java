package simulacion;

import java.util.List;
import java.util.Random;

public class SimuladorRueda {
	
	public SimuladorRueda() {
		
	}
	
	public void simularRuedaDeBolsa(List<Accion> acciones) {
		
		Random r = new Random();
		int variacion = 0;
		
		System.out.println("\nCotizaciones iniciales: ");
		
		for (Accion accion : acciones) {
			System.out.println(accion.getNombre() + ": $" + accion.getCotizacionInicial());
		}
		
		for (Accion accion : acciones) {
			accion.setCotizacionFinal(accion.getCotizacionInicial());
			
			for (int i = 0; i < 100; i++) {
				variacion = r.nextInt(11) + (-5);
				variacion = variacion * accion.getCotizacionFinal() / 100;
				accion.setCotizacionFinal(accion.getCotizacionFinal() + variacion);
			}

		}
		
		Accion accionMasCara = acciones.get(0);
		Accion accionMasBarata = acciones.get(0);
		
		System.out.println("\nCotizaciones finales: ");
		
		for (Accion accion : acciones) {
			System.out.println(accion.getNombre() + ": $" + accion.getCotizacionFinal());
			
			if(accion.getCotizacionFinal() > accionMasCara.getCotizacionFinal()) {
				accionMasCara = accion;
			}
			
			if(accion.getCotizacionFinal() < accionMasBarata.getCotizacionFinal()) {
				accionMasBarata = accion;
			}
		}

		try {
			calcularPorcentajeVariacion(acciones);
		} catch(RiesgoDeQuiebreEx e) {
			System.out.println(e.getMessage());
		} finally {
			
		}
		
		System.out.println("\nAcción más cara: " + accionMasCara.getNombre());
		System.out.println("\nAcción más barata: " + accionMasBarata.getNombre());
	}
	
	public void calcularPorcentajeVariacion(List<Accion> acciones) throws RiesgoDeQuiebreEx {
		
		double diferencia = 0, porcentaje = 0;
		int accionesEnRiesgo = 0;
		
		System.out.println("\nPorcentaje de variacion: ");
		
		for (Accion accion : acciones) {
			
			if(accion.getCotizacionFinal() < accion.getCotizacionInicial()) {
				diferencia = accion.getCotizacionInicial() - accion.getCotizacionFinal();
				porcentaje = diferencia * 100 / accion.getCotizacionInicial();
				System.out.println(accion.getNombre() + " bajó un " + porcentaje + "%");
				
				if(porcentaje >= 25) {
					accionesEnRiesgo++;
				}
				
			} else {
				diferencia = accion.getCotizacionFinal() - accion.getCotizacionInicial();
				porcentaje = diferencia * 100 / accion.getCotizacionInicial();
				System.out.println(accion.getNombre() + " subió un " + porcentaje + "%");
			}
			
		}
		
		if(accionesEnRiesgo >= 1) {
			throw new RiesgoDeQuiebreEx("\n! Existen " + accionesEnRiesgo + " acciones en riesgo");
		}

	}
	
}
