import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Data {
	public static HashMap<String, Effet> mapEffets = new HashMap<String, Effet>();
	public static List<String> keysEffets;
	public static HashMap<String, Modifiers> mapContextes = new HashMap<String, Modifiers>();
	public static List<String> keysContextes;
	public static HashMap<String, Modifiers> mapConditions = new HashMap<String, Modifiers>();
	public static List<String> keysConditions;
	public static HashMap<String, Modifiers> mapCout = new HashMap<String, Modifiers>();
	public static List<String> keysCout;
	public static double costTechnique = 1;
	public static double costDomination = 2;
	
	public Data(){
		mapEffets.put("+D", new Effet("+D", true, true, 2));
		mapEffets.put("-D", new Effet("-D", true, true, 2));
		mapEffets.put("+T", new Effet("+T", false, true, 1));
		mapEffets.put("-T", new Effet("-T", false, true, 1));
		mapEffets.put("+R", new Effet("+R", true, true, 1.3));
		mapEffets.put("-R", new Effet("-R", true, true, 1.5));
		mapEffets.put("Stop Talent", new Effet("Stop Talent", false, false, 5));
		mapEffets.put("Stop Maîtrise", new Effet("Stop Maîtrise", false, false, 4));
		mapEffets.put("Fatigue", new Effet("Fatigue", false, true, 1.5));
		mapEffets.put("Récupération", new Effet("Récupération", true, true, 5));
		mapEffets.put("Protection", new Effet("Protection", false, false, 4));
		mapEffets.put("Copie Technique", new Effet("Copie Technique", false, false, 3));
		mapEffets.put("Copie Domination", new Effet("Copie Domination", true, false, 3));
		mapEffets.put("Copie Talent", new Effet("Copie Talent", false, false, 3));
		mapEffets.put("Copie Maîtrise", new Effet("Copie Maîtrise", true, false, 3));
		mapEffets.put("Oppression", new Effet("Oppression", true, true, 6));
		mapEffets.put("Pillage", new Effet("Pillage", true, true, 8));
		mapEffets.put("Initiative", new Effet("Initiative", false, false, 6));
		mapEffets.put("--", new Effet("--", true, false, 0));
		keysEffets = new ArrayList<String>(mapEffets.keySet());
		
		mapContextes.put("Patience", new Modifiers("Patience", 3 ));
		mapContextes.put("Acharnement", new Modifiers("Acharnement", 3));
		mapContextes.put("Contrecoup", new Modifiers("Contrecoup", -1));
		mapContextes.put("par Glyphe", new Modifiers("par Glyphe", 3));
		keysContextes = new ArrayList<String>(mapContextes.keySet());
		
		mapConditions.put("Courage", new Modifiers("Courage", 0.8));
		mapConditions.put("Riposte", new Modifiers("Riposte", 0.8));
		mapConditions.put("Victoire", new Modifiers("Victoire", 0.8));
		mapConditions.put("Défaite", new Modifiers("Défaite", 0.8));
		keysConditions = new ArrayList<String>(mapConditions.keySet());
		
		mapCout.put("Sacrifice", new Modifiers("Sacrifice", 0.6));
		keysCout = new ArrayList<String>(mapCout.keySet());
	}
}
