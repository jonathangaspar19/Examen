create table IF NOT EXISTS actores(
    codActor INT IDENTITY PRIMARY KEY,
    lugarNacimiento varchar(25) NOT NULL,
    nomActor varchar(25), 
    apellidos varchar(25)
);

create table IF NOT EXISTS peliculas(
    codPelicula INT IDENTITY PRIMARY KEY,
    titulo varchar(25) NOT NULL,
    ano varchar(25) NOT NULL,
    trailer varchar(25) NOT NULL,
    comentario varchar(25) NOT NULL,
    codDirector varchar(25)
);

create table IF NOT EXISTS directores(
    codDirector INT IDENTITY PRIMARY KEY,
    nomDirector varchar(25) NOT NULL,
    fecNac varchar(25) NOT NULL,
    foto varchar(25) NOT NULL
);

create table IF NOT EXISTS peliculasActores(
    codPelicula INT NOT NULL,
    codActor INT NOT NULL,
    PRIMARY KEY(codPelicula,codActor),
    cache varchar(25) NOT NULL,
    nomPersonaje varchar(25) NOT NULL,
    foto varchar(25) NOT NULL
);

ALTER TABLE peliculasActores
    ADD FOREIGN KEY (codPelicula)
    REFERENCES peliculas(codPelicula);
 ALTER TABLE peliculasActores
    ADD FOREIGN KEY (codActor)
    REFERENCES actores(codActor);