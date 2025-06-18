
import java.awt.*;
import java.awt.event.*;

public class Additionframe extends Frame implements ActionListener
{
    Panel pnlmain, pnl1;
    Label lblmain, lblmsg1, lblmsg2;
    Button btnans;
    TextField txtin1, txtin2, txtout;
    
    Additionframe()
    {
        setLayout(null);
        setSize(800, 600);
        setBackground(new Color(128, 144, 118));
        setLocationRelativeTo(null);
        setTitle("ADDITION");
        
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                Additionframe fr = (Additionframe)(e.getSource());
                ConfirmDialogAdd cd = new ConfirmDialogAdd(fr);
            }
            
        });
        
        addPanels();
        addLabels();
        addTexts();
        addButtons();
        
        setVisible(true);
    }
    
    final void addPanels()
    {
        pnlmain = new Panel();
        pnlmain.setLayout(null);
        pnlmain.setBounds(70, 70, 660, 100);
        pnlmain.setBackground(new Color(40, 65, 57)); 
        add(pnlmain);
        
        pnl1 = new Panel();
        pnl1.setLayout(null);
        pnl1.setBounds(70, 230, 660, 300);
        pnl1.setBackground(new Color(248, 231, 148));
        add(pnl1);
    }
    
    final void addLabels()
    {
        lblmain = new Label("ADDITION");
        lblmain.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        lblmain.setBounds(0, 0, 660, 100);
        lblmain.setAlignment(Label.CENTER);
        lblmain.setForeground(new Color(248, 231, 148));
        pnlmain.add(lblmain);
        
        lblmsg1 = new Label("Enter Number :");
        lblmsg1.setAlignment(Label.LEFT);
        lblmsg1.setBounds(40, 10, 230, 70);
        lblmsg1.setFont(new Font("SERIF", Font.BOLD, 25));
        lblmsg1.setForeground(new Color(96, 108, 56));
        pnl1.add(lblmsg1);
        
        
        
        lblmsg2 = new Label("Enter Number :");
        lblmsg2.setAlignment(Label.LEFT);
        lblmsg2.setBounds(400, 10, 260, 70);
        lblmsg2.setFont(new Font("SERIF", Font.BOLD, 25));
        lblmsg2.setForeground(new Color(96, 108, 56));
        pnl1.add(lblmsg2);
    }
    
    final void addTexts()
    {
        MyKeyListenerAdd mkl = new MyKeyListenerAdd();
        
        txtin1 = new TextField();
        txtin1.setEditable(true);
        txtin1.setBackground(new Color(128, 144, 118));
        txtin1.setBounds(40, 80, 200, 70);
        txtin1.setFont(new Font("Tahoma", Font.BOLD, 20));
        txtin1.setForeground(new Color(248, 231, 148));
        pnl1.add(txtin1);
        
        txtin2 = new TextField();
        txtin2.setEditable(true);
        txtin2.setBackground(new Color(128, 144, 118));
        txtin2.setBounds(400, 80, 200, 70);
        txtin2.setFont(new Font("Tahoma", Font.BOLD, 20));
        txtin2.setForeground(new Color(248, 231, 148));
        pnl1.add(txtin2);
        
        txtin1.addKeyListener(mkl);
        txtin2.addKeyListener(mkl);
        
        txtout = new TextField();
        txtout.setEditable(false);
        txtout.setBackground(new Color(40, 65, 57));
        txtout.setBounds(210, 190, 390, 70);
        txtout.setFont(new Font("Tahoma", Font.BOLD, 20));
        txtout.setForeground(new Color(248, 231, 148));
        pnl1.add(txtout);
    }
    
    final void addButtons()
    {
        btnans = new Button("Calculate");
        btnans.setBackground(new Color(130, 50, 5));
        btnans.setBounds(40, 200, 150, 50);
        btnans.setFont(new Font("SERIF", Font.BOLD, 30));
        btnans.setForeground(new Color(243, 230, 185));
        pnl1.add(btnans);
        
        btnans.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button btn = (Button)(e.getSource());
        
        if(!txtin1.getText().equals("") && !txtin2.getText().equals(""))
        {
            String s = txtin1.getText().trim();
            int n1 = Integer.parseInt(s);
            
            s = txtin2.getText().trim();
            int n2 = Integer.parseInt(s);
            
            txtout.setText((n1+n2)+"");
        }
        
        if(txtin1.getText().equals(""))
        {
            ConfirmDialogAdd cd1 = new ConfirmDialogAdd(this, "Please Enter Number in TextField1");
            txtin1.requestFocusInWindow();
        }
        if(txtin2.getText().equals(""))
        {
            ConfirmDialogAdd cd2 = new ConfirmDialogAdd(this, "Please Enter Number in TextField2");
            txtin2.requestFocusInWindow();
        }
        
    }
    
 /*   public static void main(String[] args)
    {
        new Additionframe();
    }*/
}

class MyKeyListenerAdd extends KeyAdapter
{

    @Override
    public void keyTyped(KeyEvent e)
    {
        char ch;
        ch = e.getKeyChar();
        if(Character.isDigit(ch) == false)
        {
            e.consume();
        }
    }
    
}

class ConfirmDialogAdd extends Dialog implements ActionListener
{
    Additionframe fr;
    Label lblmain;
    Button btnyes, btnno;
    
    ConfirmDialogAdd(Additionframe ref)
    {
        super(null, true);
        this.setLayout(null);
        this.setBounds(300, 150, 300, 120);
        this.setLocationRelativeTo(ref);
        this.setTitle("Confirm Window");
        
        fr = ref;
        lblmain = new Label("Are you sure you want to close??");
        lblmain.setBounds(50, 40, 250, 20);
        add(lblmain);
        
        btnyes = new Button("Yes");
        btnyes.setBounds(70, 70, 80, 30);
        
        btnno = new Button("No");
        btnno.setBounds(180, 70, 80, 30);
        
        btnyes.addActionListener(this);
        btnno.addActionListener(this);
        
        add(btnyes);
        add(btnno);
        
        this.setVisible(true);
    }
    
    ConfirmDialogAdd(Additionframe ref, String str)
    {
        super(null, true);
        this.setLayout(null);
        this.setBounds(300, 150, 300, 120);
        this.setLocationRelativeTo(ref);
        this.setTitle("Confirm Window");
        
        fr = ref;
        lblmain = new Label(str);
        lblmain.setBounds(50, 40, 250, 20);
        add(lblmain);
        
        this.addWindowListener(new WindowAdapter()
                {
                    @Override
                    public void windowClosing(WindowEvent e)
                    {
                        ConfirmDialogAdd cd = (ConfirmDialogAdd)(e.getSource());
                        cd.dispose();
                    }
                    
                });
        
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button choice = (Button)(e.getSource());
        if( choice.getLabel().equals("Yes") )
        {
            fr.dispose();
            new MyFrame1();
        }
        dispose();
    }
    
}