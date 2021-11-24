package poli.model;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public class Factura {
	
	private int numero;
	
	private String fecha;	
	
	private Consumidor consumidor;
	
	private Cajero cajero;
	
	private Almacen almacen;
	
	private Pago pago;
	
	private ObservableList<Producto> productos;
	
	public Factura() {
		
	}

	public Factura(int numero, String fecha, Consumidor consumidor, Cajero cajero, Almacen almacen, Pago pago,
			ObservableList<Producto> productos) {
		this.numero = numero;
		this.fecha = fecha;
		this.consumidor = consumidor;
		this.cajero = cajero;
		this.almacen = almacen;
		this.pago = pago;
		this.productos = productos;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public ObservableList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ObservableList<Producto> productos) {
		this.productos = productos;
	}


	
	public String mostrarFac() {
		String s = "";
		for (int i = 0; i < productos.size(); i++) {
			s += productos.get(i).mostrarFac() + " ";
		}
		return "No. Factura: " + numero + "\n"
	          +"Fecha: " + fecha +"\n"
	          + "\n"
	          + "Almacen:  " +  almacen.mostrarFac() +"\n"
			  + "\n"
	          + "Información cliente: " + consumidor.mostrarFac() +"\n"
	    	  + "\n"
	          + "Información cajero: " + cajero.mostrarFac() +"\n"
	    	  + "\n"
	          + "Productos: " + s +"\n"
	    	  + "\n"
			  + "Tipo de pago: " + pago.mostrarFac() +"\n"
					  +"\n"
					  +"\n"
			  + "-------------------------------¡GRACIAS POR SU COMPRA!-----------------------------------";
	}

	

}