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

    private List<ResultPair> previousResults = new ArrayList<>();

    @GetMapping("/")
    public String form(Model model) {
        model.addAttribute("previousResults", previousResults);
        return "form";
    }

    @PostMapping("/send")
    public String sendForm(@RequestParam(value = "nSum", defaultValue = "0") String nSum,
                           @RequestParam(value = "sGender") String sGender,
                           @RequestParam(value = "sCase") String sCase,
                           Model model) {

        System.out.println("Отправлено: " + nSum + ", " + sGender + ", " + sCase);

        RestTemplate restTemplate = new RestTemplate();
        String url = serviceUrl + "?nSum=" + nSum + "&sGender=" + sGender + "&sCase=" + sCase;
        String response = null;
        try {
            response = restTemplate.getForObject(url, String.class);

            ResultPair resultPair = new ResultPair(nSum, sGender, sCase, response);
            previousResults.add(0, resultPair);

            model.addAttribute("nSum", nSum);
            model.addAttribute("sGender", sGender);
            model.addAttribute("sCase", sCase);
            model.addAttribute("result", response);
            model.addAttribute("previousResults", previousResults);

        } catch (Exception e) {
            model.addAttribute("result", "Ошибка при отправке запроса: " + e.getMessage());
            model.addAttribute("previousResults", previousResults);
        }

        return "form";
    }

    class ResultPair {
        private String nSum;
        private String sGender;
        private String sCase;
        private String response;

        public ResultPair(String nSum, String sGender, String sCase, String response) {
            this.nSum = nSum;
            this.sGender = sGender;
            this.sCase = sCase;
            this.response = response;
        }

        public String getnSum() {
            return nSum;
        }

        public String getsGender() {
            return sGender;
        }

        public String getsCase() {
            return sCase;
        }

        public String getResponse() {
            return response;
        }
    }
}
