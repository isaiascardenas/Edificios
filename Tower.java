import java.util.*;

public class Tower
{
	private int m;
	private int n;
	private int h;
	private int weight;
	private int totalPrice;
	private Hashtable<String, Integer> materials;

	public Tower(int m, int n)
	{
		this.m = m;
		this.n = n;
		this.h = 1;
		this.weight = 0;
		this.totalPrice = 0 ;
	}

	public int getTotalPrice(){
		return this.totalPrice;
	}

	public int getWeight(){
		return this.weight;
	}

	public Hashtable<String, Integer> getMaterals(){
		return this.materials;
	}
}
