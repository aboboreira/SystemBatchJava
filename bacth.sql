CREATE DATABASE	 db_custumer;

CREATE TABLE `db_custumer`.`tb_custumer_account` (
  `id_custumer` INT NOT NULL AUTO_INCREMENT,
  `cpf_cnpj` VARCHAR(20) NOT NULL,
  `nm_custumer` VARCHAR(45) NOT NULL,
  `is_active` BIT NOT NULL,
  `vl_total` DECIMAL NOT NULL,
  PRIMARY KEY (`id_custumer`));

-- SELECT * FROM tb_custumer_account;

-- SELECT * FROM tb_custumer_account WHERE vl_total > 560;

-- SELECT * FROM tb_custumer_account WHERE id_custumer BETWEEN 1500 and 2700;

-- SELECT * FROM tb_custumer_account WHERE vl_total > 560 and id_custumer BETWEEN 1500 and 2700;

-- SELECT AVG(vl_total) FROM tb_custumer_account  WHERE vl_total > 560 and id_custumer BETWEEN 1500 and 2700;

         
-- SELECT AVG(vl_total) AS media  FROM tb_custumer_account WHERE vl_total > 560 and id_custumer BETWEEN 1500 and 2700;
 
 -- SELECT  id_custumer , cpf_cnpj , nm_custumer , is_active, vl_total  FROM tb_custumer_account WHERE vl_total > 560 and id_custumer BETWEEN 1500 and 2700 ORDER BY vl_total desc;