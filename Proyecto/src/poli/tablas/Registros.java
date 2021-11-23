package poli.tablas;

public class Registros {
	
	private String nombre;
	private int id;
	private String date;
	
	public Registros(String nombre, int id, String date) {
		this.nombre = nombre;
		this.id = id;
		this.date = date;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
