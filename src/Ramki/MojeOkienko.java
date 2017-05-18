package Ramki;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MojeOkienko extends JFrame implements ActionListener {

	JButton bPodajDate, bWyjscie; // deklarujemy dwa pola klasy
	JLabel lWyswietlDate;

	// setSize i setTitle to metody w klasie JFrame
	// konstruktor:
	public MojeOkienko() {
		setSize(300, 200);
		setTitle("Moje pierwsze okienko");
		setLayout(null);
		// wstawiamy przycisk:
		bPodajDate = new JButton("Podaj datê");
		bPodajDate.setBounds(20, 20, 100, 50);
		add(bPodajDate);
		bPodajDate.addActionListener(this);

		bWyjscie = new JButton("Wyjœcie");
		bWyjscie.setBounds(20, 100, 100, 50);
		add(bWyjscie);
		bWyjscie.addActionListener(this);

		lWyswietlDate = new JLabel("Data");
		lWyswietlDate.setBounds(200, 20, 300, 50);
		lWyswietlDate.setForeground(new Color(12, 200, 200)); // nasz tworzony
																// kolor RGB
																// zakres 0-255
		lWyswietlDate.setFont(new Font("SansSerif", Font.BOLD, 20));
		add(lWyswietlDate);
	}

	public static void main(String[] args) {

		MojeOkienko okienko = new MojeOkienko();
		// zamykamy okno, bo bez tego po zamkniêciu okno dalej by dzia³a³o,
		// tylko ukryte
		okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okienko.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object zród³o = e.getSource();
		if (zród³o == bPodajDate) {

			lWyswietlDate.setText(new Date().toString());
			// System.out.println(new Date());
		} else if (zród³o == bWyjscie) {
			dispose(); // komenda wyjscia z programu
		}
	}
}
