package Main;

import java.util.HashMap;
import java.util.Map;

import uppaal.UppaalResult;
import agent.Agent;
import algorithm.MCMCSearch;

public class Main4a1 {

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
		
		for(int i = 0; i < 12; i++){
			Agent[] user = {new Agent(0, i, i, 1, 500, 1, "user")};
			
			long before = System.currentTimeMillis();
			UppaalResult ur = MCMCSearch.search(user, i, costMap.get(i), 1800, 0.1, 120000);
			long after = System.currentTimeMillis();
			
			long t = after - before;
			if(ur == null)
				System.out.println("unsatisfied, " + t);
			else
				System.out.println(ur.getCost() + ", " + t);
		}

	}

}
