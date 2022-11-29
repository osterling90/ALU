public class multiplier {
    public static longword multiply(longword a, longword b){
        longword c = new longword();
        longword d = new longword();
        /* Adds shifted longwords together. Shifts in longword a correspond to true bit
         * values in longword b. Ex: a longword 0110 would correspond to a rightShift
         * by 6 in longword b. Shifted copies of longword a are added together and the
         * result is returned.
        */
        for(int i = 0; i < 32; i++){
            if(b.arr[i].getValue() == true){
                c = a.rightShift(i);
                d = rippleAdder.add(c,d);
            }
        }
        return d;
    }
}