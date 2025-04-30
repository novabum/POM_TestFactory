package Model;

public class MyUserFactory {

    public static MyUser get(UserType userType){
        return switch (userType){
            case VALID -> new MyUser("practiceUser", "practicePassword");
            case INVALID_PASSWORD -> new MyUser("practiceUser", "safgoaisg");
            case INVALID_USERNAME -> new MyUser("asdadasd", "practicePassword");
            case VALID_ADMIN -> new MyUser("admin", "adminPass");
        };

    }

}
