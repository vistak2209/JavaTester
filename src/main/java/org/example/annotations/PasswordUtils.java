package org.example.annotations;

import java.util.List;

public class PasswordUtils {
    @UseCase( id= 47 ,description = "Just validatePassword")
    public boolean validatePassword(String  password){
        return (password.matches("\\*\\d\\w*"));
    }
    @UseCase( id= 48 ,description = "Just encryptPassword")
    public String encryptPassword(String password){
        return new StringBuffer(password).reverse().toString();
    }
    @UseCase( id= 49 ,description = "Just checkForNewPassword")
    public boolean checkForNewPassword(List<String> prevPasswords, String password){
        return !prevPasswords.contains(password);
    }
}
