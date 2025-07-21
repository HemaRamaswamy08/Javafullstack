package com.dyashin.jdbcmaven.usermanagement;

import org.junit.jupiter.api.Test;

import com.dyashin.jdbcmaven.usermanagement.exception.DuplicateIdException;
import com.dyashin.jdbcmaven.usermanagement.exception.InvalidPasswordException;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

	UserService service = new UserService();

	@Test
	void testAdditionUsingAssertEquals() {
		assertEquals(5, service.add(2, 3), "Addition failed");
	}

	@Test
	void testDivisionUsingAssertNotEquals() {
		assertNotEquals(0, service.divide(12, 15), "Division should not be zero");
	}

	@Test
	void testEmailContainsAtUsingAssertTrue() {
		User user = service.register("Priya", "priya@gmail.com");
		assertTrue(user.getEmail().contains("@"), "Email should contain '@'");
	}

	@Test
	void testAddressNotEmptyUsingAssertFalse() {
		User user = service.register("Priya", "priya@gmail.com");
		user.setAddress("Bangalore");
		assertFalse(user.getAddress().isEmpty(), "Address should not be empty");
	}

	@Test
	void testAddressInitiallyNullUsingAssertNull() {
		User u2 = new User(2, "Ravi", "ravi@gmail.com");
		assertNull(u2.getAddress(), "Address should be null initially");
	}

	@Test
	void testEmailNotNullUsingAssertNotNull() {
		User user = service.register("Priya", "priya8@gmail.com");
		assertNotNull(user.getEmail(), "Email should not be null");
	}
	
	@Test
	void testRegisterThrowsExceptionUsingAssertThrows() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> {
			service.register("Test", null);
		});
		assertEquals("Email is required", ex.getMessage());
	}
	@Test
	void testPasswordNotNullUsingAssertNotNull() {
		User user = service.register("hema", "priya8@gmail.com", "hema#46hek");
		assertNotNull(user.getPassword(), "Password should not be null");
	}
	@Test
	void testRegisterThrowsExceptionUsingAssertThrowsInvalidPasswordException() {
		Exception ex = assertThrows(InvalidPasswordException.class,() -> {
			service.register("Test", "priya@gmail.com",null);
		});
		assertEquals("Password is required", ex.getMessage());
	}
	
	@Test
	void testDuplicateIdThrowsException() {
		service.register("priya", "priya@gmail.com");
		User use = new User(1, "hema","hema@gmail.com");
		Exception ex = assertThrows(DuplicateIdException.class, ()->{
			UserService.checkId(use);
			
		});
		assertEquals("ID already present", ex.getMessage());
	}


	@Test
	void testUserInfoUsingAssertAll() {
		User user = service.register("Priya", "priya@gmail.com");

		assertAll("User Info", () -> assertEquals("Priya", user.getName()),
				() -> assertEquals("priya@gmail.com", user.getEmail()),
				() -> assertTrue(user.getId() > 0, "User ID should be positive"));
	}
	

	@Test
	void testReferenceEqualityUsingAssertSame() {
		User user = service.register("Priya", "priya@gmail.com");
		User sameRef = user;
		assertSame(user, sameRef, "References should match");
	}

	@Test
	void testReferenceInequalityUsingAssertNotSame() {
		User user = service.register("Priya", "priya@gmail.com");
		User anotherUser = new User(3, "Raj", "raj@gmail.com");
		assertNotSame(user, anotherUser, "Different objects should not be the same");
	}

	@Test
	void testFailConditionForNegativeUserId() {
		User user = service.register("Priya", "priya@gmail.com");
		if (user.getId() < 0) {
			fail("User ID should not be negative");
		}
	}

	@Test
	void testFailConditionForEmail() {
		User user = service.register("hema", "hema@gmail.com", "adfr456g");
		assertTrue(user.getPassword().length() > 5, "password must be atleast 5 characters");

	}
}
