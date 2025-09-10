package ru.chelinvest_rest.utils;

import ru.chelinvest_rest.exceptions.DigitPreparingException;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DigitPreparer {
    public static List<Map.Entry<Long, Integer>> convertNumberToArray(long number) throws DigitPreparingException {
        if (number < 1 || number > 999999999999L) {
            String msg = String.format("Число не находится в диапазоне от 1 до 999 999 999 999");
            throw new DigitPreparingException(msg);
        }

        List<Map.Entry<Long, Integer>> result = new ArrayList<>();

        // Find the highest power of ten needed (up to 10^11 for 999,999,999,999)
        long highestPowerOfTen = 1;
        while (highestPowerOfTen <= 99999999999L) { // Up to 10^11
            highestPowerOfTen *= 10;
        }

        // Iterate through all possible powers of ten, from highest to lowest
        while (highestPowerOfTen >= 1) {
            int digit = (int) (number / highestPowerOfTen); // Get the digit for the current power of ten.

            if (digit < 0 || digit > 9) {
                String msg = String.format("Неожиданное значение цифры: %d при создании списка пар \"разряд/значение\"", digit);
                throw new DigitPreparingException(msg);
            }

            result.add(new AbstractMap.SimpleEntry<>(highestPowerOfTen, digit));
            number %= highestPowerOfTen; // Remove the digit to find the remainder.
            highestPowerOfTen /= 10;    // Move to the next lower power of ten.
        }

        // Устанавливаем окончание Ten or Teen
        if(result.size() < 2){
            String msg = String.format("Неожиданно в списке разрядов нет пары с ключом = 10");
            throw new DigitPreparingException(msg);
        }else{
            int TenOrTeen = (result.get(result.size()-2)).getValue();
            if(TenOrTeen == 1){
                int res = (result.get(result.size()-1)).getValue() + 10;
                result.get(result.size()-1).setValue(res);
                result.get(result.size()-2).setValue(0);
            }
            //1000
            int TenOrTeen1000 = (result.get(result.size()-5)).getValue();
            if(TenOrTeen1000 == 1){
                int res = (result.get(result.size()-4)).getValue() + 10;
                result.get(result.size()-4).setValue(res);
                result.get(result.size()-5).setValue(0);
            }
//            //1000000
            int TenOrTeen1000000 = (result.get(result.size()-8)).getValue();
            if(TenOrTeen1000000 == 1){
                int res = (result.get(result.size()-7)).getValue() + 10;
                result.get(result.size()-7).setValue(res);
                result.get(result.size()-8).setValue(0);
            }
//            //1000000000
            int TenOrTeen1000000000 = (result.get(result.size()-11)).getValue();
            if(TenOrTeen1000000000 == 1){
                int res = (result.get(result.size()-10)).getValue() + 10;
                result.get(result.size()-10).setValue(res);
                result.get(result.size()-11).setValue(0);
            }
        }


        return result;
    }
}
