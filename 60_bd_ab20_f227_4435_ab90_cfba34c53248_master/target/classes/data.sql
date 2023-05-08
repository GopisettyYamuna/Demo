SET REFERENTIAL_INTEGRITY FALSE;
TRUNCATE TABLE vulnerability;
SET REFERENTIAL_INTEGRITY TRUE;
ALTER TABLE vulnerability ALTER COLUMN id RESTART WITH 1;

INSERT INTO vulnerability(score, deleted, title, product)
VALUES('1', false, 'Vuln-1', 'Laravel');
INSERT INTO vulnerability(score, deleted, title, product)
VALUES('3', true, 'Vuln-3', 'Laravel');
INSERT INTO vulnerability(score, deleted, title, product)
VALUES('2', false, 'Vuln-2', 'Laravel');