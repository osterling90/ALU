public class longword{
    /* 32-index array, each index containing an instance of the bit class */
    public bit[] arr = new bit[32];

    /* Constructor for longword class */
    public longword(){
        for(int i = 0; i < 32; i++){
            arr[i] = new bit(false);
        }
    }
    /* Second constructor - sets value of longword */
    public longword(int value){
            for(int i = 0; i < 32; i++){
                arr[i] = new bit(false);
            }
            set(value);
    }
    /* Returns the value of a new bit */
    public bit getBit(int i){
        return new bit(arr[i].getValue());
    }
    /* Sets the value of a new bit */
    public void setBit(int i, bit value){
        this.arr[i] = new bit(value.getValue());
    }
    /* Performs and operation on two longwords, returns a new longword */
    public longword and(longword other){
        longword l = new longword();
        for(int i = 0; i < 32; i++){
            l.arr[i] = this.arr[i].and(other.arr[i]);
        }
        return l;
    }
    /* Performs or operation on two longwords, returns a new longword */
    public longword or(longword other){
        longword l = new longword();
        for(int i = 0; i < 32; i++){
            l.arr[i] = this.arr[i].or(other.arr[i]);
        }
        return l;
    }
    /* Performs xor operation on two longwords, returns a new longword */
    public longword xor(longword other){
        longword l = new longword();
        for(int i = 0; i < 32; i++){
            l.arr[i] = this.arr[i].or(other.arr[i]);
        }
        return l;
    }
    /* Performs not operation on a longword, returns a new longword */
    public longword not(){
        longword l = new longword();
        for(int i = 0; i < 32; i++){
            l.arr[i] = this.arr[i].not();
        }
        return l;
    }
    /* Shifts bits to the left in longword, returns a new left shifted longword */
    public longword leftShift(int amount){
        longword l = new longword();
        for(int i = amount; i < arr.length; i++){
            l.arr[i-amount] = this.arr[i];
        }
        for(int i = l.arr.length - amount; i < l.arr.length; i++){
            l.arr[i] = new bit(false);
        }
        return l;
    }
    /* Shifts bits to the right in longword, returns a new right shifted longword */
    public longword rightShift(int amount){
        longword l = new longword();
        for(int i = 0; i < arr.length - amount; i++){
            l.arr[i+amount] = this.arr[i];
        }
        for(int i = 0; i < amount; i++){
            l.arr[i] = new bit(false);
        }
        return l;
    }
    @Override
    public String toString(){
        String result = " ";
        for(int i = 0; i < 32; i++){
            if(i != 31){
                result += arr[i].toString() + ",";
            }
            else if(i == 31){
                result += arr[i].toString();
            }
        }
        return result;
    }
    /* Returns the unsigned long value of the longword */
    public long getUnsigned(){
        long factor = 1;
        long counter = 0;
        for(int i = 0; i < 32; i++){
            if(this.arr[i].getValue() == true){
                counter = counter + factor;
            }
            factor = factor * 2;
        }
        return counter;
    }
    /* Returns the signed int value of the longword */
    /*public int getSigned(){
        
    }*/
    /* Copies bits from longword "other" into this longword */
    public void copy(longword other){
        for(int i = 0; i < 32; i++){
            this.arr[i].set(other.arr[i].getValue());
        }
    }
    /* Sets the longword to its corresponding integer value */
    public void set(int value){
        long factor = 2147483648L;
        long counter = 0;
        for(int i = 31; i >= 0; i--){
            if((factor + counter) <= value){
                this.setBit(i, new bit(true));
                counter = counter + factor;
            }
            factor = factor / 2;
        }
    }
}