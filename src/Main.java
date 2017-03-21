import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double fitness = 0, fitTalent = 0, fitMaitrise = 0;
		double maiSurTal = 2, min, max;
		int n;
		Card c = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Nombre de cartes à générer (10 par défaut): ");
		String s = scan.nextLine();
		if(s.equals("")){
			n = 10;
		} else {
			n = Integer.parseInt(s);
		}
		
		System.out.print("Fitness min (20 par défaut): ");
		s = scan.nextLine();
		if(s.equals("")){
			min = 20;
		} else {
			min = Double.parseDouble(s);
		}
		
		System.out.print("Fitness max (25 par défaut): ");
		s = scan.nextLine();
		if(s.equals("")){
			max = 25;
		} else {
			max = Double.parseDouble(s);
		}
		
		System.out.println("");
		System.out.println("Fitn | T D | Talent / Maitrise");
		System.out.println("-----+-----+------------------");
		
		for(int i = 0; i < n; i++) {
			do {
				c = CardGenerator.generateCard();
				fitness = c.getFitness();
				fitTalent = c.getFitnessTalent();
				fitMaitrise = c.getFitnessMaitrise();
			} while(fitness > max 
					|| fitness < min 
					|| fitMaitrise < 0 
					|| Math.abs(fitTalent/fitMaitrise) > 1/maiSurTal && fitMaitrise > 0);
			System.out.println(String.format("%01.1f", fitness) + " | " + c.toString());
		}
		
		scan.close();
	}

}
