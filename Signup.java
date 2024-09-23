import javax.annotation.processing.RoundEnvironment;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;

public class Signup extends JFrame implements ActionListener {

    JLabel title;
    JTextField usernametextfield,emailtextfield;
    JPasswordField passwordField;

    JButton Signup,login;
    Signup(){
        setLayout(null);
        setSize(800,700);

        Color col=new Color(255,102,102);
        getContentPane().setBackground(col);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(600,40);
        setVisible(true);



        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Image icon/blue.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,550,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(600,100,400,550);


        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Image icon/pink.jpg"));
        Image i5=i4.getImage().getScaledInstance(1550,200,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel labe=new JLabel(i6);
        labe.setBounds(-0,1,1550,80);





        JLabel head=new JLabel("Library Management System");
        head.setBounds(320,0,1000,80);
        head.setFont(new Font("RALEWAY",Font.BOLD,60));
        head.setForeground(Color.DARK_GRAY);

        add(head);


        title = new JLabel("Sign Up");
        title.setBounds(740, 120, 200, 50);
        title.setFont(new Font("RALEWAY", Font.BOLD, 35));
        title.setForeground(Color.white);

        add(title);

        usernametextfield=new JTextField("User Name");
        usernametextfield.setBounds(650,200,300,40);
        usernametextfield.setFont(new Font("serif",Font.BOLD,20));
        usernametextfield.setBackground(Color.white);
        usernametextfield.setBorder(new LineBorder(Color.black,3));
        add(usernametextfield);

        emailtextfield=new JTextField("Email");
        emailtextfield.setBounds(650,270,300,40);
        emailtextfield.setFont(new Font("serif",Font.BOLD,20));
        emailtextfield.setBackground(Color.white);
        emailtextfield.setBorder(new LineBorder(Color.black,3));
        add(emailtextfield);


        passwordField=new JPasswordField("Email");
        passwordField.setBounds(650,340,300,40);
        passwordField.setFont(new Font("serif",Font.BOLD,20));
        passwordField.setBackground(Color.white);
        passwordField.setBorder(new LineBorder(Color.black,3));
        add(passwordField);


        Signup=new JButton("Sing Up");
        Signup.setBounds(650,410,300,40);
        Signup.setFont(new Font("serif",Font.BOLD,20));
        Signup.setBackground(Color.blue);
        Signup.setForeground(Color.white);
        Signup.addActionListener(this);
        Signup.setBorder(BorderFactory.createEmptyBorder());
//        Signup.setBorder(new LineBorder(Color.black,3));
        add(Signup);


        JLabel or=new JLabel("OR");
        or.setBounds(780,460,300,45);
        or.setFont(new Font("serif",Font.BOLD,20));
        or.setForeground(Color.white);
        add(or);


        login=new JButton("Login");
        login.setBounds(650,520,300,40);
        login.setFont(new Font("serif",Font.BOLD,20));
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        add(login);


          add(label);
          add(labe);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
           if(e.getSource()==Signup){
               String Suser=usernametextfield.getText();
               String Smails=emailtextfield.getText();
               String Spasswords=new String(passwordField.getPassword());

               try {
                   Connect obj=new Connect();
                   String query = "insert into login values(?, ?, ?)";
                   PreparedStatement ps=obj.co.prepareStatement(query);
                   ps.setString(1, Suser);
                   ps.setString(2, Smails);
                   ps.setString(3, Spasswords);
                   ps.executeUpdate();
                   setVisible(false);
               }
               catch (Exception ex){
                   System.out.println(ex);
               }
           }

           if(e.getSource()==login){
               Loginlib obj=new Loginlib();
               setVisible(false);
           }

           
    }


    public static void main(String[] args) {
           new Signup();
    }


}
