#include <stdio.h>

float returnInf1(){
    float y = 0;   
    asm (
        "add $0x7f800000, %0"
        : "=r" (y) 
    );
    return y;
}

float returnInf2(){
    return 0x1.0p128;
}

int main(void){
    //float y = 0;
    //asm ("add $0x7f800000, %0" : "=r" (y));  does not work on linux gcc... 
    printf("%f\n%f\n", returnInf1(), returnInf2());

    return 0;
}