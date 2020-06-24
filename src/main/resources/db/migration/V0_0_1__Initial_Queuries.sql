CREATE SEQUENCE products_product_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

CREATE TABLE products(
    product_id integer DEFAULT nextval('products_product_id_seq'::regclass) NOT NULL,
    name varchar(150),
    price integer,
    description varchar(400),
    available_quantity integer
);

ALTER TABLE ONLY products ADD CONSTRAINT pk_product_id PRIMARY KEY (product_id);

INSERT INTO products(name, price, description, available_quantity)
    VALUES ('Sleeveless T-Shirt', 350, 'Amazon Brand - Symbol Women''s Solid Slim Fit Sleeveless T-Shirt', 115);

INSERT INTO products(name, price, description, available_quantity)
    VALUES ('Neysa Women''s Cotton Lycra Dress', 750, 'Care Instructions: Hand Wash, Fabric - Cotton Lycra Blend', 35);

INSERT INTO products(name, price, description, available_quantity)
    VALUES ('SERA Cotton a-line Dress', 452, 'Care Instructions: machine wash, Fit Type: Regular', 71);

INSERT INTO products(name, price, description, available_quantity)
    VALUES ('RIGO Women''s Midi Dress', 399, 'Care Instructions: Machine Wash, Fit Type: Regular Fit', 98);
