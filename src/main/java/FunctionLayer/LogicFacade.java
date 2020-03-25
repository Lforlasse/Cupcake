package FunctionLayer;

import DBAccess.BottomMapper;
import DBAccess.ToppingMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "20");
        UserMapper.createUser( user );
        return user;
    }

    public static ArrayList<Topping> getAllToppings(){
        return ToppingMapper.getAllToppings();
    }

    public static ArrayList<Bottom> getAllBottoms(){
        return BottomMapper.getAllBottoms();
    }
}
