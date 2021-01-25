

CREATE TABLE IF NOT EXISTS category_products(
	id varchar(225) NOT NULL PRIMARY KEY,
	updated_at DATETIME NOT NULL DEFAULT  now(),
	created_at DATETIME NOT NULL DEFAULT now(),
	created_by varchar(225) NULL DEFAULT '' ,
	updated_by varchar(225) NULL DEFAULT '',
	name varchar(225) NOT NULL,
	desciption text NOT NULL,
	image text NOT NULL
);
