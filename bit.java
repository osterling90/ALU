public class bit{
    /* Private boolean value for bit class */
    private boolean data;

    /* Constructor for bit class */
    public bit(boolean data){
        this.data = data;
    }
    /* Sets a boolean value for private bit class attribute "data" */
    public void set(boolean value){
        this.data = value;
    }
    /* Sets "data" to opposite boolean value depending on initial value */
    public void toggle(){
        if(this.data == true){
            this.data = false;
        }else if(this.data == false){
            this.data = true;
        }
    }
    /* Sets boolean value "data" to true */
    public void set(){
        this.data = true;
    }
    /* Sets boolean value "data" to false */
    public void clear(){
        this.data = false;
    }
    /* Returns current value of "data" attribute */
    public boolean getValue(){
        return this.data;
    }
    /* Performs AND operation on current bit value and passed in bit value */
    public bit and(bit other){
        bit result = (bit.this.data == other.data) ?
            (bit.this.data == true ? new bit(true) : new bit(false)) :
            (bit.this.data == true ? new bit(false) : new bit(false));
        return result;
    }
    /* Performs OR operation on current bit value and passed in bit value */
    public bit or(bit other){
        bit result = (bit.this.data == other.data) ?
            (bit.this.data == true ? new bit(true) : new bit(false)) :
            (bit.this.data == true ? new bit(true) : new bit(true));
        return result;
    }
    /* Performs XOR operation on current bit value and passed in bit value */
    public bit xor(bit other){
        if(bit.this.data != other.data){
            return new bit(true);
        }else{
            return new bit(false);
        }
    }
    /* Performs AND operation on current bit value */
    public bit not(){
        if(bit.this.data == true){
            return new bit(false);
        }else{
            return new bit(true);
        }
    }
    /* Overrides native toString method in Java */
    @Override
    public String toString(){
        if(bit.this.data == true){
            return "t";
        }else{
            return "f";
        }
    }
}