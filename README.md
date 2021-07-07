# csg
The school attendance api

The csg project

Clone the existing source code

mvn clean install

The install jar is located in \target\csgproject-0.0.1-SNAPSHOT.jar

mvn clean package dependency:copy-dependencies

Copy the csgproject-0.0.1-SNAPSHOT.jar and dependency to server

USE java -jar target/myapplication-0.0.1-SNAPSHOT.jar

OR

java -cp target/myapplication-0.0.1-SNAPSHOT.jar:target/dependency/* za.co.bigsim.CsgprojectApplication.java

DATA INITIAL LOADED Teacher(1, "Judith", "Masuku", "FEMALE", "Mrs."); Teacher(2, "Grace", "Musa", "FEMALE", "Ms."); Teacher(3, "Carlos", "Moyo", "MALE", "Mr."); Teacher(4, "Charles", "Kunut", "MALE", "Mr."); Teacher(5, "Nomsa", "Phiri", "FEMALE", "Mrs.");

Class(1,"IT011", teacher1, "ENGLISH", calndr.get(Calendar.YEAR), "GRADE 1"); Class(2,"IT012", teacher1, "ENGLISH", calndr.get(Calendar.YEAR), "GRADE 2"); Class(3,"IT013", teacher1, "ENGLISH", calndr.get(Calendar.YEAR), "GRADE 3"); Class(4,"IT014", teacher1, "ENGLISH", calndr.get(Calendar.YEAR), "GRADE 4"); Class(5,"IT015", teacher1, "ENGLISH", calndr.get(Calendar.YEAR), "GRADE 5");

Student(clazz1, "Maria", "Mupande", "Female"); Student(clazz1, "Maria1", "Mupande1", "Female"); Student(clazz1, "Maria2", "Mupande2", "Female"); Student(clazz1, "Maria3", "Mupande3", "Female"); Student(clazz2, "Maria4", "Mupande4", "Female"); Student(clazz2, "Maria5", "Mupande5", "Female"); Student(clazz2, "Maria6", "Mupande6", "Female"); Student(clazz2, "Maria7", "Mupande7", "Female"); Student(clazz2, "Maria8", "Mupande8", "Female"); Student(clazz1, "Maria9", "Mupande9", "Female"); Student(clazz1, "Maria10", "Mupande10", "Female"); Student(clazz1, "Maria11", "Mupande11", "Female");
