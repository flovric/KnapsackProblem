package hr.fer.nasp;

/*
Class that contains main method for static solution of a knapsack problem
 */
public class MainStatic {

	public static void main(String[] args) {
		
		int maxWeight = 100;
		int numThings = 6;
		int numCateg = 3;
		
		String[] kategorije=new String[]{"", "Skauti", "Igraci", "Treneri"};
		String[] proizvod=new String[]{"S.Mislintat", "J.Draxler", "T.Lemar", "Isco", "D.Simeone", "C.Ancelotti"};
		

		
		int[] vrijednost = new int[numThings+1];
		int[] cijena = new int[numThings+1];
		int[] kateg = new int[numThings+1];
		
		vrijednost[0]=10;
		cijena[0]=10;
		kateg[0]=1;

		vrijednost[1]=20;
		cijena[1]=30;
		kateg[1]=2;
	
		vrijednost[2]=20;
		cijena[2]=10;
		kateg[2]=2;
		
		vrijednost[3]=30;
		cijena[3]=50;
		kateg[3]=2;
		
		vrijednost[4]=30;
		cijena[4]=40;
		kateg[4]=3;
		
		vrijednost[5]=80;
		cijena[5]=70;
		kateg[5]=3;
		
		System.out.println("Izgled unesenih elemenata:");
	     System.out.println();
		for(int stupac=0; stupac<numThings; stupac++){
			System.out.println("Kategorija: "+kategorije[kateg[stupac]]+", podvrsta: "+proizvod[stupac]+", vrijednost: "+vrijednost[stupac]+", cijena: "+cijena[stupac]);
		}
		System.out.println();
		
		Knapsack knap = new Knapsack();
		knap.solve(maxWeight, numThings, numCateg, kateg, cijena, vrijednost, kategorije, proizvod);
	}
}
