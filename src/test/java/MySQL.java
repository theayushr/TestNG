import java.sql.*;

public class MySQL {

    public Object[][] getSQLData() throws SQLException {

        Object[][] data = new Object[2][2];

        String uri = "jdbc:mysql://localhost:3306/selenium";
        String user = "root";
        String password = "password";
        String query = "select * from Credentials;";

        Connection con = DriverManager.getConnection(uri, user, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            String credentials = null;
            for(int i=0; i<2; i++){
                for(int j=0; j<2; j++){
                    if(j==0) credentials = "emailid";
                    if(j==1) credentials = "password";
                    data[i][j] = rs.getString(credentials);
                }
                rs.next();
            }
        }
        return data;
    }

    public static void main(String[] args) throws SQLException {
        MySQL obj = new MySQL();
        Object[][] mydata = obj.getSQLData();


        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                System.out.print(mydata[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
