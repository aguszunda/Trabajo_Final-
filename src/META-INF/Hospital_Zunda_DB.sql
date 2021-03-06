create database Hospital_Zunda;

use hospital_zunda;

CREATE TABLE PACIENTE(
ID_PACIENTE INT NOT NULL auto_increment,
HC INT,
NOMBRE VARCHAR(50),
TIPO_DNI VARCHAR(25),
DNI INT,
TELEFONO VARCHAR(25),
EMAIL VARCHAR(150),
DOMICILIO VARCHAR(150),
LOCALIDAD VARCHAR(100),
DEPARTAMENTO VARCHAR(100),
PAIS VARCHAR(100),
CONSTRAINT PK_PACIENTE PRIMARY KEY(ID_PACIENTE));

INSERT INTO PACIENTE(HC, NOMBRE, TIPO_DNI, DNI, TELEFONO, EMAIL, DOMICILIO, LOCALIDAD, DEPARTAMENTO, PAIS) 
VALUES (1,'Fernando Agustin', 'DNI', 123456789,'4868829', null, null,null,null, null);
INSERT INTO PACIENTE(HC, NOMBRE, TIPO_DNI, DNI, TELEFONO, EMAIL, DOMICILIO, LOCALIDAD, DEPARTAMENTO, PAIS) 
VALUES (2,'Sofia Orozco', 'DNI', 12121212,'4865800', null, null,null,null, null);
INSERT INTO PACIENTE(HC, NOMBRE, TIPO_DNI, DNI, TELEFONO, EMAIL, DOMICILIO, LOCALIDAD, DEPARTAMENTO, PAIS) 
VALUES (3,'Mauricio Valdivia', 'DNI', 12345454,'4868855', null, null,null,null, null);
INSERT INTO PACIENTE(HC, NOMBRE, TIPO_DNI, DNI, TELEFONO, EMAIL, DOMICILIO, LOCALIDAD, DEPARTAMENTO, PAIS) 
VALUES (4,'Martin Mecodangelo', 'DNI', 15151515,'4658010', null, null,null,null, null);

CREATE TABLE O_SOCIAL(
CODIGO_OOSS INT NOT NULL auto_increment,
NOMBRE VARCHAR(150),
TELEFONO VARCHAR(25),
EMAIL VARCHAR(150),
DOMICILIO VARCHAR(150),
LOCALIDAD VARCHAR(100),
DEPARTAMENTO VARCHAR(100),
PAIS VARCHAR(100),
TIPO VARCHAR(50),
CONSTRAINT PK_OSOCIAL PRIMARY KEY(CODIGO_OOSS));

INSERT INTO o_social(NOMBRE, TELEFONO, EMAIL, DOMICILIO, LOCALIDAD, DEPARTAMENTO, PAIS, TIPO)
VALUES ('OSPACA', '4963-1157 /4805-2750', 'NO PRESENTA', 'ANCHORENA 639/41 1º Piso', 'Ciudad de Buenos Aires', 'Ciudad Autónoma de Buenos Aires','Argentina','OBRA SOCIAL');

INSERT INTO o_social(NOMBRE, TELEFONO, EMAIL, DOMICILIO, LOCALIDAD, DEPARTAMENTO, PAIS, TIPO)
VALUES ('OSITACord.', '0351 4238798', 'NO PRESENTA', 'PARANA 327', 'Cordoba', 'Cordoba','Argentina','PRE-PAGA');

INSERT INTO o_social(NOMBRE, TELEFONO, EMAIL, DOMICILIO, LOCALIDAD, DEPARTAMENTO, PAIS, TIPO)
VALUES ('APROSS', '4344017', 'NO PRESENTA', 'MARCELO T DE ALVEAR 758 B. GUEMES', 'Cordoba', 'Cordoba','Argentina','OBRA SOCIAL');

INSERT INTO o_social(NOMBRE, TELEFONO, EMAIL, DOMICILIO, LOCALIDAD, DEPARTAMENTO, PAIS, TIPO)
VALUES ('OSPACA', '4962-9756 /4962-0590', 'NO PRESENTA', 'ANCHORENA 639/41 1º Piso', 'Ciudad de Buenos Aires', 'Ciudad Autónoma de Buenos Aires','Argentina','PRE-PAGA');

INSERT INTO o_social(NOMBRE, TELEFONO, EMAIL, DOMICILIO, LOCALIDAD, DEPARTAMENTO, PAIS, TIPO)
VALUES ('OSPE', '011-43140499-0460', 'NO PRESENTA', 'AVENIDA L.N.ALEM 692 PB', 'Ciudad de Buenos Aires', 'Ciudad Autónoma de Buenos Aires','Argentina','OBRA SOCIAL');

INSERT INTO o_social(NOMBRE, TELEFONO, EMAIL, DOMICILIO, LOCALIDAD, DEPARTAMENTO, PAIS, TIPO)
VALUES ('OSPIL', '(011)48839200', 'NO PRESENTA', 'AV. H. IRIGOYEN 4054', 'Ciudad de Buenos Aires', 'Ciudad Autónoma de Buenos Aires','Argentina','OBRA SOCIAL');


CREATE TABLE COBERTURA(
NRO_COBERTURA  INT NOT NULL AUTO_INCREMENT,
N_AFILIADO INT,
CODIGO_OOSS INT,
PACIENTE_ID INT,
NOMBRE_PLAN VARCHAR(200),
FECHA_DESDE DATE,
FECHA_HASTA DATE,
CONSTRAINT PK_COBERTURA primary key(NRO_COBERTURA),
CONSTRAINT FK_OSOCIAL foreign key(CODIGO_OOSS) REFERENCES O_SOCIAL(CODIGO_OOSS),
CONSTRAINT FK_PACIENTE foreign key(PACIENTE_ID) REFERENCES PACIENTE(ID_PACIENTE));

