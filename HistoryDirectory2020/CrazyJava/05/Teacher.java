/***********************************************************************
 * Module:  Teacher.java
 * Author:  Caiye
 * Purpose: Defines the Class Teacher
 ***********************************************************************/

/** @pdOid 8a6bed6e-d8ed-45c9-8f8f-7ac569bc324b */
public class Teacher extends Person {
   /** @pdOid 634e916f-83f0-4b90-8b17-3c4d1eeae51a */
   private School workSch;
   /** @pdOid def79609-e121-4aec-bdd7-161dc170f57b */
   private int atClass;
   /** @pdOid 6022bef2-81b9-4e9e-9ed9-f52cf24cb7e9 */
   private int atGrade;
   /** @pdOid 52a4431f-4f7f-424d-b65d-65647446978f */
   private String schPost;
   /** @pdOid ef028dbb-0842-4ff8-a187-09b409ac866f */
   private String course;
   /** @pdOid f8ceca6b-a67c-4f6d-a47e-862df63c2aa2 */
   private ClassTeacher classPost;
   
   /** @pdRoleInfo migr=no name=School assc=属于 coll=java.util.Collection impl=java.util.HashSet mult=1..1 type=Aggregation */
   public School school;
   
   /** @param a
    * @pdOid c2a68866-93ce-40ec-ae94-cde3130b892e */
   public void setClassTeacher(ClassTeacher a) {
      // TODO: implement
   }

}