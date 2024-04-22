Drop database if exists Sanrio;
CREATE DATABASE if not exists Sanrio;
use Sanrio;

DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS Trabajador;
DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS Producto;
DROP TABLE IF EXISTS Personaje;
DROP TABLE IF EXISTS Compra;

create table Usuario(
username varchar(30) primary key,
password varchar(30),
telefono int,
email varchar(50),
direccion varchar(30)
);

create table Trabajador(
nss numeric(11),
username varchar(30),
foreign key (username) references Usuario(username)
);

create table Cliente(
num_cuenta Varchar(24),
username varchar(30),
foreign key (username) references Usuario(username)
);

create table Personaje(
codigo Integer,
nombre varchar(15) primary key,
descripcion varchar(255),
cumpleaños date,
curiosidad text,
ruta_foto varchar(100)
);

create table Producto(
cod_producto varchar(6) primary key,
precio DECIMAL(5,2), -- 5 dígitos en total, 2 decimales, max=999,99
descrip_prod varchar (255),
stock integer,
ruta_foto_prod varchar (100),
nombre varchar (15),
foreign key (nombre) REFERENCES Personaje(nombre)
);

create table Compra(
username varchar(30),
cod_producto varchar(6),
fecha_hora datetime primary key,
foreign key (username) references Usuario(username),
foreign key (cod_producto) references Producto(cod_producto)
);


INSERT into Usuario
values
('Olaia','abcd*1234',111222333,'olaialor@gmail.com','Santutxu'),
('Aratz','abcd*1234',112223333,'eguenaratzr@gmail.com','Urduliz'),
('Ruth','abcd*1234',122223333,'lujualandaruth@gmail.com','Algorta'),
('Laura','12345',222222222,'laura12@gmail.com','Leioa'),
('Peio','23456',333333333,'peio31@gmail.com','Basauri');

INSERT INTO Trabajador
values
(72795608040,'Olaia'),
(73935608040,'Aratz'),
(73985608040,'Ruth');

INSERT INTO Cliente
values
('ES1212341234120123456789','Laura'),
('ES8701826112198806479323','Peio');

INSERT into Personaje
values
(1,'Hello Kitty', 'Se la representa como una gata Bobtail japonesa blanca antropomórfica con un lazo rojo en la oreja izquierda.','1974-11-01', 
'Grupo sanguíneo: A. Lugar de nacimiento: Londres. Comida favorita: Tarta de manzana hecha por su madre Mary Kitty', 'img de hello kitty'),
(2,'Kuromi', 'Conejo blanco o criatura parecida a un diablillo que lleva un sombrero de bufón negro.','2005-10-31', 
'Hobbies: Escribir en su diario, cocinar y leer. No le gusta: My Melody', 'img de kuromi'),
(3,'Pom Pom Purin', 'Es un perro Golden Retriever de buen carácter.','1996-04-16', 
'Comida favorita: pudín de su madre. Pompompurin vive en su propia cesta en el vestíbulo de la casa de su hermana propietaria. Le gusta coleccionar zapatos, le gusta esconderlos', 'img del purpurinas'),
(4,'My Melody', 'Es un conejo blanco que lleva una capucha rosa que le cubre las orejas','1975-01-18', 
'Su comimda favorita es el bizcocho de almendras y ella es quien los hornea', 'img de my melody'),
(5,'Keroppi', ' Es una rana verde con ojos grandes. Su boca suele tener forma de V cuando está cerrada.','1988-07-10', 
'Pertenece a una banda donde toca la trompeta', 'img de kuromi'),
(6,'Cinamonroll', ' Es un perro pequeño de pelaje blanco con una cola rizada que se asemeja a un rollo de canela.','2002-03-06', 
'Le gusta comer y sus largas orejas le permiten volar.', 'img de kuromi');

INSERT INTO Producto
values 
('001', 10.99, 'Camiseta Kuromi', 50, '/ruta/a/foto1.jpg','Kuromi'),
('002', 24.99, 'Chandal Hello Kitty', 30, '/ruta/a/foto2.jpg','Hello Kitty'),
('003', 14.50, 'Llavero Pompompurin', 40, '/ruta/a/foto3.jpg','Pom Pom Purin'),
('004', 39.99, 'Sudadera My Melody and Sweet Piano', 20, '/ruta/a/foto4.jpg','My Melody'),
('005', 4.90, 'Pegatinas Keroppi', 100, '/ruta/a/foto5.jpg','Keroppi'),
('006', 25.00, 'Peluche Cinamonroll', 56, '/ruta/a/foto6.jpg','Cinamonroll');

INSERT INTO Compra
values
('Laura', '001', '2024-04-10 10:00:00'),
('Laura', '002', '2024-04-10 11:00:00'),
('Peio', '003', '2024-04-10 12:00:00');
