create table todo(
	id int auto_increment primary key,
	title varchar(100) not null,
	content varchar(300) not null,
	deadline date,
	complete char(1),
	priority int
);