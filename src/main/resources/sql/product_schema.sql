CREATE TABLE IF NOT EXISTS product (
    id    BIGINT AUTO_INCREMENT,
    product_name  VARCHAR(100) NOT NULL,
    color VARCHAR(20) NOT NULL,
    size_id  VARCHAR(20) NOT NULL,
    price FLOAT NOT NULL,
    category_id  VARCHAR(30) NOT NULL,
    price_curr_id BIGINT,
    PRIMARY KEY(id),
    FOREIGN KEY (category_id) REFERENCES category(category_id)
    FOREIGN KEY (price_curr_id) REFERENCES price_currency(price_curr_id)
    FOREIGN KEY (size_id) REFERENCES size(size_id)

);







