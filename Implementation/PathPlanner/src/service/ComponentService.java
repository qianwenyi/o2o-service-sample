package service;

public class ComponentService {
	
	private String name;
	private String guard;
	private String update;
	private int t;
	private int c;
	
	public ComponentService(String name, String guard, String update, int t, int c){
		this.name = name;
		this.guard = guard;
		this.update = update;
		this.t = t;
		this.c = c;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getGuard(){
		return this.guard;
	}
	
	public String getUpdate(){
		return this.update;
	}
	
	public int getT(){
		return this.t;
	}
	
	public int getC(){
		return this.c;
	}

}
