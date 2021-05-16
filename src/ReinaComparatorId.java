import java.util.Comparator;

public class ReinaComparatorId implements Comparator<Reina>{

	@Override
	public int compare(Reina o1, Reina o2) {
		return Integer.compare(o1.getNumId(),o2.getNumId());
	}

}
