package Main;

import java.util.HashMap;
import java.util.Map;

import uppaal.UppaalResult;
import agent.Agent;
import algorithm.MCMCSearch;

public class Main4a2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, Integer> costMap = new HashMap<Integer, Integer>();
		
		costMap.put(0, 4940);
		costMap.put(1, 4536);
		costMap.put(2, 4545);
		costMap.put(3, 4940);
		costMap.put(4, 5141);
		costMap.put(5, 4616);
		costMap.put(6, 4569);
		costMap.put(7, 4529);
		costMap.put(8, 3963);
		costMap.put(9, 4168);
		costMap.put(10, 3891);
		costMap.put(11, 3883);
		
		Agent a0_1 = new Agent(1, 0, 5, 1, 5000, 1, "a");
		
		Agent a1_1 = new Agent(1, 4, 10, 1, 5000, 1, "a");
		
		Agent a2_1 = new Agent(1, 8, 1, 1, 5000, 1, "a");
		
		Agent a3_1 = new Agent(1, 10, 2, 1, 5000, 1, "a");
		
		Agent a4_1 = new Agent(1, 2, 10, 1, 5000, 1, "a");
		
		long before;
		long after;
		UppaalResult ur;
		String c = "";
		String t = "";
		
		for(int i = 0; i < 12; i++){
			Agent[] agents0 = {new Agent(0, i, i, 1, 500, 1, "user"), a0_1};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search(agents0, i, costMap.get(i), 3600, 0.1, 120000);
			after = System.currentTimeMillis();
			c += ur.getCost() + "\n";
			t += (after-before) + "\n";
			
			Agent[] agents1 = {new Agent(0, i, i, 1, 500, 1, "user"), a1_1};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search(agents1, i, costMap.get(i), 3600, 0.1, 120000);
			after = System.currentTimeMillis();
			c += ur.getCost() + "\n";
			t += (after-before) + "\n";
		
			Agent[] agents2 = {new Agent(0, i, i, 1, 500, 1, "user"), a2_1};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search(agents2, i, costMap.get(i), 3600, 0.1, 120000);
			after = System.currentTimeMillis();
			c += ur.getCost() + "\n";
			t += (after-before) + "\n";
			
			Agent[] agents3 = {new Agent(0, i, i, 1, 500, 1, "user"), a3_1};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search(agents3, i, costMap.get(i), 3600, 0.1, 120000);
			after = System.currentTimeMillis();
			c += ur.getCost() + "\n";
			t += (after-before) + "\n";
			
			Agent[] agents4 = {new Agent(0, i, i, 1, 500, 1, "user"), a4_1};
			before = System.currentTimeMillis();
			ur = MCMCSearch.search(agents4, i, costMap.get(i), 3600, 0.1, 120000);
			after = System.currentTimeMillis();
			c += ur.getCost() + "\n";
			t += (after-before) + "\n";
			
			System.out.println(i + ":");
			System.out.println(c);
			System.out.println(t);
			System.out.println("======");
			
			c = "";
			t = "";
		}

	}

}
