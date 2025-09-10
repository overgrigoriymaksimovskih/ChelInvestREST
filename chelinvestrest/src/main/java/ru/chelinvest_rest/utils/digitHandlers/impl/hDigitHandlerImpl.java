package ru.chelinvest_rest.utils.digitHandlers.impl;

import ru.chelinvest_rest.utils.CheckersOfSignature.RuCase;
import ru.chelinvest_rest.utils.digitHandlers.DigitHandler;

public final class hDigitHandlerImpl implements DigitHandler  {
    private static final String classTemplate = "тысяч";

    public hDigitHandlerImpl() {
    }
    @Override
    //1000 - 999 999
    public String process(long num, String sGender, String sCase) {
        StringBuilder result = new StringBuilder();
        if(num == 1000){
            if(!RuCase.I.equals(sCase)
                    && !RuCase.R.equals(sCase)
                    && !RuCase.V.equals(sCase)
                    && !RuCase.T.equals(sCase)){
                result.append(classTemplate + "е")  ;
                return result.toString();
            }
            if (RuCase.I.equals(sCase)){
                result.append(classTemplate + "а") ;
            }
            if (RuCase.R.equals(sCase)){
                result.append(classTemplate + "и")  ;
            }
            if (RuCase.V.equals(sCase)){
                result.append(classTemplate + "у")  ;
            }
            if (RuCase.T.equals(sCase)){
                result.append(classTemplate + "ей")  ;
            }
        }


        if (num == 2000 || num == 3000 || num == 4000) {
            if (!RuCase.R.equals(sCase)
                    && !RuCase.D.equals(sCase)
                    && !RuCase.T.equals(sCase)
                    && !RuCase.P.equals(sCase)){
                result.append(classTemplate + "и");
            }
            if (RuCase.R.equals(sCase)){
                result.append(classTemplate + "");
            }
            if (RuCase.D.equals(sCase)){
                result.append(classTemplate + "ам");
            }
            if (RuCase.T.equals(sCase)){
                result.append(classTemplate + "ами");
            }
            if (RuCase.P.equals(sCase)){
                result.append(classTemplate + "ах");
            }
        }

        if ( num > 4000) {
            if(!RuCase.D.equals(sCase)
                    &&  !RuCase.T.equals(sCase)
                    &&  !RuCase.P.equals(sCase)){
                result.append(classTemplate + "");
            }
            if (RuCase.D.equals(sCase)) {
                result.append(classTemplate + "ам");
            }
            if (RuCase.T.equals(sCase)) {
                result.append(classTemplate+ "ами");
            }
            if (RuCase.P.equals(sCase)) {
                result.append(classTemplate+ "ах");
            }
        }

        return result.toString();
    }
}
