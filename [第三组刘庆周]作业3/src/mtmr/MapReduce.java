package mtmr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


public class MapReduce {
	static Fileinput FI = new Fileinput();
	static String Wholetext = new String();
	
	public static void main(String[] args) throws IOException {
		long sT=System.currentTimeMillis();
		Wholetext = FI.readFile("d:/hamlet.txt");
		int splitindex = Wholetext.length()/3;
		for(;splitindex<Wholetext.length();splitindex++) {
			if(Wholetext.charAt(splitindex)==' ')break;
		}
		int splitindex2 = splitindex + Wholetext.length()/3;
		for(;splitindex2<Wholetext.length();splitindex2++) {
			if(Wholetext.charAt(splitindex2)==' ')break;
		}
		String text1 = Wholetext.substring(0, splitindex);
		String text2 = Wholetext.substring(splitindex, splitindex2);
		String text3 = Wholetext.substring(splitindex2, Wholetext.length());
		
		
		Splitting spmp1 = new Splitting(text1);
		Splitting spmp2 = new Splitting(text2);
		Splitting spmp3 = new Splitting(text3);
		
		spmp1.start();
		spmp2.start();
		spmp3.start();
		try {
			spmp1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			

			e.printStackTrace();
		}
		try {
			spmp2.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			spmp3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		ArrayList<ArrayList<Pair<String,Integer>>> AAP = new ArrayList<ArrayList<Pair<String,Integer>>>();
		AAP.add(spmp1.getRes());
		AAP.add(spmp2.getRes());
		AAP.add(spmp3.getRes());
		Shuffling sf1 = new Shuffling(AAP,'a','f');
		Shuffling sf2 = new Shuffling(AAP,'g','t');
		Shuffling sf3 = new Shuffling(AAP,'u','z');
		sf1.start();
		sf2.start();
		sf3.start();
		try {
			sf1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sf2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sf3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Pair<String,Integer>> AP1 = sf1.getShufflingResults();
		ArrayList<Pair<String,Integer>> AP2 = sf2.getShufflingResults();
		ArrayList<Pair<String,Integer>> AP3 = sf3.getShufflingResults();
		
		Reducing rd1 = new Reducing(AP1);
		Reducing rd2 = new Reducing(AP2);
		Reducing rd3 = new Reducing(AP3);
		
		rd1.start();
		rd2.start();
		rd3.start();
		try {
			rd1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rd2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rd3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, Integer> r1 = rd1.getReducingResults();
		Map<String, Integer> r2 = rd2.getReducingResults();
		Map<String, Integer> r3 = rd3.getReducingResults();
		
		String result = new String();
		
        FileWriter fw=new FileWriter(new File("d:\\hamletout.txt"));
        BufferedWriter  bw=new BufferedWriter(fw);
		Iterator<Map.Entry<String, Integer>> it = r1.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            result= entry.getKey() + " " + entry.getValue().toString();
            bw.write(result+"\r\n");
        }
        
        it = r2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            result= entry.getKey() + " " + entry.getValue().toString();
            bw.write(result+"\r\n");
        }
        
        it = r3.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            result= entry.getKey() + " " + entry.getValue().toString();
            bw.write(result+"\r\n");
        }
        
        bw.close();
        fw.close();
		long eT=System.currentTimeMillis();                //获得当前时间
		System.out.println((eT-sT)/1000.0);  
	}
}
