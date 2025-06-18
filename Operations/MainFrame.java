
import java.awt.*;
import java.awt.event.*;

class MyFrame1 extends Frame implements ActionListener
{
    Panel pnlmain, pnl1;
    Label lblmain;
    Button btnadd, btnsub;
    
    MyFrame1()
    {
        setLayout(null);
        setSize(800, 600);
        setBackground(new Color(169, 81, 240));
        setLocationRelativeTo(null);
        setTitle("Arithematic Operations");
        
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                MyFrame1 ref = (MyFrame1)(e.getSource());
                ConfirmDialog1 cd = new ConfirmDialog1(ref);
            }
            
        });
        
        addPanels();
        addLabels();
        addButtons();
        
        setVisible(true);
    }
    
    final void addPanels()
    {
        pnlmain = new Panel();
        pnlmain.setLayout(null);
        pnlmain.setBounds(70, 70, 660, 100);
        pnlmain.setBackground(new Color(216, 175, 250)); 
        add(pnlmain);
        
        pnl1 = new Panel();
        pnl1.setLayout(null);
        pnl1.setBounds(195, 230, 400, 300);
        pnl1.setBackground(new Color(216, 175, 250));
        add(pnl1);
    }
    
    final void addLabels()
    {
        lblmain = new Label("ARITHMETIC OPERATIONS");
        lblmain.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        lblmain.setBounds(0, 0, 660, 100);
        lblmain.setAlignment(Label.CENTER);
        lblmain.setForeground(new Color(60, 3, 107));
        pnlmain.add(lblmain);
    }
    
    final void addButtons()
    {
        btnadd = new Button();
        btnadd.setLabel("Addition");
        btnadd.setBounds(100, 50, 200, 70);
        btnadd.setBackground(new Color(250, 175, 186));
        btnadd.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        pnl1.add(btnadd);
        
        btnsub = new Button();
        btnsub.setLabel("Subtraction");
        btnsub.setBounds(100, 160, 200, 70);
        btnsub.setBackground(new Color(250, 175, 186));
        btnsub.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        pnl1.add(btnsub);
        
        btnadd.addActionListener(this);
        btnsub.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button btn = (Button)(e.getSource());
        
        this.dispose();
        if(btn.getLabel().equals("Addition"))
        {
            Additionframe addFrame = new Additionframe();
        }
        if(btn.getLabel().equals("Subtraction"))
        {
            Subtractionframe subFrame = new Subtractionframe();
        }
    }
    
}

class ConfirmDialog1 extends Dialog implements ActionListener
{
    MyFrame1 fr;
    Label lblmain;
    Button btnyes, btnno;
    
    ConfirmDialog1(MyFrame1 ref)
    {
        super(null, true);
        this.setLayout(null);
        this.setBounds(300, 150, 300, 120);
        this.setLocationRelativeTo(ref);
        this.setTitle("Please Confirm!!");
        
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

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button choice = (Button)(e.getSource());
        if( choice.getLabel().equals("Yes") )
        {
            fr.dispose();
        }
        dispose();
    }
    
}

public class MainFrame
{
    public static void main(String[] args)
    {
        MyFrame1 mainpage = new MyFrame1();
    }
}
