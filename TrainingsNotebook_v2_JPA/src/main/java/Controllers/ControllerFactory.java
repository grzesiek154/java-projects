package Controllers;

public interface ControllerFactory {

    BaseController createController(String type);
}
