package mtmr;

import java.util.ArrayList;

public class Shuffling extends Thread{
	ArrayList<Pair<String,Integer>> APSI = new ArrayList<Pair<String,Integer>>();
	ArrayList<ArrayList<Pair<String,Integer>>> AAP;
	char startchar;
	char endchar;
	public Shuffling(ArrayList<ArrayList<Pair<String,Integer>>> AAP, char startchar, char endchar) {
		// TODO Auto-generated constructor stub
		this.AAP = AAP;
		this.startchar = startchar;
		this.endchar = endchar;
	}
	public void run() {
		for(ArrayList<Pair<String,Integer>> AP:AAP) {
			for(Pair<String,Integer> PSI:AP) {
				if(PSI.getKey().charAt(0)>=startchar&&PSI.getKey().charAt(0)<=endchar) {
					APSI.add(PSI);
				}
			}
		}
	}
	public ArrayList<Pair<String,Integer>> getShufflingResults(){
		return APSI;
	}
}
