package agent;

public class Agent {
	
	private int id;
	private int src;
	private int des;
	private int co;
	private int speed;
	private int thr;
	private String name;
	
	public Agent(int id, int src, int des, int co, int thr, int speed, String name){
		this.id = id;
		this.src = src;
		this.des = des;
		this.co = co;
		this.speed = speed;
		this.thr = thr;
		this.name = name;
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getSrc(){
		return this.src;
	}
	
	public int getDes(){
		return this.des;
	}
	
	public int getCo(){
		return this.co;
	}
	
	public int getThr(){
		return this.thr;
	}
	
	public int getSpeed(){
		return this.speed;
	}

	public String getName(){
		return this.name;
	}
}
