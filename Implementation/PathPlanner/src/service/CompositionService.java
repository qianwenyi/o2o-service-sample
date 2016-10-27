package service;

import java.util.Map;

import obj.Obj;

public class CompositionService {
	
	private Map<String, ComponentService> componentServices;
	private Obj[] objs;
	private int constraint;
	
	public CompositionService(Map<String, ComponentService> componentServices, Obj[] objs, int constraint){
		this.componentServices = componentServices;
		this.objs = objs;
		this.constraint = constraint;
	}
	
	public Map<String, ComponentService> getComponentServices(){
		return this.componentServices;
	}
	
	public Obj[] getObjs(){
		return this.objs;
	}
	
	public int getConstraint(){
		return this.constraint;
	}

}
