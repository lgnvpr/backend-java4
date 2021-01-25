CREATE TABLE IF NOT EXISTS staff(
	id varchar(225) NOT NULL PRIMARY KEY,
	updated_at DATETIME NOT NULL DEFAULT  now(),
	created_at DATETIME NOT NULL DEFAULT now(),
	created_by varchar(225) NULL DEFAULT '' ,
	updated_by varchar(225) NULL DEFAULT '',
	name varchar(225) not null,
	cmnd varchar(225) not null,
	phone varchar(225) not null,
	email varchar(225) not null,
	birth_at varchar(225) not null,
	gender varchar(225) not null,
	address text not null,
	image text not null
);
