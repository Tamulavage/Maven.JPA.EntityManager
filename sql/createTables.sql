create table cd
(
  id          integer,
  title       varchar(50),
  descritpion varchar(200),
  year        varchar(4),
  artist      varchar(200),
  price       double,
  primary key (id)
);

create table artist
(
  id         integer,
  first_name varchar(15),
  last_name  varchar(20),
  Instrument varchar(25),
  primary key (id)
);

create table artist_cd
(
  cd_id integer,
  artist_id integer
);
