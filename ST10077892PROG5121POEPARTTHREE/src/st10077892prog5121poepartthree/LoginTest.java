package st10077892prog5121poepartthree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LoginTest {

    private Login login;

    @Before
    public void setUp() {
        login = new Login();
    }

    @Test
    public void testCheckUserName() {
        assertTrue(login.checkUserName("kyl_1"));
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testRegisterUserSuccess() {
        assertEquals("Username and password successfully captured", login.registerUser("kyl_1", "Ch&&sec@ke99!", "John", "Doe"));
    }

    @Test
    public void testRegisterUserInvalidUsername() {
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "John", "Doe"));
    }

    @Test
    public void testRegisterUserInvalidPassword() {
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", login.registerUser("kyl_1", "password", "John", "Doe"));
    }

    @Test
    public void testLoginUserSuccess() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginUserFailure() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        assertFalse(login.loginUser("kyl_1", "wrongPassword"));
    }
}
