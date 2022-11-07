public class ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException{
    public ArrayIndexOutOfBoundsException(int index) {
        super("Строка не является выражением " + index);
    }
    public ArrayIndexOutOfBoundsException(String s) {
        super(s);
    }
}
