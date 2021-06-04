#include<iostream.h>
# define pb push_back 
#define pii pair<int, int>
#define mp make_pair
# define ll long long int
 
using namespace std;
 
const int maxn = 1e5, maxm = 1e5, maxt = 1e5, maxk = 2e5;
const string newln = "\n", space = " ";
 
int main()
{   
    int t; cin >> t;
    int a, b, c, d, k;
    while(t--){
        cin >> a >> b >> c >> d >> k;
        int dist = abs(c - a) + abs(d - b);
        string ans = (k >= dist && (k - dist) % 2 == 0 ? "YeS" : "nO");
        cout << ans << endl;            
    }

    return 0;
}