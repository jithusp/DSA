package com.griddynamics.testing.gd;
public class ManualCalling {
    public static void main(String[] args) {
            UserService service = new UserService(null);
            String msg = service.greet(1L);
            System.out.println(msg);
    }
}
