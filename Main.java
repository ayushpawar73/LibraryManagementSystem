import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main extends JFrame implements ActionListener {
    JButton addUser,addBook,issuebook,returnBook,viewUser,viewBook,viewIssueBook,viewReturnBook;

    Main(){
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

        JLabel head=new JLabel("Library Management System");
        head.setBounds(340,0,1050,80);
        head.setFont(new Font("RALEWAY",Font.BOLD,60));
        head.setForeground(Color.DARK_GRAY);

        add(head);
        addUser=new JButton("Add User");
        addUser.setBounds(330,140,210,100);
        addUser.setFont(new Font("RALEWAY",Font.BOLD,20));
        addUser.setForeground(Color.BLUE);
        addUser.setBorder(new LineBorder(Color.black,2));
        addUser.addActionListener(this);
        add(addUser);

        addBook=new JButton("Add Book");
        addBook.setBounds(540,140,210,100);
        addBook.setFont(new Font("RALEWAY",Font.BOLD,20));
        addBook.setForeground(Color.BLUE);
        addBook.setBorder(new LineBorder(Color.black,2));
        addBook.addActionListener(this);
        add(addBook);

        issuebook=new JButton("Issue Book");
        issuebook.setBounds(750,140,210,100);
        issuebook.setFont(new Font("RALEWAY",Font.BOLD,20));
        issuebook.setForeground(Color.BLUE);
        issuebook.setBorder(new LineBorder(Color.black,2));
        issuebook.addActionListener(this);
        add(issuebook);

        returnBook=new JButton("Return Book");
        returnBook.setBounds(960,140,210,100);
        returnBook.setFont(new Font("RALEWAY",Font.BOLD,20));
        returnBook.setForeground(Color.BLUE);
        returnBook.setBorder(new LineBorder(Color.black,2));
        returnBook.addActionListener(this);
        add(returnBook);


        viewUser=new JButton("View User");
        viewUser.setBounds(330,240,210,100);
        viewUser.setFont(new Font("RALEWAY",Font.BOLD,20));
        viewUser.setForeground(Color.BLUE);
        viewUser.setBorder(new LineBorder(Color.black,2));
        viewUser.addActionListener(this);
        add(viewUser);

        viewBook=new JButton("View Book");
        viewBook.setBounds(540,240,210,100);
        viewBook.setFont(new Font("RALEWAY",Font.BOLD,20));
        viewBook.setForeground(Color.BLUE);
        viewBook.setBorder(new LineBorder(Color.black,2));
        viewBook.addActionListener(this);
        add(viewBook);

        viewIssueBook=new JButton("View Issue Book");
        viewIssueBook.setBounds(750,240,210,100);
        viewIssueBook.setFont(new Font("RALEWAY",Font.BOLD,20));
        viewIssueBook.setForeground(Color.BLUE);
        viewIssueBook.setBorder(new LineBorder(Color.black,2));
        viewIssueBook.addActionListener(this);
        add(viewIssueBook);

        viewReturnBook=new JButton( "View Return Book");
        viewReturnBook.setBounds(960,240,210,100);
        viewReturnBook.setFont(new Font("RALEWAY",Font.BOLD,20));
        viewReturnBook.setForeground(Color.BLUE);
        viewReturnBook.setBorder(new LineBorder(Color.black,2));
        viewReturnBook.addActionListener(this);
        add(viewReturnBook);

        add(labs);

    }
    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==addUser){
            Adduser obj=new Adduser();
            setVisible(false);
        }

        if (e.getSource()==addBook){
            Addbook obj=new Addbook();
            setVisible(false);
        }
        if (e.getSource()==issuebook){
            Issuebook obj=new Issuebook();
            setVisible(false);
        }
        if(e.getSource()==returnBook){
            Returnbook obj=new Returnbook();
            setVisible(false);
        }

        //view User

        if(e.getSource()==viewUser){
            try {
                Connect ch=new Connect();
                String query="select *from adduser";
                PreparedStatement ps=ch.co.prepareStatement(query);
                ResultSet rs=ps.executeQuery();
              //Creating Table for to data will be in table format
                JTable view_list=new JTable();
                String [] viewColomuns={"User Id","User Name","Father Name","Course","Valid Upto"};

              //create model for the table
              DefaultTableModel viewModel=new DefaultTableModel();
                //Setting up the columns names of the model
                viewModel.setColumnIdentifiers(viewColomuns);
                //Adding model to the table component
                view_list.setModel(viewModel);
                //Setting background colour of the table
                view_list.setBackground(new Color(51, 35, 85));
                //Setting foreground colour of the table
                view_list.setForeground(Color.white);

                //Setting up table auto-resizable
                view_list.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                view_list.setFillsViewportHeight(true);
                view_list.setFocusable(false);

                //Creating scrollbars for table
                JScrollPane scrollBook = new JScrollPane(view_list);
                scrollBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                while (rs.next()){
                    int user_id=rs.getInt("Urollno");
                    String user_name=rs.getString("Username");
                    String father_name=rs.getString("Fathername");
                    String course=rs.getString("Ucourse");
                    int validupto=rs.getInt("validupto");
                    viewModel.addRow(new Object[]{user_id,user_name,father_name,course,validupto});
                }
                JFrame frame = new JFrame("View List Adduser");
                frame.getContentPane().add(scrollBook);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
            catch (Exception es){
                JOptionPane.showMessageDialog(null, es);
            }
        }



        //End view user




       //view book
        if(e.getSource()==viewBook){
            try{
                Connect ch=new Connect();
                String sql="select*from addBook";
                PreparedStatement ps=ch.co.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                JTable book_list=new JTable();
                String [] bookColomuns={"Book Id","Book Isbn","Book Name","Book Publisher","Book Edition","Book Gene","Book Price","Book pages"};
                //Creating model for the table
                DefaultTableModel bookModel=new DefaultTableModel();
                //Setting up the columns names of the model
                bookModel.setColumnIdentifiers(bookColomuns);
                //Adding model to the table component
                book_list.setModel(bookModel);
                //Setting background colour of the table
                book_list.setBackground(new Color(51, 35, 85));
                //Setting foreground colour of the table
                book_list.setForeground(Color.white);

                //Setting up table auto-resizable
                book_list.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                book_list.setFillsViewportHeight(true);
                book_list.setFocusable(false);

                //Creating scrollbars for table
                JScrollPane scrollBook = new JScrollPane(book_list);
                scrollBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                while (rs.next()) {
                    //Fetching the data from mysql database
                    int book_id = rs.getInt("b_id");
                    String book_isbn = rs.getString("book_isbn");
                    String book_name = rs.getString("book_name");
                    String book_publisher = rs.getString("book_publisher");
                    String book_edition = rs.getString("book_edition");
                    String book_genre = rs.getString("book_gene");
                    int book_price = rs.getInt("book_price");
                    int book_pages = rs.getInt("book_pages");
                    //Adding fetched data in model
                    bookModel.addRow(new Object[]{book_id, book_isbn, book_name, book_publisher, book_edition, book_genre, book_price, book_pages});
                }
                JFrame frame = new JFrame("View List Addbook");
                frame.getContentPane().add(scrollBook);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
            catch (Exception es){
                JOptionPane.showMessageDialog(null, es);
            }

        }

        //end view book

        //view Issue book
        if(e.getSource()==viewIssueBook){

            try {
                Connect ch = new Connect();
                String query = "select *from issueBook";
                PreparedStatement ps = ch.co.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                JTable viewIssuebook_list = new JTable();
                String[] viewIssueColomuns = {"Issue Id", "User Id", "Book id", "Return", "Peroid"};

                DefaultTableModel issueModel = new DefaultTableModel();
                issueModel.setColumnIdentifiers(viewIssueColomuns);
                viewIssuebook_list.setModel(issueModel);
                //Setting background colour of the table
                viewIssuebook_list.setBackground(new Color(51, 35, 85));
                //Setting foreground colour of the table
                viewIssuebook_list.setForeground(Color.white);
                //Creating scrollbars for table
                JScrollPane scrollBook = new JScrollPane(viewIssuebook_list);
                scrollBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                while (rs.next()) {
                    int issue_id = rs.getInt("Issue_Id");
                    int user_id = rs.getInt("Urollno");
                    int book_id = rs.getInt("b_id");
                    String issue_date = rs.getString("Issue_date");
                    String period = rs.getString("Period");
                    issueModel.addRow(new Object[]{issue_id, user_id, book_id, issue_date, period});
                }
                JFrame frame = new JFrame("View List Issue book");
                frame.getContentPane().add(scrollBook);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
            catch (Exception es){
                JOptionPane.showMessageDialog(null, es);
            }
        }

        if(e.getSource()==viewReturnBook){
            try {
                Connect ch=new Connect();
                String query="select * from  returnBook";
                PreparedStatement ps=ch.co.prepareStatement(query);
                ResultSet rs= ps.executeQuery();

                JTable viewReturnbook_list=new JTable();
                String[] viewReturnColomuns={"Return Id","Book Id","User Id","Return Date","Fine"};

                DefaultTableModel viewReturnModel=new DefaultTableModel();
                viewReturnModel.setColumnIdentifiers(viewReturnColomuns);
                viewReturnbook_list.setModel(viewReturnModel);

                //Setting background colour of the table
                viewReturnbook_list.setBackground(new Color(51, 35, 85));
                //Setting foreground colour of the table
                viewReturnbook_list.setForeground(Color.white);
                //Creating scrollbars for table
                JScrollPane scrollBook = new JScrollPane(viewReturnbook_list);
                scrollBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                while (rs.next()){
                    int return_id=rs.getInt("return_id");
                    int book_id=rs.getInt("b_id");
                    int user_id=rs.getInt("Urollno");
                    String return_date=rs.getString("return_date");
                    int fine=rs.getInt("fine");
                    viewReturnModel.addRow(new Object[]{return_id,book_id,user_id,return_date,fine});
                }
                JFrame frame = new JFrame("View List Return book");
                frame.getContentPane().add(scrollBook);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
            catch (Exception es){
                JOptionPane.showMessageDialog(null,es);
            }
        }




    }
    public static void main(String[] args) {
        Main obj=new Main();
    }


}
