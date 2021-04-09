#include<bits/stdc++.h>

class countNumberGeeks
{
private:
    /* data */
     public:
        //Function to count the number of ways in which frog can reach the top.
        int t[100000];
    long long countWayss(int n)
    {

            if(n<0)
            return 0;
            if(n==0)
            return 1;
            if(t[n]!=-1)
            return t[n];
            return t[n]= (countWayss(n-1)+countWayss(n-2)+countWayss(n-3))%1000000007;
    }

    long long countWays(int n){

    memset(t,-1,sizeof(t));
    return countWayss(n);
    }
};


