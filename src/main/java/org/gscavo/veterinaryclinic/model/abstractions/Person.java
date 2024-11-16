/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gscavo.veterinaryclinic.model.abstractions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

import static org.gscavo.veterinaryclinic.utils.ConversionUtils.getNullableDocumentObjectId;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person  {

    @BsonId
    private ObjectId id;

    @BsonProperty("name")
    private String name;

    @BsonProperty("password")
    private String password;

    @BsonProperty("cpf")
    private String cpf;

    @BsonProperty("phoneNumber")
    private String phoneNumber;

    @BsonProperty("email")
    private String email;

    @BsonProperty("address")
    private ObjectId address;

    @BsonProperty("type")
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
