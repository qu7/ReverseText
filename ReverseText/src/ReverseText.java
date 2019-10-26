import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.StringTokenizer;

public class ReverseText extends JFrame {
	JTextArea txtEnterYourText = new JTextArea();
	JLabel lblWordCount = new JLabel();
	
	public ReverseText() {
		getContentPane().setLayout(null);
		txtEnterYourText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				final String getText = txtEnterYourText.getText();
				wordCount(getText);
			}
		});
		
		txtEnterYourText.setColumns(3);
		txtEnterYourText.setTabSize(5);
		txtEnterYourText.setText("Enter your text here...");
		txtEnterYourText.setBounds(10, 11, 414, 193);
		getContentPane().add(txtEnterYourText);
		
		// this button reverses the letters but not the words
		JButton btnLetterOrder = new JButton("Reverse Letters");
		btnLetterOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final String getText = txtEnterYourText.getText();
				letterReverse(getText);
			}
		});
		btnLetterOrder.setBounds(150, 215, 130, 35);
		getContentPane().add(btnLetterOrder);
		
		// shows the current word count
		lblWordCount.setBounds(290, 215, 98, 35);
		getContentPane().add(lblWordCount);
	
		// this button reverses the words in the text field
		JButton btnWordOrder = new JButton("Reverse Words");
		btnWordOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final String getText = txtEnterYourText.getText();
				wordReverse(getText);
			}
		});
		btnWordOrder.setBounds(10, 215, 130, 35);
		getContentPane().add(btnWordOrder);
		}
	
	// reverse word order
	public void wordReverse (String getText) {
		String message = getText;
		String reverseW = "";
		String word = "";
		ArrayList wordlist = new ArrayList<String>();
		char letter;
		
		for (int i = 0; i < message.length(); i++) {
			letter = message.charAt(i);
			if (i == message.length() - 1) {
				word = word + letter;
				wordlist.add(word);
			}
			else if (letter != ' ') {
				word = word + letter;
			}
			else {
				wordlist.add(word);
				System.out.println(word);
				word = "";
			}
		}
		
		txtEnterYourText.setText("");
		for (int i = wordlist.size() - 1; i >= 0; i--) {
			if (i == 0) {
				txtEnterYourText.append(wordlist.get(i) + "");
			}
			else {
				txtEnterYourText.append(wordlist.get(i) + " ");
			}
		}
		
		// sets the new text
	//	txtEnterYourText.setText(reverseW);
	}
	
	// reverse letter order
	public void letterReverse (String getText) {
		String message = getText;
		String reverseL = "";
		String word = "";
		ArrayList wordlist = new ArrayList<String>();
		char letter;
		
		// displays all characters in reverse		
		for (int i = message.length() - 1; i >= 0; i--) {
			letter = message.charAt(i);
			reverseL = reverseL + letter;
		}
		
		for (int i = wordlist.size() - 1; i >= 0; i--) {
			wordlist.get(i);
		}
		
		// sets the new text
		txtEnterYourText.setText(reverseL);
	}
	
	public void wordCount(String getText) {
		String message = getText;
		//if you put only spaces, it starts counting words
		/*String word = "";
		ArrayList wordlist = new ArrayList<String>();
		char letter;
		for (int i = 0; i < message.length(); i++) {
			letter = message.charAt(i);
			if (letter != ' ') {
				word = word + letter;
			}
			else if (i == message.length() - 1) {
				word = word + " ";
				wordlist.add(word);
				word = "";
			}
			else {
				word = word + " ";
				wordlist.add(word);
				word = "";
			}
		}*/

		//more on tokens: https://docs.oracle.com/javase/7/docs/api/java/util/StringTokenizer.html
		StringTokenizer tokens = new StringTokenizer(message);
		lblWordCount.setText("Words: " + tokens.countTokens());
	}
	
	public static void main(String args[]) {
		ReverseText window = new ReverseText();
		window.setSize(new Dimension(450, 300));
		window.setVisible(true);
	}
}
