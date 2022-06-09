create table todos
(
    id           serial primary key,
    name         varchar,
    description  varchar,
    created_at   timestamptz,
    is_completed boolean,
    due_date     timestamptz,
    column_id    integer
);

create table columns
(

    id         serial primary key,
    name       varchar,
    created_at timestamptz,
    project_id integer
);

create table projects
(
    id         serial primary key,
    name       varchar,
    created_at timestamptz
);