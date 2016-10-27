//package Main;
//
//import java.io.BufferedReader;
//import java.io.FileWriter;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.List;
//
//import agent.Agent;
//import algorithm.MCMCSearch;
//import service.CompositionService;
//import service.InitCompositionServices;
//import uppaal.UppaalPlan;
//
//public class Main {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
////		List<CompositionService> compositionServices = InitCompositionServices.init(0);
////		int compositionServicesAmount = compositionServices.size();
////		int index = (int)(Math.random()*compositionServicesAmount);
//		
//		Agent a0_1 = new Agent(1, 0, 5, 1, 5000, 1, "a");
//		Agent a0_2 = new Agent(2, 1, 9, 1, 5000, 1, "b");
//		Agent a0_3 = new Agent(3, 3, 8, 1, 5000, 1, "c");
//		Agent a0_4 = new Agent(4, 2, 11, 1, 5000, 1, "d");
//		
//		Agent a1_1 = new Agent(1, 4, 10, 1, 5000, 1, "a");
//		Agent a1_2 = new Agent(2, 1, 10, 1, 5000, 1, "b");
//		Agent a1_3 = new Agent(3, 3, 6, 1, 5000, 1, "c");
//		Agent a1_4 = new Agent(4, 2, 7, 1, 5000, 1, "d");
//		
//		Agent a2_1 = new Agent(1, 8, 1, 1, 5000, 1, "a");
//		Agent a2_2 = new Agent(2, 5, 10, 1, 5000, 1, "b");
//		Agent a2_3 = new Agent(3, 6, 3, 1, 5000, 1, "c");
//		Agent a2_4 = new Agent(4, 8, 4, 1, 5000, 1, "d");
//		
//		Agent a3_1 = new Agent(1, 10, 2, 1, 5000, 1, "a");
//		Agent a3_2 = new Agent(2, 5, 11, 1, 5000, 1, "b");
//		Agent a3_3 = new Agent(3, 0, 10, 1, 5000, 1, "c");
//		Agent a3_4 = new Agent(4, 7, 0, 1, 5000, 1, "d");
//		
//		Agent a4_1 = new Agent(1, 2, 10, 1, 5000, 1, "a");
//		Agent a4_2 = new Agent(2, 11, 3, 1, 5000, 1, "b");
//		Agent a4_3 = new Agent(3, 4, 8, 1, 5000, 1, "c");
//		Agent a4_4 = new Agent(4, 2, 9, 1, 5000, 1, "d");
//		
////		Agent a0_5 = new Agent(4, 2, 7, 1, 5000, 1, "e");
////		Agent[] agents = {a1, a2, a3, a4, a5};
////		Agent[] agents = {a1, a2, a3};
//		
////		UppaalPlan.generateUppaalFile(compositionServices.get(0), agents, "e:\\temp\\paper\\paper.xml");
//		
////		long t1 = System.currentTimeMillis();
//		
//		long before;
//		long after;
//		
//		for(int i = 0; i < 12; i++){
//			Agent[] agents0 = {new Agent(0, i, i, 1, 5000, 1, "u"), a0_1, a0_2, a0_3, a0_4};
//			//int c0 = MCMCSearch.search4all(agents0, i);
//			before = System.currentTimeMillis();
//			int c0 = MCMCSearch.search(agents0, i, 3800);
//			after = System.currentTimeMillis();
//			int t0 = (int) (after - before);
//			
//			Agent[] agents1 = {new Agent(0, i, i, 1, 5000, 1, "u"), a1_1, a1_2, a1_3, a1_4};
////			int c1 = MCMCSearch.search4all(agents1, i);
//			before = System.currentTimeMillis();
//			int c1 = MCMCSearch.search(agents1, i, 3800);
//			after = System.currentTimeMillis();
//			int t1 = (int) (after - before);
//			
//			Agent[] agents2 = {new Agent(0, i, i, 1, 5000, 1, "u"), a2_1, a2_2, a2_3, a2_4};
////			int c2 = MCMCSearch.search4all(agents2, i);
//			before = System.currentTimeMillis();
//			int c2 = MCMCSearch.search(agents2, i, 3800);
//			after = System.currentTimeMillis();
//			int t2 = (int) (after - before);
//			
//			Agent[] agents3 = {new Agent(0, i, i, 1, 5000, 1, "u"), a3_1, a3_2, a3_3, a3_4};
////			int c3 = MCMCSearch.search4all(agents3, i);
//			before = System.currentTimeMillis();
//			int c3 = MCMCSearch.search(agents3, i, 3800);
//			after = System.currentTimeMillis();
//			int t3 = (int) (after - before);
//			
//			Agent[] agents4 = {new Agent(0, i, i, 1, 5000, 1, "u"), a4_1, a4_2, a4_3, a4_4};
////			int c4 = MCMCSearch.search4all(agents4, i);
//			before = System.currentTimeMillis();
//			int c4 = MCMCSearch.search(agents4, i, 3800);
//			after = System.currentTimeMillis();
//			int t4 = (int) (after - before);
//			
//			int avg_c = (c0 + c1 + c2 + c3 + c4) / 5;
//			int avg_t = (t0 + t1 + t2 + t3 + t4) / 5;
//			
//			System.out.println("cost: " + c0 + ", " + c1 + ", " + c2 + ", " + c3 + ", " + c4 + ", avg_c:" + avg_c);
//			System.out.println("time: " + c0 + ", " + c1 + ", " + c2 + ", " + c3 + ", " + c4 + ", avg_t:" + avg_t);
//		}
//		
////		long t2 = System.currentTimeMillis();
////		System.out.println(t2-t1);
//	}
//
//}
