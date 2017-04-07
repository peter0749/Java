class Bigint {
    // private:
    private java.util.ArrayList<Integer> data; // Initialize in constructor
    private int dataLength;
    private void regulate () {
        int i=0;
        for (i=this.data.size()-1; i>=0 && this.data.get(i)==0; --i);
        this.dataLength = i+1;
    }
    private void strToBigint(String str) {
        char [] charArr = str.toCharArray();
        int strLen = str.length();
        for (int i=0, j=strLen-1; j>=0; ++i, --j) {
            this.data.add((int)(charArr[j]) - '0'); // push into array
        }
        this.dataLength = strLen;
        this.regulate();
    }
    private int _cmp(Bigint ext) {
        if ( this.dataLength > ext.dataLength ) return 1; // this > ext
        else if (this.dataLength < ext.dataLength ) return -1; // this < ext
        // same degree
        for (int i=this.dataLength-1; i>=0; --i) {
            if ( this.data.get(i) > ext.data.get(i) ) return 1; // this > ext
            else if ( this.data.get(i) < ext.data.get(i) ) return -1; // this < ext
            // else same
        }
        return 0; // same
    }

    // public:
    public String toString() {
        if (this.dataLength==0) return "0";
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
    public boolean isGreaterThan (Bigint ext) {
        return this._cmp(ext) > 0;
    }
    public boolean isLessThan (Bigint ext) {
        return this._cmp(ext) < 0;
    }
    public boolean isEqualTo (Bigint ext) {
        return this._cmp(ext) == 0;
    }
    public boolean isNotEqualTo (Bigint ext) {
        return this._cmp(ext) != 0;
    }
    public boolean isGreaterThanOrEqulTo (Bigint ext) {
        return this._cmp(ext) >= 0;
    }
    public boolean isLessThanOrEqulTo (Bigint ext) {
        return this._cmp(ext) <= 0;
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
    public Bigint Diff (Bigint ext) {
        // not implement yet
        Bigint ref1=null, ref2=null;
        if (this.isLessThan(ext)) {
            ref1 = ext;
            ref2 = this;
        } else {
            ref1 = this;
            ref2 = ext;
        }
        int maxLen = ref1.dataLength;
        java.util.ArrayList<Integer> temp = new java.util.ArrayList<Integer> (maxLen+2);
        for (int t=maxLen+1; t>=0; --t) temp.add(0); // initialize maxLen elemnts
        for (int i=0; i<maxLen; ++i) {
            temp.set(i, (i<ref1.dataLength?ref1.data.get(i):0) - (i<ref2.dataLength?ref2.data.get(i):0));
        }
        for (int i=0; i<maxLen-1; ++i) {
            if ( temp.get(i) < 0 ) {
                temp.set(i+1, temp.get(i+1)-1);
                temp.set(i, temp.get(i)+10 );
            }
        }
        return new Bigint(temp);
    }

    public Bigint Mul (Bigint ext) {
        int maxLen = this.dataLength + ext.dataLength;
        java.util.ArrayList<Integer> temp = new java.util.ArrayList<Integer>(maxLen+2);
        for (int i=maxLen; i>=0; --i) temp.add(0);
        for (int i=0; i<this.dataLength; ++i) {
            for (int j=0; j<ext.dataLength; ++j) {
                temp.set ( i+j, temp.get(i+j) + this.data.get(i) * ext.data.get(j));
            }
        }
        for (int i=0; i<maxLen; ++i) {
            temp.set ( i+1, temp.get(i+1)+temp.get(i)/10);
            temp.set ( i  , temp.get(i)%10 );
        }
        return new Bigint(temp);
    }
    /*
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
