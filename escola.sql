CREATE TABLE aluno (
	nome VARCHAR(50) NOT NULL,
	datanascimento DATE,
	email VARCHAR(30) NOT NULL,
	usuario VARCHAR(20) NOT NULL,
	senha VARCHAR(10) NOT NULL,
	nota DOUBLE
);

CREATE TABLE administrador(
	nome VARCHAR(50) NOT NULL,
	dataNascimento DATE,
	email VARCHAR(30) NOT NULL,
	usuario VARCHAR(20) NOT NULL,
	senha VARCHAR(10) NOT NULL
);

CREATE TABLE professor(
	nome VARCHAR(50) NOT NULL,
	datanascimento DATE,
	email VARCHAR(30) NOT NULL,
	usuario VARCHAR(20) NOT NULL,
	senha VARCHAR(10) NOT NULL
);

INSERT INTO administrador VALUES('Jéssica dos Santos', '1994/02/02', 'jessicadscosta@outlook.com', 'jessica', '1234');