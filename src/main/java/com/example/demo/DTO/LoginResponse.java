package com.example.demo.DTO;

public class LoginResponse {
    private String token;
    private long expiresIn;
    private String email;
    private Long userId;

    public LoginResponse(
            String token,
            long expiresIn,
            String email,
            Long userId
    ) {
        this.token = token;
        this.expiresIn = expiresIn;
        this.email = email;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
    public long getExpiresIn() {
        return expiresIn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
