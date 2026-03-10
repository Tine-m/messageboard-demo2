create table IF NOT EXISTS users
(
    user_id  serial  primary key,
    username varchar(50) not null,
    password varchar(50) not null
    );
CREATE UNIQUE INDEX IF NOT EXISTS idx_username ON users(username);