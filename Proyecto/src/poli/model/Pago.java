package poli.model;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class Pago {
	
	private String idPago;
	
	private String tipoPago;

	public String getIdPago() {
		return idPago;
	}

	public Pago(String idPago, String tipoPago) {
		this.idPago = idPago;
		this.tipoPago = tipoPago;
	}

	public void setIdPago(String idPago) {
		this.idPago = idPago;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	
	public String mostrarFac() {
		return "\n" + tipoPago  +"\n"
				+"Código: " + idPago;
	}

	
	@Override
	public String toString() {
		return tipoPago;
	}
	

}