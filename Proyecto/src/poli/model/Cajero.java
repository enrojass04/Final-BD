package poli.model;

public class Cajero {

	private String idCajero;
	private String nombreCajero;
	
	
	public Cajero(String idCajero, String nombreCajero) {
		this.idCajero = idCajero;
		this.nombreCajero = nombreCajero;
	}
	public String getIdCajero() {
		return idCajero;
	}
	public void setIdCajero(String idCajero) {
		this.idCajero = idCajero;
	}
	public String getNombreCajero() {
		return nombreCajero;
	}
	public void setNombreCajero(String nombreCajero) {
		this.nombreCajero = nombreCajero;
	}
	
	public String mostrarFac() {
		return "\n" + "Cajero: "+ nombreCajero + "\n"
				+"Código: " + idCajero ;
	}
	
	
	@Override
	public String toString() {
		return nombreCajero;
	}
		
}