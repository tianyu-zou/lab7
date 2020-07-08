	package cells;
public class combination {

	
	public cell[] cells = new cell[4];
	
	public combination(){
		 cell[] cells = new cell[4];
	}
	public combination(combination x)
	{
		for(int i=0;i<4;i++)
		{
			this.cells[i] = x.cells[i];
		}
	}
	//图像整体移动
	//左移
	public void moveLeft()
	{
		for (int i = 0;i<4;i++)
		{
			cells[i].left();
		}
	}
	//右移
	public void moveRight()
	{
		for (int i = 0;i<4;i++)
		{
			cells[i].right();
		}
	}
	//下移
	public void moveDown()
	{
		for (int i = 0;i<4;i++)
		{
			cells[i].down();
		}
	}
	//变换
	public void Turn()
	{
		//约定将cells【3】设置为左下角的点
		int min = 0;
		int mincell = 3;
		for (int i = 0;i<4;i++)
		{
			if (min<cells[i].getX())
			{
				min = cells[i].getX();
				mincell = i;
			}
		}
		int n = cells[mincell].getX();
		int m = cells[mincell].getY();
		for (int i = 0;i<4;i++)
		{
			
			int y = cells[i].getX();
			int x = cells[i].getY();
			cells[i] = new cell(x-m+n,n-y+m);
		}
	}
	//I字形图像
	public void I()
	{
		for(int i=0;i<4;i++)
		{
			cells[0] = new cell(1,1);
			cells[1] = new cell(2,1);
			cells[2] = new cell(3,1);
			cells[3] = new cell(4,1);
		}
		
	}
	public void L()
	{
		for(int i=0;i<4;i++)
		{
			cells[0] = new cell(1,1);
			cells[1] = new cell(2,1);
			cells[2] = new cell(3,1);
			cells[3] = new cell(3,2);
		}
		
	}
	public void J()
	{
		for(int i=0;i<4;i++)
		{
			cells[0] = new cell(1,2);
			cells[1] = new cell(2,2);
			cells[2] = new cell(3,2);
			cells[3] = new cell(3,1);
		}
		
	}
	public void Z()
	{
		for(int i=0;i<4;i++)
		{
			cells[0] = new cell(1,1);
			cells[1] = new cell(1,2);
			cells[2] = new cell(2,2);
			cells[3] = new cell(2,3);
		}
		
	}
	public void S()
	{
		for(int i=0;i<4;i++)
		{
			cells[0] = new cell(1,2);
			cells[1] = new cell(1,3);
			cells[2] = new cell(2,2);
			cells[3] = new cell(2,1);
		}
		
	}
	public void O()
	{
		for(int i=0;i<4;i++)
		{
			cells[0] = new cell(1,1);
			cells[1] = new cell(1,2);
			cells[2] = new cell(2,2);
			cells[3] = new cell(2,1);
		}
		
	}
	public void T()
	{
		for(int i=0;i<4;i++)
		{
			cells[0] = new cell(1,1);
			cells[1] = new cell(1,2);
			cells[2] = new cell(1,3);
			cells[3] = new cell(2,2);
		}
		
	}
}