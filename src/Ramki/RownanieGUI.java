package Ramki;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RownanieGUI extends JFrame implements ActionListener {

	private JTextField tA, tB, tC, tWynik;
	private JLabel lA, lB, lC;
	private JButton bWyjscie, bRozwiaz;

	public RownanieGUI() {
		setSize(400, 400);
		setTitle("Rozwi¹zywanie równania kwadratowego");
		setLayout(null);

		// to jest tylko rameczka do wpisania tekstu
		tA = new JTextField();
		tA.setBounds(50, 50, 50, 20);
		add(tA);
		tA.setToolTipText("Podaj wspó³czynnik a");

		lA = new JLabel("a", JLabel.RIGHT);
		lA.setBounds(0, 50, 30, 20);
		add(lA);

		tB = new JTextField();
		tB.setBounds(50, 80, 50, 20);
		add(tB);
		tB.setToolTipText("Podaj wspó³czynnik b");

		lB = new JLabel("b", JLabel.RIGHT);
		lB.setBounds(0, 80, 30, 20);
		add(lB);

		tC = new JTextField();
		tC.setBounds(50, 110, 50, 20);
		add(tC);
		tC.setToolTipText("Podaj wspó³czynnik c");

		lC = new JLabel("c", JLabel.RIGHT);
		lC.setBounds(0, 110, 30, 20);
		add(lC);

		bRozwiaz = new JButton("Rozwi¹¿ równanie");
		bRozwiaz.setBounds(20, 140, 140, 20);
		add(bRozwiaz);
		bRozwiaz.addActionListener(this);

		bWyjscie = new JButton("Wyjscie");
		bWyjscie.setBounds(190, 140, 80, 20);
		add(bWyjscie);
		bWyjscie.addActionListener(this);

		tWynik = new JTextField();
		tWynik.setBounds(20, 170, 550, 30);
		add(tWynik);
	}

	public static void main(String[] args) {

		RownanieGUI app = new RownanieGUI();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object zród³o = e.getSource();

		if (zród³o == bWyjscie) {
			dispose();
		}

		else if (zród³o == bRozwiaz) {
			int a = Integer.parseInt(tA.getText());
			int b = Integer.parseInt(tB.getText());
			int c = Integer.parseInt(tC.getText());

			RównanieKwadratowe równanie = new RównanieKwadratowe(a, b, c);
			String rozwi¹zanie = równanie.rozwi¹¿();
			tWynik.setText(rozwi¹zanie);
		}
	}
}
