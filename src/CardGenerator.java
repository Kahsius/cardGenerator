import java.util.concurrent.ThreadLocalRandom;

public final class CardGenerator {
	private static final double pCondition = .2;
	private static final double pContexte = .3;
	private static final double pCout = .1;
	private static final double pEmpty = .1;
		
	public static Card generateCard() {
		int indexCondition, indexContexte, indexCout, indexEffet;
		Data d = new Data();
		boolean nV, C, sT, cT, e;
		String c3, c2 = "";
		
		Card card = new Card();
		card.technique = ThreadLocalRandom.current().nextInt(5, 10);
		card.domination = ThreadLocalRandom.current().nextInt(0, 8);
		
		// Generation du talent
		do{
			indexEffet = ThreadLocalRandom.current().nextInt(0, Data.keysEffets.size());
			card.talent[3] = Data.keysEffets.get(indexEffet);
			c3 = card.talent[3];
		} while (c3.equals("--") && ThreadLocalRandom.current().nextDouble() > pEmpty);
		if(ThreadLocalRandom.current().nextDouble() < pContexte && !c3.equals("--")){
			do{
				indexContexte = ThreadLocalRandom.current().nextInt(0, Data.keysContextes.size());
				card.talent[2] = Data.keysContextes.get(indexContexte);
				c2 = card.talent[2];
				nV = Data.mapEffets.get(c3).needValue;
				C = c2.equals("Contrecoup");
				e = c2.equals("");
				sT = c3.equals("Stop Talent");
				cT = c3.equals("Copie Talent");
			} while (!e && (!(nV || C) || sT || cT));
			// de base !nV && !(C || e) || (st || cT) && !e , loi de Morgan
		} else {
			card.talent[2] = "";
		}
		if(ThreadLocalRandom.current().nextDouble() < pCout 
				&& !(c3.equals("--") || c2.equals("Contrecoup"))){
			indexCout = ThreadLocalRandom.current().nextInt(0, Data.keysCout.size());
			card.talent[0] = Data.keysCout.get(indexCout);
		} else {
			card.talent[0] = "";
		}
		if(ThreadLocalRandom.current().nextDouble() < pCondition && !c3.equals("--")){
			do {
				indexCondition = ThreadLocalRandom.current().nextInt(0, Data.keysConditions.size());
				card.talent[1] = Data.keysConditions.get(indexCondition);
			} while (Data.mapEffets.get(c3).modifFight &&
					(card.talent[1].equals("Victoire") || card.talent[1].equals("Défaite")));
		} else {
			card.talent[1] = "";
		}
		if(Data.mapEffets.get(card.talent[3]).needValue){
			card.talent[4] = ThreadLocalRandom.current().nextInt(1,4) + "";
		} else {
			card.talent[4] = "";
		}	
		
		// Generation de la maitrise
		do{
			indexEffet = ThreadLocalRandom.current().nextInt(0, Data.keysEffets.size());
			card.maitrise[3] = Data.keysEffets.get(indexEffet);
			c3 = card.maitrise[3];
		}while(!Data.mapEffets.get(c3).isMaitrisable
				|| (c3.equals("--") && ThreadLocalRandom.current().nextDouble() > pEmpty));
		if(ThreadLocalRandom.current().nextDouble() < pContexte && !c3.equals("--")){
			do{
				indexContexte = ThreadLocalRandom.current().nextInt(0, Data.keysContextes.size());
				card.maitrise[2] = Data.keysContextes.get(indexContexte);
				c2 = card.maitrise[2];
			} while (!Data.mapEffets.get(c3).needValue && !c2.equals("Contrecoup")
					|| (c3.equals("Stop Talent") 
							|| c3.equals("Copie Talent")) && c2.equals("Contrecoup"));
		} else {
			card.maitrise[2] = "";
		}
		if(ThreadLocalRandom.current().nextDouble() < pCout 
				&& !(c3.equals("--") || c2.equals("Contrecoup"))){
			indexCout = ThreadLocalRandom.current().nextInt(0, Data.keysCout.size());
			card.maitrise[0] = Data.keysCout.get(indexCout);
		} else {
			card.maitrise[0] = "";
		}
		if(ThreadLocalRandom.current().nextDouble() < pCondition && !c3.equals("--")){
			do{
				indexCondition = ThreadLocalRandom.current().nextInt(0, Data.keysConditions.size());
				card.maitrise[1] = Data.keysConditions.get(indexCondition);
			} while (!Data.mapEffets.get(c3).needValue && 
					(card.maitrise[1].equals("Victoire") || card.maitrise[1].equals("Défaite")));
		} else {
			card.maitrise[1] = "";
		}
		if(Data.mapEffets.get(c3).needValue){
			card.maitrise[4] = ThreadLocalRandom.current().nextInt(1,4) + "";
		} else {
			card.maitrise[4] = "";
		}
		
		return card;
	}

}
