import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

public class CustomerApplication {

	private JFrame frmCustomer;
	private JLabel lblResponse;
	private JTextField textField_CustomerNbr;
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private JTextField textField_PhoneNumber;
	private JTextField textField_DeliveryAddress;
	private JTextField textField_OrderNumber;
	private JPanel panel_Order;
	private JPanel panel_Customer;
	private JComboBox comboBox_Product;
	private JLabel lblMsg;
	
	private Controller controller;
	private CustomerRegister customerRegister;
	
	private ProductRegister productRegister; //Jakob la till
	private JTextField textField_Amount;
	private JTextField textField_OrderNumberorder;
	private JTextField textField_Price;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerApplication window = new CustomerApplication();
					window.frmCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCustomer = new JFrame();
		frmCustomer.setTitle("Schinn & Behn AB");
		frmCustomer.setBounds(100, 100, 621, 457);
		frmCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		customerRegister = new CustomerRegister();
		productRegister = new ProductRegister(); //Jakob la till
		controller = new Controller(customerRegister, productRegister, frmCustomer);
		frmCustomer.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 609, 427);
		frmCustomer.getContentPane().add(tabbedPane);
		
		JPanel panel_Customer = new JPanel();
		tabbedPane.addTab("Customer", null, panel_Customer, null);
		panel_Customer.setLayout(null);
		
		textField_CustomerNbr = new JTextField();
		textField_CustomerNbr.setBounds(152, 21, 159, 31);
		panel_Customer.add(textField_CustomerNbr);
		textField_CustomerNbr.setColumns(10);
		
		JLabel lblCustomerNumber = new JLabel("Customer number:");
		lblCustomerNumber.setBounds(27, 21, 145, 31);
		panel_Customer.add(lblCustomerNumber);
		
		textField_FirstName = new JTextField();
		textField_FirstName.setBounds(152, 64, 159, 31);
		panel_Customer.add(textField_FirstName);
		textField_FirstName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setBounds(27, 72, 109, 26);
		panel_Customer.add(lblFirstName);
		
		textField_LastName = new JTextField();
		textField_LastName.setBounds(152, 107, 159, 31);
		panel_Customer.add(textField_LastName);
		textField_LastName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setBounds(27, 110, 86, 26);
		panel_Customer.add(lblLastName);
		
		textField_PhoneNumber = new JTextField();
		textField_PhoneNumber.setBounds(152, 150, 159, 31);
		panel_Customer.add(textField_PhoneNumber);
		textField_PhoneNumber.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setBounds(27, 155, 107, 21);
		panel_Customer.add(lblPhoneNumber);
		
		textField_DeliveryAddress = new JTextField();
		textField_DeliveryAddress.setBounds(152, 193, 279, 31);
		panel_Customer.add(textField_DeliveryAddress);
		textField_DeliveryAddress.setColumns(10);
		
		JLabel lblDeliveryAddress = new JLabel("Delivery Address:");
		lblDeliveryAddress.setBounds(27, 196, 129, 24);
		panel_Customer.add(lblDeliveryAddress);
		
		textField_OrderNumber = new JTextField();
		textField_OrderNumber.setBounds(424, 21, 138, 31);
		panel_Customer.add(textField_OrderNumber);
		textField_OrderNumber.setColumns(10);
		
		JLabel lblOrderNumber = new JLabel("Order number:");
		lblOrderNumber.setBounds(323, 23, 108, 26);
		panel_Customer.add(lblOrderNumber);
		
		JButton btnFindCustomer = new JButton("Find Customer");
		btnFindCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerNumber = textField_CustomerNbr.getText();
				String[] tmpCustomer = controller.findCustomer(customerNumber);
				
				if(tmpCustomer != null){
					lblResponse.setText("Response:");
					textField_CustomerNbr.setText(tmpCustomer[0]);
					textField_FirstName.setText(tmpCustomer[1]);
					textField_LastName.setText(tmpCustomer[2]);
					textField_PhoneNumber.setText(tmpCustomer[3]);
					textField_DeliveryAddress.setText(tmpCustomer[4]);
				}else if(tmpCustomer == null){
					lblResponse.setText("Response: Customer not found!");
				}
			}	
		});
		btnFindCustomer.setBounds(16, 300, 150, 29);
		panel_Customer.add(btnFindCustomer);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerNumber = textField_CustomerNbr.getText();
				String firstName= textField_FirstName.getText();
				String lastName = textField_LastName.getText();
				String phoneNumber= textField_PhoneNumber.getText();
				String deliveryAddress= textField_DeliveryAddress.getText();
				controller.addCustomer(customerNumber, firstName, lastName, phoneNumber, deliveryAddress); //Kanske skicka in en array här istället?
				lblResponse.setText("Response: Stored Successfully!");
			}
		});
		btnAddCustomer.setBounds(173, 300, 150, 29);
		panel_Customer.add(btnAddCustomer);
		
		JButton btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerNumber =textField_CustomerNbr.getText();
				String[]tmpCustomer = controller.findCustomer(customerNumber);
				if(tmpCustomer != null){
					controller.deleteCustomer(customerNumber);
					lblResponse.setText("Response: Customer Deleted!");
				}
			}
		});
		btnDeleteCustomer.setBounds(173, 334, 150, 29);
		panel_Customer.add(btnDeleteCustomer);
		
		JButton btnUpdateCustomer = new JButton("Update Customer");
		btnUpdateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cNumber= textField_CustomerNbr.getText();
				String[] tmpCustomer= controller.findCustomer(cNumber);
				if(tmpCustomer != null){
					lblResponse.setText("Response:");
					String newFirstName = textField_FirstName.getText();
					String newLastName= textField_LastName.getText();
					String newPhoneNumber= textField_PhoneNumber.getText();
					String newDeliveryAddress = textField_DeliveryAddress.getText();
					controller.updateCustomer(cNumber, newFirstName, newLastName, newPhoneNumber, newDeliveryAddress);
				}else{
					lblResponse.setText("Response: Customer not found");
				}
			}
		});
		btnUpdateCustomer.setBounds(16, 334, 150, 29);
		panel_Customer.add(btnUpdateCustomer);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnPlaceOrder.setBounds(434, 300, 138, 29);
		panel_Customer.add(btnPlaceOrder);
		
		JButton btnViewOrder = new JButton("View Order");
		btnViewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
			}
		});
		btnViewOrder.setBounds(434, 334, 138, 29);
		panel_Customer.add(btnViewOrder);
		
		lblResponse= new JLabel("Response:");
		lblResponse.setBounds(27, 236, 545, 41);
		panel_Customer.add(lblResponse);
		
		JSeparator separator = new JSeparator(); //Linjen mellan knapparna och rutorna
		separator.setBounds(27, 276, 535, 12);
		panel_Customer.add(separator);
		
		panel_Order = new JPanel();
		panel_Order.setForeground(Color.BLACK);
		tabbedPane.addTab("Order", null, panel_Order, null);
		panel_Order.setLayout(null);
		
		//Här vill vi använda oss av en array med Product som kommer från ProductRegister via Controller
		/*ProductRegister productRegister = controller.getProductRegister();
		ArrayList<Product> products = productRegister.getProducts();
		
		ArrayList<String> productNames = new ArrayList<String>();
		ArrayList<Double> productPrices = new ArrayList<Double>();
		for(Product p: products){
			productNames.add(p.getName());
			productPrices.add(p.getPrice());
		}
		
		String[] listOfProducts = new String[products.size()];
		for(int i = 0; i < products.size(); i++){
			listOfProducts[i] = productNames.get(i);
		}*/
		
		//String[] products1={"Prinskorv 250g","Offerlamm 500g","Leverkorv 350g" };
		comboBox_Product = new JComboBox(controller.getProductNames());
	
		comboBox_Product.setSelectedIndex(0);
		
		comboBox_Product.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = comboBox_Product.getSelectedIndex(); 
				textField_Price.setText(Double.toString(controller.getProductPrices().get(x)));
				
				/*switch(x){
				case 0:
					textField_Price.setText("234kr");
					break;
				case 1:
					textField_Price.setText("546kr");
					break;
				case 2:
					textField_Price.setText("300kr");
					break;
				}*/
			}
		});
		
		
		//comboBox_Product.addItem("Fisk");
		//comboBox_Product.removeItem("Fisk");
	
		comboBox_Product.setBounds(128, 78, 154, 27);
		panel_Order.add(comboBox_Product);
		
		textField_Amount = new JTextField();
		textField_Amount.setBounds(129, 156, 130, 29);
		panel_Order.add(textField_Amount);
		textField_Amount.setColumns(10);
		
		JLabel lblOrderNumber_order = new JLabel("Order number:");
		lblOrderNumber_order.setBounds(25, 14, 110, 21);
		panel_Order.add(lblOrderNumber_order);
		
		JLabel lblProduct = new JLabel("Product:");
		lblProduct.setBounds(30, 77, 83, 27);
		panel_Order.add(lblProduct);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(30, 116, 83, 32);
		panel_Order.add(lblPrice);
		
		textField_OrderNumberorder = new JTextField();
		textField_OrderNumberorder.setBounds(129, 10, 130, 29);
		panel_Order.add(textField_OrderNumberorder);
		textField_OrderNumberorder.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(30, 160, 83, 21);
		panel_Order.add(lblAmount);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(18, 43, 553, 12);
		panel_Order.add(separator_1);
		
		textField_Price = new JTextField();
		textField_Price.setBounds(128, 115, 131, 29);
		panel_Order.add(textField_Price);
		textField_Price.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 247, 534, 116);
		panel_Order.add(scrollPane);
		
		table = new JTable(); //Listan med produkter man lagt till i varukorgen
		scrollPane.setViewportView(table);
		Object[]columns={"Product","Price","Amount"};
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setRowHeight(20);
		
		Object[] row =new Object[3];
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					lblMsg.setText(""); //Stoppa ner dessa fem rader kod i den sista if-satsen?
					row[0]= comboBox_Product.getSelectedItem();
					row[1]= textField_Price.getText();
					row[2]= textField_Amount.getText();
					model.addRow(row);	
					
					if(textField_Amount.getText().equals("") && textField_Price.getText().equals("")){
						lblMsg.setText("Select Product!");
					}
					else if(textField_Amount.getText().equals("")){
						lblMsg.setText("Select Amount!");
					}
					else{
						lblMsg.setText("");
						textField_Amount.setText("");
					}
			}
		});
		btnAdd.setBounds(25, 206, 88, 29);
		panel_Order.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i =table.getSelectedRow();
				if(i >=0){
					lblMsg.setText("");
					model.removeRow(i);
				}
				else{
					lblMsg.setText("Delete Error!");
				}
			}
		});
		btnDelete.setBounds(114, 206, 117, 29);
		panel_Order.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = table.getSelectedRow();
				
				if(i>=0)
				{
					lblMsg.setText("");
					model.setValueAt(comboBox_Product.getSelectedItem(), i, 0);
					model.setValueAt(textField_Price.getText(), i, 1);
					model.setValueAt(textField_Amount.getText(), i, 2);
				}
				else{
					lblMsg.setText("Update Error!");
				}
			}
		});
		btnUpdate.setBounds(230, 203, 77, 32);
		panel_Order.add(btnUpdate);
		
		JButton btnFindOrder = new JButton("Find Order");
		btnFindOrder.setBounds(288, 11, 117, 29);
		panel_Order.add(btnFindOrder);
		
		JButton btnAddOrder = new JButton("Add Order");
		btnAddOrder.setBounds(412, 11, 117, 29);
		panel_Order.add(btnAddOrder);
		
		lblMsg = new JLabel("");
		lblMsg.setForeground(Color.RED);
		lblMsg.setBounds(334, 211, 213, 21);
		panel_Order.add(lblMsg);
	}
}