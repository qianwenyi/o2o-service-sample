package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Howmanyagents {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int timeconstraint = 3600;
		
		String a0l = null;
		String a1l = null;
		String a2l = null;
		
		int a1c = 0;
		int a2c = 0;
		int a3c = 0;
		
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 5; j++){
				File file = new File("E:\\selab\\myPaper\\icse2015\\FSE2016\\5AD\\" + timeconstraint + "\\5A" + j + "g"+i+"d"+timeconstraint+".txt");
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = "";
				while((line = br.readLine()) != null){
					Pattern pattern1 = Pattern.compile("agentAt\\[0\\]=\\d+");
                	Pattern pattern2 = Pattern.compile("agentAt\\[1\\]=\\d+");
                	Pattern pattern3 = Pattern.compile("agentAt\\[2\\]=\\d+");
                	Matcher matcher = pattern1.matcher(line);
                	while(matcher.find()){
                		String a0l_new = matcher.group();
                		if(a0l == null)
                			a0l = a0l_new;
                		else{
                			if(!a0l.equals(a0l_new))
                				a1c++;
                			a0l = a0l_new;
                		}
                	}
                	matcher = pattern2.matcher(line);
                	while(matcher.find()){
                		String a1l_new = matcher.group();
                		if(a1l == null)
                			a1l = a1l_new;
                		else{
                			if(!a1l.equals(a1l_new))
                				a2c++;
                			a1l = a1l_new;
                		}
                	}
                	matcher = pattern3.matcher(line);
                	while(matcher.find()){
                		String a2l_new = matcher.group();
                		if(a2l == null)
                			a2l = a2l_new;
                		else{
                			if(!a2l.equals(a2l_new))
                				a3c++;
                			a2l = a2l_new;
                		}
                	}
				}
				
				int result = 0;
				if(a1c > 1)
					result++;
				if(a2c > 1)
					result++;
				if(a3c > 1)
					result++;
				
//				System.out.println(j + "g" + i + "l:");
				System.out.println(result);
				
				a0l = null;
				a1l = null;
				a2l = null;
				
				a1c = 0;
				a2c = 0;
				a3c = 0;
			}
			System.out.println();
		}
		
	}

}
