create table if not exists public.tbl_user
(
    id   numeric      not null
        constraint tbl_user_pk
            primary key,
    name varchar(200) not null,
    age  integer
);