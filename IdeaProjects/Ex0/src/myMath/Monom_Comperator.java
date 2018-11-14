package myMath;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Monom_Comperator implements Comparator<Monom> {
    /**
     *
     * @param o1 monom
     * @param o2 monom
     * @return 1 if o1 is max -1 if o2 max 0 if are equals
     */
    public int compare(Monom o1, Monom o2){
        int t=o1.get_power()-o2.get_power();
        if(t>0)return 1;

        if(t==0)return 0;

        return -1;
    }

}
