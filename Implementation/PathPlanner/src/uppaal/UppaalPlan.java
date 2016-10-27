package uppaal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import obj.Obj;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import agent.Agent;
import service.CompositionService;

public class UppaalPlan {
	
	public static void generateUppaalFile(CompositionService compositionService, Agent[] agents, String fileName){
//		String fileName = "e:\\temp\\paper\\paper.xml";
		Document document;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return;
		}
		
		Element nta = document.createElement("nta"); // root node <nta>
		document.appendChild(nta);
		
		Element globalDeclaration = document.createElement("declaration");
		globalDeclaration.setTextContent(XMLContent.decl);
		nta.appendChild(globalDeclaration);
		
		createObjTemplate(document, nta);
		createAgentTemplate(document, nta);
		createProcessTemplate(document, nta, compositionService);
		createCon1Template(document, nta, compositionService);
		createCon2Template(document, nta, compositionService);
		createSystem(document, nta, compositionService, agents);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			File file = new File(fileName);
			if(file.exists())
				file.delete();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(
					fileName));
			StreamResult result = new StreamResult(printWriter);
			transformer.transform(source, result);
			//System.out.println("create XML file done!");
		} catch (Exception e) {
			System.err.println("create XML file error!");
		}
	}

	public static UppaalResult plan(CompositionService compositionService, Agent[] agents, int thr){
		generateUppaalFile(compositionService, agents, "e:\\temp\\paper\\paper.xml");
		String commandStr = "e:\\temp\\paper\\verifyta -t3 e:\\temp\\paper\\paper.xml e:\\temp\\paper\\paper.q";
		BufferedReader br = null;  
		boolean satisfied = false;
		String result = "";
        try {  
            Process p = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(p.getInputStream())); 
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) { 
                sb.append(line + "\n");
                if(line.contains("Property is satisfied"))
                	satisfied = true;
                if(line.contains("Best solution"))
                	result = line;
                if(line.contains("Best:")){
                	String[] stringArray = line.split("Best:");
                	Pattern pattern = Pattern.compile("\\d+");
                	Matcher matcher = pattern.matcher(stringArray[1]);
                	while(matcher.find()){
                		p.destroy();
                		return new UppaalResult(null, Integer.parseInt(matcher.group()));
                	}
                }
                if(line.contains("Cost:")){
                	String[] stringArray = line.split(" ");
                	if(Integer.parseInt(stringArray[9]) > thr){
                		p.destroy();
                		return null;
                	}
                }
                if(line.contains("Showing example trace"))
                	break;
            }
            if(satisfied){
            	Pattern pattern = Pattern.compile("\\d+");
            	Matcher matcher = pattern.matcher(result);
            	int cost = 0;
            	while(matcher.find()){
            		cost = Integer.parseInt(matcher.group());
            	}
            	br = new BufferedReader(new InputStreamReader(p.getErrorStream())); 
                line = null;
                sb = new StringBuilder();
                String scheduls = "sch:\n";
                while ((line = br.readLine()) != null) {
//                	Pattern pattern1 = Pattern.compile("agentAt\\[0\\]=\\d+");
//                	Pattern pattern2 = Pattern.compile("agentAt\\[1\\]=\\d+");
//                	Pattern pattern3 = Pattern.compile("agentAt\\[2\\]=\\d+");
//                	matcher = pattern1.matcher(line);
//                	while(matcher.find()){
//                		scheduls = scheduls + matcher.group() + "; ";
//                	}
//                	matcher = pattern2.matcher(line);
//                	while(matcher.find()){
//                		scheduls = scheduls + matcher.group() + "; ";
//                	}
//                	matcher = pattern3.matcher(line);
//                	while(matcher.find()){
//                		scheduls = scheduls + matcher.group() + "; ";
//                	}
//                	scheduls = scheduls + "\n";
                	scheduls = scheduls + line + "\n";
                }
            	return new UppaalResult(scheduls, cost);
            }
            else
            	return null;
        } catch (Exception e) {  
            e.printStackTrace();
        }
        return null;
	}
	
	public static UppaalResult plan4a1(CompositionService compositionService, Agent[] agents){
		generateUppaalFile4a1(compositionService, agents, "e:\\temp\\paper\\a1.xml");
		String commandStr = "e:\\temp\\paper\\verifyta -t3 e:\\temp\\paper\\a1.xml e:\\temp\\paper\\a1.q";
		BufferedReader br = null;  
		boolean satisfied = false;
		String result = "";
        try {  
            Process p = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(p.getInputStream())); 
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) { 
                sb.append(line + "\n");
                if(line.contains("Property is satisfied"))
                	satisfied = true;
                if(line.contains("Best solution"))
                	result = line;
                if(line.contains("Best:")){
                	String[] stringArray = line.split("Best:");
                	Pattern pattern = Pattern.compile("\\d+");
                	Matcher matcher = pattern.matcher(stringArray[1]);
                	while(matcher.find()){
                		p.destroy();
                		return new UppaalResult(null, Integer.parseInt(matcher.group()));
                	}
                }
                if(line.contains("Cost:")){
                	String[] stringArray = line.split(" ");
                	if(Integer.parseInt(stringArray[9]) > 5600){
                		p.destroy();
                		return null;
                	}
                }
                if(line.contains("Showing example trace"))
                	break;
            }
            if(satisfied){
            	Pattern pattern = Pattern.compile("\\d+");
            	Matcher matcher = pattern.matcher(result);
            	while(matcher.find()){
            		return new UppaalResult(null, Integer.parseInt(matcher.group()));
            	}
            }
            else
            	return null;
        } catch (Exception e) {  
            e.printStackTrace();
        }
        return null;
	}
	
	public static UppaalResult plan4a2(CompositionService compositionService, Agent[] agents, int thr){
		generateUppaalFile4a2(compositionService, agents, "e:\\temp\\paper\\a2.xml");
		String commandStr = "e:\\temp\\paper\\verifyta -t3 e:\\temp\\paper\\a2.xml e:\\temp\\paper\\a2.q";
		BufferedReader br = null;  
		boolean satisfied = false;
		String result = "";
        try {  
            Process p = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(p.getInputStream())); 
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) { 
                sb.append(line + "\n");
                if(line.contains("Property is satisfied"))
                	satisfied = true;
                if(line.contains("Best solution"))
                	result = line;
                if(line.contains("Best:")){
                	String[] stringArray = line.split("Best:");
                	Pattern pattern = Pattern.compile("\\d+");
                	Matcher matcher = pattern.matcher(stringArray[1]);
                	while(matcher.find()){
                		p.destroy();
                		return new UppaalResult(null, Integer.parseInt(matcher.group()));
                	}
                }
                if(line.contains("Cost:")){
                	String[] stringArray = line.split(" ");
                	if(Integer.parseInt(stringArray[9]) > thr){
                		p.destroy();
                		return null;
                	}
                }
                if(line.contains("Showing example trace"))
                	break;
            }
            if(satisfied){
            	Pattern pattern = Pattern.compile("\\d+");
            	Matcher matcher = pattern.matcher(result);
            	while(matcher.find()){
            		return new UppaalResult(null, Integer.parseInt(matcher.group()));
            	}
            }
            else
            	return null;
        } catch (Exception e) {  
            e.printStackTrace();
        }
        return null;
	}
	
	private static void createSystem(Document document, Element nta, CompositionService cs, Agent[] agents){
		Element system = document.createElement("system");
		nta.appendChild(system);
		String systemContent = "";
		for(int i = 0; i < cs.getObjs().length; i++){
			Obj obj = cs.getObjs()[i];
			systemContent += "O" + (i+1) + " = Obj(" + i + ", " +  obj.getSrc() + ", " + obj.getDes() + ", " + obj.getTreattime() + ");";
		}
		for(int i = 0; i < agents.length; i++){
			Agent agent = agents[i];
			systemContent += "A" + (i+1) + " = Agent(" + i + ", " + agent.getSrc() + ", " + agent.getDes() + ", " + agent.getCo() + ", " + agent.getThr() + ");";
		}
		systemContent += "P = Process(); C1 = Con1(); C2 = Con2();";
		systemContent += "system ";
		for(int i = 0; i < cs.getObjs().length; i++){
			systemContent += "O" + (i+1) + ", ";
		}
		for(int i = 0; i < agents.length; i++){
			systemContent += "A" + (i+1) + ", ";
		}
		systemContent += "P, C1, C2;";
		system.setTextContent(systemContent);
	}
	
	private static void createCon1Template(Document document, Element nta, CompositionService cs){
		Element template = document.createElement("template");
		nta.appendChild(template);
		Element name = document.createElement("name");
		name.setTextContent("Con1");
		template.appendChild(name);
		
		Element declaration = document.createElement("declaration");
		declaration.setTextContent("clock c;clock gc;");
		template.appendChild(declaration);
		
		XmlLocation id22 = new XmlLocation("id22", "end", null, false);
		XmlLocation id23 = new XmlLocation("id23", "fc", null, false);
		XmlLocation id24 = new XmlLocation("id24", "rp", new XmlLabel("kind", "invariant", "c <= " + cs.getComponentServices().get("rp").getT()), false);
		XmlLocation id25 = new XmlLocation("id25", "start", null, false);
		
		addLocation(document, template, id22);
		addLocation(document, template, id23);
		addLocation(document, template, id24);
		addLocation(document, template, id25);
		
		Element init = document.createElement("init");
		init.setAttribute("ref", "id25");
		template.appendChild(init);
		
		List<XmlLabel> t0labels = new ArrayList<XmlLabel>();
		t0labels.add(new XmlLabel("kind", "guard", cs.getComponentServices().get("fcend").getGuard() + " && gc <= " + cs.getConstraint()));
		t0labels.add(new XmlLabel("kind", "assignment", "con1_done = 1"));
		XmlTransition t0 = new XmlTransition("id23", "id22", t0labels);
		
		List<XmlLabel> t1labels = new ArrayList<XmlLabel>();
		t1labels.add(new XmlLabel("kind", "guard", cs.getComponentServices().get("fc").getGuard()));
		t1labels.add(new XmlLabel("kind", "assignment", cs.getComponentServices().get("rp").getUpdate()));
		XmlTransition t1 = new XmlTransition("id24", "id23", t1labels);
		
		List<XmlLabel> t2labels = new ArrayList<XmlLabel>();
		t2labels.add(new XmlLabel("kind", "guard", "con == 1"));
		t2labels.add(new XmlLabel("kind", "assignment", "c = 0"));
		XmlTransition t2 = new XmlTransition("id25", "id24", t2labels);
		
		addTransition(document, template, t0);
		addTransition(document, template, t1);
		addTransition(document, template, t2);
	}
	
	private static void createCon2Template(Document document, Element nta, CompositionService cs){
		Element template = document.createElement("template");
		nta.appendChild(template);
		Element name = document.createElement("name");
		name.setTextContent("Con2");
		template.appendChild(name);
		
		Element declaration = document.createElement("declaration");
		declaration.setTextContent("clock gc;");
		template.appendChild(declaration);
		
		XmlLocation id26 = new XmlLocation("id26", "end", null, false);
		XmlLocation id27 = new XmlLocation("id27", "rb", null, false);
		XmlLocation id28 = new XmlLocation("id28", "start", null, false);
		
		addLocation(document, template, id26);
		addLocation(document, template, id27);
		addLocation(document, template, id28);
		
		Element init = document.createElement("init");
		init.setAttribute("ref", "id28");
		template.appendChild(init);
		
		List<XmlLabel> t0labels = new ArrayList<XmlLabel>();
		t0labels.add(new XmlLabel("kind", "guard", "gc <= " + cs.getConstraint()));
		t0labels.add(new XmlLabel("kind", "assignment", "con2_done = 1"));
		XmlTransition t0 = new XmlTransition("id27", "id26", t0labels);
		
		List<XmlLabel> t1labels = new ArrayList<XmlLabel>();
		t1labels.add(new XmlLabel("kind", "guard", cs.getComponentServices().get("rb").getGuard()));
		XmlTransition t1 = new XmlTransition("id28", "id27", t1labels);
		
		addTransition(document, template, t0);
		addTransition(document, template, t1);
	}
	
	private static void createProcessTemplate(Document document, Element nta, CompositionService cs){
		Element template = document.createElement("template");
		nta.appendChild(template);
		Element name = document.createElement("name");
		name.setTextContent("Process");
		template.appendChild(name);
		
		Element declaration = document.createElement("declaration");
		declaration.setTextContent("clock c; clock gc;");
		template.appendChild(declaration);
		
		XmlLocation id16 = new XmlLocation("id16", "end", null, false);
		XmlLocation id17 = new XmlLocation("id17", "start", null, false);
		XmlLocation id18 = new XmlLocation("id18", "tmp", null, false);
		XmlLocation id19 = new XmlLocation("id19", "sb", new XmlLabel("kind", "invariant", "c <= " + cs.getComponentServices().get("sb").getT()), false);
		XmlLocation id20 = new XmlLocation("id20", "fb", null, false);
		XmlLocation id21 = new XmlLocation("id21", "br", new XmlLabel("kind", "invariant", "c <= " + cs.getComponentServices().get("br").getT()), false);
		XmlLocation id29 = new XmlLocation("id29", "ready", new XmlLabel("kind", "invariant", "c <= 1" + " && cost' == " + 
				(cs.getComponentServices().get("sb").getC() + cs.getComponentServices().get("br").getC() + cs.getComponentServices().get("rp").getC())), false);
		
		addLocation(document, template, id16);
		addLocation(document, template, id17);
		addLocation(document, template, id18);
		addLocation(document, template, id19);
		addLocation(document, template, id20);
		addLocation(document, template, id21);
		addLocation(document, template, id29);
		
		Element init = document.createElement("init");
		init.setAttribute("ref", "id17");
		template.appendChild(init);
		
		List<XmlLabel> t0labels = new ArrayList<XmlLabel>();
		t0labels.add(new XmlLabel("kind", "guard", "con1_done == 1 && con2_done == 1 && gc <= " + cs.getConstraint()));
		XmlTransition t0 = new XmlTransition("id18", "id16", t0labels);
		
		List<XmlLabel> t1labels = new ArrayList<XmlLabel>();
		t1labels.add(new XmlLabel("kind", "guard", "c == 1 && agentAt[0] >= 0 && agentAt[1] >= 0 && agentAt[2] >= 0"));
		t1labels.add(new XmlLabel("kind", "assignment", "c = 0"));
		XmlTransition t1 = new XmlTransition("id29", "id21", t1labels);
		
		List<XmlLabel> t2labels = new ArrayList<XmlLabel>();
		t2labels.add(new XmlLabel("kind", "guard", cs.getComponentServices().get("tmp").getGuard()));
		t2labels.add(new XmlLabel("kind", "assignment", cs.getComponentServices().get("sb").getUpdate()));
		XmlTransition t2 = new XmlTransition("id19", "id18", t2labels);
		
		List<XmlLabel> t3labels = new ArrayList<XmlLabel>();
		t3labels.add(new XmlLabel("kind", "guard", cs.getComponentServices().get("sb").getGuard() + " && gc <= " + cs.getConstraint()));
		t3labels.add(new XmlLabel("kind", "assignment", "c = 0"));
		XmlTransition t3 = new XmlTransition("id20", "id19", t3labels);
		
		List<XmlLabel> t4labels = new ArrayList<XmlLabel>();
		t4labels.add(new XmlLabel("kind", "guard", cs.getComponentServices().get("fb").getGuard()));
		t4labels.add(new XmlLabel("kind", "assignment", cs.getComponentServices().get("br").getUpdate()));
		XmlTransition t4 = new XmlTransition("id21", "id20", t4labels);
		
		List<XmlLabel> t5labels = new ArrayList<XmlLabel>();
		t5labels.add(new XmlLabel("kind", "assignment", "c = 0"));
		XmlTransition t5 = new XmlTransition("id17", "id29", t5labels);
		
		addTransition(document, template, t0);
		addTransition(document, template, t1);
		addTransition(document, template, t2);
		addTransition(document, template, t3);
		addTransition(document, template, t4);
		addTransition(document, template, t5);
	}
	
	private static void createObjTemplate(Document document, Element nta){
		Element template = document.createElement("template");
		nta.appendChild(template);
		Element name = document.createElement("name");
		name.setTextContent("Obj");
		template.appendChild(name);
		
		Element parameter = document.createElement("parameter");
		parameter.setTextContent("const int id, int src, int des, int tt");
		template.appendChild(parameter);
		
		XmlLocation id0 = new XmlLocation("id0", "intrans1", null, false);
		XmlLocation id1 = new XmlLocation("id1", "intrans2", null, false);
		XmlLocation id2 = new XmlLocation("id2", "intrans0", null, false);
		XmlLocation id3 = new XmlLocation("id3", "wait2", null, false);
		XmlLocation id4 = new XmlLocation("id4", "wait1", null, false);
		XmlLocation id5 = new XmlLocation("id5", "wait0", null, false);
		XmlLocation id6 = new XmlLocation("id6", "idle", null, false);
		
		addLocation(document, template, id0);
		addLocation(document, template, id1);
		addLocation(document, template, id2);
		addLocation(document, template, id3);
		addLocation(document, template, id4);
		addLocation(document, template, id5);
		addLocation(document, template, id6);
		
		Element init = document.createElement("init");
		init.setAttribute("ref", "id6");
		template.appendChild(init);
		
		List<XmlLabel> t0labels = new ArrayList<XmlLabel>();
		t0labels.add(new XmlLabel("kind", "synchronisation", "drop[1]?"));
		t0labels.add(new XmlLabel("kind", "assignment", "objectAt[id] = des, dropObj[1] = id"));
		XmlTransition t0 = new XmlTransition("id0", "id6", t0labels);
		
		List<XmlLabel> t1labels = new ArrayList<XmlLabel>();
		t1labels.add(new XmlLabel("kind", "guard", "objectAt[id] == src"));
		t1labels.add(new XmlLabel("kind", "synchronisation", "take[1]!"));
		t1labels.add(new XmlLabel("kind", "assignment", "treattime[1] = tt, takeObj[1] = id"));
		XmlTransition t1 = new XmlTransition("id4", "id0", t1labels);
		
		List<XmlLabel> t2labels = new ArrayList<XmlLabel>();
		t2labels.add(new XmlLabel("kind", "synchronisation", "drop[2]?"));
		t2labels.add(new XmlLabel("kind", "assignment", "objectAt[id] = des, dropObj[2] = id"));
		XmlTransition t2 = new XmlTransition("id1", "id6", t2labels);
		
		List<XmlLabel> t3labels = new ArrayList<XmlLabel>();
		t3labels.add(new XmlLabel("kind", "guard", "objectAt[id] == src"));
		t3labels.add(new XmlLabel("kind", "synchronisation", "take[2]!"));
		t3labels.add(new XmlLabel("kind", "assignment", "treattime[2] = tt, takeObj[2] = id"));
		XmlTransition t3 = new XmlTransition("id3", "id1", t3labels);
		
		List<XmlLabel> t4labels = new ArrayList<XmlLabel>();
		t4labels.add(new XmlLabel("kind", "synchronisation", "drop[0]?"));
		t4labels.add(new XmlLabel("kind", "assignment", "objectAt[id] = des, dropObj[0] = id"));
		XmlTransition t4 = new XmlTransition("id2", "id6", t4labels);
		
		List<XmlLabel> t5labels = new ArrayList<XmlLabel>();
		t5labels.add(new XmlLabel("kind", "guard", "objectAt[id] == src"));
		t5labels.add(new XmlLabel("kind", "synchronisation", "take[0]!"));
		t5labels.add(new XmlLabel("kind", "assignment", "treattime[0] = tt, takeObj[0] = id"));
		XmlTransition t5 = new XmlTransition("id5", "id2", t5labels);
		
		List<XmlLabel> t6labels = new ArrayList<XmlLabel>();
		t6labels.add(new XmlLabel("kind", "guard", "agentAt[2] >= 0"));
		t6labels.add(new XmlLabel("kind", "synchronisation", "g4t[2]!"));
		t6labels.add(new XmlLabel("kind", "assignment", "takeAt[2] = src, dropAt[2] = des"));
		XmlTransition t6 = new XmlTransition("id6", "id3", t6labels);
		
		List<XmlLabel> t7labels = new ArrayList<XmlLabel>();
		t7labels.add(new XmlLabel("kind", "guard", "agentAt[1] >= 0"));
		t7labels.add(new XmlLabel("kind", "synchronisation", "g4t[1]!"));
		t7labels.add(new XmlLabel("kind", "assignment", "takeAt[1] = src, dropAt[1] = des"));
		XmlTransition t7 = new XmlTransition("id6", "id4", t7labels);
		
		List<XmlLabel> t8labels = new ArrayList<XmlLabel>();
		t8labels.add(new XmlLabel("kind", "guard", "agentAt[0] >= 0"));
		t8labels.add(new XmlLabel("kind", "synchronisation", "g4t[0]!"));
		t8labels.add(new XmlLabel("kind", "assignment", "takeAt[0] = src, dropAt[0] = des"));
		XmlTransition t8 = new XmlTransition("id6", "id5", t8labels);
		
		addTransition(document, template, t0);
		addTransition(document, template, t1);
		addTransition(document, template, t2);
		addTransition(document, template, t3);
		addTransition(document, template, t4);
		addTransition(document, template, t5);
		addTransition(document, template, t6);
		addTransition(document, template, t7);
		addTransition(document, template, t8);
	}
	
	private static void createAgentTemplate(Document document, Element nta){
		Element template = document.createElement("template");
		nta.appendChild(template);
		Element name = document.createElement("name");
		name.setTextContent("Agent");
		template.appendChild(name);
		
		Element parameter = document.createElement("parameter");
		parameter.setTextContent("const int id, int src, int des, int co, int thr");
		template.appendChild(parameter);
		
		Element declaration = document.createElement("declaration");
		declaration.setTextContent("clock c;");
		template.appendChild(declaration);
		
		XmlLocation id7 = new XmlLocation("id7", "judg", null, true);
		XmlLocation id8 = new XmlLocation("id8", "start", null, true);
		XmlLocation id9 = new XmlLocation("id9", "intrans", new XmlLabel("kind", "invariant", "c <= dis[agentAt[id]][dropAt[id]] + treattime[id] && cost' == co"), false);
		XmlLocation id10 = new XmlLocation("id10", "wait", new XmlLabel("kind", "invariant","cost' == co"), false);
		XmlLocation id11 = new XmlLocation("id11", "arrived", null, false);
		XmlLocation id12 = new XmlLocation("id12", "todes", new XmlLabel("kind", "invariant", "c <= dis[agentAt[id]][des] && cost' == co"), false);
		XmlLocation id13 = new XmlLocation("id13", "go4trans", new XmlLabel("kind", "invariant", "c <= dis[agentAt[id]][takeAt[id]] && cost' == co"), false);
		XmlLocation id14 = new XmlLocation("id14", "idle", new XmlLabel("kind", "invariant", "cost' == co"), false);
		XmlLocation id15 = new XmlLocation("id15", "ready", new XmlLabel("kind", "invariant", "c <= 1 && cost' == -dis[src][des]"), false);
		
		addLocation(document, template, id7);
		addLocation(document, template, id8);
		addLocation(document, template, id9);
		addLocation(document, template, id10);
		addLocation(document, template, id11);
		addLocation(document, template, id12);
		addLocation(document, template, id13);
		addLocation(document, template, id14);
		addLocation(document, template, id15);
		
		Element init = document.createElement("init");
		init.setAttribute("ref", "id8");
		template.appendChild(init);
		
		List<XmlLabel> t0labels = new ArrayList<XmlLabel>();
		t0labels.add(new XmlLabel("kind", "guard", "c == dis[agentAt[id]][dropAt[id]] + treattime[id]"));
		t0labels.add(new XmlLabel("kind", "synchronisation", "drop[id]!"));
		t0labels.add(new XmlLabel("kind", "assignment", "agentAt[id] = dropAt[id], c = 0"));
		XmlTransition t0 = new XmlTransition("id9", "id14", t0labels);
		
		List<XmlLabel> t1labels = new ArrayList<XmlLabel>();
		t1labels.add(new XmlLabel("kind", "guard", "dis[agentAt[id]][takeAt[id]] + dis[takeAt[id]][dropAt[id]] + dis[dropAt[id]][des] - dis[src][des] <= thr"));
//		XmlTransition t1 = new XmlTransition("id7", "id13", t1labels);
		XmlTransition t1 = new XmlTransition("id7", "id13", null);
		
		List<XmlLabel> t2labels = new ArrayList<XmlLabel>();
		t2labels.add(new XmlLabel("kind", "synchronisation", "g4t[id]?"));
		t2labels.add(new XmlLabel("kind", "assignment", "c = 0"));
		XmlTransition t2 = new XmlTransition("id14", "id7", t2labels);
		
		List<XmlLabel> t3labels = new ArrayList<XmlLabel>();
		t3labels.add(new XmlLabel("kind", "assignment", "c = 0"));
		XmlTransition t3 = new XmlTransition("id8", "id15", t3labels);
		
		List<XmlLabel> t4labels = new ArrayList<XmlLabel>();
		t4labels.add(new XmlLabel("kind", "synchronisation", "take[id]?"));
		t4labels.add(new XmlLabel("kind", "assignment", "c = 0"));
		XmlTransition t4 = new XmlTransition("id10", "id9", t4labels);
		
		List<XmlLabel> t5labels = new ArrayList<XmlLabel>();
		t5labels.add(new XmlLabel("kind", "guard", "c == dis[agentAt[id]][takeAt[id]]"));
		t5labels.add(new XmlLabel("kind", "assignment", "agentAt[id] = takeAt[id]"));
		XmlTransition t5 = new XmlTransition("id13", "id10", t5labels);
		
		List<XmlLabel> t6labels = new ArrayList<XmlLabel>();
		t6labels.add(new XmlLabel("kind", "guard", "c == dis[agentAt[id]][des]"));
		t6labels.add(new XmlLabel("kind", "assignment", "agentAt[id] = des, c = 0"));
		XmlTransition t6 = new XmlTransition("id12", "id11", t6labels);
		
		List<XmlLabel> t7labels = new ArrayList<XmlLabel>();
		t7labels.add(new XmlLabel("kind", "assignment", "c = 0"));
		XmlTransition t7 = new XmlTransition("id14", "id12", t7labels);
		
		List<XmlLabel> t8labels = new ArrayList<XmlLabel>();
		t8labels.add(new XmlLabel("kind", "guard", "c == 1"));
		t8labels.add(new XmlLabel("kind", "assignment", "agentAt[id] = src, c = 0"));
		XmlTransition t8 = new XmlTransition("id15", "id14", t8labels);
		
		addTransition(document, template, t0);
		addTransition(document, template, t1);
		addTransition(document, template, t2);
		addTransition(document, template, t3);
		addTransition(document, template, t4);
		addTransition(document, template, t5);
		addTransition(document, template, t6);
		addTransition(document, template, t7);
		addTransition(document, template, t8);
	}
	
	private static void addTransition(Document document, Element template, XmlTransition transition){
		Element t = document.createElement("transition");
		Element source = document.createElement("source");
		source.setAttribute("ref", transition.getSource());
		t.appendChild(source);
		Element target = document.createElement("target");
		target.setAttribute("ref", transition.getTarget());
		t.appendChild(target);
		
		if(transition.getLabels() != null){
			for(XmlLabel xmllabel : transition.getLabels()){
				Element label = document.createElement("label");
				label.setAttribute(xmllabel.getAttributeType(), xmllabel.getAttributeContent());
				label.setTextContent(xmllabel.getContent());
				t.appendChild(label);
			}
		}
		
		template.appendChild(t);
	}
	
	private static void addLocation(Document document, Element template, XmlLocation location){
		Element l = document.createElement("location");
		l.setAttribute("id", location.getId());
		Element name = document.createElement("name");
		name.setTextContent(location.getName());
		l.appendChild(name);
		
		if(location.getLabel() != null){
			Element label = document.createElement("label");
			label.setAttribute(location.getLabel().getAttributeType(), location.getLabel().getAttributeContent());
			label.setTextContent(location.getLabel().getContent());
			l.appendChild(label);
		}
		
		if(location.getUrgent() == true){
			Element urgent = document.createElement("urgent");
			l.appendChild(urgent);
		}
		
		template.appendChild(l);
	}
	
	public static void generateUppaalFile4a1(CompositionService compositionService, Agent[] agents, String fileName){
		Document document;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return;
		}
		
		Element nta = document.createElement("nta"); // root node <nta>
		document.appendChild(nta);
		
		Element globalDeclaration = document.createElement("declaration");
		globalDeclaration.setTextContent(XMLContent.decl);
		nta.appendChild(globalDeclaration);
		
		createObjTemplate4a1(document, nta);
		createAgentTemplate(document, nta);
		createProcessTemplate4a1(document, nta, compositionService);
		createCon1Template(document, nta, compositionService);
		createCon2Template(document, nta, compositionService);
		createSystem(document, nta, compositionService, agents);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			File file = new File(fileName);
			if(file.exists())
				file.delete();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(
					fileName));
			StreamResult result = new StreamResult(printWriter);
			transformer.transform(source, result);
			//System.out.println("create XML file done!");
		} catch (Exception e) {
			System.err.println("create XML file error!");
		}
	}
	
	private static void createObjTemplate4a1(Document document, Element nta){
		Element template = document.createElement("template");
		nta.appendChild(template);
		Element name = document.createElement("name");
		name.setTextContent("Obj");
		template.appendChild(name);
		
		Element parameter = document.createElement("parameter");
		parameter.setTextContent("const int id, int src, int des, int tt");
		template.appendChild(parameter);
		
		XmlLocation id2 = new XmlLocation("id2", "intrans0", null, false);
		XmlLocation id5 = new XmlLocation("id5", "wait0", null, false);
		XmlLocation id6 = new XmlLocation("id6", "idle", null, false);
		
		addLocation(document, template, id2);
		addLocation(document, template, id5);
		addLocation(document, template, id6);
		
		Element init = document.createElement("init");
		init.setAttribute("ref", "id6");
		template.appendChild(init);
		
		List<XmlLabel> t4labels = new ArrayList<XmlLabel>();
		t4labels.add(new XmlLabel("kind", "synchronisation", "drop[0]?"));
		t4labels.add(new XmlLabel("kind", "assignment", "objectAt[id] = des, dropObj[0] = id"));
		XmlTransition t4 = new XmlTransition("id2", "id6", t4labels);
		
		List<XmlLabel> t5labels = new ArrayList<XmlLabel>();
		t5labels.add(new XmlLabel("kind", "guard", "objectAt[id] == src"));
		t5labels.add(new XmlLabel("kind", "synchronisation", "take[0]!"));
		t5labels.add(new XmlLabel("kind", "assignment", "treattime[0] = tt, takeObj[0] = id"));
		XmlTransition t5 = new XmlTransition("id5", "id2", t5labels);
		
		List<XmlLabel> t8labels = new ArrayList<XmlLabel>();
		t8labels.add(new XmlLabel("kind", "guard", "agentAt[0] >= 0"));
		t8labels.add(new XmlLabel("kind", "synchronisation", "g4t[0]!"));
		t8labels.add(new XmlLabel("kind", "assignment", "takeAt[0] = src, dropAt[0] = des"));
		XmlTransition t8 = new XmlTransition("id6", "id5", t8labels);
		
		addTransition(document, template, t4);
		addTransition(document, template, t5);
		addTransition(document, template, t8);
	}
	
	private static void createProcessTemplate4a1(Document document, Element nta, CompositionService cs){
		Element template = document.createElement("template");
		nta.appendChild(template);
		Element name = document.createElement("name");
		name.setTextContent("Process");
		template.appendChild(name);
		
		Element declaration = document.createElement("declaration");
		declaration.setTextContent("clock c;clock gc;");
		template.appendChild(declaration);
		
		XmlLocation id16 = new XmlLocation("id16", "end", null, false);
		XmlLocation id17 = new XmlLocation("id17", "start", null, false);
		XmlLocation id18 = new XmlLocation("id18", "tmp", null, false);
		XmlLocation id19 = new XmlLocation("id19", "sb", new XmlLabel("kind", "invariant", "c <= " + cs.getComponentServices().get("sb").getT()), false);
		XmlLocation id20 = new XmlLocation("id20", "fb", null, false);
		XmlLocation id21 = new XmlLocation("id21", "br", new XmlLabel("kind", "invariant", "c <= " + cs.getComponentServices().get("br").getT()), false);
		XmlLocation id29 = new XmlLocation("id29", "ready", new XmlLabel("kind", "invariant", "c <= 1" + " && cost' == " + 
				(cs.getComponentServices().get("sb").getC() + cs.getComponentServices().get("br").getC() + cs.getComponentServices().get("rp").getC())), false);
		
		addLocation(document, template, id16);
		addLocation(document, template, id17);
		addLocation(document, template, id18);
		addLocation(document, template, id19);
		addLocation(document, template, id20);
		addLocation(document, template, id21);
		addLocation(document, template, id29);
		
		Element init = document.createElement("init");
		init.setAttribute("ref", "id17");
		template.appendChild(init);
		
		List<XmlLabel> t0labels = new ArrayList<XmlLabel>();
		t0labels.add(new XmlLabel("kind", "guard", "con1_done == 1 && con2_done == 1 && gc <= " + cs.getConstraint()));
		XmlTransition t0 = new XmlTransition("id18", "id16", t0labels);
		
		List<XmlLabel> t1labels = new ArrayList<XmlLabel>();
		t1labels.add(new XmlLabel("kind", "guard", "c == 1 && agentAt[0] >= 0"));
		t1labels.add(new XmlLabel("kind", "assignment", "c = 0"));
		XmlTransition t1 = new XmlTransition("id29", "id21", t1labels);
		
		List<XmlLabel> t2labels = new ArrayList<XmlLabel>();
		t2labels.add(new XmlLabel("kind", "guard", cs.getComponentServices().get("tmp").getGuard()));
		t2labels.add(new XmlLabel("kind", "assignment", cs.getComponentServices().get("sb").getUpdate()));
		XmlTransition t2 = new XmlTransition("id19", "id18", t2labels);
		
		List<XmlLabel> t3labels = new ArrayList<XmlLabel>();
		t3labels.add(new XmlLabel("kind", "guard", cs.getComponentServices().get("sb").getGuard() + " && gc <= " + cs.getConstraint()));
		t3labels.add(new XmlLabel("kind", "assignment", "c = 0"));
		XmlTransition t3 = new XmlTransition("id20", "id19", t3labels);
		
		List<XmlLabel> t4labels = new ArrayList<XmlLabel>();
		t4labels.add(new XmlLabel("kind", "guard", cs.getComponentServices().get("fb").getGuard()));
		t4labels.add(new XmlLabel("kind", "assignment", cs.getComponentServices().get("br").getUpdate()));
		XmlTransition t4 = new XmlTransition("id21", "id20", t4labels);
		
		List<XmlLabel> t5labels = new ArrayList<XmlLabel>();
		t5labels.add(new XmlLabel("kind", "assignment", "c = 0"));
		XmlTransition t5 = new XmlTransition("id17", "id29", t5labels);
		
		addTransition(document, template, t0);
		addTransition(document, template, t1);
		addTransition(document, template, t2);
		addTransition(document, template, t3);
		addTransition(document, template, t4);
		addTransition(document, template, t5);
	}
	
	public static void generateUppaalFile4a2(CompositionService compositionService, Agent[] agents, String fileName){
		Document document;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return;
		}
		
		Element nta = document.createElement("nta"); // root node <nta>
		document.appendChild(nta);
		
		Element globalDeclaration = document.createElement("declaration");
		globalDeclaration.setTextContent(XMLContent.decl);
		nta.appendChild(globalDeclaration);
		
		createObjTemplate4a2(document, nta);
		createAgentTemplate(document, nta);
		createProcessTemplate4a2(document, nta, compositionService);
		createCon1Template(document, nta, compositionService);
		createCon2Template(document, nta, compositionService);
		createSystem(document, nta, compositionService, agents);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			File file = new File(fileName);
			if(file.exists())
				file.delete();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(
					fileName));
			StreamResult result = new StreamResult(printWriter);
			transformer.transform(source, result);
			//System.out.println("create XML file done!");
		} catch (Exception e) {
			System.err.println("create XML file error!");
		}
	}
	
	private static void createObjTemplate4a2(Document document, Element nta){
		Element template = document.createElement("template");
		nta.appendChild(template);
		Element name = document.createElement("name");
		name.setTextContent("Obj");
		template.appendChild(name);
		
		Element parameter = document.createElement("parameter");
		parameter.setTextContent("const int id, int src, int des, int tt");
		template.appendChild(parameter);
		
		XmlLocation id0 = new XmlLocation("id0", "intrans1", null, false);
		XmlLocation id4 = new XmlLocation("id4", "wait1", null, false);
		XmlLocation id2 = new XmlLocation("id2", "intrans0", null, false);
		XmlLocation id5 = new XmlLocation("id5", "wait0", null, false);
		XmlLocation id6 = new XmlLocation("id6", "idle", null, false);
		
		addLocation(document, template, id2);
		addLocation(document, template, id5);
		addLocation(document, template, id6);
		addLocation(document, template, id0);
		addLocation(document, template, id4);
		
		
		Element init = document.createElement("init");
		init.setAttribute("ref", "id6");
		template.appendChild(init);
		
		List<XmlLabel> t4labels = new ArrayList<XmlLabel>();
		t4labels.add(new XmlLabel("kind", "synchronisation", "drop[0]?"));
		t4labels.add(new XmlLabel("kind", "assignment", "objectAt[id] = des, dropObj[0] = id"));
		XmlTransition t4 = new XmlTransition("id2", "id6", t4labels);
		
		List<XmlLabel> t5labels = new ArrayList<XmlLabel>();
		t5labels.add(new XmlLabel("kind", "guard", "objectAt[id] == src"));
		t5labels.add(new XmlLabel("kind", "synchronisation", "take[0]!"));
		t5labels.add(new XmlLabel("kind", "assignment", "treattime[0] = tt, takeObj[0] = id"));
		XmlTransition t5 = new XmlTransition("id5", "id2", t5labels);
		
		List<XmlLabel> t8labels = new ArrayList<XmlLabel>();
		t8labels.add(new XmlLabel("kind", "guard", "agentAt[0] >= 0"));
		t8labels.add(new XmlLabel("kind", "synchronisation", "g4t[0]!"));
		t8labels.add(new XmlLabel("kind", "assignment", "takeAt[0] = src, dropAt[0] = des"));
		XmlTransition t8 = new XmlTransition("id6", "id5", t8labels);
		
		List<XmlLabel> t0labels = new ArrayList<XmlLabel>();
		t0labels.add(new XmlLabel("kind", "synchronisation", "drop[1]?"));
		t0labels.add(new XmlLabel("kind", "assignment", "objectAt[id] = des, dropObj[1] = id"));
		XmlTransition t0 = new XmlTransition("id0", "id6", t0labels);
		
		List<XmlLabel> t1labels = new ArrayList<XmlLabel>();
		t1labels.add(new XmlLabel("kind", "guard", "objectAt[id] == src"));
		t1labels.add(new XmlLabel("kind", "synchronisation", "take[1]!"));
		t1labels.add(new XmlLabel("kind", "assignment", "treattime[1] = tt, takeObj[1] = id"));
		XmlTransition t1 = new XmlTransition("id4", "id0", t1labels);
		
		List<XmlLabel> t7labels = new ArrayList<XmlLabel>();
		t7labels.add(new XmlLabel("kind", "guard", "agentAt[1] >= 0"));
		t7labels.add(new XmlLabel("kind", "synchronisation", "g4t[1]!"));
		t7labels.add(new XmlLabel("kind", "assignment", "takeAt[1] = src, dropAt[1] = des"));
		XmlTransition t7 = new XmlTransition("id6", "id4", t7labels);
		
		addTransition(document, template, t4);
		addTransition(document, template, t5);
		addTransition(document, template, t8);
		addTransition(document, template, t0);
		addTransition(document, template, t1);
		addTransition(document, template, t7);
	}
	
	private static void createProcessTemplate4a2(Document document, Element nta, CompositionService cs){
		Element template = document.createElement("template");
		nta.appendChild(template);
		Element name = document.createElement("name");
		name.setTextContent("Process");
		template.appendChild(name);
		
		Element declaration = document.createElement("declaration");
		declaration.setTextContent("clock c;clock gc;");
		template.appendChild(declaration);
		
		XmlLocation id16 = new XmlLocation("id16", "end", null, false);
		XmlLocation id17 = new XmlLocation("id17", "start", null, false);
		XmlLocation id18 = new XmlLocation("id18", "tmp", null, false);
		XmlLocation id19 = new XmlLocation("id19", "sb", new XmlLabel("kind", "invariant", "c <= " + cs.getComponentServices().get("sb").getT()), false);
		XmlLocation id20 = new XmlLocation("id20", "fb", null, false);
		XmlLocation id21 = new XmlLocation("id21", "br", new XmlLabel("kind", "invariant", "c <= " + cs.getComponentServices().get("br").getT()), false);
		XmlLocation id29 = new XmlLocation("id29", "ready", new XmlLabel("kind", "invariant", "c <= 1" + " && cost' == " + 
				(cs.getComponentServices().get("sb").getC() + cs.getComponentServices().get("br").getC() + cs.getComponentServices().get("rp").getC())), false);
		
		addLocation(document, template, id16);
		addLocation(document, template, id17);
		addLocation(document, template, id18);
		addLocation(document, template, id19);
		addLocation(document, template, id20);
		addLocation(document, template, id21);
		addLocation(document, template, id29);
		
		Element init = document.createElement("init");
		init.setAttribute("ref", "id17");
		template.appendChild(init);
		
		List<XmlLabel> t0labels = new ArrayList<XmlLabel>();
		t0labels.add(new XmlLabel("kind", "guard", "con1_done == 1 && con2_done == 1 && gc <= " + cs.getConstraint()));
		XmlTransition t0 = new XmlTransition("id18", "id16", t0labels);
		
		List<XmlLabel> t1labels = new ArrayList<XmlLabel>();
		t1labels.add(new XmlLabel("kind", "guard", "c == 1 && agentAt[0] >= 0 && agentAt[1] >= 0"));
		t1labels.add(new XmlLabel("kind", "assignment", "c = 0"));
		XmlTransition t1 = new XmlTransition("id29", "id21", t1labels);
		
		List<XmlLabel> t2labels = new ArrayList<XmlLabel>();
		t2labels.add(new XmlLabel("kind", "guard", cs.getComponentServices().get("tmp").getGuard()));
		t2labels.add(new XmlLabel("kind", "assignment", cs.getComponentServices().get("sb").getUpdate()));
		XmlTransition t2 = new XmlTransition("id19", "id18", t2labels);
		
		List<XmlLabel> t3labels = new ArrayList<XmlLabel>();
		t3labels.add(new XmlLabel("kind", "guard", cs.getComponentServices().get("sb").getGuard() + " && gc <= " + cs.getConstraint()));
		t3labels.add(new XmlLabel("kind", "assignment", "c = 0"));
		XmlTransition t3 = new XmlTransition("id20", "id19", t3labels);
		
		List<XmlLabel> t4labels = new ArrayList<XmlLabel>();
		t4labels.add(new XmlLabel("kind", "guard", cs.getComponentServices().get("fb").getGuard()));
		t4labels.add(new XmlLabel("kind", "assignment", cs.getComponentServices().get("br").getUpdate()));
		XmlTransition t4 = new XmlTransition("id21", "id20", t4labels);
		
		List<XmlLabel> t5labels = new ArrayList<XmlLabel>();
		t5labels.add(new XmlLabel("kind", "assignment", "c = 0"));
		XmlTransition t5 = new XmlTransition("id17", "id29", t5labels);
		
		addTransition(document, template, t0);
		addTransition(document, template, t1);
		addTransition(document, template, t2);
		addTransition(document, template, t3);
		addTransition(document, template, t4);
		addTransition(document, template, t5);
	}
}

class XmlLabel{
	private String attributeType;
	private String attributeContent;
	private String content;
	
	XmlLabel(String attributeType, String attributeConte, String content){
		this.attributeType = attributeType;
		this.attributeContent = attributeConte;
		this.content = content;
	}
	
	public String getAttributeType(){
		return this.attributeType;
	}
	
	public String getAttributeContent(){
		return this.attributeContent;
	}
	
	public String getContent(){
		return this.content;
	}
}

class XmlLocation{
	private String id;
	private String name;
	private XmlLabel label;
	private boolean urgent;
	
	XmlLocation(String id, String name, XmlLabel label, boolean urgent){
		this.id = id;
		this.name = name;
		this.label = label;
		this.urgent = urgent;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public XmlLabel getLabel(){
		return this.label;
	}
	
	public boolean getUrgent(){
		return this.urgent;
	}
}

class XmlTransition{
	private String source;
	private String target;
	private List<XmlLabel> labels;
	
	XmlTransition(String source, String target, List<XmlLabel> labels){
		this.source = source;
		this.target = target;
		this.labels = labels;
	}
	
	public String getSource(){
		return this.source;
	}
	
	public String getTarget(){
		return this.target;
	}
	
	public List<XmlLabel> getLabels(){
		return this.labels;
	}
}
