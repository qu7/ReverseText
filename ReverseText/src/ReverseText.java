import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ReverseText extends JFrame {
	JTextArea txtEnterYourText = new JTextArea();
	JLabel lblWordCount = new JLabel();
	
	public ReverseText() {
		getContentPane().setLayout(null);
		
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
		int wordCount = 0;
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
		}
		
		for (int i = wordlist.size() - 1; i >= 0; i--) {
			reverseW = reverseW + wordlist.get(i);
			wordCount++;
		}
		
		// sets the new text
		txtEnterYourText.setText(reverseW);
		lblWordCount.setText("Words: " + wordCount);
		wordCount = 0;
	}
	
	// reverse letter order
	public void letterReverse (String getText) {
		String message;
		String input = getText;
		String reverseL = "";
		String word = "";
		ArrayList wordlist = new ArrayList<String>();
		String stop = " ";
		message = input + stop;
		int wordCount = 0;
		
		char space = ' ';
		char letter;
		
		// displays all characters in reverse		
		for (int i = message.length() - 1; i >= 0; i--) {
			letter = message.charAt(i);
			reverseL = reverseL + letter;
		}
		
		for (int i = wordlist.size() - 1; i >= 0; i--) {
			wordlist.get(i);
			wordCount++;
		}
		
		// sets the new text
		txtEnterYourText.setText(reverseL);
		lblWordCount.setText("Words: " + wordCount);
		wordCount = 0;
	}
	
	public static void main(String args[]) {
		ReverseText window = new ReverseText();
		window.setSize(new Dimension(450, 300));
		window.setVisible(true);
	}
}
