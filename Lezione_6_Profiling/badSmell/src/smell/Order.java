package smell;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

public class Order {

	private OrderLineList _orderLineList;

	public Order(OrderLineList orderLineList) {
		_orderLineList = orderLineList;
	}

	public boolean equals(Object aThat) {
		if ( this == aThat ) return true;
		if ( !(aThat instanceof Order) ) return false;
		Order that = (Order)aThat;
		return this._orderLineList.equals(that._orderLineList);
	}

	public void calculateAndPrintOrderTotal(Order order, PrintWriter pw) {
		int result = 0;

		result = calculateAndPrintSingleOrderLine(pw, result);
		pw.println("Order total = " + result);
	}

	private int calculateAndPrintSingleOrderLine(PrintWriter pw, int result) {
		Vector<OrderLine> orderLines = _orderLineList.getOrderLines();
		Iterator<OrderLine> orderLineIterator = orderLines.iterator();
		OrderLine orderLine;
		
		while (orderLineIterator.hasNext()) {
			orderLine = (OrderLine)orderLineIterator.next();
			result += orderLine.getUnitPrice() * orderLine.getQuantity();

			pw.println("Begin Line Item");
			pw.println("Product = " + orderLine.getProductID());
			pw.println("Image = " + orderLine.getImageId());
			pw.println("Quantity = " + orderLine.getQuantity());
			pw.println("Total = " + result);
			pw.println("End Line Item");
			
		}
		return result;
	}

	public void saveOrderOnDb()  throws SQLException
	{
		Connection conn = null;

		PreparedStatement orderStatement = null;

		String sql = new StringBuffer().append("INSERT INTO T_ORDER " )
				.append("(AUTHORIZATION_CODE, " )
				.append("SHIPMETHOD_ID, USER_ID, ADDRESS_ID) " )
				.append("VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ).toString();
		conn = setConnection();
		
		orderStatement = conn.prepareStatement(sql);
		orderStatement.executeUpdate();
	}

	private Connection setConnection() {
		return null;
	}
}
