package com.example.api_gateway.util;

public class UserContext {
    private UserContext() {
    }
    private static final ThreadLocal<Long> USER_ID = new ThreadLocal<>();
    private static final ThreadLocal<String> ROLE = new ThreadLocal<>();
    public static void setUserId(Long id) {
        USER_ID.set(id);
    }
    public static Long getUserId() {
        return USER_ID.get();
    }
    public static void setUserRole(String role) {
        ROLE.set(role);
    }
    public static String getUserRole() {
        return ROLE.get();
    }
    public static void clear() {
        USER_ID.remove();
    }
    public static void clearRole() {
        ROLE.remove();
    }
}
