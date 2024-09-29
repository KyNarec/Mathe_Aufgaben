import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import com.formdev.flatlaf.*;

public class GUI implements ActionListener {
  private JTextField t1, t2, t3;
  private JButton confirm;
  private TextPrompt p1, p2, p3;
  private JComboBox<String> c;
  private String[] options = { "Anzahl der Begrüssungen", "Fakultät (rek)", "Fakultät (in)", "Bakterien (rek)",
      "Bakterien (in)", "Hasen (rek)" };
  private AUFGABEN aufgaben;
  GUI() {

    aufgaben = new AUFGABEN();
    JFrame f = new JFrame();

    /**
     * Selector for the different "aufgaben"
     */
    c = new JComboBox<>(options);
    c.setBounds(50, 45, 200, 25);
    //c.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
    c.addActionListener(this);

    /**
     * Here you enter your base number
     */
    t1 = new JTextField();
    t1.setBounds(50, 100, 200, 25);
    p1 = new TextPrompt("Number to calculate", t1);

    /**
     * Here the result will be shown
     */
    t2 = new JTextField();
    t2.setBounds(50, 150, 200, 25);
    t2.setEditable(false);
    //t2.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
    p2 = new TextPrompt("Press 'Calculate'", t2);
    //p2 = new TextPrompt("Press 'Calculate' to see result", t2);

    /**
     * The additional text field that's needed for some math problems
     */
    t3 = new JTextField();
    t3.setBounds(50, 115, 200, 25);
    //t2.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
    p3 = new TextPrompt("Additional value", t3);
    t3.setVisible(false);
    
    /**
     * Confirm Button
     */
    confirm = new JButton("Calculate");
    confirm.setBounds(100, 200, 100, 25);
    confirm.addActionListener(this);
    //confirm.setFont(new Font(Font.SERIF, Font.BOLD, 12));

    f.add(t1);
    f.add(t2);
    f.add(confirm);
    f.add(c);
    f.add(t3);
    f.setTitle("Aufgaben Rechner");
    f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    f.setSize(300, 300);
    f.setLayout(null);
    f.setVisible(true);
    f.setDefaultLookAndFeelDecorated(true);

  }

  public void actionPerformed(ActionEvent e) {
    int ex = evaluateAufgabe(c.getItemAt(c.getSelectedIndex()));
    // System.out.println(ex);

    if (e.getSource() == confirm) {
      String result = "";
      String s1 = t1.getText();
      int a = Integer.parseInt(s1);
      String s2;
      int b;

      switch (ex) {
        case 1 -> result = String.valueOf(aufgaben.anzahlBegruessungen(a));
        case 2 -> result = String.valueOf(aufgaben.fak_rek(a));
        case 3 -> result = String.valueOf(aufgaben.fak_in(a));
        case 4 -> {
          s2 = t3.getText();
          b = Integer.parseInt(s2);
          result = String.valueOf(aufgaben.bak_rek(a, b));
        }
        case 5 -> {
          s2 = t3.getText();
          b = Integer.parseInt(s2);
          result = String.valueOf(aufgaben.bak_in(a, b));
        }
        case 6 -> result = String.valueOf(aufgaben.hasen_rek(a));
      }
      t2.setText(result);

    } else if (e.getSource() == c) {
      if (ex == 4 || ex == 5) {
        t1.setBounds(50, 80, 200, 25);
        t3.setVisible(true);
      } else {
        t1.setBounds(50, 100, 200, 25);
        t3.setVisible(false);
      }
    }
  }

  public int evaluateAufgabe(String aufgabe) {
    switch (aufgabe) {
      case "Anzahl der Begrüssungen" -> {
        return 1;
      }
      case "Fakultät (rek)" -> {
        return 2;
      }
      case "Fakultät (in)" -> {
        return 3;
      }
      case "Bakterien (rek)" -> {
        return 4;
      }
      case "Bakterien (in)" -> {
        return 5;
      }
      case "Hasen (rek)" -> {
        return 6;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    new GUI();
  }
}
