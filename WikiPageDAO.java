package wiki;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import sw.DBManager;
import sw.ResultSetBeanMapping;

public class WikiPageDAO{
	private ResultSetBeanMapping allMapping = new ResultSetBeanMapping(){
		public WikiPage createFromResultSet(ResultSet rs)
		throws SQLException{
			WikiPage page = new WikiPage();
			page.setName(rs.getString("name"));
			page.setContent(rs.getString("content"));
			page.setUpdateTime(rs.getTimestamp("update_time"));
			return page;
		}
	};
	public static WikiPageDAO getInstance(){
		return new WikiPageDAO();
	}
	
	public List findAll() throws SQLException {
		String sql = "SELECT * FROM wiki_page"
		+ " ORDER BY update_time DESC";
		
		return DBManager.simpleFind(sql,allMapping);
	}
	public WikiPage findByName(String name) throws SQLException{ 
	  
		String sql = "SELECT * FROM wiki_page" + " WHERE name ='" + name + "'"; 
		System.out.println(sql);
	  
		List<WikiPage> list = DBManager.simpleFind(sql,allMapping); 
		if(list.size() == 0){ 
			return null; 
		}else if(list.size() > 1){ 
			throw new IllegalArgumentException("record > 1"); 
		} 
	return list.get(0); 
	} 

	public void insert(WikiPage page) throws SQLException{ 

		String sql = "INSERT INTO wiki_page (name, content)" 
		+" VALUES(" 
		+ "'" + page.getName() + "'" 
		+ ",'" + page.getContent() + "'" 
		+ ")"; 
		DBManager.simpleUpdate(sql); 
	} 

	public void update(WikiPage page) throws SQLException{ 

		String sql = "UPDATE wiki_page " 
		+"SET" 
		+ " content='" + page.getContent() + "'" 
		+ " WHERE name='" + page.getName() + "'"; 

		DBManager.simpleUpdate(sql); 
	}	
	public void delete(WikiPage page) throws SQLException{ 

		String sql = "DELETE FROM wiki_page WHERE name='"
		+ page.getName() + "'"; 
		DBManager.simpleUpdate(sql); 
	}
}