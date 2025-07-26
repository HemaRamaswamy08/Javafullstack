package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import dto.FoodMenuDTO;
import util.DBUtil;

public class FoodMenuDetailsImpl implements FoodMenuDetailsDAO {

	static Connection con = null;
	static {
		try {
			con = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void menuDetails() {
		Scanner sc = new Scanner("System.in");

		System.out.println("Enter choice");
		String ch = sc.next();
		if (ch.equals("A")) {
			FoodMenuDetailsImpl.display();
		} else if (ch.equals("B")) {
			FoodMenuDetailsImpl.randomlyFood();
		} else if (ch.equals("C")) {
			String foodName = sc.next();
			FoodMenuDetailsImpl.particularFood(foodName);
		}

	}

	@Override
	public void searchFood() {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();

		String queru = "select * from food_menu ";
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(queru);

			while (res.next()) {
				int foodId = res.getInt("food_id");
				String foodName = res.getString("food_name");
				String foodType = res.getString("food_type");
				String description = res.getString("description");
				int foodCost = res.getInt("food_cost");
				String quantity = res.getString("quantity");
				FoodMenuDTO food = new FoodMenuDTO(foodId, foodName, foodType, description, foodCost, quantity);

				if (food.getFoodName().matches(name)) {
					System.out.println(food);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void showAll() {
		FoodMenuDetailsImpl.display();

	}

	@Override
	public void menuOperatation() {
		System.out.println("A .Create");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter choice");
		String ch = sc.next();
		if (ch.equals("A")) {
			int foodId = sc.nextInt();
			String foodName = sc.next();
			String foodType = sc.next();
			String description = sc.next();
			int food_cost = sc.nextInt();
			String quantity = sc.next();
			FoodMenuDetailsImpl.addFood(foodId, foodName, foodType, description, food_cost, quantity);
		} else if (ch.equals("B")) {
			System.out.println("Enter ID ");
			int num = sc.nextInt();
			System.out.println("Enter id");
			System.out.println("Enter new Food name");
			String name = sc.next();
			FoodMenuDetailsImpl.editInfo(num,name);
		} else if (ch.equals("C")) {
			FoodMenuDetailsImpl.deleteInfo();
		}

	}

	public static void addFood(int foodId, String foodName, String foodType, String description, int food_cost,
			String quantity) {
		String queru = "insert into food_menu values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(queru);
			stmt.setInt(1, foodId);
			stmt.setString(2, foodName);
			stmt.setString(3, foodType);
			stmt.setString(4, description);
			stmt.setInt(5, food_cost);
			stmt.setString(6, quantity);
			int res = stmt.executeUpdate(queru);

			if (res > 0) {
				System.out.println("sucessfully added");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void display() {
		String queru = "select * from food_menu";
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(queru);

			while (res.next()) {
				int foodId = res.getInt("food_id");
				String foodName = res.getString("food_name");
				String foodType = res.getString("food_type");
				String description = res.getString("description");

				int foodCost = res.getInt("food_cost");
				String quantity = res.getString("quantity");
				FoodMenuDTO food = new FoodMenuDTO(foodId, foodName, foodType, description, foodCost, quantity);
				System.out.println(food);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void randomlyFood() {
		Queue<FoodMenuDTO> foodRandom = new PriorityQueue<FoodMenuDTO>();
		String queru = "select * from food_menu";
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(queru);

			while (res.next()) {
				int foodId = res.getInt("food_id");
				String foodName = res.getString("food_name");
				String foodType = res.getString("food_type");
				String description = res.getString("description");

				int foodCost = res.getInt("food_cost");
				String quantity = res.getString("quantity");
				FoodMenuDTO food = new FoodMenuDTO(foodId, foodName, foodType, description, foodCost, quantity);

				foodRandom.add(food);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (FoodMenuDTO foodMenuDTO : foodRandom) {
			System.out.println(foodMenuDTO);
		}

	}

	public static FoodMenuDTO particularFood(String name) {
		String queru = "select * from food_menu where food_name=?";
		try {
			PreparedStatement stmt = con.prepareStatement(queru);
			stmt.setString(1, name);
			ResultSet res = stmt.executeQuery(queru);

			if (res.getString("food_name").equals(name)) {
				int foodId = res.getInt("food_id");
				String foodName = res.getString("food_name");
				String foodType = res.getString("food_type");
				String description = res.getString("description");
				int foodCost = res.getInt("food_cost");
				String quantity = res.getString("quantity");
				FoodMenuDTO food = new FoodMenuDTO(foodId, foodName, foodType, description, foodCost, quantity);
				return food;
			} else {
				System.out.println("No Food");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void editInfo(int num ,String name) {
		String queru = "update food_menu where  food_id=? set food_name = ?";

		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(queru);
			stmt.setInt(1, num);
			stmt.setString(2, name);
			int res = stmt.executeUpdate(queru);
			
			if(res>0) {
				System.out.println("Sucess");
			}else {
				System.out.println("Failuer");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void deleteInfo() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id to delete");
		int id = sc.nextInt();

		String query = "delete from food_menu where food_id = ?";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			int res = stmt.executeUpdate(query);
			if (res > 0) {
				System.out.println("Sucesfullu deleted");
			} else {
				System.out.println("Failed to delete");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
