package uppaal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String commandStr = "e:\\temp\\paper\\verifyta -t3 e:\\temp\\paper\\paper.xml e:\\temp\\paper\\paper.q";
		BufferedReader br = null;  
		boolean satisfied = false;
		String result = "";
        try {  
            Process p = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(p.getInputStream())); 
            String line = null;
            while ((line = br.readLine()) != null) {
            	System.out.println(line);
                if(line.contains("Property is satisfied"))
                	satisfied = true;
                if(line.contains("Best solution"))
                	result = line;
                if(line.contains("Best:")){
                	String[] stringArray = line.split("Best:");
                	Pattern pattern = Pattern.compile("\\d+");
                	Matcher matcher = pattern.matcher(stringArray[1]);
                	while(matcher.find()){
                		System.out.println(matcher.group());
                		p.destroy();
                	}
                }
                if(line.contains("Cost:")){
                	String[] stringArray = line.split(" ");
//                	System.out.println(stringArray[9]);
                	if(Integer.parseInt(stringArray[9]) > 5500)
                		p.destroy();
                }
                if(line.contains("Showing example trace"))
                	break;
            }
        } catch (Exception e) {  
            e.printStackTrace();
        }
	}

}
