import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import com.formdev.flatlaf.*;

public class GUI implements ActionListener {
  private final JTextField t1, t2, t3;
  private final JButton confirm;
  private final TEXT_PROMPT p1, p2, p3;
  private final JComboBox<String> c;
  private final JLabel l1, l2;
  private final AUFGABEN aufgaben;
  GUI(int width, int height) {

    FlatDarkLaf.setup();

    aufgaben = new AUFGABEN();
    JFrame f = new JFrame();

    /*
     * Selector for the different "aufgaben"
     */
    String[] options = {"Anzahl der Begrüssungen", "Fakultät (rek)", "Fakultät (it)", "Bakterien (rek)", "Bakterien (it)", "Hasen (rek)", "Hasen (it)"};
    c = new JComboBox<>(options);
    c.setBounds(50, 35, 200, 25);
    c.addActionListener(this);

    /*
     * Here you enter your base number
     */
    t1 = new JTextField();
    t1.setBounds(50, 90, 200, 25);
    p1 = new TEXT_PROMPT("Number to calculate", t1);
    /*
     *  If Enter is pressed, the calculate button is pressed
     */
    t1.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "pressEnter");
    t1.getActionMap().put("pressEnter", new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        confirm.doClick();  // Simulate button click when "Enter" is pressed
      }
    });

    /*
      Here the result will be shown
     */
    t2 = new JTextField();
    t2.setBounds(50, 140, 200, 25);
    t2.setEditable(false);
    p2 = new TEXT_PROMPT("Press 'Calculate'", t2);

    /*
     * The additional text field that's needed for some math problems
     */
    t3 = new JTextField();
    t3.setBounds(50, 105, 200, 25);
    p3 = new TEXT_PROMPT("Additional value", t3);
    t3.setVisible(false);
    /*
     *  If Enter is pressed, the calculate button is pressed
     */
    t3.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "pressEnter");
    t3.getActionMap().put("pressEnter", new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        confirm.doClick();  // Simulate button click when "Enter" is pressed
      }
    });

    /*
     * Confirmation Button
     */
    confirm = new JButton("Calculate");
    confirm.setBounds(100, 190, 100, 25);
    confirm.addActionListener(this);

    /*
     *  Error message 1
     */
    l1 = new JLabel("<html>Please enter a integer in every editable field before pressing 'Calculate'</html>", SwingConstants.CENTER);
    l1.setVisible(false);
    l1.setBounds(35,225,280,75);
    l1.setForeground(Color.RED);
    l1.setFont(UIManager.getFont("h4.font"));

    /*
     *  Error message 2
     */
    l2 = new JLabel("Number is too high");
    l2.setVisible(false);
    l2.setBounds(80,215,150,25);
    l2.setForeground(Color.RED);
    l2.setFont(UIManager.getFont("h4.font"));

    f.add(t1);
    f.add(t2);
    f.add(confirm);
    f.add(c);
    f.add(t3);
    f.add(l1);
    f.add(l2);
    f.setTitle("Aufgaben Rechner");
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.setSize(width, height);
    f.setLayout(null);
    f.setVisible(true);
    //f.getRootPane().setDefaultButton(confirm);
    JFrame.setDefaultLookAndFeelDecorated(true);

  }

  public void actionPerformed(ActionEvent e) {
    int ex = evaluateAufgabe(c.getItemAt(c.getSelectedIndex()));

    if (e.getSource() == confirm) {
      try {
        String result = "";
        String s1 = t1.getText();
        int a = Integer.parseInt(s1);
        String s2;
        int b;

        switch (ex) {
          case 1 -> result = String.valueOf(aufgaben.anzahlBegruessungen(a));
          case 2 -> result = String.valueOf(aufgaben.fak_rek(a));
          case 3 -> result = String.valueOf(aufgaben.fak_it(a));
          case 4 -> {
            s2 = t3.getText();
            b = Integer.parseInt(s2);
            result = String.valueOf(aufgaben.bak_rek(a, b));
          }
          case 5 -> {
            s2 = t3.getText();
            b = Integer.parseInt(s2);
            result = String.valueOf(aufgaben.bak_it(a, b));
          }
          case 6 -> result = String.valueOf(aufgaben.hasen_rek(a));
          case 7 -> result = String.valueOf(aufgaben.hasen_it(a));
        }
        l1.setVisible(false);
        l2.setVisible(false);
        t2.setText(result);
      } catch (NumberFormatException exc) {
        l1.setVisible(true);
      } catch (StackOverflowError exc){
        l2.setVisible(true);
      }

    } else if (e.getSource() == c) {
        if (ex == 4 || ex == 5) {
        t1.setBounds(50, 70, 200, 25);
        t3.setVisible(true);
      } else {
        t1.setBounds(50, 90, 200, 25);
        t3.setVisible(false);
      }
    }
  }

  public static int evaluateAufgabe(String aufgabe) {
    switch (aufgabe) {
      case "Anzahl der Begrüssungen" -> {
        return 1;
      }
      case "Fakultät (rek)" -> {
        return 2;
      }
      case "Fakultät (it)" -> {
        return 3;
      }
      case "Bakterien (rek)" -> {
        return 4;
      }
      case "Bakterien (it)" -> {
        return 5;
      }
      case "Hasen (rek)" -> {
        return 6;
      }
      case  "Hasen (it)" -> {
        return 7;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    new GUI(300, 300);
  }
}
