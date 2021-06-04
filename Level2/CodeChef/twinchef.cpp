#include <bits/stdc++.h>
#define ll long long
#define sz(x) ((int) (x).size())
#define all(x) (x).begin(), (x).end()
#define vi vector<int>
#define pii pair<int, int>
#define rep(i, a, b) for(int i = (a); i < (b); i++)
using namespace std;
template<typename T>
using minpq = priority_queue<T, vector<T>, greater<T>>;
 
void solve() {
    int n, k;
    cin >> n >> k;
    vector<ll> a(n);
    for(auto &x : a) cin >> x;
    sort(all(a), greater<>());
    ll A = 0, B = 0;
    rep(i, 0, 2 * k) {
        (i % 2 == 0 ? A : B) += a[i];
    }
    B += a[2 * k];
    cout << max(A, B) << '\n';
}
 
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int te;
    cin >> te;
    while(te--) solve();
    
}