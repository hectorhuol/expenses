package com.financial.analisys.financial_gui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.financial.analisys.financial_gui.view.FinancialGUI;

public class Main {
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FinancialGUI financialGUI = new FinancialGUI();
				financialGUI.createAndShowGUI();
			}
		});
	}
}
