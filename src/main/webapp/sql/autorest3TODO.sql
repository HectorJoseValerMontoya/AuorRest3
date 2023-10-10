drop database autorest3;
create database autorest3;
use autorest3;

-- ----------------------------------------------------------

create table cliente(
	codCliente int not null auto_increment,
    nombreCliente varchar(30) not null,
    apellidoCliente varchar(30) not null,
    dni varchar(8) not null,
    primary key(codCliente)
);

INSERT INTO cliente VALUES
(null, 'Nombre', 'Apellido', '00000000');

-- ----------------------------------------------------------


create table perfilEmpleado(
	codPerfilEmpleado int not null auto_increment,
    cargo varchar(20) not null,
    estadoPerfilEmpleado int default 1,
    primary key(codPerfilEmpleado)
) auto_increment = 1;


INSERT INTO perfilEmpleado  VALUES
(null, 'Admin', default),
(null, 'Empleado', default);

select * from perfilEMPLEADO;

create table empleado(
	codEmpleado int not null auto_increment,
    nombreEmpleado varchar(100) not null,
    apellidoEmpleado varchar(100) not null,
	contra varchar(100) not null,
    codPerfilEmpleado int not null,
    estadoEmpleado int default 1,
    primary key(codEmpleado),
    foreign key(codPerfilEmpleado) references perfilEmpleado(codPerfilEmpleado)
) auto_increment = 1001;


INSERT INTO empleado VALUES
(null, 'nombreAdministrador', 'apellidoAdministrador', 'admin', 1, default),
(null, 'Axel', 'Gutierrez', '1234', 1, default);

select * from EMPLEADO;


-- ----------------------------------------------------------

create table CategoriaPlato(
	codCategoriaPlato int not null auto_increment,
	nombreCategoria varchar(30) not null,
	estadoCategoria int not null default 1,
  primary key(codCategoriaPlato)
);

INSERT INTO CategoriaPlato VALUES
(null, 'BRASAS', default),
(null, 'COMPLEMENTOS', default),
(null, 'BEBIDAS', default),
(null, 'FRITURAS', default);



create table plato (
	codPlato int auto_increment,
    nombrePlato varchar(30) not null,
    precioPlato double not null,
    codCategoriaPlato int not null,
    estadoPlato int default 1 not null,
    imagenPlato varchar(100) default null,
    primary key(codPlato),
    foreign key(codCategoriaPlato) references categoriaPlato(codCategoriaPlato)
);

INSERT INTO plato VALUES
(null, '1/4 Pollo a la brasa', 		50, 1, default, NULL),
(null, '1/2 Pollo a la brasa', 		25, 1, default, NULL),
(null, '1 Pollo a la brasa', 		15, 1, default, NULL),
(null, 'Inka Cola 1L', 				5, 	3, default, NULL),
(null, 'Porción de arroz pequeña', 	4, 	2, default, NULL),
(null, 'Porción de arroz grande', 	8, 	2, default, NULL),
(null, 'Salchipapa', 				3, 	4, default, NULL);


-- --------------------------------------------------------



CREATE TABLE mesa (
  codMesa int NOT NULL auto_increment,
  descripcion varchar(50) DEFAULT NULL,
  estadoMesa int default 1,
  primary key(codMesa)
);

insert into mesa values 
(null, 'Primer piso', default),
(null, 'Primer piso', default),
(null, 'Primer piso', default),
(null, 'Segundo piso', default),
(null, 'Segundo piso', default);


create table orden(
	codOrden int not null auto_increment,
    codMesa int not null,
    codEmpleado int not null,
    primary key(codOrden),
    foreign key(codMesa) references mesa(codMesa),
    foreign key(codEmpleado) references empleado(codEmpleado)
);


create table detalleOrden(
	codDetalleOrden int not null auto_increment,
    codOrden int not null,
    codPlato int not null,
    cantidad int not null,
    primary key(codDetalleOrden),
    foreign key (codOrden) references orden(codOrden),
    foreign key (codPlato) references plato(codPlato)
);

-- --------------------------------------------------------





-- -------------------------------------------------------- PROCEDURES

-- -------------------------------------------------------- PROCEDURES

-- -------------------------------------------------------- PROCEDURES

delimiter $$
create procedure registrarEmpleado(nombre varchar(100), apellido varchar(100), contra varchar(100), codPerfil int)
begin
insert into empleado values (null, nombre, apellido, contra, codPerfil, default);
end$$
 
 
delimiter $$
create procedure registrarPerfilEmpleado(cargo varchar(20))
begin
insert into perfilEmpleado values (null, cargo, default);
end$$
-- -----------------
delimiter $$
create procedure mostrarTodosLosDatosDeEmpleadoYPerfil()
begin
select * from empleado e inner join perfilEmpleado pe on e.codPerfilEmpleado = pe.codPerfilEmpleado;
end$$



delimiter $$
create procedure datosEmpleadoConPerfilEmpleado(_codEmpleado int)
begin
select * from empleado e inner join perfilEmpleado pe on e.codPerfilEmpleado = pe.codPerfilEmpleado where codEmpleado = _codEmpleado;
end$$

-- -----------------


delimiter $$
create procedure mostrarTodosLosDatosDePlatos()
begin
select * from plato p inner join CategoriaPlato cp on p.codCategoriaPlato = cp.codCategoriaPlato;
end$$

delimiter $$
create procedure mostrarTodosLosDatosDePlatosActivos()
begin
select * from plato p inner join CategoriaPlato cp on p.codCategoriaPlato = cp.codCategoriaPlato where estadoPlato = 1;
end$$



delimiter $$
create procedure mostrarTodosLosDatosDeUnPlato(_codPlato int)
begin
select * from plato p inner join CategoriaPlato cp on p.codCategoriaPlato = cp.codCategoriaPlato where codPlato = _codPlato;
end$$
-- -----------------
delimiter $$
create procedure mostrarTodosLosDatosDeCategoriaPlatos()
begin
select * from CategoriaPlato;
end$$

delimiter $$
create procedure mostrarTodosLosDatosDeCategoriaPlatosActivos()
begin
select * from CategoriaPlato where estadoCategoria = 1;
end$$

select * from categoriaPlato;

delimiter $$
create procedure mostrarTodosLosDatosDeUnCategoriaPlato(_codCategoriaPlato int)
begin
select * from CategoriaPlato where codCategoriaPlato = _codCategoriaPlato;
end$$
-- -----------------

delimiter $$
create procedure cargoEmpleado(_codEmpleado int)
begin
select cargo from empleado e inner join perfilEmpleado pe on e.codPerfilEmpleado = pe.codPerfilEmpleado where codEmpleado = _codEmpleado;
end$$

delimiter $$
create procedure nombreTipoCategoria(_codCategoriaPlato int)
begin
select nombreCategoria from categoriaPlato where codCategoriaPlato =  _codCategoriaPlato;
end$$

select *  from categoriaPlato;

delimiter $$
create procedure eliminarEmpleado(_codEmpleado int)
begin
update empleado set estadoEmpleado = 2 where codEmpleado = _codEmpleado;
end$$


delimiter $$
create procedure eliminarCategoriaPlato(_codCategoriaPlato int)
begin
update categoriaPlato set estadoCategoria = 2 where codCategoriaPlato = _codCategoriaPlato;
update plato set estadoPlato = 2 where codCategoriaPlato = _codCategoriaPlato;
end$$

select * from categoriaPlato;
select * from plato;

delimiter $$
create procedure actualizarEmpleado(nombre varchar(100), apellido varchar(100), contra varchar(100), codPerfil int, estado int, _codEmpleado int)
begin
update empleado set nombreEmpleado = nombre, apellidoEmpleado = apellido, contra = contra, codPerfilEmpleado = codPerfil, estadoEmpleado = estado where codEmpleado = _codEmpleado;
end$$

delimiter $$
create procedure actualizarPerfilEmpleado(_cargo varchar(20), _estadoPerfilEmpleado int, _codPerfilEmpleado int)
begin
update perfilEmpleado set cargo = _cargo, estadoPerfilEmpleado = _estadoPerfilEmpleado where codPerfilEmpleado = _codPerfilEmpleado;
end$$

delimiter $$
create procedure actualizarPlato(_nombrePlato varchar(30), _precioPlato double, _codCategoriaPlato int, _codPlato int)
begin
update plato set nombrePlato = _nombrePlato, precioPlato = _precioPlato, codCategoriaPlato = _codCategoriaPlato where codPlato = _codPlato;
end$$

select * from plato;

delimiter $$
create procedure eliminarPerfilEmpleado(_codPerfilEmpleado int)
begin
update perfilEmpleado set estadoPerfilEmpleado = 2 where codPerfilEmpleado = _codPerfilEmpleado;
update empleado set estadoEmpleado = 2 where codPerfilEmpleado = _codPerfilEmpleado;
end$$


delimiter $$
create procedure eliminarPlato(_codPlato int)
begin
update plato set estadoPlato = 2 where codPlato = _codPlato;
end$$

select * from plato;

select * from categoriaPlato;


-- <<<<<<<<<<<<Consultas y Actualizaciones>>>>>>>>>>>>>

#update empleado set nombreEmpleado = "Hola", apellidoEmpleado = "Ape", contra = "contra", codPerfilEmpleado = 2 where codEmpleado = 1001;
#update empleado set estadoEmpleado = 2 where codEmpleado = 1001;
#update empleado set nombreEmpleado = "Hola" where codEmpleado = 1001;

select contra from empleado where CodEmpleado = 1001;

SELECT

select max(codPlato) + 1 from plato;
