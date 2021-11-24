package poli.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import poli.tablas.Registros;


/**
 *
 * @author 
 */
public class Conexion {

	Connection conn = null;
	static ResultSet resultado;

	public static Connection ConnectarDb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/facturabd", "root",
					"Jos123efina*");
			System.out.println("Conexion establecida");
			return conn;
		} catch (Exception e) {
			System.err.println("Error de acceso a la BD");
			return null;
		}

	}

	public static ObservableList<Consumidor> getDataConsumidor() {
		Connection conn = ConnectarDb();
		ObservableList<Consumidor> list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from vistaconsumidor");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Consumidor(rs.getString("nombreUsuario"), 
						rs.getString("numeroTarjetaUsuario"),
						rs.getString("puntosUsuario"), 
						rs.getInt("idUsuario"), 
						rs.getString("direccionUsuario"),
						rs.getString("numeroUsuario")));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public static ObservableList<Almacen> getDataAlmacen() {
		Connection conn = ConnectarDb();
		ObservableList<Almacen> list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from almacen");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Almacen(rs.getString("nit"), 
						rs.getString("nombreAlmacen"), 
						rs.getString("sucursal"),
						rs.getString("direccionAlmacen"), 
						rs.getString("nombreGerente"),
						rs.getString("telefonoAlmacen")));
			}
		} catch (Exception e) {
		}
		return list;
	}
	
	public static ObservableList<Pago> getDataPago() {
		Connection conn = ConnectarDb();
		ObservableList<Pago> list = FXCollections.observableArrayList();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from vistapago");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Pago(rs.getString("idPago"), rs.getString("tipoPago")));
			}
		} catch (Exception e) {
		}
		return list;
	}
	
	public static ObservableList<Producto> getDataProducto() {
		Connection conn = ConnectarDb();
		ObservableList<Producto> list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from vistaproducto");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Producto(
						rs.getString("tipoProducto"), 
						rs.getString("codigo"), 
						rs.getString("nombreProducto"),
						rs.getDouble("precio")));
			}
		} catch (Exception e) {
			
		}
		return list;
	}
	
	public static ObservableList<Cajero> getDataCajero	() {
		Connection conn = ConnectarDb();
		ObservableList<Cajero> list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from cajero");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Cajero(
						rs.getString("codigoCajero"), 
						rs.getString("nombreCajero")));
			}
		} catch (Exception e) {
			
		}
		return list;
	}
	
	//////////////Trigger
	public static ObservableList<Registros> getDataRegistros() {
		Connection conn = ConnectarDb();
		ObservableList<Registros> list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from registros");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Registros(rs.getString("nombre"),
						rs.getInt("id"),
						rs.getString("date")));
			}
		} catch (Exception e) {
		}
		return list;
	}
	
	public static Producto buscar_reg(String nombreProducto) {
		Producto pro = null;
		Connection conn = ConnectarDb();
		String sql = "select * from vistaProducto " + "where nombreProducto = '" + nombreProducto + "'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			resultado = ps.executeQuery();

			pro = asignar();

			System.out.println("Correcto");
		} catch (Exception e) {
			System.out.println(" No Correcto");
		}
		return pro;
	}

	public static Producto asignar() {
		Producto pro = null;
		try {
			if (resultado.next()) {
				pro = new Producto(resultado.getString("tipoProducto"), resultado.getString("codigo"),
						resultado.getString("nombreProducto"), resultado.getDouble("precio"));
			}
		} catch (Exception e) {
		}
		return pro;
	}
	

}