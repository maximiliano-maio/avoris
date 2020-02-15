CREATE SCHEMA IF NOT EXISTS productdb;
SET SCHEMA productdb;

CREATE TABLE IF NOT EXISTS productdb.product (
    id    INT PRIMARY KEY AUTO_INCREMENT,
    product_name  VARCHAR(200) NOT NULL,
    category VARCHAR(30) NOT NULL,
    color VARCHAR(20) NOT NULL,
    size  VARCHAR(20) NOT NULL,
    price INT NOT NULL,
    currency VARCHAR(5) NOT NULL,

);

