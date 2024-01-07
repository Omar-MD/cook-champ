package com.cooklikeachampion.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterBeanTest {

    private RegisterBean registerBean;

    @BeforeEach
    public void setUp() {
        registerBean = new RegisterBean();
    }

    @Test
    public void testValidInputValid() {
        registerBean.setName("John Doe");
        registerBean.setEmail("test@example.com");
        registerBean.setPassword("securePass");
        registerBean.setConfirmPassword("securePass");

        assertEquals(true, registerBean.validInput());
    }

    @Test
    public void testValidInputShortPassword() {
        registerBean.setName("Alice Johnson");
        registerBean.setEmail("alice@example.com");
        registerBean.setPassword("short");
        registerBean.setConfirmPassword("short");

        assertEquals(true, registerBean.validInput());
    }
    
    @Test
    public void testValidEmailValid() {
        assertEquals(true, registerBean.validEmail("test@example.com"));
    }

    @Test
    public void testValidEmailInvalid() {
        assertEquals(false, registerBean.validEmail("invalid-email"));
    }
    
    @Test
    public void testGetName() {
        registerBean.setName("John Doe");
        assertEquals("John Doe", registerBean.getName());
    }

    @Test
    public void testSetName() {
        registerBean.setName("Jane Smith");
        assertEquals("Jane Smith", registerBean.getName());
    }

    @Test
    public void testGetEmail() {
        registerBean.setEmail("test@example.com");
        assertEquals("test@example.com", registerBean.getEmail());
    }

    @Test
    public void testSetEmail() {
        registerBean.setEmail("user@example.com");
        assertEquals("user@example.com", registerBean.getEmail());
    }

    @Test
    public void testGetPassword() {
        registerBean.setPassword("password123");
        assertEquals("password123", registerBean.getPassword());
    }

    @Test
    public void testSetPassword() {
        registerBean.setPassword("securePass");
        assertEquals("securePass", registerBean.getPassword());
    }

    @Test
    public void testGetConfirmPassword() {
        registerBean.setConfirmPassword("password123");
        assertEquals("password123", registerBean.getConfirmPassword());
    }

    @Test
    public void testSetConfirmPassword() {
        registerBean.setConfirmPassword("securePass");
        assertEquals("securePass", registerBean.getConfirmPassword());
    }
}