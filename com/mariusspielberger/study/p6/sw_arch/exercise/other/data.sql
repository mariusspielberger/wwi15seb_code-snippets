CREATE TABLE USER(ID bigint auto_increment, USERNAME varchar(255) UNIQUE, PASSWORD varchar(255), FIRSTNAME varchar(255), LASTNAME varchar(255));

INSERT INTO USER (USERNAME, PASSWORD, FIRSTNAME, LASTNAME) VALUES ('ms', 'change-me', 'Marius', 'Spielberger');
INSERT INTO USER (USERNAME, PASSWORD, FIRSTNAME, LASTNAME) VALUES ('ik', 'password', 'Ina', 'Kolbinger');
INSERT INTO USER (USERNAME, PASSWORD, FIRSTNAME, LASTNAME) VALUES ('mf', 's5kjgdkj5tdfkgmzkjwerlkgsjdfz', 'Martin', 'Faber');