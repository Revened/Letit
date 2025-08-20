package main.repos;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReposCSV {
    private List<String[]> repos;

    public List<String[]> getRepos() {
        return repos;
    }

    public ReposCSV() {
        this.repos = new ArrayList<>();
        init();
    }

    public void init() {
        File file = new File("C:\\Users\\plahin\\Desktop\\ipRepository.csv");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            while (br.ready()) {
                String s = br.readLine();
                if (!s.contains("ip")) {
                    String[] line = s.split(",");
                    repos.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String[] repo : repos) {
            for (int i = 0; i < repo.length - 1; i++) {
                System.out.println(repo[i] + "\t" + repo[i + 1]);
            }
        }
    }
}
