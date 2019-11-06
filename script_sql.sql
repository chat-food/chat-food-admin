CREATE DATABASE chatfood;
USE chatfood;

CREATE TABLE restaurante (
	id_restaurante INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(64) NOT NULL,
	descricao VARCHAR(256) NULL,
	telefone VARCHAR(30) NOT NULL UNIQUE,
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
	CONSTRAINT fk_id_restaurante FOREIGN KEY (id_restaurante) REFERENCES restaurante(id_restaurante)
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
	CONSTRAINT fk_id_cardapio FOREIGN KEY (id_cardapio) REFERENCES cardapio(id_cardapio)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);

CREATE TABLE cliente (
	id_cliente INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(64) NOT NULL,
	telefone VARCHAR(30) NOT NULL UNIQUE,
	cpf VARCHAR(11) NOT NULL UNIQUE,
	PRIMARY KEY (id_cliente)
);

CREATE TABLE endereco (
	id_endereco INT NOT NULL AUTO_INCREMENT,
	logradouro VARCHAR(45) NOT NULL,
	bairro VARCHAR(45) NOT NULL,
	cidade VARCHAR(45) NOT NULL,
	cep VARCHAR(11) NOT NULL,
	estado VARCHAR(3) NOT NULL,
	complemento VARCHAR(45) NULL,
	id_cliente INT NOT NULL,
	PRIMARY KEY (id_endereco),
	CONSTRAINT id_cliente FOREIGN KEY (id_cliente) REFERENCES chatfood.cliente (id_cliente)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);

CREATE TABLE pedido (
  id_pedido INT NOT NULL AUTO_INCREMENT,
  id_restaurante INT NOT NULL,
  id_cliente INT NOT NULL,
  descricao VARCHAR(256) NULL,
  horario DATETIME NULL,
  status ENUM('aberto', 'preparando', 'finalizado', 'entregue') NULL,
  valor_total DECIMAL(6,2) NULL,
  id_endereco INT NOT NULL,
	PRIMARY KEY (id_pedido),
	CONSTRAINT fk2_id_restaurante FOREIGN KEY (id_restaurante) REFERENCES restaurante(id_restaurante)
		ON DELETE CASCADE
		ON UPDATE NO ACTION,
	CONSTRAINT fk_id_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
		ON DELETE CASCADE
		ON UPDATE NO ACTION,
	CONSTRAINT fk_id_endereco FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);

INSERT INTO cliente (nome, telefone, cpf) VALUES ('Caio Coneglian', '3222-5678','32345567809');
INSERT INTO endereco (logradouro, bairro, cidade, cep, estado, complemento, id_cliente) VALUES ('Rua das Flores', 'Acapulco', 'Marilia', '17500-120', 'SP', '', 1);
INSERT INTO restaurante (nome, descricao, telefone, hora_inicio, hora_fim, senha) VALUES ('ze', 'Hamburgueria do Zé', '+14155238886', '20:00:00', '23:00:00', '123');
INSERT INTO cardapio (id_cardapio, id_restaurante) VALUES (1, 1);
INSERT INTO pedido (id_restaurante, id_cliente, id_endereco, descricao, horario, status, valor_total) VALUES (1, 1, 1, 'Pedido de 2 X-SALADA, 3 X-BACON', '2019-10-20 20:00:00', 'aberto', 60.50);
INSERT INTO item (id_cardapio, nome, preco, descricao) VALUES (1, 'X-SALADA', 10, 'Pão, hamburguer, muçarela, alface e tomate');
INSERT INTO item (id_cardapio, nome, preco, descricao) VALUES (1, 'X-BACON', 10, 'Pão, hamburguer, bacon, muçarela, alface e tomate');