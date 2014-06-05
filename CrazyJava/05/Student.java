/***********************************************************************
 * Module:  Student.java
 * Author:  Caiye
 * Purpose: Defines the Class Student
 ***********************************************************************/

import java.util.*;

/** @pdOid febee1aa-7c5f-4105-8557-62a5d91bc0e7 */
public class Student extends Person {
   /** @pdOid b207c77b-667b-47c0-b447-2cdadf39ae90 */
   private int stuNum;
   /** @pdOid ed94b644-acb5-45db-8df5-51ae11b46ebe */
   private School stuSchool;
   /** @pdOid feb88b44-5be0-4f12-8e67-a72486bdaf5d */
   private int grade;
   /** @pdOid 6fdca8a3-3ebe-4134-9760-babb68d6c39d */
   private int class;
   /** @pdOid 04e7ce34-501b-4a8f-8500-534d8471519e */
   private String stuPost;
   
   /** @pdRoleInfo migr=no name=School assc=Association_2 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<School> school;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<School> getSchool() {
      if (school == null)
         school = new java.util.HashSet<School>();
      return school;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSchool() {
      if (school == null)
         school = new java.util.HashSet<School>();
      return school.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSchool */
   public void setSchool(java.util.Collection<School> newSchool) {
      removeAllSchool();
      for (java.util.Iterator iter = newSchool.iterator(); iter.hasNext();)
         addSchool((School)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSchool */
   public void addSchool(School newSchool) {
      if (newSchool == null)
         return;
      if (this.school == null)
         this.school = new java.util.HashSet<School>();
      if (!this.school.contains(newSchool))
         this.school.add(newSchool);
   }
   
   /** @pdGenerated default remove
     * @param oldSchool */
   public void removeSchool(School oldSchool) {
      if (oldSchool == null)
         return;
      if (this.school != null)
         if (this.school.contains(oldSchool))
            this.school.remove(oldSchool);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSchool() {
      if (school != null)
         school.clear();
   }

}