package map;

public class Town extends MyMap {

	public Town(String map[][], int potalxLoca1, int potalyLoca1, int potalxLoca2, int potalyLoca2) {
		super(map);
		this.potalxLoca1 = potalxLoca1;
		this.potalxLoca2 = potalxLoca2;
		this.potalyLoca1 = potalyLoca1;
		this.potalyLoca2 = potalyLoca2;
	}

}
