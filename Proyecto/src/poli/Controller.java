package poli.controller;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import poli.model.Almacen;
import poli.model.Cajero;
import poli.model.Conexion;
import poli.model.Consumidor;
import poli.model.Factura;
import poli.model.Pago;
import poli.model.Producto;
import poli.tablas.Registros;


public class Controller implements Initializable{

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	
	@FXML
    private Tab usuario;
    @FXML
    private Tab almacen;
    @FXML
    private Tab producto;
    
    ////////  CONSUMIDOR  ////////
    @FXML
    private TableView<Consumidor> tablaConsumidor;
    @FXML
    private TableColumn<Consumidor, String> colDireccion;
    @FXML
    private TableColumn<Consumidor, Integer> colId;
    @FXML
    private TableColumn<Consumidor, String> colNombre;
    @FXML
    private TableColumn<Consumidor, String> colNumeroTarjeta;
    @FXML
    private TableColumn<Consumidor, String> colPuntos;
    @FXML
    private TableColumn<Consumidor, String> colTelefono;


    @FXML
    private TextField nombreUsuario;
    @FXML
    private TextField numeroTarjetaUsuario;
    @FXML
    private TextField puntosUsuario;
    @FXML
    private TextField idUsuario;  
    @FXML
    private TextField direccionUsuario;
    @FXML
    private TextField numeroUsuario;
    
    ////////  CAJERO  ////////
    @FXML
    private TableView<Cajero> tablaCajero;
    @FXML
    private TableColumn<Cajero, String> colCajero1;
    @FXML
    private TableColumn<Cajero, String> colCajero2;
    
    @FXML
    private TextField idCajero;
    @FXML
    private TextField nombreCajero;
    
    ////////  ALMACEN  ////////
    @FXML
    private TableView<Almacen> tablaAlmacen;
    @FXML
    private TableColumn<Almacen, String> colNit;
    @FXML
    private TableColumn<Almacen, String> colNombreAlmacen;
    @FXML
    private TableColumn<Almacen, String> colNombreGerente;
    @FXML
    private TableColumn<Almacen, String> colSucursal;
    @FXML
    private TableColumn<Almacen, String> coldireccionAlmacen;
    @FXML
    private TableColumn<Almacen, String> colTelefonoAlmacen;   
    
    @FXML
    private TextField nit;
    @FXML
    private TextField nombreAlmacen;
    @FXML
    private TextField sucursal;
    @FXML
    private TextField direccionAlmacen;
    @FXML
    private TextField nombreGerente;
    @FXML
    private TextField telefonoAlmacen;
    
    ////////  PAGO  ////////    
    @FXML
    private TableView<Pago> tablaPago;
    @FXML
    private TableColumn<Pago, String> colIdPago;
    @FXML
    private TableColumn<Pago, String> colTipoPago;
    
    @FXML
    private TextField idPago;
    @FXML
    private TextField tipoPago;
    @FXML
    private RadioButton rbCheque;
    @FXML
    private RadioButton rbEfectivo;
    @FXML
    private RadioButton rbTarjeta;   
    
    ////////  PRODUCTO  ////////
    @FXML
    private TableView<Producto> tablaProducto;
    @FXML
    private TableColumn<Producto, String> colTipoProducto;
    @FXML
    private TableColumn<Producto, String> colCodigo;
    @FXML
    private TableColumn<Producto, String> colNombreProducto;
    @FXML
    private TableColumn<Producto, Double> colPrecio;
    
    @FXML
    private TextField tipoProducto;
    @FXML
    private TextField codigo;
    @FXML
    private TextField nombreProducto;
    @FXML
    private TextField precio;
    
    //////TRIGGER
    @FXML
    private TableView<Registros> tablaRegistros;
    @FXML
    private TableColumn<Registros, String> colregistros1;
    @FXML
    private TableColumn<Registros, Integer> colregistros2;
    @FXML
    private TableColumn<Registros, String> colregistros3;
    
    //FACTURA
    @FXML
    private TextField tfBuscar;
    @FXML
    private TextField tfbuscarFac;
    @FXML
    private TextField numFac;
    @FXML
    private TextField tfCantidad;
    @FXML
    private TextField tftotal;
    @FXML
    private TextField txttotal;
    @FXML
    private TextField txtiva;
    @FXML
    private DatePicker fecha;
    @FXML
    private TextField numero;
    @FXML
    private TextField tfCodigo;
    @FXML
    private TextField txtivafinal;
    @FXML
    private TextArea tablaFinal;
    @FXML
    private TextField tfCliente;
    @FXML
    private Label cliente;
    
    @FXML
    private TableView<Producto> TablaPF;
    @FXML
    private TableView<Producto> tablaCantidad;
    
    @FXML
    private ComboBox<Consumidor> cmbConsumidores;
    @FXML
    private ComboBox<Almacen> cmbAlmacenes;
    @FXML
    private ComboBox<Pago> cmbPagos;
    @FXML
    private ComboBox<Cajero> cmbCajero;
    @FXML
    private ComboBox<Producto> cmbProductos;
    @FXML
    private TableColumn<Producto, String> colC1;
    @FXML
    private TableColumn<Producto, String> colC2;
    @FXML
    private TableColumn<Producto, String> colC3;
    @FXML
    private TableColumn<Producto, Double> colC4;
    @FXML
    private TableColumn<Producto, Integer> colC45;
    @FXML
    private TableColumn<Producto, Integer> colC5;
    
    // Coleccion
 	private ObservableList<Consumidor> listaConsumidor;
 	private ObservableList<Cajero> listaCajero;
 	private ObservableList<Almacen> listaAlmacen;
 	private ObservableList<Pago> listaPago;
 	private ObservableList<Producto> listaProducto;
 	private ObservableList<Registros> listaRegistros;
 	ObservableList<Producto> listaPF = FXCollections.observableArrayList();
 	ObservableList<Producto> listaPFcantidad = FXCollections.observableArrayList();
 	ObservableList<Factura> listaFactura = FXCollections.observableArrayList();
	//////// Selecccion de datos Consumidor ///////
	@FXML
	void getSelected1(MouseEvent event) {
		Consumidor c = this.tablaConsumidor.getSelectionModel().getSelectedItem();
		if (c != null) {
			nombreUsuario.setText(c.getNombreUsuario());
			numeroTarjetaUsuario.setText(c.getNumeroTarjetaUsuario());
			puntosUsuario.setText(c.getPuntosUsuario());
			idUsuario.setText(c.getIdUsuario()+"");
			direccionUsuario.setText(c.getDireccionUsuario());
			numeroUsuario.setText(c.getNumeroUsuario());			
		}
		
	}
	
	////////Actualizar de datos Tabla Consumidor /////// 	
 	public void actualizarTablaConsumidor(){
 		
        colNombre.setCellValueFactory(new PropertyValueFactory<Consumidor,String>("nombreUsuario"));
        colNumeroTarjeta.setCellValueFactory(new PropertyValueFactory<Consumidor,String>("numeroTarjetaUsuario"));
        colPuntos.setCellValueFactory(new PropertyValueFactory<Consumidor,String>("puntosUsuario"));
        colId.setCellValueFactory(new PropertyValueFactory<Consumidor,Integer>("idUsuario"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<Consumidor,String>("direccionUsuario"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<Consumidor,String>("numeroUsuario"));
        
        listaConsumidor = Conexion.getDataConsumidor();
        tablaConsumidor.setItems(listaConsumidor);
        
    }
 	
 	////////Selecccion de datos Cajero ///////
 	@FXML
	void getSelected2(MouseEvent event) {
 		
 		Cajero ca = this.tablaCajero.getSelectionModel().getSelectedItem();
 		if (ca != null) {			
 			idCajero.setText(ca.getIdCajero());
 			nombreCajero.setText(ca.getNombreCajero());			
		}
 		
 	}
 	
	////////Actualizar de datos Tabla Cajero /////// 	
 	public void actualizarTablaCajero(){
 		colCajero1.setCellValueFactory(new PropertyValueFactory<Cajero,String>("idCajero"));
 		colCajero2.setCellValueFactory(new PropertyValueFactory<Cajero,String>("nombreCajero"));
        
        listaCajero = Conexion.getDataCajero();
        tablaCajero.setItems(listaCajero);
 	}
 	
	////////Selecccion de datos Almacen ///////
	@FXML
	void getSelected3(MouseEvent event) {
		
		Almacen a = this.tablaAlmacen.getSelectionModel().getSelectedItem();
		if (a != null) {			
			nit.setText(a.getNit());
			nombreAlmacen.setText(a.getNombreAlmacen());
			sucursal.setText(a.getSucursal());
			direccionAlmacen.setText(a.getDireccionAlmacen());
			nombreGerente.setText(a.getNombreGerente());
			telefonoAlmacen.setText(a.getNombreAlmacen());			
		}
		
	}
 	
	////////Actualizar de datos Tabla Almacen /////// 	
		public void actualizarTablaAlmacen(){
	    colNit.setCellValueFactory(new PropertyValueFactory<Almacen,String>("nit"));
	    colNombreAlmacen.setCellValueFactory(new PropertyValueFactory<Almacen,String>("nombreAlmacen"));
	    colSucursal.setCellValueFactory(new PropertyValueFactory<Almacen,String>("sucursal"));
	    coldireccionAlmacen.setCellValueFactory(new PropertyValueFactory<Almacen,String>("direccionAlmacen"));
	    colNombreGerente.setCellValueFactory(new PropertyValueFactory<Almacen,String>("nombreGerente"));
	    colTelefonoAlmacen.setCellValueFactory(new PropertyValueFactory<Almacen,String>("telefonoAlmacen"));
	    
	    listaAlmacen = Conexion.getDataAlmacen();
	    tablaAlmacen.setItems(listaAlmacen);
	}
		
		////////Selecccion de datos Pago ///////
	@FXML
	void getSelected4(MouseEvent event) {
		
		Pago p = this.tablaPago.getSelectionModel().getSelectedItem();
		if (p != null) {
			idPago.setText(p.getIdPago());
			tipoPago.setText(p.getTipoPago());
		}
		
	}
	
	////////Actualizar de datos Tabla Pago /////// 	
	public void actualizarTablaPago(){
		colIdPago.setCellValueFactory(new PropertyValueFactory<Pago,String>("idPago"));
	    colTipoPago.setCellValueFactory(new PropertyValueFactory<Pago,String>("tipoPago"));
		listaPago = Conexion.getDataPago();
	    tablaPago.setItems(listaPago);
				
	}	
 	
	//////// Selecccion de datos Productos ///////
	@FXML
	void getSelected5(MouseEvent event) {
		Producto pr = this.tablaProducto.getSelectionModel().getSelectedItem();
		if (pr != null) {
			tipoProducto.setText(pr.getTipoProducto());
			codigo.setText(pr.getCodigo());
			nombreProducto.setText(pr.getNombreProducto());
			precio.setText(pr.getPrecio()+"");
		}
		
	}
	
	////////Actualizar de datos Tabla Producto /////// 	
 	public void actualizarTablaProducto(){
        colTipoProducto.setCellValueFactory(new PropertyValueFactory<Producto,String>("tipoProducto"));
        colCodigo.setCellValueFactory(new PropertyValueFactory<Producto,String>("codigo"));
        colNombreProducto.setCellValueFactory(new PropertyValueFactory<Producto,String>("nombreProducto"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<Producto,Double>("precio"));
        
        listaProducto = Conexion.getDataProducto();
        tablaProducto.setItems(listaProducto);
    }
 	
 	
 	////////Actualizar de datos Tabla Registros /////// 	
	public void actualizarTablaRegistros() {
		
		colregistros1.setCellValueFactory(new PropertyValueFactory<Registros, String>("nombre"));
		colregistros2.setCellValueFactory(new PropertyValueFactory<Registros, Integer>("id"));
		colregistros3.setCellValueFactory(new PropertyValueFactory<Registros, String>("date"));

		listaRegistros = Conexion.getDataRegistros();
		tablaRegistros.setItems(listaRegistros);
	}
	
	////////Actualizar de datos Tabla Productos en Factura /////// 	

	
	public void actualizarTablaPFac(){
		colC1.setCellValueFactory(new PropertyValueFactory<Producto,String>("tipoProducto"));
		colC2.setCellValueFactory(new PropertyValueFactory<Producto,String>("codigo"));
		colC3.setCellValueFactory(new PropertyValueFactory<Producto,String>("nombreProducto"));
		colC4.setCellValueFactory(new PropertyValueFactory<Producto,Double>("precio"));
        colC5.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("Cantidad"));
        //listaProducto = Conexion.getDataProducto();
		TablaPF.setItems(listaPF);
    }
		
		/**   QUERYS SQL   */
 	
 	
 	//Insertar
 	public void agregarConsumidor (){    
 		conn = Conexion.ConnectarDb();
        String sql = "INSERT INTO vistaconsumidor ("
				+ "nombreUsuario, numeroTarjetaUsuario, puntosUsuario, idUsuario, direccionUsuario, numeroUsuario) VALUES"
				+ " (?, ?, ?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nombreUsuario.getText());
            pst.setString(2, numeroTarjetaUsuario.getText());
            pst.setString(3, puntosUsuario.getText());
            pst.setString(4, idUsuario.getText());
            pst.setString(5, direccionUsuario.getText());
            pst.setString(6, numeroUsuario.getText());
            pst.execute();
            
            mensajeAdd();		
			actualizarTablaConsumidor();
			actualizarTablaRegistros();
            
        } catch (Exception e) {
        	mensajeError();
        }
        limpiar();
 	}
 	
 	public void guardarRegistroCajero (){
 		
 		conn = Conexion.ConnectarDb();
        String sql = "INSERT INTO cajero ("
				+ "codigoCajero, nombreCajero) VALUES"
				+ " (?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, idCajero.getText());
            pst.setString(2, nombreCajero.getText());
            
            pst.execute();
            
            mensajeAdd();		
			actualizarTablaCajero();
            
        } catch (Exception e) {
        	mensajeError();
        }
        limpiar();
 	}
 	
 	public void guardarRegistroAlmacen (){    
        conn = Conexion.ConnectarDb();
        String sql = "INSERT INTO almacen ("
				+ "nit, nombreAlmacen, sucursal, direccionAlmacen, nombreGerente, telefonoAlmacen) VALUES"
				+ " (?, ?, ?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nit.getText());
            pst.setString(2, nombreAlmacen.getText());
            pst.setString(3, sucursal.getText());
            pst.setString(4, direccionAlmacen.getText());
            pst.setString(5, nombreGerente.getText());
            pst.setString(6, telefonoAlmacen.getText());
            pst.execute();
            
            mensajeAdd();		
			actualizarTablaAlmacen();
            
        } catch (Exception e) {
        	mensajeError();
        }
        limpiar();
 	}
 	//>>>>>>>>>>>>>>>>>>>>
 	public void guardarRegistroPago (){ 
 		 conn = Conexion.ConnectarDb();
         String sql = "INSERT INTO vistapago ("
 				+ "idPago, tipoPago) VALUES"
 				+ " (?, ?)";
         try {
             pst = conn.prepareStatement(sql);
             pst.setString(1, idPago.getText());
             pst.setString(2, tipoPago.getText());
             pst.execute();
             
             mensajeAdd();		
 			 actualizarTablaPago();
             
         } catch (Exception e) {
         	mensajeError();
         }
         limpiar();
 	}
 	
 	public void guardarRegistroProducto (){ 
 		 conn = Conexion.ConnectarDb();
         String sql = "INSERT INTO vistaproducto ("
 				+ "tipoProducto, codigo, nombreProducto, precio) VALUES"
 				+ " (?, ?, ?, ?)";
        
         try {
             pst = conn.prepareStatement(sql);
             pst.setString(1, tipoProducto.getText());
             pst.setString(2, codigo.getText());
             pst.setString(3, nombreProducto.getText());
             pst.setString(4, precio.getText());
             pst.execute();
             
             mensajeAdd();		
 			 actualizarTablaProducto();
             
         } catch (Exception e) {
         	mensajeError();
         }
         limpiar();
 	}
 	
 	public Factura f;
 	
 	public void generarFactura (){ 
 		f = new Factura(Integer.parseInt(numero.getText()), fecha.getValue().toString(),
 				cmbConsumidores.getValue(), cmbCajero.getValue(), cmbAlmacenes.getValue(),
 				cmbPagos.getValue(), listaPF);
 		
 		
 		
		conn = Conexion.ConnectarDb();
        String sql = "INSERT INTO vistafactura ("
				+ "fecha, numero, consumidor, almacen, cajero, tipopago ) VALUES"
				+ " (?, ?, ?, ?, ?, ?)";
 
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, fecha.getValue().toString());
            pst.setString(2, numero.getText());
            pst.setString(3, cmbConsumidores.getValue().toString());
            pst.setString(4, cmbAlmacenes.getValue().toString());
            pst.setString(5, cmbCajero.getValue().toString());
            pst.setString(6, cmbPagos.getValue().toString());
            pst.execute();
                     
            //pst.setString(7, TablaPF.getItems().toString());
            mensajeAdd();		
			//System.err.println(f);            
        } catch (Exception e) {
        	mensajeError();
        }

        
	}
 	
	public void calcularTotal() {
		
		//PRECIO + IVA
		double total = 0;
		double iva = 0;

		try {       
			java.sql.CallableStatement  pcall= null;

			String SQL = "call calcularTotal(?,?)";
			
			pcall = conn.prepareCall(SQL);

			pcall.setString(1, numero.getText());
			pcall.registerOutParameter(2, java.sql.Types.DOUBLE);

			pcall.execute();

			total = pcall.getDouble(2);
			System.out.println(total);
			
			tftotal.setText("       $"+total+"");
			txttotal.setText("          $"+total+"");

		} catch (Exception e) {
			System.err.println("error de registro");
		}
		
		try {       
			java.sql.CallableStatement  pcall= null;

			String SQL = "call calcularIva(?,?)";
			pcall = conn.prepareCall(SQL);

			pcall.setString(1, numero.getText());
			pcall.registerOutParameter(2, java.sql.Types.DOUBLE);

			pcall.execute();

			iva = pcall.getDouble(2);
			System.out.println(iva);
			
			txtiva.setText("              $"+iva+"");
			txtivafinal.setText("      $"+iva+"");

		} catch (Exception e) {
			System.err.println("error de registro");
		}

	 		
	 	}

 	
 	//Update
 	public void actualizarRegistroConsumidor() {
 		
		try {
            conn = Conexion.ConnectarDb();
            		String value1 = nombreUsuario.getText();
            		String value2 = numeroTarjetaUsuario.getText();
            		String value3 = puntosUsuario.getText();
            		String value4 = idUsuario.getText();
            		String value5 = direccionUsuario.getText();
            		String value6 = numeroUsuario.getText();

            String sql = "update vistaconsumidor set nombreUsuario= '"+value1+"',numeroTarjetaUsuario= '"+value2+"',puntosUsuario= '"+
                    value3+"',idUsuario= '"+value4+"',direccionUsuario= '"+value5+"',numeroUsuario= '"+value6+"' where idUsuario='"+value4+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            mensajeUpdate();	
			actualizarTablaConsumidor();
            
        } catch (Exception e) {
        	mensajeError(); 
        }
		limpiar();
    }
 	
 	public void actualizarRegistroCajero() {
 		
 		try {
            conn = Conexion.ConnectarDb();
            		String value1 = idCajero.getText();
            		String value2 = nombreCajero.getText();
            		
            String sql = "update Cajero set nombreCajero= '"+value2+"' where "+" codigoCajero= '"+value1+"'";
            System.out.println(sql);
            pst= conn.prepareStatement(sql);
            pst.execute();
            mensajeUpdate();	
			actualizarTablaCajero();
			
            
        } catch (Exception e) {
        	mensajeError(); 
        }
		limpiar();
 		
 	}
 	
 	public void actualizarRegistroAlmacen() {
		try {
            conn = Conexion.ConnectarDb();
            		String value1 = nit.getText();
            		String value2 = nombreAlmacen.getText();
            		String value3 = sucursal.getText();
            		String value4 = direccionAlmacen.getText();
            		String value5 = nombreGerente.getText();
            		String value6 = telefonoAlmacen.getText();

            String sql = "update almacen set nit= '"+value1+"',nombreAlmacen= '"+value2+"',sucursal= '"+
                    value3+"',direccionAlmacen= '"+value4+"',nombreGerente= '"+value5+"',telefonoAlmacen= '"+value6+"' where nit='"+value1+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            mensajeUpdate();
			actualizarTablaAlmacen();
            
        } catch (Exception e) {
        	mensajeError();
        }
		limpiar();
	}
 	//>>>>>>>>>>>>>>>>>>>>
 	public void actualizarRegistroPago() {
 		try {
            conn = Conexion.ConnectarDb();
            		String value1 = idPago.getText();
            		String value2 = tipoPago.getText();
            String sql = "update vistapago set idPago= '"+value1+"',tipoPago= '"+value2+"' where idPago='"+value1+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            mensajeUpdate();
			actualizarTablaPago();
            
        } catch (Exception e) {
        	mensajeError();
        }
 		limpiar();
 	}
 	
 	public void actualizarRegistroProducto (){ 
 		try {
            conn = Conexion.ConnectarDb();
            		String value1 = tipoProducto.getText();
            		String value2 = codigo.getText();
            		String value3 = nombreProducto.getText();
            		String value4 = precio.getText();

            String sql = "update vistaproducto set tipoProducto= '"+value1+"',codigo= '"+value2+"',nombreProducto= '"+
                    value3+"',precio= '"+value4+"'where codigo='"+value2+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            mensajeUpdate();
			actualizarTablaProducto();
            
        } catch (Exception e) {
        	mensajeError();
        }
 		limpiar();
 	}
 	
 
 	//Delete
 	
 	public void eliminarFactura() {
 		
        try {
        	conn = Conexion.ConnectarDb();
     		String sql = "DELETE FROM factura WHERE numero= ?";
     		
            pst = conn.prepareStatement(sql);
            pst.setString(1, numFac.getText());
            
            pst.execute();
            
            mensajeDelete();		
			System.out.println(sql);
            
        } catch (Exception e) {
        	mensajeError();
        }
        limpiar();
        numFac.setText(null);
        tfCliente.setText(null);
 		
 		
	}

 	public void eliminarRegistroConsumidor() {
 		
	}
	
 	public void eliminarRegistroAlmacen() {
		
	}
 	//>>>>>>>>>>>>>>>>>>>>
 	public void eliminarRegistroPago() {
 		
 	}
		
	public void limpiar() {
		//Consumidor
    	nombreUsuario.setText(null);
    	numeroTarjetaUsuario.setText(null);
    	puntosUsuario.setText(null);
    	direccionUsuario.setText(null);
    	numeroUsuario.setText(null);
    	idUsuario.setText(null);
    	//Cajero
    	idCajero.setText(null);
    	nombreCajero.setText(null);
    	//Almacen
    	nit.setText(null);
    	nombreAlmacen.setText(null);
    	sucursal.setText(null);
    	direccionAlmacen.setText(null);
    	nombreGerente.setText(null);
    	telefonoAlmacen.setText(null);
    	//Pago
    	idPago.setText(null);
    	tipoPago.setText(null);
    	//Producto
    	tipoProducto.setText(null);
    	codigo.setText(null);
    	nombreProducto.setText(null);
    	precio.setText(null);
    	//Factura
    	
    	
    	tftotal.setText(null);
    	txtiva.setText(null);
    	fecha.setValue(null);
    	numero.setText(null);
    	
    	cmbAlmacenes.getItems().clear();
    	cmbCajero.getItems().clear();
    	cmbConsumidores.getItems().clear();
    	cmbPagos.getItems().clear();
    	
    	initialize(null, null);
    	
    	TablaPF.getItems().clear();
    	tablaCantidad.getItems().clear();
	}
	
	public void guardarlista (){ 
		conn = Conexion.ConnectarDb();
		String sql = "INSERT INTO vistaregistra ("
 				+ "cantidad, numero, codigo) VALUES"
 				+ " (?, ?, ?)";
         try {
             pst = conn.prepareStatement(sql);
             pst.setString(1, tfCantidad.getText());
             pst.setString(2, numero.getText());
             pst.setString(3, tfCodigo.getText());
             pst.execute();
             	             
         } catch (Exception e) {
         	mensajeError();
         	System.err.println("Error en Registra");
         }
		}
	
	
		@FXML
		void buscar(ActionEvent event) {
			
			
			String nombreProducto = tfBuscar.getText();
			int cantidad = Integer.parseInt(tfCantidad.getText());
			Producto pro = Conexion.buscar_reg(nombreProducto);
			Producto proc = new Producto(cantidad);
			if (pro != null && proc != null ) {
				listaPF.add(pro);
				mostrar(pro);
				listaPFcantidad.add(proc);
				tablaCantidad.setItems(listaPFcantidad);				
			} 
		
			guardarlista ();
			tfBuscar.setText(null);
	    	tfCantidad.setText(null);
		}
		
		@FXML
		void buscarFac(ActionEvent event) {
			
	
			int numero = Integer.parseInt(tfbuscarFac.getText());
			Factura fac = Conexion.buscar_Fac(numero);
			if (fac == null) {
				Alert mensaje = new Alert(AlertType.INFORMATION);
				mensaje.setTitle("Resultado");
				mensaje.setHeaderText("No existe ese número de factura");
				mensaje.show();	
			} else {
				listaFactura.add(fac);
				mostrarFac(fac);
				for (Iterator iterator = listaFactura.iterator(); iterator.hasNext();) {
					Factura factura = (Factura) iterator.next();
					System.out.println(factura);
					
				}
			}
			
		}
		
		public void mostrarFac(Factura fac){
			numFac.setText(fac.getNumero()+"");
			tfCliente.setText(fac.getConsumidor().toString());
				        
		}
		
		public void mostrar(Producto pro){
			tfCodigo.setText(pro.getCodigo());	        
		}
		@FXML
		    void imprimirFactura(ActionEvent event) {

		 
		 tablaFinal.setText(f.mostrarFac());
		 System.out.println(f);
		 
		    }


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		actualizarTablaConsumidor();
		actualizarTablaAlmacen();
		actualizarTablaPago();
		actualizarTablaProducto();
		actualizarTablaCajero();
		actualizarTablaPFac();
		actualizarTablaRegistros();
		
		
		cmbConsumidores.setItems(listaConsumidor);
		cmbAlmacenes.setItems(listaAlmacen);
		cmbPagos.setItems(listaPago);
		cmbCajero.setItems(listaCajero);
		
		
		
	}
	
	public void mensajeAdd(){
		Alert mensaje = new Alert(AlertType.INFORMATION);
		mensaje.setTitle("Resultado");
		mensaje.setHeaderText("Dato registrado");
		mensaje.show();	
	}
	
	public void mensajeUpdate(){
		Alert mensaje = new Alert(AlertType.INFORMATION);
		mensaje.setTitle("Resultado");
		mensaje.setHeaderText("Dato actualizado");
		mensaje.show();	
	}
	
	public void mensajeDelete(){
		Alert mensaje = new Alert(AlertType.INFORMATION);
		mensaje.setTitle("Resultado");
		mensaje.setHeaderText("Dato eliminado");
		mensaje.show();	
	}
	
	public void mensajeError(){
		Alert mensaje = new Alert(AlertType.INFORMATION);
		mensaje.setTitle("Resultado");
		mensaje.setHeaderText("Error al realizar cambio");
		mensaje.show();	
	}
	
    @FXML
    void mostrarTablaConsumidor(ActionEvent event) {

    }
	
}