CREATE USER 'pg'@'localhost' IDENTIFIED BY 'pg';
GRANT ALL PRIVILEGES ON payment_gateway.* TO 'pg'@'localhost';

CREATE TABLE Payment (
    paymentId BIGINT NOT NULL PRIMARY KEY,
    refernceId BIGINT NOT NULL,
    paymentAmount DOUBLE NOT NULL,
    processingFee DOUBLE NOT NULL,
    merchantRefNum VARCHAR(255),
    paymentTypeCode VARCHAR(50),
    paymentTypeDescription VARCHAR(255),
    paymentStatus VARCHAR(50) NOT NULL,
    paymenDate DATE
);
