import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CalculatorApp implements Calculation{
    private boolean isDecimal = false;
    private String sign;
    private double toBeCalculate;
    private JButton percent;
    private JButton squareRoot;
    private JButton x2Button;
    private JButton oneByX;
    private JButton ceButton;
    private JButton cButton;
    private JButton arrowButton;
    private JButton divide;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton multiple;
    private JButton a4Button1;
    private JButton a5Button;
    private JButton a6Button;
    private JButton minus;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton plus;
    private JButton plusMinus;
    private JButton a0Button;
    private JButton dot;
    private JButton equalRes;
    private JPanel Calculator;
    private JTextField textField1;
    private JLabel result;

    public CalculatorApp() {
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+"0");
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+"1");
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+"2");
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+"3");
            }
        });
        a4Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+"4");
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+"5");
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+"6");
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+"7");
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+"8");
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+"9");
            }
        });
        dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isDecimal) {
                    textField1.setText(textField1.getText() + ".");
                    isDecimal = true;
                }
            }
        });


        ceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
            }
        });
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                result.setText("");
            }
        });
        plusMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String val = textField1.getText();
                if(! val.contains("-")){
                    textField1.setText("-"+val);
                }else{
                    try {
                        textField1.setText(val.split("-")[1]);
                    }catch (Exception exception){
                        textField1.setText("");
                    }
                }
            }
        });
        arrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().length() > 0){
                    StringBuilder builder = new StringBuilder(textField1.getText());
                    textField1.setText(builder.deleteCharAt(textField1.getText().length() - 1).toString());
                }
            }
        });
        equalRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().length() > 0){

                    double b = Double.parseDouble(textField1.getText());
                    switch (sign){
                        case "+":
                            add(toBeCalculate,b);
                            break;
                        case "-":
                            minus(toBeCalculate,b);
                            break;
                        case "*":
                            multiply(toBeCalculate,b);
                            break;
                        case "/":
                            divide(toBeCalculate,b);
                            break;
                        default:
                            break;
                    }
                }
            }
        });
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sign = "/";
                if(textField1.getText().length() > 0) {
                    storeVal(sign);
                }
            }
        });
        multiple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sign = "*";
                if(textField1.getText().length() > 0) {
                    storeVal(sign);
                }
            }
        });
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sign = "-";
                if(textField1.getText().length() > 0) {
                    storeVal(sign);
                }
            }
        });
       plus.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               sign = "+";
               if(textField1.getText().length() > 0) {
                   storeVal(sign);
               }
           }
       });
       percent.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(result.getText().length() > 0 && textField1.getText().length()>0){
                   toBeCalculate = Double.parseDouble(textField1.getText());
                   setPercent(Double.parseDouble(result.getText().split(" ")[0]),toBeCalculate);
               }
           }
       });
       squareRoot.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               toBeCalculate = Double.parseDouble(textField1.getText());
               setSquareRoot(toBeCalculate);
           }
       });
       x2Button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(textField1.getText().length() > 0){
                   toBeCalculate = Double.parseDouble(textField1.getText());
                    setX2Button(toBeCalculate);
               }
           }
       });
       oneByX.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               toBeCalculate = Double.parseDouble(textField1.getText());
               setOneByX(toBeCalculate);
           }
       });
    }
    private void setOneByX(double a){
        textField1.setText(Double.toString(1/a));
    }
    private void setX2Button(double a){
        textField1.setText(Double.toString(a*=a));
    }
    private void setSquareRoot(double a){
        textField1.setText(Double.toString(Math.sqrt(a)));
    }
    private void setPercent(double a ,double b){
        switch (sign){
            case "+":
                add((a*b)/100,a);
                break;
            case "-":
                minus((a*b)/100,a);
                break;
            case "*":
                multiply((a*b)/100,a);
                break;
            case "/":
                divide((a*b)/100,a);
                break;
        }
    }
    private void storeVal(String sign){
        String value = textField1.getText();
        toBeCalculate = Double.parseDouble(value);
        result.setText(value + " " + sign);
        textField1.setText("");
    }
    public static void main(String[] args) {
        System.out.println("Calculator running...");
        JFrame frame = new JFrame("CalculatorApp");
        frame.setContentPane(new CalculatorApp().Calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void add(double a ,double b) {
        setResult(a+b);
    }

    @Override
    public void multiply(double a ,double b) {
        setResult(a*b);
    }

    @Override
    public void divide(double a ,double b) {
        try {
            setResult(a/b);
        }catch (ArithmeticException exception){
            textField1.setText("Error...");
        }

    }

    @Override
    public void minus(double a ,double b) {
        setResult(a-b);
    }
    private void setResult(double res){
        textField1.setText(res+"");
        result.setText("");
    }
}
