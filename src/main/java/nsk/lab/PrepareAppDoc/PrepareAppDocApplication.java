package nsk.lab.PrepareAppDoc;

//import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

@SpringBootApplication
@EnableScheduling
public class PrepareAppDocApplication implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
//	private static final Logger log = LogManager.getLogger(PrepareAppDocApplication.class);

	@Autowired
//	private MongoClient mongoClient;
//	@Autowired
	private MongoTemplate template;
//	@Autowired
//	private MongoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PrepareAppDocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*		for (String db : mongoClient.listDatabaseNames()) {
			try{
				mongoClient.dropDatabase(db);
				System.out.println("Удалена база данных: "+ db);
			} catch (Exception e) {
				System.err.println("Ошибка при удалении базы данных: "+ db+ ". Ошибка"+ e.getLocalizedMessage());
			}
		}
*/
		log.warn("Старт. База данных: "+ template.getDb().getName()+ " Коллекции: "+ template.getCollectionNames());
//		System.out.println(new getExample().getRequest().toJson());
	}
}