package Linked_List_Algorithm;

public class DynamicStack extends customstack {
    public DynamicStack(){
        super();
    }

    public DynamicStack(int size){
        super();
    }

    @Override
    public boolean push(int item) {
        if(this.isfull()){
            int[] temp = new int[data.length * 2];

            //copy all prev items in new data.
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }

        // insert item
        return super.push(item);
    }
}
