import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class Adduser extends JFrame implements ActionListener {
     JTextField addUserTextField,userNameTextField,fatherNameTextfield,courseTextField,validTextField,validTextField1;
     JButton Submit;
    Adduser(){
        setLayout(null);
        setVisible(true);
        setSize(900,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Color col=new Color(255,102,102);
        getContentPane().setBackground(col);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Image icon/pink.jpg"));
        Image i5=i4.getImage().getScaledInstance(1550,200,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel labs=new JLabel(i6);
        labs.setBounds(0,1,1550,80);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Image icon/blue.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,550,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(470,100,600,550);

        JLabel head=new JLabel("Library Management System");
        head.setBounds(340,0,1050,80);
        head.setFont(new Font("RALEWAY",Font.BOLD,60));
        head.setForeground(Color.DARK_GRAY);
        add(head);

        JLabel form=new JLabel("Add User");
        form.setBounds(620,130,300,40);
        form.setFont(new Font("RALEWAY",Font.BOLD,30));
        form.setHorizontalAlignment(SwingConstants.CENTER);
        form.setForeground(Color.black);
//        form.setBorder(new LineBorder(Color.black,2));
        form.setOpaque(true); // Set to true to make the background color visible
        form.setBackground(Color.orange);
        add(form);


        JLabel userid=new JLabel("User Id:");
        userid.setBounds(520,200,100,30);
        userid.setFont(new Font("RALEWAY",Font.BOLD,25));
        userid.setForeground(Color.white);
        add(userid);

        addUserTextField=new JTextField();
        addUserTextField.setBounds(680,200,300,30);
        addUserTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        addUserTextField.setForeground(Color.black);
        addUserTextField.setBorder(new LineBorder(Color.black,2));
        add(addUserTextField);

        JLabel username=new JLabel("UserName:");
        username.setBounds(520,250,140,30);
        username.setFont(new Font("RALEWAY",Font.BOLD,25));
        username.setForeground(Color.white);
        add(username);

        userNameTextField=new JTextField();
        userNameTextField.setBounds(680,250,300,30);
        userNameTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        userNameTextField.setForeground(Color.black);
        userNameTextField.setBorder(new LineBorder(Color.black,2));
        add(userNameTextField);

        JLabel fathername=new JLabel("FatherName:");
        fathername.setBounds(520,300,150,30);
        fathername.setFont(new Font("RALEWAY",Font.BOLD,25));
        fathername.setForeground(Color.white);
        add(fathername);

        fatherNameTextfield=new JTextField();
        fatherNameTextfield.setBounds(680,300,300,30);
        fatherNameTextfield.setFont(new Font("RALEWAY",Font.BOLD,20));
        fatherNameTextfield.setForeground(Color.black);
        fatherNameTextfield.setBorder(new LineBorder(Color.black,2));
        add(fatherNameTextfield);

        JLabel course=new JLabel("Course:");
        course.setBounds(520,350,150,30);
        course.setFont(new Font("RALEWAY",Font.BOLD,25));
        course.setForeground(Color.white);
        add(course);
        courseTextField=new JTextField();
        courseTextField.setBounds(680,350,300,30);
        courseTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        courseTextField.setForeground(Color.black);
        courseTextField.setBorder(new LineBorder(Color.black,2));
        add(courseTextField);

        JLabel valid=new JLabel("Valid Upto:");
        valid.setBounds(520,400,150,30);
        valid.setFont(new Font("RALEWAY",Font.BOLD,25));
        valid.setForeground(Color.white);
        add(valid);
        validTextField=new JTextField();
        validTextField.setBounds(680,400,120,30);
        validTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        validTextField.setForeground(Color.black);
        validTextField.setBorder(new LineBorder(Color.black,2));
        add( validTextField);


        JLabel validTo=new JLabel("To");
        validTo.setBounds(810,400,150,30);
        validTo.setFont(new Font("RALEWAY",Font.BOLD,25));
        validTo.setForeground(Color.white);
        add(validTo);

        validTextField1=new JTextField();
        validTextField1.setBounds(860,400,120,30);
        validTextField1.setFont(new Font("RALEWAY",Font.BOLD,20));
        validTextField1.setForeground(Color.black);
        validTextField1.setBorder(new LineBorder(Color.black,2));
        add( validTextField1);

        Submit=new JButton("Add");
        Submit.setBounds(700,500,150,40);
        Submit.setFont(new Font("RALEWAY",Font.BOLD,25));
        Submit.setForeground(Color.BLACK);
        Submit.setBorder(new LineBorder(Color.black,2));
        Submit.setOpaque(true);
        Submit.setBackground(Color.white);
        Submit.addActionListener(this);
        add(Submit);

        add(label);
        add(labs);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           if(e.getSource()==Submit){
               String Urollno=new String(addUserTextField.getText());
               String Username=userNameTextField.getText();
               String Fathername=fatherNameTextfield.getText();
               String  Ucourse=courseTextField.getText();
               String validupto=new String(validTextField.getText())+""+new String(validTextField1.getText());

               try {
                   Connect ch=new Connect();
                   String query="insert into addUser values (?,?,?,?,?)";
                   PreparedStatement ps=ch.co.prepareStatement(query);
                   ps.setString(1, Urollno);
                   ps.setString(2, Username);
                   ps.setString(3, Fathername);
                   ps.setString(4,Ucourse);
                   ps.setString(5,validupto);
                   ps.executeUpdate();
                   setVisible(false);

               }
               catch (Exception ex){
                   System.out.println(ex);
               }
           }
    }

    public static void main(String[] args) {
         new Adduser();
    }


}
