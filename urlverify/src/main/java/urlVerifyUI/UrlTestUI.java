package urlVerifyUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import urlverifyCode.CompareFiles;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class UrlTestUI {

	private JFrame frame = new JFrame();
	static UrlTestUI window;
//	AppendingTextPane atp = new AppendingTextPane();
	protected AppendTextPane atp= new AppendTextPane();
	SwingWorker<Object, Void> worker;
	CompareFiles tr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
//		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new UrlTestUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public UrlTestUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame.setBounds(100, 100, 822, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				worker = new SwingWorker<Object, Void>() {
			          @Override
			          public Object doInBackground() { 
			        	  btnNewButton.setEnabled(false);
			        	  
			        	  tr =new CompareFiles(atp);
			        	  try {
			        		  tr.excelcompare();
			        	  } catch (IOException e1) {
			        		  e1.printStackTrace();
				}
//				test();
				atp.appendText("helloText1");
				
				return e ;
			          }

			          @Override
			          public void done() {
							btnNewButton.setEnabled(true);
			          }
			        };
			        worker.execute();
			}
		});
		btnNewButton.setBounds(367, 111, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 169, 790, 258);
		frame.getContentPane().add(scrollPane);
		
		atp.setEditable(false);
		scrollPane.setViewportView(atp);
	}

public class AppendTextPane extends JTextPane {
	JTextPane textpane;
	
//	public AppendTextPane(JTextPane textpane) {
//		this.textpane=textpane;
//	}

	
	public void appendText(String str) {
//		Document doc = getDocument();
		
		StyledDocument doc = getStyledDocument();
        Style style = doc.addStyle("MyStyle", null);
		//for colorful text
		String clrStr = null;
		String actlStr = str;
		int length = str.length();
		StyleConstants.setForeground(style, Color.BLACK);
		if(str.contains("*#")) {
			
		int a = str.indexOf("*#",0);
		System.out.println(a);
		 clrStr= str.substring(0, a);
		System.out.println(clrStr);
		//removing color code
		actlStr= str.substring(a+2, length);
//		System.out.println(actlStr);
		
        if(clrStr.equals("#00FF00")) {
        	StyleConstants.setForeground(style, Color.BLUE);
        }
        if(clrStr.equals("#FF0000")){
        	StyleConstants.setForeground(style, Color.RED);
        }}

        StyleConstants.setFontSize(style, 12);
        StyleConstants.setFontFamily(style, "Arial");
        try {
            doc.insertString(doc.getLength(), "\n"+actlStr, style);
            setCaretPosition(doc.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
}