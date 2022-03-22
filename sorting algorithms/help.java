import java.awt.EventQueue;
import static java.awt.EventQueue.invokeLater;

import javax.swing.JFrame;

public class help {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		invokeLater(new Runnable() {
			public void run() {
				try {
					help window = new help();
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
	public help() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
	}

}
