drop table if exists avenger;
create table avenger (id serial primary key, last_name varchar(255) not null, first_name varchar(255) not null, alias varchar(255) not null, pouvoir int not null, photo bytea, agent_id int not null);

drop table if exists agent;
create table agent (id serial primary key, last_name varchar(255) not null, first_name varchar(255) not null, photo bytea);

alter table avenger add constraint FK_AGENT foreign key (agent_id) references agent(id)