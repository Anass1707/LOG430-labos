-- Table: Utilisateurs
CREATE TABLE IF NOT EXISTS utilisateurs (
  id SERIAL PRIMARY KEY,
  nom VARCHAR(100) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL
);

INSERT INTO utilisateurs (nom, email)
VALUES ('Jean Dupont', 'jean.dupont@example.com'),
('Vinicius Junior', 'vini.junior@example.com');

-- Table: Produits
CREATE TABLE IF NOT EXISTS produits (
  id SERIAL PRIMARY KEY,
  nom VARCHAR(100) NOT NULL,
  categorie VARCHAR(100),
  prix NUMERIC(10, 2) NOT NULL,
  quantite INT NOT NULL
);

INSERT INTO produits (nom, categorie, prix, quantite) VALUES
('Clavier', 'Électronique', 45.90, 20),
('Souris', 'Électronique', 25.00, 50),
('Chaise', 'Mobilier', 120.50, 10);

-- Table: magasins
CREATE TABLE IF NOT EXISTS magasins (
  id SERIAL PRIMARY KEY,
  nom VARCHAR(100) NOT NULL,
  adresse VARCHAR(255)
);

-- Table: Vente
CREATE TABLE IF NOT EXISTS ventes (
  id SERIAL PRIMARY KEY,
  id_utilisateur INT NOT NULL,
  date_vente DATE NOT NULL,
  total NUMERIC(10, 2) NOT NULL,
  id_magasin INT NOT NULL,
  FOREIGN KEY (id_magasin) REFERENCES magasins(id),
  FOREIGN KEY (id_utilisateur) REFERENCES utilisateurs(id)
);

-- Table: LigneVente 
CREATE TABLE IF NOT EXISTS ligne_vente (
  id_vente INT NOT NULL,
  id_produit INT NOT NULL,
  quantite INT NOT NULL,
  PRIMARY KEY (id_vente, id_produit),
  FOREIGN KEY (id_vente) REFERENCES ventes(id) ON DELETE CASCADE,
  FOREIGN KEY (id_produit) REFERENCES produits(id)
);

-- Table: Retour
CREATE TABLE IF NOT EXISTS retours (
  id SERIAL PRIMARY KEY,
  id_vente INT NOT NULL,
  date_retour DATE NOT NULL,
  motif TEXT,
  FOREIGN KEY (id_vente) REFERENCES ventes(id)
);

-- Table: stock_magasin
CREATE TABLE IF NOT EXISTS stock_magasin (
  id SERIAL PRIMARY KEY,
  id_magasin INT NOT NULL,
  id_produit INT NOT NULL,
  quantite INT NOT NULL,
  minimum_stock INT NOT NULL,
  FOREIGN KEY (id_magasin) REFERENCES magasins(id),
  FOREIGN KEY (id_produit) REFERENCES produits(id),
  UNIQUE (id_magasin, id_produit)
);

-- Table: stock_central
CREATE TABLE IF NOT EXISTS stock_central (
  id SERIAL PRIMARY KEY,
  id_produit INT NOT NULL,
  quantite INT NOT NULL,
  FOREIGN KEY (id_produit) REFERENCES produits(id),
  UNIQUE (id_produit)
);

-- Table: demandes_reapprovisionnement 
CREATE TABLE IF NOT EXISTS demandes_reapprovisionnement (
  id SERIAL PRIMARY KEY,
  id_magasin INT NOT NULL,
  id_produit INT NOT NULL,
  quantite_demandee INT NOT NULL,
  date_demande DATE NOT NULL DEFAULT CURRENT_DATE,
  statut VARCHAR(50) DEFAULT 'EN_ATTENTE',
  FOREIGN KEY (id_magasin) REFERENCES magasins(id),
  FOREIGN KEY (id_produit) REFERENCES produits(id)
);

-- Magasins
INSERT INTO magasins (nom, adresse) VALUES
('Magasin Central', '1 rue de la Logistique'),
('Magasin Nord', '12 avenue du Nord'),
('Magasin Sud', '34 boulevard du Sud');

-- Stock central
INSERT INTO stock_central (id_produit, quantite) VALUES
(1, 100),
(2, 200),
(3, 50);

-- Stock magasin
INSERT INTO stock_magasin (id_magasin, id_produit, quantite, minimum_stock) VALUES
(1, 1, 20, 10),
(1, 2, 30, 15),
(1, 3, 0, 10),
(2, 1, 10,10),
(2, 2, 0,20),
(2, 3, 5, 5),
(3, 1, 0, 10),
(3, 2, 15, 10),
(3, 3, 8,5);

-- Ventes
INSERT INTO ventes (id_utilisateur, date_vente, total, id_magasin) VALUES
(1, '2025-06-01', 91.80, 1),
(2, '2025-06-02', 120.50, 2),
(1, '2025-06-03', 25.00, 3),
(1, '2025-06-01', 367.2, 1),
(2, '2025-06-02', 1205.00, 2),
(1, '2025-06-05', 50.00, 3);

-- LigneVente
INSERT INTO ligne_vente (id_vente, id_produit, quantite) VALUES
(1, 1, 2),   -- 2 claviers
(2, 3, 1),   -- 1 chaise
(3, 2, 1),   -- 1 souris
(4, 1, 8),   
(5, 3, 10),   
(6, 2, 6);   

-- Retours
INSERT INTO retours (id_vente, date_retour, motif) VALUES
(1, '2024-05-05', 'Défectueux'),
(3, '2024-05-06', 'Erreur de commande');

-- Demandes de réapprovisionnement
INSERT INTO demandes_reapprovisionnement (id_magasin, id_produit, quantite_demandee, date_demande, statut) VALUES
(2, 1, 10, '2024-05-07', 'EN_ATTENTE'),
(3, 3, 5, '2024-05-08', 'VALIDÉ');