CREATE TABLE IF NOT EXISTS product(
	id varchar(225) NOT NULL PRIMARY KEY,
	updated_at DATETIME NOT NULL DEFAULT  now(),
	created_at DATETIME NOT NULL DEFAULT now(),
	created_by varchar(225) NULL DEFAULT '' ,
	updated_by varchar(225) NULL DEFAULT '',
	is_deleted boolean default false,
	name varchar(225) not null,
	price BIGINT not null,
	description text null,
	category_product_id varchar(225) null,
	price_sale BIGINT null default 0,
	percent_sale int null default 0
);
