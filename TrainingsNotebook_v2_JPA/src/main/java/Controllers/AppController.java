package Controllers;

import DAO.BaseService;

public class AppController {

    private BaseService service;



    public AppController(BaseService service) {
        this.service = service;
    }
}
