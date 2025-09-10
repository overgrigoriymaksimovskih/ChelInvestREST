package ru.chelinvest_rest.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {

    @Value("${form.controller.url}")
    private String serviceUrl;

    private List<ResultPair> previousResults = new ArrayList<>(); // Список для хранения объектов ResultPair.

    @GetMapping("/")
    public String form(Model model) {
        model.addAttribute("previousResults", previousResults); // Передаем историю в шаблон при загрузке формы
        return "form";
    }

    @PostMapping("/send")
    public String sendForm(@RequestParam(value = "nSum", defaultValue = "0") String nSum,
                           @RequestParam(value = "sGender", defaultValue = "С") String sGender,
                           @RequestParam(value = "sCase", defaultValue = "И") String sCase,
                           Model model) {

        System.out.println("Отправлено: " + nSum + ", " + sGender + ", " + sCase);

        RestTemplate restTemplate = new RestTemplate();
        String url =  serviceUrl + "?nSum=" + nSum + "&sGender=" + sGender + "&sCase=" + sCase;
        String response = null;
        try {
            response = restTemplate.getForObject(url, String.class);

            ResultPair resultPair = new ResultPair(nSum, response); // Создаем объект ResultPair
            previousResults.add(0, resultPair);          // Добавляем объект в начало списка.

            model.addAttribute("nSum", nSum);             // Добавляем nSum для текущего отображения как и раньше
            model.addAttribute("result",  response);       // Добавляем result для текущего отображения как и раньше
            model.addAttribute("previousResults", previousResults);  // Обновляем список в модели

        } catch (Exception e) {
            model.addAttribute("result", "Ошибка при отправке запроса: " + e.getMessage());
            model.addAttribute("previousResults", previousResults); // Все равно передаем список, даже если ошибка
        }

        return "form";
    }

    // Вложенный класс ResultPair
    class ResultPair {
        private String nSum;
        private String response;

        public ResultPair(String nSum, String response) {
            this.nSum = nSum;
            this.response = response;
        }

        public String getnSum() {
            return nSum;
        }

        public String getResponse() {
            return response;
        }
    }
}
