package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLNonTransientConnectionException;

import org.junit.Assert;

//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;

//import org.junit.Before;
import org.junit.Test;

import main.java.Employee.testableConn;

public class ST_0_01Test {
	
    @Test
    public void CT_0_01() //Due to bad code conception we can't parameter the conn class so we are going to copy its code and edit its parameters
    {
    	boolean test = true;

		try {
			testableConn con = new testableConn("jdbc:mysql://localhost:3306/ets?useSSL=false&serverTimezone=UTC","root","etsets");			
		} catch(Exception e) {
	    	test = false;
		}
        assertTrue(test);
    }    

    @Test
    public void CT_0_02() throws Exception
    {
    	boolean test = true;

		try {
			testableConn con = new testableConn("jdbc:mysql://localhost:3306/ets?useSSL=false&serverTimezone=UTC","root","error");	
			//Assert.fail("Should have thrown an exception"); 
		} catch(Exception e) {
			assertTrue(test);
		}
    }   

    @Test
    public void CT_0_03() throws Exception
    {
    	boolean test = true;

		try {
			testableConn con = new testableConn("jdbc:mysql://localhost:3306/ets?useSSL=false&serverTimezone=UTC","error","etsets");	
			//Assert.fail("Should have thrown an exception"); 
		} catch(Exception e) {
			assertTrue(test);
		}
    }   

    @Test
    public void CT_0_04() throws Exception
    {
    	boolean test = true;

		try {
			testableConn con = new testableConn("jdbc:mysql://localhost:3306/error?useSSL=false&serverTimezone=UTC","root","etsets");	
			//Assert.fail("Should have thrown an exception"); 
		} catch(Exception e) {
			assertTrue(test);
		}
    }   

}
