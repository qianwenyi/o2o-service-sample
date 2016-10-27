package obj;

public class Obj {
	
	private int id;
	private int src;
	private int des;
	private int treattime;
	private String name;
	
	public Obj(int id, int src, int des, int treattime, String name){
		this.id = id;
		this.src = src;
		this.des = des;
		this.treattime = treattime;
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
	
	public int getTreattime(){
		return this.treattime;
	}
	
	public String getName(){
		return this.name;
	}

}
