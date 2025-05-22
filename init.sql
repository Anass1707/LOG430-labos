CREATE TABLE IF NOT EXISTS utilisateurs (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

INSERT INTO utilisateurs (nom, email)
VALUES ('Jean Dupont', 'jean.dupont@example.com');