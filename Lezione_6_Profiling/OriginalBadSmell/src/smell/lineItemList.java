package smell;

import java.util.Vector;
 
class lineitemlist {
    private Vector LIList;
 
    public void setLineItems(Vector lineItems) {
        LIList = lineItems;
    }
 
    Vector getLineItems() {
        return LIList;
    }
}
