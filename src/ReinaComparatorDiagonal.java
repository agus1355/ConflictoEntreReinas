import java.util.Comparator;

public class ReinaComparatorDiagonal implements Comparator<Reina>{

	@Override
	public int compare(Reina o1, Reina o2) {
		return Integer.compare(o1.getPosicion().getX(),o2.getPosicion().getX());
	}

}