/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MY PHU NGUYEN
 */
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

public class test {
   public static void main(String[] args) throws JAXBException {
      //Create a student object
      Student student = new Student("Minh",18, Gender.Male);

      //fill details of the student

 
         //create JAXBElement of type Student
         //Pass it the student object
        JAXBElement<Student> jaxbElement =  new JAXBElement( 
            new QName(Student.class.getSimpleName()), Student.class, student);

         //Create a String writer object which will be 
         //used to write jaxbElment XML to string
         StringWriter writer = new StringWriter();

         // create JAXBContext which will be used to update writer 		
         JAXBContext context = JAXBContext.newInstance(Student.class);

         // marshall or convert jaxbElement containing student to xml format
         context.createMarshaller().marshal(jaxbElement, writer);
          System.out.println( writer.toString());
         StringReader sr = new StringReader(writer.toString());
         
         Student aStudent=    JAXB.unmarshal(sr, Student.class);
         Student anotherStudent= new Student("Dat",12,Gender.Female);
         
         System.out.println(aStudent);
         System.out.println(Student.getStudentNumber());
      
   }
}
