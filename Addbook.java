import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class Addbook extends JFrame implements ActionListener {
   JTextField bookIdTextField, isbnTextField, bookNameTextField,  bookPublisherTextField,bookEditionTextField, bookGeneTextField, bookPriceTextField, bookPagesTextField;
   JButton Submit;
    Addbook(){
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


        JLabel form=new JLabel("Add Book");
        form.setBounds(620,130,300,40);
        form.setFont(new Font("RALEWAY",Font.BOLD,30));
        form.setHorizontalAlignment(SwingConstants.CENTER);
        form.setForeground(Color.black);
        form.setBorder(new LineBorder(Color.black,2));
        form.setOpaque(true); // Set to true to make the background color visible
        form.setBackground(Color.orange);
        add(form);


        JLabel bookId=new JLabel("Book Id: ");
        bookId.setBounds(520,220,120,30);
        bookId.setFont(new Font("RALEWAY",Font.BOLD,25));
        bookId.setForeground(Color.white);
        add(bookId);


        bookIdTextField=new JTextField();
        bookIdTextField.setBounds(720,220,300,30);
        bookIdTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        bookIdTextField.setForeground(Color.black);
        bookIdTextField.setBorder(new LineBorder(Color.black,1));
        add(bookIdTextField);

        JLabel isbn=new JLabel("Book isbn: ");
        isbn.setBounds(520,260,140,30);
        isbn.setFont(new Font("RALEWAY",Font.BOLD,25));
        isbn.setForeground(Color.white);
        add(isbn);


        isbnTextField=new JTextField();
        isbnTextField.setBounds(720,260,300,30);
        isbnTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        isbnTextField.setForeground(Color.black);
        isbnTextField.setBorder(new LineBorder(Color.black,1));
        add(isbnTextField);

        JLabel bookName=new JLabel("Book name: ");
        bookName.setBounds(520,300,150,30);
        bookName.setFont(new Font("RALEWAY",Font.BOLD,25));
        bookName.setForeground(Color.white);
        add(bookName);


        bookNameTextField=new JTextField();
        bookNameTextField.setBounds(720,300,300,30);
        bookNameTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        bookNameTextField.setForeground(Color.black);
        bookNameTextField.setBorder(new LineBorder(Color.black,1));
        add(bookNameTextField);

        JLabel bookPublisher=new JLabel("Book Publisher: ");
        bookPublisher.setBounds(520,340,200,30);
        bookPublisher.setFont(new Font("RALEWAY",Font.BOLD,25));
        bookPublisher.setForeground(Color.white);
        add(bookPublisher);


        bookPublisherTextField=new JTextField();
        bookPublisherTextField.setBounds(720,340,300,30);
        bookPublisherTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        bookPublisherTextField.setForeground(Color.black);
        bookPublisherTextField.setBorder(new LineBorder(Color.black,1));
        add(bookPublisherTextField);

        JLabel bookEdition=new JLabel("Book Edition: ");
        bookEdition.setBounds(520,380,200,30);
        bookEdition.setFont(new Font("RALEWAY",Font.BOLD,25));
        bookEdition.setForeground(Color.white);
        add(bookEdition);


        bookEditionTextField=new JTextField();
        bookEditionTextField.setBounds(720,380,300,30);
        bookEditionTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        bookEditionTextField.setForeground(Color.black);
        bookEditionTextField.setBorder(new LineBorder(Color.black,1));
        add(bookEditionTextField);

        JLabel bookGene=new JLabel("Book Gene: ");
        bookGene.setBounds(520,420,200,30);
        bookGene.setFont(new Font("RALEWAY",Font.BOLD,25));
        bookGene.setForeground(Color.white);
        add(bookGene);


        bookGeneTextField=new JTextField();
        bookGeneTextField.setBounds(720,420,300,30);
        bookGeneTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        bookGeneTextField.setForeground(Color.black);
        bookGeneTextField.setBorder(new LineBorder(Color.black,1));
        add(bookGeneTextField);

        JLabel bookPrice=new JLabel("Book Price: ");
        bookPrice.setBounds(520,460,200,30);
        bookPrice.setFont(new Font("RALEWAY",Font.BOLD,25));
        bookPrice.setForeground(Color.white);
        add(bookPrice);


        bookPriceTextField=new JTextField();
        bookPriceTextField.setBounds(720,460,300,30);
        bookPriceTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        bookPriceTextField.setForeground(Color.black);
        bookPriceTextField.setBorder(new LineBorder(Color.black,1));
        add(bookPriceTextField);

        JLabel bookPages=new JLabel("Book Pages: ");
        bookPages.setBounds(520,500,200,30);
        bookPages.setFont(new Font("RALEWAY",Font.BOLD,25));
        bookPages.setForeground(Color.white);
        add(bookPages);


        bookPagesTextField=new JTextField();
        bookPagesTextField.setBounds(720,500,300,30);
        bookPagesTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
        bookPagesTextField.setForeground(Color.black);
        bookPagesTextField.setBorder(new LineBorder(Color.black,1));
        add(bookPagesTextField);


        Submit=new JButton("Add");
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
        String b_id=new String(bookIdTextField.getText());
        String book_isbn=isbnTextField.getText();
        String book_name=bookNameTextField.getText();
        String book_publisher=bookPublisherTextField.getText();
        String book_edition=bookEditionTextField.getText();
        String book_gene=new String(bookGeneTextField.getText());
        String book_price=bookPriceTextField.getText();
        String book_pages=new String(bookPagesTextField.getText());

        if(e.getSource()==Submit){
            try {
                Connect ch=new Connect();
                String query="insert into addBook values(?,?,?,?,?,?,?,?)";
                PreparedStatement ps=ch.co.prepareStatement(query);
                ps.setString(1,b_id);
                ps.setString(2,book_isbn);
                ps.setString(3,book_name);
                ps.setString(4,book_publisher);
                ps.setString(5,book_edition);
                ps.setString(6,book_gene);
                ps.setString(7,book_price);
                ps.setString(8,book_pages);
                ps.executeUpdate();
                setVisible(false);
            }
            catch (Exception es){
                System.out.println(es);
            }

        }



    }
    public static void main(String[] args) {
           Addbook obj= new Addbook();
    }


}
