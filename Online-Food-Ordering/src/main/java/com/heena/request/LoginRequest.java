package com.heena.request;

import lombok.Data;
import org.apache.catalina.authenticator.SavedRequest;

@Data
public class LoginRequest {
    private String Email;
    private String  Password;

}
