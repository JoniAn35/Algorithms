package uti;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SortControll extends JPanel {
	private SortingPanel sortingPanel = new SortingPanel();

	private JButton nextStepBtn = new JButton("NextStep");

	public SortControll() {

		setLayout(new BorderLayout());
		add(sortingPanel, BorderLayout.CENTER);
		add(nextStepBtn, BorderLayout.SOUTH);
		
		nextStepBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sortingPanel.nextStepInSorting();
				if(sortingPanel.getStage() == 4) {
					nextStepBtn.setEnabled(false);
					JOptionPane.showMessageDialog(null, "The array is sorted.");
				}
			}
		});
		
	}

}
