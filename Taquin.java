import java.util.ArrayList;
import java.util.Random;
//yfukglhkfguiiyuyfyiufy

public class Taquin {

	private int [][] tabTaq;

	public Taquin() {
		// Action : Génération d'un Taquin de manière pseudo-aléatoire.
		// Remarque : La valeur 0 est considérée comme la case vide.
		boolean [] tabB = new boolean [] {false, false, false, false, false, false, false, false, false}; // Permet de savoir quelles valeurs ont déjà été tirées (0..8).
		this.tabTaq = new int [3][3];
		Random r = new Random();

		// Pour chaque case du taquin, on génère un nombre entre 0 et 8 et on l'affecte; sachant qu'il ne peut être tiré qu'une seule fois.
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int x = r.nextInt(9);
				while (tabB[x]) {
					x = r.nextInt(9);
				}
				tabB[x] = true;
				this.tabTaq[i][j] = x;
			}
		}
	}

	public Taquin(Taquin t) {
		// Action : Constructeur par copie.
		this.tabTaq = new int [3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <3; j++) {
				this.tabTaq[i][j] = t.tabTaq[i][j];
			}
		}
	}

	/*// Taquin gagnant pour tester divers fonctions
	public Taquin () {
		this.tabTaq = new int [3][3];
		this.tabTaq[0][0] = 1;
		this.tabTaq[0][1] = 2;
		this.tabTaq[0][2] = 3;
		this.tabTaq[1][0] = 4;
		this.tabTaq[1][1] = 5;
		this.tabTaq[1][2] = 6;
		this.tabTaq[2][0] = 7;
		this.tabTaq[2][1] = 8;
		this.tabTaq[2][2] = 0;
	}*/

	public String toString() {
		return (  " _____ \n"
				+ "|" + this.tabTaq[0][0] + " " + this.tabTaq[0][1] + " "  + this.tabTaq[0][2]  + "|\n"
				+ "|" + this.tabTaq[1][0] + " " + this.tabTaq[1][1] + " "  + this.tabTaq[1][2]  + "|\n"
				+ "|" + this.tabTaq[2][0] + " " + this.tabTaq[2][1] + " "  + this.tabTaq[2][2]  + "|\n"
				+ "|_____| ");
	}

	public static void main (String [] args) {
		Taquin t = new Taquin();
		System.out.println(t);
		Random r = new Random();
		int i,j,k,l ;
		int n = 0;
		while(t.estGagnant() == false){
			System.out.println(t);
			i = r.nextInt(3);
			j = r.nextInt(3);
			k = r.nextInt(3);
			l = r.nextInt(3);
			t.inverseValeurs(i, j, k, l);
			System.out.println(t.estGagnant());
			n +=1 ;
		}
		System.out.println(t);
		System.out.println("Trouvé en "+ n +" tentatives");



	}

	public boolean estGagnant() {
		// Stratégie : Parcours partiel du taquin ; en s'arrêtant à la première valeur fausse.
		boolean gagnant = true;
		int i = 0;
		while(gagnant && (i < 3)) {
			int j = 0;
			while(gagnant && (j < 3)) {
				if (this.tabTaq[i][j] != ((3*i + j + 1) % 9)) { //
					gagnant = false;
				}
				j++;
			}
			i++;
		}
		return gagnant;
	}

	public int [] positionCaseVide() {
		// Action : Renvoie la position de la case vide (0) sous forme d'un tableau à 2 cases [ligne ; colonne].
		boolean trouve = false;
		int i = 0;
		int j = 0;
		while(!trouve && (i < 3)) {
			j = 0;
			while(!trouve && (j < 3)) {
				if (this.tabTaq[i][j] == 0) {
					trouve = true;
				}
				j++;
			}
			i++;
		}
		return(new int [] {i,j});
	}

	public void inverseValeurs(int i1, int j1, int i2, int j2) {
		// Action : inverse les cases (i1,j1) et (i2,j2).
		int temp = this.tabTaq[i1][j1];
		this.tabTaq[i1][j1] = this.tabTaq[i2][j2];
		this.tabTaq[i2][j2] = temp;
	}


}
