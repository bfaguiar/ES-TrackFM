package es.labproj.trackfm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import es.labproj.trackfm.dbcontroller.DBController;

@SpringBootApplication
@EnableJpaRepositories
//@EnableScheduling
public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		DBController dbcontroller = context.getBean(DBController.class);
		dbcontroller.addRecentTracks();
		//CallRestAPI rapi = context.getBean(CallRestAPI.class);
	}

}

