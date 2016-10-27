package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import service.CompositionService;
import service.CompositionServiceIndex;
import service.InitCompositionServices;
import service.InitCompositionServices4S;
import uppaal.UppaalPlan;
import uppaal.UppaalResult;
import agent.Agent;

public class MCMCSearch {
	
	
	private static int[][] agentSelection = {{0, 1, 2},
			                          {0, 1, 3},
			                          {0, 1, 4},
			                          {0, 2, 3},
			                          {0, 2, 4},
			                          {0, 3, 4},
			                          {1, 2, 3},
			                          {1, 2, 4},
			                          {1, 3, 4},
			                          {2, 3, 4}};
	
	private static int[][] agentSelection2 = {{0, 1, 2},
        									  {0, 1, 3},
        									  {0, 2, 3},
        									  {1, 2, 3}};
	
	public static UppaalResult search(Agent[] agents, int userlocation, int thr, int constraint, double acceptRate, int timeLimit){
		long begin = System.currentTimeMillis();
		int n = 0;
		Set<String> index_set = new HashSet<String>();
		Map<String, CompositionService> compositionServices = InitCompositionServices.init(userlocation, constraint);
		int compositionServicesAmount = compositionServices.size();
		CompositionServiceIndex index = randomCsi();
		index_set.addAll(compositionServices.keySet());
		CompositionService compositionService = compositionServices.get(index.toString());
		UppaalResult ur = tryAllAgents(compositionService, agents, thr);
		while(ur == null || ur.getCost() >= thr){
//			System.out.println(ur.getCost());
			String new_index_string = null;
			if(index_set.size() < 1)
				break;
			for(String next_index : index_set){
				if(dis(next_index, index.toString()) <= 1){
					new_index_string = next_index;
					index_set.remove(next_index);
					break;
				}
			}
			if(new_index_string == null && index_set.size() > 0){
				new_index_string = index_set.iterator().next();
				index_set.remove(new_index_string);
			}
			else if(new_index_string == null || index_set.size() == 0)
				break;
//			System.out.println(new_index_string + ", remain:" + index_set.size());
			CompositionService new_compositionService = compositionServices.get(new_index_string);
			UppaalResult new_ur = tryAllAgents(new_compositionService, agents, thr);
			if(new_ur != null){
				if(ur == null)
					ur = new_ur;
				else{
					if(new_ur.getCost() < ur.getCost()){
						ur = new_ur;
					}
					else{
						if(Math.random() < acceptRate)
							ur = new_ur;
					}
				}
			}
			if(index_set.size() == compositionServices.size())
				break;
			long current = System.currentTimeMillis();
			if(current - begin >= timeLimit)
				break;
		}
		return ur;
	}
	
	public static UppaalResult search4S(Agent[] agents, int userlocation, int thr, int constraint, double acceptRate, int timeLimit, int num){
		long begin = System.currentTimeMillis();
		int n = 0;
		Set<String> index_set = new HashSet<String>();
		Map<String, CompositionService> compositionServices = InitCompositionServices4S.init(userlocation, constraint, num);
//		System.out.println(compositionServices.keySet().size());
		CompositionServiceIndex index = randomCsi4S(num);
		index_set.addAll(compositionServices.keySet());
		CompositionService compositionService = compositionServices.get(index.toString());
		UppaalResult ur = tryAllAgents(compositionService, agents, thr);
		while(ur == null || ur.getCost() >= thr){
//			System.out.println(ur.getCost());
			String new_index_string = null;
			if(index_set.size() < 1)
				break;
			for(String next_index : index_set){
				if(dis(next_index, index.toString()) <= 1){
					new_index_string = next_index;
					index_set.remove(next_index);
					break;
				}
			}
			if(new_index_string == null && index_set.size() > 0){
				new_index_string = index_set.iterator().next();
				index_set.remove(new_index_string);
			}
			else if(new_index_string == null || index_set.size() == 0)
				break;
//			System.out.println(new_index_string + ", remain:" + index_set.size());
			CompositionService new_compositionService = compositionServices.get(new_index_string);
			UppaalResult new_ur = tryAllAgents(new_compositionService, agents, thr);
			if(new_ur != null){
				if(ur == null)
					ur = new_ur;
				else{
					if(new_ur.getCost() < ur.getCost()){
						ur = new_ur;
					}
					else{
						if(Math.random() < acceptRate)
							ur = new_ur;
					}
				}
			}
			if(index_set.size() == compositionServices.size())
				break;
			long current = System.currentTimeMillis();
			if(current - begin >= timeLimit)
				break;
		}
		return ur;
	}
	
	public static UppaalResult search4all(Agent[] agents, int userlocation, int constraint){
		Map<String, CompositionService> compositionServices = InitCompositionServices.init(userlocation, constraint);
		int cost = Integer.MAX_VALUE;
		UppaalResult ret = null;
		int i = 0;
		for(String csi : compositionServices.keySet()){
//			System.out.println(i++);
			UppaalResult ur = tryAllAgents(compositionServices.get(csi), agents, 5500);
			if(ur != null){
				if(ur.getCost() < cost){
					cost = ur.getCost();
					ret = ur;
				}
			}
		}
//		System.out.println(cost);
		return ret;
	}
	
	public static UppaalResult search4all4S(Agent[] agents, int userlocation, int constraint, int num){
		Map<String, CompositionService> compositionServices = InitCompositionServices4S.init(userlocation, constraint, num);
		int cost = Integer.MAX_VALUE;
		UppaalResult ret = null;
		int i = 0;
		for(String csi : compositionServices.keySet()){
//			System.out.println(i++);
			UppaalResult ur = tryAllAgents(compositionServices.get(csi), agents, 5500);
			if(ur != null){
				if(ur.getCost() < cost){
					cost = ur.getCost();
					ret = ur;
				}
			}
		}
		return ret;
	}
	
	public static UppaalResult search4a1(Agent[] agents, int userlocation, int constraint){
		Map<String, CompositionService> compositionServices = InitCompositionServices.init(userlocation, constraint);
		int cost = Integer.MAX_VALUE;
		UppaalResult ret = null;
		for(String csi : compositionServices.keySet()){
			UppaalResult ur = UppaalPlan.plan4a1(compositionServices.get(csi), agents);
			if(ur.getCost() < cost){
				cost = ur.getCost();
				ret = ur;
			}
		}
		return ret;
	}
	
	public static void search4a2(Agent[] agents, int userlocation, int constraint, int thr){
		Map<String, CompositionService> compositionServices = InitCompositionServices.init(userlocation, constraint);
		int cost = Integer.MAX_VALUE;
		for(String csi : compositionServices.keySet()){
			UppaalResult ur = UppaalPlan.plan4a2(compositionServices.get(csi), agents, thr);
			if(ur.getCost() < cost)
				cost = ur.getCost();
		}
		System.out.println(cost);
	}
	
	private static UppaalResult tryAllAgents(CompositionService compositionService, Agent[] agents, int thr){
		int cost = Integer.MAX_VALUE;
		UppaalResult ret = null;
		if(agents.length == 5){
			for(int[] selectedAid : agentSelection){
				Agent[] selectedAgents = new Agent[selectedAid.length];
				for(int j = 0; j < selectedAid.length; j++){
					selectedAgents[j] = agents[selectedAid[j]];
				}
				UppaalResult ur = UppaalPlan.plan(compositionService, selectedAgents, thr);
				if(ur!= null){
					if(ur.getCost() < cost){
						cost = ur.getCost();
						ret = ur;
					}
				}
			}
			return ret;
		}
		else if(agents.length == 4){
			for(int[] selectedAid : agentSelection2){
				Agent[] selectedAgents = new Agent[selectedAid.length];
				for(int j = 0; j < selectedAid.length; j++){
					selectedAgents[j] = agents[selectedAid[j]];
				}
				UppaalResult ur = UppaalPlan.plan(compositionService, selectedAgents, thr);
				if(ur!= null){
					if(ur.getCost() < cost){
						cost = ur.getCost();
						ret = ur;
					}
				}
			}
			return ret;
		}
		else if(agents.length == 1){
			return UppaalPlan.plan4a1(compositionService, agents);
		}
		else if(agents.length == 2){
			return UppaalPlan.plan4a2(compositionService, agents, thr);
		}
		else if(agents.length == 3){
			return UppaalPlan.plan(compositionService, agents, thr);
		}
		return null;
	}
	
	private Agent[] initAgents(int n){
		Agent[] ret = new Agent[n];
		return ret;
	}
	
	public static CompositionServiceIndex randomCsi(){
		int first = (int)(Math.random()*4 + 1);
		int second = (int)(Math.random()*3 + 1);
		int third = (int)(Math.random()*4 + 1);
		
		return new CompositionServiceIndex(first, second, third);
	}
	
	public static CompositionServiceIndex randomCsi4S(int num){
		int first = (int)(Math.random()*num + 1);
		int second = (int)(Math.random()*num + 1);
		int third = (int)(Math.random()*num + 1);
		
		return new CompositionServiceIndex(first, second, third);
	}
	
	public static CompositionServiceIndex randomCsi(CompositionServiceIndex csi){
		int change = (int)(Math.random()*3 + 1);
		if(change == 1){
			int first = (int)(Math.random()*4 + 1);
//			while(first == csi.getFirst())
//				first = (int)(Math.random()*4 + 1);
			return new CompositionServiceIndex(first, csi.getSecond(), csi.getThird());
		}
		else if(change == 2){
			int second = (int)(Math.random()*3 + 1);
//			while(second == csi.getSecond());
//				second = (int)(Math.random()*3 + 1);
			return new CompositionServiceIndex(csi.getFirst(), second, csi.getThird());
		}
		else{
			int third = (int)(Math.random()*4 + 1);
//			while(third == csi.getThird());
//				third = (int)(Math.random()*4 + 1);
			return new CompositionServiceIndex(csi.getFirst(), csi.getSecond(), third);
		}
	}
	
	public static CompositionServiceIndex randomCsi4S(CompositionServiceIndex csi, int num){
		int change = (int)(Math.random()*3 + 1);
		if(change == 1){
			int first = (int)(Math.random()*num + 1);
//			while(first == csi.getFirst())
//				first = (int)(Math.random()*4 + 1);
			return new CompositionServiceIndex(first, csi.getSecond(), csi.getThird());
		}
		else if(change == 2){
			int second = (int)(Math.random()*num + 1);
//			while(second == csi.getSecond());
//				second = (int)(Math.random()*3 + 1);
			return new CompositionServiceIndex(csi.getFirst(), second, csi.getThird());
		}
		else{
			int third = (int)(Math.random()*num + 1);
//			while(third == csi.getThird());
//				third = (int)(Math.random()*4 + 1);
			return new CompositionServiceIndex(csi.getFirst(), csi.getSecond(), third);
		}
	}
	
	private static int dis(String index1, String index2){
		int ret = 0;
		String[] s1 = index1.split("-");
		String[] s2 = index2.split("-");
		for(int i = 0; i < s1.length; i++)
			ret += Math.abs(Integer.parseInt(s1[i]) - Integer.parseInt(s2[i]));
		return ret;
	}

}
