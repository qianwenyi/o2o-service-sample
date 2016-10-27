package service;

import java.util.HashMap;
import java.util.Map;

import obj.Obj;

public class InitCompositionServices4S {
	
	public static Map<String, CompositionService> init(int userlocation, int constraint, int num){
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
		
		for(int fbi = 1; fbi <= num; fbi++){
			if(fbi == 1){
				bri = 1;
				brt = 5;
				brc = 200;
				fbguard = "c==" + brt;
				brupdate = "objectAt[0]=l2, c=0";
				rbguard = "con==1 && objectAt[2]==l2";
				obj0src = 2;
				obj0tt = 5;
				obj2des = 2;
				obj2tt = 10;
			}
			else if(fbi == 2){
				bri = 2;
				brt = 5;
				brc = 200;
				fbguard = "c==" + brt;
				brupdate = "objectAt[0]=l7, c=0";
				rbguard = "con==1 && objectAt[2]==l7";
				obj0src= 7;
				obj0tt = 8;
				obj2des = 7;
				obj2tt = 15;
			}
			else if(fbi == 3){
				bri = 1;
				brt = 3;
				brc = 150;
				fbguard = "c==" + brt;
				brupdate = "objectAt[0]=l10, c=0";
				rbguard = "con==1 && objectAt[2]==l10";
				obj0src = 10;
				obj0tt = 8;
				obj2des = 10;
				obj2tt = 14;
			}
			else if(fbi == 4){
				bri = 2;
				brt = 3;
				brc = 300;
				fbguard = "c==" + brt;
				brupdate = "objectAt[0]=l4, c=0";
				rbguard = "con==1 && objectAt[2]==l4";
				obj0src = 4;
				obj0tt = 10;
				obj2des = 4;
				obj2tt = 12;
			}
			else if(fbi == 5){
				bri = 2;
				brt = 5;
				brc = 200;
				fbguard = "c==" + brt;
				brupdate = "objectAt[0]=l2, c=0";
				rbguard = "con==1 && objectAt[2]==l2";
				obj0src = 2;
				obj0tt = 8;
				obj2des = 2;
				obj2tt = 11;
			}
			if(fbi == 10){
				bri = 1;
				brt = 5;
				brc = 200;
				fbguard = "c==" + brt;
				brupdate = "objectAt[0]=l2, c=0";
				rbguard = "con==1 && objectAt[2]==l2";
				obj0src = 2;
				obj0tt = 5;
				obj2des = 2;
				obj2tt = 10;
			}
			else if(fbi == 9){
				bri = 2;
				brt = 5;
				brc = 200;
				fbguard = "c==" + brt;
				brupdate = "objectAt[0]=l7, c=0";
				rbguard = "con==1 && objectAt[2]==l7";
				obj0src= 7;
				obj0tt = 8;
				obj2des = 7;
				obj2tt = 15;
			}
			else if(fbi == 8){
				bri = 1;
				brt = 4;
				brc = 140;
				fbguard = "c==" + brt;
				brupdate = "objectAt[0]=l10, c=0";
				rbguard = "con==1 && objectAt[2]==l10";
				obj0src = 10;
				obj0tt = 8;
				obj2des = 10;
				obj2tt = 14;
			}
			else if(fbi == 7){
				bri = 2;
				brt = 5;
				brc = 400;
				fbguard = "c==" + brt;
				brupdate = "objectAt[0]=l4, c=0";
				rbguard = "con==1 && objectAt[2]==l4";
				obj0src = 4;
				obj0tt = 11;
				obj2des = 4;
				obj2tt = 13;
			}
			else if(fbi == 6){
				bri = 2;
				brt = 7;
				brc = 290;
				fbguard = "c==" + brt;
				brupdate = "objectAt[0]=l2, c=0";
				rbguard = "con==1 && objectAt[2]==l2";
				obj0src = 2;
				obj0tt = 9;
				obj2des = 2;
				obj2tt = 12;
			}
			fbupdate = "c=0";
			
			for(int sbi = 1; sbi <= num; sbi++){
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
				else if(sbi == 3){
					sbguard = "objectAt[0]==l3";
					sbupdate = "objectAt[2]=l3, con=1";
					sbt = 450;
					sbc = 1200;
					obj0des = 3;
					obj2src = 3;
				}
				else if(sbi == 4){
					sbguard = "objectAt[0]==l9";
					sbupdate = "objectAt[2]=l9, con=1";
					sbt = 600;
					sbc = 600;
					obj0des = 9;
					obj2src = 9;
				}
				else if(sbi == 5){
					sbguard = "objectAt[0]==l7";
					sbupdate = "objectAt[2]=l7, con=1";
					sbt = 400;
					sbc = 950;
					obj0des = 9;
					obj2src = 9;
				}
				if(sbi == 10){
					sbguard = "objectAt[0]==l9";
					sbupdate = "objectAt[2]=l9, con=1";
					sbt = 500;
					sbc = 800;
					obj0des = 9;
					obj2src = 9;
				}
				else if(sbi == 9){
					sbguard = "objectAt[0]==l6";
					sbupdate = "objectAt[2]=l6, con=1";
					sbt = 400;
					sbc = 1000;
					obj0des = 6;
					obj2src = 6;
				}
				else if(sbi == 8){
					sbguard = "objectAt[0]==l3";
					sbupdate = "objectAt[2]=l3, con=1";
					sbt = 460;
					sbc = 1100;
					obj0des = 3;
					obj2src = 3;
				}
				else if(sbi == 7){
					sbguard = "objectAt[0]==l9";
					sbupdate = "objectAt[2]=l9, con=1";
					sbt = 610;
					sbc = 590;
					obj0des = 9;
					obj2src = 9;
				}
				else if(sbi == 6){
					sbguard = "objectAt[0]==l7";
					sbupdate = "objectAt[2]=l7, con=1";
					sbt = 410;
					sbc = 900;
					obj0des = 9;
					obj2src = 9;
				}
				tmpguard = "c==" + sbt;
				
				for(int fci = 1; fci <= num; fci++){
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
					else if(fci == 4){
						rpguard = "con==1";
						rpupdate = "objectAt[1]=l11";
						rpt = 120;
						rpc = 1500;
						obj1src = 11;
						obj1tt = 5;
					}
					else if(fci == 5){
						rpguard = "con==1";
						rpupdate = "objectAt[1]=l8";
						rpt = 140;
						rpc = 1000;
						obj1src = 8;
						obj1tt = 6;
					}
					if(fci == 10){
						rpguard = "con==1";
						rpupdate = "objectAt[1]=l5";
						rpt = 100;
						rpc = 2000;
						obj1src = 5;
						obj1tt = 5;
					}
					else if(fci == 9){
						rpguard = "con==1";
						rpupdate = "objectAt[1]=l1";
						rpt = 100;
						rpc = 2000;
						obj1src = 1;
						obj1tt = 4;
					}
					else if(fci == 8){
						rpguard = "con==1";
						rpupdate = "objectAt[1]=l8";
						rpt = 130;
						rpc = 1400;
						obj1src = 8;
						obj1tt = 6;
					}
					else if(fci == 7){
						rpguard = "con==1";
						rpupdate = "objectAt[1]=l11";
						rpt = 130;
						rpc = 1300;
						obj1src = 11;
						obj1tt = 6;
					}
					else if(fci == 6){
						rpguard = "con==1";
						rpupdate = "objectAt[1]=l8";
						rpt = 130;
						rpc = 1200;
						obj1src = 8;
						obj1tt = 7;
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
