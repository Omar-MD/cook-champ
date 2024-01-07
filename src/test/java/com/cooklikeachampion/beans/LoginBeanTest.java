package com.cooklikeachampion.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginBeanTest {

    private LoginBean loginBean;

    @BeforeEach
    public void setUp() {
        loginBean = new LoginBean();
    }

    @Test
    public void testGetEmail() {
        loginBean.setEmail("test@example.com");
        assertEquals("test@example.com", loginBean.getEmail());
    }

    @Test
    public void testSetEmail() {
        loginBean.setEmail("test@example.com");
        assertEquals("test@example.com", loginBean.getEmail());
    }

    @Test
    public void testGetPassword() {
        loginBean.setPassword("password");
        assertEquals("password", loginBean.getPassword());
    }

    @Test
    public void testSetPassword() {
        loginBean.setPassword("password");
        assertEquals("password", loginBean.getPassword());
    }
}
