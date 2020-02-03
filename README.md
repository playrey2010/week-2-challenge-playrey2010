# Week two challenge: Arrays/arrayLists;


![](https://res.cloudinary.com/playrey/image/upload/bo_16px_solid_rgb:000000/v1580739466/Opera_Snapshot_2020-02-03_091715_coggle.it_jmyjio.png)

#### The instructions for* part one *of the challenge:

> Write a program that will allow a robot to assemble 25 burritos. Use a random generator for each burrito option and build a list of 25 burrito customizations:


> Rice: white, brown, none, all
Meat: chicken, steak, carnidas, chorizo, sofritas, veggie meat, none, all
Beans: pinto, black, none, all
Salsa: mild, medium, hot, none, all
Veggies: lettuce, fajita veggies, none, all
Cheese: yes/no
Guac: yes/no
Queso: yes/no
Sour cream: yes/noSour cream: yes/no

> Randomly generate a number of ingredients per burrito.  Save the finished burritos and display the contents.

> Calculate and display a price for each burrito. Pricing will be $3.00 plus 0.50 for each additional ingredient.

#### Pseudocode solution: 
- create an array of each ingredient group (rices, meats, beans, etc.)
- use Random class to randomly choose one ingredient per category, adding each ingredient to a String. 
- Count and keep inventory of chosen items. 
- for loop to recreate 25 burritos. 
