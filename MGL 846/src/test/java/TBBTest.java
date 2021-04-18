package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import java.sql.SQLNonTransientConnectionException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;

//import org.junit.Before;
import org.junit.Test;

import main.java.Employee.add_employee;
import main.java.Employee.details_page;
import main.java.Employee.print_data;
import main.java.Employee.remove_employee;
import main.java.Employee.search_employee;
import main.java.Employee.testableConn;
import main.java.Employee.view_employee;

public class TBBTest {
	
	public static details_page page;
	public static ActionEvent ae;
	
	@BeforeClass
	public static void setUp()
	{
		page = new details_page();
		
	}
	
    @Test
    public void TBB_01() 
    {
    	ae = new ActionEvent(page.getB1(), 1001, "Submit");
		
    	assertEquals(new add_employee().getClass(), page.actionPerformed(ae, true).getClass());
    }    

    @Test
    public void TBB_02() 
    {
    	ae = new ActionEvent(page.getB2(), 1001, "Submit");
		
    	assertEquals(new view_employee().getClass(), page.actionPerformed(ae, true).getClass());
    }    

    @Test
    public void TBB_03() 
    {
    	ae = new ActionEvent(page.getB3(), 1001, "Submit");
		
    	assertEquals(new remove_employee().getClass(), page.actionPerformed(ae, true).getClass());
    }    

    @Test
    public void TBB_04() 
    {
    	ae = new ActionEvent(page.getB4(), 1001, "Submit");
		
    	assertEquals(new search_employee().getClass(), page.actionPerformed(ae, true).getClass());
    }    
}
