DROP TABLE IF EXISTS prices;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS product;

CREATE TABLE brand
(
    id   bigint      NOT NULL AUTO_INCREMENT,
    name varchar(40) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE product
(
    id   bigint      NOT NULL AUTO_INCREMENT,
    name varchar(40) NOT NULL,
    code bigint NOT NULL unique,
    PRIMARY KEY (id)
);

CREATE TABLE prices
(
    id         bigint     NOT NULL AUTO_INCREMENT,
    brand_id   bigint     NOT NULL,
    product_id bigint     NOT NULL,
    price_list bigint     NOT NULL,
    price      decimal(15, 5)      DEFAULT NULL,
    priority   tinyint    NOT NULL DEFAULT '0',
    curr       varchar(3) NOT NULL,
    start_date datetime   NOT NULL,
    end_date   datetime   NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT PO_BRAND_ID_FK FOREIGN KEY (brand_id) REFERENCES brand (id),
    CONSTRAINT PO_PRODUCT_ID_FK FOREIGN KEY (product_id) REFERENCES product (id)
);


