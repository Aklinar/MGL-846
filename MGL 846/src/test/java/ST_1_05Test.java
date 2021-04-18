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
import main.java.Employee.print_data;
import main.java.Employee.remove_employee;
import main.java.Employee.search_employee;
import main.java.Employee.testableConn;

public class ST_1_05Test {
	
	public static search_employee page;
	public static ActionEvent aeSearch;
	public static boolean switcher = true;
	
	@BeforeClass
	public static void setUp()
	{
		page = new search_employee();
		
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
	
	@After
	public void tearDown()
	{
		if (switcher)
		{
			remove_employee pagetemp = new remove_employee();
			pagetemp.getT().setText("9999");
			ActionEvent aetemp = new ActionEvent(pagetemp.getB1(), 1001, "Submit");
			
			pagetemp.actionPerformed(aetemp, true);
		}
	}
	
    @Test
    public void CT_1_14() 
    {
    	page.getT().setText("9999");
		
    	//Il s'avère qu'il n'existe pas de fonctionalité de recherche, voir la note du rapport
    	
    	assertFalse(true);
    }    

	
    @Test
    public void CT_1_15()
    {
    	page.getT().setText("9999");
		
    	//Il s'avère qu'il n'existe pas de fonctionalité de recherche, voir la note du rapport
    	
    	assertFalse(true);
    }   

	
    @Test
    public void CT_1_16()
    {
    	page.getT().setText("erreur");
		
    	//Il s'avère qu'il n'existe pas de fonctionalité de recherche, voir la note du rapport
    	
    	assertFalse(true);
    } 

	
    @Test
    public void CT_1_17()
    {
    	page.getT().setText("***");
		
    	//Il s'avère qu'il n'existe pas de fonctionalité de recherche, voir la note du rapport
    	
    	assertFalse(true);
    } 

}
