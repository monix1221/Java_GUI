package Ramki;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class JMenuTest extends JFrame implements ActionListener {

	JMenuBar menuBar;
	JMenu menuPlik, menuNarzedzia, menuPomoc, menuOpcje;
	JMenuItem mOtworz, mZapisz, mWyjscie, mNarz1, mNarz2, mOProgramie, mOpcja1, mOpcja2;
	JCheckBoxMenuItem chOpcja2;
	JTextArea notatnik;

	public JMenuTest() {
		setSize(700, 700);
		setTitle("Demonstracja JMenuBar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		menuBar = new JMenuBar();

		menuPlik = new JMenu("Plik");

		mOtworz = new JMenuItem("Otw�rz", 'O');
		mOtworz.addActionListener(this);
		mZapisz = new JMenuItem("Zapisz");
		mZapisz.addActionListener(this);
		mWyjscie = new JMenuItem("Wyj�cie");

		menuPlik.add(mOtworz);
		menuPlik.add(mZapisz);
		menuPlik.addSeparator();
		menuPlik.add(mWyjscie);

		mWyjscie.addActionListener(this);

		mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

		menuNarzedzia = new JMenu("Narz�dzia");
		mNarz1 = new JMenuItem("Narz1");
		mNarz1.setEnabled(false);
		mNarz2 = new JMenuItem("Narz2");
		mNarz2.addActionListener(this);

		menuNarzedzia.add(mNarz1);
		menuNarzedzia.add(mNarz2);

		menuOpcje = new JMenu("Opcje");
		mOpcja1 = new JMenuItem("Opcja 1");
		chOpcja2 = new JCheckBoxMenuItem("Opcja 2");
		// mOpcja2 = new JMenuItem("Opcja 2");
		chOpcja2.addActionListener(this);

		menuOpcje.add(mOpcja1);
		menuOpcje.add(chOpcja2);
		menuNarzedzia.add(menuOpcje);

		// menuBar.add(Box.createHorizontalGlue());

		menuPomoc = new JMenu("Pomoc");
		mOProgramie = new JMenuItem("O programie");
		mOProgramie.addActionListener(this);

		menuPomoc.add(mOProgramie);

		setJMenuBar(menuBar);
		menuBar.add(menuPlik);
		menuBar.add(menuNarzedzia);
		menuBar.add(menuPomoc);

		// notatnik jako argument
		notatnik = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(notatnik);
		scrollPane.setBounds(50, 50, 600, 600);
		// notatnik.setBounds(50, 50, 200, 200);
		add(scrollPane);
	}

	public static void main(String[] args) {

		JMenuTest appMenu = new JMenuTest();
		appMenu.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object zr = e.getSource();

		if (zr == mOtworz) {
			JFileChooser fc = new JFileChooser();
			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File plik = fc.getSelectedFile();
				// JOptionPane.showMessageDialog(null, "Wybrany plik to "+
				// plik.getName()+"\n"+plik.getAbsolutePath());
				try {
					Scanner skaner = new Scanner(plik);
					while (skaner.hasNext())
						notatnik.append(skaner.nextLine() + "\n");
				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				}
			}

		} else if (zr == mZapisz) {
			JFileChooser fc = new JFileChooser();
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				File plik = fc.getSelectedFile();
				// JOptionPane.showMessageDialog(null, "Wybrany plik to "+
				// plik);

				try {
					PrintWriter pw = new PrintWriter(plik);
					Scanner skaner = new Scanner(notatnik.getText());
					while (skaner.hasNext())
						pw.println(skaner.nextLine() + "\n");
					pw.close();

				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				}
			}
		}

		if (zr == mWyjscie) {

			int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno wyj��?", "Pytanie", JOptionPane.YES_NO_OPTION);
			if (odp == JOptionPane.YES_OPTION)
				dispose();
			else if (odp == JOptionPane.NO_OPTION)
				JOptionPane.showMessageDialog(null, "Wiedzia�em :D");
			else if (odp == JOptionPane.CLOSED_OPTION)
				JOptionPane.showMessageDialog(null, "Tak nie robimy", "Tytu�", JOptionPane.WARNING_MESSAGE);
		}

		if (zr == chOpcja2) {
			if (chOpcja2.isSelected()) {
				mNarz1.setEnabled(true);
			} else if (!chOpcja2.isSelected()) {
				mNarz1.setEnabled(false);
			}
		}

		if (zr == mNarz2) {
			String sMetry = JOptionPane.showInputDialog("Podaj d�ugo�� w metrach");
			double metry = Double.parseDouble(sMetry);

			double stopy = metry / 0.3048;
			String sStopy = String.format("%.2f", stopy);
			JOptionPane.showMessageDialog(null, metry + " metr�w = " + sStopy + " st�p");

		}

		if (zr == mOProgramie) {
			JOptionPane.showMessageDialog(null, "Program demonstruje wykorzystanie JMenuBar i JMenu\nWersja 1.0",
					"Tytu�", JOptionPane.WARNING_MESSAGE);
			// zamiast null mo�na wpisa� this; wpisujemy okno nadrz�dne
		}
	}
}