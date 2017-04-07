class HugeInteger {
    // private:
    private java.util.ArrayList<Integer> data; // Initialize in constructor
    private int dataLength;
    private void regulate () {
        int i=0;
        for (i=this.data.size()-1; i>=0 && this.data.get(i)==0; --i);
        this.dataLength = i+1;
    }
    private void parse(String str) {
        int strLen = str.length();
        for (int i=0, j=strLen-1; j>=0; ++i, --j) {
            this.data.add((int)(str.charAt(j)) - '0'); // push into array
        }
        this.dataLength = strLen;
        this.regulate();
    }
    private int _cmp(HugeInteger ext) {
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
    public boolean isGreaterThan (HugeInteger ext) {
        return this._cmp(ext) > 0;
    }
    public boolean isLessThan (HugeInteger ext) {
        return this._cmp(ext) < 0;
    }
    public boolean isEqualTo (HugeInteger ext) {
        return this._cmp(ext) == 0;
    }
    public boolean isNotEqualTo (HugeInteger ext) {
        return this._cmp(ext) != 0;
    }
    public boolean isGreaterThanOrEqualTo (HugeInteger ext) {
        return this._cmp(ext) >= 0;
    }
    public boolean isLessThanOrEqualTo (HugeInteger ext) {
        return this._cmp(ext) <= 0;
    }
    public boolean isZero () {
        for(int i=this.dataLength-1; i>=0; --i) {
            if (this.data.get(i)!=0) return false;
        }
        return true;
    }
    public HugeInteger add (HugeInteger ext) {
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
        return new HugeInteger(temp);
    }
    public HugeInteger subtract (HugeInteger ext) {
        // not implement yet
        HugeInteger ref1=null, ref2=null;
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
        return new HugeInteger(temp);
    }

    public HugeInteger multiply (HugeInteger ext) {
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
        return new HugeInteger(temp);
    }
    public HugeInteger mul_int (int k) {
        int maxLen = this.dataLength;
        java.util.ArrayList<Integer> temp = new java.util.ArrayList<Integer>(maxLen+2);
        for (int i=maxLen; i>=0; --i) temp.add(0);
        for (int i=0; i<maxLen; ++i) {
            temp.set(i, this.data.get(i)*k);
        }
        for (int i=0; i<maxLen; ++i) {
            temp.set(i+1, temp.get(i+1)+temp.get(i)/10);
            temp.set(i  , temp.get(i)%10 );
        }
        return new HugeInteger(temp);
    }
    public HugeInteger subHugeInteger(int from, int to) { //exclusive-to
        java.util.ArrayList<Integer> temp = new java.util.ArrayList<Integer> (this.data.subList(from, to));
        return new HugeInteger(temp);
    }
    public void append(HugeInteger ext) {
        this.data.addAll(ext.data); //append
        this.dataLength += ext.dataLength;
    }
    public HugeInteger divide (HugeInteger ext) {
        int Len=this.dataLength - ext.dataLength;
        if(Len<0) return new HugeInteger("0");
        HugeInteger m = new HugeInteger(this);
        java.util.ArrayList<Integer> res=new java.util.ArrayList<Integer>();
        for(int i=0; i<=Len; ++i) res.add(0);
        for(int i=Len; i>=0; --i) {
            for(int q=9; q>0; --q) {
                HugeInteger t1 = ext.mul_int(q);
                HugeInteger t2 = m.subHugeInteger(i, m.dataLength);
                if( t1.isLessThanOrEqualTo(t2)) {
                    t1 = t2.subtract(t1);
                    m = m.subHugeInteger(0,i);
                    m.append(t1);
                    res.set(i,q);
                    break;
                }
            }
        }
        return new HugeInteger(res);
    }
    public HugeInteger remainder (HugeInteger ext) {
        int Len=this.dataLength - ext.dataLength;
        HugeInteger m = new HugeInteger(this);
        if(Len<0) return m;
        for(int i=Len; i>=0; --i) {
            for(int q=9; q>0; --q) {
                HugeInteger t1 = ext.mul_int(q);
                HugeInteger t2 = m.subHugeInteger(i, m.dataLength);
                if( t1.isLessThanOrEqualTo(t2)) {
                    t1 = t2.subtract(t1);
                    m = m.subHugeInteger(0,i);
                    m.append(t1);
                    break;
                }
            }
        }
        return m;
    }
    // constructor:
    HugeInteger(HugeInteger target) {
        this.dataLength = target.dataLength;
        this.data = new java.util.ArrayList<Integer>( target.data);
    }
    HugeInteger(String str) {
        // not implment yet
        this.data = new java.util.ArrayList<Integer> ();
        this.parse(str);
    }
    HugeInteger(java.util.ArrayList<Integer> arr) {
        this.data = arr;
        this.dataLength = arr.size();
        this.regulate();
    }
};
