package log430.Labos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LabosApplication {
public static void main(String[] args) {
	SpringApplication.run(LabosApplication.class, args);
//     final ApplicationContext app = SpringApplication.run(LabosApplication.class, args);

//     // Récupération des controllers via Spring
//     final ProduitController produitController = app.getBean(ProduitController.class);
//     final VenteController venteController = app.getBean(VenteController.class);
//     final RetourController retourController = app.getBean(RetourController.class);

//     final Scanner scanner = new Scanner(System.in);
//     int choix = -1;

//     while (choix != 0) {
//         System.out.println("\n=== Menu ===");
//         System.out.println("1. Lister les produits");
// 		System.out.println("2. Lister les ventes");
//         System.out.println("3. Lister les retours");
//         System.out.println("4. Afficher un produit par ID");
// 		System.out.println("5. Chercher produit par nom");
//     	System.out.println("6. Chercher produit par catégorie");
//         System.out.println("0. Quitter");
//         System.out.print("Votre choix : ");
//         try {
//             choix = Integer.parseInt(scanner.nextLine());
//         } catch (NumberFormatException e) {
//             System.out.println("Entrée invalide.");
//             continue;
//         }

//         switch (choix) {
//             case 1:
//                 final var produits = produitController.getAllProduits();
//                 if (produits.isEmpty()) {
//                     System.out.println("Aucun produit trouvé.");
//                 } else {
//                     System.out.println("Liste des produits :");
//                     for (var produit : produits) {
//                         System.out.println("ID: " + produit.getId() + ", Nom: " + 
// 						produit.getNom() + ", Prix: " + produit.getPrix());
//                     }
//                 }
//                 break;
//             case 2:
//                 final var ventes = venteController.getAllVentes();
//                 if (ventes.isEmpty()) {
//                     System.out.println("Aucune vente trouvée.");
//                 } else {
//                     System.out.println("Liste des ventes :");
//                     for (var vente : ventes) {
//                         System.out.println("ID: " + vente.getId() + ", Date: " + 
// 						vente.getDateVente() + ", Total: " + vente.getTotal());
//                     }
//                 }
//                 break;
//             case 3:
//                 final var retours = retourController.getAllRetours();
//                 if (retours.isEmpty()) {
//                     System.out.println("Aucun retour trouvé.");
//                 } else {
//                     System.out.println("Liste des retours :");
//                     for (var retour : retours) {
//                         System.out.println("ID: " + retour.getId() +
// 						 ", Date: " + retour.getDateRetour());
//                     }
//                 }
//                 break;
//             case 4:
//                 System.out.print("Entrez l'ID du produit à afficher : ");
//                 try {
//                     final Long idProduit = Long.parseLong(scanner.nextLine());
//                     final var produit = produitController.getProduit(idProduit);
//                     if (produit == null) {
//                         System.out.println("Produit non trouvé.");
//                     } else {
//                         System.out.println("ID: " + produit.getId() + ", Nom: " +
// 						produit.getNom() + ", Prix: " + produit.getPrix() + ", Quantité: " +
// 						produit.getQuantite());
//                     }
//                 } catch (NumberFormatException e) {
//                     System.out.println("ID invalide.");
//                 }
//                 break;
// 			case 7:
//             System.out.print("Entrez le nom du produit à chercher : ");
//             final String nom = scanner.nextLine();
//             final var produitParNom = produitController.getProduitsByNom(nom);
//             if (produitParNom == null) {
//                 System.out.println("Aucun produit trouvé avec ce nom.");
//             } else {
//                 System.out.println("ID: " + produitParNom.getId() + ", Nom: " +
// 				 produitParNom.getNom() + ", Prix: " + produitParNom.getPrix() + 
// 				 ", Quantité: " + produitParNom.getQuantite());
//             }
//             break;

//         	case 5:
//             System.out.print("Entrez la catégorie à chercher : ");
//             final String categorie = scanner.nextLine();
//             final var produitsParCategorie = produitController.getProduitsByCategorie(categorie);
//             if (produitsParCategorie == null || produitsParCategorie.isEmpty()) {
//                 System.out.println("Aucun produit trouvé dans cette catégorie.");
//             } else {
//                 System.out.println("Produits dans la catégorie " + categorie + " :");
//                 for (var produit : produitsParCategorie) {
//                     System.out.println("ID: " + produit.getId() + ", Nom: " +
// 					 produit.getNom() + ", Prix: " + produit.getPrix() 
// 					 + ", Quantité: " + produit.getQuantite());
//                 }
//             }
//             break;
//             case 0:
//                 System.out.println("Au revoir !");
//                 break;
//             default:
//                 System.out.println("Choix invalide.");
//         }
//     }
//     scanner.close();
 }
}