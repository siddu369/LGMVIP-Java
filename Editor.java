import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
class Text extends JFrame {
	static Stack<Character> stackL = new Stack<Character>();
	static Stack<Character> stackR = new Stack<Character>();
	JMenuBar mb = new JMenuBar();
	JMenuItem newb, save, open, cut, copy, paste;
	JMenu file, edit;
	JTextArea ta1 = new JTextArea(65, 65);

	int x = 0, count = 0, y = 0, a = 0, start = 0, end = 0, c = 0;
	String selection;
	int returnValue = 0;
	char chr, ch1, ch2;
	String ingest = null;

	Text() {
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newb = new JMenuItem("New");
		save = new JMenuItem("Save");
		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		open = new JMenuItem("Open");
		file = new JMenu("File");
		edit = new JMenu("Edit");
		file.add(newb);
		file.add(open);
		file.add(save);
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		mb.add(file);
		mb.add(edit);
		add(mb);
		setJMenuBar(mb);
		add(new JScrollPane(ta1));
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Choose destination.");
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		newb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
					new1();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				jfc.showSaveDialog(null);
				try {
					File f = new File(jfc.getSelectedFile().getAbsolutePath());
					FileWriter out = new FileWriter(f);
					out.write(ta1.getText());
					out.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});

		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File f = new File(jfc.getSelectedFile().getAbsolutePath());
					try {
						FileReader read = new FileReader(f);
						@SuppressWarnings("resource")
						Scanner scan = new Scanner(read);
						while (scan.hasNextLine()) {
							String line = scan.nextLine() + "\n";
							ingest = ingest + line;
						}
						char[] charr = ingest.toCharArray();
						for (int i = 0; i < charr.length; i++) {
							stackL.push(charr[i]);
						}
						ta1.setText(ingest);
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					} catch (Exception e) {
						System.out.println("");
					}
				}
			}
		});

		cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
					selection = ta1.getSelectedText();
					int start = ta1.getSelectionStart();
					int end = ta1.getSelectionEnd();
					if (start == x) {
						for (int i = end - start; i > 0; i--) {
							stackR.pop();
						}
					}
					if (start != x) {
						for (int i = end - start; i > 0; i--) {
							stackL.pop();
						}
					}
					int l = stackL.size();
					int r = stackR.size();
					String st = "", st1 = "";
					for (int i = 0; i < l; i++) {
						char c = stackL.pop();
						st = Character.toString(c) + st;
					}
					char[] arr1 = st.toCharArray();
					for (int i = 0; i < arr1.length; i++) {
						stackL.push(arr1[i]);
					}
					for (int i = 0; i < r; i++) {
						char c = stackR.pop();
						st1 = st1 + Character.toString(c);
					}
					char[] arr2 = st1.toCharArray();
					for (int i = arr2.length - 1; i >= 0; i--) {
						stackR.push(arr2[i]);
					}
					ta1.setText(st + st1);
					c = 1;
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});

		copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
					selection = ta1.getSelectedText();
				}

				catch (Exception e) {
					System.out.println(e);
				}
			}
		});

		paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
					char[] arrp = selection.toCharArray();
					for (int i = 0; i < arrp.length; i++) {
						stackL.push(arrp[i]);
					}
					int l = stackL.size();
					int r = stackR.size();
					String st = "", st1 = "";
					for (int i = 0; i < l; i++) {
						char c = stackL.pop();
						st = Character.toString(c) + st;
					}
					char[] arr1 = st.toCharArray();
					for (int i = 0; i < arr1.length; i++) {
						stackL.push(arr1[i]);
					}
					for (int i = 0; i < r; i++) {
						char c = stackR.pop();
						st1 = st1 + Character.toString(c);
					}
					char[] arr2 = st1.toCharArray();
					for (int i = arr2.length - 1; i >= 0; i--) {
						stackR.push(arr2[i]);
					}
					ta1.setText(st + st1);
				} catch (NullPointerException e) {
					String st = ta1.getText();
					ta1.setText(st);
				} catch (Exception e) {
					System.out.println(e);
				}
			}

		});

		ta1.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					System.out.print("");
				} else if (e.getKeyChar() == KeyEvent.VK_TAB) {
					stackL.push('	');
					count++;
				} else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					stackL.push('\n');
					count++;
				} else {
					chr = e.getKeyChar();
					stackL.push(chr);
					count++;
				}
			}

			@Override
			public void keyReleased(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					int len = (ta1.getText()).length();
					for (int i = 0; i < count - len; i++) {
						stackR.pop();
					}
					count = len;
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		ta1.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				try {
					x = e.getMark();
					int r = stackR.size();
					if (x < y) {
						int l = stackL.size();
						for (int i = l - x; i > 0; i--) {
							char ch1 = stackL.pop();
							stackR.push(ch1);
						}
					} else if (x > y && r > 0 && a == count) {
						for (int i = x - y; i > 0; i--) {
							char ch2 = stackR.pop();
							stackL.push(ch2);
						}
					}
					y = x;
					a = count;
				} catch (Exception ex) {
					System.out.print("");
				}
			}
		});
	}

	static void new1() {
		Text st1 = new Text();
		st1.setVisible(true);
		st1.setSize(1920, 1080);
	}
}

public class Editor {
	public static void main(String args[]) {
		Text ob = new Text();
		ob.setVisible(true);
		ob.setSize(800, 600);
	}
}