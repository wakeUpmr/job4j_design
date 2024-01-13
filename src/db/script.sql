create table flowers(
	id serial primary key,
	family varchar(255),
	name text,
	price money
);
insert into flowers(family, name, price) 
	values('Кактусовые', 'мамиллярия', 200);
select * from flowers;
update flowers set price = 190;
select * from flowers;
delete from flowers;