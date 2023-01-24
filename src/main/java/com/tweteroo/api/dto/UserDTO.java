package com.tweteroo.api.dto;

// import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserDTO {
    @NotNull(message = "O username é um campo obrigatório")
    // @NotBlank
    private String username;
    @NotNull(message = "O avatar é um campo obrigatório")
    // @NotBlank
    private String avatar;
    
    public UserDTO() {
    }

    public UserDTO(String username, String avatar) {
        this.setUsername(username);
        this.setAvatar(avatar);
    }
    /* */
    //setters e getters
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getAvatar() {
        return this.avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
