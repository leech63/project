package foodmall;

//

public class StartShopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	MyShop myshop = new MyShop();
		
		myshop.setTitle("금용");
		myshop.genFood();
		myshop.setExistingUsers("이창헌", "홍길동", myshop.existingUsers);
		myshop.initAlarm();
	}

	}


