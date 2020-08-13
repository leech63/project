package foodmall;

public abstract class Food {
	
	protected String categoryName;
	protected String foodName;
	protected int price;
	public Food(String foodName, int price) {
		super();
		this.foodName = foodName;
		this.price = price;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void printDetail(int num) {
		System.out.printf("#  음식명%d : %s, 가격 : %d\n", num + 1, foodName, price);
	};
}
	

