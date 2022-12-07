package demo;

import java.sql.Connection;

public class DBCManager {
    private String dbURL;
	private String user;
	private String password;
	private Connection con;
    {
        System.out.println("-----------DBCManager---------");
    }
    public DBCManager(String url, String u, String p) {
        
        this.dbURL = url;
        this.user = u;
        this.password = p;
    }

    public Connection getConnection(){
		return this.con;
	}
	
	public void closeConnection(){
		//close DB connection here
	}
    
}
