CREATE DATABASE chatfood;
USE chatfood;

CREATE TABLE restaurante (
	id_restaurante INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(64) NOT NULL,
	descricao VARCHAR(256) NULL,
	telefone VARCHAR(12) NOT NULL,
	hora_inicio TIME NULL,
	hora_fim TIME NULL,
	senha VARCHAR(64) NULL,
	PRIMARY KEY (id_restaurante),
	UNIQUE INDEX nome_UNIQUE (nome ASC)
);

CREATE TABLE cardapio (
	id_cardapio INT NOT NULL AUTO_INCREMENT,
	id_restaurante INT NULL,
	PRIMARY KEY (id_cardapio),
	CONSTRAINT id_restaurante FOREIGN KEY (id_restaurante) REFERENCES chatfood.restaurante (id_restaurante)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);

CREATE TABLE item (
	id_item INT NOT NULL AUTO_INCREMENT,
	id_cardapio INT NULL,
	nome VARCHAR(45) NULL,
	preco DECIMAL(5,2) NULL,
	descricao VARCHAR(64) NULL,
	PRIMARY KEY (id_item),
	CONSTRAINT id_cardapio FOREIGN KEY (id_cardapio) REFERENCES chatfood.cardapio (id_cardapio)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);

CREATE TABLE pedido (
	id_pedido INT NOT NULL AUTO_INCREMENT,
	id_restaurante INT NULL,
	id_cliente INT NULL,
	id_endereco INT NULL,
	descricao VARCHAR(256) NULL,
	valor_total DECIMAL(5,2) NULL,
	PRIMARY KEY (id_pedido),
	CONSTRAINT id_restaurante FOREIGN KEY (id_restaurante) REFERENCES chatfood.restaurante (id_restaurante)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);

CREATE TABLE cliente (
	id_cliente INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(64) NULL,
	telefone VARCHAR(12) NULL,
	PRIMARY KEY (id_cliente)
);

CREATE TABLE endereco (
	id_endereco INT NOT NULL AUTO_INCREMENT,
	logradouro VARCHAR(45) NULL,
	bairro VARCHAR(45) NULL,
	cidade VARCHAR(45) NULL,
	cep VARCHAR(11) NULL,
	estado VARCHAR(3) NULL,
	complemento VARCHAR(45) NULL,
	id_cliente INT NULL,
	PRIMARY KEY (id_endereco),
	CONSTRAINT id_cliente FOREIGN KEY (id_cliente) REFERENCES chatfood.cliente (id_cliente)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);

INSERT INTO cliente (nome, telefone) VALUES ('Caio Coneglian', '3222-5678');
INSERT INTO endereco (logradouro, bairro, cidade, cep, estado, complemento, id_cliente) VALUES ('Rua das Flores', 'Acapulco', 'Marilia', '17500-120', 'SP', '', 1);
INSERT INTO restaurante (nome, descricao, telefone, hora_inicio, hora_fim, senha) VALUES ('Lanche do Zé', 'Hamburgueria do Zé', '3560-8585', '20:00:00', '23:00:00', '123');
INSERT INTO cardapio (id_cardapio, id_restaurante) VALUES (1, 1);
INSERT INTO pedido (id_restaurante, id_cliente, id_endereco, descricao, valor_total) VALUES (1, 1, 1, 'Pedido de 2 X-SALADA, 3 X-BACON', 60.50);
INSERT INTO item (id_cardapio, nome, preco, descricao) VALUES (1, 'X-SALADA', 10, 'Pão, hamburguer, muçarela, alface e tomate');
INSERT INTO item (id_cardapio, nome, preco, descricao) VALUES (1, 'X-BACON', 10, 'Pão, hamburguer, bacon, muçarela, alface e tomate');