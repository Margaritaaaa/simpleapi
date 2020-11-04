DROP TABLE IF EXISTS Computers CASCADE;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1;
CREATE TABLE Computers(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    type        VARCHAR         NOT NULL,
    name        VARCHAR         NOT NULL,
    cpu         VARCHAR         NOT NULL,
    employee    VARCHAR         NOT NULL
);