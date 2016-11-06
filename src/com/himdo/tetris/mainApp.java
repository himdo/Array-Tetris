package com.himdo.tetris;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
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
	public MainApp() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JMenuItem mntmChangeLog = new JMenuItem("Change Log");
		
		mnSettings.add(mntmChangeLog);
		
		MyPanel GameBoardPanel = new MyPanel();
		//GameBoardPanel.getInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "left");
		//GameBoardPanel.getActionMap().put("left", MovingPieces.MoveLeft());//MovingPieces.MoveLeft());
		
		JPanel FuturePiece = new JPanel();
		FuturePiece.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblTimer = new JLabel("00:00");
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblScore = new JLabel("Score:");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(GameBoardPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTimer, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(FuturePiece, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblScore, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblScore, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTimer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(FuturePiece, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
					.addGap(10)
					.addComponent(GameBoardPanel, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
					.addGap(10))
		);
		frame.getContentPane().setLayout(groupLayout);
		GameBoardPanel.setVisible(true);
		
		Thread_GamePlaying update = new Thread_GamePlaying("update",GameBoardPanel);
		update.start();
		
		Thread_Repaint paint = new Thread_Repaint(GameBoardPanel);
		paint.start();
		
		Thread_Timer timer = new Thread_Timer(lblTimer); 
		timer.start();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyChar()=='a'){
					if(VarSizes.currentX>0)
						VarSizes.currentX--;
				}
				if(arg0.getKeyChar()=='d'){
					if(VarSizes.currentX+Pieces.getPieceSize(Thread_GamePlaying.piece)[0]<VarSizes.sizeX)
						VarSizes.currentX++;
				}
				if(arg0.getKeyChar()=='q'){
					Pieces.RotateLeft();
				}
				if(arg0.getKeyChar()=='e'){
					Pieces.RotateRight();
				}
			}
		});
		
		mntmChangeLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Settings.changeLog();
			}
		});
	}
}
