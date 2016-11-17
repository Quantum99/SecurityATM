import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadedClass implements Runnable {

	private ObjectOutputStream os;
	private ObjectInputStream is;
	private Socket socket;
	
	public ThreadedClass(Socket socketvar) {
		// TODO Auto-generated constructor stub
		super();
		this.socket = socketvar;
	}
	
	@Override
	private void run() {
		// TODO Auto-generated method stub
		int cardnumber, pin;
		try {
			os = new ObjectOutputStream(socket.getOutputStream());
			is = new ObjectInputStream(socket.getInputStream());
			
			cardnumber=(int)is.readObject();
			pin=(int)is.readObject();
			
			os.writeObject("Message Recieved");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException ex) 
		{
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		

	}
	
}
