package JFrame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cells.cell;
import cells.combination;
import tool.Logic;


public  class Panel1 extends JPanel implements KeyListener
{
	public static final int HORRIZEN = 1;
	public static final int VERTICAL = 2;
	int score;
	
	public int pane[][] = new int [21][11]; 

	
	
	private int RectWidth = 10;
	
	Logic logic = new Logic();
	
	combination com = new combination();
	combination nextcom = new combination();
	private int blockType;
	private int changeType;
	
	class TimerListener implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
		   com.moveDown();
		 }
	}
	
//	public Panel1() {
//		//initmap();
//		//Creatnewteris();
//	}
//	



	//绘画出边框
	public void initmap()
	{
		//初始化分数
		score=0;
		//初始化第一个方块的类型
		blockType = (int) (Math.random() * 1000) % 7;
		changeType = (int) (Math.random() * 1000) % 4;
		
		for(int i=0;i<21;i++)
		{
			for(int j=0;j<11;j++)
			{
				if(i==0||i==20||j==0||j==10)
				{
					pane[i][j]=1;
				}
				else
				{
					pane[i][j]=0; 
				}
			}
		}
	}
	
	public void paint(Graphics g)
	{
		
		super.paint(g);
		//绘制正在下落的小方块
		for(int i=0;i<4;i++)
		{
			int ver = com.cells[i].getX();
			int hor = com.cells[i].getY(); 
			g.fillRect((hor+1)*RectWidth, (ver+1)*RectWidth, RectWidth, RectWidth);
		}
		for(int i=0;i<21;i++)
		{
			for(int j=0;j<11;j++)
			{
				if(pane[i][j]==1)
				{
					g.drawRect((j+1)*RectWidth, (i+1)*RectWidth, RectWidth, RectWidth);
					//System.out.print("#");
				}
				if(pane[i][j]==0)
				{
					//System.out.print(" ");
				}
				if(pane[i][j]==2)//小方块
				{
					g.fillRect((j+1)*RectWidth, (i+1)*RectWidth, RectWidth, RectWidth);
					//System.out.print("@");
				}
			}
		
			//System.out.println();
		}	
		
		g.drawString("score = "+ score, 225, 20);
		g.drawString("下一个方块：", 225, 60);
		//显示下一个方块的样子
		for(int i=0;i<4;i++)
		{
			g.fillRect((nextcom.cells[i].getY()+22)*RectWidth, 
					(nextcom.cells[i].getX()+7)*RectWidth, RectWidth, RectWidth);
		}
	}
	
	public void Creatnewteris()
	{
		switch(blockType)
		{
		case 1:com.I();
		break;
		case 2:com.Z();
		break;
		case 3:com.S();
		break;
		case 4:com.J();
		break;
		case 5:com.T();
		break;
		case 6:com.O();
		break;
		case 0:com.L();
		break;
		}
		for(int i=0;i<changeType;i++)
		{
			com.Turn();
		}
		//将旋转后的方块再次移动到最上面
		
		int min1 = Math.min(com.cells[0].getX(),com.cells[1].getX());
		int min2 = Math.min(com.cells[2].getX(),com.cells[3].getX());
		int min = Math.min(min1, min2);
		if(min>1)
		{
			for(int i=0;i<4;i++)
			{
				com.cells[i].up(min-1);
			}
		}
		
		blockType = (int) (Math.random() * 1000) % 7;
		changeType = (int) (Math.random() * 1000) % 4;
		//产生下一个方块的样式
		switch(blockType)
		{
		case 1:nextcom.I();
		break;
		case 2:nextcom.Z();
		break;
		case 3:nextcom.S();
		break;
		case 4:nextcom.J();
		break;
		case 5:nextcom.T();
		break;
		case 6:nextcom.O();
		break;
		case 0:nextcom.L();
		break;
		}
		for(int i=0;i<changeType;i++)
		{
			nextcom.Turn();
		}
		
	}
	
	
	//获得任意一格的格子类型
	public int getpanetype(int x,int y)
	{
		return this.pane[x][y];
	}
	
	
	//更改背景方格类型
	public void changeto(combination c,int num)
	{
		for(int i=0;i<4;i++)
		{
			pane[c.cells[i].getX()][c.cells[i].getY()] = num;
		}
	}
	//消行函数
	public void Checkline()
	{
		for(int i=1;i<20;i++)
		{
			if(1==logic.cleanornot(this, i))
			{
				score+=100;
				for(int row = i;row > 1 ; row--)
				{
					for(int line = 1;line < 10;line++)
					{
						pane[row][line] = pane[row-1][line];
					}
				}
				for(int line = 1;line < 10;line++)
				{
					pane[1][line] = 0;
				}
			}
		}
	}
	public void Moveup()
	{
		if(1 == logic.Turnornot(this, com))
		{
			com.Turn();
			repaint();
		}
		repaint();
	}
	//分别实现俄罗斯方块向下向左向右移动的事件
	public void Movedown()
	{
		if(1 == logic.Moveornot(this,com,VERTICAL,1))
		{
			com.moveDown();
			repaint();
		}
		//若无法下落
		else{
			//将方块加入背景
			changeto(com,2);
			Checkline();
			Creatnewteris();
			
		}
		repaint();
	}
	private void MoveLeft() 
	{
		if(1== logic.Moveornot(this,com,HORRIZEN,-1))
		{
			com.moveLeft();
			//将背景的方块类型改为2
			repaint();
		}
		
	}
	private void MoveRight() {
		if( 1== logic.Moveornot(this,com,HORRIZEN,1))
		{
			com.moveRight();
			repaint();
		}
	}
	//键盘监听
	public void keyPressed(KeyEvent e) 
	{
		 switch(e.getKeyCode())
		 {
		 case KeyEvent.VK_UP://上----旋转
		 Moveup();
		 break;
		 case KeyEvent.VK_DOWN://下----向下移动
		 Movedown();
		 break;
		 case KeyEvent.VK_LEFT://左----向左移动
		 MoveLeft();
		 break;
		 case KeyEvent.VK_RIGHT://右----向右移动
		 MoveRight();
		 break;
		 }
	}
	
	public void Gameon() throws InterruptedException
	{
		while(true)
		{
			initmap();
			repaint();
			Creatnewteris();
			
			while(logic.Gameover(this, com) == 0)
			{
				Thread.sleep(300);
				Movedown();
				
			}
			Thread.interrupted();
			JOptionPane.showMessageDialog(null, "GAME OVER");
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}

