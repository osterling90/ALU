public class ALU {
    public static longword doOp(bit[] operation, longword a, longword b){
        longword c = new longword();
        for(int i = 0; i < 4; i++){
            /* And operation */
            if(operation[0].getValue() == false && operation[1].getValue() == false
            && operation[2].getValue() == false && operation[3].getValue() == true){
                c = a.and(b);
            }
            /* Or operation */
            if(operation[0].getValue() == true && operation[1].getValue() == false
            && operation[2].getValue() == false && operation[3].getValue() == true){
                c = a.or(b);
            }
            /* Xor operation */
            if(operation[0].getValue() == false && operation[1].getValue() == true
            && operation[2].getValue() == false && operation[3].getValue() == true){
                c = a.xor(b);
            }
            /* Not operation (works on longword a only) */
            if(operation[0].getValue() == true && operation[1].getValue() == true
            && operation[2].getValue() == false && operation[3].getValue() == true){
                c = a.not();
            }
            /* Leftshift operation (shifts longword a to the left by an integer amount
            defined by longword b) */
            if(operation[0].getValue() == false && operation[1].getValue() == false
            && operation[2].getValue() == true && operation[3].getValue() == true){
                c = a.leftShift((int)b.getUnsigned());
            }
            /* Rightshift operation (shifts longword a to the right by an integer amount
            defined by longword b) */
            if(operation[0].getValue() == true && operation[1].getValue() == false
            && operation[2].getValue() == true && operation[3].getValue() == true){
                c = a.rightShift((int)b.getUnsigned());
            }
            /* Add operation from rippleAdder */
            if(operation[0].getValue() == false && operation[1].getValue() == true
            && operation[2].getValue() == true && operation[3].getValue() == true){
                c = rippleAdder.add(a,b);
            }
            /* Subtract operation from rippleAdder */
            if(operation[0].getValue() == true && operation[1].getValue() == true
            && operation[2].getValue() == true && operation[3].getValue() == true){
                c = rippleAdder.subtract(a,b);
            }
            /* Multiplication operator from multiplier */
            if(operation[0].getValue() == true && operation[1].getValue() == true
            && operation[2].getValue() == true && operation[3].getValue() == false){
                c = multiplier.multiply(a,b);
            }
        }
        return c;
    }
}