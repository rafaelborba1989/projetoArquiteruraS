CREATE TABLE vendas (
id bigint(20) NOT NULL AUTO_INCREMENT,
valor decimal(19,2) NOT NULL,
codigo varchar(3) DEFAULT NULL,
idProduto bigint(20) NOT NULL,
idCliente bigint(20) NOT NULL,
PRIMARY KEY (id)
);