// 1.13 16:41 complete the interface
interface NumList{
    public int size();                                             // return the number of elements of NumArrayList
    public int capacity();                                         // return the capacity of NumArrayList
    public void add(double value);                                 // add a value to the end of NumArrayList.
    public void insert(int i, double value);                       // inserts a element before i-th element. using 0 as start. 
    public void remove(int i);                                     // remove the i-th element. do nothing if i > size
    public double lookup(int i) throws NotVaildIndexException;     // look for the i-th element. throw an exception if not found. 
    public boolean equals(NumList otherList);                      // returns true if the otherList equals the other list.
    public void removeDuplicates();                                // remove duplicates of any elements in the list.
    public String toString();                                      // convert the list to a String.
}

public class NumArrayList implements NumList{
    private int capacity = 0;
    private double[] array;
    private int elements = 0;

    public NumArrayList(){
        this.array = new double[0];
    }

    public NumArrayList(int capacity){
        this.array = new double[capacity];
        this.capacity = capacity;
    }

    private void ExpandIfExceed(){
        double[] newArray = new double[capacity + 1];
        capacity++;
        for(int i = 0; i < capacity - 1; i++){
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

    public int size(){
        return this.elements;
    }

    public int capacity(){
        return this.capacity;
    }

    public void add(double value){
        if(elements < capacity){
            array[elements] = value;
            elements++;
        }
        else{
            this.ExpandIfExceed();
            array[elements] = value;
            elements++;            
        }
    }

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

    public void remove(int i){
        double[] newArray = new double[elements - 1];
        if(elements >= i){
            for(int j = 0; j < i - 1; j++){
                newArray[j] = array[j];
            }
            for(int j = i; j < elements - 1; j++){
                newArray[j] = array[j+1];
            }
        }
    }

    public boolean contains(double value){
        for(int i = 0; i < elements; i++){
            if(array[i] == value){
                return true;
            }
        }
        return false;
    }

    public double lookup(int i) throws NotVaildIndexException{
        if(elements < i){
            throw new NotVaildIndexException("This index is not vaild");
        }
        else{
            return array[i];
        }
    }

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
            } catch (NotVaildIndexException e) {
                System.out.println("This index is not vaild");
            }
        }
        return true;

    }

    public void removeDuplicates(){
        int[] newArray = new int[elements];
        for(int i = 0; i < elements - 1; i++){
            for(int j = i; j > 0; j--){
                
            }
        }
    }

    public String toString(){
        String result = "";
        if(elements == 0){
            return result;
        }
        for(int i = 0; i < elements - 1; i++){
            result = result + array[i]; 
        }
        return result;
    }

}