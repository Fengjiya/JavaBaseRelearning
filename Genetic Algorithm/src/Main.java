import java.util.*;

public class Main 
{
	public static void main(String[] args)
	{
		//Point[] set = new Point[50];
		List<Point> list = new ArrayList<Point>();
		Genetic gen = new Genetic();
		double x = -1.0;
		double y = 2.0;
		int num = 30;
		
		gen.PopulationGeneration(x,y,num,list);
		int count = 0;
		
		boolean bo;
		do
		{
			count++;
			gen.Roulette(list);
			gen.crossBreed(list);
			gen.mutate(list);
			bo = gen.genStop(list);
		}while( !bo );
		
		gen.geneticPrint();
		
	}  //end of main
}  // end of class Main
