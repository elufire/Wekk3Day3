package com.example.wekk3day3;

import com.example.wekk3day3.user.UserResponse;

public class UserEvent {
    private UserResponse userResponse;

    public UserEvent(UserResponse userResponse) {
        this.userResponse = userResponse;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
