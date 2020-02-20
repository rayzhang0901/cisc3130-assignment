import java.util.*;	
import java.io.*;
/*
 * JingYi Zhang
 */

public class assign1
{

	ArrayList<Song> topList = new ArrayList<Song>();
    HashMap<Song, Integer> songCount = new HashMap<Song,Integer>();
    
    public static void main(String[] args) throws FileNotFoundException {
    	PrintStream o = new PrintStream(new File("output.txt")); 
        new assign1().go();
    }
   
    public void go() throws FileNotFoundException {
        getSongs();
    songCounting();
	 ArrayList<Song> newList = removeDuplicates(topList); 
	 PrintStream o = new PrintStream(new File("output.txt")); 
	 PrintStream console = System.out; 
	   //Collections.sort(newList);
	  //  System.setOut(o); 
	   for (int i = 0 ; i < topList.size() ; i++) {
		    System.out.printf("%d\t%d\n", newList.get(i), songCount.get(i));
		}
	    //System.out.println(newList.toString().replaceAll("^.|.$", "").replace(", ", "\n"));
    	//System.setOut(o); 
	    //System.out.println(songCount.toString().replaceAll("^.|.$", "").replace(", ", "\n"));
    }
   
    void getSongs() {
        try {
            File file = new File("topList.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line=reader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }
    void songCounting() {
    for(Song s:topList) {
    if(songCount.containsKey(s)) {
    songCount.put(s,songCount.get(s)+1);
    }
    else songCount.put(s,1);
    }
    }
    void addSong(String lineToParse) {		
        String[]tokens = lineToParse.split(",");
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        topList.add(nextSong);
    }
	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> topList) //method to remove the duplicate values in the list
    { 
		ArrayList<T> newList = new ArrayList<T>();
        for (T element : topList) { 
            if (!newList.contains(element)) {   
                newList.add(element); 
            } 
        }
		return newList; 
    }
}
