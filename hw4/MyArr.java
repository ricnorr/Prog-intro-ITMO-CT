
public class MyArr {
    private int[] stuff;
    private int pointer = 0;
    private int size = 0;
	
    public MyArr() {
        this.stuff = new int[0];
    }
	
    public void add(int x) {
        if (size >= stuff.length) {
            int[] stuff1 = new int[(stuff.length * 2)+1];
            System.arraycopy(stuff, 0, stuff1, 0, stuff.length);
            stuff = stuff1;
        }
        stuff[size++] = x;
    }

    public int get(int i) {
        return stuff[i];
    }

    public int getSize() {
        return size;
    }

}
