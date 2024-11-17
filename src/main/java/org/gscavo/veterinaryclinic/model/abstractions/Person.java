/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gscavo.veterinaryclinic.model.abstractions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

import static org.gscavo.veterinaryclinic.utils.ConversionUtils.getNullableDocumentObjectId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person implements BaseModel<Person>  {
    @JsonIgnore
    private ObjectId id;

    private String name;

    private String password;

    private String cpf;

    private String phoneNumber;

    private String email;

    private ObjectId address;

    private PersonType type;


    public Person(Document document) {
        this.id = document.getObjectId("_id");
        this.name = document.getString("name");
        this.cpf = document.getString("cpf");
        this.email = document.getString("email");
        this.password = document.getString("password");
        this.phoneNumber = document.getString("phoneNumber");
        this.address = getNullableDocumentObjectId(document, "address");
        this.type = PersonType.getByName(document.getString("type"));

    }
}
