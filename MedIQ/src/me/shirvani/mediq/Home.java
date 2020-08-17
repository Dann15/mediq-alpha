package me.shirvani.mediq;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import me.shirvani.mediq.datainteract.MediaFormatter;
import me.shirvani.mediq.scheduler.Scheduler;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 286, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelUsername = new JLabel("DR. JOHN DOE");
		labelUsername.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton buttonSearch = new JButton("");
		buttonSearch.setIcon(MediaFormatter.scaleImageIcon(new ImageIcon(Home.class.getResource("/media/search.png")), 30, 30));
		
		JLabel labelStaticTools = new JLabel("TOOLS");
		labelStaticTools.setFont(new Font("Arial", Font.BOLD, 9));
		
		JButton buttonChat = new JButton("");
		buttonChat.setIcon(MediaFormatter.scaleImageIcon(new ImageIcon(Home.class.getResource("/media/chat.png")), 30, 30));
		
		JButton buttonTasks = new JButton("");
		buttonTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Scheduler().main(null);;
			}
		});
		buttonTasks.setIcon(MediaFormatter.scaleImageIcon(new ImageIcon(Home.class.getResource("/media/clock.png")), 30, 30));
		
		JLabel labelStaticTasks = new JLabel("TASKS");
		labelStaticTasks.setFont(new Font("Arial", Font.BOLD, 9));
		
		JButton buttonStats = new JButton("");
		buttonStats.setIcon(MediaFormatter.scaleImageIcon(new ImageIcon(Home.class.getResource("/media/stats.png")), 30, 30));
		
		JButton buttonAbout = new JButton("");
		buttonAbout.setIcon(MediaFormatter.scaleImageIcon(new ImageIcon(Home.class.getResource("/media/question.png")), 30, 30));
		
		JLabel labelTimeSystem = new JLabel("Grabbing Time...");
		labelTimeSystem.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
		Timer clock = new Timer(2000, new ActionListener() { // time updates every 2 seconds
			@Override
			public void actionPerformed(ActionEvent e) {
				
				labelTimeSystem.setText(timeFormat.format(new Date()));
			}
		});
		clock.start();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(buttonChat, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
							.addComponent(buttonTasks, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
							.addComponent(buttonSearch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(labelStaticTools)
						.addComponent(buttonStats, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonAbout, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(labelStaticTasks, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(181))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(7))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(labelUsername)
					.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
					.addComponent(labelTimeSystem)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelUsername)
						.addComponent(labelTimeSystem))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(labelStaticTools, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelStaticTasks, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(buttonSearch)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonChat, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonTasks, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonStats, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
							.addComponent(buttonAbout, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
					.addGap(5))
		);
		
		String previewText = "<div style=\"font-family:'Courier New';\" >"
				+ "<b style=\"color: red\" >9:00am - APPT</b><br />&nbsp;&nbsp;&nbsp;Steve Jones<br />&nbsp;&nbsp;&nbsp;Room A<br /><br /><b>9:30am - APPT</b><br />&nbsp;&nbsp;&nbsp;Johnny Appleseed<br />&nbsp;&nbsp;&nbsp;Teleheath (#124)<br /><br />"
				+ "</div>";
		
		
		
		JEditorPane txtAreaMessages = new JEditorPane("text/html","");
		txtAreaMessages.setEditable(false);
		scrollPane.setViewportView(txtAreaMessages);
		txtAreaMessages.setText(previewText);
		txtAreaMessages.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		//txtAreaMessages.setTabSize(2); shit
		contentPane.setLayout(gl_contentPane);
	}
}
