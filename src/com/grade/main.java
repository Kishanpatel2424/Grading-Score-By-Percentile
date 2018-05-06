/*
 * This Program is used for assigning scores based of overall class scores
 * 
 * All scores are divided into 20% percentile and the scores are assigned accordingly
 * 
 * top 20% of scores are A
 * next 20% of scores are B
 * next 20% of scores are C
 * next 20% of scores are D
 * next 20% of scores are F
 * 
 * At first it creates a sorted list which is saved into scores which is passed to findDublicate function which returns 
 * scores with no dublicate
 * then a scoresDublicate list is created to save the original values.
 * 
 *  Scores list is use to create a percentile index score because its sorted and no dublicate values 
 *  
 *  The percentile  index scores are saved into an array
 *  Get Scores
	 * Prints the Sorted array with non dublicate Value
	 * Prints the Sorted Original Array  
	 * 
	 * For loop to calculate 20% of all scores and saves the srarting socre for each 20% into an indexValue array
	 * 
	 * For loop of scoresDublicate assign the value grade 
 *  
 *  
 */

package com.grade;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



// you may import more classes
class Main {
	private static final List<Map<Integer, String>> scoresWithGrades = new ArrayList<Map<Integer,String>>();
	public static List<Integer> scores = new ArrayList<Integer>();
	public static List<Integer> scoresDublicate = new ArrayList<Integer>();
	static Map<Integer, String> map = new HashMap<Integer, String>();
	
	public static int originalSize = 0;
	
	public static List<Map<Integer,String>> atheniumGrading(List<Integer> scores){
		getScores(scores);
		return scoresWithGrades;
	}
	
	/*
	 *  Create n List number of Random scores between 1-100 for the list 
	 */
	public static List<Integer> setScores(int numberOfScores) {
		
		for(int i=0;i<numberOfScores;i++){
			int random = (int )(Math.random() * 100 + 1);
			//System.out.println(random);
			scores.add(random);
			scoresDublicate.add(random);
		}
		originalSize = numberOfScores;
		Collections.sort(scores, Collections.reverseOrder()); //to sort the list [if to reverse the order Use Collections.reverseOrder()]
		Collections.sort(scoresDublicate, Collections.reverseOrder());
		scores = findDuplicates(scores);//Find dublicate
		return scores;
	}
	
	/*
	 *  To use if you have list of scores
	 */
	public static List<Integer> setScores(List<Integer> scores){
		originalSize = scores.size();
		Collections.sort(scores, Collections.reverseOrder()); //to sort the list [if to reverse the order Use Collections.reverseOrder()]
		scoresDublicate = scores;
		scores = findDuplicates(scores);
		return scores;
	}
	
	/*
	 * to Find dublicates and save them into scoresDublicate list
	 */
	public static List<Integer> findDuplicates(List<Integer> sortedScores){
		for(int i=0;i<sortedScores.size()-1;i++){
			if(sortedScores.get(i+1) == sortedScores.get(i)){
				//scoresDublicate.add(i);	
				sortedScores.remove(i);
			}
		}
		return sortedScores;
	}
	
	/*Get Scores
	 * Prints the Sorted array with non dublicate Value
	 * Prints the Sorted Original Array  
	 * 
	 * For loop to calculate 20% of all scores and saves the srarting socre for each 20% into an indexValue array
	 * 
	 * For loop of scoresDublicate assign the value grade 
	 * 		
	 */
	public static void getScores(List<Integer> scores){
		
		int[] indexValue = new int[5];
		for(int i=0;i<scores.size();i++){
			System.out.print(scores.get(i)+",");
		}
		System.out.println("\n Original List");
		for(int i=0;i<scoresDublicate.size();i++){
			System.out.print(scoresDublicate.get(i)+",");
		}
		
		
		//System.out.println(scoresWithGrades.get(0));
		System.out.println();	
		int count =0;
		for(int percentile = 80;percentile>0;percentile-=20){
			System.out.println("Starting Score for each percentile "+Percentile(scores,percentile));
			indexValue[count] = Percentile(scores,percentile);
			count++;
			
			
		}
		
		
		for(int i=0;i<scoresDublicate.size();i++){
		//if score is >= 1st 20% index its an A
			if(scoresDublicate.get(i)>=indexValue[3]){
				map.put(scoresDublicate.get(i), "A");
				System.out.print("\n"+scoresDublicate.get(i)+" A");
				//System.out.println(map.get(i));
				scoresWithGrades.add(map);
			}
		//if score is >= 2nd 20% index and <1st 20% index its an B
			else if(scoresDublicate.get(i)>=indexValue[2] && scoresDublicate.get(i)<indexValue[3]){
				map.put(scoresDublicate.get(i), "B");
				//System.out.println(map.get(i));
				System.out.print("\n"+scoresDublicate.get(i)+" B");
				scoresWithGrades.add(map);
			}
		//if score is >= 3nd 20% index and <2st 20% index its an C
			else if(scoresDublicate.get(i)>=indexValue[1] && scoresDublicate.get(i)<indexValue[2]){
				map.put(scoresDublicate.get(i), "C");
				//System.out.println(map.get(i));
				System.out.print("\n"+scoresDublicate.get(i)+" C");
				scoresWithGrades.add(map);
			}
		//if score is >= 3nd 20% index and <2st 20% index its an D
			else if(scoresDublicate.get(i)>=indexValue[0] && scoresDublicate.get(i)<indexValue[1]){
				map.put(scoresDublicate.get(i), "D");
				//System.out.println(map.get(i));
				System.out.print("\n"+scoresDublicate.get(i)+" D");
				scoresWithGrades.add(map);
			}
		//if score is >= 4nd 20% index an F
			else {
				map.put(scoresDublicate.get(i), "F");
				//System.out.println(map.get(i));
				System.out.print("\n"+scoresDublicate.get(i)+" F");
				scoresWithGrades.add(map);
			}
			
		}
		
		
		System.out.println("\n scoresWithGrades Size "+scoresWithGrades.size()+"\n"+scoresWithGrades.get(0));
	}	
	
	
	//retures a percentile index Score
	 public static Integer Percentile(List<Integer> listScores, double Percentile)
	    {
	        
	        int Index = (int)Math.ceil(((double)Percentile / (double)100) * (double)listScores.size());
	        return listScores.get(Index-1);
	    }
	 

	public static void main(String[] args)
    {
		Main a = new Main();
		
		//Create a random list of 20 int 
		List<Integer> scores = a.setScores(20);
		
		a.atheniumGrading(scores);
		//a.top_20(scores, scores.size());
		//a.getScores(scores);
		
		//Use a list 
		List<Integer> loadScores=null;
		
		if(loadScores!=null){
			List<Integer> scores1 = a.setScores(loadScores);
			a.atheniumGrading(scores1);
			//a.getScores(scores1);
		}
		
		
    }
	
}
