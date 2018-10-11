package hr.fer.nasp;

/*
Created by Filip
 */
public class Knapsack {

	
	public Knapsack(){}

	/*
		Method that solves Knapsack problem
 	*/
	public void solve(int maxWeight, int numThings, int numCateg, int[] kateg, int[] cijena, int[] vrijednost, String[] kategorije, String[] proizvod) {
		
		int myLeft=0;
		int remember=0;
		int[] count = new int[numCateg+1];

		for(int category=1; category<=numCateg; ++category){
			count[category]=0;
		}
		
		int[][] table = new int[maxWeight+1][numThings+1];

		int[][] keepTable = new int[maxWeight+1][numThings+1];
		
		for(int i=1; i<=maxWeight; ++i){
			for(int j=0; j<numThings; ++j){
				table[i][j]=0;
				keepTable[i][j]=0;
			}
		}
		
		for(int stvar=0; stvar<numThings;++stvar){
			myLeft=0;
			remember=0;
			
			if(kateg[stvar]==1){
				++count[kateg[stvar]];
				
				for(int redak=1; redak <= maxWeight ; redak++){
					if(cijena[stvar]<=redak){
						table[redak][stvar]=vrijednost[stvar];
						keepTable[redak][stvar]=1;
					}
				}
			}
			else{
				++count[kateg[stvar]];
				for(int redak=1; redak<=maxWeight;redak++){
					for(int i=0; i<count[kateg[stvar]-1];++i){
						if(table[redak][stvar-count[kateg[stvar]]-i]>myLeft){
							myLeft=table[redak][stvar-count[kateg[stvar]]-i];
						}
					}
					if(cijena[stvar]>redak){
						table[redak][stvar]=myLeft;
					}
					else{
						for(int i = 0; i<count[kateg[stvar]-1]; ++i){
							if(redak>cijena[stvar] && table[redak-cijena[stvar]][stvar-count[kateg[stvar]]-i]>remember){
								remember=table[redak-cijena[stvar]][stvar-count[kateg[stvar]]-i];
							}
						}
						int sum = remember+vrijednost[stvar];
						if(sum>=myLeft){
							table[redak][stvar]=sum;
							keepTable[redak][stvar]=1;
						}
						else{
							table[redak][stvar]=myLeft;
						}
					}
				}
			}
		}
		
		for(int i=1;i<=maxWeight;i++){
			for(int j=0; j<numThings; j++){
				System.out.printf("%d\t",  table[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		/*for(int i=1;i<=maxWeight;i++){
			for(int j=0; j<numThings; j++){
				System.out.printf("%d\t",  keepTable[i][j]);
			}
			System.out.println();
		}*/

		int k=maxWeight;
		int stupac=numThings;
		int brkat=numCateg;
		
		int ukCijena = 0;
		int ukVrij = 0;
		
		System.out.println("\n Najbolji odabir:");
		while(true){
			//if(stupac < 0) break;
			if(keepTable[k][stupac]==0){
				stupac--;
				if(stupac<0) break;
			}
			else{
				if(stupac<0 || k<0) break;
				System.out.println("Kategorija: "+kategorije[kateg[stupac]]+", podvrsta: "+proizvod[stupac]+", vrijednost: "+vrijednost[stupac]+", cijena: "+cijena[stupac]);
				
				ukVrij += vrijednost[stupac];
				ukCijena += cijena[stupac];
						
				k=k-cijena[stupac];
				stupac-=count[brkat-1];
				brkat-=1;
				if(brkat==0) break;
			}
		}
		
		
		System.out.println("\nMaksimalna vrijednost v="+ ukVrij +" postignuta je za cijenu c="+ukCijena);
		
	
	}

}
