import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Posicion{
	private int x;
	private int y;
	
	public Posicion()
	{
		this(0,0);
	}
	public Posicion(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double distancia(Posicion obj)
	{
		return sqrt(pow(this.x - obj.x,2)+pow(this.y-obj.y,2));
	}
	
	public double distanciaAOrigen()
	{
		return sqrt(pow(this.x,2)+pow(this.y,2));
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}