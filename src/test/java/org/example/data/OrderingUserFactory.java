package org.example.data;

import Model.UserType;

public class OrderingUserFactory {

    public static OrderingUser get(OrderingUserType orderingUserType){
        return switch (orderingUserType) {
            case USER_TYPE1 -> new OrderingUser(
                    "Istvan",
                    "Nagy",
                    "asdsad@asdas.as",
                    new Address(
                            "asd",
                            "asd",
                            "asd",
                            Country.HUNGARY,
                            "4354")
            );

            case USER_TYPE2 -> new OrderingUser(
                    "Asd22",
                    "NaEgy",
                    "asdSsad@asdas.as",
                    new Address(
                            "as2d",
                            "a4sd",
                            "as4d",
                            Country.HUNGARY,
                            "43524")
            );
        };
    }

}
