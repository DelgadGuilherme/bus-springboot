CREATE TABLE usuario (
    id INT NOT NULL,
    nome VARCHAR(90) NOT NULL,
    email VARCHAR(45) NOT NULL,
    telefone VARCHAR(45) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    endereco_id VARCHAR(11) NOT NULL
);

CREATE TABLE endereco (
     id INT NOT NULL,
     logradouro VARCHAR(50) NOT NULL,
     bairro VARCHAR(50) NOT NULL,
     cidade VARCHAR(50) NOT NULL,
     estado VARCHAR(50) NOT NULL
);

CREATE TABLE onibus (
    placa integer NOT NULL,
    vagas VARCHAR(45) NOT NULL,
    localizacao VARCHAR(90) NOT NULL,
    empresa_id integer NOT NULL,
    rota_id integer NOT NULL
);

CREATE TABLE rota (
    id INT NOT NULL,
    horario_saida_terminal TIME NOT NULL,
    horario_chegada_terminal TIME NOT NULL ,
    ponto_id integer NOT NULL
);

CREATE TABLE ponto (
    id INT NOT NULL,
    localizacao VARCHAR(90) NOT NULL
);

CREATE TABLE rotaFavorita (
    id INT NOT NULL AUTO_INCREMENT,
    usuario_id INT,
    rota_id INT
)
