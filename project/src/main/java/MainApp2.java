import java.util.Scanner;
import java.sql.*;
import javax.sql.DataSource;
import redis.clients.jedis.Jedis;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp2 {
   public static void main(String[] args) {
     Jedis jedis = new Jedis();
     ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
     System.out.println("Dime un nombre, por favor");
     Scanner sc = new Scanner(System.in);
    while (sc.hasNext()){
     String nombre = sc.nextLine();
     System.out.println("Dime un país, por favor");
     String country12 = sc.nextLine();
     try {
     	DataSource ds = (DataSource) context.getBean("ds");
	Connection conn = ds.getConnection();
	PreparedStatement st = conn.prepareStatement("INSERT INTO person(name, country) VALUES(?,?)");
	if(jedis.sismember("a18:miset", country12)){
		System.out.println("No agregado, está ya almacenado!!!!!!!!!!!");
		System.out.println("Saliendo del programa...Bye!");
		return;
	}
	jedis.sadd("a18:miset", country12);
	st.setString(1, nombre);
	st.setString(2, country12);
	st.executeUpdate();
	System.out.println("Agregado con éxito!!!!!!:):):)");
	conn.close();

     } catch (Exception e) {
	System.out.println("No funciona, algo va mal, es problema humano!!");
	System.out.println(e.getMessage());
     }
     System.out.println("Dime otro nombre, por favor");
    }
   }
}
