CREATE USER 'pg'@'localhost' IDENTIFIED BY 'pg';
GRANT ALL PRIVILEGES ON payment_gateway.* TO 'pg'@'localhost';

CREATE TABLE payment (
    payment_id BIGINT NOT NULL PRIMARY KEY,
    reference_id BIGINT NOT NULL,
    payment_amount DOUBLE NOT NULL,
    processing_fee DOUBLE NOT NULL,
    merchant_ref_num VARCHAR(255),
    payment_type_description VARCHAR(255),
    payment_status VARCHAR(50) NOT NULL,
    payment_date DATE
);

ALTER TABLE payment MODIFY COLUMN payment_id BIGINT NOT NULL AUTO_INCREMENT;

