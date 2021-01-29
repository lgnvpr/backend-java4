
CREATE TABLE IF NOT EXISTS permission(
	id varchar(225) NOT NULL PRIMARY KEY,
	updated_at DATETIME NOT NULL DEFAULT  now(),
	created_at DATETIME NOT NULL DEFAULT now(),
	created_by varchar(225) NULL DEFAULT '' ,
	updated_by varchar(225) NULL DEFAULT '',
	is_deleted boolean default false,
	name_table varchar(225) not null,
	name_action varchar(225) not null,
	name_method varchar(225) not null
);