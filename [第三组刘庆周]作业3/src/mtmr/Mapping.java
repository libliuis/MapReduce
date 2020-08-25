package mtmr;

import java.util.ArrayList;

public class Mapping {
	ArrayList<Pair<String,Integer>> AP = new ArrayList<Pair<String,Integer>>();
	
	public void mapping(ArrayList<String> AS) {
		for(String stmp:AS) {
			AP.add(new Pair<String, Integer>(stmp, 1));
		}
	}
	
	public ArrayList<Pair<String,Integer>> getMappingResults(){
		return AP;
	}
}
