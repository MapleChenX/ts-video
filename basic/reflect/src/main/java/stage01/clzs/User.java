package stage01.clzs;

import stage01.annotations.Property;

public class User {

    @Property(name = "username", value = "Hello World!")
    private String username;
    @Property(name = "password", value = "123123")
    private String password;

}
