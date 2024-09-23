import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.sql.PreparedStatement;

public class Issuebook  extends JFrame implements ActionListener {
    JTextField  issueIdTextField, userIdTextField,  bookIdTextField,issueDateTextField,periodTextField;
    JButton Submit;
    Issuebook(){
        setVisible(true);
        setLayout(null);
        setSize(900,900);
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

        JLabel form=new JLabel("Issue Book");
        form.setBounds(620,130,300,40);
        form.setFont(new Font("RALEWAY",Font.BOLD,30));
        form.setHorizontalAlignment(SwingConstants.CENTER);
        form.setForeground(Color.black);
        form.setBorder(new LineBorder(Color.black,2));
        form.setOpaque(true); // Set to true to make the background color visible
        form.setBackground(Color.orange);
        add(form);




        JLabel issueId=new JLabel("Issue Id: ");
        issueId.setBounds(520,220,120,30);
        issueId.setFont(new Font("RALEWAY",Font.BOLD,25));
        issueId.setForeground(Color.white);
        add(issueId);


        issueIdTextField=new JTextField();
        issueIdTextField.setBounds(720,220,300,30);
        issueIdTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        issueIdTextField.setForeground(Color.black);
        issueIdTextField.setBorder(new LineBorder(Color.black,1));
        add(issueIdTextField);

        JLabel userId=new JLabel("User Id: ");
        userId.setBounds(520,280,120,30);
        userId.setFont(new Font("RALEWAY",Font.BOLD,25));
        userId.setForeground(Color.white);
        add(userId);


        userIdTextField=new JTextField();
        userIdTextField.setBounds(720,280,300,30);
        userIdTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        userIdTextField.setForeground(Color.black);
        userIdTextField.setBorder(new LineBorder(Color.black,1));
        add(userIdTextField);

        JLabel bookId=new JLabel("Book Id: ");
        bookId.setBounds(520,340,120,30);
        bookId.setFont(new Font("RALEWAY",Font.BOLD,25));
        bookId.setForeground(Color.white);
        add(bookId);


        bookIdTextField=new JTextField();
        bookIdTextField.setBounds(720,340,300,30);
        bookIdTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        bookIdTextField.setForeground(Color.black);
        bookIdTextField.setBorder(new LineBorder(Color.black,1));
        add(bookIdTextField);

        JLabel issueDate=new JLabel("Issue Date: ");
        issueDate.setBounds(520,400,150,30);
        issueDate.setFont(new Font("RALEWAY",Font.BOLD,25));
        issueDate.setForeground(Color.white);
        add(issueDate);


        issueDateTextField=new JTextField();
        issueDateTextField.setBounds(720,400,300,30);
        issueDateTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        issueDateTextField.setForeground(Color.black);
        issueDateTextField.setBorder(new LineBorder(Color.black,1));
        add(issueDateTextField);

        JLabel period=new JLabel("Period: ");
        period.setBounds(520,460,120,30);
        period.setFont(new Font("RALEWAY",Font.BOLD,25));
        period.setForeground(Color.white);
        add(period);


        periodTextField=new JTextField();
        periodTextField.setBounds(720,460,300,30);
        periodTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        periodTextField.setForeground(Color.black);
        periodTextField.setBorder(new LineBorder(Color.black,1));
        add(periodTextField);

        Submit=new JButton("Submit");
        Submit.setBounds(720,570,150,40);
        Submit.setFont(new Font("RALEWAY",Font.BOLD,25));
        Submit.setForeground(Color.BLACK);
        Submit.setBorder(new LineBorder(Color.black,2));
        Submit.setOpaque(true);
        Submit.setBackground(Color.white);
        Submit.addActionListener(this);
        add(Submit);
        add(labs);
        add(label);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Issue_Id=new String(issueIdTextField.getText());
        String Urollno=new String(userIdTextField.getText());
        String  b_id=new String(bookIdTextField.getText());
        String Issue_date=issueDateTextField.getText();
        String Period=periodTextField.getText();

        if(e.getSource()==Submit){
            try {
                Connect ch=new Connect();
                String query="insert into issueBook values(?,?,?,?,?)";
                PreparedStatement ps=ch.co.prepareStatement(query);
                ps.setString(1,Issue_Id);
                ps.setString(2,Urollno);
                ps.setString(3, b_id);
                ps.setString(4,Issue_date);
                ps.setString(5,Period);
                ps.executeUpdate();
                setVisible(false);
            }
            catch (Exception ex){
                System.out.println(ex);
            }
        }
    }
    public static void main(String[] args) {
      Issuebook obj=new Issuebook();
    }


}
