package tetris;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import JFrame.Panel1;
import tool.Logic;
import cells.combination;
import cells.cell;
import java.awt.BorderLayout;


public class GameFrame extends JFrame implements ActionListener
{
	Panel1 newp = new Panel1();
	public GameFrame() throws InterruptedException
	{
		setTitle("俄罗斯方块");
		//2:设置为可见
		setVisible(true);
		//3:设置窗口的尺寸
		setSize(400, 400);
		//4:设置窗口居中
	
		setLocationRelativeTo(null);
		//5:设置窗口关闭,即程序中止
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(newp);
		addKeyListener(newp);
		newp.Gameon();

	}

	

	public static void main(String[] args) throws InterruptedException
	{
		GameFrame newGF = new GameFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}