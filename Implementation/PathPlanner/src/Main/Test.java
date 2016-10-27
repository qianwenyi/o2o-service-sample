package Main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import agent.Agent;
import algorithm.MCMCSearch;
import service.CompositionService;
import service.CompositionServiceIndex;
import service.InitCompositionServices;
import uppaal.UppaalPlan;
import uppaal.UppaalResult;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 12; i++){
			Agent[] user = {new Agent(0, i, i, 1, 500, 1, "user")};
			
			for(int j = 6; j <= 10; j++){
				UppaalResult ur = MCMCSearch.search4all4S(user, i, 3600, j);
				
				if(ur == null)
					System.out.println("L: " + i + ", num: " + j + ", unsatisfied");
				else
					System.out.println("L: " + i + ", num: " + j + ", " + ur.getCost());
			}
		}
	}

}
