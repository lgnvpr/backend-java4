CREATE TABLE IF NOT EXISTS role_account(
	id varchar(225) NOT NULL PRIMARY KEY,
	updated_at DATETIME NOT NULL DEFAULT  now(),
	created_at DATETIME NOT NULL DEFAULT now(),
	created_by varchar(225) NULL DEFAULT '' ,
	updated_by varchar(225) NULL DEFAULT '',
	is_deleted boolean default false,
	id_role varchar(225) not null,
	account_id varchar(225) not null
)
