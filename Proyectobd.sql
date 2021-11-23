/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`facturabd` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `facturabd`;

DROP TABLE IF EXISTS `almacen`;

CREATE TABLE almacen
(
  nit CHAR(15),
  nombreAlmacen VARCHAR(30),
  sucursal VARCHAR(30),
  direccionAlmacen VARCHAR(70),
  nombreGerente VARCHAR(50),
  telefonoAlmacen VARCHAR(15),
  PRIMARY KEY (nit)
);

insert into almacen values
('1000-1','Olimpica','Suba','Ave Suba # 86-02','Pablo Perez','3126457');

DROP TABLE IF EXISTS `factura`;
CREATE TABLE factura
(
  fecha DATE,
  numero INT,
  consumidor varchar (50),
  almacen varchar (50),
  cajero varchar (50),
  tipopago varchar (50),
  producto varchar (50),
  cantidad INT,  
  PRIMARY KEY (numero)
);

insert into factura values
(null,0,null,null,null,null,null,null);


DROP TABLE IF EXISTS `producto`;
CREATE TABLE producto
(
  tipoProducto VARCHAR(30),
  codigo CHAR(20),
  nombreProducto VARCHAR(30),
  precio FLOAT,
  numero INT,
  PRIMARY KEY (codigo),
  FOREIGN KEY (numero) REFERENCES Factura(numero)
);

insert into producto values
('Alimento','a001','Arroz',1500,null),
('Alimento','a002','Aceite',25000,null),
('Alimento','a003','Manzana',8000,null),
('Alimento','a004','Banano',2000,null),
('Alimento','a005','Huevos',450,null),
('Alimento','a006','Queso',4300,null),
('Alimento','a007','Carne',11000,null),
('Alimento','a008','Pollo',7500,null),
('Alimento','a009','Pescado',8000,null),
('Alimento','a010','Lenteja',2500,null),
('Alimento','a011','Pasta',2300,null),
('Aseo','as001','Crema Dental',2300,null),
('Aseo','as002','Jabon',2300,null),
('Aseo','as003','Cepillo de Dientes',2600,null),
('Aseo','as004','Shampoo',18400,null),
('Aseo','as005','Blanqueador',4500,null),
('Aseo','as006','Trapero',2300,null),
('Electronico','e001','Radio',75500,null),
('Electronico','e002','Mouse',45000,null),
('Electronico','e003','Audifonos',36700,null),
('Electronico','e004','Plancha',65500,null);

DROP TABLE IF EXISTS `Registra`;
CREATE TABLE Registra
(
  cantidad INT,
  numero INT,
  codigo CHAR(20)
);

DROP TABLE IF EXISTS `TipoPago`;
CREATE TABLE Pago
(
  idPago VARCHAR(15),
  TipoPago VARCHAR(15),
  numero INT,
  PRIMARY KEY (idPago),
  FOREIGN KEY (numero) REFERENCES Factura(numero)
);

insert into pago values ('A01','Efectivo', null);

DROP TABLE IF EXISTS `consumidor`;
CREATE TABLE consumidor
(
  nombreUsuario VARCHAR(50),
  numeroTarjetaUsuario VARCHAR(20),
  puntosUsuario VARCHAR(15),
  idUsuario INT NOT NULL,
  direccionUsuario VARCHAR(60),
  numeroUsuario VARCHAR(15),
  numero INT,
  PRIMARY KEY (idUsuario),
  FOREIGN KEY (numero) REFERENCES Factura(numero)
);

insert into consumidor values
('Jose','A001','100',1001,'Suba','3126457',null);

DROP TABLE IF EXISTS `cajero`;
CREATE TABLE cajero
(
  codigoCajero VARCHAR(50),
  nombreCajero VARCHAR(20),
  PRIMARY KEY (codigoCajero)
);

insert into cajero values
('101','Juan'),
('102','Paula');

/*Vistas */
create view vistaconsumidor as
select c.nombreUsuario, c.numeroTarjetaUsuario, c.puntosUsuario,
c.idUsuario, c.direccionUsuario, c.numeroUsuario
from consumidor c;

create view vistapago as
select p.idPago, p.tipoPago
from Pago p;

create view vistaproducto as
select b.tipoproducto, b.codigo,
b.nombreproducto, b.precio
from producto b;

create view vistafactura as
select f.fecha, f.numero,  f.consumidor,
f.almacen, f.cajero, f.tipopago
from factura f;

create view vistaregistra as
  select r.cantidad, r.numero, r.codigo
  from 
  registra r;
  
 



/*Trigger*/

create table Registros
(
	nombre varchar(50),
    id INT,
    date varchar(50)
);

/* TRIGGER */

delimiter **
create trigger trigger1
after insert on consumidor
for each row
begin
    insert into registros values
    (new.nombreUsuario, new.idUsuario,  now());
   
end **
delimiter ;

/*  STORAGE PROCEDURE */
DELIMITER //
CREATE PROCEDURE CALCULARIVA()
BEGIN
	DECLARE var_final BOOLEAN DEFAULT FALSE;
	DECLARE IVA FLOAT DEFAULT 0;
    DECLARE CURSORSTRPRECIO FLOAT DEFAULT 0;
    
	DECLARE CURSOR1 CURSOR FOR
	SELECT PRECIO FROM PRODUCTO WHERE TIPOPRODUCTO <> 'Alimento' ;
	
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET var_final = TRUE;
    
    OPEN CURSOR1;
    BUCLE : LOOP
		FETCH CURSOR1 INTO CURSORSTRPRECIO;
		IF var_final THEN
			LEAVE bucle;
		END IF;
		        SET IVA = (IVA + CURSORSTRPRECIO*0.19);
        
    END LOOP BUCLE;
    CLOSE CURSOR1;
    
    SELECT IVA;
    
END //
DELIMITER ;

CALL CALCULARIVA();

select * from registros;


/*
select * from vistaconsumidor;
select * from vistapago;
select * from vistaproducto;
select * from producto;
select * from almacen;


select * from factura;
select * from consumidor;
select * from almacen;
select * from pago;

select * from registros;

drop table registros;
drop view view1;

