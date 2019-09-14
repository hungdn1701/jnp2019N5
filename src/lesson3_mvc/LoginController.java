/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3_mvc;

/**
 *
 * @author mam
 */
public class LoginController {
   LoginModel user;

    public LoginController() {
        new LoginView();
    }

    public LoginController(LoginModel user) {
        this.user = user;
        new LoginView(user);
    }
    public LoginController(String _strUser, String _strPass) {
       System.out.println("xxx");
        if(_strUser.equals("admin") && _strPass.equals("abc123"))
            this.user = new LoginModel(_strUser, _strPass);
        if(user!=null)
            new LoginView(user);
        else
            new LoginView();
    }
    
}
