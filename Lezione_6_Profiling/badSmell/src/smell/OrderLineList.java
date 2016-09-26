package smell;

import java.util.Vector;
 
public class OrderLineList {
    private Vector<OrderLine> _orderLineList;
 
    public void setOrderLines(Vector<OrderLine> orderLines) {
        _orderLineList = orderLines;
    }
 
    Vector<OrderLine> getOrderLines() {
        return _orderLineList;
    }
}
