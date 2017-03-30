package dtdyq.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dtdyq.client.Client;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private Client client;
	private JPanel contentPane;
	private JTextField userSend;
	private JTextArea userMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientFrame() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 414, 200);
		contentPane.add(scrollPane_1);
		
		
		userMessage = new JTextArea();
		userMessage.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollPane_1.setViewportView(userMessage);
		
		userSend = new JTextField();
		userSend.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		userSend.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(KeyEvent.VK_ENTER==e.getKeyCode()){
					String str=userSend.getText();
					if(str!=null){
						client.sendMessage(str);
						userSend.setText("");
					}
				}
			}
		});
		userSend.setBounds(22, 224, 253, 27);
		contentPane.add(userSend);
		userSend.setColumns(10);
		
		JButton userButten = new JButton("Send");
		userButten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=userSend.getText();
				if(str!=null){
					client.sendMessage(str);
					userSend.setText("");
				}
			}
		});
		userButten.setFont(new Font("ËÎÌו", Font.PLAIN, 18));
		userButten.setBounds(309, 224, 93, 27);
		contentPane.add(userButten);
		
		client=new Client(userMessage);
	}
}
