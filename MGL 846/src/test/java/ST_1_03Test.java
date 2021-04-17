package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import java.sql.SQLNonTransientConnectionException;

import org.junit.Assert;
import org.junit.BeforeClass;

//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;

//import org.junit.Before;
import org.junit.Test;

import main.java.Employee.update_employee;
import main.java.Employee.testableConn;

public class ST_1_03Test {
	
	public static update_employee page;
	public static ActionEvent ae;
	
	@BeforeClass
	public static void setUp()
	{
		page = new update_employee("1000");
		ae = new ActionEvent(page.getB(), 1001, "Submit");
		
		page.getT1().setText("John");
		page.getT2().setText("Wick");
		page.getT3().setText("30");
		page.getT4().setText("1995/03/24");
		page.getT5().setText("32 rue de la grange");
		page.getT6().setText("0666007666");
		page.getT7().setText("johnattan@mail.com");
		page.getT8().setText("graduate");
		page.getT9().setText("mercenary");
		page.getT10().setText("666666666");
		page.getT11().setText("1002");
	}
	
    @Test
    public void CT_1_01_2() 
    {
    	boolean test = true;
    	
		try
		{
			page.actionPerformed(ae, true);
		} finally {
			//Reste à vérifier côté DB si l'enregistrement a été save
	    	assertTrue(test);
		}
    }    

    @Test
    public void CT_1_02_2() throws Exception
    {
		page.getT3().setText("erreur");
		page.getT6().setText("erreur");
		page.getT10().setText("erreur");
		page.getT11().setText("erreur");
    	boolean test = false;
    	
		try
		{
			page.actionPerformed(ae, true);
		}
		catch(Exception e)
		{
			test = true;
		}
		assertTrue(test);
    }   

    @Test
    public void CT_1_03_2() throws Exception
    {
		page.getT1().setText("66666");
		page.getT2().setText("66666");
		page.getT8().setText("66666");
		page.getT9().setText("66666");
		
    	boolean test = false;
    	
		try
		{
			page.actionPerformed(ae, true);
		}
		catch(Exception e)
		{
			test = true;
		}
		assertTrue(test);
    }   

    @Test
    public void CT_1_04_2() throws Exception
    {
		page.getT1().setText("***");
		page.getT2().setText("***");
		page.getT3().setText("***");
		page.getT4().setText("***");
		page.getT5().setText("***");
		page.getT6().setText("***");
		page.getT8().setText("***");
		page.getT9().setText("***");
		page.getT10().setText("***");
		page.getT11().setText("***");

    	boolean test = false;
    	
		try
		{
			page.actionPerformed(ae, true);
		}
		catch(Exception e)
		{
			test = true;
		}
		assertTrue(test);
    }   
    

    @Test
    public void CT_1_05_2() throws Exception
    {
		page.getT1().setText("");
		page.getT2().setText("");
		page.getT3().setText("");
		page.getT4().setText("");
		page.getT5().setText("");
		page.getT6().setText("");
		page.getT8().setText("");
		page.getT9().setText("");
		page.getT10().setText("");
		page.getT11().setText("");

    	boolean test = false;
    	
		try
		{
			page.actionPerformed(ae, true);
		}
		catch(Exception e)
		{
			test = true;
		}
		assertTrue(test);
    }   

    @Test
    public void CT_1_06_2() throws Exception
    {
		page.getT7().setText("@@@");
		

    	boolean test = false;
    	
		try
		{
			page.actionPerformed(ae, true);
		}
		catch(Exception e)
		{
			test = true;
		}
		assertTrue(test);
    }   

    @Test
    public void CT_1_07_2() throws Exception
    {
		page.getT11().setText("1000");
		

    	boolean test = false;
    	
		try
		{
			page.actionPerformed(ae, true);
		}
		catch(Exception e)
		{
			test = true;
		}
		assertTrue(test);
    }   

}
