
CREATE TABLE IF NOT EXISTS account(
	id varchar(225) NOT NULL PRIMARY KEY,
	updated_at DATETIME NOT NULL DEFAULT  now(),
	created_at DATETIME NOT NULL DEFAULT now(),
	created_by varchar(225) NULL DEFAULT '' ,
	updated_by varchar(225) NULL DEFAULT '',
	username varchar(225) not null,
	password varchar(225) not null,
	user_id varchar(225) not null,
	type varchar(20) not null,
);