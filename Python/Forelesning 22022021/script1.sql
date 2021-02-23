USE heltnydatabase;

SELECT *
FROM vare;

CREATE USER 'Lagersjefen2021' IDENTIFIED BY 'lagerpw';

GRANT SELECT ON Vare TO 'Lagersjefen2021';
GRANT INSERT ON Vare TO 'Lagersjefen2021';
GRANT DELETE ON Vare TO 'Lagersjefen2021';

GRANT UPDATE ON Vare TO 'Lagersjefen2021';