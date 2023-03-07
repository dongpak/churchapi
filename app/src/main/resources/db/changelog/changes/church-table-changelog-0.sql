--liquibase formatted sql

--changeset dongp:0
CREATE TABLE church (
    id              UUID PRIMARY KEY,
    active          BOOL NULL DEFAULT true,
    name            TEXT UNIQUE,
    created_date    timestamp NOT NULL,
    created_by      TEXT NOT NULL,
    updated_date    timestamp NOT NULL,
    updated_by      TEXT NOT NULL
)

--changeset dongp:1
ALTER TABLE church ADD COLUMN contact_id UUID;
ALTER TABLE church ADD CONSTRAINT fk_church_contact_id FOREIGN KEY (contact_id) REFERENCES public.contact(id);
