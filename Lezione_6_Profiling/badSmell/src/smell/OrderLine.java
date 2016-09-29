package smell;

import java.io.PrintWriter;


public class OrderLine {
	private int _productId;
	private int _imageId;
	private int _quantity;
	private int _unitPrice;

	public OrderLine(int prodID, int imageID, int inQty) {
		_productId = prodID;
		_imageId = imageID;
		_quantity = inQty;
	}

	void PrintSingleOrderLine(PrintWriter pw) {
		pw.println("Begin Line Item");
		pw.println("Product = " + _productId);
		pw.println("Image = " + _imageId);
		pw.println("Quantity = " + _quantity);
		pw.println("Total = " + calculateTotalLine());
		pw.println("End Line Item");
	}

	public int calculateTotalLine() {
		return _unitPrice * _quantity;
	}
	
    public void setUnitPrice(int unitPrice) {
    	_unitPrice = unitPrice;
    }
}
