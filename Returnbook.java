import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class Returnbook  extends JFrame implements ActionListener {
    JTextField   returnIdTextField, bookIdTextField, userIdTextField,  returnDateTextField,issueDateTextField, fineTextField;
    JButton Submit;
    Returnbook(){
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
        Image i2=i1.getImage().getScaledInstance(600,520,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(470,100,600,520);

        JLabel head=new JLabel("Library Management System");
        head.setBounds(340,0,1050,80);
        head.setFont(new Font("RALEWAY",Font.BOLD,60));
        head.setForeground(Color.DARK_GRAY);
        add(head);

        JLabel form=new JLabel("Return Book");
        form.setBounds(620,130,300,40);
        form.setFont(new Font("RALEWAY",Font.BOLD,30));
        form.setHorizontalAlignment(SwingConstants.CENTER);
        form.setForeground(Color.black);
        form.setBorder(new LineBorder(Color.black,2));
        form.setOpaque(true); // Set to true to make the background color visible
        form.setBackground(Color.orange);
        add(form);




        JLabel issueId=new JLabel("Return Id: ");
        issueId.setBounds(520,220,140,30);
        issueId.setFont(new Font("RALEWAY",Font.BOLD,25));
        issueId.setForeground(Color.white);
        add(issueId);


        returnIdTextField=new JTextField();
        returnIdTextField.setBounds(720,220,300,30);
        returnIdTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        returnIdTextField.setForeground(Color.black);
        returnIdTextField.setBorder(new LineBorder(Color.black,1));
        add(returnIdTextField);

        JLabel userId=new JLabel("Book Id: ");
        userId.setBounds(520,280,120,30);
        userId.setFont(new Font("RALEWAY",Font.BOLD,25));
        userId.setForeground(Color.white);
        add(userId);


        bookIdTextField=new JTextField();
        bookIdTextField.setBounds(720,280,300,30);
        bookIdTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        bookIdTextField.setForeground(Color.black);
        bookIdTextField.setBorder(new LineBorder(Color.black,1));
        add(bookIdTextField);

        JLabel bookId=new JLabel("User Id: ");
        bookId.setBounds(520,340,120,30);
        bookId.setFont(new Font("RALEWAY",Font.BOLD,25));
        bookId.setForeground(Color.white);
        add(bookId);


        userIdTextField=new JTextField();
        userIdTextField.setBounds(720,340,300,30);
        userIdTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        userIdTextField.setForeground(Color.black);
        userIdTextField.setBorder(new LineBorder(Color.black,1));
        add(userIdTextField);

        JLabel returnDate=new JLabel("Return Date: ");
        returnDate.setBounds(520,400,170,30);
        returnDate.setFont(new Font("RALEWAY",Font.BOLD,25));
        returnDate.setForeground(Color.white);
        add(returnDate);


        returnDateTextField=new JTextField();
        returnDateTextField.setBounds(720,400,300,30);
        returnDateTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        returnDateTextField.setForeground(Color.black);
        returnDateTextField.setBorder(new LineBorder(Color.black,1));
        add(returnDateTextField);




        JLabel period=new JLabel("Fine: ");
        period.setBounds(520,460,120,30);
        period.setFont(new Font("RALEWAY",Font.BOLD,25));
        period.setForeground(Color.white);
        add(period);


        fineTextField=new JTextField();
        fineTextField.setBounds(720,460,300,30);
        fineTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        fineTextField.setForeground(Color.black);
        fineTextField.setBorder(new LineBorder(Color.black,1));
        add(fineTextField);

        Submit=new JButton("Submit");
        Submit.setBounds(720,520,150,40);
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
        String return_id=new String(returnIdTextField.getText());
        String b_id=new String(bookIdTextField.getText());
        String  Urollno=new String(userIdTextField.getText());
        String return_date=returnDateTextField.getText();
        String  fine=new String(fineTextField.getText());



        try {
            Connect ch=new Connect();
            String query="insert into returnBook values(?,?,?,?,?)";
            PreparedStatement ps=ch.co.prepareStatement(query);
            ps.setString(1,return_id);
            ps.setString(2,b_id);
            ps.setString(3, Urollno);
            ps.setString(4,return_date);
            ps.setString(5,fine);


            ps.executeUpdate();
            setVisible(false);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        Returnbook obj=new Returnbook();
    }


}
