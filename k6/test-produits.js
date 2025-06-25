import http from 'k6/http';
import { check, sleep } from 'k6';
import { randomIntBetween } from 'https://jslib.k6.io/k6-utils/1.4.0/index.js';

export const options = {
  stages: [
    { duration: '20s', vus: 250 , target: 500},
    { duration: '10s', vus: 150, target: 100 },
    { duration: '55s', vus: 500, target: 150 },
  ],
};

const baseURL = 'http://localhost:8080/api/v1/produits';

// Données aléatoires pour POST/PUT
const createProduitPayload = () => JSON.stringify({
  nom: `ProduitTest-${Math.random().toString(36).substring(7)}`,
  description: 'Produit généré par k6',
  prix: Math.floor(Math.random() * 100) + 1,
  categorie: 'test',
});

const headers = {
  'Content-Type': 'application/json',
};

export default function () {
  // GET /produits
  let res = http.get(baseURL);
  check(res, {
    'GET /produits - status 200': (r) => r.status === 200,
  });

  // POST /produits (créer un produit)
  const payload = createProduitPayload();
  res = http.post(baseURL, payload, { headers });
  check(res, {
    'POST /produits - status 201': (r) => r.status === 201,
  });

  const produit = res.json(); // réponse contenant id, nom, etc.
  const produitId = produit?.id || 1; // fallback si le backend ne retourne pas l’id

  // GET /produits/{id}
  res = http.get(`${baseURL}/${produitId}`);
  check(res, {
    'GET /produits/{id} - status 200 ou 404': (r) => r.status === 200 || r.status === 404,
  });

  // GET /produits/nom?nom=...
  res = http.get(`${baseURL}/nom?nom=${encodeURIComponent(produit.nom)}`);
  check(res, {
    'GET /produits/nom - status 200 ou 404': (r) => r.status === 200 || r.status === 404,
  });

  // GET /produits/categorie?categorie=test
  res = http.get(`${baseURL}/categorie?categorie=test`);
  check(res, {
    'GET /produits/categorie - status 200': (r) => r.status === 200,
  });

  // PUT /produits/{id}
  const updatedPayload = JSON.stringify({
    nom: produit.nom + '-modifié',
    description: 'Produit modifié',
    prix: produit.prix + 5,
    categorie: 'test',
  });

  res = http.put(`${baseURL}/${produitId}`, updatedPayload, { headers });
  check(res, {
    'PUT /produits/{id} - status 200 ou 404': (r) => r.status === 200 || r.status === 404,
  });

  sleep(1);
}
