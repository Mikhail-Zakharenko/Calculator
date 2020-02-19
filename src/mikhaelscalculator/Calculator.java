package mikhaelscalculator;

public class Calculator extends javax.swing.JFrame {

    private final int digit;// размер числа на экране
    private int action; //порядковый номер выражения
    private boolean actionExist; //нажатие кнопки действия даст true, 
    //чтобы избежать повторного нажатия одной и той же кнопки действия
    private double firstNumber;//число один
    private double secondNumber;//число два
    private double result;// результат действия
    private boolean actionExistEquals;//нажатие кнопки =, чтобы избежать повторного нажатия
    private double memoryValue;//значение переменной сохраненной в памяти

    public Calculator() {

        digit = 17;
        initComponents();
        screen.setText("0");
    }

    /**
     * метод нажатия цифровой кнопки
     */
    private void pushNumberButton(String num) {
        if (actionExistEquals == true) {
            screen.setText("");
        }

        if (screen.getText().equals("0") || actionExist == true) {
            screen.setText("");
        }

        String scr = screen.getText();

        if (scr.length() < digit) {
            screen.setText(scr + num);
        }
        actionExist = false;
        actionExistEquals = false;

    }

    /**
     * вывод числа на экран без запятой или с запятой в зависимости от того,
     * какого типа число (int или double)
     */
    private String setOptimalNumberScreen() {

        String text = null;
        if (result % 1 == 0) {
            text = String.valueOf((int) result);

        } else {
            text = String.valueOf(result);

        }
        return text;
    }

    /**
     * метод извлечение подстроки с числом без указания действия из строки
     * вспомогательного экрана
     */
    private String toExtractNumberFromHelpScreen() {
        String stringHelpScreen = helpScreen.getText();

        StringBuffer sb = new StringBuffer(stringHelpScreen);
        sb.deleteCharAt(sb.length() - 1);
        stringHelpScreen = new String(sb);

        return stringHelpScreen;
    }

    /**
     * выполняет арифметические действия в зависимости от нажатой кнопки +,-,*,/
     * (action)
     */
    private double actionResult() {

        String stringHelpScreen = this.toExtractNumberFromHelpScreen();

        String stringMainScreen = screen.getText();

        firstNumber = new Double(stringHelpScreen);
        secondNumber = new Double(stringMainScreen);

        switch (action) {
            case 1:
                result = firstNumber + secondNumber;

                break;

            case 2:
                result = firstNumber - secondNumber;

                break;

            case 3:

                result = firstNumber * secondNumber;
                break;

            case 4:
                result = firstNumber / secondNumber;

                break;
        }
        return result;

    }

    /**
     * Метод описывающий порядок выполнения действия после нажатия кнопки
     * арифметического знака +,-,*,/
     */
    private void actionPerformed(String ariphmeticSighn, int... numAction) {

        if (action == numAction[0] || action == numAction[1] || action == numAction[2]) {
            /**
             * блок работает , если перед этим было нажато другое действие,
             * оличное от ariphmeticSighn
             */

            if (actionExist == false) {
                /**
                 * блок раотает, если перед этим было действие, отличное от
                 * ariphmeticSighn но после были нажаты цифры
                 */
                this.actionResult();

                String scr = this.setOptimalNumberScreen();

                helpScreen.setText(scr + ariphmeticSighn);
                actionExist = true;
            } else {
                /**
                 * блок работает, если после действия, отличного от
                 * ariphmeticSighn был нажат ariphmeticSighn, т.е. предыдущее
                 * нажатое действие нужно изменить (ошибочное нажатие действия,
                 * отличного от ariphmeticSighn);
                 */
                if (actionExist == true) {

                    String hscr = this.toExtractNumberFromHelpScreen();
                    helpScreen.setText(hscr + ariphmeticSighn);
                }
            }
        }
        action = numAction[3];

        if (helpScreen.getText().isEmpty()) {
            /**
             * работает блок если вспомогательный экран пустой
             */
            String scr = screen.getText();
            helpScreen.setText(scr + ariphmeticSighn);
            actionExist = true;
        }
        /**
         * работает блок если вспомогательный и основной экраны заполнены
         */
        if (actionExist == false) {

            this.actionResult();

            helpScreen.setText(this.setOptimalNumberScreen() + ariphmeticSighn);
            screen.setText(this.setOptimalNumberScreen());
            actionExist = true;
        }
        actionExistEquals = false;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        screen = new javax.swing.JLabel();
        MC = new javax.swing.JButton();
        MR = new javax.swing.JButton();
        MS = new javax.swing.JButton();
        Mplus = new javax.swing.JButton();
        Mminus = new javax.swing.JButton();
        backspace = new javax.swing.JButton();
        CE = new javax.swing.JButton();
        C = new javax.swing.JButton();
        ChangeSign = new javax.swing.JButton();
        sqrt = new javax.swing.JButton();
        n7 = new javax.swing.JButton();
        n8 = new javax.swing.JButton();
        n9 = new javax.swing.JButton();
        divide = new javax.swing.JButton();
        percent = new javax.swing.JButton();
        n4 = new javax.swing.JButton();
        n5 = new javax.swing.JButton();
        n6 = new javax.swing.JButton();
        multiplication = new javax.swing.JButton();
        inverce = new javax.swing.JButton();
        n1 = new javax.swing.JButton();
        n2 = new javax.swing.JButton();
        n3 = new javax.swing.JButton();
        minus = new javax.swing.JButton();
        point = new javax.swing.JButton();
        plus = new javax.swing.JButton();
        equal = new javax.swing.JButton();
        n0 = new javax.swing.JButton();
        helpScreen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        memory = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setLocation(new java.awt.Point(550, 170));
        setMaximumSize(new java.awt.Dimension(250, 343));
        setMinimumSize(new java.awt.Dimension(240, 343));
        setPreferredSize(new java.awt.Dimension(243, 370));

        screen.setBackground(new java.awt.Color(0, 51, 51));
        screen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        screen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        screen.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        MC.setBackground(new java.awt.Color(153, 153, 153));
        MC.setText("MC");
        MC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MC.setName("MC"); // NOI18N
        MC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MCActionPerformed(evt);
            }
        });

        MR.setBackground(new java.awt.Color(153, 153, 153));
        MR.setText("MR");
        MR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MR.setName("MC"); // NOI18N
        MR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MRActionPerformed(evt);
            }
        });

        MS.setBackground(new java.awt.Color(153, 153, 153));
        MS.setText("MS");
        MS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MS.setName("MC"); // NOI18N
        MS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSActionPerformed(evt);
            }
        });

        Mplus.setBackground(new java.awt.Color(153, 153, 153));
        Mplus.setText("M+");
        Mplus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Mplus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Mplus.setName("MC"); // NOI18N
        Mplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MplusActionPerformed(evt);
            }
        });

        Mminus.setBackground(new java.awt.Color(153, 153, 153));
        Mminus.setText("M-");
        Mminus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Mminus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Mminus.setName("MC"); // NOI18N
        Mminus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MminusActionPerformed(evt);
            }
        });

        backspace.setBackground(new java.awt.Color(153, 153, 153));
        backspace.setForeground(new java.awt.Color(255, 255, 255));
        backspace.setIcon(new javax.swing.ImageIcon("D:\\EPAMWORKSPASE\\MikhaelsCalculator\\Icons\\backspaceButton1.png")); // NOI18N
        backspace.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backspace.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backspace.setName("MC"); // NOI18N
        backspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backspaceActionPerformed(evt);
            }
        });

        CE.setBackground(new java.awt.Color(153, 153, 153));
        CE.setText("CE");
        CE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CE.setName("MC"); // NOI18N
        CE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CEActionPerformed(evt);
            }
        });

        C.setBackground(new java.awt.Color(153, 153, 153));
        C.setText("C");
        C.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        C.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        C.setName("MC"); // NOI18N
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });

        ChangeSign.setBackground(new java.awt.Color(153, 153, 153));
        ChangeSign.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ChangeSign.setText("+/-");
        ChangeSign.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ChangeSign.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ChangeSign.setName("MC"); // NOI18N
        ChangeSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeSignActionPerformed(evt);
            }
        });

        sqrt.setBackground(new java.awt.Color(153, 153, 153));
        sqrt.setIcon(new javax.swing.ImageIcon("D:\\EPAMWORKSPASE\\MikhaelsCalculator\\Icons\\квадратный_корень_1.png")); // NOI18N
        sqrt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sqrt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sqrt.setName("MC"); // NOI18N
        sqrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqrtActionPerformed(evt);
            }
        });

        n7.setBackground(new java.awt.Color(153, 153, 153));
        n7.setText("7");
        n7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        n7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        n7.setName("MC"); // NOI18N
        n7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n7ActionPerformed(evt);
            }
        });

        n8.setBackground(new java.awt.Color(153, 153, 153));
        n8.setText("8");
        n8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        n8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        n8.setName("MC"); // NOI18N
        n8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n8ActionPerformed(evt);
            }
        });

        n9.setBackground(new java.awt.Color(153, 153, 153));
        n9.setText("9");
        n9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        n9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        n9.setName("MC"); // NOI18N
        n9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n9ActionPerformed(evt);
            }
        });

        divide.setBackground(new java.awt.Color(153, 153, 153));
        divide.setText("/");
        divide.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        divide.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        divide.setName("MC"); // NOI18N
        divide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divideActionPerformed(evt);
            }
        });

        percent.setBackground(new java.awt.Color(153, 153, 153));
        percent.setText("%");
        percent.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        percent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        percent.setName("MC"); // NOI18N
        percent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percentActionPerformed(evt);
            }
        });

        n4.setBackground(new java.awt.Color(153, 153, 153));
        n4.setText("4");
        n4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        n4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        n4.setName("MC"); // NOI18N
        n4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n4ActionPerformed(evt);
            }
        });

        n5.setBackground(new java.awt.Color(153, 153, 153));
        n5.setText("5");
        n5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        n5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        n5.setName("MC"); // NOI18N
        n5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n5ActionPerformed(evt);
            }
        });

        n6.setBackground(new java.awt.Color(153, 153, 153));
        n6.setText("6");
        n6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        n6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        n6.setName("MC"); // NOI18N
        n6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n6ActionPerformed(evt);
            }
        });

        multiplication.setBackground(new java.awt.Color(153, 153, 153));
        multiplication.setText("*");
        multiplication.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        multiplication.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        multiplication.setName("MC"); // NOI18N
        multiplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiplicationActionPerformed(evt);
            }
        });

        inverce.setBackground(new java.awt.Color(153, 153, 153));
        inverce.setText("1/x");
        inverce.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inverce.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        inverce.setName("MC"); // NOI18N
        inverce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inverceActionPerformed(evt);
            }
        });

        n1.setBackground(new java.awt.Color(153, 153, 153));
        n1.setText("1");
        n1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        n1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        n1.setName("MC"); // NOI18N
        n1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n1ActionPerformed(evt);
            }
        });

        n2.setBackground(new java.awt.Color(153, 153, 153));
        n2.setText("2");
        n2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        n2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        n2.setName("MC"); // NOI18N
        n2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n2ActionPerformed(evt);
            }
        });

        n3.setBackground(new java.awt.Color(153, 153, 153));
        n3.setText("3");
        n3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        n3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        n3.setName("MC"); // NOI18N
        n3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n3ActionPerformed(evt);
            }
        });

        minus.setBackground(new java.awt.Color(153, 153, 153));
        minus.setText("-");
        minus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        minus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        minus.setName("MC"); // NOI18N
        minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusActionPerformed(evt);
            }
        });

        point.setBackground(new java.awt.Color(153, 153, 153));
        point.setText(",");
        point.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        point.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        point.setName("MC"); // NOI18N
        point.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pointActionPerformed(evt);
            }
        });

        plus.setBackground(new java.awt.Color(153, 153, 153));
        plus.setText("+");
        plus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        plus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        plus.setName("MC"); // NOI18N
        plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusActionPerformed(evt);
            }
        });

        equal.setBackground(new java.awt.Color(153, 153, 153));
        equal.setText("=");
        equal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        equal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        equal.setName("MC"); // NOI18N
        equal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalActionPerformed(evt);
            }
        });

        n0.setBackground(new java.awt.Color(153, 153, 153));
        n0.setText("0");
        n0.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        n0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        n0.setName("MC"); // NOI18N
        n0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n0ActionPerformed(evt);
            }
        });

        helpScreen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        helpScreen.setForeground(new java.awt.Color(255, 51, 51));
        helpScreen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        helpScreen.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), null));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Mikhael`s Calculator");

        memory.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        memory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        memory.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), null));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(MC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(MR, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(MS, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Mplus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Mminus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(backspace, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CE, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ChangeSign, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sqrt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(n7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(n8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(n9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(divide, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(percent, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(n4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(n5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(n6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(multiplication, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inverce, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(n1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(n2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(n3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(minus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(n0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(point, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(plus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(equal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(screen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(memory, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(helpScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(helpScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(memory, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screen, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MR, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MS, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mplus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mminus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backspace, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChangeSign, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sqrt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(divide, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percent, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(multiplication, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inverce, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(n1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(n2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(n3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(n0, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(point, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(equal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void n0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n0ActionPerformed

        this.pushNumberButton("0");
    }//GEN-LAST:event_n0ActionPerformed

    private void n1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n1ActionPerformed

        this.pushNumberButton("1");
    }//GEN-LAST:event_n1ActionPerformed

    private void n2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n2ActionPerformed
        this.pushNumberButton("2");
    }//GEN-LAST:event_n2ActionPerformed

    private void n3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n3ActionPerformed
        this.pushNumberButton("3");
    }//GEN-LAST:event_n3ActionPerformed

    private void n4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n4ActionPerformed
        this.pushNumberButton("4");
    }//GEN-LAST:event_n4ActionPerformed

    private void n5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n5ActionPerformed
        this.pushNumberButton("5");
    }//GEN-LAST:event_n5ActionPerformed

    private void n6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n6ActionPerformed
        this.pushNumberButton("6");
    }//GEN-LAST:event_n6ActionPerformed

    private void n7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n7ActionPerformed
        this.pushNumberButton("7");
    }//GEN-LAST:event_n7ActionPerformed

    private void n8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n8ActionPerformed
        this.pushNumberButton("8");
    }//GEN-LAST:event_n8ActionPerformed

    private void n9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n9ActionPerformed
        this.pushNumberButton("9");
    }//GEN-LAST:event_n9ActionPerformed

    private void pointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pointActionPerformed

        String scr = screen.getText();

        if (!scr.contains(".")) {

            screen.setText(screen.getText() + ".");
        }

    }//GEN-LAST:event_pointActionPerformed

    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
        screen.setText("0");
        helpScreen.setText("");
        action = 0;
        actionExist = false;
        actionExistEquals = false;

    }//GEN-LAST:event_CActionPerformed

    private void CEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CEActionPerformed
        if (actionExist == false) {
            screen.setText("0");
        }
    }//GEN-LAST:event_CEActionPerformed

    private void backspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backspaceActionPerformed

        if (actionExistEquals == false) {
            String scr = screen.getText();

            Double scrrenNum = new Double(scr);

            if (scrrenNum < 0) {
                if (scr.length() > 2) {
                    StringBuffer back = new StringBuffer(scr);
                    back.deleteCharAt(back.length() - 1);
                    screen.setText(new String(back));
                } else {
                    screen.setText("0");
                }
            } else {
                if (scr.length() > 1) {
                    StringBuffer back = new StringBuffer(scr);
                    back.deleteCharAt(back.length() - 1);
                    screen.setText(new String(back));
                } else {
                    screen.setText("0");
                }
            }
        }
        actionExist = false;
    }//GEN-LAST:event_backspaceActionPerformed

    private void plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusActionPerformed

        this.actionPerformed("+", 2, 3, 4, 1);


    }//GEN-LAST:event_plusActionPerformed

    private void minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusActionPerformed
        this.actionPerformed("-", 1, 3, 4, 2);

    }//GEN-LAST:event_minusActionPerformed

    private void multiplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiplicationActionPerformed
        this.actionPerformed("*", 1, 2, 4, 3);

    }//GEN-LAST:event_multiplicationActionPerformed

    private void divideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divideActionPerformed

        this.actionPerformed("/", 1, 3, 2, 4);

    }//GEN-LAST:event_divideActionPerformed

    private void equalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalActionPerformed

        try {
            if (actionExistEquals == false && actionExist != true) {
                this.actionResult();
                helpScreen.setText("");
                screen.setText(this.setOptimalNumberScreen());

            } else {
                if (actionExistEquals == false && actionExist == true) {

                    screen.setText(this.toExtractNumberFromHelpScreen());
                    helpScreen.setText("");
                }
            }
            actionExistEquals = true;
            action = 0;
            result = 0;
            firstNumber = 0;
            secondNumber = 0;
        } catch (StringIndexOutOfBoundsException ex) {
            actionExistEquals = true;
            action = 0;
            result = 0;
            firstNumber = 0;
            secondNumber = 0;
        }
    }//GEN-LAST:event_equalActionPerformed

    private void ChangeSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeSignActionPerformed
        String scr = screen.getText();

        try {
            if (scr.contains(".")) {

                Double num = new Double(scr);

                double changeNum = num;

                if (changeNum > 0) {
                    scr = "-" + Math.abs(changeNum);
                    screen.setText(scr);

                } else {
                    if (changeNum < 0) {
                        scr = "" + Math.abs(changeNum);
                        screen.setText(scr);
                    } else {
                        screen.setText("0");
                    }
                }
            } else {
                Integer num = new Integer(scr);
                int changeNum = num;
                if (changeNum > 0) {
                    scr = "-" + Math.abs(changeNum);
                    screen.setText(scr);

                } else {
                    if (changeNum < 0) {
                        scr = "" + Math.abs(changeNum);
                        screen.setText(scr);
                    } else {
                        screen.setText("0");
                    }
                }

            }
        } catch (NumberFormatException ex) {

        }
        actionExist = false;
    }//GEN-LAST:event_ChangeSignActionPerformed

    private void sqrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqrtActionPerformed
        if (actionExist == false) {
            Double dscreen = new Double(screen.getText());

            if (dscreen >= 0) {
                result = Math.sqrt(dscreen);
                screen.setText(this.setOptimalNumberScreen());
            }

        }
    }//GEN-LAST:event_sqrtActionPerformed

    private void percentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percentActionPerformed

        if (actionExist == false) {
            Double dscreen = new Double(screen.getText());
            Double dhelpScreen = new Double(this.toExtractNumberFromHelpScreen());
            /**
             * Нужно взять dscreen % от числа dhelpScreen и вставить результат в
             * основной экран;
             */
            result = dhelpScreen * dscreen / 100;
            screen.setText(this.setOptimalNumberScreen());
        }
    }//GEN-LAST:event_percentActionPerformed

    private void inverceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inverceActionPerformed

        if (actionExist == false) {
            Double dscreen = new Double(screen.getText());

            if (dscreen != 0) {
                result = 1 / dscreen;
                screen.setText(this.setOptimalNumberScreen());
            }
        }

    }//GEN-LAST:event_inverceActionPerformed

    private void MSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSActionPerformed
        /**
         * MS - Memory Save: Запоминание числа на основном экране в память;
         *
         */

        memoryValue = new Double(screen.getText());
        memory.setText("M");

    }//GEN-LAST:event_MSActionPerformed

    private void MCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MCActionPerformed
        /**
         * Memory Clear Удаление из памяти калькулятора сохраненного числа;
         */

        memoryValue = 0;
        memory.setText("");
    }//GEN-LAST:event_MCActionPerformed

    private void MRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MRActionPerformed
        /**
         * Memory Read: Чтение из памяти калькулятора значения и вывод его на
         * основной экран
         */

        if (memoryValue % 1 == 0) {
            screen.setText(String.valueOf((int) memoryValue));
        } else {
            screen.setText(String.valueOf(memoryValue));
        }

    }//GEN-LAST:event_MRActionPerformed

    private void MplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MplusActionPerformed
        /**
         * M+: Прибавляет число на основном экране к числу в памяти и сумму
         * сохраняет в памяти;
         */
        memoryValue += new Double(screen.getText());
        memory.setText("M");
    }//GEN-LAST:event_MplusActionPerformed

    private void MminusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MminusActionPerformed
        /**
         * M-: Отнимает число на основном экране от числа в памяти и разность
         * сохраняет в памяти;
         */
        memoryValue -= new Double(screen.getText());
        memory.setText("M");
    }//GEN-LAST:event_MminusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculator.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculator.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculator.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculator.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton C;
    private javax.swing.JButton CE;
    private javax.swing.JButton ChangeSign;
    private javax.swing.JButton MC;
    private javax.swing.JButton MR;
    private javax.swing.JButton MS;
    private javax.swing.JButton Mminus;
    private javax.swing.JButton Mplus;
    private javax.swing.JButton backspace;
    private javax.swing.JButton divide;
    private javax.swing.JButton equal;
    private javax.swing.JLabel helpScreen;
    private javax.swing.JButton inverce;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel memory;
    private javax.swing.JButton minus;
    private javax.swing.JButton multiplication;
    private javax.swing.JButton n0;
    private javax.swing.JButton n1;
    private javax.swing.JButton n2;
    private javax.swing.JButton n3;
    private javax.swing.JButton n4;
    private javax.swing.JButton n5;
    private javax.swing.JButton n6;
    private javax.swing.JButton n7;
    private javax.swing.JButton n8;
    private javax.swing.JButton n9;
    private javax.swing.JButton percent;
    private javax.swing.JButton plus;
    private javax.swing.JButton point;
    private javax.swing.JLabel screen;
    private javax.swing.JButton sqrt;
    // End of variables declaration//GEN-END:variables
}
