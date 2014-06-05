/***********************************************************************
 * Module:  Person.java
 * Author:  Caiye
 * Purpose: Defines the Class Person
 ***********************************************************************/

import java.util.*;

/** @pdOid 0621b7c9-b341-45de-a7b5-ef531c1f876f */
public class Person {
   /** @pdOid 6230223b-9e1f-4677-be18-bc0dc7f5de95 */
   private int ID;
   /** @pdOid 26d66f53-5592-44f6-806e-6e3eb76e6dc0 */
   private String name;
   /** @pdOid 087c569f-ca3f-4b53-8706-4ea3566742d0 */
   private int age;
   /** @pdOid 0de33148-5a7d-44a8-9a56-e311faf7a575 */
   private char sex;
   /** @pdOid fdd1f979-4574-4e7e-9e6e-7db5c6dbdb07 */
   private String adress;
   
   /** @param id 
    * @param name 
    * @param age 
    * @param sex 
    * @param adress
    * @pdOid cbe8526d-677f-482b-a0b6-6a990a691053 */
   public void person(int id, String name, int age, char sex, String adress) 
   {
		this.ID = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.adress = adress;
      // TODO: implement
   }

}