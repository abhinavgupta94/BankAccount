import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HelpGraphics extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public HelpGraphics(){
		
		super("HelpGraphics");	
		setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,200,300,200);
		setVisible(true);
	}

	public void paint(Graphics object) {
		object.setColor(Color.orange);
		object.setFont(new Font("Times", Font.BOLD, 32));
		object.drawString("HElP",350,70);
		object.drawRect(650,70,50,50);
		object.drawOval(850,70,50,50);
		Image image = new ImageIcon("im.jpg").getImage();
		object.drawImage(image,350,170,this);
	}

}
