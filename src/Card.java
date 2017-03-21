
public class Card {
	public int technique;
	public int domination;
	public String[] talent;
	public String[] maitrise;
	
	public Card(){
		this.technique = 0;
		this.domination = 0;
		this.talent = new String[5];
		this.maitrise = new String[5];
	}
	
	public double getFitnessTalent(){
		double fitTalent;
		
		// Talent
		double fitContexte = 1, fitCout = 1 , fitCondition = 1, fitEffet, fitValue = 1;
		if(this.talent[0] != "") fitCout = Data.mapCout.get(this.talent[0]).param;
		if(this.talent[1] != "") fitCondition = Data.mapConditions.get(this.talent[1]).param;
		if(this.talent[2] != "") fitContexte = Data.mapContextes.get(this.talent[2]).param;
		fitEffet = Data.mapEffets.get(this.talent[3]).param;
		if(Data.mapEffets.get(this.talent[3]).needValue){
			fitValue = Integer.parseInt(this.talent[4]);
		}
		fitTalent = fitEffet * fitContexte * fitCondition * fitValue * fitCout;
		return fitTalent;
	}
	
	public double getFitnessMaitrise(){
		double fitMaitrise;
		
		// Maitrise
		double fitContexte = 1, fitCout = 1, fitCondition = 1, fitValue = 1, fitEffet;
		if(this.maitrise[0] != "") fitCout = Data.mapCout.get(this.maitrise[0]).param;
		if(this.maitrise[1] != "") fitCondition = Data.mapConditions.get(this.maitrise[1]).param;
		if(this.maitrise[2] != "") fitContexte = Data.mapContextes.get(this.maitrise[2]).param;
		fitEffet = Data.mapEffets.get(this.maitrise[3]).param;
		if(Data.mapEffets.get(this.maitrise[3]).needValue){
			fitValue = Integer.parseInt(this.maitrise[4]);
		}
		fitMaitrise = fitEffet * fitContexte * fitCondition * fitValue * fitCout;
		return fitMaitrise;
	}
	
	public double getFitness(){
		double fitness = 0;
		double fitTech = this.technique * Data.costTechnique;
		double fitDom = this.domination * Data.costDomination;

		
		fitness = fitTech + fitDom + this.getFitnessTalent() + this.getFitnessMaitrise();
		return fitness;
	}
	
	public String toString(){
		String str = "", strTalent = "", strMaitrise = "";
		int i;
		for(i = 0; i < 5; i++){
			if(!talent[i].equals("")){
				strTalent = strTalent + this.talent[i] + " ";
				if(i == 2) strTalent = strTalent + ": "; 
			}
			if(!maitrise[i].equals("")){
				strMaitrise = strMaitrise + this.maitrise[i] + " ";
				if(i == 2) strMaitrise = strMaitrise+ ": "; 
			}
		}
		str = this.technique + " " + this.domination + " | " + strTalent + " / " + strMaitrise;
		return str;
	}
}
