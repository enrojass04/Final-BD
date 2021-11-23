package poli.model;

public class Cajero {

	private String codigoCajero;
	private String nombreCajero;
	
	
	public Cajero(String codigoCajero, String nombreCajero) {
		this.codigoCajero = codigoCajero;
		this.nombreCajero = nombreCajero;
	}
	public String getIdCajero() {
		return codigoCajero;
	}
	public void setIdCajero(String idCajero) {
		this.codigoCajero = idCajero;
	}
	public String getNombreCajero() {
		return nombreCajero;
	}
	public void setNombreCajero(String nombreCajero) {
		this.nombreCajero = nombreCajero;
	}
	@Override
	public String toString() {
		return nombreCajero;
	}
		
}
