// 1.13 16:41 complete the interface
interface NumList{
    int size();                                             // return the number of elements of NumArrayList
    int capacity();                                         // return the capacity of NumArrayList
    void add(double value);                                 // add a value to the end of NumArrayList.
    void insert(int i, double value);                       // inserts a element before i-th element. using 0 as start.
    void remove(int i);                                     // remove the i-th element. do nothing if i > size
    double lookup(int i) throws NotValidIndexException;     // look for the i-th element. throw an exception if not found.
    boolean equals(NumList otherList);                      // returns true if the otherList equals the other list.
    void removeDuplicates();                                // remove duplicates of any elements in the list.
    String toString();                                      // convert the list to a String.
}

public class NumArrayList implements NumList{
    // variable that store the capacity of array. 
    private int capacity = 0;
    // Using null as an initial value; Avoid ambigious if/else statement when considering 0.0
    private Double[] array;
    // variable that store the number of current elements
    private int elements = 0;

    /**
     * For those NumArrayList variable without input, one would construct initial NumArrayList 
     * with zero capacity. 
     */
    public NumArrayList(){
        this.array = new Double[0];
    }

    /**
     * For those NumArrayList with specific input, one would construct initial NumArrayList 
     * with parameter
     * @param capacity
     */
    public NumArrayList(int capacity){
        this.array = new Double[capacity];
        this.capacity = capacity;
    }

    /**
     * increase the capacity of array by 1 unit. Trigger when current capacity is not enough
     * for additional element.
     */
    private void ExpandIfExceed(){
        Double[] newArray = new Double[capacity + 1];
        capacity++;
        for(int i = 0; i < capacity - 1; i++){
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

    
    /** 
     * @return the number of elements
     */
    public int size(){
        return this.elements;
    }

    
    /** 
     * @return the value of capacity
     */
    public int capacity(){
        return this.capacity;
    }

    
    /** 
     * Accept a double value and place that input at the end of the array. Able to 
     * expand the array if needed. 
     * @param value
     */
    public void add(double value){
        if(elements < capacity){
            array[elements] = value;
            elements++;
        }
        else{
            this.ExpandIfExceed();
            array[capacity] = value;
            elements++;
        }
    }

    
    /** 
     * place the <code>value</code> at <code>i</code>-th index of the array and defer  
     * the subsequent values. If the array has elements that fewer than <code>i</code>,
     * adding that value to the end of array. Able to Expand the array if needed. 
     * @param i
     * @param value
     */
    public void insert(int i, double value){
        double intermediateVal;
        if(elements < capacity){
            if(elements >= i){
                for(int j = i; j < elements + 1; j++){
                    intermediateVal = array[j];
                    array[j] = array[j+1];
                    array[j+1] = intermediateVal;
                }
                array[i] = value;
                elements++;
            }
            else if(elements < i){
                this.add(value);
            }
        }
        else{
            this.ExpandIfExceed();
            for(int j = i; j < elements + 1; j++){
                intermediateVal = array[j];
                array[j] = array[j+1];
                array[j+1] = intermediateVal;
            }
            array[i] = value;
            elements++;
        }   
    }

    
    /** 
     * Remove the <code>i</code>-th element and advance the subsequent elements. Do nothing
     * if the <code>i</code>-th element does not exist.
     * @param i
     */
    public void remove(int i){
        Double[] newArray = new Double[elements - 1];
        if(elements >= i){
            for(int j = 0; j < i - 1; j++){
                newArray[j] = array[j];
            }
            for(int j = i; j < elements - 1; j++){
                newArray[j] = array[j+1];
            }
            this.array = newArray;
        }
    }

    
    /** 
     * Determining whether <code>value</code> exist in array. Return <code>true</code> if 
     * exist. 
     * @param value
     * @return DoesValueExist
     */
    public boolean contains(double value){
        for(int i = 0; i < elements; i++){
            if(array[i] == value){
                return true;
            }
        }
        return false;
    }

    
    /** 
     * Return <code>i</code>-th element in the array. 
     * @param i
     * @return i-th element
     * @throws NotValidIndexException
     */
    public double lookup(int i) throws NotValidIndexException{
        if(elements < i){
            throw new NotValidIndexException("This index is not valid");
        }
        else{
            return array[i];
        }
    }

    
    /** 
     * Determining whether two <code>NumArrayList</code> is equal. Two <code>NumArrayList</code>
     * is equal if every element with same index are equal in both lists. 
     * @param otherList
     * @return DoesTwoListEqual
     */
    public boolean equals(NumList otherList){
        if(otherList.size() == 0 && this.size() == 0){
            return true;
        }
        else if(otherList.size() != this.size()){
            return false;
        }
        for(int i = 0; i < elements - 1; i++){
            try {
                if(otherList.lookup(i) != array[i]){
                    return false;
                }
            } catch (NotValidIndexException e) {
                System.out.println("This index is not valid");
            }
        }
        return true;

    }
    /**
     * Remove duplicates of elements in array. An element is said duplicate if another element exists 
     * in array that has same value but lower index. 
     */
    public void removeDuplicates(){
        NumArrayList newArray = new NumArrayList();
        for(int i = 0;i<array.length; i++){
			for(int j = i + 1; j<array.length; j++){
				if(array[i] == array[j]){
					j = ++i;
				}
			}
			newArray.add(array[i]);
        }
    }

    
    /** 
     * Print the array to String. Each element would be sepreated by a single space. Return <code>""</code>
     * if the array is empty. 
     * @return String
     */
    public String toString(){
        if(elements == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < elements - 1; i++){
            result.append(array[i]);
            result.append(" ");
        }
        return result.toString();
    }

}