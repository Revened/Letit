package main.service.factory;

import jakarta.annotation.PostConstruct;
import main.repos.ReposCSV;
import main.service.Panel;
import main.service.panelModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PanelFactory {
    /*@Autowired
    List<Panel> panels;*/
    @Autowired
    ReposCSV repos;
    @Autowired
    private ApplicationContext applicationContext;


    public void init() {
        for (String[] repo : repos.getRepos()) {
            String ip = repo[0];
            String model = repo[1];
            String login = repo[2];
            String password = repo[3];

            switch (model) {
                case "R28":new R28(ip, login, password); break;
                case "X915S":new X915S(ip, login, password); break;
                case "C313V2":new C313V2(ip, login, password); break;
                case "S256":new S256(ip, login, password); break;
                case "RV3434":new RV3434(ip, login, password); break;
                case "C319":new C319(ip, login, password); break;
                default:break;
            }
        }
    }

    public Panel getPanel(String panelName) {
        return applicationContext.getBean(panelName, Panel.class);
    }
}
