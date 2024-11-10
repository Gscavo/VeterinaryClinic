/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gscavo.veterinaryclinic.model.abstractions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person  {
    
    private ObjectId id;
    
    private String name;

    private String password;
    
    private String cpf;
    
    private String phoneNumber;
    
    private String email;
    
    private ObjectId address;

    public abstract PersonType getType();
}
