CREATE TABLE IF NOT EXISTS path_store(
	id varchar(225) NOT NULL PRIMARY KEY,
	updated_at DATETIME NOT NULL DEFAULT  now(),
	created_at DATETIME NOT NULL DEFAULT now(),
	created_by varchar(225) NULL DEFAULT '' ,
	updated_by varchar(225) NULL DEFAULT '',
	resource_id varchar(225),
	previous_path_store_id varchar(225),
	data text
);
