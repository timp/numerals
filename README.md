#Roman Numerals Challenge

To build the program (assumes you have maven installed): 

    ./build.sh

You can then use the program: 

    ./numerals iv
    4

The system will accept upper or lowercase input.

To perform the tasks: 

    $ ./tasks.sh
    Part 1
    
    MMDCDXLIV is  2944
    
    Part 2
    
    VIV is  9
    MIX is  1009
    LID is not valid because
       I may not be used as a prefix subtraction from D
    DIX is  509
    LICX is not valid because
       I may not be used as a prefix subtraction from C
    CLIX is  159
    MMDLIV is  2554
    MMXDLIV is not valid because
       X may not be used as a prefix subtraction from D
    MCMXCX is not valid because
       C may not be used as a prefix subtraction from M
    MCMXCVI is not valid because
       C may not be used as a prefix subtraction from M

 
## Controversy 
 
Roman numerals, unlike modern arabic numerals, are not a single thing. 
They existed for a long period of time and had no single interpretation. 
The example parsed in the tasks, `MMDCDXLIV`, is considered by some parsers 
to be invalid as `DCD` can be represented as `CM` and brevity normally decides 
between two representations, similarly for `VIV` which is better represented as `IX`. 
 
 
## How to Read Roman Numerals
###Know the symbols and their values.

Reading Roman numerals is pretty easy once you have the basic symbols and 
their corresponding values down pat.

    I=1
    V=5
    X=10
    L=50
    C=100
    D=500
    M=1000

There are seven basic symbols. With these seven symbols you can fashion pretty 
much any number (with the exception of exotic numbers like negatives, decimals, etc.).

### When one or more numeral is used to form a number, the value of each symbol is (generally) added together from left to right.

The letters are arranged from left to right in descending order of value to form a number:

    II = 2
    XXX (10+10+10) = 30
    LII (50+1+1) = 52
    MMLVII (1,000+1,000+50+5+1+1) = 2,057


### In some instances, a lower numeral placed in front of a larger numeral indicates that the lower numeral should be subtracted from the larger.

The subtraction rule (usually) kicks in when you’re getting close to a number that has 
a unique symbol. 
Take 4, for instance. It’s just one number away from 5, which has its own symbol (“V”). 
Instead of writing out four “I”s, you’d simply write “IV,” which indicates that 
you subtract 1 from 5 to get 4. Easy peasy.

How about 9? It’s just one digit away from 10, which has its own symbol (“X”). 
So instead of “VIIII” (5+1+1+1+1), you’d write “IX” (1 subtracted from 10).

And what about 40? It’s just 10 away from 50 which has its own symbol (“L”), 
so instead of writing out XXXX, you’d simply put XL (10 subtracted from 50). 
Just remember, when you see a lower value in front of a higher value, this rule kicks in. 
Note only 1, 10, 100 can be used in the subtraction, the use of 5, 50 or 500 is not correct.

Some more examples of the subtraction rule in action:

    29 = XXIX (10+10+(10-1))
    399 = CCCXCIX (100+100+100+(100-10)+(10-1))
    444 = CDXLIV ((500-100)+(50-10)+(5-1))

    I = 1
    IV = 4
    V =5
    IX = 9
    X = 10
    XL = 40
    L = 50
    XC = 90
    C = 100
    CD = 400
    D = 500
    CM = 900
    M = 1000
 
 
 

