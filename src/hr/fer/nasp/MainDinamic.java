package hr.fer.nasp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Class that contains main method for dinamic solution of a knapsack problem
 */
public class MainDinamic {

public static void main(String[] args) {
		
		int maxWeight = 0;
		int numThings = 0;
		int numCateg = 0;
		
		int numItems = 0;
		
		 String s = null;
	    
	     System.out.println("Koliko ukupno stvari zelite unijeti? ");
	        
	        try{
	           BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	           s = bufferRead.readLine();
	           numThings = Integer.parseInt(s.trim());   

	       }
	       catch(IOException e)
	       {
	           e.printStackTrace();
	       }
	        
	        
	     System.out.println("Koliko razlicitih kategorija zelite unijeti? ");
	     
	     try{
	        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	        s = bufferRead.readLine();
	        numCateg = Integer.parseInt(s.trim());
	        
	    }
	    catch(IOException e)
	    {
	        e.printStackTrace();
	    }
	     
	     String[] kategorije = new String[numCateg + 1];
	     String[] proizvod=new String[numThings];
	     
	     kategorije[0] = "";
	     
	     int[] vrijednost = new int[numThings+1];
		 int[] cijena = new int[numThings+1];
		 int[] kateg = new int[numThings+1];
	     
	     int temp = 0;
	    for(int i=1; i <= numCateg; i++) {
	        System.out.println("Unesite " + i +". kategoriju: ");
	        try{
	            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	            s = bufferRead.readLine();
	            kategorije[i] = s.trim();
	        }
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
	        System.out.println("Koliko ce kategorija " + kategorije[i] +" imati podkategorija? ");
		     
		     try{
		        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		        s = bufferRead.readLine();
		        numItems = Integer.parseInt(s.trim());
		        
		    }
		    catch(IOException e)
		    {
		        e.printStackTrace();
		    }
	      
	       
	        for(int j = temp; j < (numItems + temp); j++) {
	           System.out.println("Unesite podkategoriju: ");
	           try{
	               BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	               s = bufferRead.readLine();
	               proizvod[j] = s.trim();
	           }
	           catch(IOException e)
	           {
	               e.printStackTrace();
	           }
	           
	           System.out.println("Unesite tezinu: ");
	           try{
	               BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	               s = bufferRead.readLine();
	               cijena[j] = Integer.parseInt(s.trim());
	           }
	           catch(IOException e)
	           {
	               e.printStackTrace();
	           }
	           System.out.println("Unesite vrijednost: ");
	           try{
	               BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	               s = bufferRead.readLine();
	               vrijednost[j] = Integer.parseInt(s.trim());
	               kateg[j] = i;
	           }
	           catch(IOException e)
	           {
	               e.printStackTrace();
	           }

	       }
	        temp += numItems;
	    }
	    
	    System.out.println("Unesite najvecu dopustenu tezinu: ");
	     
	     try{
	        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	        s = bufferRead.readLine();
	        maxWeight = Integer.parseInt(s.trim());
	        
	    }
	    catch(IOException e)
	    {
	        e.printStackTrace();
	    }
		
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
