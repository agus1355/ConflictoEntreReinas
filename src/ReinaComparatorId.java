import java.util.Comparator;

public class ReinaComparatorId implements Comparator<Reina>{

	@Override
	public int compare(Reina o1, Reina o2) {
		return o1.getNumId() - o2.getNumId();
	}

}
