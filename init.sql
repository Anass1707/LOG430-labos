-- Table: Utilisateur
CREATE TABLE IF NOT EXISTS utilisateurs (
  id SERIAL PRIMARY KEY,
  nom VARCHAR(100) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL
);

INSERT INTO utilisateurs (nom, email)
VALUES ('Jean Dupont', 'jean.dupont@example.com'),
('Vinicius Junior', 'vini.junior@example.com');

-- Table: Produit
CREATE TABLE IF NOT EXISTS produits (
  id SERIAL PRIMARY KEY,
  nom VARCHAR(100) NOT NULL,
  categorie VARCHAR(100),
  prix NUMERIC(10, 2) NOT NULL,
  quantite INT NOT NULL
);

-- INSERT INTO produits (nom, categorie, prix, quantite) VALUES
-- ('Clavier', 'Électronique', 45.90, 20),
-- ('Souris', 'Électronique', 25.00, 50),
-- ('Chaise', 'Mobilier', 120.50, 10);

-- Table: Vente
CREATE TABLE IF NOT EXISTS ventes (
  id SERIAL PRIMARY KEY,
  id_utilisateur INT NOT NULL,
  date_vente DATE NOT NULL,
  total NUMERIC(10, 2) NOT NULL,
  FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id)
);

-- Table: LigneVente 
CREATE TABLE IF NOT EXISTS ligneVente (
  id_vente INT NOT NULL,
  id_produit INT NOT NULL,
  quantite INT NOT NULL,
  PRIMARY KEY (id_vente, id_produit),
  FOREIGN KEY (id_vente) REFERENCES vente(id) ON DELETE CASCADE,
  FOREIGN KEY (id_produit) REFERENCES produit(id)
);

-- Table: Retour
CREATE TABLE IF NOT EXISTS retours (
  id SERIAL PRIMARY KEY,
  id_vente INT NOT NULL,
  date_retour DATE NOT NULL,
  motif TEXT,
  FOREIGN KEY (id_vente) REFERENCES vente(id)
);
