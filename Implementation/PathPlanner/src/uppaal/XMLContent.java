package uppaal;

public class XMLContent {
	
	public static String head = "<?xml version=\"1.0\" encoding=\"utf-8\"?><!DOCTYPE nta PUBLIC '-//Uppaal Team//DTD Flat System 1.1//EN' 'http://www.it.uu.se/research/group/darts/uppaal/flat-1_1.dtd'><nta>";
	
	public static String decl = "int[0,1] con = 0;"
			+ "int[0,1] con1_done = 0;"
			+ "int[0,1] con2_done = 0;"
			+ "const int locations = 12;"
			+ "const int l0 = 0;"
			+ "const int l1 = 1;"
			+ "const int l2 = 2;"
			+ "const int l3 = 3;"
			+ "const int l4 = 4;"
			+ "const int l5 = 5;"
			+ "const int l6 = 6;"
			+ "const int l7 = 7;"
			+ "const int l8 = 8;"
			+ "const int l9 = 9;"
			+ "const int l10 = 10;"
			+ "const int l11 = 11;"
			+ "const int objects = 3;"
			+ "const int agents = 3;"
			+ "const int dis[locations][locations] = "
			+ "{{0, 200, 400, 400, 220, 480, 660, 660, 940, 820, 1120, 960},"
			+ "{200, 0, 200, 200, 360, 420, 460, 600, 760, 760, 920, 900},"
			+ "{400, 200, 0, 400, 500, 240, 260, 420, 560, 580, 720, 720},"
			+ "{400, 200, 400, 0, 480, 220, 660, 400, 680, 560, 840, 700},"
			+ "{220, 360, 500, 480, 0, 260, 760, 440, 720, 600, 860, 740},"
			+ "{480, 420, 240, 220, 260, 0, 500,  180, 460, 340, 620, 480},"
			+ "{660, 460, 260, 660, 760, 500, 0, 580, 300, 760, 460, 620},"
			+ "{660, 600, 420, 400, 440,  180, 580, 0, 280, 520, 440, 600},"
			+ "{940, 760, 560, 680, 720, 460, 300, 280, 0, 460,  160, 320},"
			+ "{820, 760, 580, 560, 600, 340, 760, 520, 460, 0, 260,  140},"
			+ "{1120, 920, 720, 840, 880, 620, 460, 440, 160, 260, 0,  120},"
			+ "{960, 900, 720, 700, 740, 480, 620, 600, 320, 140, 120, 0}};"
			+ "int[-1,11] objectAt[objects] = {-1, -1, -1};"
			+ "int[-1,11] takeAt[agents] = {-1, -1, -1};"
			+ "int[-1,11] dropAt[agents] = {-1, -1, -1};"
			+ "int[-1,11] agentAt[agents] = {-1, -1, -1};"
			+ "urgent chan g4t[agents];"
			+ "urgent chan take[agents];"
			+ "chan drop[agents];"
			+ "int treattime[agents] = {0, 0, 0};"
			+ "int takeObj[agents] = {-1, -1, -1};"
			+ "int dropObj[agents] = {-1, -1, -1};";
	
//	public static String objTemplate = "<name x=\"5\" y=\"5\">Obj</name>"
//			+ "<parameter>const int id, int src, int des, int tt</parameter>"
//			+ "<declaration>// Place local declarations here.</declaration>"
//			+ "<location id=\"id0\" x=\"232\" y=\"64\">"
//				+ "<name x=\"222\" y=\"34\">intrans1</name>"
//			+ "</location>"
//			+ "<location id=\"id1\" x=\"-760\" y=\"64\">"
//				+ "<name x=\"-784\" y=\"32\">intrans2</name>"
//			+ "</location>"
//			+ "<location id=\"id2\" x=\"-200\" y=\"64\">"
//			+ "<name x=\"-210\" y=\"34\">intrans0</name>"
//			+ "</location>"
//			+ "<location id=\"id3\" x=\"-600\" y=\"64\">"
//			+ "<name x=\"-610\" y=\"34\">wait2</name>"
//			+ "</location>"
//			+ "<location id=\"id4\" x=\"56\" y=\"64\">"
//			+ "<name x=\"46\" y=\"34\">wait1</name>"
//			+ "</location>"
//			+ "<location id=\"id5\" x=\"-408\" y=\"64\">"
//			+ "<name x=\"-418\" y=\"34\">wait0</name>"
//			+ "</location>"
//			+ "<location id=\"id6\" x=\"-288\" y=\"-312\">"
//			+ "<name x=\"-296\" y=\"-344\">idle</name>"
//			+ "</location>"
//			+ "<init ref=\"id6\"/>"
//			+ "<transition>"
//			+ "<source ref=\"id0\"/>"
//			+ "<target ref=\"id6\"/>"
//			+ "<label kind=\"synchronisation\" x=\"168\" y=\"-119\">drop[1]?</label>"
//			+ "<label kind=\"assignment\" x=\"168\" y=\"-104\">objectAt[id] = des,dropObj[1] = id</label>"
//			+ "<nail x=\"232\" y=\"-312\"/>"
//			+ "</transition>"
//			+ "<transition>"
//			+ "<source ref=\"id4\"/>"
//			+ "<target ref=\"id0\"/>"
//			+ "<label kind=\"guard\" x=\"84\" y=\"34\">objectAt[id] == src</label>"
//			+ "<label kind="synchronisation" x="84" y="49">take[1]!</label><label kind="assignment" x="84" y="64">treattime[1] = tt,
//takeObj[1] = id</label></transition><transition><source ref="id1"/><target ref="id6"/><label kind="synchronisation" x="-800" y="-96">drop[2]?</label><label kind="assignment" x="-800" y="-72">objectAt[id] = des,
//dropObj[2] = id</label><nail x="-760" y="-312"/></transition><transition><source ref="id3"/><target ref="id1"/><label kind="guard" x="-720" y="24">objectAt[id] == src</label><label kind="synchronisation" x="-720" y="40">take[2]!</label><label kind="assignment" x="-740" y="64">treattime[2] = tt,
//takeObj[2] = id</label></transition><transition><source ref="id2"/><target ref="id6"/><label kind="synchronisation" x="-232" y="-127">drop[0]?</label><label kind="assignment" x="-232" y="-112">objectAt[id] = des,
//dropObj[0] = id</label><nail x="-200" y="-176"/></transition><transition><source ref="id5"/><target ref="id2"/><label kind="guard" x="-360" y="24">objectAt[id] == src</label><label kind="synchronisation" x="-360" y="40">take[0]!</label><label kind="assignment" x="-364" y="64">treattime[0] = tt,
//takeObj[0] = id</label></transition><transition><source ref="id6"/><target ref="id3"/><label kind="guard" x="-664" y="-176">agentAt[2] &gt;= 0</label><label kind="synchronisation" x="-664" y="-96">g4t[2]!</label><label kind="assignment" x="-664" y="-160">takeAt[2] = src,
//dropAt[2] = des</label><nail x="-600" y="-200"/><nail x="-600" y="24"/></transition><transition><source ref="id6"/><target ref="id4"/><label kind="guard" x="-24" y="-112">agentAt[1] &gt;= 0</label><label kind="synchronisation" x="-24" y="-24">g4t[1]!</label><label kind="assignment" x="-24" y="-96">takeAt[1] = src,
//dropAt[1] = des</label><nail x="56" y="-216"/><nail x="56" y="16"/></transition><transition><source ref="id6"/><target ref="id5"/><label kind="guard" x="-472" y="-136">agentAt[0] &gt;= 0</label><label kind="synchronisation" x="-472" y="-48">g4t[0]!</label><label kind="assignment" x="-472" y="-112">takeAt[0] = src,
//dropAt[0] = des</label><nail x="-408" y="-176"/><nail x="-408" y="16"/></transition>";

}
