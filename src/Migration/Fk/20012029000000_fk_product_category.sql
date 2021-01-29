alter table product 
add constraint fk_product_category
FOREIGN KEY (category_product_id) REFERENCES category_product(id)