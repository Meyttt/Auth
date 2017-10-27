CREATE DATABASE auth;
\c auth;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE tokens(
  id BIGSERIAL PRIMARY KEY,
  value UUID NOT NULL DEFAULT uuid_generate_v4(),
  expired_date TIMESTAMP
);
CREATE TABLE sessions(
  id BIGSERIAL PRIMARY KEY,
  user_id BIGINT NOT NULL UNIQUE,
  access_token BIGINT REFERENCES tokens(id),
  refresh_token BIGINT REFERENCES tokens(id)
);



