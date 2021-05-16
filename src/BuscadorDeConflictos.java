import java.util.HashMap;

public class BuscadorDeConflictos {
	public void generarConflictos(HashMap<Integer,OrderedList> map)
	{

		for (OrderedList reinas : map.values()) {
			for (int i = 0; i < reinas.size(); i++) {
				if(i-1 >= 0)
				{					
					reinas.get(i).agregarConflicto(reinas.get(i-1));
				}
				if(i+1 < reinas.size())
				{
					reinas.get(i).agregarConflicto(reinas.get(i+1));
				}
			}			
		}
	}
}
