package simpleapilookup;
/**
 * Builds the Java Swing GUI and sets up ActionListeners for the resolve button. 
 *
 */
import javax.swing.*;

import java.awt.event.*;

public class SLGUI implements ActionListener {
	private JFrame frame;
	private JPanel addPanel;
	private JPanel addTextFieldPanel;
	private JPanel listPanel;
	private JTextArea listTextArea;
	private JTextField addRowTextField;
	private JButton addResolveButton;
	
	private SLGTextBoxLogic listLogic;
	
	public SLGUI() {
		listLogic = new SLGTextBoxLogic();
	}
	public void startGUI() {
		frame = new JFrame(SLGConstants.c_GUITitle);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400, 500);
	    
		addPanel = new JPanel();
		addTextFieldPanel = new JPanel();
		listPanel = new JPanel();

	    listTextArea = new JTextArea(SLGConstants.c_EmptyList, 15, 30);
	    JScrollPane scroll = new JScrollPane (listTextArea);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    listTextArea.setLineWrap(true);
	    listTextArea.setWrapStyleWord(true);
	    listTextArea.setEditable(false);
	    
	    listPanel.add(scroll);
        
        addRowTextField = new JTextField(30);
        addResolveButton = new JButton(SLGConstants.c_AddAsURLButton);
        addTextFieldPanel.add(addRowTextField);
        addPanel.add(addResolveButton);
        
        frame.add(listPanel);
        frame.add(addTextFieldPanel);
        frame.add(addPanel);
        
        addResolveButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
	}
	
	public void updateTextBox() {
		listTextArea.setText(listLogic.getMessage());
	}
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addResolveButton) {
        	if(addRowTextField.getText() != "") {
        		listLogic.resolveURL(addRowTextField.getText());
        	}
        }
        
        updateTextBox();
	}
}
