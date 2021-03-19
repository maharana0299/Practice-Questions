#include<iostream>
using namespace std;

void printSomething() {
	int a ;
	cout<<"Enter a:";
	cin >> a;
	cout<<"You entered value is " + to_string(a);
}

int main() {
	cout<<"Hello World";
	printSomething();
	return 0;
}

bool isPrime_(int n){
	bool prime = true;
	for (int i =2; i*i <= n; i++){
		if (n % i == 0) {
			prime = false;
		}
	}
	
	return prime;
}

void isPrime(){
	int n;
	cin>>n;
	bool ans = isPrime_(n);

	if(ans) cout<<"prime"<<endl;
	else cout<<"not prime"<<endl;

}

void printAllPrime(int a, int b){
	for (int i =a; i <= b; i++){
		bool ans = isPrime_(i);
		if(ans) cout<<i<<endl;
	}
}

int fibonacii(int n) {
	int a = 1, b = 0;

	cout<<a<<endl;
	cout<<b<<endl;

	for (int i=2; i <= n; i++) {
		int fib = a + b;
		cout<<fib;
		a = b;
		b = fib;
	}

}



