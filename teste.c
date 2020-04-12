#include <stdio.h>

float returnInf(){
    float y = 0;   
    asm (
        "add $0x7f800000, %0"
        : "=r" (y) 
    );
    return y;
}

int main(void){
    float y = 0;
    asm ("add $0x7f800000, %0" : "=r" (y));   
    
    printf("%f\n", y);

    return 0;
}