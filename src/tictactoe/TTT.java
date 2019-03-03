package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TTT extends JFrame implements ActionListener {

	private int num = 3;
	boolean crossturn = true;
     static class gamestatus
    {
    public final static gamestatus xwon = new gamestatus();
    public final static gamestatus owon = new gamestatus();
    public final static gamestatus incomplete = new gamestatus();
    public final static gamestatus tie = new gamestatus();

    }
	
	private JButton[][] buttons = new JButton[num][num];
	
	public TTT()
	{
		
		super.setTitle("Tic Tac Toe");
		super.setSize(800,800);
		
		GridLayout layout = new GridLayout(this.num, this.num);
		super.setLayout(layout);
		
		Font f = new Font("Comic Sans MS",2,200);
		
		
		
		for(int i = 0; i< num; i++)
		{
			for(int j =0; j< num;j++)
			{
				JButton bto = new JButton();
				
				bto.addActionListener(this);
			    bto.setFont(f);
			   // Color c = new Color(224, 224, 224);
			   // buttons[i][j].setBackground(c);
			   
			    buttons[i][j]=bto;
			    super.add(bto);
				
			}
		}
		
		
		super.setResizable(false);
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        JButton cb = (JButton)e.getSource(); 
        
      
        
        makeMove(cb);
        gamestatus s = getgamestatus();
        if(s== gamestatus.incomplete)
        {
        	return;
        }
        
        declareWinner(s);
        
        int choice = JOptionPane.showConfirmDialog(this, "replay?");
        if(choice == JOptionPane.YES_OPTION)
        {
        	//Color c = new Color(224, 224, 224);
        
        	for(int i =0; i <buttons.length; i++)
    		{
    			for(int j=0; j<buttons.length; j++)
    			{
    				buttons[i][j].setText("");
    			    buttons[i][j].setBackground(null);
    			}
    		}
        	this.crossturn = true;
        }
        
        else
        {
        	super.dispose();
        }
        
		
	}	
	
	private void makeMove(JButton cb)
	{
		String text = cb.getText();
		if(text.length() != 0)
		{
			JOptionPane.showMessageDialog(this, "Invalid move");
			return;
		}
		
		else
			if(this.crossturn)
			{
				cb.setText("x");
				Color c = new Color(0,255,0);
		        cb.setBackground(c);
			}
			else
			{
				cb.setText("o");
				Color c = new Color(0,0,255);
		        cb.setBackground(c);
		
			}
		crossturn= !crossturn;
	}
	
	private gamestatus getgamestatus()
	{
		
		String t1 = ""; 
		String t2 = ""; 
		String t3 = ""; 
		
		for(int i =0; i < buttons.length; i++)
		{
			 t1 = buttons[i][0].getText();
			 t2 = buttons[i][1].getText();
			 t3 = buttons[i][2].getText();
			
			if(t1.equals(t2) && t2.equals(t3) && t1.length()!= 0)
			{
				
				if(t1.equals("x"))
				{
					return  gamestatus.xwon;
				}
				else
					return  gamestatus.owon;
			
			}
		}
		
		for(int j =0; j < buttons.length; j++)
		{
			 t1 = buttons[0][j].getText();
			 t2 = buttons[1][j].getText();
			 t3 = buttons[2][j].getText();
			
			if(t1.equals(t2) && t2.equals(t3) && t1.length()!= 0)
			{
				if(t1.equals("x"))
				{
					return  gamestatus.xwon;
				}
				else
					return gamestatus.owon;
			
			}
		}
		
		 t1 = buttons[0][0].getText();
		 t2 = buttons[1][1].getText();
		 t3 = buttons[2][2].getText();
		
		if(t1.equals(t2) && t2.equals(t3) && t1.length()!= 0)
		{
			if(t1.equals("x"))
			{
				return gamestatus.xwon;
			}
			else
				return gamestatus.owon;
		
		}
		
		 t1 = buttons[0][2].getText();
		 t2 = buttons[1][1].getText();
		 t3 = buttons[2][0].getText();
		
		if(t1.equals(t2) && t2.equals(t3) && t1.length()!= 0)
		{
			if(t1== "x")
			{
				return gamestatus.xwon;
			}
			else
				return gamestatus.owon;
		
		}
		
		
		for(int i =0; i <buttons.length; i++)
		{
			for(int j=0; j<buttons.length; j++)
			{
				if(buttons[i][j].getText().length() == 0)
					return gamestatus.incomplete;
			}
		}
		
		
		
		
		return gamestatus.tie;
	}
	
	private void declareWinner(gamestatus gs)
	{
		if(gs == gamestatus.xwon)
		{
			JOptionPane.showMessageDialog(this, "X won");
		}
		
		if(gs == gamestatus.owon)
		{
			JOptionPane.showMessageDialog(this, "O won");
		}
		
		if(gs == gamestatus.tie)
		{
			JOptionPane.showMessageDialog(this, "tie");
		}
	}
	
}