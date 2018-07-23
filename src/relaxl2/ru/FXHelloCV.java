package relaxl2.ru;

import org.opencv.core.Core;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * Основной класс для отрисовки и запуска приложения
 *
 */
public class FXHelloCV extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			// Подгрузка FXML ресурса
			FXMLLoader loader = new FXMLLoader(getClass().getResource("FXHelloCV.fxml"));
			// store the root element so that the controllers can use it
			BorderPane rootElement = (BorderPane) loader.load();
			// create and style a scene
			Scene scene = new Scene(rootElement, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// create the stage with the given title and the previously created
			// scene
			primaryStage.setTitle("JavaFX meets OpenCV");
			primaryStage.setScene(scene);
			// show the GUI
			primaryStage.show();
			
			// set the proper behavior on closing the application
			FXHelloCVController controller = loader.getController();
			primaryStage.setOnCloseRequest((new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we)
				{
					controller.setClosed();
				}
			}));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Для запуска приложения
	 * 
	 * @param args
	 *            опциональные параметры
	 */
	public static void main(String[] args)
	{
		// load the native OpenCV library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		// load the native OpenCV library for ip Camera
		System.loadLibrary("opencv_ffmpeg342_64");
		launch(args);
	}
}
