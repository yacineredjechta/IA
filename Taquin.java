import java.util.ArrayList;
import java.util.Random;
// Mathieu, Yacine, Idir, Tarshini, Marine

public class Taquin {

	private int [][] tab;

	public Taquin() {
		boolean [] tabTest = new boolean [] {false, false, false, false, false, false, false, false, false}; 
		this.tab = new int [3][3];
		Random r = new Random();

	
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int x = r.nextInt(9);
				while (tabTest[x]) {
					x = r.nextInt(9);
				}
				tabTest[x] = true;
				this.tab[i][j] = x;
			}
		}
	}

	

	public String toString() {
		return (  " _____ \n"
				+ "|" + this.tab[0][0] + " " + this.tab[0][1] + " "  + this.tab[0][2]  + "|\n"
				+ "|" + this.tab[1][0] + " " + this.tab[1][1] + " "  + this.tab[1][2]  + "|\n"
				+ "|" + this.tab[2][0] + " " + this.tab[2][1] + " "  + this.tab[2][2]  + "|\n"
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
		boolean gagnant = true;
		int i = 0;
		while(gagnant && (i < 3)) {
			int j = 0;
			while(gagnant && (j < 3)) {
				if (this.tab[i][j] != ((3*i + j + 1) % 9)) { //
					gagnant = false;
				}
				j++;
			}
			i++;
		}
		return gagnant;
	}

	public int [] positionCaseVide() {
		boolean trouve = false;
		int i = 0;
		int j = 0;
		while(!trouve && (i < 3)) {
			j = 0;
			while(!trouve && (j < 3)) {
				if (this.tab[i][j] == 0) {
					trouve = true;
				}
				j++;
			}
			i++;
		}
		return(new int [] {i,j});
	}

	public void inverseValeurs(int i1, int j1, int i2, int j2) {
		int temp = this.tab[i1][j1];
		this.tab[i1][j1] = this.tab[i2][j2];
		this.tab[i2][j2] = temp;
	}


}
