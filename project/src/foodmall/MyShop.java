package foodmall;

import java.util.ArrayList;
import java.util.Scanner;

public class MyShop {
//
	String title;

	String[] existingUsers = new String[2];

	String newUser;

	Food[] jajangFood = new Food[3];
	Food[] jjambbongFood = new Food[3];
	Food[] tangsuyukFood = new Food[3];

	ArrayList<Food> cart = new ArrayList<Food>();

	int foodNo;

	Scanner scan = new Scanner(System.in);

	int total = 0;

	public void setTitle(String title) {	//제목
		this.title = title;
	}

	public void setExistingUsers(String firstUser, String secondUser, String[] existingUsers) {
		//사용자
		UserList userList = new UserList();

		userList.setFirstUser(firstUser);
		userList.setSecondUser(secondUser);

		existingUsers[0] = userList.getFirstUser();
		existingUsers[1] = userList.getSecondUser();
	}

	public void initAlarm() {
		//시작
		System.out.println("====================================================");
		System.out.println("#  " + title + " 중국집에 오신것을 환영합니다.  #");
		System.out.println("#  기존에 저희 중국집을 방문해 보신적이 있으신가요? [y/n]  #");
		System.out.printf("#  방문여부 : ");

		String isVisited = scan.next();

		switch (isVisited) {
		case "y":

			choiceAccount();
			break;
		case "n":

			registerAccount();
			break;
		default:

			System.out.println("#  범위를 벗어났습니다. 프로그램을 종료합니다.");
			System.exit(0);
			break;
		}
	}

	public void choiceAccount() {
		//계정선택
		System.out.println("====================================================");
		System.out.println("# 데이터 조회 결과, 두 개의 계정이 존재합니다. 원하시는 계정을 선택해주세요.");
		System.out.println("#  회원[1] : " + existingUsers[0]);
		System.out.println("#  회원[2] : " + existingUsers[1]);
		System.out.printf("#  선택 -> ");

		int userNo = scan.nextInt();

		switch (userNo) {
		case 1:

			firstUser(existingUsers[0]);
			break;
		case 2:

			secondUser(existingUsers[1]);
			break;
		default:
			System.out.println("#  범위를 벗어났습니다. 프로그램을 종료합니다.");
			System.exit(0);
			break;
		}

	}

	public void registerAccount() {
		//회원가입
		System.out.println("====================================================");
		System.out.println("#  회원가입을 진행합니다.");
		System.out.printf("#  성함을 입력해주세요 : ");

		newUser = scan.next();

		UserList userList = new UserList();
		userList.setNewUser(newUser);

		System.out.println("====================================================");
		System.out.println("#  " + userList.getNewUser() + "님 환영합니다. 원하시는 카테고리를 선택해주세요.");

		selectCategory();
	}

	public void firstUser(String firstUser) {

		System.out.println("===================================================");
		System.out.println("#  " + firstUser + "님 환영합니다. 원하시는 카테고리를 선택해주세요.");

		selectCategory();
	}

	public void secondUser(String secondUser) {

		System.out.println("===================================================");
		System.out.println("#  " + secondUser + "님 환영합니다. 원하시는 카테고리를 선택해주세요.");

		selectCategory();
	}

	public void genFood() {
		//음식
		Jajang jajang = new Jajang("짜장면", 5000);
		jajang.setCategoryName("짜장면");
		jajangFood[0] = jajang;
		jajang = new Jajang("간짜장", 6000);
		jajangFood[1] = jajang;
		jajang = new Jajang("사천짜장", 7000);
		jajangFood[2] = jajang;

		Jjambbong jjambbong = new Jjambbong("짬뽕", 6000);
		jjambbong.setCategoryName("짬뽕");
		jjambbongFood[0] = jjambbong;
		jjambbong = new Jjambbong("삼선짬뽕", 7000);
		jjambbongFood[1] = jjambbong;
		jjambbong = new Jjambbong("사천짬뽕", 8000);
		jjambbongFood[2] = jjambbong;

		Tangsuyuk tangsuyuk = new Tangsuyuk("탕수육", 18000);
		tangsuyuk.setCategoryName("탕수육");
		tangsuyukFood[0] = tangsuyuk;
		tangsuyuk = new Tangsuyuk("사천탕수육", 20000);
		tangsuyukFood[1] = tangsuyuk;
		tangsuyuk = new Tangsuyuk("탕수육대", 20000);
		tangsuyukFood[2] = tangsuyuk;
	}

	public void selectCategory() {
		//카테고리선택
		System.out.println("┏━━카테고리목록━━┓");
		System.out.println("┃ 1. 짜장          ┃");
		System.out.println("┃ 2. 짬뽕          ┃");
		System.out.println("┃ 3. 탕수육       ┃");
		System.out.println("┗━━━━━━━━━━━━┛");
		System.out.println("#  [0] : 장바구니 물품을 계산합니다.");
		System.out.printf("#  선택 -> ");

		int categoryNo = scan.nextInt();

		printFoodList(categoryNo);
	}

	public void printFoodList(int categoryNo) {	//음식리스트
		switch (categoryNo) {
		case 0:

			checkout();
			break;
		case 1:

			selectFood(jajangFood);
			break;
		case 2:

			selectFood(jjambbongFood);
			break;
		case 3:

			selectFood(tangsuyukFood);
			break;
		default:

			System.out.println("#  범위를 벗어났습니다. 프로그램이 종료되었습니다.");
			System.exit(0);
			break;
		}

	}

	public void putCart(Food food) {
		//음식카트담기
		cart.add(food);
		total += food.getPrice();

		System.out.printf("#  %s을 선택하셨습니다. 현재 장바구니 총 금액은 %d원 입니다.\n", food.getFoodName(), total);
		System.out.println("#  Enter키를 누르시면 카테고리 목록이 출력됩니다.");

		scan.nextLine();
		scan.nextLine(); // 입력 버퍼 지우기

		selectCategory();
	}

	public void selectFood(Food[] food) {
		//음식선택
		System.out.println("=================================================================");

		// products[0]의 의미는 0, 1, 2중 아무거나 와도 출력값이 같아서 0으로 설정함
		System.out.println("#  " + food[0].getCategoryName() + " 카테고리에 오신 것을 환영합니다. 원하시는 상품 번호를 입력해주세요.");

		for (int i = 0; i < 3; i++) {
			System.out.printf("#  상품명" + (i + 1) + " : %s, 가격 : %d\n", food[i].getFoodName(), food[i].getPrice());
		}

		System.out.println("#  [0] : 장바구니 물품들을 계산합니다.");
		System.out.printf("#  선택 -> ");

		foodNo = scan.nextInt();

		System.out.println("==================================================================");

		if (foodNo == 0) {

			checkout();
		} else if (foodNo == 1 || foodNo == 2 || foodNo == 3) {

			putCart(food[foodNo - 1]);
		} else {

			System.out.println("#  범위를 벗어났습니다. 프로그램을 종료합니다.");
			System.exit(0);
		}
	}

	public void checkout() {	//체크
		if (total == 0) {

			System.out.println("============================================");
			System.out.println("#  장바구니가 비어있습니다. 장바구니에 상품을 담아주세요.");

			selectCategory();
		} else {

			printShoppingBasket();
			System.out.printf("#  결제하실 총 금액은 %d원 입니다. \n#  ▼ 결제 방법을 선택해주세요 ▼\n", total);
			System.out.println("#  [1] : CASH");
			System.out.println("#  [2] : CARD");
			System.out.println("#  [3] : HANDPHONE");
			System.out.printf("#  선택 -> ");

			int payment = scan.nextInt();

			switch (payment) {
			case 1:

				paymentOnCash();
				break;
			case 2:

				paymentOnCard();
				break;
			case 3:

				System.out.println("#  핸드폰결제하겠습니다.");
				NeedRecipt();
				break;

			default:

				System.out.println("#  범위를 벗어났습니다. 프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}

	public void printShoppingBasket() {
		//장바구니
		System.out.println("=========================================");
		System.out.println("━━━━━━━━━━장바구니 목록━━━━━━━━━━━");
		System.out.println("순번\t   상품\t\t      가격");

		for (int i = 0; i < cart.size(); i++) {

			System.out.printf(" %d   ┃\t%s   \t┃%d \n", i + 1, cart.get(i).getFoodName(), cart.get(i).getPrice());
		}

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}

	public void paymentOnCash() {
		//현금결제
		System.out.println("=======================================");
		System.out.printf("#  지불하실 현금을 입력해주세요 : ");

		int cash = scan.nextInt();

		if (cash >= total) {

			System.out.println("=======================================");
			System.out.printf("#  %d원을 지불하셨습니다. 거스름돈은 %d원 입니다.\n", cash, cash - total);
			System.out.println("#  계산이 완료되었습니다. 안녕히 가세요.");
		} else {

			System.out.println("=======================================");
			System.out.printf("#  %d원을 더 지불하셔야 합니다.\n", total - cash);

			differencePayment(cash);
		}

	}

	public void differencePayment(int cash) {
		//현금차액
		System.out.printf("#  차액 지불하기 : ");

		int difference = scan.nextInt();

		if (difference == total - cash) {

			System.out.println("=====================================");
			System.out.println("#  계산이 완료되었습니다. 안녕히 가세요.");
		} else if (difference < total - cash) {

			total = (total - cash) - difference;

			System.out.println("=====================================");
			System.out.printf("#  %d원을 더 지불하셔야 합니다.\n", total);

			differencePayment(total);
		} else {

			System.out.println("=====================================");
			System.out.printf("#  %d원을 지불하셨습니다. 거스름돈은 %d원 입니다.\n", difference, difference - (total - cash));
			System.out.println("#  계산이 완료되었습니다. 안녕히 가세요.");
			System.out.println("#  프로그램이 종료되었습니다.");
		}
	}

	public void paymentOnCard() {
		//카드결제
		System.out.println("=====================================");

		System.out.println("#  할부 필요하신가요?(y/n)");
		System.out.printf("#  선택 -> ");

		String isNeedInstallment = scan.next();

		switch (isNeedInstallment) {
		case "y":

			installment();
			break;
		case "n":

			System.out.println("=====================================");
			System.out.println("#  일시불결제하겠습니다.");

			NeedRecipt();
			break;
		default:

			System.out.println("=====================================");
			System.out.println("#  범위를 벗어났습니다. 프로그램을 종료합니다.");

			System.exit(0);
			break;

		}
	}

	public void NeedRecipt() {
		//영수증출력
		System.out.println("=====================================");

		System.out.println("#  영수증 필요하신가요?(y/n)");
		System.out.printf("#  선택 -> ");

		String isNeedRecipt = scan.next();

		switch (isNeedRecipt) {
		case "y":

			System.out.println("=====================================");
			System.out.println("#  영수증 발급이 완료되었습니다.안녕히 가세요.");
			break;
		case "n":

			System.out.println("=====================================");
			System.out.println("#  계산이 완료되었습니다.안녕히 가세요.");
			break;
		default:

			System.out.println("=====================================");
			System.out.println("#  범위를 벗어났습니다. 프로그램을 종료합니다.");

			System.exit(0);
			break;
		}
	}

	public void installment() {
		//할부결제
		System.out.println("=====================================");

		System.out.println("#  몇개월 필요하신가요? 1~3개월까지 됩니다.");
		System.out.printf("#  선택 -> ");

		String installment = scan.next();

		switch (installment) {
		case "1":

			System.out.println("=====================================");
			System.out.println("#  1개월할부입니다.");
			NeedRecipt();
			break;
		case "2":

			System.out.println("=====================================");
			System.out.println("#  2개월할부입니다.");
			NeedRecipt();
			break;
		case "3":

			System.out.println("=====================================");
			System.out.println("#  3개월할부입니다.");
			NeedRecipt();
			break;
		default:

			System.out.println("=====================================");
			System.out.println("#  범위를 벗어났습니다. 프로그램을 종료합니다.");

			System.exit(0);
			break;
		}
	}
}