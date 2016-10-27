package uppaal;

import java.util.List;
import java.util.Map;

public class UppaalResult {
	
	private int cost;
	private String scheduls;
	
	public UppaalResult(String scheduls, int cost){
		this.scheduls = scheduls;
		this.cost = cost;
	}
	
	public int getCost(){
		return this.cost;
	}
	
	public String getScheduls(){
		return this.scheduls;
	}

}
