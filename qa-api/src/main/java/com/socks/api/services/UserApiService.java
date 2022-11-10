package com.socks.api.services;

import com.socks.api.assertions.Assertions;
import com.socks.api.models.UserModel;

public class UserApiService extends ApiService {
 //   @Step
 public Assertions registerUser(UserModel user) {
     return new Assertions(request()
                .body(user)
                .when()
                .post("register"));
    }
}
