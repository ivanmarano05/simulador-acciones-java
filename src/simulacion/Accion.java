package simulacion;

public class Accion {

	private String nombre;
	private int cotizacionInicial, cotizacionFinal;
	
	public Accion() {
		
	}

	public Accion(String nombre, int cotizacionInicial, int cotizacionFinal) {
		this.nombre = nombre;
		this.cotizacionInicial = cotizacionInicial;
		this.cotizacionFinal = cotizacionFinal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCotizacionInicial() {
		return cotizacionInicial;
	}

	public void setCotizacionInicial(int cotizacionInicial) {
		this.cotizacionInicial = cotizacionInicial;
	}
	
	public int getCotizacionFinal() {
		return cotizacionFinal;
	}

	public void setCotizacionFinal(int getCotizacionFinal) {
		this.cotizacionFinal = getCotizacionFinal;
	}
	
}
