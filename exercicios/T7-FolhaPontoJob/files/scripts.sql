DROP TABLE IF EXISTS funcionario;

CREATE table funcionario (
	matricula INT,
	nome TEXT,
	idade INT,
	primary key(matricula)
);

DROP TABLE IF EXISTS registro_ponto;

CREATE table registro_ponto (
	id INT AUTO_INCREMENT,
	data DATETIME,
	funcionario_id INT,
	primary key(id)
);

DROP TABLE IF EXISTS folha_ponto;

CREATE table folha_ponto (
	id INT AUTO_INCREMENT,
	mes INT,
	ano INT,
	funcionario_id INT,
	registros_ponto TEXT,
	primary key(id)
);

INSERT INTO `funcionario` VALUES ('113883','Lukas Abernathy OK','58'),
('121928','Felicity Jacobson OK','56'),
('122683','Mr. Junius Wintheiser OK','33'),
('171171','Macy Willms NOK','35'),
('184218','Luna Moen IV NOK','35'); 

INSERT INTO `registro_ponto` (data, funcionario_id) VALUES ('2020-05-04 08:00:00', 121928),
('2020-05-04 12:00:00', 121928),
('2020-05-04 14:00:00', 121928),
('2020-05-04 18:00:00', 121928),
('2020-05-05 08:00:00', 121928),
('2020-05-04 12:00:00', 113883),
('2020-05-04 08:00:00', 122683),
('2020-05-05 08:00:00', 122683);

