import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

import main.java.Employee.conn;
import org.junit.After;
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

	public static conn mySqlConn = new conn();
	public static String name = "John";
	public static String fathersName = "Wick";
	public static String age = "30";
	public static String birthDate = "1995/03/24";
	public static String address = "32 rue de la grange";
	public static String phone = "0666007666";
	public static String email = "johnattan@mail.com";
	public static String education = "graduate";
	public static String jobPost = "mercenary";
	public static String aadharNo = "666666666";
	public static String employeeId = "9999";

	@BeforeClass
	public static void setUp()
	{
		page = new remove_employee();
		aeSearch = new ActionEvent(page.getB(), 1001, "Submit");
		aeDelete = new ActionEvent(page.getB1(), 1001, "Submit");

		page.getT().setText("9999");

		add_employee pagetemp = new add_employee();
		ActionEvent aetemp = new ActionEvent(pagetemp.getB1(), 1001, "Submit");



		String add_employee_query = "insert into employee values('"
				+ name + "','"
				+ fathersName + "','"
				+ age + "','"
				+ birthDate + "','"
				+ address + "','"
				+ phone + "','"
				+ email + "','"
				+ education + "','"
				+ jobPost + "','"
				+ aadharNo + "','"
				+ employeeId + "')";

		try {
			mySqlConn.st.execute(add_employee_query);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		pagetemp.actionPerformed(aetemp, true);
	}

	@After
	public void deleteEmployee() {
		String deleteQuery = "DELETE FROM employee WHERE emp_id = '" + employeeId + "'";
		try {
			mySqlConn.st.execute(deleteQuery);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
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
