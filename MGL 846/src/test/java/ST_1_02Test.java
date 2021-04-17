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

import main.java.Employee.add_employee;
import main.java.Employee.remove_employee;
import main.java.Employee.testableConn;

public class ST_1_02Test {
	
	public static remove_employee page;
	public static ActionEvent aeSearch;
	public static ActionEvent aeDelete;
	
	@BeforeClass
	public static void setUp()
	{
		page = new remove_employee();
		aeSearch = new ActionEvent(page.getB(), 1001, "Submit");
		aeDelete = new ActionEvent(page.getB1(), 1001, "Submit");
		
		page.getT().setText("9999");
		
		add_employee pagetemp = new add_employee();
		ActionEvent aetemp = new ActionEvent(pagetemp.getB1(), 1001, "Submit");
		
		pagetemp.getT1().setText("John");
		pagetemp.getT2().setText("Wick");
		pagetemp.getT3().setText("30");
		pagetemp.getT4().setText("1995/03/24");
		pagetemp.getT5().setText("32 rue de la grange");
		pagetemp.getT6().setText("0666007666");
		pagetemp.getT7().setText("johnattan@mail.com");
		pagetemp.getT8().setText("graduate");
		pagetemp.getT9().setText("mercenary");
		pagetemp.getT10().setText("666666666");
		pagetemp.getT11().setText("9999");
		
		pagetemp.actionPerformed(aetemp, true);
	}
	
    @Test
    public void CT_1_08() 
    {
		assertTrue(page.actionPerformed(aeSearch, true));
		assertTrue(page.actionPerformed(aeDelete, true));
    }    

    @Test
    public void CT_1_09()
    {
		assertFalse(page.actionPerformed(aeSearch, true));
    }   

}
