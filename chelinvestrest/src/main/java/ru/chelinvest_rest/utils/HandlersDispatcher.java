package ru.chelinvest_rest.utils;

import ru.chelinvest_rest.utils.digitHandlers.impl.*;

public final class HandlersDispatcher {
    private HandlersDispatcher() {
    }
    public static String handleNumber(Long nSum, String sGender, String sCase) {
        aDigitHandlerImpl aDigitHandlerImpl = new aDigitHandlerImpl();
        bDigitHandlerImpl bDigitHandlerImpl = new bDigitHandlerImpl();
        cDigitHandlerImpl cDigitHandlerImpl = new cDigitHandlerImpl();
        dDigitHandlerImpl dDigitHandlerImpl = new dDigitHandlerImpl();
        eDigitHandlerImpl eDigitHandlerImpl = new eDigitHandlerImpl();
        fDigitHandlerImpl fDigitHandlerImpl = new fDigitHandlerImpl();
        gDigitHandlerImpl gDigitHandlerImpl = new gDigitHandlerImpl();
        hDigitHandlerImpl hDigitHandlerImpl = new hDigitHandlerImpl();
        iDigitHandlerImpl iDigitHandlerImpl = new iDigitHandlerImpl();
        jDigitHandlerImpl jDigitHandlerImpl = new jDigitHandlerImpl();

        if(nSum > 0 && nSum < 5){
            return aDigitHandlerImpl.process(nSum, sGender, sCase);
        }
        if(nSum > 4 && nSum < 10){
            return bDigitHandlerImpl.process(nSum, sGender, sCase);
        }
        if(nSum > 9 && nSum < 20){
            return cDigitHandlerImpl.process(nSum, sGender, sCase);
        }
        if(nSum > 19 && nSum < 40){
            return dDigitHandlerImpl.process(nSum, sGender, sCase);
        }
        //--------------------------------
        if(nSum > 39 && nSum < 50){
            return eDigitHandlerImpl.process(nSum, sGender, sCase);
        }
        if(nSum > 89 && nSum < 100){
            return eDigitHandlerImpl.process(nSum, sGender, sCase);
        }
        if(nSum > 99 && nSum < 200){
            return eDigitHandlerImpl.process(nSum, sGender, sCase);
        }
        //------------------------------
        if(nSum > 49 && nSum < 90){
            return fDigitHandlerImpl.process(nSum, sGender, sCase);
        }

        if(nSum > 199 && nSum < 1000){
            return gDigitHandlerImpl.process(nSum, sGender, sCase);
        }
        if(nSum > 999 && nSum < 1000000){
            return hDigitHandlerImpl.process(nSum, sGender, sCase);
        }
        if(nSum > 999999 && nSum < 1000000000){
            return iDigitHandlerImpl.process(nSum, sGender, sCase);
        }
        if(nSum > 999999999 && nSum < 1000000000000L){
            return jDigitHandlerImpl.process(nSum, sGender, sCase);
        }

        return "empty - " + nSum;
    }
}
