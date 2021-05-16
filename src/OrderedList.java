import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class OrderedList extends LinkedList<Reina>{

	private static final long serialVersionUID = 1L;
	
	public void insertarEnOrden(Reina r, Comparator<Reina> comp)
	{
		int index = 0,
			res;
		if(this.isEmpty() != true)
		{
			Iterator<Reina> iterator = this.iterator();
			Reina reinaInsertada = iterator.next();
			index++;
			while((res = comp.compare(reinaInsertada,r)) < 0 && iterator.hasNext())
			{
				reinaInsertada = iterator.next();
				index++;
			}	
			if(res > 0)
				index--;
		}
		this.add(index, r);
	}
}
