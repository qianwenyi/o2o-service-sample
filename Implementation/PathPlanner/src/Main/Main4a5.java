package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import uppaal.UppaalResult;
import agent.Agent;
import algorithm.MCMCSearch;

public class Main4a5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, Integer> costMap = new HashMap<Integer, Integer>();
		
		costMap.put(0, 4940);
		costMap.put(1, 4536);
		costMap.put(2, 4545);
		costMap.put(3, 4940);
		costMap.put(4, 5140);
		costMap.put(5, 4616);
		costMap.put(6, 4569);
		costMap.put(7, 4529);
		costMap.put(8, 3963);
		costMap.put(9, 4168);
		costMap.put(10, 3891);
		costMap.put(11, 3883);
		
//		costMap.put(0, 5500);
//		costMap.put(1, 4536);
//		costMap.put(2, 5500);
//		costMap.put(3, 5500);
//		costMap.put(4, 5500);
//		costMap.put(5, 4615);
//		costMap.put(6, 5500);
//		costMap.put(7, 5500);
//		costMap.put(8, 5500);
//		costMap.put(9, 5500);
//		costMap.put(10, 5500);
//		costMap.put(11, 3883);
		
		Agent a0_1 = new Agent(1, 0, 6, 1, 5000, 1, "a");
		Agent a0_2 = new Agent(2, 1, 9, 1, 5000, 1, "b");
		Agent a0_3 = new Agent(3, 3, 8, 1, 5000, 1, "c");
		Agent a0_4 = new Agent(4, 2, 11, 1, 5000, 1, "d");
		
		Agent a1_1 = new Agent(1, 4, 10, 1, 5000, 1, "a");
		Agent a1_2 = new Agent(2, 1, 10, 1, 5000, 1, "b");
		Agent a1_3 = new Agent(3, 3, 6, 1, 5000, 1, "c");
		Agent a1_4 = new Agent(4, 2, 7, 1, 5000, 1, "d");
		
		Agent a2_1 = new Agent(1, 8, 1, 1, 5000, 1, "a");
		Agent a2_2 = new Agent(2, 5, 10, 1, 5000, 1, "b");
		Agent a2_3 = new Agent(3, 6, 3, 1, 5000, 1, "c");
		Agent a2_4 = new Agent(4, 8, 4, 1, 5000, 1, "d");
		
		Agent a3_1 = new Agent(1, 10, 2, 1, 5000, 1, "a");
		Agent a3_2 = new Agent(2, 5, 11, 1, 5000, 1, "b");
		Agent a3_3 = new Agent(3, 0, 10, 1, 5000, 1, "c");
		Agent a3_4 = new Agent(4, 7, 0, 1, 5000, 1, "d");
		
		Agent a4_1 = new Agent(1, 2, 10, 1, 5000, 1, "a");
		Agent a4_2 = new Agent(2, 11, 3, 1, 5000, 1, "b");
		Agent a4_3 = new Agent(3, 4, 8, 1, 5000, 1, "c");
		Agent a4_4 = new Agent(4, 2, 9, 1, 5000, 1, "d");
		
		int timeconstraint = 3000;
		
		long before;
		long after;
		UppaalResult ur;
		String c = "";
		String t = "";
		
		for(int i = 0; i < 12; i++){
//			if(i!=1 && i!=3 && i!=7 && i!=9 && i!=11)
//				continue;
			Agent[] agents0 = {new Agent(0, i, i, 1, 500, 1, "user"), a0_1, a0_2, a0_3, a0_4};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search(agents0, i, costMap.get(i), timeconstraint, 0.1, 120000);
			after = System.currentTimeMillis();
			if(ur!=null){
				c += ur.getCost() + "\n";
			}
			else{
				c += "null\n";
			}
			t += (after-before) + "\n";
			
			FileWriter fw1;
			try {
				File file1 = new File("E:\\selab\\myPaper\\icse2015\\FSE2016\\5AD\\5A0g"+i+"d"+timeconstraint+".txt");
				if(!file1.exists())
					file1.createNewFile();
				fw1 = new FileWriter(file1,true);
				if(ur!=null){
					if(ur.getScheduls()!=null)
						fw1.write(ur.getScheduls()); 
				}
				else
					fw1.write("null");
		        fw1.flush();  
		        fw1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			Agent[] agents1 = {new Agent(0, i, i, 1, 500, 1, "user"), a1_1, a1_2, a1_3, a1_4};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search(agents1, i, costMap.get(i), timeconstraint, 0.1, 120000);
			after = System.currentTimeMillis();
			if(ur!=null){
				c += ur.getCost() + "\n";
			}
			else{
				c += "null\n";
			}
			t += (after-before) + "\n";
			
			FileWriter fw2;
			try {
				File file2 = new File("E:\\selab\\myPaper\\icse2015\\FSE2016\\5AD\\5A1g"+i+"d"+timeconstraint+".txt");
				if(!file2.exists())
					file2.createNewFile();
				fw2 = new FileWriter(file2,true);
				if(ur!=null){
					if(ur.getScheduls()!=null)
						fw2.write(ur.getScheduls()); 
				}
				else
					fw2.write("null");
		        fw2.flush();  
		        fw2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
			Agent[] agents2 = {new Agent(0, i, i, 1, 500, 1, "user"), a2_1, a2_2, a2_3, a2_4};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search(agents2, i, costMap.get(i), timeconstraint, 0.1, 120000);
			after = System.currentTimeMillis();
			if(ur!=null){
				c += ur.getCost() + "\n";
			}
			else{
				c += "null\n";
			}
			t += (after-before) + "\n";
			
			FileWriter fw3;
			try {
				File file3 = new File("E:\\selab\\myPaper\\icse2015\\FSE2016\\5AD\\5A2g"+i+"d"+timeconstraint+".txt");
				if(!file3.exists())
					file3.createNewFile();
				fw3 = new FileWriter(file3,true);
				if(ur!=null){
					if(ur.getScheduls()!=null)
						fw3.write(ur.getScheduls()); 
				}
				else
					fw3.write("null");
		        fw3.flush();  
		        fw3.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			Agent[] agents3 = {new Agent(0, i, i, 1, 500, 1, "user"), a3_1, a3_2, a3_3, a3_4};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search(agents3, i, costMap.get(i), timeconstraint, 0.1, 120000);
			after = System.currentTimeMillis();
			if(ur!=null){
				c += ur.getCost() + "\n";
			}
			else{
				c += "null\n";
			}
			t += (after-before) + "\n";
			
			FileWriter fw4;
			try {
				File file4 = new File("E:\\selab\\myPaper\\icse2015\\FSE2016\\5AD\\5A3g"+i+"d"+timeconstraint+".txt");
				if(!file4.exists())
					file4.createNewFile();
				fw4 = new FileWriter(file4,true);
				if(ur!=null){
					if(ur.getScheduls()!=null)
						fw4.write(ur.getScheduls()); 
				}
				else
					fw4.write("null");
		        fw4.flush();  
		        fw4.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			Agent[] agents4 = {new Agent(0, i, i, 1, 500, 1, "user"), a4_1, a4_2, a4_3, a4_4};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search(agents4, i, costMap.get(i), timeconstraint, 0.1, 120000);
			after = System.currentTimeMillis();
			if(ur!=null){
				c += ur.getCost() + "\n";
			}
			else{
				c += "null\n";
			}
			t += (after-before) + "\n";
			
			FileWriter fw5;
			try {
				File file5 = new File("E:\\selab\\myPaper\\icse2015\\FSE2016\\5AD\\5A4g"+i+"d"+timeconstraint+".txt");
				if(!file5.exists())
					file5.createNewFile();
				fw5 = new FileWriter(file5,true);
				if(ur!=null){
					if(ur.getScheduls()!=null)
						fw5.write(ur.getScheduls()); 
				}
				else
					fw5.write("null");
		        fw5.flush();  
		        fw5.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			System.out.println(i + ":");
			System.out.println(c);
			System.out.println(t);
			System.out.println("======");
			
			c = "";
			t = "";
		}

	}

}
