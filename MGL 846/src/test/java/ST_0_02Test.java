import Employee.conn;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import static org.junit.Assert.assertEquals;


public class ST_0_02Test {
    conn mySqlConn = new conn();
    String name = "John";
    String fathersName = "Wick";
    String age = "30";
    String birthDate = "1995/03/24";
    String address = "32 rue de la grange";
    String phone = "0666007666";
    String email = "johnattan@mail.com";
    String education = "graduate";
    String jobPost = "mercenary";
    String aadharNo = "666666666";
    String employeeId = "1059";

    @Before
    public void insertEmployee() {
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
    public void CT_0_05() {
        // Fabriquer une requête valide
        String select_employee_query = "select * from employee where emp_id = '" + employeeId + "'";
        ResultSet rs = null;
        boolean is_found = false;
        try {
            rs = mySqlConn.st.executeQuery(select_employee_query);
            while (rs.next()) {
                is_found = true;
                assertEquals(rs.getString("name"), name);
                assertEquals(rs.getString("fname"), fathersName);
                assertEquals(rs.getString("age"), age);
                assertEquals(rs.getString("dob"), birthDate);
                assertEquals(rs.getString("address"), address);
                assertEquals(rs.getString("phone"), phone);
                assertEquals(rs.getString("email"), email);
                assertEquals(rs.getString("name"), name);
                assertEquals(rs.getString("education"), education);
                assertEquals(rs.getString("post"), jobPost);
                assertEquals(rs.getString("aadhar"), aadharNo);
            }
            assertEquals(true, is_found);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = SQLSyntaxErrorException.class)
    public void CT_0_06() throws Exception {        //  Fabriquer une requête non valide dans la
        String select_employee_query = "select * frommmmmmmm employee where emp_id = '" + employeeId + "'";

        mySqlConn.st.executeQuery(select_employee_query);

    }

    public void CT_0_07() throws Exception {
        // TODO: Fabriquer une requête valide avec interruption /**/
    }

}
