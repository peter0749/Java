all: Main.class
Main.class: Rational.class
	javac Main.java
Rational.class:
	javac Rational.java
clean:
	rm -f Main.class Rational.class test.class
test: test.java
	javac test.java
	java test
