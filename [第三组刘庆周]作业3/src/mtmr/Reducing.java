package mtmr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Reducing extends Thread {
	Map<String, Integer> Rm = new TreeMap<String, Integer>();
	ArrayList<Pair<String,Integer>> AP;
	public Reducing(ArrayList<Pair<String,Integer>> AP) {
		this.AP = AP;
		// TODO Auto-generated constructor stub
	}
	public void run() {
		for(Pair<String,Integer> PSI:AP) {
			if(Rm.containsKey(PSI.getKey())) {
				Rm.put(PSI.getKey(),Rm.get(PSI.getKey())+1);
			}
			else {
				Rm.put(PSI.getKey(),PSI.getValue());
			}
		}
	}
	
	public Map<String, Integer> getReducingResults(){
		return Rm;
	}
}
