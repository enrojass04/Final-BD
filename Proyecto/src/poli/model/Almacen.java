package poli.model;


public class Almacen {

	
	private String nit;

	private String nombreAlmacen;
	
	private String sucursal;

	private String direccionAlmacen;

	private String nombreGerente;

	private String telefonoAlmacen;

	public Almacen(String nit, String nombreAlmacen, String sucursal, String direccionAlmacen, String nombreGerente,
			String telefonoAlmacen) {
		this.nit = nit;
		this.nombreAlmacen = nombreAlmacen;
		this.sucursal = sucursal;
		this.direccionAlmacen = direccionAlmacen;
		this.nombreGerente = nombreGerente;
		this.telefonoAlmacen = telefonoAlmacen;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getDireccionAlmacen() {
		return direccionAlmacen;
	}

	public void setDireccionAlmacen(String direccionAlmacen) {
		this.direccionAlmacen = direccionAlmacen;
	}

	public String getNombreGerente() {
		return nombreGerente;
	}

	public void setNombreGerente(String nombreGerente) {
		this.nombreGerente = nombreGerente;
	}

	public String getTelefonoAlmacen() {
		return telefonoAlmacen;
	}

	public void setTelefonoAlmacen(String telefonoAlmacen) {
		this.telefonoAlmacen = telefonoAlmacen;
	}

	@Override
	public String toString() {
		return nombreAlmacen + " " + sucursal;
	}
	
	
	
}