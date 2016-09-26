package smell;

 
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
 
    int getProductID() {
        return _productId;
    }
 
    int getImageId() {
        return _imageId;
    }
 
    int getQuantity() {
        return _quantity;
    }
 
    int getUnitPrice() {
        return _unitPrice;
    }
}
