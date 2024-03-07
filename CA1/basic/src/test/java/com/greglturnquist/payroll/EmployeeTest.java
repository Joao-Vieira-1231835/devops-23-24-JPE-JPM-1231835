package com.greglturnquist.payroll;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void employeeConstructorTest(){
        //Arrange
        String firstName="Vitorino";
        String lastName="Silva";
        String description="Presidente da Junta";
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=4;
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears, eMail);
        //Assert
        assertNotNull(employee);
    }
    @Test
    void employeeConstructor_throwsIllegalArgumentExceptionIfFirstNameNull(){
        //Arrange
        String firstName=null;
        String lastName="Silva";
        String description="Presidente da Junta";
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=4;
        String expected = "Please insert valid Parameters";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Employee (firstName,lastName,description,jobYears, eMail));
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }

    @Test
    void employeeConstructor_throwsIllegalArgumentExceptionIfLastNameNull(){
        //Arrange
        String firstName="Vitorino";
        String lastName=null;
        String description="Presidente da Junta";
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=4;
        String expected = "Please insert valid Parameters";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Employee (firstName,lastName,description,jobYears, eMail));
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }
    @Test
    void employeeConstructor_throwsIllegalArgumentExceptionIfDescriptionNull(){
        //Arrange
        String firstName="Vitorino";
        String lastName="Silva";
        String description=null;
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=4;
        String expected = "Please insert valid Parameters";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Employee (firstName,lastName,description,jobYears, eMail));
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }
    @Test
    void employeeConstructor_throwsIllegalArgumentExceptionIfJobYearsNegative(){
        //Arrange
        String firstName="Vitorino";
        String lastName="Silva";
        String description="Presidente da Junta";
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=-1;
        String expected = "Please insert valid Parameters";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Employee (firstName,lastName,description,jobYears, eMail));
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }
    @Test
    void employeeConstructor_throwsIllegalArgumentExceptionIfEmailNull(){
        //Arrange
        String firstName="Vitorino";
        String lastName="Silva";
        String description="Presidente da Junta";
        String eMail = null;
        int jobYears=4;
        String expected = "Please insert valid Parameters";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Employee (firstName,lastName,description,jobYears, eMail));
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }
    @Test
    void firstNameGetterTest(){
        //Arrange
        String firstName="Vitorino";
        String lastName="Silva";
        String description="Presidente da Junta";
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=4;
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears, eMail);
        String result = employee.getFirstName();
        //Assert
        assertEquals(firstName,result);
    }
    @Test
    void lastNameGetterTest(){
        //Arrange
        String firstName="Vitorino";
        String lastName="Silva";
        String description="Presidente da Junta";
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=4;
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears, eMail);
        String result = employee.getLastName();
        //Assert
        assertEquals(lastName,result);
    }
    @Test
    void descriptionGetterTest(){
        //Arrange
        String firstName="Vitorino";
        String lastName="Silva";
        String description="Presidente da Junta";
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=4;
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears, eMail);
        String result = employee.getDescription();
        //Assert
        assertEquals(description,result);
    }
    @Test
    void jobYearsGetterTest(){
        //Arrange
        String firstName="Vitorino";
        String lastName="Silva";
        String description="Presidente da Junta";
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=4;
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears, eMail);
        int result = employee.getJobYears();
        //Assert
        assertEquals(jobYears,result);
    }
    @Test
    void eMailGetterTest(){
        //Arrange
        String firstName="Vitorino";
        String lastName="Silva";
        String description="Presidente da Junta";
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=4;
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears, eMail);
        String result = employee.getEmail();
        //Assert
        assertEquals(eMail,result);
    }
    @Test
    void jobYearsSetterTest(){
        //Arrange
        String firstName="Vitorino";
        String lastName="Silva";
        String description="Presidente da Junta";
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=4;
        int newJobYears=5;
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears, eMail);
        employee.setJobYears(newJobYears);
        int result = employee.getJobYears();
        //Assert
        assertEquals(newJobYears,result);
    }
    @Test
    void eMailSetterTest(){
        //Arrange
        String firstName="Vitorino";
        String lastName="Silva";
        String description="Presidente da Junta";
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=4;
        String newEmail = "tino@rir.pt";
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears, eMail);
        employee.setEmail(newEmail);
        String result = employee.getEmail();
        //Assert
        assertEquals(newEmail,result);
    }

    @Test
    void firstNameSetterTest(){
        //Arrange
        String firstName="Vitorino";
        String lastName="Silva";
        String description="Presidente da Junta";
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=4;
        String newFirstName="Antonio";
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears, eMail);
        employee.setFirstName(newFirstName);
        String result = employee.getFirstName();
        //Assert
        assertEquals(newFirstName,result);
    }
    @Test
    void lastNameSetterTest(){
        //Arrange
        String firstName="Vitorino";
        String lastName="Silva";
        String description="Presidente da Junta";
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=4;
        String newLastName="Antonio";
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears, eMail);
        employee.setLastName(newLastName);
        String result = employee.getLastName();
        //Assert
        assertEquals(newLastName,result);
    }
    @Test
    void descriptionSetterTest(){
        //Arrange
        String firstName="Vitorino";
        String lastName="Silva";
        String description="Presidente da Junta";
        String eMail = "tinoDeRans@calceteiro.pt";
        int jobYears=4;
        String newDescription="Presidente da Camara";
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears, eMail);
        employee.setDescription(newDescription);
        String result = employee.getDescription();
        //Assert
        assertEquals(newDescription,result);
    }
}