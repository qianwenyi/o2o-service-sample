package service;

public class CompositionServiceIndex {
	
	private int first;
	private int second;
	private int third;
	
	public CompositionServiceIndex(int first, int second, int third){
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	public int getFirst(){
		return this.first;
	}
	
	public int getSecond(){
		return this.second;
	}
	
	public int getThird(){
		return this.third;
	}

	public boolean equals(CompositionServiceIndex csi){
		if(this.first == csi.getFirst() && this.second == csi.getSecond() && this.third == csi.getThird())
			return true;
		return false;
	}
	
	public String toString(){
		return this.first + "-" + this.second + "-" + this.third;
	}
	
	public int dis(CompositionServiceIndex csi){
		int ret = 0;
		
		ret += Math.abs(this.first - csi.getFirst());
		ret += Math.abs(this.second - csi.getSecond());
		ret += Math.abs(this.third - csi.getThird());
		
		return ret;
	}
}
