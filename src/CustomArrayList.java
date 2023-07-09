//TODO make everything generic soon^tm
public class CustomArrayList implements ArrayListRI {
    private final static int DEFAULT_CAPACITY = 1;
    private int elementCount; //returns the number of elements in the array
    private int capacity; // max size of the current internal array
    private Integer[] internalArray;


    public CustomArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        internalArray = new Integer[DEFAULT_CAPACITY];
    }
    public CustomArrayList(int capacity) {
        this.capacity = capacity;
        internalArray = new Integer[this.capacity];
    }
    @Override
    public void set(int index, int value) {
        internalArray[index] = value;
    }
    @Override
    public int get(int index) {
        return internalArray[index];
    }
    @Override
    public int size() {
        return this.elementCount;
    }

    @Override
    public boolean isEmpty() {
        return this.elementCount == 0;
    }


    @Override
    public void add(int value) {
        if (elementCount == capacity) {
            resize();
        }
        internalArray[elementCount] = value;
        elementCount++;
    }

    @Override
    public void insert(int index, int value){
        if (elementCount == capacity) {
            resize();
        }
        if (elementCount == index) {
            add(value);
            return;
        }
        shiftRight(index); //shifting all values to the right by one
        set(index, value); //setting "value" at position "index"
        elementCount++;
    }

    @Override
    public void delete(int index) {
        if (index != this.elementCount) {
            shiftLeft(index);
        }
        this.internalArray[index] = null;
        elementCount--;
    }

    @Override
    public boolean contains(int value) {
        for (int i=0; i <= this.elementCount;i++){
            if(internalArray[i] != null && internalArray[i] == value) {
                return true;
            }
        } return false;
    }

    @Override
    public StringBuilder print(){
        StringBuilder printArray = new StringBuilder();
        for (int i=0; i < this.elementCount;i++){
            if(internalArray[i] != null) {
                printArray.append(internalArray[i]).append(", ");
            }
        }
        return printArray.insert(0,"{ ").append("}");
    }

    //--------------------------private methods--------------------------
    private void shiftRight(int index) {
        for (int i = this.elementCount; i > index; i--) {
            internalArray[i] = internalArray[i - 1];
        }
    }
    private void shiftLeft(int index){
        for (int i = index; i < this.elementCount-1; i++) {
            internalArray[i] = internalArray[i + 1];
        }
    }
    private void resize() {
        int newSize = this.capacity * 2;
        Integer[] newArray = new Integer[newSize];
        for (int i = 0; i < this.capacity; i++) {
            newArray[i] = internalArray[i];
        }
        this.capacity = newSize;
        this.internalArray = newArray;
    }
}
