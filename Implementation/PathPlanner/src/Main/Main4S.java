package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import uppaal.UppaalResult;
import agent.Agent;
import algorithm.MCMCSearch;

public class Main4S {
	public static void main(String[] args) {
		
		Map<Integer, Integer> costMapN1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> costMapN2 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> costMapN3 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> costMapN4 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> costMapN5 = new HashMap<Integer, Integer>();
		
		costMapN1.put(0, 5801);
		costMapN1.put(1, 5541);
		costMapN1.put(2, 5166);
		costMapN1.put(3, 5541);
		costMapN1.put(4, 5681);
		costMapN1.put(5, 5156);
		costMapN1.put(6, 5681);
		costMapN1.put(7, 5521);
		costMapN1.put(8, 5941);
		costMapN1.put(9, 5841);
		costMapN1.put(10, 6261);
		costMapN1.put(11, 6121);
		
		costMapN2.put(0, 4940);
		costMapN2.put(1, 4536);
		costMapN2.put(2, 4545);
		costMapN2.put(3, 4940);
		costMapN2.put(4, 5141);
		costMapN2.put(5, 4616);
		costMapN2.put(6, 5060);
		costMapN2.put(7, 4934);
		costMapN2.put(8, 5401);
		costMapN2.put(9, 5301);
		costMapN2.put(10, 5721);
		costMapN2.put(11, 5581);
		
		costMapN3.put(0, 4940);
		costMapN3.put(1, 4536);
		costMapN3.put(2, 4545);
		costMapN3.put(3, 4940);
		costMapN3.put(4, 5141);
		costMapN3.put(5, 4616);
		costMapN3.put(6, 4419);
		costMapN3.put(7, 4379);
		costMapN3.put(8, 3813);
		costMapN3.put(9, 4379);
		costMapN3.put(10, 3822);
		costMapN3.put(11, 4099);
		
		costMapN4.put(0, 4940);
		costMapN4.put(1, 4536);
		costMapN4.put(2, 4545);
		costMapN4.put(3, 4940);
		costMapN4.put(4, 5118);
		costMapN4.put(5, 4616);
		costMapN4.put(6, 4319);
		costMapN4.put(7, 4279);
		costMapN4.put(8, 3713);
		costMapN4.put(9, 3918);
		costMapN4.put(10, 3641);
		costMapN4.put(11, 3633);
		
		costMapN5.put(0, 3860);
		costMapN5.put(1, 3151);
		costMapN5.put(2, 3277);
		costMapN5.put(3, 3517);
		costMapN5.put(4, 3597);
		costMapN5.put(5, 3151);
		costMapN5.put(6, 3002);
		costMapN5.put(7, 2982);
		costMapN5.put(8, 2151);
		costMapN5.put(9, 3162);
		costMapN5.put(10, 2862);
		costMapN5.put(11, 2651);
		
		Map<Integer, Map<Integer, Integer>> costMap = new HashMap<Integer, Map<Integer, Integer>>();
		costMap.put(1, costMapN1);
		costMap.put(2, costMapN2);
		costMap.put(3, costMapN3);
		costMap.put(4, costMapN4);
		costMap.put(5, costMapN5);
		costMap.put(6, costMapN5);
		costMap.put(7, costMapN5);
		costMap.put(8, costMapN5);
		costMap.put(9, costMapN5);
		costMap.put(10, costMapN5);
		
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
		
		int timeconstraint = 3600;
//		int num = 7;
		int timelimit = 600000;
		
		long before;
		long after;
		UppaalResult ur;
		String c = "";
		String t = "";
		String out = "";
		
		for(int num = 5; num <= 5; num++){
		out = out + "num: " + num + "\n";
		for(int i = 0; i < 12; i++){
			Agent[] agents0 = {new Agent(0, i, i, 1, 500, 1, "user"), a0_1, a0_2, a0_3 , a0_4};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search4S(agents0, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
			after = System.currentTimeMillis();
			if(ur!=null){
				c += ur.getCost() + "\n";
			}
			else{
				c += "null\n";
			}
			t += (after-before) + "\n";
			
			Agent[] agents1 = {new Agent(0, i, i, 1, 500, 1, "user"), a1_1, a1_2, a1_3, a1_4};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search4S(agents1, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
			after = System.currentTimeMillis();
			if(ur!=null){
				c += ur.getCost() + "\n";
			}
			else{
				c += "null\n";
			}
			t += (after-before) + "\n";
		
			Agent[] agents2 = {new Agent(0, i, i, 1, 500, 1, "user"), a2_1, a2_2, a2_3, a2_4};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search4S(agents2, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
			after = System.currentTimeMillis();
			if(ur!=null){
				c += ur.getCost() + "\n";
			}
			else{
				c += "null\n";
			}
			t += (after-before) + "\n";
			
			Agent[] agents3 = {new Agent(0, i, i, 1, 500, 1, "user"), a3_1, a3_2, a3_3, a3_4};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search4S(agents3, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
			after = System.currentTimeMillis();
			if(ur!=null){
				c += ur.getCost() + "\n";
			}
			else{
				c += "null\n";
			}
			t += (after-before) + "\n";
			
			Agent[] agents4 = {new Agent(0, i, i, 1, 500, 1, "user"), a4_1, a4_2, a4_3, a4_4};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search4S(agents4, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
			after = System.currentTimeMillis();
			if(ur!=null){
				c += ur.getCost() + "\n";
			}
			else{
				c += "null\n";
			}
			t += (after-before) + "\n";
			
			System.out.println("num: " + num);
			System.out.println(i + ":");
			System.out.println(c);
			System.out.println(t);
			System.out.println("======");
			
			out = out + i + ":" + "\n" + c + "\n" + t + "\n" + "=====\n";
			
			c = "";
			t = "";
		}
		}
		
//		FileWriter fw1;
//		try {
//			File file1 = new File("E:\\selab\\myPaper\\icse2015\\FSE2016\\1A.txt");
//			if(!file1.exists())
//				file1.createNewFile();
//			fw1 = new FileWriter(file1,true);
//			fw1.write(out);  
//	        fw1.flush();  
//	        fw1.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		
//		out = "";
//		for(int num = 6; num <= 7; num++){
//			out = out + "num: " + num + "\n";
//			for(int i = 0; i < 12; i++){
//				Agent[] agents0 = {new Agent(0, i, i, 1, 500, 1, "user"), a0_1, a0_2/*, a0_3, a0_4*/};
//				before = System.currentTimeMillis();
//				ur = MCMCSearch.search4S(agents0, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//				after = System.currentTimeMillis();
//				if(ur!=null){
//					c += ur.getCost() + "\n";
//				}
//				else{
//					c += "null\n";
//				}
//				t += (after-before) + "\n";
//				
//				Agent[] agents1 = {new Agent(0, i, i, 1, 500, 1, "user"), a1_1, a1_2/*, a1_3, a1_4*/};
//				before = System.currentTimeMillis();
//				ur = MCMCSearch.search4S(agents1, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//				after = System.currentTimeMillis();
//				if(ur!=null){
//					c += ur.getCost() + "\n";
//				}
//				else{
//					c += "null\n";
//				}
//				t += (after-before) + "\n";
//			
//				Agent[] agents2 = {new Agent(0, i, i, 1, 500, 1, "user"), a2_1, a2_2/*, a2_3, a2_4*/};
//				before = System.currentTimeMillis();
//				ur = MCMCSearch.search4S(agents2, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//				after = System.currentTimeMillis();
//				if(ur!=null){
//					c += ur.getCost() + "\n";
//				}
//				else{
//					c += "null\n";
//				}
//				t += (after-before) + "\n";
//				
//				Agent[] agents3 = {new Agent(0, i, i, 1, 500, 1, "user"), a3_1, a3_2/*, a3_3, a3_4*/};
//				before = System.currentTimeMillis();
//				ur = MCMCSearch.search4S(agents3, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//				after = System.currentTimeMillis();
//				if(ur!=null){
//					c += ur.getCost() + "\n";
//				}
//				else{
//					c += "null\n";
//				}
//				t += (after-before) + "\n";
//				
//				Agent[] agents4 = {new Agent(0, i, i, 1, 500, 1, "user"), a4_1, a4_2/*, a4_3, a4_4*/};
//				before = System.currentTimeMillis();
//				ur = MCMCSearch.search4S(agents4, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//				after = System.currentTimeMillis();
//				if(ur!=null){
//					c += ur.getCost() + "\n";
//				}
//				else{
//					c += "null\n";
//				}
//				t += (after-before) + "\n";
//				
//				System.out.println("num: " + num);
//				System.out.println(i + ":");
//				System.out.println(c);
//				System.out.println(t);
//				System.out.println("======");
//				
//				out = out + i + ":" + "\n" + c + "\n" + t + "\n" + "=====\n";
//				
//				c = "";
//				t = "";
//			}
//			}
//			
//			FileWriter fw2;
//			try {
//				File file2 = new File("E:\\selab\\myPaper\\icse2015\\FSE2016\\3A67.txt");
//				if(!file2.exists())
//					file2.createNewFile();
//				fw2 = new FileWriter(file2,true);
//				fw2.write(out);  
//		        fw2.flush();  
//		        fw2.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}  
//			
//			out = "";
//			for(int num = 6; num <= 7; num++){
//				out = out + "num: " + num + "\n";
//				for(int i = 0; i < 12; i++){
//					Agent[] agents0 = {new Agent(0, i, i, 1, 500, 1, "user"), a0_1/*, a0_2, a0_3, a0_4*/};
//					before = System.currentTimeMillis();
//					ur = MCMCSearch.search4S(agents0, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//					after = System.currentTimeMillis();
//					if(ur!=null){
//						c += ur.getCost() + "\n";
//					}
//					else{
//						c += "null\n";
//					}
//					t += (after-before) + "\n";
//					
//					Agent[] agents1 = {new Agent(0, i, i, 1, 500, 1, "user"), a1_1/*, a1_2, a1_3, a1_4*/};
//					before = System.currentTimeMillis();
//					ur = MCMCSearch.search4S(agents1, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//					after = System.currentTimeMillis();
//					if(ur!=null){
//						c += ur.getCost() + "\n";
//					}
//					else{
//						c += "null\n";
//					}
//					t += (after-before) + "\n";
//				
//					Agent[] agents2 = {new Agent(0, i, i, 1, 500, 1, "user"), a2_1/*, a2_2, a2_3, a2_4*/};
//					before = System.currentTimeMillis();
//					ur = MCMCSearch.search4S(agents2, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//					after = System.currentTimeMillis();
//					if(ur!=null){
//						c += ur.getCost() + "\n";
//					}
//					else{
//						c += "null\n";
//					}
//					t += (after-before) + "\n";
//					
//					Agent[] agents3 = {new Agent(0, i, i, 1, 500, 1, "user"), a3_1/*, a3_2, a3_3, a3_4*/};
//					before = System.currentTimeMillis();
//					ur = MCMCSearch.search4S(agents3, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//					after = System.currentTimeMillis();
//					if(ur!=null){
//						c += ur.getCost() + "\n";
//					}
//					else{
//						c += "null\n";
//					}
//					t += (after-before) + "\n";
//					
//					Agent[] agents4 = {new Agent(0, i, i, 1, 500, 1, "user"), a4_1/*, a4_2, a4_3, a4_4*/};
//					before = System.currentTimeMillis();
//					ur = MCMCSearch.search4S(agents4, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//					after = System.currentTimeMillis();
//					if(ur!=null){
//						c += ur.getCost() + "\n";
//					}
//					else{
//						c += "null\n";
//					}
//					t += (after-before) + "\n";
//					
//					System.out.println("num: " + num);
//					System.out.println(i + ":");
//					System.out.println(c);
//					System.out.println(t);
//					System.out.println("======");
//					
//					out = out + i + ":" + "\n" + c + "\n" + t + "\n" + "=====\n";
//					
//					c = "";
//					t = "";
//				}
//				}
//				
//				FileWriter fw3;
//				try {
//					File file3 = new File("E:\\selab\\myPaper\\icse2015\\FSE2016\\2A67.txt");
//					if(!file3.exists())
//						file3.createNewFile();
//					fw3 = new FileWriter(file3,true);
//					fw3.write(out);  
//			        fw3.flush();  
//			        fw3.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}  
//				
//				out = "";
//				for(int num = 6; num <= 7; num++){
//					out = out + "num: " + num + "\n";
//					for(int i = 0; i < 12; i++){
//						Agent[] agents0 = {new Agent(0, i, i, 1, 500, 1, "user")/*, a0_1, a0_2, a0_3, a0_4*/};
//						before = System.currentTimeMillis();
//						ur = MCMCSearch.search4S(agents0, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//						after = System.currentTimeMillis();
//						if(ur!=null){
//							c += ur.getCost() + "\n";
//						}
//						else{
//							c += "null\n";
//						}
//						t += (after-before) + "\n";
//						
//						Agent[] agents1 = {new Agent(0, i, i, 1, 500, 1, "user")/*, a1_1, a1_2, a1_3, a1_4*/};
//						before = System.currentTimeMillis();
//						ur = MCMCSearch.search4S(agents1, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//						after = System.currentTimeMillis();
//						if(ur!=null){
//							c += ur.getCost() + "\n";
//						}
//						else{
//							c += "null\n";
//						}
//						t += (after-before) + "\n";
//					
//						Agent[] agents2 = {new Agent(0, i, i, 1, 500, 1, "user")/*, a2_1, a2_2, a2_3, a2_4*/};
//						before = System.currentTimeMillis();
//						ur = MCMCSearch.search4S(agents2, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//						after = System.currentTimeMillis();
//						if(ur!=null){
//							c += ur.getCost() + "\n";
//						}
//						else{
//							c += "null\n";
//						}
//						t += (after-before) + "\n";
//						
//						Agent[] agents3 = {new Agent(0, i, i, 1, 500, 1, "user")/*, a3_1, a3_2, a3_3, a3_4*/};
//						before = System.currentTimeMillis();
//						ur = MCMCSearch.search4S(agents3, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//						after = System.currentTimeMillis();
//						if(ur!=null){
//							c += ur.getCost() + "\n";
//						}
//						else{
//							c += "null\n";
//						}
//						t += (after-before) + "\n";
//						
//						Agent[] agents4 = {new Agent(0, i, i, 1, 500, 1, "user")/*, a4_1, a4_2, a4_3, a4_4*/};
//						before = System.currentTimeMillis();
//						ur = MCMCSearch.search4S(agents4, i, costMap.get(num).get(i), timeconstraint, 0.1, timelimit, num);
//						after = System.currentTimeMillis();
//						if(ur!=null){
//							c += ur.getCost() + "\n";
//						}
//						else{
//							c += "null\n";
//						}
//						t += (after-before) + "\n";
//						
//						System.out.println("num: " + num);
//						System.out.println(i + ":");
//						System.out.println(c);
//						System.out.println(t);
//						System.out.println("======");
//						
//						out = out + i + ":" + "\n" + c + "\n" + t + "\n" + "=====\n";
//						
//						c = "";
//						t = "";
//					}
//					}
//					
//					FileWriter fw4;
//					try {
//						File file4 = new File("E:\\selab\\myPaper\\icse2015\\FSE2016\\1A67.txt");
//						if(!file4.exists())
//							file4.createNewFile();
//						fw4 = new FileWriter(file4,true);
//						fw4.write(out);  
//				        fw4.flush();  
//				        fw4.close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}  
        
	}

}
