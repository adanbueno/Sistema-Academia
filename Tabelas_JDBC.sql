CREATE TABLE academia(
	id SERIAL NOT NULL,
	telefone1 BIGINT NOT NULL,
	rua VARCHAR,
	num_casa VARCHAR,
	cidade VARCHAR,
	estado VARCHAR,
		PRIMARY KEY (id)
);

CREATE TABLE equipamento(
	id SERIAL NOT NULL UNIQUE,
	nome VARCHAR,
	tipo VARCHAR,
		PRIMARY KEY(id),
		CONSTRAINT tipo CHECK(tipo = ANY (ARRAY['mmii', 'mmss', 'aeróbico', 'geral']))
);

CREATE TABLE academia_possui(
	id_academia INTEGER NOT NULL,
	id_maquina INTEGER NOT NULL,
	quantidade INTEGER NOT NULL CHECK(quantidade > 0),
		PRIMARY KEY(id_academia, id_maquina),
		FOREIGN KEY (id_academia) REFERENCES academia(id),
		FOREIGN KEY (id_maquina) REFERENCES equipamento(id)
);

CREATE TABLE manutencao(
	id SERIAL NOT NULL,
	id_academia INTEGER,
	descricao VARCHAR,
	valor INTEGER,
	data_manutencao DATE,
		PRIMARY KEY (id, id_academia),
		FOREIGN KEY (id_academia) REFERENCES academia(id)
);

CREATE TABLE funcionario(
	id SERIAL NOT NULL,
	cpf BIGINT NOT NULL UNIQUE,
	nome VARCHAR,
	id_academia INTEGER NOT NULL,
	tipo VARCHAR,
	salario INTEGER NOT NULL,
	telefone1 BIGINT NOT NULL,
	rua VARCHAR,
	num_casa INTEGER,
	cidade VARCHAR,
		PRIMARY KEY (id),
		FOREIGN KEY (id_academia) REFERENCES academia (id),
		CONSTRAINT tipo CHECK (tipo = ANY(ARRAY['enfermeiro', 'instrutor', 'zelador', 'recepcao']))
);

CREATE TABLE ponto(
	id_funcionario INTEGER NOT NULL,
	data_ponto DATE,
		PRIMARY KEY(id_funcionario, data_ponto),
		FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
);

CREATE TABLE cliente(
	id SERIAL NOT NULL,
	cpf BIGINT NOT NULL UNIQUE,
	nome VARCHAR,
	id_academia INTEGER NOT NULL,
	objetivo VARCHAR,
	mensalidade INTEGER NOT NULL,
	data_prox_pag DATE,
	telefone1 BIGINT,
	dat_nasc DATE,
	rua VARCHAR,
	num_casa INTEGER,
	cidade VARCHAR,
		PRIMARY KEY (id),
		CONSTRAINT mensalidade CHECK (mensalidade >= 50),
		FOREIGN KEY (id_academia) REFERENCES academia(id),
		CONSTRAINT objetivo CHECK (objetivo = ANY(ARRAY['hipertrofia', 'força', 'potência', 'resistencia']))
);