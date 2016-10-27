package Main;

import uppaal.UppaalResult;
import agent.Agent;
import algorithm.MCMCSearch;

public class OAMain {
	

	public static void main(String[] args) {
	
		for(int i = 0; i < 12; i++){
			Agent[] user = {new Agent(0, i, i, 1, 500, 1, "user")};
			
			long before = System.currentTimeMillis();
			UppaalResult ur = MCMCSearch.search4all(user, i, 3600);
			long after = System.currentTimeMillis();
			
			long t = after - before;
			if(ur == null)
				System.out.println("unsatisfied, " + t);
			else
				System.out.println(ur.getCost() + ", " + t);
		}
	}

}
