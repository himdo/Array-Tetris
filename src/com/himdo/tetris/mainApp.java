package com.himdo.tetris;

import java.awt.EventQueue;
import java.awt.RenderingHints.Key;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
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
		
		FuturePiecePanel FuturePiece = new FuturePiecePanel();
		FuturePiece.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblTimer = new JLabel("00:00");
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblScoreText = new JLabel("Score:");
		
		JLabel lblScore = new JLabel("0");
		
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
							.addComponent(FuturePiece, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblScoreText)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblScore, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblScoreText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblScore, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblTimer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(FuturePiece, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)))
					.addGap(10)
					.addComponent(GameBoardPanel, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
					.addGap(10))
		);
		frame.getContentPane().setLayout(groupLayout);
		GameBoardPanel.setVisible(true);
		
		Thread_GamePlaying update = new Thread_GamePlaying("update",GameBoardPanel);
		update.start();
		
		Thread_Repaint paint = new Thread_Repaint(GameBoardPanel,FuturePiece);
		paint.start();
		
		Thread_Timer timer = new Thread_Timer(lblTimer); 
		timer.start();
		
		Pieces.scoreText = lblScore;
		
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
				if(arg0.getKeyChar()=='s'){
					VarSizes.sleepTime=250/5;
				}
				/*if(arg0.getKeyChar()==' '){
					VarSizes.sleepTime=0;
				}*/
			}
			
			public void keyReleased(KeyEvent arg0){
				if(arg0.getKeyChar()=='s'){
					VarSizes.sleepTime=250;
				}
				/*if(arg0.getKeyChar()== ' '){
					VarSizes.sleepTime=250;
				}*/

			}
		});
		
		mntmChangeLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Settings.changeLog();
			}
		});
	}
}
