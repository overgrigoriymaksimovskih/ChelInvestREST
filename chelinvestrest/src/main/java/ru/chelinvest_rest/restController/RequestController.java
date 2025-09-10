package ru.chelinvest_rest.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.chelinvest_rest.exceptions.IncorrectValueException;
import ru.chelinvest_rest.service.impl.NumberToTextConverterImpl;


//@RestController
//public class RequestController {
//
//    private final NumberToTextConverterImpl numberToTextConverter;
//    public RequestController(NumberToTextConverterImpl numberToTextConverter, NumberToTextConverterImpl numberToTextConverter1) {
//        this.numberToTextConverter = numberToTextConverter1;
//    }
//
//    @GetMapping("${api.restmodule.endpoint.upload}")
//    @ResponseBody
//    public String sendUsers(
//            @RequestParam(value = "nSum", defaultValue = "10") String nSum,
//            @RequestParam(value = "sGender", defaultValue = "М") String sGender,
//            @RequestParam(value = "sCase", defaultValue = "Т") String sCase
//    ) {
//        try {
//            return numberToTextConverter.numberToWords(Long.parseLong(nSum), sGender, sCase);
//        } catch (IncorrectValueException e) {
//            return "ошибко";
//        }
//
////        return "uploadResult";
//    }
//}

@RestController
public class RequestController {
    private final NumberToTextConverterImpl numberToTextConverter;

    public RequestController(NumberToTextConverterImpl numberToTextConverter) {
        this.numberToTextConverter = numberToTextConverter;
    }

//    @GetMapping("${api.restmodule.endpoint.upload}")
    @GetMapping("${api.restmodule.endpoint.request}")
    @ResponseBody
    public String sendUsers(
            @RequestParam(value = "nSum", defaultValue = "0") String nSum,
            @RequestParam(value = "sGender", defaultValue = "С") String sGender,
            @RequestParam(value = "sCase", defaultValue = "И") String sCase
    ) {
        try {
            return numberToTextConverter.numberToWords(Long.parseLong(nSum), sGender, sCase);
        } catch (IncorrectValueException e) {
            return "ошибко";
        }
    }
}