import java.util.concurrent.ThreadLocalRandom;

public final class CardGenerator {
	private static final double pCondition = .3;
	private static final double pContexte = .3;
	private static final double pCout = .1;
		
	public static Card generateCard() {
		int indexCondition, indexContexte, indexCout, indexEffet;
		Data d = new Data();
		Effet e;
		
		Card card = new Card();
		card.technique = ThreadLocalRandom.current().nextInt(5, 10);
		card.domination = ThreadLocalRandom.current().nextInt(0, 8);
		
		// Generation du talent
		indexEffet = ThreadLocalRandom.current().nextInt(0, Data.keysEffets.size());
		card.talent[3] = Data.keysEffets.get(indexEffet);
		if(ThreadLocalRandom.current().nextDouble() < pCout){
			indexCout = ThreadLocalRandom.current().nextInt(0, Data.keysCout.size());
			card.talent[0] = Data.keysCout.get(indexCout);
		} else {
			card.talent[0] = "";
		}
		if(ThreadLocalRandom.current().nextDouble() < pContexte){
			do{
				indexContexte = ThreadLocalRandom.current().nextInt(0, Data.keysContextes.size());
				card.talent[2] = Data.keysContextes.get(indexContexte);
			} while (!Data.mapEffets.get(card.talent[3]).needValue && !card.talent[2].equals("Contrecoup"));
		} else {
			card.talent[2] = "";
		}
		if(ThreadLocalRandom.current().nextDouble() < pCondition){
			e = Data.mapEffets.get(card.talent[3]);
			do {
				indexCondition = ThreadLocalRandom.current().nextInt(0, Data.keysConditions.size());
				card.talent[1] = Data.keysConditions.get(indexCondition);
			} while ((!e.needValue || !e.isMaitrisable && e.needValue) &&
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
		}while(!Data.mapEffets.get(Data.keysEffets.get(indexEffet)).isMaitrisable);
		card.maitrise[3] = Data.keysEffets.get(indexEffet);
		if(ThreadLocalRandom.current().nextDouble() < pCout){
			indexCout = ThreadLocalRandom.current().nextInt(0, Data.keysCout.size());
			card.maitrise[0] = Data.keysCout.get(indexCout);
		} else {
			card.maitrise[0] = "";
		}
		if(ThreadLocalRandom.current().nextDouble() < pContexte){
			do{
				indexContexte = ThreadLocalRandom.current().nextInt(0, Data.keysContextes.size());
				card.maitrise[2] = Data.keysContextes.get(indexContexte);
			} while (!Data.mapEffets.get(card.maitrise[3]).needValue && !card.maitrise[2].equals("Contrecoup"));
		} else {
			card.maitrise[2] = "";
		}
		if(ThreadLocalRandom.current().nextDouble() < pCondition){
			do{
				indexCondition = ThreadLocalRandom.current().nextInt(0, Data.keysConditions.size());
				card.maitrise[1] = Data.keysConditions.get(indexCondition);
			} while (!Data.mapEffets.get(card.maitrise[3]).needValue && 
					(card.maitrise[1].equals("Victoire") || card.maitrise[1].equals("Défaite")));
		} else {
			card.maitrise[1] = "";
		}
		if(Data.mapEffets.get(card.maitrise[3]).needValue){
			card.maitrise[4] = ThreadLocalRandom.current().nextInt(1,4) + "";
		} else {
			card.maitrise[4] = "";
		}
		
		return card;
	}

}
