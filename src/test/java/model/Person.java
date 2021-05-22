package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter @AllArgsConstructor
@Data
public class Person {
    private final String lastName;
    private final String firstName;
    private final String email;
    private final String website;
    private final float due;
}