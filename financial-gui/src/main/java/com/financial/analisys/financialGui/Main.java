package com.financial.analisys.financialGui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.financial.analisys.financialGui.view.FinancialGUI;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.invokeLater(() -> new FinancialGUI().createAndShowGUI());
	}
}
