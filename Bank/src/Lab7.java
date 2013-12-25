import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Lab7 extends JApplet{
	
	static Lab7 obj;
	
	public void init(){
    	final ReadBA obj1 = new ReadBA();
    	
    	try{        		
    		final BankAccount bAArray[] = obj1.readBA("bankAccountFile");
    		
    		final JPanel mainPanel = new JPanel();
    		final JTextArea textArea = new JTextArea();
    		final JPasswordField passwordField = new JPasswordField();
    		
    		JButton button = new JButton("Submit");
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
                   
            button.addActionListener(new ActionListener(){ 
            	public void actionPerformed(ActionEvent event){ 
            		String text = textArea.getText();
            		Long accountno = Long.parseLong(text);
            		String password="";
            		char pass[] = passwordField.getPassword();
            		for(int i=0;i<pass.length;i++)
            			password+=pass[i];
            		int flag=0;
            		for(int i=0;i<obj1.num;i++)	
            			if(accountno == bAArray[i].getAccountNo()){
            				flag=1;
            				if(password.equals(bAArray[i].myVerifier.password)){
            					obj.screen2();
            					break;
            				}
            				else JOptionPane.showMessageDialog(mainPanel,"Wrong Password.");
            			}
            		if(flag==0) JOptionPane.showMessageDialog(mainPanel,"Wrong Account No.");
            	}
            });

    		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    		mainPanel.add(new JLabel("Account No."));
    		mainPanel.add(textArea);
    		mainPanel.add(new JLabel("Password"));
    		mainPanel.add(passwordField);
    		mainPanel.add(button);
    		
    		getContentPane().add(mainPanel);
    	}
    	catch (FileNotFoundException exception)
        {
           System.out.println("File not found.");
        }
        catch (BadDataException exception)
        {
           System.out.println("Bad data: " + exception.getMessage());
        }
        catch (IOException exception)
        {
           exception.printStackTrace();
        }
    }	
	
	private void screen2(){
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JButton button1 = new JButton(" Withdrawal ");
		JButton button2 = new JButton(" Transfer ");
		JButton button3 = new JButton(" Quick Withdraw ");
		JButton button4 = new JButton(" Show Balance ");
		JButton button5 = new JButton(" Help ");
		
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		button3.setAlignmentX(Component.CENTER_ALIGNMENT);
		button4.setAlignmentX(Component.CENTER_ALIGNMENT);
		button5.setAlignmentX(Component.CENTER_ALIGNMENT);
		
        button1.addActionListener(new ActionListener(){ 
        	public void actionPerformed(ActionEvent event){ 
        		obj.screen3();
    		}
    	});
        
        button5.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent event) { 
        		obj.screen4();
    		}
    	});
        
		mainPanel.add(button1);
		mainPanel.add(button2);
		mainPanel.add(button3);
		mainPanel.add(button4);
		mainPanel.add(button5);
	}
	
	private void screen3() {
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JLabel label2 = new JLabel("Enter the amount to be Withdrawn", JLabel.CENTER);
		final JLabel label1 = new JLabel("Balance = 10000", JLabel.CENTER);
		final JTextField textField = new JTextField();
		JButton button = new JButton("Submit");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent event) { 
        		double withdrawValue = Double.parseDouble(textField.getText());
        		if(withdrawValue < 10000)
        			label1.setText("Withdrawal Successful");
        		else 
        			label1.setText("Withdrawal Failed");
    		}
    	});
        
		mainPanel.add(label2);
		mainPanel.add(label1);
		mainPanel.add(textField);
		mainPanel.add(button);
		
	}
	
	private void screen4(){
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JButton button1 = new JButton(" Withdrawal Help ");
		JButton button2 = new JButton(" Transfer Help ");
		JButton button3 = new JButton(" Quick Withdraw Help ");
		JButton button4 = new JButton(" Show Balance Help ");
		JButton button5 = new JButton(" Exit Help ");
		
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		button3.setAlignmentX(Component.CENTER_ALIGNMENT);
		button4.setAlignmentX(Component.CENTER_ALIGNMENT);
		button5.setAlignmentX(Component.CENTER_ALIGNMENT);
		
        button1.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent event) { 
        		HelpGraphics obj = new HelpGraphics();
    		}
    	});
        
		mainPanel.add(button1);
		mainPanel.add(button2);
		mainPanel.add(button3);
		mainPanel.add(button4);
		mainPanel.add(button5);
	}
	
}