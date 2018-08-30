package com.aplicacionSprFx;

/*
 * Example take from
 * http://www.greggbolinger.com/let-spring-be-your-javafx-controller-factory/
 * 
 * */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@EnableAutoConfiguration
@EnableJpaRepositories({"com.dao"})
@EntityScan("com.entidades")
@ComponentScan("com.*")
@SpringBootApplication
public class DemoSpringFxApplication extends Application{

	private ConfigurableApplicationContext springContext;
	private Parent root;

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(DemoSpringFxApplication.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/controlador/controlUI.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		root = fxmlLoader.load();
	}

	@Override
	public void stop() throws Exception {
		springContext.stop();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Prueba Spring FX");
		Scene scene = new Scene(root,800,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(DemoSpringFxApplication.class, args);
	}
}
