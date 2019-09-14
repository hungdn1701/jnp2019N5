/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3_mvc;

import java.util.Scanner;

/**
 *
 * @author mam
 */
public class LoginView {
    LoginModel user;
    String _strUser, _strPass;
    public LoginView() {
        System.out.println(" login form view");
        Scanner input = new Scanner(System.in);
        _strUser = input.nextLine();
        _strPass = input.nextLine();
        new LoginController(_strUser, _strPass);
        System.out.println("ok");
    }

    public LoginView(LoginModel user) {
        this.user = user;
        System.out.println(" Detail Form View");
        System.out.println("user: " + user.getUser());
    }
    
}
