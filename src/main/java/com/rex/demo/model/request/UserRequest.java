package com.rex.demo.model.request;

import javax.validation.constraints.NotBlank;

/**
 * 使用者請求封裝類(VO)
 *
 * @author rex
 */
public class UserRequest {

    @NotBlank(message = "account cannot be blank")
    private String account;
    @NotBlank(message = "password cannot be blank")
    private String password;
    @NotBlank(message = "username cannot be blank")
    private String username;
    private String address;
    private String phoneNumber;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
