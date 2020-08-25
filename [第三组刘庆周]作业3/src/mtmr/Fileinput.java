package mtmr;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Fileinput {
	public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException
	{
		InputStream is = new FileInputStream(filePath);
		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		line = reader.readLine();
		while(line!=null) {
			buffer.append(line);
			buffer.append("\n");
			line = reader.readLine();
		}
		reader.close();
		is.close();
	}
	
	public String readFile(String filePath) throws IOException{
		StringBuffer sb = new StringBuffer();
		Fileinput.readToBuffer(sb, filePath);
		return sb.toString();
	}
}

