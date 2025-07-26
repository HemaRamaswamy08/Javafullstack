package dto;

public class FoodMenuDTO {

	private int foodId;
	private String foodName;
	private String foodType;
	private String description;
	private int foodCost;
	private String quantity;

	public FoodMenuDTO(int foodId, String foodName, String foodType, String description, int foodCost, String quantity) {
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodType = foodType;
		this.description = description;
		this.foodCost = foodCost;
		this.quantity = quantity;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFoodCost() {
		return foodCost;
	}

	public void setFoodCost(int foodCost) {
		this.foodCost = foodCost;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
