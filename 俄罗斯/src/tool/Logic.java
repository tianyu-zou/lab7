package tool;
import cells.cell;
import cells.combination;
import JFrame.Panel1;
public class Logic {
	public static final int HORRIZEN = 1;
	public static final int VERTICAL = 2;

	public int Moveornot(Panel1 p,combination c,int drect,int move)
	{
		for(int i=0;i<4;i++)
		{
			if(drect == VERTICAL)
			{
				//可以移动
				if(p.getpanetype(c.cells[i].getX()+move, c.cells[i].getY())!=0)
				{
					return 0;
				}
					
			}
			if(drect == HORRIZEN)
			{
				if(p.getpanetype(c.cells[i].getX(), c.cells[i].getY()+move)!=0)
				{
					return 0;
				}
			}
		}
		//将现在方块所处位置的格子类型改为0即空格
		//p.changeto(c,0);
		return 1;
	}
	
	public int Turnornot(Panel1 p,combination c)
	{
		combination temp = new combination(c) ;
		
		temp.Turn();
		for(int i=0;i<4;i++)
		{
			if(p.getpanetype(temp.cells[i].getX(), temp.cells[i].getY())!=0)
			{
				return 0;
			}
		}
		return 1;
		
	}
	public int Gameover(Panel1 p,combination c)
	{
		if(0 == Moveornot(p,c,VERTICAL,0))
		{
			return 1;
		}
		return 0;
	}
	//判断第num行是否需要清0
	public int cleanornot(Panel1 p,int num)
	{
		int count = 0;
	
			for(int i=1;i<10;i++)
			{
				if(p.getpanetype(num, i)==2)
				{
					count++;
				}
			}
			if(count == 9)
			{
				return 1;
			}
			
		return 0;
	}


}