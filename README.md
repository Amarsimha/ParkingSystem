Automatic CarParking System
----------------------------
Cars are placed on a 15 by 15 grid at particular co-ordinates heading north, and the simple
commands Left, right and forward are transmitted to them. The commands must be executed and
the final position calculated.

The following examples should be used to demonstrate your code:

For the input "5,5:RFLFRFLF"

We should get the position "7,7"

For the input "6,6:FFLFFLFFLFF"

We should get the position "6,6"

For the input "5,5:FLFLFFRFFF"

We should get the position "4,1"


## Requirements:
   a) Java 1.7+ (code has been tested and run against 1.8)
   
   b) Maven

## How to compile and run?
   a) $mvn clean package
   
   b) java -jar target/parkingsystem.jar

## Sample program output

$java -jar target/parkingsystem.jar

White Clark Parking System

Enter a command, Input Format should be:

X,Y:[RLF]+ OR EXIT

5,5:RFLFRFLF

7,7

6,6:FFLFFLFFLFF

6,6

5,5:FLFLFFRFFF

4,1

exit

$

