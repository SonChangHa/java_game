package map;

public class Store extends MyMap {

	// public int potalxLoca1;
	// public int potalyLoca1;
	public Town town;
	public int storexLoca;

	public Store(String map[][], int potalxLoca1, int potalyLoca1) {
		super(map);
		this.potalxLoca1 = potalxLoca1;
		this.potalyLoca1 = potalyLoca1;
	}

	public void metStore() {
		if(player.xLoca == this.potalxLoca1) {
			now = town;
		}
	}

}
