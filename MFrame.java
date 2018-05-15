
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MFrame extends JFrame {
    private JLabel jlb = new JLabel("", JLabel.RIGHT);
    private JButton[][] jbtn = new JButton[4][5];
    private JPanel jpanN = new JPanel(new GridLayout(1, 1, 3, 3));
    private JPanel jpanC = new JPanel(new GridLayout(4, 5, 3, 3));
    Container cp;
    private int op = -1;
    private double v1,v2;

    public MFrame() {
        init();
    }

    public void init() {
        this.setBounds(400, 300, 400, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jlb.setFont(new Font(null, Font.BOLD, 40));
        cp = getContentPane();
        cp.add(jpanN, BorderLayout.NORTH);
        cp.add(jpanC, BorderLayout.CENTER);
        jpanN.add(jlb);

        jbtn[0][0] = new JButton("7");
        jbtn[1][0] = new JButton("8");
        jbtn[2][0] = new JButton("9");
        jbtn[3][0] = new JButton("/");
        jbtn[0][1] = new JButton("AC");
        jbtn[1][1] = new JButton("4");
        jbtn[2][1] = new JButton("5");
        jbtn[3][1] = new JButton("6");
        jbtn[0][2] = new JButton("*");
        jbtn[1][2] = new JButton("SQRT");
        jbtn[2][2] = new JButton("1");
        jbtn[3][2] = new JButton("2");
        jbtn[0][3] = new JButton("3");
        jbtn[1][3] = new JButton("-");
        jbtn[2][3] = new JButton("PI");
        jbtn[3][3] = new JButton("0");
        jbtn[0][4] = new JButton(".");
        jbtn[1][4] = new JButton("+");
        jbtn[2][4] = new JButton("=");
        jbtn[3][4] = new JButton("EXIT");

        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 3; j++) {
                jpanC.add(jbtn[j][i]);
            }
        }

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {

                jbtn[j][i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton jb = (JButton) e.getSource();
                        jlb.setText(jlb.getText() + jb.getText());
                    }
                });
                jbtn[j][i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tmpBtn = (JButton) e.getSource();
                        switch (tmpBtn.getText()) {
                            case "AC":
                                jlb.setText("0");
                                op = -1;
                                break;
                            case "PI":
                                jlb.setText(Double.toString(Math.PI));
                                break;
                            case "+":
                                op = 0;
                                v1=Double.parseDouble(jlb.getText());
                                break;
                            case "=":
                                v2 = Double.parseDouble(jlb.getText());
                                double v3 = 0;
                                switch (op){
                                    case 0:
                                        v3 = v1+v2;
                                        break;


                                }
                        }
                    }
                });

            }
        }
    }
}
//計算機(有加按鍵功能)
