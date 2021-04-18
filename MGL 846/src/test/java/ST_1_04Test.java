
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

import Employee.add_employee;
import Employee.print_data;
import Employee.remove_employee;
import Employee.testableConn;

public class ST_1_04Test {
	
	public static print_data page;
	public static ActionEvent aeSearch;
	public static ActionEvent aeDelete;
	public static boolean switcher = true;
	
	@BeforeClass
	public static void setUp()
	{
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
    public void CT_1_10() 
    {
		page = new print_data("9999");
		
		assertEquals("9999", page.getEmp_id());
		assertEquals("John", page.getName());
		assertEquals("Wick", page.getFather());
		assertEquals("32 rue de la grange", page.getAddress());
		assertEquals("0666007666", page.getPhone());
		assertEquals("johnattan@mail.com", page.getEmail());
		assertEquals("graduate", page.getEducation());
		assertEquals("mercenary", page.getPost());
    }    


	@After
	public void tearDown()
	{
		if (switcher) {
		remove_employee pagetemp = new remove_employee();
		pagetemp.getT().setText("9999");
		ActionEvent aetemp = new ActionEvent(pagetemp.getB1(), 1001, "Submit");
		
		pagetemp.actionPerformed(aetemp, true);
		}
		switcher = false;
	}
	
    @Test
    public void CT_1_11()
    {
		page = new print_data("9999");

		assertFalse(page.getFlag());
    }   

	
    @Test
    public void CT_1_12()
    {
		page = new print_data("erreur");

		assertFalse(page.getFlag());
    } 

	
    @Test
    public void CT_1_13()
    {
		page = new print_data("***");

		assertFalse(page.getFlag());
    } 

}
