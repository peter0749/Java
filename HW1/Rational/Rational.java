class Rational {
    // private:
    private int numerator, denominator;
    // 分子，分母
    private int _GCD (int first, int second) {
        return second==0 ? first : _GCD (second, first%second);
    }
    private void Simplify () {
        int factor = this._GCD (Math.abs(numerator), Math.abs(denominator));
        if ( factor != 0) {
            this.numerator /= factor;
            this.denominator /= factor;
        }
        this.numerator = (this.numerator*this.denominator<0) ? -Math.abs(this.numerator) : Math.abs(this.numerator);
        this.denominator = Math.abs(this.denominator);
    }
    // public:
    public Rational (int num, int deno) {
        this.numerator = num;
        this.denominator = deno;
        this.Simplify();
    }
    public Rational () {
        this.numerator = 0;
        this.denominator = 1;
        this.Simplify();
    }
    public static Rational Add (Rational first, Rational second) {
        int num = first.numerator*second.denominator + first.denominator*second.numerator;
        int deno = first.denominator * second.denominator;
        return new Rational(num,deno);
    }
    public static Rational Subtract (Rational first, Rational second) {
        int num = first.numerator*second.denominator - first.denominator*second.numerator;
        int deno = first.denominator * second.denominator;
        return new Rational(num,deno);
    }
    public static Rational Multiply (Rational first, Rational second) {
        return new Rational(first.numerator*second.numerator,first.denominator*second.denominator);
    }
    public static Rational Divide (Rational first, Rational second) {
        return new Rational(first.numerator*second.denominator,first.denominator*second.numerator);
    }
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
    public String DecimalString(int n) {
        double res = (double)this.numerator / (double)this.denominator;
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        nf.setMaximumFractionDigits(n);
        return nf.format(res);
    }
};
