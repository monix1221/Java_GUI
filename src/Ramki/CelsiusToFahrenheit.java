package Ramki;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CelsiusToFahrenheit extends JFrame implements ActionListener {

	private JButton bKonwertuj, bWyjscie;
	private JLabel lCelsius, lFahrenheit;
	private JTextField tCelsius, tFahrenheit;
	private double tempCelsius, tempFahrenheit;
	private JCheckBox chWielkie;
	private ButtonGroup bgRozmiar, bgRadioPanel;
	private JRadioButton rbMaly, rbSredni, rbDuzy;
	private JRadioButton rbCtoF, rbFtoC;

	public CelsiusToFahrenheit() {
		setSize(400, 200);
		setTitle("Przeliczanie stopni Celsiusza na Fahrenheita");
		setLayout(null);

		lCelsius = new JLabel("Stopnie Celsiusza:");
		lCelsius.setBounds(20, 20, 160, 20);
		add(lCelsius);

		tCelsius = new JTextField("");
		tCelsius.setBounds(170, 20, 150, 20);
		add(tCelsius);
		tCelsius.addActionListener(this);
		// toolTip:
		tCelsius.setToolTipText("Podaj temperaturê w stopniach Celsiusa");

		lFahrenheit = new JLabel("Stopnie Fahrenheita:");
		lFahrenheit.setBounds(20, 50, 150, 20);
		add(lFahrenheit);

		tFahrenheit = new JTextField("");
		tFahrenheit.setBounds(170, 50, 150, 20);
		add(tFahrenheit);
		tFahrenheit.addActionListener(this);

		bKonwertuj = new JButton("Konwertuj");
		bKonwertuj.setBounds(20, 100, 150, 20);
		add(bKonwertuj);
		bKonwertuj.addActionListener(this);

		bWyjscie = new JButton("Zakoncz");
		bWyjscie.setBounds(180, 100, 150, 20);
		add(bWyjscie);
		bWyjscie.addActionListener(this);

		chWielkie = new JCheckBox("Wielkie litery");
		chWielkie.setBounds(150, 130, 150, 20);
		add(chWielkie);
		// chWielkie.addActionListener(this);

		// panel do grupowania RadioButtonów:

		bgRozmiar = new ButtonGroup();
		// w grupie RB jeden button musi byc true, reszta false
		rbMaly = new JRadioButton("Ma³y", true);
		rbMaly.setBounds(50, 150, 100, 20);
		bgRozmiar.add(rbMaly);
		add(rbMaly);
		rbMaly.addActionListener(this);

		rbSredni = new JRadioButton("Œredni", false);
		rbSredni.setBounds(150, 150, 100, 20);
		bgRozmiar.add(rbSredni);
		add(rbSredni);
		rbSredni.addActionListener(this);

		rbDuzy = new JRadioButton("Du¿y", false);
		rbDuzy.setBounds(250, 150, 100, 20);
		bgRozmiar.add(rbDuzy);
		add(rbDuzy);
		rbDuzy.addActionListener(this);

		bgRadioPanel = new ButtonGroup();
		rbCtoF = new JRadioButton("Celsious to Fahrenheit");
		rbCtoF.setBounds(50, 180, 200, 20);
		bgRadioPanel.add(rbCtoF);
		add(rbCtoF);
		rbCtoF.setSelected(true);

		rbFtoC = new JRadioButton("Fahrenheit to Celsious");
		rbFtoC.setBounds(250, 180, 200, 20);
		add(rbFtoC);
		bgRadioPanel.add(rbFtoC);
	}

	public static void main(String[] args) {

		CelsiusToFahrenheit aplikacja = new CelsiusToFahrenheit();
		aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplikacja.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		Object zrodlo = ev.getSource();
		if (zrodlo == bWyjscie) {
			dispose();
		}

		else if (zrodlo == bKonwertuj) {

			if (chWielkie.isSelected() == true) {
				tFahrenheit.setFont(new Font("SansSerif", Font.BOLD, 18));
			} else {
				tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 12));
			}

			if (rbCtoF.isSelected()) {
				// odczytania zawartoœci pola tekstowego:
				tempCelsius = Double.parseDouble(tCelsius.getText());
				tempFahrenheit = 32.0 + (9.0 / 5) * tempCelsius;

				tFahrenheit.setText(String.valueOf(tempFahrenheit));
			} else if (rbFtoC.isSelected()) {
				tempFahrenheit = Double.parseDouble(tFahrenheit.getText());
				tempCelsius = (tempFahrenheit - 32.0) * (5 / 9.0);
				tCelsius.setText(String.valueOf(tempCelsius));
			}
		}

		if (zrodlo == tCelsius) {
			tempCelsius = Double.parseDouble(tCelsius.getText());
			tempFahrenheit = 32.0 + (9.0 / 5) * tempCelsius;
			tFahrenheit.setText(String.valueOf(tempFahrenheit));
		} else if (zrodlo == tFahrenheit) {
			tempFahrenheit = Double.parseDouble(tFahrenheit.getText());
			tempCelsius = (tempFahrenheit - 32.0) * (5 / 9.0);
			tCelsius.setText(String.valueOf(tempCelsius));
		}
		// sprawdzic czy checkbox jest zaznaczony

		else if (zrodlo == rbMaly) {
			tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 12));
		} else if (zrodlo == rbSredni) {
			tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 16));
		} else if (zrodlo == rbDuzy) {
			tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 20));
		}
	}
}
