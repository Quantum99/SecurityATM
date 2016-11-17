
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ATMClient extends JFrame implements ActionListener{

	JLabel wel, cnum, pin;
	JTextField cnumtext, pintext, result;
	JButton send;
	JPanel pn1, pn2, pn3, pn4;
	private Socket socket;
	private ObjectOutputStream os;
	private ObjectInputStream is;
	
	public ATMClient() {
	// TODO Auto-generated constructor stub
		super("ATM Prompt");
		
		try {
			socket = new Socket("localhost", 555);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setLayout(new GridLayout(5,1));
		initializeComponents();
		addComponentsToPanels();
		addPanelsToWindow();
		registerListeners();
		setWindowProperties();
	}
	
	public void getStreams(){
		try {
			os = new ObjectOutputStream(socket.getOutputStream());
			is = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initializeComponents(){
		wel = new JLabel("Welcome");
		cnum = new JLabel("Card Number");
		pin = new JLabel("PIN");
		
		cnumtext = new JTextField();
		pintext = new JTextField();
		result = new JTextField();
		
		send = new JButton("Send");
		
		pn1 = new JPanel(new GridLayout(1, 2));
		pn2 = new JPanel(new GridLayout(1, 2));
		pn3 = new JPanel(new GridLayout(1, 2));
		pn4 = new JPanel(new GridLayout(1, 2));
		
	}
	
	public void addComponentsToPanels(){
		pn1.add(wel);
		pn2.add(cnum);
		pn2.add(cnumtext);
		pn3.add(pin);
		pn3.add(pintext);
		pn4.add(send);
	}
	
	public void addPanelsToWindow(){
		this.add(pn1);
		this.add(pn2);
		this.add(pn3);
		this.add(pn4);
	}
	
	public void registerListeners(){
		send.addActionListener(this);
	}
	
	public void setWindowProperties(){
		this.setSize(350,105);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource().equals(send)){
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] arg){
		@SuppressWarnings("unused")
		ATMClient client = new ATMClient();
	}
	

}