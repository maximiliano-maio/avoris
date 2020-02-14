CREATE SCHEMA IF NOT EXISTS productdb;
SET SCHEMA productdb;

CREATE TABLE IF NOT EXISTS productdb.currencies (
  id INT PRIMARY KEY AUTO_INCREMENT,
  currency VARCHAR(30) NOT NULL,
);

CREATE TABLE IF NOT EXISTS productdb.product (
    id    INT PRIMARY KEY AUTO_INCREMENT,
    product_name  VARCHAR(200) NOT NULL,
    color VARCHAR(20) NOT NULL,
    size  VARCHAR(20) NOT NULL,
    price INT NOT NULL,
    currency_id INT NOT NULL,
    FOREIGN KEY (currency_id) REFERENCES currencies(id),

);

