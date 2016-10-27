package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import obj.Obj;

public class InitCompositionServices {
	
	public static Map<String, CompositionService> init(int userlocation, int constraint){
		Map<String, CompositionService> ret = new HashMap<String, CompositionService>();
		
		int bri;
		String brguard = "agentAt[0]>=0 && agentAt[1]>=0 && agentAt[2]>=0";
		String brupdate = "";
		int brt = 0;
		int brc = 0;
		String fbguard = "";
		String fbupdate = "";
		int fbt = 0;
		int fbc = 0;
		String sbguard =  "";
		String sbupdate = "";
		int sbt = 0;
		int sbc = 0;
		String rpguard = "";
		String rpupdate = "";
		int rpt = 0;
		int rpc = 0;
		String fcguard = "";
		String fcupdate = "";
		int fct = 0;
		int fcc = 0;
		String rbguard = "";
		String rbupdate = "";
		int rbt = 0;
		int rbc = 0;
		String tmpguard = "";
		String tmpupdate = "";
		int tmpt = 0;
		int tmpc = 0;
		String fcendguard = "";
		String fcendupdate = "";
		int fcendt = 0;
		int fcendc = 0;
		
		int obj0src = 0;
		int obj0des = 0;
		int obj0tt = 0;
		int obj1src = 0;
		int obj1des = 0;
		int obj1tt = 0;
		int obj2src = 0;
		int obj2des = 0;
		int obj2tt = 0;
		
		for(int fbi = 1; fbi <= 4; fbi++){
			if(fbi <= 2){
				bri = 1;
				brt = 5;
				brc = 200;
			}
			else{
				bri = 2;
				brt = 3;
				brc = 300;
			}
			fbguard = "c==" + brt;
			if(fbi == 1){
				brupdate = "objectAt[0]=l2, c=0";
				rbguard = "con==1 && objectAt[2]==l2";
				obj0src = 2;
				obj0tt = 5;
				obj2des = 2;
				obj2tt = 10;
			}
			else if(fbi == 2){
				brupdate = "objectAt[0]=l7, c=0";
				rbguard = "con==1 && objectAt[2]==l7";
				obj0src= 7;
				obj0tt = 8;
				obj2des = 7;
				obj2tt = 15;
			}
			else if(fbi == 3){
				brupdate = "objectAt[0]=l10, c=0";
				rbguard = "con==1 && objectAt[2]==l10";
				obj0src = 10;
				obj0tt = 8;
				obj2des = 10;
				obj2tt = 14;
			}
			else{
				brupdate = "objectAt[0]=l4, c=0";
				rbguard = "con==1 && objectAt[2]==l4";
				obj0src = 4;
				obj0tt = 10;
				obj2des = 4;
				obj2tt = 12;
			}
			fbupdate = "c=0";
			
			for(int sbi = 1; sbi <= 3; sbi++){
				if(sbi == 1){
					sbguard = "objectAt[0]==l9";
					sbupdate = "objectAt[2]=l9, con=1";
					sbt = 500;
					sbc = 800;
					obj0des = 9;
					obj2src = 9;
				}
				else if(sbi == 2){
					sbguard = "objectAt[0]==l6";
					sbupdate = "objectAt[2]=l6, con=1";
					sbt = 400;
					sbc = 1000;
					obj0des = 6;
					obj2src = 6;
				}
				else{
					sbguard = "objectAt[0]==l3";
					sbupdate = "objectAt[2]=l3, con=1";
					sbt = 450;
					sbc = 1200;
					obj0des = 3;
					obj2src = 3;
				}
				tmpguard = "c==" + sbt;
				
				for(int fci = 1; fci <= 4; fci++){
					if(fci == 1){
						rpguard = "con==1";
						rpupdate = "objectAt[1]=l5";
						rpt = 100;
						rpc = 2000;
						obj1src = 5;
						obj1tt = 5;
					}
					else if(fci == 2){
						rpguard = "con==1";
						rpupdate = "objectAt[1]=l1";
						rpt = 100;
						rpc = 2000;
						obj1src = 1;
						obj1tt = 4;
					}
					else if(fci == 3){
						rpguard = "con==1";
						rpupdate = "objectAt[1]=l8";
						rpt = 120;
						rpc = 1500;
						obj1src = 8;
						obj1tt = 6;
					}
					else{
						rpguard = "con==1";
						rpupdate = "objectAt[1]=l11";
						rpt = 120;
						rpc = 1500;
						obj1src = 11;
						obj1tt = 5;
					}
					fcguard = "c==" + rpt;
					fcendguard = "objectAt[1]==l" + userlocation;
					obj1des = userlocation;
					
					ComponentService br = new ComponentService("br", brguard, brupdate, brt, brc);
					ComponentService fb = new ComponentService("fb", fbguard, fbupdate, fbt, fbc);
					ComponentService sb = new ComponentService("sb", sbguard, sbupdate, sbt, sbc);
					ComponentService tmp = new ComponentService("tmp", tmpguard, tmpupdate, tmpt, tmpc);
					ComponentService rp = new ComponentService("rp", rpguard, rpupdate, rpt, rpc);
					ComponentService fc = new ComponentService("fc", fcguard, fcupdate, fct, fcc);
					ComponentService fcend = new ComponentService("fcend", fcendguard, fcendupdate, fcendt, fcendc);
					ComponentService rb = new ComponentService("rb", rbguard, rbupdate, rbt, rbc);
					
					Map<String, ComponentService> components = new HashMap<String, ComponentService>();
					components.put("br", br);
					components.put("fb", fb);
					components.put("sb", sb);
					components.put("tmp", tmp);
					components.put("rp", rp);
					components.put("fc", fc);
					components.put("fcend", fcend);
					components.put("rb", rb);
					
					Obj obj0 = new Obj(0, obj0src, obj0des, obj0tt, "book4scan");
					Obj obj1 = new Obj(1, obj1src, obj1des, obj1tt, "copy");
					Obj obj2 = new Obj(2, obj2src, obj2des, obj2tt, "book4return");
					Obj[] objs = {obj0, obj1, obj2};
					
					CompositionService compositionService = new CompositionService(components, objs, constraint);
					CompositionServiceIndex csi = new CompositionServiceIndex(fbi, sbi, fci);
					ret.put(csi.toString(), compositionService);
				}
			}
		}
		return ret;	
	}
}

