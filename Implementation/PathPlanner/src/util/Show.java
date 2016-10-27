package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uppaal.UppaalResult;

public class Show {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String commandStr = "e:\\temp\\paper\\verifyta -t3 e:\\temp\\paper\\a2.xml e:\\temp\\paper\\a2.q";
		BufferedReader br = null;  
		boolean satisfied = false;
		String result = "";
        try {  
            Process p = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(p.getInputStream())); 
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) { 
                sb.append(line + "\n");
                if(line.contains("Property is satisfied"))
                	satisfied = true;
                if(line.contains("Best solution"))
                	result = line;
                if(line.contains("Showing example trace"))
                	break;
            }
            if(satisfied){
            	br = new BufferedReader(new InputStreamReader(p.getErrorStream())); 
                line = null;
                while ((line = br.readLine()) != null) { 
                	System.out.println(line);
                }
            }
        } catch (Exception e) {  
            e.printStackTrace();
        }
	}

}
