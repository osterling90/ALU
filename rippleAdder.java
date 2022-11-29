public class rippleAdder{
    /* Adds the value of two longwords together */
    public static longword add(longword a, longword b){
        longword c = new longword();
        bit carry = new bit(false);
        for(int i = 0; i < 32; i++){
            c.arr[i] = ((a.arr[i].xor(b.arr[i])).xor(carry));
            carry = a.arr[i].and(b.arr[i]).or((a.arr[i].xor(b.arr[i])).and(carry));
        }
        return c;
    }
    /* Subtracts the value of one longword from another longword */
    public static longword subtract(longword a, longword b){
        longword c = new longword();
        bit carry = new bit(true);
        for(int i = 0; i < 32; i++){
            c.arr[i] = ((a.arr[i].xor(b.not().arr[i])).xor(carry));
            carry = a.arr[i].and(b.not().arr[i]).or((a.arr[i].xor(b.not().arr[i])).and(carry));
        }
        return c;
    }
}