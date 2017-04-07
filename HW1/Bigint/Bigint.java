class Bigint {
    // private:
    private java.util.ArrayList<Integer> data; // Initialize in constructor
    private int dataLength;
    private boolean sign;
    private void regulate () {
        int i=0;
        for (i=this.data.size()-1; i>=0 && this.data.get(i)==0; --i);
        this.dataLength = i+1;
    }
    void strToBigint(String str) {
        char [] charArr = str.toCharArray();
        int strLen = str.length();
        for (int i=0, j=strLen-1; j>=0; ++i, --j) {
            this.data.add((int)(charArr[j]) - '0'); // push into array
        }
        this.dataLength = strLen;
        this.regulate();
    }

    // public:
    public String toString() {
        String str="";
        for (int i=this.dataLength-1; i>=0; --i) {
            str = str + this.data.get(i);
        }
        return str;
        // not implement yet.
    }
    public double toDouble() {
        double val=0.0;
        for (int i=0; i<this.dataLength; ++i) {
            val*=10.0;
            val+=(this.data.get(i));
        }
        return val;
        // not implement yet
    }
    public Bigint Add (Bigint ext) {
        // not implement yet
        int maxLen = Math.max(ext.dataLength,this.dataLength);
        java.util.ArrayList<Integer> temp = new java.util.ArrayList<Integer> (maxLen+2);
        for (int t=maxLen+1; t>=0; --t) temp.add(0); // initialize maxLen elemnts
        for (int i=0; i<this.dataLength; ++i)
            temp.set(i,temp.get(i)+this.data.get(i));
        for (int i=0; i<ext.dataLength; ++i)
            temp.set(i,temp.get(i)+ext.data.get(i));
        for (int i=0; i<maxLen; ++i) {
            temp.set(i+1, temp.get(i+1)+temp.get(i)/10);
            temp.set(i, temp.get(i)%10 );
        }
        return new Bigint(temp);
    }
    /*
    public Bigint Sub (Bigint ext) {
        // not implement yet
    }
    public Bigint Mul (Bigint ext) {
        // not implement yet
    }
    public Bigint Div (Bigint ext) {
        // not implement yet
    }
    */

    // constructor:
    Bigint(String str) {
        // not implment yet
        this.data = new java.util.ArrayList<Integer> ();
        this.strToBigint(str);
    }
    Bigint(java.util.ArrayList<Integer> arr) {
        this.data = arr;
        this.dataLength = arr.size();
        this.regulate();
    }
};
