create database book_systems;

\connect book_systems;

create table books (
                    id bigint primary key generated always as identity,
                    name character varying(255) not null,
                    CONSTRAINT books_name_uniq UNIQUE (name)
                );

INSERT INTO books (name) VALUES ('The Art of FreeBSD'), ('Debian Unleashed'), ('The UNIX Programming Guide'), ('xv6 Explained');
