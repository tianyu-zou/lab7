package cells;

public class cell {

	private int ver;
	private int hor;
	//每一个方块的位置
	public cell (int ver, int hor)
	{
		this.ver = ver;
		this.hor = hor;
	}
	public cell(cell x)
	{
		this.ver = x.getX();
		this.hor = x.getY();
	}
	//、Window->preferences->team->git->congfiguration
	//获取x坐标
	public int getX()
	{
		return ver;
	}
	//获取y坐标
	public int getY()
	{
		return hor;
	}
	//方块位置改变
	//左移
	public void left()
	{
		hor--;
	}
	//右移
	public void right()
	{
		hor++;
	}
	//下移
	public void down()
	{
		ver++;
	}
	public void up(int x)
	{
		ver=ver-x;
	}
	
}