create sequence road_id_seq start with 1 increment by 50;

create table raods
(
    id       bigint DEFAULT nextval('road_id_seq') not null,
    roadName varchar(255)                          not null,
    city     varchar(50)                           not null,
    state    varchar(2)                            not null,
    primary key (id)
);
