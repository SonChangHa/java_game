package map;

public class Town extends MyMap {

	public Town(String map[][], int potalxLoca1, int potalyLoca1, int potalxLoca2, int potalyLoca2, MyMap potalnext1, MyMap potalnext2) {
		super(map);
		this.potalxLoca1 = potalxLoca1;
		this.potalxLoca2 = potalxLoca2;
		this.potalyLoca1 = potalyLoca1;
		this.potalyLoca2 = potalyLoca2;
		this.potalnext1 = potalnext1;
		this.potalnext2 = potalnext2;	
	}

}
