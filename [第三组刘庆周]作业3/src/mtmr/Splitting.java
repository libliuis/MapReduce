package mtmr;

import java.util.ArrayList;

public class Splitting extends Thread{
	ArrayList<String> AS = new ArrayList<String>();
	Mapping mp = new Mapping();
	String text = new String();
	ArrayList<Pair<String,Integer>> ms = new ArrayList<Pair<String,Integer>>();
	public Splitting(String text) {
		this.text = text;
		// TODO Auto-generated constructor stub
	}
	public void run() {
		char[] ctext = text.toCharArray();
		for(int i=0;i<text.length();i++) {
			int j = i;
			String stmp = new String();
			for(;j<text.length();j++) {
				if(ctext[j]>='A'&&ctext[j]<='Z'||ctext[j]>='a'&&ctext[j]<='z') {
					if(ctext[j]>='A'&&ctext[j]<='Z')ctext[j]+=32;
					stmp+=ctext[j];
				}
				else break;
			}
			i = j;
			if(!stmp.isEmpty()) {
				AS.add(stmp);
			}
		}
		
		mp.mapping(AS);
		ms = mp.getMappingResults();
	}
	
	public ArrayList<Pair<String,Integer>> getRes(){
		return ms;
	}
}
