-- borra la bd si existe
DROP DATABASE IF EXISTS ciberfarma;
-- creamos la bd
CREATE DATABASE ciberfarma;
-- activamos la bd
USE ciberfarma;

create table tb_tipos(
id_tipo  int not null primary key,
des_tipo varchar(20)
);

CREATE TABLE tb_usuarios(
codigo  int auto_increment,
nombre varchar(15),
apellido varchar(25),
usuario  char(4) NOT NULL,
clave    char(5),
fnacim   date  null,
tipo    int DEFAULT 2  ,
estado  int(1) DEFAULT 1,
primary key (codigo),
foreign key(tipo) references tb_tipos (id_tipo)
);

create table tb_categorias(
idtipo		int not null primary key,
descripcion varchar(45)
);

create table tb_productos(
idprod      char(5) not null,
descripcion varchar(45),
stock		int,
precio		decimal(8,2),
idtipo		int,
estado		boolean,
primary key (idprod), 
foreign key (idtipo) references tb_categorias(idtipo)
);

create table tb_cab_boleta(
num_bol    char(5) not null,
fch_bol    date,
cod_cliente  int not null,
cod_vendedor int not null,
total_bol decimal(8,2),
primary key (num_bol),
foreign key (cod_cliente) references tb_usuarios(codigo),
foreign key (cod_vendedor) references tb_usuarios(codigo)
);

create table tb_det_boleta(
num_bol     char(5) not null,
idprod      char(5) not null,
cantidad    int,
preciovta   decimal(8,2),
importe		decimal(8,2),
primary key (num_bol,idprod),
foreign key (num_bol) references tb_cab_boleta(num_bol),
foreign key (idprod) references tb_productos(idprod)
);

-- inserts
insert into tb_tipos values (1, 'Administrador');
insert into tb_tipos values (2, 'Cliente');
insert into tb_tipos values (3, 'Cajero');

insert into tb_usuarios values (1,'Tito', 'Siber','U001', '10001', curdate(),2,1);
insert into tb_usuarios values (2,'Zoila', 'Baca','U002', '10002', curdate(),2,1);
insert into tb_usuarios values (null,'Pedro','Navaja','C001', '10001', curdate(),3,1);
insert into tb_usuarios values (10,'Jose', 'Atuncar','ADMI', 'ADMIN', curdate(),1,1);
insert into tb_usuarios values (null,'Marce', 'Odebrech','CAJA', 'CAJA2', curdate(),3,2);

insert into tb_categorias values (1, 'Pastillas');
insert into tb_categorias values (2, 'Jarabe');
insert into tb_categorias values (3, 'Cremas');
insert into tb_categorias values (4, 'Tocador');
insert into tb_categorias values (5, 'Cuidado');
insert into tb_categorias values (6, 'Otros');

insert into tb_productos values ('P0001','Panadol cj 10',20,1.85,1,1);
insert into tb_productos values ('P0002','Curitas unidad',100,1.0,3,1);
insert into tb_productos values ('P0003','Kita tos',80,15.0,2,1);
insert into tb_productos values ('P0004','Achiz',120,1.0,1,1);
insert into tb_productos values ('P0005','Jaboncillo cj',120,1.0,3,1);
insert into tb_productos values ('P0006','Termometro',80,2.8,5,1);
insert into tb_productos values ('P0007','Panadol jarabe pq',40,10.5,2,1);
insert into tb_productos values ('P0008','Antalgina',55,1.8,1,1);
insert into tb_productos values ('P0009','Ibuprofeno',60,15.0,4,1);
insert into tb_productos values ('P0010','Mejoralito NiÃ±os',10,1.5,1,1);
insert into tb_productos values ('P0011','Panadol jarabe',10,1.5,2,1);
insert into tb_productos values ('P0012','Jabon Neko',40,8.5,4,1);
insert into tb_productos values ('P0013','Pañales x 24u',10,1.5,5,1);
insert into tb_productos values ('P0014','Mejoralito Forte',10,1.5,1,1);
insert into tb_productos values ('P0015','Champu Amigo',50,0.99,5,1);
insert into tb_productos values ('P0016','Mejoralito',10,1.5,4,1);
insert into tb_productos values ('P0017','SinDolor',23,1.5,6,1);
insert into tb_productos values ('P0018','Mejoralito Forte',10,1.5,2,1);
insert into tb_productos values ('P0019','Mejoralito Forte',10,1.5,1,1);
insert into tb_productos values ('P0020','Mejoralito Forte',10,1.5,3,1);
insert into tb_productos values ('P0021','Mejoralito Forte',10,1.5,2,1);
insert into tb_productos values ('P0022','Mejoralito Forte',10,1.5,1,1);
insert into tb_productos values ('P0023','Mejoralito Forte',10,1.5,1,1);
insert into tb_productos values ('P0024','Mejoralito Forte',10,1.5,2,1);
insert into tb_productos values ('P0025','Mejoralito Forte',10,1.5,1,1);
insert into tb_productos values ('P0026','Mejoralito Forte',10,1.5,3,1);
insert into tb_productos values ('P0027','Mejoralito Forte',10,1.5,1,1);
insert into tb_productos values ('P0028','Mejoralito Forte',10,1.5,4,1);
insert into tb_productos values ('P0029','Mejoralito Forte',10,1.5,1,1);
insert into tb_productos values ('P0030','Mejoralito Forte',10,1.5,5,1);
insert into tb_productos values ('P0031','Mejoralito UForte',10,0.99,5,1);

insert into tb_cab_boleta values ('B0001',curdate(), 1, 10, 7.50);

