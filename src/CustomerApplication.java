import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.DefaultListModel;
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
	private JList list_1;
	
	private Controller controller;
	private CustomerRegister customerRegister;
	private ProductRegister productRegister; //Jakob la till
	private OrderRegister orderRegister;
	
	private Customer currentCustomer;
	private Order currentOrder;
	
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
	
	DefaultListModel dlm = new DefaultListModel();
	DefaultTableModel model=new DefaultTableModel();

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            //break;
		        }
		    }
		} catch (Exception e) {
		   
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}*/
		
		frmCustomer = new JFrame();
		frmCustomer.setTitle("Schinn & Behn AB");
		frmCustomer.setBounds(100, 100, 621, 521);
		frmCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		customerRegister = new CustomerRegister();
		productRegister = new ProductRegister(); //Jakob la till
		orderRegister = new OrderRegister();
		controller = new Controller(customerRegister, productRegister, orderRegister, frmCustomer);
		frmCustomer.getContentPane().setLayout(null);
		
		currentCustomer  = null;
		
		//Den h�r ska vi lista en kunds ordrar med. Bara tmp-grej nu! Men vi b�r nog g�ra en JTable ist�llet?
		//Man kan ha en scroller i Jlist om man vill kunna scrolla n�r det blir f�r m�nga f�r att se.
		//list = new JList();
		//list.setBounds(152, 246, 279, 84);

		//list.getSelectedIndex();
		//panel_Customer.add(list);
		//list.setModel(dlm);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 609, 487);
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
				
				String tmpCustomerNumber = textField_CustomerNbr.getText();
				String tmpOrderNumber = textField_OrderNumber.getText();
					
				//String[] tmpOrder =controller.returnCustomerByOrderNumber(tmpOrderNumber);	
				//String[] tmpCustomer = controller.returnCustomerInfo(tmpCustomerNumber);
				
					if(!tmpCustomerNumber.isEmpty()){
						lblResponse.setText("");
						Customer tmpCustomer = controller.findCustomer(tmpCustomerNumber);
						
						if(tmpCustomer != null){
							currentCustomer = tmpCustomer;
							
							textField_CustomerNbr.setText(currentCustomer.getCustomerNumber());
							textField_FirstName.setText(currentCustomer.getFirstName());
							textField_LastName.setText(currentCustomer.getLastName());
							textField_PhoneNumber.setText(currentCustomer.getPhoneNumber());
							textField_DeliveryAddress.setText(currentCustomer.getDeliveryAddress());
							
							for(Order tmp: currentCustomer.getOrders()){
								dlm.addElement(tmp.getOrderNumber());
							}
						}
						else{
							
						}
						
						/*if(tmpCustomer != null){
						lblResponse.setText("");
						textField_CustomerNbr.setText(tmpCustomer[0]);
						textField_FirstName.setText(tmpCustomer[1]);
						textField_LastName.setText(tmpCustomer[2]);
						textField_PhoneNumber.setText(tmpCustomer[3]);
						textField_DeliveryAddress.setText(tmpCustomer[4]);
						
						currentCustomer = controller.findCustomer(tmpCustomerNumber);
						
						for(Order tmp: currentCustomer.getOrders()){
							dlm.addElement(tmp.getOrderNumber());
							//lblMsg.setText(tmp.getOrderNumber());
						}
						
					//else if(tmpCustomer.equals(null)){
					//	lblResponse.setText("Customer not found!");
					//}*/
					}
					else if(!tmpOrderNumber.isEmpty()){
							
						Order tmpOrder = controller.getOrderRegister().findOrder(tmpOrderNumber);
						
						if(tmpOrder!=null){
							currentCustomer = tmpOrder.getBelongsTo();
							
							textField_OrderNumber.setText(tmpOrder.getOrderNumber());
							textField_CustomerNbr.setText(currentCustomer.getCustomerNumber());
							textField_FirstName.setText(currentCustomer.getFirstName());
							textField_LastName.setText(currentCustomer.getLastName());
							textField_PhoneNumber.setText(currentCustomer.getPhoneNumber());
							textField_DeliveryAddress.setText(currentCustomer.getDeliveryAddress());
							
							for(Order tmp: currentCustomer.getOrders()){
								dlm.addElement(tmp.getOrderNumber());
							}
						}
							/*textField_OrderNumber.setText(tmpOrder[0]);
							textField_CustomerNbr.setText(tmpOrder[1]);
							textField_FirstName.setText(tmpOrder[2]);
							textField_LastName.setText(tmpOrder[3]);
							textField_PhoneNumber.setText(tmpOrder[4]);
							textField_DeliveryAddress.setText(tmpOrder[5]);
							
							currentCustomer = controller.findCustomer(tmpOrder[1]);
							for(Order tmp: currentCustomer.getOrders()){
								dlm.addElement(tmp.getOrderNumber());
							}*/			
						}
					}
		});
		btnFindCustomer.setBounds(16, 375, 150, 29);
		panel_Customer.add(btnFindCustomer);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_FirstName.getText().isEmpty()){
					lblResponse.setText("Add error!");
					lblResponse.setForeground(Color.red);
				}else{
				String customerNumber = controller.generateNewCustomerNumber();//textField_CustomerNbr.getText();
				textField_CustomerNbr.setText(customerNumber);
				String firstName= textField_FirstName.getText();
				String lastName = textField_LastName.getText();
				String phoneNumber= textField_PhoneNumber.getText();
				String deliveryAddress= textField_DeliveryAddress.getText();
				controller.addCustomer(customerNumber, firstName, lastName, phoneNumber, deliveryAddress); //Kanske skicka in en array h�r ist�llet?
				lblResponse.setText("Stored Successfully!");
				lblResponse.setForeground(Color.BLUE);
				currentCustomer = controller.findCustomer(customerNumber);
			}
			}});
		btnAddCustomer.setBounds(173, 375, 150, 29);
		panel_Customer.add(btnAddCustomer);
		
		JButton btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerNumber = textField_CustomerNbr.getText();
				Customer tmpCustomer = controller.findCustomer(customerNumber);
				//String[]tmpCustomer = controller.returnCustomerInfo(customerNumber);
				if(tmpCustomer != null){
					controller.deleteCustomer(customerNumber);
					currentCustomer = null;
					lblResponse.setText("Customer Deleted!");
					clearText();
				}
			}
		});
		btnDeleteCustomer.setBounds(173, 406, 150, 29);
		panel_Customer.add(btnDeleteCustomer);
		
		JButton btnUpdateCustomer = new JButton("Update Customer");
		btnUpdateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cNumber= textField_CustomerNbr.getText();
				//String[] tmpCustomer= controller.returnCustomerInfo(cNumber);
				Customer tmpCustomer = controller.findCustomer(cNumber);
				if(tmpCustomer != null){
					lblResponse.setText("");
					String newFirstName = textField_FirstName.getText();
					String newLastName= textField_LastName.getText();
					String newPhoneNumber= textField_PhoneNumber.getText();
					String newDeliveryAddress = textField_DeliveryAddress.getText();
					controller.updateCustomer(cNumber, newFirstName, newLastName, newPhoneNumber, newDeliveryAddress);
				}else{
					lblResponse.setText("Customer not found!");
				}
			}
		});
		btnUpdateCustomer.setBounds(16, 406, 150, 29);
		panel_Customer.add(btnUpdateCustomer);
		
		JButton btnClearText = new JButton("Clear Text");
		btnClearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				lblResponse.setText("");
				clearText();
			}
		});
		btnClearText.setBounds(424, 406, 138, 29);
		panel_Customer.add(btnClearText);
		
		/*JButton btnViewOrder = new JButton("View Order");
		btnViewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
			}
		});
		btnViewOrder.setBounds(434, 334, 138, 29);
		panel_Customer.add(btnViewOrder);*/
		
		lblResponse= new JLabel("");
		lblResponse.setForeground(Color.BLUE);
		lblResponse.setBounds(16, 337, 156, 21);
		panel_Customer.add(lblResponse);
		
		JSeparator separator = new JSeparator(); //Linjen mellan knapparna och rutorna
		separator.setBounds(16, 359, 546, 12);
		panel_Customer.add(separator);

		JLabel lblOrders = new JLabel("Orders:");
		lblOrders.setBounds(27, 255, 96, 21);
		panel_Customer.add(lblOrders);
		
		list_1 = new JList();
		list_1.setBounds(152, 257, 279, 76);
		panel_Customer.add(list_1);
		DefaultListModel dlm = new DefaultListModel();
		list_1.setModel(dlm);
		
		//list_1.getSelectedValue()
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentCustomer!=null){
					lblResponse.setText(null);
					lblMsg.setText(null);
					tabbedPane.setSelectedIndex(1);
				}
				else{
					lblResponse.setForeground(Color.RED);
					lblResponse.setText("No customer selected!");
				}
			}
		});
		btnPlaceOrder.setBounds(424, 375, 138, 29);
		panel_Customer.add(btnPlaceOrder);
		
		panel_Order = new JPanel();
		panel_Order.setForeground(Color.BLACK);
		tabbedPane.addTab("Order", null, panel_Order, null);
		panel_Order.setLayout(null);
		
		comboBox_Product = new JComboBox(controller.getProductNames());
	
		comboBox_Product.setSelectedIndex(3);
		
		comboBox_Product.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = comboBox_Product.getSelectedIndex(); 
				textField_Price.setText(Double.toString(controller.getProductPrices().get(x)));
			}
		});
	
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
		
		JLabel lblAmount = new JLabel("Quantity:");
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
		scrollPane.setBounds(25, 270, 534, 116);
		panel_Order.add(scrollPane);
		
		table = new JTable(); //Listan med produkter man lagt till i varukorgen
		scrollPane.setViewportView(table);
		Object[]columns={"Product","Price","Quantity"};

		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setRowHeight(20);
		
		Object[] row =new Object[3];
		JButton btnAdd = new JButton("Add Product");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_Amount.getText().equals("") && textField_Price.getText().equals("")){
					lblMsg.setText("Select Product and Amount!");
				}
				else if(textField_Amount.getText().equals("")){
					lblMsg.setText("Select Amount!");
				}
				else if(textField_Amount.getText().equals("")){
					lblMsg.setText("Select Product!");
				}
				else{
					lblMsg.setText(""); //Stoppa ner dessa fem rader kod i den sista if-satsen?
					row[0]= comboBox_Product.getSelectedItem();
					row[1]= textField_Price.getText();
					row[2]= textField_Amount.getText();
					model.addRow(row);
					
					lblMsg.setText(null);
					textField_Amount.setText("");
				}
			}
		});
		btnAdd.setBounds(25, 229, 130, 29);
		panel_Order.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete Product");
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
		btnDelete.setBounds(152, 398, 130, 29);
		panel_Order.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update Product");
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
		btnUpdate.setBounds(23, 398, 131, 29);
		panel_Order.add(btnUpdate);
		
		JButton btnFindOrder = new JButton("Find Order");
		btnFindOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				String tmpOrderNumber = textField_OrderNumberorder.getText();
				Order tmpOrder = controller.getOrderRegister().findOrder(tmpOrderNumber);
				
				if(tmpOrder != null){
					currentOrder = tmpOrder;
					ArrayList<OrderLine> tmpOrderLines = tmpOrder.getOrderLines();
					
					int i = 0;
						for(OrderLine o: tmpOrderLines){
								
							//Object tmpLineNumber = o.getLineNumber();
							Object tmpProductName = o.getProduct().getName();
							Object tmpProductPrice = Double.toString(o.getProduct().getPrice());
							Object tmpAmount = o.getAmount();
							
							Object[] tmpObjects= new Object[3];
							
							model.addRow(tmpObjects);
							
							model.setValueAt(tmpProductName, i, 0);
							model.setValueAt(tmpProductPrice, i, 1);
							model.setValueAt(tmpAmount, i, 2);
							
							i++;
						}
				}
				else{
					lblMsg.setForeground(Color.RED);
					lblMsg.setText("Order not found!");
				}
				
				//panel_Customer.setVisible(true);
				//panel_Order.setVisible(false);
			}
		});
		btnFindOrder.setBounds(282, 11, 116, 29);
		panel_Order.add(btnFindOrder);
		
		JButton btnAddOrder = new JButton("Place Order");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentCustomer != null){
					Order tmpOrder = new Order(controller.generateNewOrderNumber());
					tmpOrder.setBelongsTo(currentCustomer);
					
					TableModel tmpModel = table.getModel();
					int rows = tmpModel.getRowCount();
					
					for(int i = 0; i < rows; i++){
						Object[] objects = new Object[3];
						objects[0] = tmpModel.getValueAt(i, 0);
						objects[1] = tmpModel.getValueAt(i, 1);
						objects[2] = tmpModel.getValueAt(i, 2);
						
						String tmpProductName = (String)objects[0];
						String tmpPrice = (String)objects[1];
						String tmpQuantity = (String)objects[2];
						
						Product tmpProduct = controller.getProductRegister().find(tmpProductName);
						OrderLine tmpOrderLine = new OrderLine(Integer.toString(i+1), tmpProduct, Integer.parseInt(tmpQuantity));
						tmpOrder.addOrderLine(tmpOrderLine);
					
					}
					
					controller.getOrderRegister().addOrder(tmpOrder); //L�gger till ordern i det STORA orderregistret som h�ller ALLAS ordrar.
					currentCustomer.addOrder(tmpOrder); //L�gger till ordern hos den specifika kundens orderregister s� att det g�r att hitta ordern genom kunden.
					
					//ArrayList<Order> tmpOrders = currentCustomer.getOrders();
					//Order tmpOrderIgen = tmpOrders.get(0);
					
					dlm.addElement(tmpOrder.getOrderNumber());
					//textField_OrderNumber.setText(tmpOrderIgen.getOrderNumber());
					
					lblMsg.setForeground(Color.BLUE);
					lblMsg.setText("Order placed!");
					clearOrder();
				}
				else{
					lblMsg.setForeground(Color.RED);
					lblMsg.setText("No selected customer!");
				}
				
			}
		});
		btnAddOrder.setBounds(445, 398, 116, 29);
		panel_Order.add(btnAddOrder);
		
		lblMsg = new JLabel("");
		lblMsg.setForeground(Color.RED);
		lblMsg.setBounds(377, 237, 182, 21);
		panel_Order.add(lblMsg);
		
		JButton btnDeleteOrder = new JButton("Delete Order");
		btnDeleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentOrder != null){
					controller.getOrderRegister().deleteOrder(currentOrder.getOrderNumber());
					currentCustomer.deleteOrder(currentOrder.getOrderNumber());
					dlm.removeElement(currentOrder.getOrderNumber());
					clearOrder();
					currentOrder = null;
					
					lblMsg.setForeground(Color.BLUE);
					lblMsg.setText("Order deleted!");
				}
				else{
					lblMsg.setForeground(Color.RED);
					lblMsg.setText("No order selected!");
				}
			}
		});
		btnDeleteOrder.setBounds(398, 11, 116, 29);
		panel_Order.add(btnDeleteOrder);
	}
	private void clearText(){
		textField_CustomerNbr.setText(null);
		textField_FirstName.setText(null);
		textField_LastName.setText(null);
		textField_PhoneNumber.setText(null);
		textField_DeliveryAddress.setText(null);
		textField_OrderNumber.setText(null);
		lblMsg.setText(null);
		dlm.clear();
		list_1.setModel(dlm);
	}
	
	//Gjorde Anna
	private void clearOrder() {
		comboBox_Product.setSelectedIndex(3);
		textField_Price.setText(null);
		textField_Amount.setText(null);
		textField_OrderNumberorder.setText(null);
		int tmp = model.getRowCount();
		
		for (int i = 0; i < tmp; i++) {
			model.removeRow(0);
		}
	}
}

