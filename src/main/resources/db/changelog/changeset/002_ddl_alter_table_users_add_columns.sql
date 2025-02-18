--liquibase formatted sql
--changeset nzagorodnikov:add_columns_to_users_table
ALTER TABLE users
    ADD COLUMN first_arg BIGINT,
    ADD COLUMN second_arg BIGINT,
    ADD COLUMN result BIGINT;
