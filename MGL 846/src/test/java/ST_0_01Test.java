import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;



//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;

//import org.junit.Before;
import org.junit.Test;

import main.java.Employee.testableConn;

public class ST_0_01Test {
	
    @Test
    public void CT_0_01() //Due to bad code conception we can't parameter the conn class so we are going to copy its code and edit its parameters
    {
    	testableConn con = new testableConn("jdbc:mysql://localhost:3306/ets?useSSL=false&serverTimezone=UTC","root","etsets");			
    	assertEquals(null, con.getExceptionResult());
    }    

    @Test
    public void CT_0_02() throws Exception
    {
    	testableConn con = new testableConn("jdbc:mysql://localhost:3306/ets?useSSL=false&serverTimezone=UTC","root","error");	
    	assertEquals("Public Key Retrieval is not allowed", con.getExceptionResult());
    }   

    @Test
    public void CT_0_03() throws Exception
    {
    	testableConn con = new testableConn("jdbc:mysql://localhost:3306/ets?useSSL=false&serverTimezone=UTC","error","etsets");	
    	assertEquals("Access denied for user 'error'@'localhost' (using password: YES)", con.getExceptionResult());
    }   

    @Test
    public void CT_0_04()
    {
    	testableConn con = new testableConn("jdbc:mysql://localhost:3306/error?useSSL=false&serverTimezone=UTC","root","etsets");	
    	assertEquals("Unknown database 'error'", con.getExceptionResult());
    }   
   
}
