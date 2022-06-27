class TransactionParty {
  String seller;
	String buyer;
	public TransactionParty(String seller, String buyer) {
		super();
		this.seller = seller;
		this.buyer = buyer;
	}  
    
}

class Receipt{
  TransactionParty transactionParty;
	String productsQR;
	public Receipt(TransactionParty transactionParty, String productsQR) {
		super();
		this.transactionParty = transactionParty;
		this.productsQR = productsQR;
	}     
}


class GenerateReceipt{
   public static int verifyParty(Receipt r) {
		String regex= "[A-Za-z]{1}[A-Za-z\\'\\s]+|[A-Za-z\\s-]+[A-Za-z]{1}";
		int value;
		boolean m1,m2;
		m1=Pattern.matches(regex, r.transactionParty.seller);
		m2=Pattern.matches(regex, r.transactionParty.buyer);
		if(m1&&m2==true)
			value=2;
		else if(m1||m2==true)
			value=1;
		else
			value=0;
		return value;	
	}
	public static String calcGST(Receipt r) {
		int gst=0; float gst_rate=0.12F;
	    String[]pairs=r.productsQR.split("@");
	   	    for(String pair:pairs) {
	    	String[] rateQty=pair.split(",");
	    	String rate=rateQty[0];
	    	String quantity=rateQty[1];
	    	int total=(Integer.parseInt(rate))*(Integer.parseInt(quantity));
	    	gst=gst+total;
	    }
    	gst=(int)(gst*gst_rate);
	   return Integer.toString(gst); 	
	    } 
}

class SourceC {
	  public static void main(String[] args){
}
}
