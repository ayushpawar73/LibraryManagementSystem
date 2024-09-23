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
import java.sql.ResultSet;
import java.sql.SQLException;

public class Loginlib extends JFrame implements ActionListener {

    JLabel title;
    JTextField usernametextfield;
    JPasswordField passwordField;

    JButton login;
    Loginlib(){
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
        label.setBounds(600,100,400,440);


        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Image icon/pink.jpg"));
        Image i5=i4.getImage().getScaledInstance(1550,520,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel labe=new JLabel(i6);
        labe.setBounds(-0,1,1550,80);





        JLabel head=new JLabel("Library Management System");
        head.setBounds(320,0,1000,80);
        head.setFont(new Font("RALEWAY",Font.BOLD,60));
        head.setForeground(Color.DARK_GRAY);

        add(head);


        title = new JLabel("Login");
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

        passwordField=new JPasswordField("password");
        passwordField.setBounds(650,280,300,40);
        passwordField.setFont(new Font("serif",Font.BOLD,20));
        passwordField.setBackground(Color.white);
        passwordField.setBorder(new LineBorder(Color.black,3));
        add(passwordField);


        login=new JButton("Login");
        login.setBounds(650,380,300,40);
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
        if(e.getSource() == login){
            boolean isAuthenticated = false;
            do{
                String Suser=usernametextfield.getText();
                String Spasswords=new String(passwordField.getPassword());
                isAuthenticated=Authenticatedadmin(Suser,Spasswords);

                if (Authenticatedadmin(Suser, Spasswords)) {
                    Main obj=new Main();
                    JOptionPane.showMessageDialog(null,"Login sucess");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Username and password do not match");
                    break;
                }

            }
            while (!isAuthenticated);
        }

    }

    private boolean Authenticatedadmin(String Suser, String Spasswords) {

        try {
            Connect ch=new Connect();
            PreparedStatement ps = ch.co.prepareStatement("select * from login where Suser=? and Spasswords=?");
            ps.setString(1,Suser);
            ps.setString(2,Spasswords);
            ResultSet rs = ps.executeQuery();

            return rs.next();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        new Loginlib();
    }


}
