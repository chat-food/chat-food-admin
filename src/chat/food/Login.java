/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.food;

/**
 *
 * @author leotecco
 */
public class Login {
    private static Restaurante restaurante;
    
    public static void setInstance(Restaurante r) {
        restaurante = r;
    }
    
    public static Restaurante getInstance() {
        return restaurante;
    }
}
