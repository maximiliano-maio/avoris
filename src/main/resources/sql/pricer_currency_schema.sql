CREATE TABLE IF NOT EXISTS price_currency {
  price_curr_id BIGINT AUTO_INCREMENT,
  price_curr VARCHAR(30) NOT NULL,
  PRIMARY KEY (price_curr_id)   
};