package com.greglturnquist.payroll;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void employeeConstructorTest(){
        //Arrange
        String firstName="Jose";
        String lastName="Joaquim";
        String description="Presidente da Junta";
        int jobYears=4;
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears);
        //Assert
        assertNotNull(employee);
    }
    @Test
    void employeeConstructor_throwsIllegalArgumentExceptionIfFirstNameNull(){
        //Arrange
        String firstName=null;
        String lastName="Joaquim";
        String description="Presidente da Junta";
        int jobYears=4;
        String expected = "Please insert valid Parameters";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Employee (firstName,lastName,description,jobYears));
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }

    @Test
    void employeeConstructor_throwsIllegalArgumentExceptionIfLastNameNull(){
        //Arrange
        String firstName="Jose";
        String lastName=null;
        String description="Presidente da Junta";
        int jobYears=4;
        String expected = "Please insert valid Parameters";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Employee (firstName,lastName,description,jobYears));
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }
    @Test
    void employeeConstructor_throwsIllegalArgumentExceptionIfDescriptionNull(){
        //Arrange
        String firstName="Jose";
        String lastName="Joaquim";
        String description=null;
        int jobYears=4;
        String expected = "Please insert valid Parameters";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Employee (firstName,lastName,description,jobYears));
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }
    @Test
    void employeeConstructor_throwsIllegalArgumentExceptionIfJobYearsNegative(){
        //Arrange
        String firstName="Jose";
        String lastName="Joaquim";
        String description="Presidente da Junta";
        int jobYears=-1;
        String expected = "Please insert valid Parameters";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Employee (firstName,lastName,description,jobYears));
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }
    @Test
    void firstNameGetterTest(){
        //Arrange
        String firstName="Jose";
        String lastName="Joaquim";
        String description="Presidente da Junta";
        int jobYears=4;
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears);
        String result = employee.getFirstName();
        //Assert
        assertEquals(firstName,result);
    }
    @Test
    void lastNameGetterTest(){
        //Arrange
        String firstName="Jose";
        String lastName="Joaquim";
        String description="Presidente da Junta";
        int jobYears=4;
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears);
        String result = employee.getLastName();
        //Assert
        assertEquals(lastName,result);
    }
    @Test
    void descriptionGetterTest(){
        //Arrange
        String firstName="Jose";
        String lastName="Joaquim";
        String description="Presidente da Junta";
        int jobYears=4;
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears);
        String result = employee.getDescription();
        //Assert
        assertEquals(description,result);
    }
    @Test
    void jobYearsGetterTest(){
        //Arrange
        String firstName="Jose";
        String lastName="Joaquim";
        String description="Presidente da Junta";
        int jobYears=4;
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears);
        int result = employee.getJobYears();
        //Assert
        assertEquals(jobYears,result);
    }
    @Test
    void jobYearsSetterTest(){
        //Arrange
        String firstName="Jose";
        String lastName="Joaquim";
        String description="Presidente da Junta";
        int jobYears=4;
        int newJobYears=5;
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears);
        employee.setJobYears(newJobYears);
        int result = employee.getJobYears();
        //Assert
        assertEquals(newJobYears,result);
    }
    @Test
    void firstNameSetterTest(){
        //Arrange
        String firstName="Jose";
        String lastName="Joaquim";
        String description="Presidente da Junta";
        int jobYears=4;
        String newFirstName="Antonio";
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears);
        employee.setFirstName(newFirstName);
        String result = employee.getFirstName();
        //Assert
        assertEquals(newFirstName,result);
    }
    @Test
    void lastNameSetterTest(){
        //Arrange
        String firstName="Jose";
        String lastName="Joaquim";
        String description="Presidente da Junta";
        int jobYears=4;
        String newLastName="Antonio";
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears);
        employee.setLastName(newLastName);
        String result = employee.getLastName();
        //Assert
        assertEquals(newLastName,result);
    }
    @Test
    void descriptionSetterTest(){
        //Arrange
        String firstName="Jose";
        String lastName="Joaquim";
        String description="Presidente da Junta";
        int jobYears=4;
        String newDescription="Presidente da Camara";
        //Act
        Employee employee = new Employee(firstName,lastName,description,jobYears);
        employee.setDescription(newDescription);
        String result = employee.getDescription();
        //Assert
        assertEquals(newDescription,result);
    }
}